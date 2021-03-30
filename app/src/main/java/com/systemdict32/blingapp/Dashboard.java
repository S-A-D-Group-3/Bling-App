package com.systemdict32.blingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    Button btn_goto_emergency_basic,
            btn_goto_emergency_response,
            btn_goto_in_home_emergency,
            btn_goto_out_door_incidents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn_goto_emergency_basic = findViewById(R.id.btn_goto_emergency_basic);
        btn_goto_emergency_response = findViewById(R.id.btn_goto_emergency_response);
        btn_goto_in_home_emergency = findViewById(R.id.btn_goto_in_home_incidents);
        btn_goto_out_door_incidents = findViewById(R.id.btn_goto_out_door_incidents);

        btn_goto_emergency_basic.setOnClickListener(this);
        btn_goto_emergency_response.setOnClickListener(this);
        btn_goto_in_home_emergency.setOnClickListener(this);
        btn_goto_out_door_incidents.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btn_goto_emergency_basic.getId())
        {
            Intent intent = new Intent(Dashboard.this, EmergencyBasic.class);
            startActivity(intent);
        }
        if(v.getId() == btn_goto_emergency_response.getId())
        {
            Intent intent = new Intent(Dashboard.this, EmergencyResponse.class);
            startActivity(intent);
        }
        if(v.getId() == btn_goto_in_home_emergency.getId())
        {
            Intent intent = new Intent(Dashboard.this, InHomeIncidents.class);
            startActivity(intent);
        }
        if(v.getId() == btn_goto_out_door_incidents.getId())
        {
            Intent intent = new Intent(Dashboard.this, OutDoorIncidents.class);
            startActivity(intent);
        }
    }
}