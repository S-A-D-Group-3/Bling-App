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

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.systemdict32.blingapp.BlingChatbot.BlingChatbot;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignUp extends AppCompatActivity {

    //Variables natin
    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button goBack, regBtn, regToLoginBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    MessageDigest md;
    BlingChatbot blingChatbot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        blingChatbot = new BlingChatbot();
        //hooks to signup.xml
        regName = findViewById(R.id.reg_fullname);
        regUsername = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPhoneNo = findViewById(R.id.reg_phoneNo);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.reg_btn);
        regToLoginBtn = findViewById(R.id.goback);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance("https://bling-230eb-default-rtdb.firebaseio.com/");
                reference = rootNode.getReference("users");

                //validation
                if (!validateName() | !validateUserName() | !validateEmail() | !validatePhone() | !validatePassword()) {
                    return;
                }

                //get values
                String name = regName.getEditText().getText().toString();
                String username = regUsername.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String phoneNo = regPhoneNo.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();

                // hash password
//                String hashedPassword = blingChatbot.HashPassword(password);

                UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);

                reference.child(name).setValue(helperClass);

                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);

            }


        });//register button method end

        regToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);

            }
        });


    }//onCreate method end


    private boolean validateName() {
        String val = regName.getEditText().getText().toString();

        if (val.isEmpty()) {
            regName.setError("This part must be filled up");
            return false;
        } else {
            regName.setError(null);
            regName.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateUserName() {
        String val = regUsername.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";
        if (val.isEmpty()) {
            regUsername.setError("This part must be filled up");
            return false;
        } else if (val.length() >= 15) {
            regUsername.setError("Username too long");
            return false;

        } else if (!val.matches(noWhiteSpace)) {
            regUsername.setError("Please don't leave spaces");
            return false;

        } else {
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            regEmail.setError("This part must be filled up");
            return false;
        } else if (!val.matches(emailPattern)) {
            regEmail.setError("Invalid Email");
            return false;

        } else {
            regEmail.setError(null);
            return true;
        }
    }

    private boolean validatePhone() {
        String val = regPhoneNo.getEditText().getText().toString();
        if (val.isEmpty()) {
            regPhoneNo.setError("This part must be filled up");
            return false;
        } else {
            regPhoneNo.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = regPassword.getEditText().getText().toString();
        String passVal = "^" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                ".{4,}" + "$";

        if (val.isEmpty()) {
            regPassword.setError("This part must be filled up");
            return false;
        } else if (!val.matches(passVal)) {
            regPassword.setError("Password combination is weak");
            return false;
        } else {
            regPassword.setError(null);
            return true;
        }
    }


}