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
        woundsList.add("5. Electrecution");
        woundsList.add("6. Epileptic Seizure");
        woundsList.add("7. Seizures in Adults");
        woundsList.add("8. Seizures in Children");
        woundsList.add("9. Emergency Childbirth");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, woundsList);

        lv_serious_incidents.setAdapter(arrayAdapter);

        lv_serious_incidents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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