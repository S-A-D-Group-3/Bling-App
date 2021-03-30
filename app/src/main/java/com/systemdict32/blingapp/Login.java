package com.systemdict32.blingapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button callSignUp, loginUser;
    ImageView image;
    TextView logoText, SloganText;
    TextInputLayout username, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        /*Hooks*/
        username = findViewById(R.id.user_name);
        password = findViewById(R.id.pass_word);
        callSignUp = findViewById(R.id.signup_screen);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_name);
        SloganText = findViewById(R.id.slogan_name);
        loginUser = findViewById(R.id.loginbutton);


    }

    private boolean validateUserName(){
        String val = username.getEditText().getText().toString();

        if(val.isEmpty()){
            username.setError("This part must be filled up");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword(){
        String val = password.getEditText().getText().toString();

        if(val.isEmpty()){
            password.setError("This part must be filled up");
            return false;
        }
        else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }




    public void loginUser (View view) {
        if(!validateUserName() | !validatePassword()) {
            return;
        } else {
            isUser();
        }
    }


    public interface MyCallback {
        void onCallback(String value);
    }


        private void isUser () {
            String EnteredUsername = username.getEditText().getText().toString().trim();
            String EnteredPassword = password.getEditText().getText().toString().trim();


            DatabaseReference database = FirebaseDatabase.getInstance("https://bling-230eb-default-rtdb.firebaseio.com/").getReference("users");
            Query checkUser = database.orderByChild("username").equalTo(EnteredUsername);
            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    if (dataSnapshot.exists()) {
                        username.setError(null);
                        username.setErrorEnabled(false);

                        String passwordFromDB = dataSnapshot.child(EnteredUsername).child("password").getValue(String.class);

                        if (passwordFromDB != null && passwordFromDB.equals(EnteredPassword)) {
                            username.setError(null);
                            username.setErrorEnabled(false);
                            Intent i;
                            i = new Intent(Login.this, Profile.class);
                            startActivity(i);
                        } else {
                            password.setError("Wrong password");
                            password.requestFocus();
                        }
                    } else {
                        username.setError("User doesn't exist");
                        username.requestFocus();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }



    //signup onclick
    public void callSignUp(View view) {



        Intent intent = new Intent(Login.this, SignUp.class);
        startActivity(intent);

        Pair[] pairs = new Pair[7];
        pairs[0] = new Pair<View, String>(image, "logo_image");
        pairs[1] = new Pair<View, String>(logoText, "logo_text");
        pairs[2] = new Pair<View, String>(SloganText, "logo_desc");
        pairs[3] = new Pair<View, String>(username, "username_tran");
        pairs[4] = new Pair<View, String>(password, "password_image");
        pairs[5] = new Pair<View, String>(loginUser, "button_tran");
        pairs[6] = new Pair<View, String>(callSignUp, "login_signup_tran");


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