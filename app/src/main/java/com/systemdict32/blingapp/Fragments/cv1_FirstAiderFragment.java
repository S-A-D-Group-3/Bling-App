package com.systemdict32.blingapp.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.systemdict32.blingapp.Interfaces.FirstAidInterface;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cv1_FirstAiderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cv1_FirstAiderFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public cv1_FirstAiderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cv1_FirstAiderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static cv1_FirstAiderFragment newInstance(String param1, String param2) {
        cv1_FirstAiderFragment fragment = new cv1_FirstAiderFragment();
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

            // This callback will only be called when MyFragment is at least Started.
            // OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            //  @Override
            // public void handleOnBackPressed() {
            // Handle the back button event
            // }
            //  }
            //  requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

            // The callback can be enabled or disabled here or in handleOnBackPressed()
        }
    }
    View view;
    TextView tv_bleeding_first_aid;
    public String firstAidManual = "1. Remove any clothing or debris on the wound. Don't remove large or deeply embedded objects. Don't probe the wound or attempt to clean it yet. Your first job is to stop the bleeding. Wear disposable protective gloves if available. \n" +
            "2. Stop the bleeding. Place a sterile bandage or clean cloth on the wound. Press the bandage firmly with your palm to control bleeding. Apply constant pressure until the bleeding stops. Maintain pressure by binding the wound with a thick bandage or a piece of clean cloth. Don't put direct pressure on an eye injury or embedded object. ";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cv1__first_aider, container, false);

        tv_bleeding_first_aid = view.findViewById(R.id.tv_bleeding_first_aid);
//        SpannableStringBuilder ssb = new SpannableStringBuilder( firstAidManual );
//        Bitmap smiley = BitmapFactory.decodeResource( getResources(), R.drawable.bleeding_first_aid );
//        ssb.setSpan( new ImageSpan( smiley ), 231, 232, Spannable.SPAN_INCLUSkIVE_INCLUSIVE );
//        tv_bleeding_first_aid.setText( ssb, TextView.BufferType.SPANNABLE );
//
//        tv_bleeding_first_aid.setCompoundDrawablesWithIntrinsicBounds(
//                R.drawable.bleeding_first_aid, 0, 0, 0);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_bleeding_first_aid = view.findViewById(R.id.tv_bleeding_first_aid);
        tv_bleeding_first_aid.setText(text);
    }

    public String getFirstAid() {
        return firstAidManual;
    }

}