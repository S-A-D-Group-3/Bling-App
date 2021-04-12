package com.systemdict32.blingapp.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.model.Dash;
import com.systemdict32.blingapp.Dashboard;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    CardView cv_1, cv_2, cv_3, cv_4, cv_5, cv_6, cv_7, cv_8, cv_9, cv_10, cv_11, cv_12;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

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
        cv_11 = view.findViewById(R.id.cv_11);
        cv_12 = view.findViewById(R.id.cv_12);

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
        cv_11.setOnClickListener(this);
        cv_12.setOnClickListener(this);

        return view;
    }



    @Override
    public void onClick(View v) {
        if(v.getId() == cv_1.getId()){
            cv1_FirstAiderFragment cv1 = new cv1_FirstAiderFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, cv1);
            ft.commit();
        }
        if(v.getId() == cv_2.getId()){
            cv2_IncidentsFragment cv2 = new cv2_IncidentsFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, cv2);
            ft.commit();
        }
        if(v.getId() == cv_3.getId()){

        }
        if(v.getId() == cv_4.getId()){

        }
        if(v.getId() == cv_5.getId()){

        }
        if(v.getId() == cv_6.getId()){

        }
        if(v.getId() == cv_7.getId()){

        }
        if(v.getId() == cv_8.getId()){

        }
        if(v.getId() == cv_9.getId()){

        }
        if(v.getId() == cv_10.getId()){

        }
        if(v.getId() == cv_11.getId()){

        }
        if(v.getId() == cv_12.getId()){

        }
    }
}