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
 * Use the {@link c10_12_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_12_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_12_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_12_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_12_ReadFragment newInstance(String param1, String param2) {
        c10_12_ReadFragment fragment = new c10_12_ReadFragment();
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

    public String firstAidManual = "1. Support the injured limb in a comfortable position for the casualty, with the joint partially flexed. Place the tail of the bandage on the inner side of the joint. Pass the bandage over and around to the outside of the joint. Make one-and-a-half turns, so that the tail end of the bandage is fixed and the joint is covered. \n" +
            "\n2. Pass the bandage to the inner side of the limb, just above the joint. Make a turn around the limb, covering the upper half of the bandage from the first turn. \n" +
            "\n3. Pass the bandage from the inner side of the upper limb to just below the joint. Make one diagonal turn below the elbow joint to cover the lower half of the bandaging from the first straight turn. \n" +
            "\n4. Continue to bandage diagonally above and below the joint in a figure-eight. Increase the bandaged area by covering about two-thirds of the previous turn with each new layer. \n" +
            "\n5. To finish bandaging the joint, make two straight turns around the limb, then secure the end of the bandage. Check the circulation beyond the bandage as soon as you have finished, then recheck every ten minutes. If necessary, unroll the bandage and reapply more loosely. \n";
    TextView tv_c10_12_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c10_12__read, container, false);

        tv_c10_12_first_aid_manual = view.findViewById(R.id.tv_c10_12_first_aid_manual);
        tv_c10_12_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c10_12_first_aid_manual = view.findViewById(R.id.tv_c10_12_first_aid_manual);
        tv_c10_12_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}