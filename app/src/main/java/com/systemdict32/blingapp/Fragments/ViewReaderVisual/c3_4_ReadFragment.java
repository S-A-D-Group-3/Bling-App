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
 * Use the {@link c3_4_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c3_4_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c3_4_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c3_4_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c3_4_ReadFragment newInstance(String param1, String param2) {
        c3_4_ReadFragment fragment = new c3_4_ReadFragment();
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

    public String firstAidManual = "1. Help the casualty sit down and ask him to support the arm on the injured side; help him if necessary. For extra support place the arm on the injured side in a sling. To do this, first thing to do, ensure that the injured arm is supported with the hand slightly higher than the elbow. Fold the base of the bandage under to form a hem. Place the bandage with the base parallel to the casualty’s body and level with his little fingernail. Slide the upper end under the injured arm and pull it around the neck to the opposite shoulder. \n" +
            "Second, Fold the lower end of the bandage up over the forearm and bring it to meet the upper end at the shoulder. \n" +
            "Third, Tie a square knot on the injured side, at the hollow above the casualty’s collarbone. Tuck both free ends of the bandage under the knot to pad it. Adjust the sling so that the front edge supports the hand. it should extend to the top of the casualty’s little finger. \n" +
            "Fourth, hold the point of the bandage beyond the elbow and twist it until the fabric fits the elbow snugly, then tuck it in or knot it. Alternatively, if you have a safety pin, fold the fabric and fasten it to the front. \n" +
            "Last, bind the finished sling to the body with another triangular bandage or swathe. As soon as you have finished, check the circulation in the fingers. Recheck every ten minutes. If necessary, loosen and reapply the bandages and sling. \n" +
            "\n2. Arrange to take or send the casualty to the hospital. \n";
    View view;
    TextView tv_c3_4_first_aid_manual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c3_4__read, container, false);

        tv_c3_4_first_aid_manual = view.findViewById(R.id.tv_c3_4_first_aid_manual);

        tv_c3_4_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c3_4_first_aid_manual = view.findViewById(R.id.tv_c3_4_first_aid_manual);
        tv_c3_4_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}