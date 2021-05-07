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

import com.systemdict32.blingapp.Fragments.SubCategories.c3_10_FootInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c3_1_HeadInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c3_2_ShoulderInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c3_3_ElbowInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c3_4_RibInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c3_5_KneeInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c3_6_AnkleInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c3_7_NoseInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c3_8_FacialInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c3_9_HandInjuryFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c3_BodyInjuriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c3_BodyInjuriesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c3_BodyInjuriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c3_BodyInjuriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c3_BodyInjuriesFragment newInstance(String param1, String param2) {
        c3_BodyInjuriesFragment fragment = new c3_BodyInjuriesFragment();
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

    ListView lv_body_injuries;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c3__body_injuries, container, false);

        lv_body_injuries = view.findViewById(R.id.lv_body_injuries);

        ArrayList<String> respiratoryProblemList = new ArrayList<>();

        respiratoryProblemList.add("1. Head Injury");
        respiratoryProblemList.add("2. Shoulder Injury");
        respiratoryProblemList.add("3. Elbow Injury");
        respiratoryProblemList.add("4. Rib Injury");
        respiratoryProblemList.add("5. Knee Injury");
        respiratoryProblemList.add("6. Ankle Injury");
        respiratoryProblemList.add("7. Nose Injury");
        respiratoryProblemList.add("8. Facial Injury");
        respiratoryProblemList.add("9. Hand Injury");
        respiratoryProblemList.add("10. Foot Injury");

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, respiratoryProblemList);

        lv_body_injuries.setAdapter(adapter);

        lv_body_injuries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("instruction_sub_category");
                switch (position) {
                    case 0:
                        c3_1_HeadInjuryFragment c3_1_headInjuryFragment = new c3_1_HeadInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c3_1_headInjuryFragment);
                        ft.commit();
                        break;
                    case 1:
                        c3_2_ShoulderInjuryFragment c3_2_shoulderInjuryFragment = new c3_2_ShoulderInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c3_2_shoulderInjuryFragment);
                        ft.commit();
                        break;
                    case 2:
                        c3_3_ElbowInjuryFragment c3_3_elbowInjuryFragment = new c3_3_ElbowInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c3_3_elbowInjuryFragment);
                        ft.commit();
                        break;
                    case 3:
                        c3_4_RibInjuryFragment c3_4_ribInjuryFragment = new c3_4_RibInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c3_4_ribInjuryFragment);
                        ft.commit();
                        break;
                    case 4:
                        c3_5_KneeInjuryFragment c3_5_kneeInjuryFragment = new c3_5_KneeInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c3_5_kneeInjuryFragment);
                        ft.commit();
                        break;
                    case 5:
                        c3_6_AnkleInjuryFragment c3_6_ankleInjuryFragment = new c3_6_AnkleInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c3_6_ankleInjuryFragment);
                        ft.commit();
                        break;
                    case 6:
                        c3_7_NoseInjuryFragment c3_7_noseInjuryFragment = new c3_7_NoseInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c3_7_noseInjuryFragment);
                        ft.commit();
                        break;
                    case 7:
                        c3_8_FacialInjuryFragment c3_8_facialInjuryFragment = new c3_8_FacialInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c3_8_facialInjuryFragment);
                        ft.commit();
                        break;
                    case 8:
                        c3_9_HandInjuryFragment c3_9_handInjuryFragment = new c3_9_HandInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c3_9_handInjuryFragment);
                        ft.commit();
                        break;
                    case 9:
                        c3_10_FootInjuryFragment c3_10_footInjuryFragment = new c3_10_FootInjuryFragment();
                        ft.replace(R.id.home_fragment_container, c3_10_footInjuryFragment);
                        ft.commit();
                        break;
                }
            }
        });

        return view;
    }
}