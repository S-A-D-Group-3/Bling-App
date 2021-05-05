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
 * Use the {@link c6_4_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c6_4_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c6_4_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c6_4_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c6_4_ReadFragment newInstance(String param1, String param2) {
        c6_4_ReadFragment fragment = new c6_4_ReadFragment();
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

    public String firstAidManual = "1. Cover the wound with a sterile dressing or large, clean, gauze pad. Apply pressure around the injury to control bleeding; be careful not to press on a protruding bone. \n" +
            "\n2. Carefully place a sterile wound dressing or more clean padding over and around the dressing. \n" +
            "\n3. Secure the dressing and padding with a bandage. Bandage firmly, but not so tightly that it impairs the circulation beyond the bandage. \n" +
            "\n4. Immobilize the injured part as for a closed fracture, and arrange to transport the casualty to the hospital. \n" +
            "\n5. Treat the casualty for shock if necessary. Do not raise the injured leg. Monitor and record vital signs—level of response, breathing, and pulse—while waiting for help to arrive. Check the circulation beyond the bandage every ten minutes. If the circulation is impaired, loosen the bandages. \n";
    TextView tv_c6_4_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c6_4__read, container, false);

        tv_c6_4_first_aid_manual = view.findViewById(R.id.tv_c6_4_first_aid_manual);
        tv_c6_4_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c6_4_first_aid_manual = view.findViewById(R.id.tv_c6_4_first_aid_manual);
        tv_c6_4_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}