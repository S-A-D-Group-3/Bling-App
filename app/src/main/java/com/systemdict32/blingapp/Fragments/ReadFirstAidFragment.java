package com.systemdict32.blingapp.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.systemdict32.blingapp.BlingChatbot.BlingChatbot;
import com.systemdict32.blingapp.Interfaces.FirstAidInterface;
import com.systemdict32.blingapp.R;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReadFirstAidFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReadFirstAidFragment extends Fragment implements TextToSpeech.OnInitListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ReadFirstAidFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReadFirstAidFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReadFirstAidFragment newInstance(String param1, String param2) {
        ReadFirstAidFragment fragment = new ReadFirstAidFragment();
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

    Button btn_read_first_aid;
    BlingChatbot blingChatbot;
    TextToSpeech TTS;
    public FirstAidInterface firstAidInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_first_aid, container, false);
        blingChatbot = new BlingChatbot();
        TTS = blingChatbot.TTS(getActivity(), this);
        btn_read_first_aid = view.findViewById(R.id.btn_read_first_aid);

        firstAidInterface = (FirstAidInterface) getParentFragment();



        btn_read_first_aid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFirstAid();
            }
        });
        return view;
    }

    public void readFirstAid() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String message = firstAidInterface.getFirstAid();
            String[] splitMessage = message.split("\\. ");
            TTSProgressListener();
            highlightWordCounter=0;
            for (int i = 0; i < splitMessage.length; i++) {
                TTS.speak(splitMessage[i], TextToSpeech.QUEUE_ADD, null, TextToSpeech.ACTION_TTS_QUEUE_PROCESSING_COMPLETED);
            }
        }
    }

    int highlightWordCounter = 0;
    public void TTSProgressListener() {
        TTS.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String utteranceId) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        highlightTextPart(highlightWordCounter, "\\. ");
                        highlightWordCounter++;
                    }
                });
            }

            @Override
            // reset text view after bot speech is done
            public void onDone(String utteranceId) {
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        highlightTextPart(j, " ");
//                        j++;
//                    }
//                });
            }

            @Override
            public void onError(String utteranceId) {

            }
        });
    }

    private void highlightTextPart(int index, String regularExpression) {
        String fullText = firstAidInterface.getFirstAid();
        int startPos = 0;
        int endPos = fullText.length();
        String[] textParts = fullText.split(regularExpression);
        if (index < 0 || index > textParts.length - 1) {
            return;
        }
        if (textParts.length > 1) {
            startPos = fullText.indexOf(textParts[index]);
            endPos = fullText.indexOf(". ", startPos);

            if (endPos == -1) {
                endPos = fullText.length();
            }
        }
        Spannable spannable = new SpannableString(fullText);
//        ColorStateList blueColor = new ColorStateList(new int[][]{new int[]{}}, new int[]{Color.BLUE}); -- changes text color
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, -1, -1, null, null);
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.YELLOW);
        spannable.setSpan(textAppearanceSpan, startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(backgroundColorSpan, startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        if(firstAidInterface.getClass().equals(cv1_FirstAiderFragment.class)){
            ((cv1_FirstAiderFragment) getParentFragment()).setFirstAidText(spannable);

        }
//        if(firstAidInterface.getClass().equals(BleedingActivity.class)){
//            ((BleedingActivity) getActivity()).setFirstAidText(spannable);
//        }

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = TTS.setLanguage(Locale.getDefault());
            TTS.setSpeechRate(0.8f);
            TTS.setPitch(1);
            // check if TTS is support on user , if false create speak to user
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // if true make a toast saying TTS is not supported
                Toast.makeText(getActivity(), "TTS language not supported", Toast.LENGTH_SHORT).show();
            } else {
                // if false launch a welcome message to the user
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        String message = "Hi, I'm Bling App.";
//                        TTS.speak(message, TextToSpeech.QUEUE_FLUSH, null, TextToSpeech.ACTION_TTS_QUEUE_PROCESSING_COMPLETED);
                }
            }
        } else {
            Toast.makeText(getActivity(), "TTS initialization failed.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        TTS.stop();
    }
}