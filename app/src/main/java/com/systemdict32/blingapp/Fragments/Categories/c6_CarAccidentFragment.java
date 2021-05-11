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

import com.systemdict32.blingapp.Fragments.SubCategories.c3_1_HeadInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c3_4_RibInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c4_2_ExternalBleedingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c4_4_ImpalementFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c4_5_AmputationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c4_6_CrushInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_1_StrokeFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_1_SevereBurnFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_2_MildBurnFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_3_ClosedFractureFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_4_OpenFractureFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_5_ForeignObjectEyeFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_6_ForeignObjectEarFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_7_ForeignObjectNoseFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c6_CarAccidentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c6_CarAccidentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c6_CarAccidentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c6_CarAccidentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c6_CarAccidentFragment newInstance(String param1, String param2) {
        c6_CarAccidentFragment fragment = new c6_CarAccidentFragment();
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

    ListView lv_car_accident;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c6__car_accident, container, false);

        lv_car_accident = view.findViewById(R.id.lv_car_accident);

        ArrayList<String> woundsList = new ArrayList<>();

        woundsList.add("1. Severe Burns and Scalds");
        woundsList.add("2. Minor Burns and Scalds");
        woundsList.add("3. Closed Fractures");
        woundsList.add("4. Open Fractures");
        woundsList.add("5. Rib Injury");
        woundsList.add("6. Head Injury");
        woundsList.add("7. Crush Injury");
        woundsList.add("8. Amputation");
        woundsList.add("9. Impalement");
        woundsList.add("10. External Bleeding");
        woundsList.add("11. Foreign Object (Eye)");
        woundsList.add("12. Foreign Object (Ear)");
        woundsList.add("13. Foreign Object (Nose)");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, woundsList);

        lv_car_accident.setAdapter(arrayAdapter);

        lv_car_accident.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("nav_home");
                switch (position) {
                    case 0:
                        c6_1_SevereBurnFragment c6_1_severeBurnFragment = new c6_1_SevereBurnFragment();
                        ft.replace(R.id.home_fragment_container, c6_1_severeBurnFragment);
                        ft.commit();
                        break;
                    case 1:
                        c6_2_MildBurnFragment c6_2_mildBurnFragment = new c6_2_MildBurnFragment();
                        ft.replace(R.id.home_fragment_container, c6_2_mildBurnFragment);
                        ft.commit();
                        break;
                    case 2:
                        c6_3_ClosedFractureFragment c6_3_closedFractureFragment = new c6_3_ClosedFractureFragment();
                        ft.replace(R.id.home_fragment_container, c6_3_closedFractureFragment);
                        ft.commit();
                        break;
                    case 3:
                        c6_4_OpenFractureFragment c6_4_openFractureFragment = new c6_4_OpenFractureFragment();
                        ft.replace(R.id.home_fragment_container, c6_4_openFractureFragment);
                        ft.commit();
                        break;
                    case 4:
                        c3_4_RibInjuryFragment c3_4_ribInjuryFragment = new c3_4_RibInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c3_4_ribInjuryFragment);
                        ft.commit();
                        break;
                    case 5:
                        c3_1_HeadInjuryFragment c3_1_headInjuryFragment = new c3_1_HeadInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c3_1_headInjuryFragment);
                        ft.commit();
                        break;
                    case 6:
                        c4_6_CrushInjuryFragment c4_6_crushInjuryFragment = new c4_6_CrushInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c4_6_crushInjuryFragment);
                        ft.commit();
                        break;
                    case 7:
                        c4_5_AmputationFragment c4_5_amputationFragment = new c4_5_AmputationFragment();
                        ft.replace(R.id.home_fragment_container, c4_5_amputationFragment);
                        ft.commit();
                        break;
                    case 8:
                        c4_4_ImpalementFragment c4_4_impalementFragment = new c4_4_ImpalementFragment();
                        ft.replace(R.id.home_fragment_container, c4_4_impalementFragment);
                        ft.commit();
                        break;
                    case 9:
                        c4_2_ExternalBleedingFragment c4_2_externalBleedingFragment = new c4_2_ExternalBleedingFragment();
                        ft.replace(R.id.home_fragment_container, c4_2_externalBleedingFragment);
                        ft.commit();
                        break;
                    case 10:
                        c6_5_ForeignObjectEyeFragment c6_5_foreignObjectEyeFragment = new c6_5_ForeignObjectEyeFragment();
                        ft.replace(R.id.home_fragment_container, c6_5_foreignObjectEyeFragment);
                        ft.commit();
                        break;
                    case 11:
                        c6_6_ForeignObjectEarFragment c6_6_foreignObjectEarFragment = new c6_6_ForeignObjectEarFragment();
                        ft.replace(R.id.home_fragment_container, c6_6_foreignObjectEarFragment);
                        ft.commit();
                        break;
                    case 12:
                        c6_7_ForeignObjectNoseFragment c6_7_foreignObjectNoseFragment = new c6_7_ForeignObjectNoseFragment();
                        ft.replace(R.id.home_fragment_container, c6_7_foreignObjectNoseFragment);
                        ft.commit();
                        break;
                }
            }
        });

        return view;
    }
}