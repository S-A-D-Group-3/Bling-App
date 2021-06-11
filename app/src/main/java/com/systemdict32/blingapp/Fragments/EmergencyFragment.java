package com.systemdict32.blingapp.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmergencyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmergencyFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmergencyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmergencyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmergencyFragment newInstance(String param1, String param2) {
        EmergencyFragment fragment = new EmergencyFragment();
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

    CardView emergency_cv1, emergency_cv2, emergency_cv3, emergency_cv4;
    TextView permGranter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emergency, container, false);

        emergency_cv1 = view.findViewById(R.id.emergency_cv_1);
        emergency_cv2 = view.findViewById(R.id.emergency_cv_2);
        emergency_cv3 = view.findViewById(R.id.emergency_cv_3);
        emergency_cv4 = view.findViewById(R.id.emergency_cv_4);
        permGranter = view.findViewById(R.id.permGranting);

        emergency_cv1.setOnClickListener(this);
        emergency_cv2.setOnClickListener(this);
        emergency_cv3.setOnClickListener(this);
        emergency_cv4.setOnClickListener(this);
        permGranter.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == emergency_cv1.getId()) {
            HospitalFragment hospitalFragment = new HospitalFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, hospitalFragment);
            ft.addToBackStack("emergency_services");
            ft.commit();
        }
        if(v.getId() == emergency_cv2.getId()) {
            PoliceStationsFragment policeStationsFragment = new PoliceStationsFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, policeStationsFragment);
            ft.addToBackStack("emergency_services");
            ft.commit();
        }
        if(v.getId() == emergency_cv3.getId()) {
            FireStationFragment fireStationFragment = new FireStationFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, fireStationFragment);
            ft.addToBackStack("emergency_services");
            ft.commit();
        }
        if(v.getId() == emergency_cv4.getId()) {
            LGUFragment lguFragment = new LGUFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.home_fragment_container, lguFragment);
            ft.addToBackStack("emergency_services");
            ft.commit();
        }
        if(v.getId() == permGranter.getId()) {
           // tama ba dito yung place ng show message onse?
            // dialog box or toast na lang
        }
    }
}