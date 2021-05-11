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

import com.systemdict32.blingapp.Fragments.SubCategories.c5_2_DrowningFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c6_1_SevereBurnFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_1_ChokingAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_2_ChokingChildFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_3_ChokingInfantFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_4_HangingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_5_InhalationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_6_HyperventilationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_7_AsthmaFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_8_CroupFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_9_ChestWoundFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c7_RespiratoryProblemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c7_RespiratoryProblemFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c7_RespiratoryProblemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c1_RespiratoryProblemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c7_RespiratoryProblemFragment newInstance(String param1, String param2) {
        c7_RespiratoryProblemFragment fragment = new c7_RespiratoryProblemFragment();
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

    ListView lv_respiratory_problem;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c7__respiratory_problem, container, false);

        lv_respiratory_problem = view.findViewById(R.id.lv_respiratory_problem);

        ArrayList<String> respiratoryProblemList = new ArrayList<>();

        respiratoryProblemList.add("1. Choking Adult");
        respiratoryProblemList.add("2. Choking Child");
        respiratoryProblemList.add("3. Choking Infant");
        respiratoryProblemList.add("4. Hanging and Strangulation");
        respiratoryProblemList.add("5. Inhalation of Fumes");
        respiratoryProblemList.add("6. Drowning");
        respiratoryProblemList.add("7. Hyperventilation");
        respiratoryProblemList.add("8. Asthma");
        respiratoryProblemList.add("9. Croup");
        respiratoryProblemList.add("10. Penetrating Chest Wound");

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, respiratoryProblemList);

        lv_respiratory_problem.setAdapter(adapter);

        lv_respiratory_problem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack("nav_home");
                switch(position) {
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
                    case 3:
                        c7_4_HangingFragment c7_4_hangingFragment = new c7_4_HangingFragment();
                        ft.replace(R.id.home_fragment_container, c7_4_hangingFragment);
                        ft.commit();
                        break;
                    case 4:
                        c7_5_InhalationFragment c7_5_inhalationFragment = new c7_5_InhalationFragment();
                        ft.replace(R.id.home_fragment_container, c7_5_inhalationFragment);
                        ft.commit();
                        break;
                    case 5:
                        c5_2_DrowningFragment c5_2_drowningFragment = new c5_2_DrowningFragment();
                        ft.replace(R.id.home_fragment_container, c5_2_drowningFragment);
                        ft.commit();
                        break;
                    case 6:
                        c7_6_HyperventilationFragment c7_6_hyperventilationFragment = new c7_6_HyperventilationFragment();
                        ft.replace(R.id.home_fragment_container, c7_6_hyperventilationFragment);
                        ft.commit();
                        break;
                    case 7:
                        c7_7_AsthmaFragment c7_7_asthmaFragment = new c7_7_AsthmaFragment();
                        ft.replace(R.id.home_fragment_container, c7_7_asthmaFragment);
                        ft.commit();
                        break;
                    case 8:
                        c7_8_CroupFragment c7_8_croupFragment = new c7_8_CroupFragment();
                        ft.replace(R.id.home_fragment_container, c7_8_croupFragment);
                        ft.commit();
                        break;
                    case 9:
                        c7_9_ChestWoundFragment c7_9_chestWoundFragment = new c7_9_ChestWoundFragment();
                        ft.replace(R.id.home_fragment_container, c7_9_chestWoundFragment);
                        ft.commit();
                        break;
                }
            }
        });

        return view;
    }
}