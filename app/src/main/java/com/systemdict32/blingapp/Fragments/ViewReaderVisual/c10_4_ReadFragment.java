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
 * Use the {@link c10_4_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_4_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_4_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_4_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_4_ReadFragment newInstance(String param1, String param2) {
        c10_4_ReadFragment fragment = new c10_4_ReadFragment();
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
    String firstAidManual = "1. Check for a response. Gently shake the casualty’s shoulders and talk to him. Assess breathing; if casualty is not breathing or only gasping, go to the next step. \n" +
            "\n2. Kneel level with the casualty's chest. Put one hand on the center of the chest and the heel of your other hand on top; interlock your fingers. Depress chest at least 2 in (5 cm), and release but keep your hands in place. Do compressions at a rate of 100 per minute. \n" +
            "\n3. Give chest compressions until emergency help arrives; the casualty shows signs of regaining consciousness, such as coughing, opening his eyes, speaking, or moving purposefully, and starts to breathe normally; or you are too exhausted to continue. \n";
    TextView tv_c10_4_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c10_4__read, container, false);

        tv_c10_4_first_aid_manual = view.findViewById(R.id.tv_c10_4_first_aid_manual);
        tv_c10_4_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c10_4_first_aid_manual = view.findViewById(R.id.tv_c10_4_first_aid_manual);
        tv_c10_4_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}