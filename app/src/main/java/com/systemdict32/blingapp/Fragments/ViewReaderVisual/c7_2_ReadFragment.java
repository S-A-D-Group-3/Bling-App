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
 * Use the {@link c7_2_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c7_2_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c7_2_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c7_2_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c7_2_ReadFragment newInstance(String param1, String param2) {
        c7_2_ReadFragment fragment = new c7_2_ReadFragment();
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

    public String firstAidManual = "1. If the child is breathing, encourage her to continue coughing. If she is not coughing and not able to breathe, she is choking. Proceed to next step. \n" +
            "\n2. Put your arms around the child’s upper abdomen. \n" +
            "\n3. Place your fist between the navel and the bottom of her breastbone and grasp it with your other hand. \n" +
            "\n4. Pull sharply inward and upward until the object is dislodged or the child becomes unconscious. \n" +
            "\n5. if the child becomes unresponsive, carefully support her to the ground and start CPR with chest compressions. \n" +
            "\n6. After 30 compressions, open the airway and look in her mouth. If a foreign body is seen, remove it but do not perform blind finger sweeps. Then attempt to give two breaths and continue with cycles of chest compressions and ventilation until the object is expelled. \n" +
            "\n7. After two minutes, if no one has already done so, the obstruction still has not cleared or the child has not regained consciousness, call for emergency help. Then continue CPR until help arrives. \n";
    View view;
    TextView tv_c7_2_first_aid_manual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c7_2__read, container, false);

        tv_c7_2_first_aid_manual = view.findViewById(R.id.tv_c7_2_first_aid_manual);
        tv_c7_2_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c7_2_first_aid_manual = view.findViewById(R.id.tv_c7_2_first_aid_manual);
        tv_c7_2_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}