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
 * Use the {@link c1_16_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c1_16_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c1_16_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c1_16_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c1_16_ReadFragment newInstance(String param1, String param2) {
        c1_16_ReadFragment fragment = new c1_16_ReadFragment();
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

    public String firstAidManual = "1. Kneel beside the child. Remove her glasses and any bulky objects from her pockets, but do not search pockets for small items. \n" +
            "\n2. Make sure that both of the child’s legs are straight. Place the arm nearest to you at right angles to the child’s body, with the elbow bent and the palm facing upward. \n" +
            "\n3. Bring the arm that is farthest from you across the child’s chest, and hold the back of her hand against the cheek nearest to you. With your other hand, grasp the far leg just above the knee and pull it up, keeping the foot flat on the ground. \n" +
            "\n4. Keeping the child’s hand pressed against her cheek, pull on the far leg and roll the child toward you and onto her side. \n" +
            "\n5. Adjust the upper leg so that both the hip and the knee are bent at right angles. Tilt the child’s head back and lift the chin so that the airway remains open. \n" +
            "\n6. If necessary, adjust the hand under the cheek to make sure that the head remains tilted and the airway stays open. If it has not already been done, call for emergency help. Monitor and record vital signs—level of response, breathing, and pulse—until help arrives. \n" +
            "\n7. If the child has to be left in the recovery position for longer than 30 minutes, you should roll her onto her back, then turn her onto the opposite side—unless other injuries prevent you from doing this. \n";
    TextView tv_c1_16_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c1_16__read, container, false);

        tv_c1_16_first_aid_manual = view.findViewById(R.id.tv_c1_16_first_aid_manual);
        tv_c1_16_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c1_16_first_aid_manual = view.findViewById(R.id.tv_c1_16_first_aid_manual);
        tv_c1_16_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}