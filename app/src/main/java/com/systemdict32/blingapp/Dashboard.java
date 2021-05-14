package com.systemdict32.blingapp;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
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
import com.systemdict32.blingapp.Fragments.JsonParserLGU;
import com.systemdict32.blingapp.Fragments.LGUFragment;
import com.systemdict32.blingapp.Fragments.MyAccountFragment;
import com.systemdict32.blingapp.Fragments.MyICEFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
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
    View chatbot_fragment;
    BottomNavigationView top_nav_view;
    private FirebaseAuth mFireAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mFireAuth = FirebaseAuth.getInstance();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View home = inflater.inflate(R.layout.fragment_home, null);
        homeFragment = new HomeFragment();
        fm = getSupportFragmentManager();

        fm.beginTransaction().add(R.id.dashboard_fragment_container, homeFragment).addToBackStack("nav_home").commit();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_vieww);
        toolbar = findViewById(R.id.toolbar);
        top_nav_view = (BottomNavigationView) home.findViewById(R.id.top_nav_view);
        chatbot_fragment = findViewById(R.id.chatbot_fragment);

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
        if (firebaseAuth.getCurrentUser() != null) {
            userId = firebaseAuth.getCurrentUser().getUid();
        } else {
            Intent intent = new Intent(Dashboard.this, Login.class);
            startActivity(intent);
            return;
        }


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
    }

    @Override
    protected void onStart() {
        super.onStart();
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
            FirebaseUser mFireUser = mFireAuth.getCurrentUser();
            if (mFireUser != null) {

                // eto onse yung di na need ng sharedpref//
                // Toasty.info(Dashboard.this, "Login verified"
                //                   , Toast.LENGTH_LONG, true).show();
            } else {
                Toasty.warning(Dashboard.this, "Oops, you must login first!"
                        , Toast.LENGTH_LONG, true).show();
                Intent intentCheck = new Intent(getApplicationContext(), Login.class);
                intentCheck.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentCheck);
                finish();
            }
        } else {
            connected = false;
            Toasty.info(this, "You are on offline mode!", Toast.LENGTH_LONG).show();
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
                chatbot_fragment.setVisibility(View.VISIBLE);
                break;
            case R.id.nav_account:
                selectedFragment = new MyAccountFragment();
                backstackName = "nav_account";
                chatbot_fragment.setVisibility(View.GONE);
                break;

            case R.id.nav_ice:
                selectedFragment = new MyICEFragment();
                backstackName = "nav_ice";
                chatbot_fragment.setVisibility(View.GONE);
                break;

            case R.id.nav_help:
                selectedFragment = new HelpFragment();
                backstackName = "nav_help";
                chatbot_fragment.setVisibility(View.GONE);
                break;

            case R.id.nav_about:
                selectedFragment = new AboutFragment();
                backstackName = "nav_about";
                chatbot_fragment.setVisibility(View.GONE);
                break;

            case R.id.nav_exitt:
                firebaseAuth.getInstance().signOut();
                mFireAuth.signOut();
//                hideNotification(this);
                Intent intentExit = new Intent(getApplicationContext(), Login.class);
                intentExit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentExit);
                System.exit(0);


        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_fragment_container, selectedFragment);
        ft.addToBackStack(backstackName);
        ft.commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MyICEFragment myICEFragment = new MyICEFragment();
//        if (bloodType != null && address != null && contactPersonNum != null && contactPerson != null && medTake != null && medCondition != null) {
//            myICEFragment.showNotification(fullName, address, medCondition, medTake, bloodType, contactPerson, contactPersonNum);
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    boolean isExit = false;

    @Override
    public void onBackPressed() {
        // working pero may bugs pa
        // --update-- working na, pwera dun na lang sa paglipat between nearby emergency at instruction
        int stackCount = getSupportFragmentManager().getBackStackEntryCount();
//        Toast.makeText(this, String.valueOf(getSupportFragmentManager().getBackStackEntryAt(stackCount - 2)), Toast.LENGTH_SHORT).show();
        if (stackCount < 2) {
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);

            if (isExit) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
            isExit = true;

        } else {
            getSupportFragmentManager().popBackStack();
            FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(stackCount - 2);
            highlightNavViewOnBackPressed(backStackEntry.getName());
        }
    }

    public void highlightNavViewOnBackPressed(String backStackName) {
        // not working lods
//        if (backStackName.equals("nav_emergency") || backStackName.equals("emergency_services")) {
//            top_nav_view.setSelectedItemId(R.id.nav_emergency);
//            navigationView.setCheckedItem(R.id.nav_home);
//
//        }
//
//        if (backStackName.equals("nav_instruction") || backStackName.equals("instruction_category") || backStackName.equals("instruction_sub_category")) {
//            top_nav_view.setSelectedItemId(R.id.top_nav_view);
//            navigationView.setCheckedItem(R.id.nav_home);
//        }

        if (backStackName.equals("nav_home") && backStackName != null) {
            navigationView.setCheckedItem(R.id.nav_home);

        }

        if (backStackName.equals("nav_account") && backStackName != null) {
            navigationView.setCheckedItem(R.id.nav_account);
        }

        if (backStackName.equals("nav_ice") && backStackName != null) {
            navigationView.setCheckedItem(R.id.nav_ice);
        }

        if (backStackName.equals("nav_help") && backStackName != null) {
            navigationView.setCheckedItem(R.id.nav_help);
        }

        if (backStackName.equals("nav_about") && backStackName != null) {
            navigationView.setCheckedItem(R.id.nav_about);
        }


    }


}
