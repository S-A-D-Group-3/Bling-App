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

import com.systemdict32.blingapp.Fragments.SubCategories.c10_11_RollerBandageFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_12_RollerBandage2Fragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_13_HandBandageFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_14_GauzeBandageFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_15_BroadBandageFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_1_ChokingAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_2_ChokingChildFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_3_ChokingInfantFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c10_4_BandagesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_4_BandagesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_4_BandagesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_4_BandagesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_4_BandagesFragment newInstance(String param1, String param2) {
        c10_4_BandagesFragment fragment = new c10_4_BandagesFragment();
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

    ListView lv_basic_bandages;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c10_4__bandages, container, false);

        lv_basic_bandages = view.findViewById(R.id.lv_basic_bandages);

        ArrayList<String> bandages_list = new ArrayList<>();
        bandages_list.add("Apply Roller Bandage");
        bandages_list.add("Apply Roller Bandage (Elbow and Knee Bandages)");
        bandages_list.add("Apply Hand Bandages");
        bandages_list.add("Apply Tubular Gauze Bandages");
        bandages_list.add("Make Broad-Fold Bandages");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, bandages_list);

        lv_basic_bandages.setAdapter(arrayAdapter);

        lv_basic_bandages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("nav_home");
                switch (position) {
                    case 0:
                        c10_11_RollerBandageFragment c10_11_rollerBandageFragment = new c10_11_RollerBandageFragment();
                        ft.replace(R.id.home_fragment_container, c10_11_rollerBandageFragment);
                        ft.commit();
                        break;
                    case 1:
                        c10_12_RollerBandage2Fragment c10_12_rollerBandage2Fragment = new c10_12_RollerBandage2Fragment();
                        ft.replace(R.id.home_fragment_container, c10_12_rollerBandage2Fragment);
                        ft.commit();
                        break;
                    case 2:
                        c10_13_HandBandageFragment c10_13_handBandageFragment = new c10_13_HandBandageFragment();
                        ft.replace(R.id.home_fragment_container, c10_13_handBandageFragment);
                        ft.commit();
                        break;
                    case 3:
                        c10_14_GauzeBandageFragment c10_14_gauzeBandageFragment = new c10_14_GauzeBandageFragment();
                        ft.replace(R.id.home_fragment_container, c10_14_gauzeBandageFragment);
                        ft.commit();
                        break;
                    case 4:
                        c10_15_BroadBandageFragment c10_15_broadBandageFragment = new c10_15_BroadBandageFragment();
                        ft.replace(R.id.home_fragment_container, c10_15_broadBandageFragment);
                        ft.commit();
                        break;
                }
            }
        });

        return view;
    }
}