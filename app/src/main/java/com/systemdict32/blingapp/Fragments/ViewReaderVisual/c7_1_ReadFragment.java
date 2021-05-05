package com.systemdict32.blingapp.Fragments.ViewReaderVisual;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.systemdict32.blingapp.Interfaces.FirstAidInterface;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c7_1_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c7_1_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c7_1_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c7_1_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c7_1_ReadFragment newInstance(String param1, String param2) {
        c7_1_ReadFragment fragment = new c7_1_ReadFragment();
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

    public String firstAidManual = "1. If the casualty is breathing, encourage him/her to continue coughing. If she is not coughing and not able to breathe, she is choking. Proceed to next step. \n" +
            "\n2. Stand behind the casualty with one leg back and the other between the casualty’s legs and put both arms around the upper part of her abdomen. \n" +
            "\n3. Clench your fist with your thumb on top of your index finger and place it between the navel and the bottom of her breastbone. \n" +
            "\n4. Grasp your fist firmly with your other hand, thrust sharply inward and upward until the object is dislodged or the casualty becomes unconscious. \n" +
            "\n5. If the casualty loses consciousness, carefully support her to the floor, immediately call for emergency help or send someone to do so, then begin CPR with chest compressions. \n" +
            "\n6. Each time the airway is opened during CPR, look for an object in the casualty's mouth and, if seen, remove it. \n" +
            "\n7. If the obstruction still has not cleared, continue CPR until help arrives. \n";
    TextView tv_c7_1_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c7_1__read, container, false);

        tv_c7_1_first_aid_manual = view.findViewById(R.id.tv_c7_1_first_aid_manual);
        tv_c7_1_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c7_1_first_aid_manual = view.findViewById(R.id.tv_c7_1_first_aid_manual);
        tv_c7_1_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}