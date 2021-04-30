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
        respiratoryProblemList.add("4. Drowning");
        respiratoryProblemList.add("5. Asthma");
        respiratoryProblemList.add("6. Hyperventilation");
        respiratoryProblemList.add("7. Inhalation of Fumes");
        respiratoryProblemList.add("8. Airway Obstruction");

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, respiratoryProblemList);

        lv_respiratory_problem.setAdapter(adapter);

        lv_respiratory_problem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
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
                }
            }
        });

        return view;
    }
}