package com.systemdict32.blingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    //Variables natin
    TextInputLayout  regEmail, regPassword;
    Button goBack, regBtn, regToLoginBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        //hooks to signup.xml

        regEmail = findViewById(R.id.reg_email);
        regPassword = findViewById(R.id.reg_password);
        regBtn =  findViewById(R.id.reg_btn);
        regToLoginBtn =  findViewById(R.id.goback);
        progressBar = findViewById(R.id.progressBar);
        firebaseAuth = FirebaseAuth.getInstance();

        regBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String sEmail = regEmail.getEditText().getText().toString().trim();
                String sPass = regPassword.getEditText().getText().toString().trim();
                firebaseAuth.createUserWithEmailAndPassword(sEmail, sPass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    firebaseAuth.getCurrentUser().sendEmailVerification()
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if(task.isSuccessful()){
                                                        Toast.makeText(SignUp.this, "Registered successfully. Please check your email for verification",
                                                                Toast.LENGTH_LONG).show();
                                                        regEmail.getEditText().setText("");
                                                        regPassword.getEditText().setText("");
                                                        startActivity(new Intent(SignUp.this, Login.class));
                                                    }else{
                                                        Toast.makeText(SignUp.this,  task.getException().getMessage(),
                                                                Toast.LENGTH_LONG).show();
                                                    }

                                                }
                                            });
                                } else {
                                    Toast.makeText(SignUp.this, task.getException().getMessage(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
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





   /** private boolean validateEmail(){
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            regEmail.setError("This part must be filled up");
            return false;
        }else if(!val.matches(emailPattern)){
            regEmail.setError("Invalid Email");
            return false;

        }
        else{
            regEmail.setError(null);
            return true;
        }
    }
    **/


   /** private boolean validatePassword(){
        String val = regPassword.getEditText().getText().toString();
        String passVal = "^"+
                "(?=.*[a-zA-Z])"+
                "(?=.*[@#$%^&+=])"+
                ".{4,}"+"$";

        if(val.isEmpty()){
            regPassword.setError("This part must be filled up");
            return false;
        }else if (!val.matches(passVal)){
            regPassword.setError("Password combination is weak");
            return false;
        }
        else{
            regPassword.setError(null);
            return true;
        }
    }
    **/


}