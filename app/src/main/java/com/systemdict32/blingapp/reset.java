package com.systemdict32.blingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import es.dmoral.toasty.Toasty;

public class reset extends AppCompatActivity {

    ProgressBar progressBar;
    EditText inputEmail;
    Button btnReset, btnBack;

    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        inputEmail = (EditText) findViewById(R.id.email);

        btnReset = (Button) findViewById(R.id.btn_reset_password);

        btnBack = (Button) findViewById(R.id.btn_back);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        firebaseAuth = FirebaseAuth.getInstance();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                if (inputEmail.getText().toString().toString().isEmpty()) {
                    //Toasty.Config.getInstance().setTextSize(29).apply();// for resizing toasty lang e2
                    progressBar.setVisibility(View.GONE);
                    Toasty.warning(reset.this,
                            "It is Empty", Toast.LENGTH_LONG, true).show();

                }else{
                    progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.sendPasswordResetEmail(inputEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toasty.success(reset.this,
                                            "Password reset link sent to your email", Toast.LENGTH_LONG, true).show();
                                } else {
                                    Toasty.warning(reset.this,
                                            task.getException().getMessage(), Toast.LENGTH_LONG,true).show();
                                }
                            }
                        });
            }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("App", Context.MODE_PRIVATE);
                preferences.edit().putBoolean("isFirstRun", true).apply();
                Intent intentback = new Intent(reset.this, Login.class);
                startActivity(intentback);

            }
        });
    }
}








/**
public class reset extends AppCompatActivity {

    private EditText inputEmail;

    private Button btnReset, btnBack;


   private  FirebaseAuth auth;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reset_password);

        inputEmail = (EditText) findViewById(R.id.email);

        btnReset = (Button) findViewById(R.id.btn_reset_password);

        btnBack = (Button) findViewById(R.id.btn_back);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(reset.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Semail = "2.dahrencamacho@gmail.com";

                if (TextUtils.isEmpty(Semail)) {
                    Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                FirebaseAuth.getInstance().sendPasswordResetEmail(Semail)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(reset.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(reset.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                }

                                progressBar.setVisibility(View.GONE);
                            }
                        });
            }
        });
    }

}

**/


