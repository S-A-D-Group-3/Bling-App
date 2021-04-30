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
 * Use the {@link c5_7_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c5_7_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c5_7_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c5_7_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c5_7_ReadFragment newInstance(String param1, String param2) {
        c5_7_ReadFragment fragment = new c5_7_ReadFragment();
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

    public String firstAidManual = "1. Make sure that the area around the casualty is safe. Ventilate the area to disperse fumes. Wear protective gloves to prevent you from coming into contact with the chemical. If it is safe to do so, seal the chemical container. Move the casualty if necessary. If the chemical is in powder form, it can be brushed off the skin. \n" +
            "\n2. Flood the burn with water for at least 20 minutes to disperse the chemical and stop the burning. If treating a casualty lying on the ground, ensure that the contaminated water does not collect underneath her. Pour water away from yourself to avoid being splashed. \n" +
            "\n3. Gently remove any contaminated clothing while flooding the injury. \n" +
            "\n4. Arrange to take or send the casualty to the hospital. Monitor vital signs—level of response, breathing, and pulse—while waiting for medical help. Pass on details of the chemical to medical staff if you can identify it. \n";
    View view;
    TextView tv_c5_7_first_aid_manual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c5_7__read, container, false);

        tv_c5_7_first_aid_manual = view.findViewById(R.id.tv_c5_7_first_aid_manual);
        tv_c5_7_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c5_7_first_aid_manual = view.findViewById(R.id.tv_c5_7_first_aid_manual);
        tv_c5_7_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}