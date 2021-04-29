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
 * Use the {@link c3_9_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c3_9_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c3_9_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c3_9_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c3_9_ReadFragment newInstance(String param1, String param2) {
        c3_9_ReadFragment fragment = new c3_9_ReadFragment();
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

    public String firstAidManual = "1. Help the casualty sit down and ask her to raise and support the affected wrist and hand; help her if necessary. Treat any bleeding and loosely cover the wound with a sterile dressing or large clean, gauze pad. \n" +
            "\n2. Remove any rings, bracelets, and watch before the hand begins to swell, and keep it raised to minimize swelling. Wrap the hand in soft, nonfluffy padding for extra protection. \n" +
            "\n3. Gently support the affected arm across the casualty’s body by placing it in an elevation sling. To do this, first thing to do, ask the casualty to support his injured arm across his chest, with the fingers resting on the opposite shoulder. Second, place the bandage over his body, with one end over the shoulder on the uninjured side. Hold the point just beyond his elbow. Third, ask the casualty to let go of his injured arm while you tuck the base of the bandage under his hand, forearm, and elbow. Fourth, bring the lower end of the bandage up diagonally across his back, to meet the other end at his shoulder. Fifth, Tie the ends in a square knot at the hollow above the casualty’s collarbone. Tuck ends under the knot to pad it. Sixth, Twist the point until the bandage fits closely around the casualty’s elbow. Tuck the point in just above his elbow to secure it. If you have a safety pin, fold the fabric over the elbow and fasten the point at the corner. Check the circulation in the thumb every ten minutes; loosen and reapply if necessary. \n" +
            "\n4. For extra support, or if the trip to the hospital is likely to be prolonged, secure the arm by tying a broad-fold bandage around the chest and over the sling. If this is needed, first thing to do, open out a triangular bandage and lay it flat on a clean surface. Fold the bandage in half horizontally, so that the point of the triangle touches the center of the base. This keeps it away from the injury. After that, arrange to take or send the casualty to the hospital. \n";
    TextView tv_c3_9_first_aid_manual;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c3_9__read, container, false);

        tv_c3_9_first_aid_manual = view.findViewById(R.id.tv_c3_9_first_aid_manual);
        tv_c3_9_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c3_9_first_aid_manual = view.findViewById(R.id.tv_c3_9_first_aid_manual);
        tv_c3_9_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}