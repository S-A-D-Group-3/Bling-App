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
 * Use the {@link c1_15_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c1_15_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c1_15_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c1_15_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c1_15_ReadFragment newInstance(String param1, String param2) {
        c1_15_ReadFragment fragment = new c1_15_ReadFragment();
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

    public String firstAidManual = "1. Kneel beside the casualty. Remove his glasses and any bulky objects, such as mobile phones or large bunches of keys, from his pockets. Do not search his pockets for small items. \n" +
            "\n2. Make sure that both of the casualty’s legs are straight. Place the arm that is closest to you at right angles to the casualty’s body, with the elbow bent and the palm facing upward. \n" +
            "\n3. Bring the arm that is farthest from you across the casualty’s chest, and hold the back of his hand against the cheek closest to you. With your other hand, grasp the far leg just above the knee and pull it up, keeping the foot flat on the ground. \n" +
            "\n4. Keeping the casualty’s hand pressed against his cheek, pull on the far leg and roll the casualty toward you and onto his side. \n" +
            "\n5. Adjust the upper leg so that both the hip and the knee are bent at right angles. \n" +
            "\n6. Tilt the casualty’s head back and tilt his chin so that the airway remains open. \n" +
            "\n7. If necessary, adjust the hand under the cheek to keep the airway open. \n" +
            "\n8. If it has not already been done, call for emergency help. Monitor and record vital signs—level of response, breathing, and pulse—while waiting for help to arrive. \n" +
            "\n9. If the casualty has to be left in the recovery position for longer than 30 minutes, roll him onto his back, and then roll him onto the opposite side—unless other injuries prevent you from doing this. \n";
    TextView tv_c1_15_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c1_15__read, container, false);

        tv_c1_15_first_aid_manual = view.findViewById(R.id.tv_c1_15_first_aid_manual);
        tv_c1_15_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c1_15_first_aid_manual = view.findViewById(R.id.tv_c1_15_first_aid_manual);
        tv_c1_15_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}