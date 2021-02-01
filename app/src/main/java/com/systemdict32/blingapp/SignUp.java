package com.systemdict32.blingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    Button goBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        goBack = findViewById(R.id.go_back);
        goBack.setOnClickListener((View) -> {
            Intent intent = new Intent(SignUp.this, Login.class);
            startActivity(intent);

        });

    }




    private boolean doubleBackToExitPressedOnce = true;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = false;
            Toast.makeText(this, "Press again to close Bling", Toast.LENGTH_SHORT).show();


        }

        else if (doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            finishAffinity();


        }

        else{
            finishAffinity();

        }

    }

}