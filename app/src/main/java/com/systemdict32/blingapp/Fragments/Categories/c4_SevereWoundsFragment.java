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
 * Use the {@link c4_SevereWoundsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c4_SevereWoundsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c4_SevereWoundsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c4_SevereWoundsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c4_SevereWoundsFragment newInstance(String param1, String param2) {
        c4_SevereWoundsFragment fragment = new c4_SevereWoundsFragment();
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

    ListView lv_severe_wounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_c4__severe_wounds, container, false);

        lv_severe_wounds = view.findViewById(R.id.lv_severe_wounds);

        ArrayList<String> woundsList = new ArrayList<>();

        woundsList.add("1. Internal Bleeding");
        woundsList.add("2. External Bleeding");
        woundsList.add("3. Impalement");
        woundsList.add("4. Amputation");
        woundsList.add("5. Crush Injury");
        woundsList.add("6. Fractures");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, woundsList);

        lv_severe_wounds.setAdapter(arrayAdapter);

        lv_severe_wounds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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