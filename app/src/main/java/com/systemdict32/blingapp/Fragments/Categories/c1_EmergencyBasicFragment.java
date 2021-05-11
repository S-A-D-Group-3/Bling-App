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

import com.systemdict32.blingapp.Fragments.SubCategories.c1_10_NoseBleedFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_11_MouthBleedFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_12_SoreThroatFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_13_AbdominalPainFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_14_AllergicReactionFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_15_UnconciousAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_16_UnconciousChildFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_17_UnconciousInfantFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_1_CrampFootFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_2_CrampCalfFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_3_CrampFrontThighFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_4_CrampBackThighFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_5_SplinterFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_6_FaintingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_7_MigraineFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_8_VomitingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_9_EarBleedFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c2_1_BlistersFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c1_EmergencyBasicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c1_EmergencyBasicFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c1_EmergencyBasicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c1_EmergencyBasicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c1_EmergencyBasicFragment newInstance(String param1, String param2) {
        c1_EmergencyBasicFragment fragment = new c1_EmergencyBasicFragment();
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

    ListView lv_emergency_basic;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c1__emergency_basic, container, false);

        lv_emergency_basic = view.findViewById(R.id.lv_emergency_basic);

        ArrayList<String> woundsList = new ArrayList<>();

        woundsList.add("1. Cramp in the Foot");
        woundsList.add("2. Cramp in the Calf Muscles");
        woundsList.add("3. Cramp in the Front of the Thigh");
        woundsList.add("4. Cramp in the Back of the Thigh");
        woundsList.add("5. Splinter");
        woundsList.add("6. Fainting");
        woundsList.add("7. Migraine");
        woundsList.add("8. Vomiting and Diarrhea");
        woundsList.add("9. Bleeding from the Ear");
        woundsList.add("10. Nosebleed");
        woundsList.add("11. Bleeding from the Mouth");
        woundsList.add("12. Sore Throat");
        woundsList.add("13. Abdominal Pain");
        woundsList.add("14. Allergic Reaction");
        woundsList.add("15. Unconscious Adult");
        woundsList.add("16. Unconscious Child");
        woundsList.add("17. Unconscious Infant");


        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, woundsList);

        lv_emergency_basic.setAdapter(arrayAdapter);

        lv_emergency_basic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("nav_home");
                switch (position) {
                    case 0:
                        c1_1_CrampFootFragment c1_1_crampFootFragment = new c1_1_CrampFootFragment();
                        ft.replace(R.id.home_fragment_container, c1_1_crampFootFragment);
                        ft.commit();
                        break;
                    case 1:
                        c1_2_CrampCalfFragment c1_2_crampCalfFragment = new c1_2_CrampCalfFragment();
                        ft.replace(R.id.home_fragment_container, c1_2_crampCalfFragment);
                        ft.commit();
                        break;
                    case 2:
                        c1_3_CrampFrontThighFragment c1_3_crampFrontThighFragment = new c1_3_CrampFrontThighFragment();
                        ft.replace(R.id.home_fragment_container, c1_3_crampFrontThighFragment);
                        ft.commit();
                        break;
                    case 3:
                        c1_4_CrampBackThighFragment c1_4_crampBackThighFragment = new c1_4_CrampBackThighFragment();
                        ft.replace(R.id.home_fragment_container, c1_4_crampBackThighFragment);
                        ft.commit();
                        break;
                    case 4:
                        c1_5_SplinterFragment c1_5_splinterFragment = new c1_5_SplinterFragment();
                        ft.replace(R.id.home_fragment_container, c1_5_splinterFragment);
                        ft.commit();
                        break;
                    case 5:
                        c1_6_FaintingFragment c1_6_faintingFragment = new c1_6_FaintingFragment();
                        ft.replace(R.id.home_fragment_container, c1_6_faintingFragment);
                        ft.commit();
                        break;
                    case 6:
                        c1_7_MigraineFragment c1_7_migraineFragment = new c1_7_MigraineFragment();
                        ft.replace(R.id.home_fragment_container, c1_7_migraineFragment);
                        ft.commit();
                        break;
                    case 7:
                        c1_8_VomitingFragment c1_8_vomitingFragment = new c1_8_VomitingFragment();
                        ft.replace(R.id.home_fragment_container, c1_8_vomitingFragment);
                        ft.commit();
                        break;
                    case 8:
                        c1_9_EarBleedFragment c1_9_earBleedFragment = new c1_9_EarBleedFragment();
                        ft.replace(R.id.home_fragment_container, c1_9_earBleedFragment);
                        ft.commit();
                        break;
                    case 9:
                        c1_10_NoseBleedFragment c1_10_noseBleedFragment = new c1_10_NoseBleedFragment();
                        ft.replace(R.id.home_fragment_container, c1_10_noseBleedFragment);
                        ft.commit();
                        break;
                    case 10:
                        c1_11_MouthBleedFragment c1_11_MouthBleedFragment = new c1_11_MouthBleedFragment();
                        ft.replace(R.id.home_fragment_container, c1_11_MouthBleedFragment);
                        ft.commit();
                        break;
                    case 11:
                        c1_12_SoreThroatFragment c1_12_soreThroatFragment = new c1_12_SoreThroatFragment();
                        ft.replace(R.id.home_fragment_container, c1_12_soreThroatFragment);
                        ft.commit();
                        break;
                    case 12:
                        c1_13_AbdominalPainFragment c1_13_abdominalPainFragment = new c1_13_AbdominalPainFragment();
                        ft.replace(R.id.home_fragment_container, c1_13_abdominalPainFragment);
                        ft.commit();
                        break;
                    case 13:
                        c1_14_AllergicReactionFragment c1_14_allergicReactionFragment = new c1_14_AllergicReactionFragment();
                        ft.replace(R.id.home_fragment_container, c1_14_allergicReactionFragment);
                        ft.commit();
                        break;
                    case 14:
                        c1_15_UnconciousAdultFragment c1_15_unconciousAdultFragment = new c1_15_UnconciousAdultFragment();
                        ft.replace(R.id.home_fragment_container, c1_15_unconciousAdultFragment);
                        ft.commit();
                        break;
                    case 15:
                        c1_16_UnconciousChildFragment c1_16_unconciousChildFragment = new c1_16_UnconciousChildFragment();
                        ft.replace(R.id.home_fragment_container, c1_16_unconciousChildFragment);
                        ft.commit();
                        break;
                    case 16:
                        c1_17_UnconciousInfantFragment c1_17_unconciousInfantFragment = new c1_17_UnconciousInfantFragment();
                        ft.replace(R.id.home_fragment_container, c1_17_unconciousInfantFragment);
                        ft.commit();
                        break;
                }
            }
        });

        return view;
    }
}