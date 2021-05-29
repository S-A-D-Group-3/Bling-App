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

import com.systemdict32.blingapp.Fragments.SubCategories.c10_1_CprAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_2_CprChildFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_3_CprInfantFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_4_CprCompFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_5_PulseLocationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_6_LvlResponseFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_7_PulseRateFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_8_BreathingFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c10_2_VitalSignsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_2_VitalSignsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_2_VitalSignsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_2_VitalSignsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_2_VitalSignsFragment newInstance(String param1, String param2) {
        c10_2_VitalSignsFragment fragment = new c10_2_VitalSignsFragment();
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

    ListView lv_basic_vital_signs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c10_2__vital_signs, container, false);

        lv_basic_vital_signs = view.findViewById(R.id.lv_basic_vital_signs);

        ArrayList<String> vital_list = new ArrayList<>();
        vital_list.add("Level of Response");
        vital_list.add("How To Identify Pulse Rate");
        vital_list.add("How To Identify Pulse Location");
        vital_list.add("Breathing");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, vital_list);

        lv_basic_vital_signs.setAdapter(arrayAdapter);

        lv_basic_vital_signs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("nav_home");
                switch (position) {
                    case 0:
                        c10_6_LvlResponseFragment c10_6_lvlResponseFragment = new c10_6_LvlResponseFragment();
                        ft.replace(R.id.home_fragment_container, c10_6_lvlResponseFragment);
                        ft.commit();
                        break;
                    case 1:
                        c10_7_PulseRateFragment c10_7_pulseRateFragment = new c10_7_PulseRateFragment();
                        ft.replace(R.id.home_fragment_container, c10_7_pulseRateFragment);
                        ft.commit();
                        break;
                    case 2:
                        c10_5_PulseLocationFragment c10_5_pulseLocationFragment = new c10_5_PulseLocationFragment();
                        ft.replace(R.id.home_fragment_container, c10_5_pulseLocationFragment);
                        ft.commit();
                        break;
                    case 3:
                        c10_8_BreathingFragment c10_8_breathingFragment = new c10_8_BreathingFragment();
                        ft.replace(R.id.home_fragment_container, c10_8_breathingFragment);
                        ft.commit();
                        break;
                }
            }
        });

        return view;
    }
}