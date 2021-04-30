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

import com.systemdict32.blingapp.Fragments.SubCategories.c2_1_BlistersFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_10_EmergencyChildbirthFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_1_StrokeFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_2_DrowningFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_3_HeatStrokeFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_4_HeartAttackFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_5_ElectricIncidentFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_6_ElectricBurnFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_7_ChemicalBurnFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_8_SeizuresInAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_9_SeizuresInChildrenFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c5_SeriousIncidentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c5_SeriousIncidentsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c5_SeriousIncidentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c5_SeriousIncidentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c5_SeriousIncidentsFragment newInstance(String param1, String param2) {
        c5_SeriousIncidentsFragment fragment = new c5_SeriousIncidentsFragment();
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

    ListView lv_serious_incidents;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c5__serious_incidents, container, false);

        lv_serious_incidents = view.findViewById(R.id.lv_serious_incidents);

        ArrayList<String> woundsList = new ArrayList<>();

        woundsList.add("1. Stroke");
        woundsList.add("2. Drowning");
        woundsList.add("3. Heat Stroke");
        woundsList.add("4. Heart Attack");
        woundsList.add("5. Electrical Incident");
        woundsList.add("6. Electrical Burn");
        woundsList.add("7. Chemical Burn");
        woundsList.add("8. Seizures in Adults");
        woundsList.add("9. Seizures in Children");
        woundsList.add("10. Emergency Childbirth");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, woundsList);

        lv_serious_incidents.setAdapter(arrayAdapter);

        lv_serious_incidents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                switch (position) {
                    case 0:
                        c5_1_StrokeFragment c5_1_strokeFragment = new c5_1_StrokeFragment();
                        ft.replace(R.id.home_fragment_container, c5_1_strokeFragment);
                        ft.commit();
                        break;
                    case 1:
                        c5_2_DrowningFragment c5_2_drowningFragment = new c5_2_DrowningFragment();
                        ft.replace(R.id.home_fragment_container, c5_2_drowningFragment);
                        ft.commit();
                        break;
                    case 2:
                        c5_3_HeatStrokeFragment c5_3_heatStrokeFragment = new c5_3_HeatStrokeFragment();
                        ft.replace(R.id.home_fragment_container, c5_3_heatStrokeFragment);
                        ft.commit();
                        break;
                    case 3:
                        c5_4_HeartAttackFragment c5_4_heartAttackFragment = new c5_4_HeartAttackFragment();
                        ft.replace(R.id.home_fragment_container, c5_4_heartAttackFragment);
                        ft.commit();
                        break;
                    case 4:
                        c5_5_ElectricIncidentFragment c5_5_electricIncidentFragment = new c5_5_ElectricIncidentFragment();
                        ft.replace(R.id.home_fragment_container, c5_5_electricIncidentFragment);
                        ft.commit();
                        break;
                    case 5:
                        c5_6_ElectricBurnFragment c5_6_electricBurnFragment = new c5_6_ElectricBurnFragment();
                        ft.replace(R.id.home_fragment_container, c5_6_electricBurnFragment);
                        ft.commit();
                        break;
                    case 6:
                        c5_7_ChemicalBurnFragment c5_7_chemicalBurnFragment = new c5_7_ChemicalBurnFragment();
                        ft.replace(R.id.home_fragment_container, c5_7_chemicalBurnFragment);
                        ft.commit();
                        break;
                    case 7:
                        c5_8_SeizuresInAdultFragment c5_8_seizuresInAdultFragment = new c5_8_SeizuresInAdultFragment();
                        ft.replace(R.id.home_fragment_container, c5_8_seizuresInAdultFragment);
                        ft.commit();
                        break;
                    case 8:
                        c5_9_SeizuresInChildrenFragment c5_9_seizuresInChildrenFragment = new c5_9_SeizuresInChildrenFragment();
                        ft.replace(R.id.home_fragment_container, c5_9_seizuresInChildrenFragment);
                        ft.commit();
                        break;
                    case 9:
                        c5_10_EmergencyChildbirthFragment c5_10_emergencyChildbirthFragment = new c5_10_EmergencyChildbirthFragment();
                        ft.replace(R.id.home_fragment_container, c5_10_emergencyChildbirthFragment);
                        ft.commit();
                        break;
                }
            }
        });

        return view;
    }
}