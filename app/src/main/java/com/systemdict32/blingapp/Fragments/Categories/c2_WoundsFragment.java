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
import com.systemdict32.blingapp.Fragments.SubCategories.c2_2_BruisingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c2_3_EyeWoundFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c2_4_FingerWoundFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c2_5_HeadWoundsFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c2_6_InfectedWoundFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c2_7_AbdominalWoundFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c2_8_CutAndScrapesFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c2_9_ForeignObjectsFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c3_1_HeadInjuryFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c2_WoundsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c2_WoundsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c2_WoundsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c2_WoundsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c2_WoundsFragment newInstance(String param1, String param2) {
        c2_WoundsFragment fragment = new c2_WoundsFragment();
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

    ListView lv_wounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c2__wounds, container, false);

        lv_wounds = view.findViewById(R.id.lv_wounds);

        ArrayList<String> woundsList = new ArrayList<>();

        woundsList.add("1. Blisters");
        woundsList.add("2. Bruising");
        woundsList.add("3. Eye Wound");
        woundsList.add("4. Finger Wound");
        woundsList.add("5. Head Wounds");
        woundsList.add("6. Infected Wound");
        woundsList.add("7. Abdominal Wound");
        woundsList.add("8. Cut and Scrapes");
        woundsList.add("9. Foreign Objects");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, woundsList);

        lv_wounds.setAdapter(arrayAdapter);

        lv_wounds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("nav_home");

                switch (position) {
                    case 0:
                        c2_1_BlistersFragment c2_1_blistersFragment = new c2_1_BlistersFragment();
                        ft.replace(R.id.home_fragment_container, c2_1_blistersFragment);
                        ft.commit();
                        break;
                    case 1:
                        c2_2_BruisingFragment c2_2_bruisingFragment = new c2_2_BruisingFragment();
                        ft.replace(R.id.home_fragment_container, c2_2_bruisingFragment);
                        ft.commit();
                        break;
                    case 2:
                        c2_3_EyeWoundFragment c2_3_eyeWoundFragment = new c2_3_EyeWoundFragment();
                        ft.replace(R.id.home_fragment_container, c2_3_eyeWoundFragment);
                        ft.commit();
                        break;
                    case 3:
                        c2_4_FingerWoundFragment c2_4_fingerWoundFragment = new c2_4_FingerWoundFragment();
                        ft.replace(R.id.home_fragment_container, c2_4_fingerWoundFragment);
                        ft.commit();
                        break;
                    case 4:
                        c2_5_HeadWoundsFragment c2_5_headWoundsFragment = new c2_5_HeadWoundsFragment();
                        ft.replace(R.id.home_fragment_container, c2_5_headWoundsFragment);
                        ft.commit();
                        break;
                    case 5:
                        c2_6_InfectedWoundFragment c2_6_infectedWoundFragment = new c2_6_InfectedWoundFragment();
                        ft.replace(R.id.home_fragment_container, c2_6_infectedWoundFragment);
                        ft.commit();
                        break;
                    case 6:
                        c2_7_AbdominalWoundFragment c2_7_abdominalWoundFragment = new c2_7_AbdominalWoundFragment();
                        ft.replace(R.id.home_fragment_container, c2_7_abdominalWoundFragment);
                        ft.commit();
                        break;
                    case 7:
                        c2_8_CutAndScrapesFragment c2_8_cutAndScrapesFragment = new c2_8_CutAndScrapesFragment();
                        ft.replace(R.id.home_fragment_container, c2_8_cutAndScrapesFragment);
                        ft.commit();
                        break;
                    case 8:
                        c2_9_ForeignObjectsFragment c2_9_foreignObjectsFragment = new c2_9_ForeignObjectsFragment();
                        ft.replace(R.id.home_fragment_container, c2_9_foreignObjectsFragment);
                        ft.commit();
                        break;
                }
            }
        });
        return view;
    }
}