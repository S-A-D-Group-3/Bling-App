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

import com.systemdict32.blingapp.Fragments.SubCategories.c10_10_ColdCompressFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_16_ArmSlingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_17_ElevateSlingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_1_CprAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_2_CprChildFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_3_CprInfantFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_4_CprCompFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_5_PulseLocationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_6_LvlResponseFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_7_PulseRateFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_8_BreathingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_9_CirculationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c4_1_ShockFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_1_StrokeFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_4_HeartAttackFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_5_ForeignObjectEyeFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_6_ForeignObjectEarFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_7_ForeignObjectNoseFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_1_ChokingAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_2_ChokingChildFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_3_ChokingInfantFragment;
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

        firstAidBasicList.add("CPR");
        firstAidBasicList.add("Vital Signs");
        firstAidBasicList.add("Choking");
        firstAidBasicList.add("Bandages");
        firstAidBasicList.add("Sling");
        firstAidBasicList.add("Circulation");
        firstAidBasicList.add("Cold Compression");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, firstAidBasicList);

        lv_first_aid_basic.setAdapter(arrayAdapter);

        lv_first_aid_basic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("nav_home");
                switch (position) {
                    case 0:
                        c10_1_CprFragment c10_1_cprFragment = new c10_1_CprFragment();
                        ft.replace(R.id.home_fragment_container, c10_1_cprFragment);
                        ft.commit();
                        break;
                    case 1:
                        c10_2_VitalSignsFragment c10_2_vitalSignsFragment = new c10_2_VitalSignsFragment();
                        ft.replace(R.id.home_fragment_container, c10_2_vitalSignsFragment);
                        ft.commit();
                        break;
                    case 2:
                        c10_3_ChokingsFragment c10_3_chokingsFragment = new c10_3_ChokingsFragment();
                        ft.replace(R.id.home_fragment_container, c10_3_chokingsFragment);
                        ft.commit();
                        break;
                    case 3:
                        c10_4_BandagesFragment c10_4_bandagesFragment = new c10_4_BandagesFragment();
                        ft.replace(R.id.home_fragment_container, c10_4_bandagesFragment);
                        ft.commit();
                        break;
                    case 4:
                        c10_5_SlingFragment c10_5_slingFragment = new c10_5_SlingFragment();
                        ft.replace(R.id.home_fragment_container, c10_5_slingFragment);
                        ft.commit();
                        break;
                    case 5:
                        c10_9_CirculationFragment c10_9_circulationFragment = new c10_9_CirculationFragment();
                        ft.replace(R.id.home_fragment_container, c10_9_circulationFragment);
                        ft.commit();
                        break;
                    case 6:
                        c10_10_ColdCompressFragment c10_10_coldCompressFragment = new c10_10_ColdCompressFragment();
                        ft.replace(R.id.home_fragment_container, c10_10_coldCompressFragment);
                        ft.commit();
                        break;
                }
            }
        });
        return view;
    }
}