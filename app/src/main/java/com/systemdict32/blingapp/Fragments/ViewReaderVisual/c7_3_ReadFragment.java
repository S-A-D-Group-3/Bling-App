package com.systemdict32.blingapp.Fragments.ViewReaderVisual;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.systemdict32.blingapp.Interfaces.FirstAidInterface;
import com.systemdict32.blingapp.Interfaces.ToggleReadVisualInterface;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c7_3_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c7_3_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c7_3_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c7_3_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c7_3_ReadFragment newInstance(String param1, String param2) {
        c7_3_ReadFragment fragment = new c7_3_ReadFragment();
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

    public String firstAidManual = "1. If the infant is distressed, is unable to cry, cough, or breathe, lay him face down along your forearm, with his head low, and support his back and head. \n" +
            "\n2. Give up to five back blows, with the heel of your hand. \n" +
            "\n3. If back blows fail to clear the obstruction, turn the infant onto his back and give chest compressions. \n" +
            "\n4. Using two fingers, push against the infant’s breastbone, in the nipple line. \n" +
            "\n5. Perform up to five chest compressions. The aim is to relieve the obstruction with each chest compression rather than necessarily doing all five. \n" +
            "\n6. Check the infant’s mouth; remove any obvious obstructions with your fingertips. Do not sweep the mouth with your finger because this may push the object farther down the throat. \n" +
            "\n7. Repeat steps 1–6 until the object clears or the infant loses consciousness. \n" +
            "\n8. If the obstruction has not cleared and he becomes unconscious, call for emergency help, then start CPR with chest compressions. Continue until help arrives. \n";
    View view;
    TextView tv_c7_3_first_aid_manual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c7_3__read, container, false);

        tv_c7_3_first_aid_manual = view.findViewById(R.id.tv_c7_3_first_aid_manual);
        tv_c7_3_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c7_3_first_aid_manual = view.findViewById(R.id.tv_c7_3_first_aid_manual);
        tv_c7_3_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}