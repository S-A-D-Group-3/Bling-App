package com.systemdict32.blingapp.BlingChatbot;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.widget.TextView;

import com.systemdict32.blingapp.EmergencyBasic;
import com.systemdict32.blingapp.EmergencyResponse;
import com.systemdict32.blingapp.InHomeIncidents;
import com.systemdict32.blingapp.OutDoorIncidents;

import java.util.ArrayList;
import java.util.Locale;

public class BlingChatbot {
    final Handler handler = new Handler();

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

    public void TTSProgressListener(TextToSpeech TTS, TextView tv_textTTS) {
        TTS.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String utteranceId) {

            }

            @Override
            // reset text view after bot speech is done
            public void onDone(String utteranceId) {
                tv_textTTS.setText("");
            }

            @Override
            public void onError(String utteranceId) {

            }
        });
    }

    public String MainChatbot(ArrayList<String> speechMessage, Context context) {
        String botMessage = "Pardon. I didn't get that.";
        String userMessage = speechMessage.get(0);

        if (userMessage.compareToIgnoreCase("number one") == 0) {
            botMessage = "Transitioning to Emergency Basic page";
            Intent intent = new Intent(context, EmergencyBasic.class);
            context.startActivity(intent);
        }
        if (userMessage.compareToIgnoreCase("number two") == 0) {
            botMessage = "Transitioning to Emergency Response page";
            Intent intent = new Intent(context, EmergencyResponse.class);
            context.startActivity(intent);
        }
        if (userMessage.compareToIgnoreCase("number three") == 0) {
            botMessage = "transitioning to In-home incidents page";
            Intent intent = new Intent(context, InHomeIncidents.class);
            context.startActivity(intent);
        }
        if (userMessage.compareToIgnoreCase("number four") == 0) {
            botMessage = "transitioning to out-door incidents page";
            Intent intent = new Intent(context, OutDoorIncidents.class);
            context.startActivity(intent);
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
        if (userMessage.compareToIgnoreCase("first aid") == 0) {
            botMessage = "Apply cold water on the open wound.";
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
}
