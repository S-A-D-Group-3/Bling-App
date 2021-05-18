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
 * Use the {@link c10_1_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_1_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_1_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_1_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_1_ReadFragment newInstance(String param1, String param2) {
        c10_1_ReadFragment fragment = new c10_1_ReadFragment();
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

    public String firstAidManual = "1. Position hands on chest. Place one hand on the center of the casualty’s chest. Place the heel of your other hand on top of the first and interlock your fingers but keep your fingers off the casualty’s ribs. \n" +
            "\n2. Lean directly over the casualty’s chest and press down vertically at least 2 in (5 cm). Release the pressure, but do not remove your hands. Give 30 compressions at a rate of at least 100 per minute. \n" +
            "\n3. Pinch the casualty’s nose firmly to close the nostrils, and allow his mouth to fall open. Take a breath and seal your lips over the casualty’s mouth. Blow steadily into the mouth until the chest rises—this should take about one second. \n" +
            "\n4. Maintaining Head tilt and chin lift, take your moth away from the casualty’s. Look along the chest and watch it fall. Repeat to give TWO rescue Breaths. Repeat 30 chest compressions followed by TWO rescue breaths. \n" +
            "\n5. Continue CPR until emergency help arrives, the casualty starts to breath normally, or you are too exhausted to continue. If you are unwilling or unable to give rescue breaths, you can give chest compression alone. \n";
    TextView tv_c10_1_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c10_1__read, container, false);

        tv_c10_1_first_aid_manual = view.findViewById(R.id.tv_c10_1_first_aid_manual);
        tv_c10_1_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c10_1_first_aid_manual = view.findViewById(R.id.tv_c10_1_first_aid_manual);
        tv_c10_1_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}