package com.systemdict32.blingapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import es.dmoral.toasty.Toasty;

public class Login extends AppCompatActivity {

    Button callSignUp, loginUser, passForget;
    ImageView image;
    TextView logoText, SloganText;
    TextInputLayout eml, pass;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        /*Hooks*/
        eml = findViewById(R.id.maill);
        pass = findViewById(R.id.pass_word);
        callSignUp = findViewById(R.id.signup_screen);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_name);
        SloganText = findViewById(R.id.slogan_name);
        loginUser = findViewById(R.id.loginbutton);
        progressBar = findViewById(R.id.progressBar);
       passForget = findViewById(R.id.forget_pass);


        firebaseAuth = FirebaseAuth.getInstance();

        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email_ = eml.getEditText().getText().toString().trim();
                String pass_ = pass.getEditText().getText().toString().trim();

                if ((email_.isEmpty() && pass_.isEmpty() || email_.isEmpty() || pass_.isEmpty())) {
                    Toasty.error(Login.this, "Please fill up the field(s)",
                            Toast.LENGTH_LONG, true).show();
                    progressBar.setVisibility(View.GONE);
                }else{
                    progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(email_, pass_)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    if (firebaseAuth.getCurrentUser().isEmailVerified()) {
                                        startActivity(new Intent(Login.this, Dashboard.class));
                                    } else {
                                        Toasty.info(Login.this, "Please verify it on your email address"
                                                , Toast.LENGTH_LONG, true).show();
                                    }
                                } else {
                                    Toasty.warning(Login.this, task.getException().getMessage()
                                            , Toast.LENGTH_LONG, true).show();
                                }
                            }
                        });

            }
            }
        });



    }





    public void callSignUp (View view){


        Intent intent = new Intent(Login.this, SignUp.class);
        startActivity(intent);

        Pair[] pairs = new Pair[7];
        pairs[0] = new Pair<View, String>(image, "logo_image");
        pairs[1] = new Pair<View, String>(logoText, "logo_text");
        pairs[2] = new Pair<View, String>(SloganText, "logo_desc");
        pairs[3] = new Pair<View, String>(eml, "username_tran");
        pairs[4] = new Pair<View, String>(pass, "password_image");
        pairs[5] = new Pair<View, String>(loginUser, "button_tran");
        pairs[6] = new Pair<View, String>(callSignUp, "login_signup_tran");


    }

        private boolean doubleBackToExitPressedOnce = true;
        @Override
        public void onBackPressed () {
            if (doubleBackToExitPressedOnce) {
                this.doubleBackToExitPressedOnce = false;
                Toasty.info(this, "Press again to close Bling", Toast.LENGTH_SHORT, true).show();


            } else if (doubleBackToExitPressedOnce) {
                this.doubleBackToExitPressedOnce = true;
                finishAffinity();


            } else {
                finishAffinity();

            }

        }

    public void passForget(View view) {

        Intent intent = new Intent(Login.this,reset.class);
        startActivity(intent);
    }
}






