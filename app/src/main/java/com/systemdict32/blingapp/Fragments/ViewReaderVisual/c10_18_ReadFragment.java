package com.systemdict32.blingapp.Fragments.ViewReaderVisual;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.systemdict32.blingapp.Fragments.SubCategories.c10_18_FASTFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_9_CirculationFragment;
import com.systemdict32.blingapp.Interfaces.FirstAidInterface;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c10_18_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_18_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_18_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_18_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_18_ReadFragment newInstance(String param1, String param2) {
        c10_18_ReadFragment fragment = new c10_18_ReadFragment();
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

    public String firstAidManual = "FAST (Face-Arm-Speech-Time) GUIDE. \n" +
            "\nF. Facial weakness—the casualty is unable to smile evenly and the mouth or eye may be droopy. \n" +
            "\nA. Arm weakness—the casualty is only able to raise one of his arms. \n" +
            "\nS. Speech problems—the casualty is unable to speak clearly or may not understand the spoken word. \n" +
            "\nT. Time to call for emergency help if you suspect that the casualty has had a stroke. \n";
    TextView tv_c10_18_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c10_18__read, container, false);

        tv_c10_18_first_aid_manual = view.findViewById(R.id.tv_c10_18_first_aid_manual);
        tv_c10_18_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c10_18_first_aid_manual = view.findViewById(R.id.tv_c10_18_first_aid_manual);
        tv_c10_18_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}