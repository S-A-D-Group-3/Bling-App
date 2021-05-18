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
import com.systemdict32.blingapp.Fragments.SubCategories.c6_5_ForeignObjectEyeFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_6_ForeignObjectEarFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_7_ForeignObjectNoseFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_1_ChokingAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c9_1_TickBiteFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c9_2_SnakeBiteFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c9_3_InsectStingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c9_4_SeaCreatureFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c9_5_AnimalHumanFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c9_6_OtherBitesFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c9_7_DrugPoisoningFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c9_8_SwallowedFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c10_FirstAidBasicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_FirstAidBasicFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_FirstAidBasicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_FirstAidBasicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_FirstAidBasicFragment newInstance(String param1, String param2) {
        c10_FirstAidBasicFragment fragment = new c10_FirstAidBasicFragment();
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

    ListView lv_first_aid_basic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c10__first_aid_basic, container, false);

        lv_first_aid_basic = view.findViewById(R.id.lv_first_aid_basic);

        ArrayList<String> firstAidBasicList = new ArrayList<>();

        firstAidBasicList.add("CPR for Adult");
        firstAidBasicList.add("CPR for Children");
        firstAidBasicList.add("CPR for Infant");
        firstAidBasicList.add("Choking Adult");
        firstAidBasicList.add("Choking Child");
        firstAidBasicList.add("Choking Infant");
        firstAidBasicList.add("Shock");
        firstAidBasicList.add("Level of Response");
        firstAidBasicList.add("How To Identify Pulse Rate");
        firstAidBasicList.add("How To Identify Pulse Location");
        firstAidBasicList.add("Breathing");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, firstAidBasicList);

        lv_first_aid_basic.setAdapter(arrayAdapter);

        lv_first_aid_basic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("nav_home");
                switch (position) {
                    case 0:
                        c10_1_CprAdultFragment c10_1_cprAdultFragment = new c10_1_CprAdultFragment();
                        ft.replace(R.id.home_fragment_container, c10_1_cprAdultFragment);
                        ft.commit();
                        break;
                    case 1:
                        c9_2_SnakeBiteFragment c9_2_snakeBiteFragment = new c9_2_SnakeBiteFragment();
                        ft.replace(R.id.home_fragment_container, c9_2_snakeBiteFragment);
                        ft.commit();
                        break;
                    case 2:
                        c9_3_InsectStingFragment c9_3_insectStingFragment = new c9_3_InsectStingFragment();
                        ft.replace(R.id.home_fragment_container, c9_3_insectStingFragment);
                        ft.commit();
                        break;
                    case 3:
                        c7_1_ChokingAdultFragment c7_1_chokingAdultFragment = new c7_1_ChokingAdultFragment();
                        ft.replace(R.id.home_fragment_container, c7_1_chokingAdultFragment);
                        ft.commit();
                        break;
                    case 4:
                        c9_5_AnimalHumanFragment c9_5_animalHumanFragment = new c9_5_AnimalHumanFragment();
                        ft.replace(R.id.home_fragment_container, c9_5_animalHumanFragment);
                        ft.commit();
                        break;
                    case 5:
                        c9_6_OtherBitesFragment c9_6_otherBitesFragment = new c9_6_OtherBitesFragment();
                        ft.replace(R.id.home_fragment_container, c9_6_otherBitesFragment);
                        ft.commit();
                        break;
                    case 6:
                        c9_7_DrugPoisoningFragment c9_7_drugPoisoningFragment = new c9_7_DrugPoisoningFragment();
                        ft.replace(R.id.home_fragment_container, c9_7_drugPoisoningFragment);
                        ft.commit();
                        break;
                    case 7:
                        c6_5_ForeignObjectEyeFragment c6_5_foreignObjectEyeFragment = new c6_5_ForeignObjectEyeFragment();
                        ft.replace(R.id.home_fragment_container, c6_5_foreignObjectEyeFragment);
                        ft.commit();
                        break;
                    case 8:
                        c6_6_ForeignObjectEarFragment c6_6_foreignObjectEarFragment = new c6_6_ForeignObjectEarFragment();
                        ft.replace(R.id.home_fragment_container, c6_6_foreignObjectEarFragment);
                        ft.commit();
                        break;
                    case 9:
                        c6_7_ForeignObjectNoseFragment c6_7_foreignObjectNoseFragment = new c6_7_ForeignObjectNoseFragment();
                        ft.replace(R.id.home_fragment_container, c6_7_foreignObjectNoseFragment);
                        ft.commit();
                        break;
                    case 10:
                        c9_8_SwallowedFragment c9_8_swallowedFragment = new c9_8_SwallowedFragment();
                        ft.replace(R.id.home_fragment_container, c9_8_swallowedFragment);
                        ft.commit();
                        break;
                }
            }
        });
        return view;
    }
}