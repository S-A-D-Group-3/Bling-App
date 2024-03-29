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
import com.systemdict32.blingapp.Fragments.SubCategories.c10_16_ArmSlingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_17_ElevateSlingFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c10_5_SlingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_5_SlingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_5_SlingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_5_SlingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_5_SlingFragment newInstance(String param1, String param2) {
        c10_5_SlingFragment fragment = new c10_5_SlingFragment();
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
    ListView lv_basic_sling;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_c10_5__sling, container, false);

        lv_basic_sling = view.findViewById(R.id.lv_basic_sling);

        ArrayList<String> slings_list = new ArrayList<>();
        slings_list.add("Arm Sling");
        slings_list.add("Elevation Sling");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, slings_list);

        lv_basic_sling.setAdapter(arrayAdapter);

        lv_basic_sling.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("nav_home");
                switch (position) {
                    case 0:
                        c10_16_ArmSlingFragment c10_16_armSlingFragment = new c10_16_ArmSlingFragment();
                        ft.replace(R.id.home_fragment_container, c10_16_armSlingFragment);
                        ft.commit();
                        break;
                    case 1:
                        c10_17_ElevateSlingFragment c10_17_elevateSlingFragment = new c10_17_ElevateSlingFragment();
                        ft.replace(R.id.home_fragment_container, c10_17_elevateSlingFragment);
                        ft.commit();
                        break;
                }
            }
        });
        return view;
    }
}