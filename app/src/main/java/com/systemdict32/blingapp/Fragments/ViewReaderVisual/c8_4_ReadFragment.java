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
 * Use the {@link c8_4_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c8_4_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c8_4_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c8_4_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c8_4_ReadFragment newInstance(String param1, String param2) {
        c8_4_ReadFragment fragment = new c8_4_ReadFragment();
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

    public String firstAidManual = "1. Take the casualty to a sheltered place as quickly as possible. Shield the casualty from the wind. \n" +
            "\n2. Remove and replace any wet clothing if possible; do not give him your clothes. Make sure his head is covered. \n" +
            "\n3. Protect the casualty from the ground. Lay him on a thick layer of dry insulating material, such as pine branches. Put him in a dry sleeping bag and/or cover him with blankets or newspapers. Wrap him in a plastic or foil survival bag, if available. You can shelter and warm him with your body. \n" +
            "\n4. Call for emergency help. Ideally, two people should go for help and stay together if you are in a remote area. It is important that you do not leave the casualty by himself; someone must remain with him at all times. \n" +
            "\n5. To help rewarm a casualty who is conscious, give him warm drinks and high-energy foods such as chocolate, if available. \n" +
            "\n6. Monitor and record the casualty’s vital signs—level of response, breathing, pulse, and temperature—while waiting for help to arrive. \n";
    View view;
    TextView tv_c8_4_first_aid_manual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c8_4__read, container, false);

        tv_c8_4_first_aid_manual = view.findViewById(R.id.tv_c8_4_first_aid_manual);
        tv_c8_4_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c8_4_first_aid_manual = view.findViewById(R.id.tv_c8_4_first_aid_manual);
        tv_c8_4_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}