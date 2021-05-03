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

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c1_12_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c1_12_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c1_12_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c1_12_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c1_12_ReadFragment newInstance(String param1, String param2) {
        c1_12_ReadFragment fragment = new c1_12_ReadFragment();
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

    public String firstAidManual = "1. Give the casualty plenty of cold fluids to help ease the pain and keep the throat from becoming dry. \n" +
            "\n2. An adult may take the recommended dose of acetaminophen tablets or his own pain relievers. A child may have acetaminophen syrup. \n";
    TextView tv_c1_12_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c1_12__read, container, false);

        tv_c1_12_first_aid_manual = view.findViewById(R.id.tv_c1_12_first_aid_manual);
        tv_c1_12_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c1_12_first_aid_manual = view.findViewById(R.id.tv_c1_12_first_aid_manual);
        tv_c1_12_first_aid_manual.setText(text);
    }


    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}