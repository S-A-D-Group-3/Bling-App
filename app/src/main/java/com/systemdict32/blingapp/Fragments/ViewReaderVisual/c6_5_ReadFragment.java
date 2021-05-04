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
 * Use the {@link c6_5_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c6_5_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c6_5_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c6_5_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c6_5_ReadFragment newInstance(String param1, String param2) {
        c6_5_ReadFragment fragment = new c6_5_ReadFragment();
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

    public String firstAidManual = "1. Advise the casualty not to rub his/her eye. Ask her to sit down facing a light. \n" +
            "\n2.Stand beside, or just behind, the casualty. Gently separate her eyelids with your thumbs or finger and thumb. Ask her to look right, left, up, and down. Examine every part of her eye as she does this. \n" +
            "\n3.If you can see a foreign object on the white of the eye, wash it out by pouring clean water from a glass or pitcher, or by using a sterile eyewash if you have one. Put a towel around the casualty’s shoulders. Hold her eye open and pour the water from the inner corner so that it drains onto the towel. \n" +
            "\n4.If this is unsuccessful, try lifting the object off with a moist swab or the damp corner of a clean handkerchief or tissue. If you still cannot remove the object, seek medical help. \n";
    View view;
    TextView tv_c6_5_first_aid_manual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c6_5__read, container, false);

        tv_c6_5_first_aid_manual = view.findViewById(R.id.tv_c6_5_first_aid_manual);
        tv_c6_5_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c6_5_first_aid_manual = view.findViewById(R.id.tv_c6_5_first_aid_manual);
        tv_c6_5_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}