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
 * Use the {@link c8_1_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c8_1_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c8_1_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c8_1_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c8_1_ReadFragment newInstance(String param1, String param2) {
        c8_1_ReadFragment fragment = new c8_1_ReadFragment();
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
    public String firstAidManual = "1. Cover the casualty’s skin with light clothing or a towel. Help her move out of the sun or, if at all possible, indoors. \n" +
            "\n2. Encourage the casualty to have frequent sips of cold water. Cool the affected skin by dabbing with cold water. If the area is extensive, the casualty may prefer to soak the affected skin in a cold bath for ten minutes. \n" +
            "\n3. If the burns are mild, calamine or an after-sun lotion may soothe them. Advise the casualty to stay inside or in the shade. If sunburn is severe, seek medical advice. \n";
    View view;
    TextView tv_c8_1_first_aid_manual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c8_1__read, container, false);

        tv_c8_1_first_aid_manual = view.findViewById(R.id.tv_c8_1_first_aid_manual);
        tv_c8_1_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c8_1_first_aid_manual = view.findViewById(R.id.tv_c8_1_first_aid_manual);
        tv_c8_1_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}