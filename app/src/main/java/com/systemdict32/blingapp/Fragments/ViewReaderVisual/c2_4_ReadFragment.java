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
 * Use the {@link c2_4_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c2_4_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c2_4_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c2_4_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c2_4_ReadFragment newInstance(String param1, String param2) {
        c2_4_ReadFragment fragment = new c2_4_ReadFragment();
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

    public String firstAidManual = "1. If the wound to the finger breaks the skin, it should be cleaned with soap and water like any other abrasion. \n" +
            "\n2. Press a sterile dressing or clean gauze pad on the wound and apply direct pressure to control bleeding. \n" +
            "\n3. Raise and support the injured hand and maintain pressure on the wound until the bleeding stops. \n" +
            "\n4. When the bleeding has stopped, cover the wound to protect it. \n" +
            "\n5. Use an adhesive dressing or for a larger wound apply a dressing pad, secured with a tubular gauze bandage. If there is a fracture or dislocation, the finger should be splinted. \n" +
            "\n6. Seek medical help if necessary. If you need to take the casualty to the hospital, support the injured arm in an elevation sling. \n";
    TextView tv_c2_4_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c2_4__read, container, false);

        tv_c2_4_first_aid_manual = view.findViewById(R.id.tv_c2_4_first_aid_manual);
        tv_c2_4_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c2_4_first_aid_manual = view.findViewById(R.id.tv_c2_4_first_aid_manual);
        tv_c2_4_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}