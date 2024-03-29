package com.systemdict32.blingapp.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.systemdict32.blingapp.Fragments.Categories.c10_FirstAidBasicFragment;
import com.systemdict32.blingapp.Fragments.Categories.c1_EmergencyBasicFragment;
import com.systemdict32.blingapp.Fragments.Categories.c2_WoundsFragment;
import com.systemdict32.blingapp.Fragments.Categories.c3_BodyInjuriesFragment;

import com.systemdict32.blingapp.Fragments.Categories.c4_SevereWoundsFragment;
import com.systemdict32.blingapp.Fragments.Categories.c5_SeriousIncidentsFragment;
import com.systemdict32.blingapp.Fragments.Categories.c6_CarAccidentFragment;
import com.systemdict32.blingapp.Fragments.Categories.c7_RespiratoryProblemFragment;
import com.systemdict32.blingapp.Fragments.Categories.c8_OutdoorIncidentsFragment;
import com.systemdict32.blingapp.Fragments.Categories.c9_ForeignObjectsFragment;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InstructionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InstructionFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InstructionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InstructionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InstructionFragment newInstance(String param1, String param2) {
        InstructionFragment fragment = new InstructionFragment();
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

    CardView cv_1, cv_2, cv_3, cv_4, cv_5, cv_6, cv_7, cv_8, cv_9, cv_10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_instruction, container, false);
        cv_1 = view.findViewById(R.id.cv_1);
        cv_2 = view.findViewById(R.id.cv_2);
        cv_3 = view.findViewById(R.id.cv_3);
        cv_4 = view.findViewById(R.id.cv_4);
        cv_5 = view.findViewById(R.id.cv_5);
        cv_6 = view.findViewById(R.id.cv_6);
        cv_7 = view.findViewById(R.id.cv_7);
        cv_8 = view.findViewById(R.id.cv_8);
        cv_9 = view.findViewById(R.id.cv_9);
        cv_10 = view.findViewById(R.id.cv_10);
//        cv_11 = view.findViewById(R.id.cv_11);
//        cv_12 = view.findViewById(R.id.cv_12);

        cv_1.setOnClickListener(this);
        cv_2.setOnClickListener(this);
        cv_3.setOnClickListener(this);
        cv_4.setOnClickListener(this);
        cv_5.setOnClickListener(this);
        cv_6.setOnClickListener(this);
        cv_7.setOnClickListener(this);
        cv_8.setOnClickListener(this);
        cv_9.setOnClickListener(this);
        cv_10.setOnClickListener(this);
//        cv_11.setOnClickListener(this);
//        cv_12.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == cv_1.getId()) {
            c1_EmergencyBasicFragment cv1 = new c1_EmergencyBasicFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, cv1);
            ft.addToBackStack("instruction_category");
            ft.commit();
        }
        if (v.getId() == cv_2.getId()) {
            c2_WoundsFragment cv2 = new c2_WoundsFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, cv2);
            ft.addToBackStack("instruction_category");
            ft.commit();
        }
        if (v.getId() == cv_3.getId()) {
            c3_BodyInjuriesFragment cv3 = new c3_BodyInjuriesFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, cv3);
            ft.addToBackStack("instruction_category");
            ft.commit();
        }
        if (v.getId() == cv_4.getId()) {
            c4_SevereWoundsFragment cv4 = new c4_SevereWoundsFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, cv4);
            ft.addToBackStack("instruction_category");
            ft.commit();
        }
        if (v.getId() == cv_5.getId()) {
            c5_SeriousIncidentsFragment cv5 = new c5_SeriousIncidentsFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, cv5);
            ft.addToBackStack("instruction_category");
            ft.commit();
        }
        if (v.getId() == cv_6.getId()) {
            c6_CarAccidentFragment cv6 = new c6_CarAccidentFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, cv6);
            ft.addToBackStack("instruction_category");
            ft.commit();
        }
        if (v.getId() == cv_7.getId()) {
            c7_RespiratoryProblemFragment cv7 = new c7_RespiratoryProblemFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, cv7);
            ft.addToBackStack("instruction_category");
            ft.commit();
        }
        if (v.getId() == cv_8.getId()) {
            c8_OutdoorIncidentsFragment cv8 = new c8_OutdoorIncidentsFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, cv8);
            ft.addToBackStack("instruction_category");
            ft.commit();
        }
        if (v.getId() == cv_9.getId()) {
            c9_ForeignObjectsFragment cv9 = new c9_ForeignObjectsFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, cv9);
            ft.addToBackStack("instruction_category");
            ft.commit();
        }
        if (v.getId() == cv_10.getId()) {
            c10_FirstAidBasicFragment c10 = new c10_FirstAidBasicFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, c10);
            ft.addToBackStack("instruction_category");
            ft.commit();
        }
//        if (v.getId() == cv_11.getId()) {
//
//        }
//        if (v.getId() == cv_12.getId()) {
//
//        }
    }

}