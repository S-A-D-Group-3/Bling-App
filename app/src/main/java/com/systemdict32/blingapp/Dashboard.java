package com.systemdict32.blingapp;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.systemdict32.blingapp.Fragments.AboutFragment;
import com.systemdict32.blingapp.Fragments.HelpFragment;
import com.systemdict32.blingapp.Fragments.HomeFragment;
import com.systemdict32.blingapp.Fragments.MyAccountFragment;
import com.systemdict32.blingapp.Fragments.MyICEFragment;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentManager fm;
    HomeFragment homeFragment;
    FirebaseFirestore fStore;
    FirebaseAuth firebaseAuth;
    String fullName, email, address, bloodType, contactPerson, contactPersonNum, medCondition, medTake, userId;
    TextView tv_user_name;
    BottomNavigationView top_nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View home = inflater.inflate(R.layout.fragment_home, null);
        homeFragment = new HomeFragment();
        fm = getSupportFragmentManager();

        fm.beginTransaction().add(R.id.dashboard_fragment_container, homeFragment).addToBackStack("nav_home").commit();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_vieww);
        toolbar = findViewById(R.id.toolbar);
        top_nav_view = (BottomNavigationView) home.findViewById(R.id.top_nav_view);

        View header = navigationView.getHeaderView(0);

        top_nav_view.setSelectedItemId(R.id.nav_emergency);

        tv_user_name = header.findViewById(R.id.tv_user_name);

        /*----------toolbar TO PREEE------*/
        setSupportActionBar(toolbar);

        /*----------navi  drawer meenuu TO PREEE------*/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        // get data from firebase
        firebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = firebaseAuth.getCurrentUser().getUid();

        fStore.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if (document.getId().equals(userId)) {
                            fullName = document.getString("user_FN");
                            email = document.getString("user_Email");
                            address = document.getString("user_ICE_ADDRESS");
                            bloodType = document.getString("user_ICE_BLOODTYPE");
                            contactPerson = document.getString("user_ICE_CONTACTPERSON");
                            contactPersonNum = document.getString("user_ICE_CONTACTPERSON_NUMBER");
                            medCondition = document.getString("user_ICE_MEDICALCONDITION");
                            medTake = document.getString("user_ICE_MEDICINETAKE");
                            // set username on nav view
                            tv_user_name.setText(fullName);
                        }
                    }
                } else {

                }
            }
        });

        SharedPreferences preferences = getSharedPreferences("App", Context.MODE_PRIVATE);

        // Get value from shared preferences,
        // if null (app is run first time) the default value (second argument) is returned
        boolean isFIrstRun = preferences.getBoolean("isFirstRun", true);

        if (isFIrstRun) {
            // set isFirstRun to false
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            Toasty.info(Dashboard.this, "Okay",
                                    Toast.LENGTH_LONG, true).show();
                            return;

                        case DialogInterface.BUTTON_NEGATIVE:
                            preferences.edit().putBoolean("isFirstRun", false).apply();
                            Intent intent = new Intent(Dashboard.this, Login.class);
                            startActivity(intent);
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
            builder.create();
            builder.setCancelable(false);
            builder.setMessage("User Check, Have you Logged-in?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // get home fragment
        Fragment selectedFragment = null;
        String backstackName = null;
        switch (item.getItemId()) {
            case R.id.nav_home:
                selectedFragment = new HomeFragment();
                backstackName = "nav_home";
                break;
            case R.id.nav_account:
                selectedFragment = new MyAccountFragment();
                backstackName = "nav_account";
                break;

            case R.id.nav_ice:
                selectedFragment = new MyICEFragment();
                backstackName = "nav_ice";
                break;

            case R.id.nav_help:
                selectedFragment = new HelpFragment();
                backstackName = "nav_help";
                break;

            case R.id.nav_about:
                selectedFragment = new AboutFragment();
                backstackName = "nav_about";
                break;

            case R.id.nav_exitt:
                SharedPreferences preferences = getSharedPreferences("App", Context.MODE_PRIVATE);
                preferences.edit().putBoolean("isFirstRun", true).apply();
                Intent intentExit = new Intent(Dashboard.this, Login.class);
                startActivity(intentExit);
                System.exit(0);
                firebaseAuth.getInstance().signOut();
                break;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_fragment_container, selectedFragment);
        ft.addToBackStack(backstackName);
        ft.commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    private static final String CHANNEL_ID = "notif";
    NotificationCompat.Builder builder;

    public void showNotification() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("Name: " + fullName + "\n");
        buffer.append("Address: " + address + "\n");
        buffer.append("Medical Condition: " + medCondition + "\n");
        buffer.append("Medicine Take: " + medTake + "\n");
        buffer.append("Blood Type: " + bloodType +"\n");
        buffer.append("ICE Name: " + contactPerson + "\n");
        buffer.append("ICE Name #: " + contactPersonNum + "\n");
//        buffer.append("ICE Number: " +  +"N/A");

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "notification";
            String description = "user notification";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(this, Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logov2)
                .setContentTitle("In-case of Emergency")
                .setContentText("User Information")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(buffer.toString()))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true).setOngoing(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
//            builder.setVisibility(Notification.VISIBILITY_SECRET);
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, builder.build());

    }

    @Override
    protected void onPause() {
        super.onPause();
        showNotification();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showNotification();
    }

    @Override
    public void onBackPressed() {
        // working pero may bugs pa
        // --update-- working na, pwera dun na lang sa paglipat between nearby emergency at instruction
        int stackCount = getSupportFragmentManager().getBackStackEntryCount();

        if (stackCount < 2) {
            System.exit(0);
        } else {
            getSupportFragmentManager().popBackStack();
            FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(stackCount - 2);
            highlightNavViewOnBackPressed(backStackEntry.getName());
        }
    }

    public void highlightNavViewOnBackPressed(String backStackName) {
        // not working lods
//        if(backStackName.equals("nav_emergency")){
//            top_nav_view.setSelectedItemId(R.id.nav_emergency);
//            navigationView.setCheckedItem(R.id.nav_home);
//
//            Toast.makeText(this, "" + String.valueOf(top_nav_view.getMenu().getItem(0).isChecked()), Toast.LENGTH_SHORT).show();
//        }
//
//        if(backStackName.equals("nav_instruction") || backStackName.equals("nav_home")){
//            top_nav_view.setSelectedItemId(R.id.top_nav_view);
//            navigationView.setCheckedItem(R.id.nav_home);
//        }

        if (backStackName.equals("nav_home")) {
            navigationView.setCheckedItem(R.id.nav_home);

        }

        if (backStackName.equals("nav_account")) {
            navigationView.setCheckedItem(R.id.nav_account);
        }

        if (backStackName.equals("nav_ice")) {
            navigationView.setCheckedItem(R.id.nav_ice);
        }

        if (backStackName.equals("nav_help")) {
            navigationView.setCheckedItem(R.id.nav_help);
        }

        if (backStackName.equals("nav_about")) {
            navigationView.setCheckedItem(R.id.nav_about);
        }


    }
}
