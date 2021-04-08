package com.systemdict32.blingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;


public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences("App", Context.MODE_PRIVATE);

        // Get value from shared preferences,
        // if null (app is run first time) the default value (second argument) is returned
        boolean isFIrstRun = preferences.getBoolean("isFirstRun", true);


        if (isFIrstRun) {
            // set isFirstRun to false
            preferences.edit().putBoolean("isFirstRun", false).apply();

            Intent intent = new Intent(LauncherActivity.this, splashscreen.class);
            startActivity(intent);

        } else {

            //For Use of Login Checking, NOT USED.



           /**  SharedPreferences preferences1 = getSharedPreferences("prefs", Context.MODE_PRIVATE);

            // Get value from shared preferences,
            // if null (app is run first time) the default value (second argument) is returned
            boolean isChecked = preferences1.getBoolean("isChecked", true);


            AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("Security Check");
                builder.setIcon(R.drawable.logov2);
                builder.setMessage("Double Checking User Activity, Did you recently log-in?");


                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        if (isChecked) {
                            preferences1.edit().putBoolean("isChecking", false).apply();
                            Intent intent = new Intent(LauncherActivity.this, Dashboard.class);
                            startActivity(intent);
                            dialog.dismiss();
                        }
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(LauncherActivity.this, Login.class);
                        startActivity(intent);
                        dialog.dismiss();

                    }
                });

                AlertDialog alert = builder.create();
                alert.setCanceledOnTouchOutside(false);
                alert.setCancelable(false);
                alert.show();
            SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("isChecked", false);
            editor.apply();
            }**/

            Intent intent = new Intent(LauncherActivity.this, Dashboard.class);
            startActivity(intent);
        }
    }
}
