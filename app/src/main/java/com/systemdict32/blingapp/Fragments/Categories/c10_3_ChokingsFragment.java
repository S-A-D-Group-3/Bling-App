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

import com.systemdict32.blingapp.Fragments.SubCategories.c10_5_PulseLocationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_6_LvlResponseFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_7_PulseRateFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_8_BreathingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_1_ChokingAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_2_ChokingChildFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_3_ChokingInfantFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c10_3_ChokingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_3_ChokingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_3_ChokingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_3_ChokingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_3_ChokingsFragment newInstance(String param1, String param2) {
        c10_3_ChokingsFragment fragment = new c10_3_ChokingsFragment();
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

    ListView lv_basic_chokings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c10_3__chokings, container, false);

        lv_basic_chokings = view.findViewById(R.id.lv_basic_chokings);

        ArrayList<String> chokings_list = new ArrayList<>();
        chokings_list.add("Choking Adult");
        chokings_list.add("Choking Child");
        chokings_list.add("Choking Infant");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, chokings_list);

        lv_basic_chokings.setAdapter(arrayAdapter);

        lv_basic_chokings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("nav_home");
                switch (position) {
                    case 0:
                        c7_1_ChokingAdultFragment c7_1_chokingAdultFragment = new c7_1_ChokingAdultFragment();
                        ft.replace(R.id.home_fragment_container, c7_1_chokingAdultFragment);
                        ft.commit();
                        break;
                    case 1:
                        c7_2_ChokingChildFragment c7_2_chokingChildFragment = new c7_2_ChokingChildFragment();
                        ft.replace(R.id.home_fragment_container, c7_2_chokingChildFragment);
                        ft.commit();
                        break;
                    case 2:
                        c7_3_ChokingInfantFragment c7_3_chokingInfantFragment = new c7_3_ChokingInfantFragment();
                        ft.replace(R.id.home_fragment_container, c7_3_chokingInfantFragment);
                        ft.commit();
                        break;
                }
            }
        });

        return view;
    }
}