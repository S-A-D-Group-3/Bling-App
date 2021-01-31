package com.systemdict32.blingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class splashscreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    //variable ko for  animation
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView introwan, introtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        //animate
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bot_animation);

        //hooks
        image= findViewById(R.id.kit);
        introwan = findViewById(R.id.textView2);
        introtwo = findViewById(R.id.textView3);

        image.setAnimation(topAnim);
        introwan.setAnimation(bottomAnim);
        introtwo.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override

            public void run(){
                Intent intent = new Intent(splashscreen.this, MainActivity.class);
                startActivity(intent);
                finish();



            }
        }, SPLASH_SCREEN);


    }
}