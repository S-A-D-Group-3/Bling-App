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
 * Use the {@link c8_2_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c8_2_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c8_2_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c8_2_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c8_2_ReadFragment newInstance(String param1, String param2) {
        c8_2_ReadFragment fragment = new c8_2_ReadFragment();
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
    public String firstAidManual = "1. Advise the casualty to put his hands, if affected, in his armpits. Move the casualty into warmth before you thaw the affected part further. \n" +
            "\n2. Once inside, gently remove gloves, rings, and any other constrictions, such as boots. Warm the affected part with your hands, in your lap, or continue to warm them in the casualty’s armpits. Avoid rubbing the affected area because this can damage skin and other tissues. \n" +
            "\n3. Place the affected parts in tepid water, or lower than 104°F (40°C). Dry gently and apply a light dressing of dry gauze bandage. \n" +
            "\n4. Raise the affected limb to reduce swelling. An adult may take the recommended dose of acetaminophen, or her own pain medicine, and a child, the recommended dose of acetaminophen syrup (not aspirin). Take or send the casualty to the hospital. \n";
    View view;
    TextView tv_c8_2_first_aid_manual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_c8_2__read, container, false);

        tv_c8_2_first_aid_manual = view.findViewById(R.id.tv_c8_2_first_aid_manual);
        tv_c8_2_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c8_2_first_aid_manual = view.findViewById(R.id.tv_c8_2_first_aid_manual);
        tv_c8_2_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}