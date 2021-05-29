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
 * Use the {@link c10_13_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_13_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_13_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_13_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_13_ReadFragment newInstance(String param1, String param2) {
        c10_13_ReadFragment fragment = new c10_13_ReadFragment();
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

    public String firstAidManual = "1. Place the tail of the bandage on the inner side of the wrist, by the base of the thumb. Make two straight turns around the wrist. \n" +
            "\n2. Working from the inner side of the wrist, pass the bandage diagonally across the back of the hand to the nail of the little finger, and across the front of the casualty’s fingers. \n" +
            "\n3. Pass the bandage diagonally across the back of the hand to the outer side of the wrist. Take the bandage under the wrist. Then repeat the diagonal over the back of the hand. \n" +
            "\n4. Repeat the sequence of figure-eight turns. Extend the bandaging by covering about two-thirds of the bandage from the previous turn with each new layer. When the hand is completely covered, finish with two straight turns around the wrist. \n" +
            "\n5. Secure the end. As soon as you have finished, check the circulation beyond the bandage, then recheck every ten minutes. If necessary, unroll the bandage until the blood supply returns and reapply it more loosely. \n";
    TextView tv_c10_13_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_c10_13__read, container, false);

        tv_c10_13_first_aid_manual = view.findViewById(R.id.tv_c10_13_first_aid_manual);
        tv_c10_13_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c10_13_first_aid_manual = view.findViewById(R.id.tv_c10_13_first_aid_manual);
        tv_c10_13_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}