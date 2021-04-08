package com.systemdict32.blingapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class logChecker extends AppCompatActivity {

// THIS CLASS CAN BE USED FOR LOGIN CHECKING, BUT NOW IT ISN'T USED


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        SharedPreferences preferences = getSharedPreferences("App", Context.MODE_PRIVATE);

        // Get value from shared preferences,
        // if null (app is run first time) the default value (second argument) is returned
        boolean isChecked = preferences.getBoolean("isChecked", true);


        if (isChecked) {
            // set isFirstRun to false
            preferences.edit().putBoolean("isChecked", false).apply();

            checker();


        }

        else{
            Intent intent = new Intent(logChecker.this, Dashboard.class);
            startActivity(intent);

        }

    }

    private void checker() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Security Check");
            builder.setIcon(R.drawable.logov2);
            builder.setMessage("Double Checking User Activity, Did you recently log-in?");


            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    Intent intent = new Intent(logChecker.this, Dashboard.class);
                    startActivity(intent);
                    dialog.dismiss();
                }
            });

            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(logChecker.this, Login.class);
                    startActivity(intent);
                    dialog.dismiss();

                }
            });

            AlertDialog alert = builder.create();
            alert.setCanceledOnTouchOutside(false);
            alert.setCancelable(false);
            alert.show();

        }

    }

