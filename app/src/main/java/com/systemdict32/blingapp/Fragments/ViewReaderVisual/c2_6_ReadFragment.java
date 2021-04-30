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
 * Use the {@link c2_6_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c2_6_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c2_6_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c2_6_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c2_6_ReadFragment newInstance(String param1, String param2) {
        c2_6_ReadFragment fragment = new c2_6_ReadFragment();
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

    public String firstAidManual = "1. Cover the wound with a sterile dressing or large clean, nonstick pad, and bandage it in place. \n" +
            "\n2. Raise and support the injured part with a sling and/or bandages. This helps reduce the swelling around the injury. \n" +
            "\n3. Advise the casualty to seek medical advice. \n" +
            "\n4. If infection is advanced with signs of fever, such as sweating, shivering, and lethargy, take or send the casualty to the hospital. \n";
    TextView tv_c2_6_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c2_6__read, container, false);

        tv_c2_6_first_aid_manual = view.findViewById(R.id.tv_c2_6_first_aid_manual);
        tv_c2_6_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c2_6_first_aid_manual = view.findViewById(R.id.tv_c2_6_first_aid_manual);
        tv_c2_6_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}