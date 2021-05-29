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
import com.systemdict32.blingapp.Fragments.SubCategories.c10_2_CprChildFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_3_CprInfantFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_4_CprCompFragment;
import com.systemdict32.blingapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c10_1_CprFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_1_CprFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_1_CprFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_1_CprFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_1_CprFragment newInstance(String param1, String param2) {
        c10_1_CprFragment fragment = new c10_1_CprFragment();
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

    ListView lv_basic_cpr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c10_1__cpr, container, false);

        lv_basic_cpr = view.findViewById(R.id.lv_basic_cpr);

        ArrayList<String> cprList = new ArrayList<>();
        cprList.add("CPR for Adult");
        cprList.add("CPR for Children");
        cprList.add("CPR for Infant");
        cprList.add("CPR Compression");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, cprList);

        lv_basic_cpr.setAdapter(arrayAdapter);

        lv_basic_cpr.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                        c10_2_CprChildFragment c10_2_cprChildFragment = new c10_2_CprChildFragment();
                        ft.replace(R.id.home_fragment_container, c10_2_cprChildFragment);
                        ft.commit();
                        break;
                    case 2:
                        c10_3_CprInfantFragment c10_3_cprInfantFragment = new c10_3_CprInfantFragment();
                        ft.replace(R.id.home_fragment_container, c10_3_cprInfantFragment);
                        ft.commit();
                        break;
                    case 3:
                        c10_4_CprCompFragment c10_4_cprCompFragment = new c10_4_CprCompFragment();
                        ft.replace(R.id.home_fragment_container, c10_4_cprCompFragment);
                        ft.commit();
                        break;
                }
            }
        });
        return view;
    }
}