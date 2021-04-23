package com.systemdict32.blingapp;

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

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

public class Dashboard extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentManager fm;
    HomeFragment homeFragment;
    FirebaseFirestore fStore;
    FirebaseAuth firebaseAuth;
    String fullName, email, userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        homeFragment = new HomeFragment();
        fm = getSupportFragmentManager();

        fm.beginTransaction().add(R.id.dashboard_fragment_container, homeFragment).commit();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_vieww);
        toolbar = findViewById(R.id.toolbar);

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
                        if(document.getId().equals(userId)) {
                            fullName = document.getString("user_FN");
                            email = document.getString("user_Email");
                        }
                    }
                } else {

                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //switch to pre
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.nav_home:
                selectedFragment = new HomeFragment();
                break;
            case R.id.nav_account:
                selectedFragment = new MyAccountFragment();
                break;

            case R.id.nav_ice:
                selectedFragment = new MyICEFragment();
                break;

            case R.id.nav_help:
                selectedFragment = new HelpFragment();
                break;

            case R.id.nav_about:
                selectedFragment = new AboutFragment();
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

        getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_fragment_container, selectedFragment).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    private static final String CHANNEL_ID = "notif";
    NotificationCompat.Builder builder;

    public void showNotification(){
        StringBuffer buffer = new StringBuffer();

        buffer.append("Name: " + fullName + "\n");
        buffer.append("Email: " + email + "\n");
        buffer.append("Address: " + "N/A\n");
        buffer.append("Blood Type: " + "N/A+\n");
        buffer.append("ICE Name: " + "N/A\n");
        buffer.append("ICE Number: " + "N/A");

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
}