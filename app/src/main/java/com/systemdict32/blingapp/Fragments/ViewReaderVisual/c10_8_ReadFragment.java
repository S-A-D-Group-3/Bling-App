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
 * Use the {@link c10_8_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_8_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_8_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_8_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_8_ReadFragment newInstance(String param1, String param2) {
        c10_8_ReadFragment fragment = new c10_8_ReadFragment();
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

    public String firstAidManual = "When assessing a casualty’s breathing, check the breathing rate and listen for any breathing difficulties or unusual noises. An adult’s normal breathing rate is 12–16 breaths per minute; in babies and young children, it is 20–30 breaths per minute. When checking breathing, listen for breaths and watch the casualty’s chest movements. For a baby or young child, it might be easier to place your hand on the chest and feel for movement of breathing. Record the following information. \n" +
            "\nRate — count the number of breaths per minute. \n" +
            "\nDepth — are the breaths deep or shallow. \n" +
            "\nEase — are the breaths easy, difficult, or painful?. \n" +
            "\nNoise — Is the breathing quiet or noisy, and if noisy, what are the types of noise?. \n";
    TextView tv_c10_8_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c10_8__read, container, false);

        tv_c10_8_first_aid_manual = view.findViewById(R.id.tv_c10_8_first_aid_manual);
        tv_c10_8_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c10_8_first_aid_manual = view.findViewById(R.id.tv_c10_8_first_aid_manual);
        tv_c10_8_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}