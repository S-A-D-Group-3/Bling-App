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
 * Use the {@link c6_3_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c6_3_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c6_3_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c6_3_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c6_3_ReadFragment newInstance(String param1, String param2) {
        c6_3_ReadFragment fragment = new c6_3_ReadFragment();
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

    public String firstAidManual = "1. Advise the casualty to keep still. Support the joints above and below the injury with your hands until it is immobilized with a sling or bandages, in the position in which it is found. \n" +
            "\n2. Place padding around the injury for extra support. Take or send the casualty to the hospital; a casualty with an arm injury may be transported by car; call for emergency help for a leg injury. \n" +
            "\n3. For firmer support and/or if removal to the hospital is likely to be delayed, secure the injured part to an unaffected part of the body. For upper limb fractures, immobilize the arm with a sling. To do this; first thing to do, ensure that the injured arm is supported with the hand slightly higher than the elbow. Fold the base of the bandage under to form a hem. Place the bandage with the base parallel to the casualty’s body and level with his little fingernail. Slide the upper end under the injured arm and pull it around the neck to the opposite shoulder. Second, Fold the lower end of the bandage up over the forearm and bring it to meet the upper end at the shoulder. Third, Tie a square knot on the injured side, at the hollow above the casualty’s collarbone. Tuck both free ends of the bandage under the knot to pad it. Adjust the sling so that the front edge supports the hand. it should extend to the top of the casualty’s little finger. Fourth, hold the point of the bandage beyond the elbow and twist it until the fabric fits the elbow snugly, then tuck it in or knot it. Alternatively, if you have a safety pin, fold the fabric and fasten it to the front. Last, bind the finished sling to the body with another triangular bandage or swathe. As soon as you have finished, check the circulation in the fingers. Recheck every ten minutes. If necessary, loosen and reapply the bandages and sling. For lower limb fractures, move the uninjured leg to the injured one and secure with broad-fold bandages. To do This; First, open out a triangular bandage and lay it flat on a clean surface. Fold the bandage in half horizontally, so that the point of the triangle touches the center of the base. Second, fold the bandage in half again in the same direction, so that the first folded edge touches the base. The bandage should now form a broad strip. After that, always tie knots on the uninjured side. \n" +
            "\n4. Treat for shock if necessary. Do not raise an injured leg. Elevate an uninjured limb if shock is present. Monitor and record vital signs while waiting for help. Check the circulation beyond a sling or bandage every ten minutes. If the circulation is impaired, loosen the bandages. \n";
    View view;
    TextView tv_c6_3_first_aid_manual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c6_3__read, container, false);

        tv_c6_3_first_aid_manual = view.findViewById(R.id.tv_c6_3_first_aid_manual);
        tv_c6_3_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c6_3_first_aid_manual = view.findViewById(R.id.tv_c6_3_first_aid_manual);
        tv_c6_3_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}