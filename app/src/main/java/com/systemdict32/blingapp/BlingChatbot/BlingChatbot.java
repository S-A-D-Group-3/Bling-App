package com.systemdict32.blingapp.BlingChatbot;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.systemdict32.blingapp.Fragments.Categories.c3_BodyInjuriesFragment;
import com.systemdict32.blingapp.Fragments.HomeFragment;
import com.systemdict32.blingapp.Fragments.MyAccountFragment;
import com.systemdict32.blingapp.Fragments.MyICEFragment;
import com.systemdict32.blingapp.Fragments.ReadFirstAidFragment;
import com.systemdict32.blingapp.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;

public class BlingChatbot {
    final Handler handler = new Handler();
    FragmentActivity fa = new FragmentActivity();

    public BlingChatbot() {
    }

    public Intent STT() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.JAPANESE);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi speak something");
        return intent;
    }

    public TextToSpeech TTS(Context context, TextToSpeech.OnInitListener onInit) {
        TextToSpeech TTS = new TextToSpeech(context, onInit);
        return TTS;
    }

    public String MainChatbot(ArrayList<String> speechMessage, Context context, FragmentActivity activity) {
        String botMessage = "Pardon. I didn't get that.";
        String userMessage = speechMessage.get(0);
        Fragment selectedFragment = null;
        Fragment selectedFragment2 = null;

        // nav bar
        if (userMessage.compareToIgnoreCase("home") == 0) {
            selectedFragment = new HomeFragment();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_fragment_container, selectedFragment);
            ft.addToBackStack("nav_home");
            ft.commit();
            botMessage = "Going to Home Page";
        }
        if (userMessage.compareToIgnoreCase("my account") == 0) {
            selectedFragment = new MyAccountFragment();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_fragment_container, selectedFragment);

            ft.addToBackStack("nav_account");
            ft.commit();
            botMessage = "Going to My I.C.E Page";
        }
        if (userMessage.compareToIgnoreCase("ice") == 0) {
            selectedFragment = new MyICEFragment();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_fragment_container, selectedFragment);

            ft.addToBackStack("nav_ice");
            ft.commit();
            botMessage = "Going to My I.C.E Page";
        }

        if (userMessage.compareToIgnoreCase("body injury") == 0) {
            selectedFragment = new MyICEFragment();
            selectedFragment2 = new c3_BodyInjuriesFragment();
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_fragment_container, selectedFragment);
            FragmentTransaction ft2 = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, selectedFragment2);

            ft.addToBackStack("nav_ice");
            ft.commit();
            ft2.commit();

            botMessage = "Going to Body Injuries Page";
        }
        // categories
//        if (userMessage.compareToIgnoreCase("first aid") == 0) {
//            selectedFragment = new cv1_FirstAiderFragment();
//            activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, selectedFragment).commit();
//            botMessage = "Going to First Aider Page";
//        }
//        if (userMessage.compareToIgnoreCase("incidents") == 0) {
//            selectedFragment = new cv2_IncidentsFragment();
//            activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, selectedFragment).commit();
//            botMessage = "Going to Incident Page";
//        }
        if (userMessage.compareToIgnoreCase("number three") == 0) {
//            botMessage = "transitioning to In-home incidents page";
//            Intent intent = new Intent(context, InHomeIncidents.class);
//            context.startActivity(intent);
        }
        if (userMessage.compareToIgnoreCase("number four") == 0) {
//            botMessage = "transitioning to out-door incidents page";
//            Intent intent = new Intent(context, OutDoorIncidents.class);
//            context.startActivity(intent);
        }
        if (userMessage.compareToIgnoreCase("heart attack") == 0) {
//            Intent intent = new Intent(context, HeartAttackActivity.class);
//            context.startActivity(intent);
//            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 911"));
//            context.startActivity(intent);
//            botMessage = "Transitioning to Heart Attack Page";
        }
        if (userMessage.compareToIgnoreCase("hello") == 0) {
            botMessage = "Hi, I'm Bling App";
        }
        if (userMessage.compareToIgnoreCase("emergency") == 0) {
            botMessage = "Calling 911.";
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 911"));
            context.startActivity(intent);
        }
        if (userMessage.compareToIgnoreCase("hotline") == 0) {
            botMessage = "Hello, what is your emergency?";
        }
        if (userMessage.compareToIgnoreCase("thank you") == 0 || userMessage.compareToIgnoreCase("thanks") == 0) {
            botMessage = "Thank you for using bling app";
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
//                    Intent intent = new Intent(context, MainActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    intent.putExtra("EXIT", true);
//                    context.startActivity(intent);
                }
            }, 1500);
        }
        return botMessage;
    }

    public String HashPassword(String password) {
        String hashedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }
}
