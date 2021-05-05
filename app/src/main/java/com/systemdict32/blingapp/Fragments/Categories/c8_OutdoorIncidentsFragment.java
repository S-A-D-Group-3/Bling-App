package com.systemdict32.blingapp.Fragments.Categories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.systemdict32.blingapp.Fragments.SubCategories.c5_3_HeatStrokeFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_1_ChokingAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c8_1_SunburnFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c8_2_FrostbiteFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c8_3_DehydrationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c8_4_HypothermiaFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c8_5_HeatExhaustionFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c8_OutdoorIncidentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c8_OutdoorIncidentsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c8_OutdoorIncidentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OutdoorIncidentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c8_OutdoorIncidentsFragment newInstance(String param1, String param2) {
        c8_OutdoorIncidentsFragment fragment = new c8_OutdoorIncidentsFragment();
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

    ListView lv_outdoor_incidents;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c8__outdoor_incidents, container, false);

        lv_outdoor_incidents = view.findViewById(R.id.lv_outdoor_incidents);

        ArrayList<String> woundsList = new ArrayList<>();

        woundsList.add("1. Sunburn");
        woundsList.add("2. Frostbite");
        woundsList.add("3. Dehydration");
        woundsList.add("4. Hypothermia");
        woundsList.add("5. Heat Stroke");
        woundsList.add("6. Heat Exhaustion");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, woundsList);

        lv_outdoor_incidents.setAdapter(arrayAdapter);

        lv_outdoor_incidents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                switch (position) {
                    case 0:
                        c8_1_SunburnFragment c8_1_sunburnFragment = new c8_1_SunburnFragment();
                        ft.replace(R.id.home_fragment_container, c8_1_sunburnFragment);
                        ft.commit();
                        break;
                    case 1:
                        c8_2_FrostbiteFragment c8_2_frostbiteFragment = new c8_2_FrostbiteFragment();
                        ft.replace(R.id.home_fragment_container, c8_2_frostbiteFragment);
                        ft.commit();
                        break;
                    case 2:
                        c8_3_DehydrationFragment c8_3_dehydrationFragment = new c8_3_DehydrationFragment();
                        ft.replace(R.id.home_fragment_container, c8_3_dehydrationFragment);
                        ft.commit();
                        break;
                    case 3:
                        c8_4_HypothermiaFragment c8_4_hypothermiaFragment = new c8_4_HypothermiaFragment();
                        ft.replace(R.id.home_fragment_container, c8_4_hypothermiaFragment);
                        ft.commit();
                        break;
                    case 4:
                        c5_3_HeatStrokeFragment c5_3_heatStrokeFragment = new c5_3_HeatStrokeFragment();
                        ft.replace(R.id.home_fragment_container, c5_3_heatStrokeFragment);
                        ft.commit();
                        break;
                    case 5:
                        c8_5_HeatExhaustionFragment c8_5_heatExhaustionFragment = new c8_5_HeatExhaustionFragment();
                        ft.replace(R.id.home_fragment_container, c8_5_heatExhaustionFragment);
                        ft.commit();
                        break;
                }
            }
        });

        return view;
    }
}