package com.systemdict32.blingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    CardView cv_1, cv_2, cv_3, cv_4, cv_5, cv_6, cv_7, cv_8, cv_9, cv_10, cv_11, cv_12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_vieww);
        toolbar = findViewById(R.id.toolbar);
        cv_1 = findViewById(R.id.cv_1);
        cv_2 = findViewById(R.id.cv_2);
        cv_3 = findViewById(R.id.cv_3);
        cv_4 = findViewById(R.id.cv_4);
        cv_5 = findViewById(R.id.cv_5);
        cv_6 = findViewById(R.id.cv_6);
        cv_7 = findViewById(R.id.cv_7);
        cv_8 = findViewById(R.id.cv_8);
        cv_9 = findViewById(R.id.cv_9);
        cv_10 = findViewById(R.id.cv_10);
        cv_11 = findViewById(R.id.cv_11);
        cv_12 = findViewById(R.id.cv_12);

        /*----------toolbar TO PREEE------*/
        setSupportActionBar(toolbar);

        /*----------navi  drawer meenuu TO PREEE------*/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        cv_1.setOnClickListener(this);
        cv_2.setOnClickListener(this);
        cv_3.setOnClickListener(this);
        cv_4.setOnClickListener(this);
        cv_5.setOnClickListener(this);
        cv_6.setOnClickListener(this);
        cv_7.setOnClickListener(this);
        cv_8.setOnClickListener(this);
        cv_9.setOnClickListener(this);
        cv_10.setOnClickListener(this);
        cv_11.setOnClickListener(this);
        cv_12.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == cv_1.getId()){
            Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        }
        if(v.getId() == cv_2.getId()){

        }
        if(v.getId() == cv_3.getId()){

        }
        if(v.getId() == cv_4.getId()){

        }
        if(v.getId() == cv_5.getId()){

        }
        if(v.getId() == cv_6.getId()){

        }
        if(v.getId() == cv_7.getId()){

        }
        if(v.getId() == cv_8.getId()){

        }
        if(v.getId() == cv_9.getId()){

        }
        if(v.getId() == cv_10.getId()){

        }
        if(v.getId() == cv_11.getId()){

        }
        if(v.getId() == cv_12.getId()){

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //switch to pre
        switch (item.getItemId()){

            case R.id.nav_home:
                break;

            case R.id.nav_about:
//                Intent intent = new Intent(MainActivity.this, aboutUs.class);
//                startActivity(intent);
                break;

            case R.id.nav_exitt:
                finish();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}