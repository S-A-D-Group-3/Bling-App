package com.systemdict32.blingapp.Fragments;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.systemdict32.blingapp.BlingChatbot.BlingChatbot;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_10_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_11_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_12_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_13_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_14_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_15_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_16_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_17_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_1_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_2_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_3_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_4_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_5_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_6_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_7_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_8_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c10_9_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_10_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_11_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_12_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_13_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_14_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_15_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_16_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_17_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_1_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_2_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_3_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_4_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_5_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_6_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_7_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_8_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_9_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c2_1_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c2_2_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c2_3_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c2_4_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c2_5_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c2_6_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c2_7_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c2_8_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c2_9_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c3_10_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c3_1_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c3_2_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c3_3_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c3_4_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c3_5_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c3_6_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c3_7_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c3_8_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c3_9_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c4_1_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c4_2_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c4_3_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c4_4_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c4_5_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c4_6_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c5_10_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c5_1_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c5_2_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c5_3_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c5_4_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c5_5_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c5_6_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c5_7_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c5_8_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c5_9_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c6_1_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c6_2_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c6_3_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c6_4_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c6_5_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c6_6_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c6_7_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c7_1_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c7_2_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c7_3_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c7_4_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c7_5_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c7_6_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c7_7_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c7_8_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c7_9_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c8_1_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c8_2_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c8_3_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c8_4_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c8_5_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c9_1_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c9_2_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c9_3_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c9_4_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c9_5_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c9_6_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c9_7_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c9_8_ReadFragment;
import com.systemdict32.blingapp.Interfaces.FirstAidInterface;
import com.systemdict32.blingapp.R;

import java.util.Locale;

import es.dmoral.toasty.Toasty;

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

    ImageView iv_read_first_aid, iv_cancel_read;
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

        iv_read_first_aid = view.findViewById(R.id.iv_read_first_aid);
        iv_read_first_aid.setImageResource(R.drawable.read_first_aid);

        iv_cancel_read = view.findViewById(R.id.iv_cancel_read);
        iv_cancel_read.setImageResource(R.drawable.cancel_read);

        firstAidInterface = (FirstAidInterface) getParentFragment();

        iv_read_first_aid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFirstAid();
            }
        });

        iv_cancel_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highlightWordCounter = -1;
                highlightTextPart(highlightWordCounter, "\\, |\\. ");
                TTS.stop();
                if (TTS.STOPPED == -2) {
                    iv_read_first_aid.setVisibility(View.VISIBLE);
                    iv_cancel_read.setVisibility(View.GONE);
                }
            }
        });
        return view;
    }

    public void readFirstAid() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String message = firstAidInterface.getFirstAid();
            String[] splitMessage = message.split("\\, |\\. ");
            TTSProgressListener();
            highlightWordCounter = 0;
            for (int i = 0; i < splitMessage.length; i++) {
                TTS.speak(splitMessage[i], TextToSpeech.QUEUE_ADD, null, TextToSpeech.ACTION_TTS_QUEUE_PROCESSING_COMPLETED);
            }
        } else {
            Toasty.warning(getActivity(), "Text to Speech API is not supported."
                    , Toast.LENGTH_LONG, true).show();
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
                        highlightTextPart(highlightWordCounter, "\\, |\\. ");
                        highlightWordCounter++;
                        iv_cancel_read.setVisibility(View.VISIBLE);
                        iv_read_first_aid.setVisibility(View.GONE);
                    }
                });
            }

            @Override
            public void onDone(String utteranceId) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iv_read_first_aid.setVisibility(View.VISIBLE);
                        iv_cancel_read.setVisibility(View.GONE);
                    }
                });
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

            int commaPos = fullText.indexOf(",", startPos);
            int dotPos = fullText.indexOf(".", startPos);
//            int colonPos = fullText.indexOf(":", startPos);
//            int semiColonPos = fullText.indexOf(";", startPos);

            if (commaPos < dotPos && commaPos != -1) {
                endPos = commaPos;
            } else {
                endPos = dotPos;
            }
            //may bug
//            if(commaPos < dotPos && commaPos < colonPos && commaPos < semiColonPos) {
//                endPos = commaPos;
//            } else if (dotPos < commaPos && dotPos < colonPos && dotPos < semiColonPos) {
//                endPos = dotPos;
//            } else if (colonPos < commaPos && colonPos < dotPos && colonPos < semiColonPos)
//                endPos = colonPos;
//            else {
//                endPos = semiColonPos;
//            }

//            endPos = punctuationFinder(fullText);
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

        setFirstAidText(spannable);
    }

    public void setFirstAidText(Spannable spannable){
        // C1 EMERGENCY BASIC
        if (firstAidInterface.getClass().equals(c1_1_ReadFragment.class)) {
            ((c1_1_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_2_ReadFragment.class)) {
            ((c1_2_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_3_ReadFragment.class)) {
            ((c1_3_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_4_ReadFragment.class)) {
            ((c1_4_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_5_ReadFragment.class)) {
            ((c1_5_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_6_ReadFragment.class)) {
            ((c1_6_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_7_ReadFragment.class)) {
            ((c1_7_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_8_ReadFragment.class)) {
            ((c1_8_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_9_ReadFragment.class)) {
            ((c1_9_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_10_ReadFragment.class)) {
            ((c1_10_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_11_ReadFragment.class)) {
            ((c1_11_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_12_ReadFragment.class)) {
            ((c1_12_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_13_ReadFragment.class)) {
            ((c1_13_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_14_ReadFragment.class)) {
            ((c1_14_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_15_ReadFragment.class)) {
            ((c1_15_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_16_ReadFragment.class)) {
            ((c1_16_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c1_17_ReadFragment.class)) {
            ((c1_17_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        // C2 WOUNDS
        if (firstAidInterface.getClass().equals(c2_1_ReadFragment.class)) {
            ((c2_1_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }

        if (firstAidInterface.getClass().equals(c2_2_ReadFragment.class)) {
            ((c2_2_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c2_3_ReadFragment.class)) {
            ((c2_3_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c2_4_ReadFragment.class)) {
            ((c2_4_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c2_5_ReadFragment.class)) {
            ((c2_5_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c2_6_ReadFragment.class)) {
            ((c2_6_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c2_7_ReadFragment.class)) {
            ((c2_7_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c2_8_ReadFragment.class)) {
            ((c2_8_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c2_9_ReadFragment.class)) {
            ((c2_9_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        // c3 BODY INJURIES
        if (firstAidInterface.getClass().equals(c3_1_ReadFragment.class)) {
            ((c3_1_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c3_2_ReadFragment.class)) {
            ((c3_2_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c3_3_ReadFragment.class)) {
            ((c3_3_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c3_4_ReadFragment.class)) {
            ((c3_4_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c3_5_ReadFragment.class)) {
            ((c3_5_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c3_6_ReadFragment.class)) {
            ((c3_6_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c3_7_ReadFragment.class)) {
            ((c3_7_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c3_8_ReadFragment.class)) {
            ((c3_8_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c3_9_ReadFragment.class)) {
            ((c3_9_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c3_10_ReadFragment.class)) {
            ((c3_10_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        // c4 SEVERE WOUNDS
        if (firstAidInterface.getClass().equals(c4_1_ReadFragment.class)) {
            ((c4_1_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c4_2_ReadFragment.class)) {
            ((c4_2_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c4_3_ReadFragment.class)) {
            ((c4_3_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c4_4_ReadFragment.class)) {
            ((c4_4_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c4_5_ReadFragment.class)) {
            ((c4_5_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c4_6_ReadFragment.class)) {
            ((c4_6_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        // C5 Serious Incidents
        if (firstAidInterface.getClass().equals(c5_1_ReadFragment.class)) {
            ((c5_1_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c5_2_ReadFragment.class)) {
            ((c5_2_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c5_3_ReadFragment.class)) {
            ((c5_3_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c5_4_ReadFragment.class)) {
            ((c5_4_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c5_5_ReadFragment.class)) {
            ((c5_5_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c5_6_ReadFragment.class)) {
            ((c5_6_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c5_7_ReadFragment.class)) {
            ((c5_7_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c5_8_ReadFragment.class)) {
            ((c5_8_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c5_9_ReadFragment.class)) {
            ((c5_9_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c5_10_ReadFragment.class)) {
            ((c5_10_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        // C6 Car Accident
        if (firstAidInterface.getClass().equals(c6_1_ReadFragment.class)) {
            ((c6_1_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c6_2_ReadFragment.class)) {
            ((c6_2_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c6_3_ReadFragment.class)) {
            ((c6_3_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c6_4_ReadFragment.class)) {
            ((c6_4_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c6_5_ReadFragment.class)) {
            ((c6_5_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c6_6_ReadFragment.class)) {
            ((c6_6_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c6_7_ReadFragment.class)) {
            ((c6_7_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        // C7 RESPIRATORY PROBLEM
        if (firstAidInterface.getClass().equals(c7_1_ReadFragment.class)) {
            ((c7_1_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c7_2_ReadFragment.class)) {
            ((c7_2_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c7_3_ReadFragment.class)) {
            ((c7_3_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c7_4_ReadFragment.class)) {
            ((c7_4_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c7_5_ReadFragment.class)) {
            ((c7_5_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c7_6_ReadFragment.class)) {
            ((c7_6_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c7_7_ReadFragment.class)) {
            ((c7_7_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c7_8_ReadFragment.class)) {
            ((c7_8_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c7_9_ReadFragment.class)) {
            ((c7_9_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        // C8 Outdoor Incidents
        if (firstAidInterface.getClass().equals(c8_1_ReadFragment.class)) {
            ((c8_1_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c8_2_ReadFragment.class)) {
            ((c8_2_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c8_3_ReadFragment.class)) {
            ((c8_3_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c8_4_ReadFragment.class)) {
            ((c8_4_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c8_5_ReadFragment.class)) {
            ((c8_5_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        // C9 Foreign Objects
        if (firstAidInterface.getClass().equals(c9_1_ReadFragment.class)) {
            ((c9_1_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c9_2_ReadFragment.class)) {
            ((c9_2_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c9_3_ReadFragment.class)) {
            ((c9_3_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c9_4_ReadFragment.class)) {
            ((c9_4_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c9_5_ReadFragment.class)) {
            ((c9_5_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c9_6_ReadFragment.class)) {
            ((c9_6_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c9_7_ReadFragment.class)) {
            ((c9_7_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c9_8_ReadFragment.class)) {
            ((c9_8_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        // c10 first aid basic
        if (firstAidInterface.getClass().equals(c10_1_ReadFragment.class)) {
            ((c10_1_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_2_ReadFragment.class)) {
            ((c10_2_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_3_ReadFragment.class)) {
            ((c10_3_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_4_ReadFragment.class)) {
            ((c10_4_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_5_ReadFragment.class)) {
            ((c10_5_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_6_ReadFragment.class)) {
            ((c10_6_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_7_ReadFragment.class)) {
            ((c10_7_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_8_ReadFragment.class)) {
            ((c10_8_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_9_ReadFragment.class)) {
            ((c10_9_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_10_ReadFragment.class)) {
            ((c10_10_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_11_ReadFragment.class)) {
            ((c10_11_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_12_ReadFragment.class)) {
            ((c10_12_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_13_ReadFragment.class)) {
            ((c10_13_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_14_ReadFragment.class)) {
            ((c10_14_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_15_ReadFragment.class)) {
            ((c10_15_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_16_ReadFragment.class)) {
            ((c10_16_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
        if (firstAidInterface.getClass().equals(c10_17_ReadFragment.class)) {
            ((c10_17_ReadFragment) getParentFragment()).setFirstAidText(spannable);
        }
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        TTS.stop();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        TTS.stop();
    }
}