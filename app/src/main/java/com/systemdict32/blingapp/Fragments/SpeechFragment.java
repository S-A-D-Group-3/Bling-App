package com.systemdict32.blingapp.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.systemdict32.blingapp.BlingChatbot.BlingChatbot;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SpeechFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpeechFragment extends Fragment implements TextToSpeech.OnInitListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SpeechFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SpeechFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpeechFragment newInstance(String param1, String param2) {
        SpeechFragment fragment = new SpeechFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ImageView iv_speak_STT;
    BlingChatbot blingChatbot;
    TextToSpeech TTS;
    TextView frag_tv_STT;
    LinearLayout speech_layout;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_speech, container, false);

        blingChatbot = new BlingChatbot();
        TTS = blingChatbot.TTS(getActivity(), this);
        iv_speak_STT = view.findViewById(R.id.iv_speak_STT);
        frag_tv_STT = view.findViewById(R.id.frag_tv_STT);
        speech_layout = view.findViewById(R.id.speech_layout);
        iv_speak_STT.setImageResource(R.drawable.microphone);

        iv_speak_STT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = blingChatbot.STT();

                try {
                    startActivityForResult(intent, 1);
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    final Handler handler = new Handler();

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == Activity.RESULT_OK && data != null) {
                    // get the speech from user
                    ArrayList<String> speech = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    // call bling chatbot, pass the speech, chatbot will return a string message, store the message to the string botMessage variable
                    // check the current activity and use the proper chatbot to use
                    String botMessage = blingChatbot.MainChatbot(speech, getActivity(), getActivity());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        TTSProgressListener();
                        // speak bot message
                        TTS.speak(botMessage, TextToSpeech.QUEUE_FLUSH, null, TextToSpeech.ACTION_TTS_QUEUE_PROCESSING_COMPLETED);
                        // set text view based on the botMessage variable
                        frag_tv_STT.setText(botMessage);
                        iv_speak_STT.setImageResource(R.drawable.chatbot);
                        frag_tv_STT.setVisibility(View.VISIBLE);
                    }
                }
        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = TTS.setLanguage(Locale.getDefault());
            TTS.setSpeechRate(1);
            TTS.setPitch(1);
            // check if TTS support on user , if false create speak to user
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // if true make a toast saying TTS is not supported
                Toast.makeText(getActivity(), "TTS language not supported", Toast.LENGTH_SHORT).show();
            } else {
                // if false launch a welcome message to the user
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    TTSProgressListener();
                    String message = "Press me to use Chatbot Assistance";
                    frag_tv_STT.setText(message);
                    iv_speak_STT.setImageResource(R.drawable.chatbot);
                    frag_tv_STT.setVisibility(View.VISIBLE);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    frag_tv_STT.setVisibility(View.INVISIBLE);
                                }
                            }, 3000);
                        }
                    });
                } else {
                    Toast.makeText(getActivity(), "TTS language not supported", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(getActivity(), "TTS initialization failed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void TTSProgressListener() {
        TTS.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String utteranceId) {
            }

            @Override
            // reset text view after bot speech is done
            public void onDone(String utteranceId) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        frag_tv_STT.setVisibility(View.INVISIBLE);
                        iv_speak_STT.setImageResource(R.drawable.microphone);
                    }
                });
            }

            @Override
            public void onError(String utteranceId) {

            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TTS.stop();
    }
}