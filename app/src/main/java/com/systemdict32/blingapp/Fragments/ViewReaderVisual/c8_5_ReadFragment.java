package com.systemdict32.blingapp.Fragments.ViewReaderVisual;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.systemdict32.blingapp.Interfaces.FirstAidInterface;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c8_5_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c8_5_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c8_5_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c8_5_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c8_5_ReadFragment newInstance(String param1, String param2) {
        c8_5_ReadFragment fragment = new c8_5_ReadFragment();
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

    public String firstAidManual = "1. Help the casualty to a cool, shady place. Get him to lie down and raise and support his legs to improve blood flow to his brain. \n" +
            "\n2. Give him plenty of water to drink. Oral rehydration salts or isotonic drinks will help with salt replacement. \n" +
            "\n3. Monitor and record vital signs—level of response, breathing, and pulse. Even if the casualty recovers quickly, advise him to seek medical help. \n" +
            "\n4. If the casualty’s vital signs worsen, call for emergency help. Monitor and record vital signs—level of response, breathing, and pulse—while you are waiting for help to arrive. \n";
    View view;
    TextView tv_c8_5_first_aid_manual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c8_5__read, container, false);

        tv_c8_5_first_aid_manual = view.findViewById(R.id.tv_c8_5_first_aid_manual);
        tv_c8_5_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c8_5_first_aid_manual = view.findViewById(R.id.tv_c8_5_first_aid_manual);
        tv_c8_5_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}