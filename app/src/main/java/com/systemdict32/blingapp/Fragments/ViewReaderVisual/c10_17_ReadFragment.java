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
 * Use the {@link c10_17_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_17_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_17_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_17_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_17_ReadFragment newInstance(String param1, String param2) {
        c10_17_ReadFragment fragment = new c10_17_ReadFragment();
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

    public String firstAidManual = "1. Ask the casualty to support his injured arm across his chest, with the fingers resting on the opposite shoulder. \n" +
            "\n2. Place the bandage over his body, with one end over the shoulder on the uninjured side. Hold the point just beyond his elbow. \n" +
            "\n3. Ask the casualty to let go of his injured arm while you tuck the base of the bandage under his hand, forearm, and elbow. \n" +
            "\n4. Bring the lower end of the bandage up diagonally across his back, to meet the other end at his shoulder. \n" +
            "\n5. Tie the ends in a square knot at the hollow above the casualty’s collarbone. Tuck ends under the knot to pad it. \n" +
            "\n6. Twist the point until the bandage fits closely around the casualty’s elbow. Tuck the point in just above his elbow to secure it. If you have a safety pin, fold the fabric over the elbow and fasten the point at the corner. Check the circulation in the thumb every ten minutes; loosen and reapply if necessary. \n";
    TextView tv_c10_17_first_aid_manual;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c10_17__read, container, false);

        tv_c10_17_first_aid_manual = view.findViewById(R.id.tv_c10_17_first_aid_manual);
        tv_c10_17_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c10_17_first_aid_manual = view.findViewById(R.id.tv_c10_17_first_aid_manual);
        tv_c10_17_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}