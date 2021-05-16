package com.systemdict32.blingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import es.dmoral.toasty.Toasty;

public class SignUp extends AppCompatActivity {

    public static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 4 characters
                    "$");

    private static final String TAG = SignUp.class.getSimpleName();
    //Variables natin
    TextInputLayout regEmail, regPassword, regFname;
    Button goBack, regBtn, regToLoginBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    FirebaseFirestore fStore;
    String userID;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        //hooks to signup.xml




        regEmail = findViewById(R.id.reg_email);
        regPassword = findViewById(R.id.reg_password);
        regFname = findViewById(R.id.reg_fname);
        regBtn = findViewById(R.id.reg_btn);
        regToLoginBtn = findViewById(R.id.goback);
        progressBar = findViewById(R.id.progressBar);
        firebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();



        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String sEmail = regEmail.getEditText().getText().toString().trim();
                String sPass = regPassword.getEditText().getText().toString().trim();
                String sFname = regFname.getEditText().getText().toString().trim();

                if (sEmail.isEmpty() && sPass.isEmpty()  && sFname.isEmpty()|| sEmail.isEmpty() || sFname.isEmpty() || sPass.isEmpty()) {
                   regEmail.setError("This field is empty");
                   regFname.setError("This field is empty");
                   regPassword.setError("This field is empty");
                    Toasty.error(SignUp.this, "Please fill up the field(s)",
                            Toast.LENGTH_LONG, true).show();
                    progressBar.setVisibility(View.GONE);
                }
                else if (!PASSWORD_PATTERN.matcher(sPass).matches()) {
                    regEmail.setError(null);
                    regFname.setError(null);
                    regPassword.setError("Password combination is weak");
                    Toasty.info(SignUp.this, "Password must contain 8 minimum characters that include: [a Capital letter, a Number and a Special character]",
                            Toast.LENGTH_LONG, true).show();
                            progressBar.setVisibility(View.GONE);
                }

                else {

                    regEmail.setError(null);
                    regFname.setError(null);
                    regPassword.setError(null);



                    progressBar.setVisibility(View.VISIBLE);
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
                                                        if (task.isSuccessful()) {
                                                            Toasty.success(SignUp.this, "Registered successfully. Please check your email for verification",
                                                                    Toast.LENGTH_LONG, true).show();
                                                            userID = firebaseAuth.getCurrentUser().getUid();
                                                            DocumentReference documentReference = fStore.collection("users").document(userID);
                                                            Map<String, Object> user = new HashMap<>();
                                                            user.put("user_FN", sFname);
                                                            user.put("user_Email", sEmail);
                                                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                @Override
                                                                public void onSuccess(Void aVoid) {
                                                                    Log.d(TAG, "SUCCESS ON REGISTRATION FOR : " + userID);

                                                                }
                                                            }).addOnFailureListener(new OnFailureListener() {
                                                                @Override
                                                                public void onFailure(@NonNull Exception e) {
                                                                    Log.d(TAG, "failed : " + e.toString());
                                                                }
                                                            });
                                                            regEmail.getEditText().setText("");
                                                            regPassword.getEditText().setText("");
                                                            regFname.getEditText().setText("");
                                                            startActivity(new Intent(SignUp.this, Login.class));


                                                        } else {
                                                            Toasty.warning(SignUp.this, task.getException().getMessage(),
                                                                    Toast.LENGTH_LONG, true).show();
                                                        }

                                                    }
                                                });
                                    } else {
                                        Toasty.error(SignUp.this, task.getException().getMessage(),
                                                Toast.LENGTH_LONG, true).show();
                                    }
                                }
                            });
                }
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