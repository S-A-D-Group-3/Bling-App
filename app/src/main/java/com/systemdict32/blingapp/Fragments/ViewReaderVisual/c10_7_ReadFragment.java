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
 * Use the {@link c10_7_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_7_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_7_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_7_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_7_ReadFragment newInstance(String param1, String param2) {
        c10_7_ReadFragment fragment = new c10_7_ReadFragment();
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

    public String firstAidManual = "\tEach heartbeat creates a wave of pressure as blood is pumped along the arteries. Where arteries lie close to the skin surface, such as on the inside of the wrist and at the neck, this pressure wave can be felt as a pulse. The normal pulse rate in adults is 60–100 beats per minute. The rate is faster in children and may be slower in very fit adults. An abnormally fast or slow pulse may be a sign of illness. The pulse may be felt at the wrist (radial pulse), or if this is not possible, the neck (carotid pulse). In babies, the pulse in the upper arm (brachial pulse) is easier to find. When checking a pulse, use your fingers (not your thumb) and press lightly against the skin. Record the following points. \n" +
            "\nRate (number of beats per minute). \n" +
            "\nStrength (strong or weak). \n" +
            "\nRhythm (regular or irregular). \n";
    TextView tv_c10_7_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_c10_7__read, container, false);

        tv_c10_7_first_aid_manual = view.findViewById(R.id.tv_c10_7_first_aid_manual);
        tv_c10_7_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c10_7_first_aid_manual = view.findViewById(R.id.tv_c10_7_first_aid_manual);
        tv_c10_7_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}