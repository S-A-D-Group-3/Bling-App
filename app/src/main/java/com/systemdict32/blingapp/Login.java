package com.systemdict32.blingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    Button callSignUp, login_btn;
    ImageView image;
    TextView logoText, SloganText;
    TextInputLayout username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        /*Hooks*/
        callSignUp = findViewById(R.id.signup_screen);
        image = findViewById(R.id.logo_image);
       logoText = findViewById(R.id.logo_name);
        SloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_btn =findViewById(R.id.login_btn);


                 callSignUp.setOnClickListener((View) -> {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);

            Pair[] pairs = new Pair[7];
                     pairs[0] = new Pair<View, String>(image, "logo_image");
                     pairs[1] = new Pair<View, String>(logoText, "logo_text");
                     pairs[2] = new Pair<View, String>(SloganText, "logo_desc");
                     pairs[3] = new Pair<View, String>(username, "username_tran");
                     pairs[4] = new Pair<View, String>(password, "password_image");
                     pairs[5] = new Pair<View, String>(login_btn, "button_tran");
                     pairs[6] = new Pair<View, String>(callSignUp, "login_signup_tran");

                     ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                     startActivity(intent, options.toBundle());


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