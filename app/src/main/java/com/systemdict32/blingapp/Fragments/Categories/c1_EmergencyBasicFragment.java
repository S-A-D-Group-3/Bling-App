package com.systemdict32.blingapp.Fragments.Categories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        woundsList.add("1. Cramps");
        woundsList.add("2. Splinter");
        woundsList.add("3. Fainting");
        woundsList.add("4. Migraine");
        woundsList.add("5. Vomiting");
        woundsList.add("6. Diarrhea");
        woundsList.add("7. Bleeding");
        woundsList.add("8. Sore Throat");
        woundsList.add("9. Abdominal Pain");
        woundsList.add("10. Allergic Reaction");
        woundsList.add("11. Unconscious Adult");
        woundsList.add("12. Unconscious Child");
        woundsList.add("13. Unconscious Infant");


        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, woundsList);

        lv_emergency_basic.setAdapter(arrayAdapter);

        lv_emergency_basic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                }
            }
        });

        return view;
    }
}