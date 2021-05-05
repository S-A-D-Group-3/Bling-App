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
 * Use the {@link c7_7_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c7_7_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c7_7_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c7_7_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c7_7_ReadFragment newInstance(String param1, String param2) {
        c7_7_ReadFragment fragment = new c7_7_ReadFragment();
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

    public String firstAidManual = "1. Keep calm and reassure the casualty. \n" +
            "\n2. Get her to take her usual dose of her inhaler; use a spacer if she has one. Ask her to breathe slowly and deeply. \n" +
            "\n3. Sit her down in the position she finds most comfortable; do not let her lie down. n" +
            "\n4. A mild attack should ease in a few minutes. If it does not, ask the casualty to take another dose from her inhaler. \n" +
            "\n5. Call for emergency help if the attack is severe and any of the following occur: the inhaler has no effect; the casualty is getting worse; breathlessness makes talking hard; she becomes exhausted. \n" +
            "\n6. Help the casualty use her inhaler as required. \n" +
            "\n7. Monitor her vital signs—level of response, breathing, and pulse —until help arrives. \n";
    View view;
    TextView tv_c7_7_first_aid_manual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c7_7__read, container, false);
        tv_c7_7_first_aid_manual = view.findViewById(R.id.tv_c7_7_first_aid_manual);
        tv_c7_7_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c7_7_first_aid_manual = view.findViewById(R.id.tv_c7_7_first_aid_manual);
        tv_c7_7_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}