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
 * Use the {@link c3_2_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c3_2_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c3_2_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c3_2_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c3_2_ReadFragment newInstance(String param1, String param2) {
        c3_2_ReadFragment fragment = new c3_2_ReadFragment();
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
    public String firstAidManual = "1. Help the casualty sit down. Gently place the arm on the injured side across her body in the position that is most comfortable. Ask the casualty to support her elbow on the injured side, or help her do it. \n" +
            "\n2. Support the arm on the injured side with an arm sling. \n" +
            "\n3. For extra support if necessary, secure the arm to the chest by tying a broad fold bandage around the chest and the sling. \n" +
            "\n4. Arrange to take or send the casualty to the hospital in the position she finds most comfortable. \n";
    TextView tv_c3_2_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c3_2__read, container, false);

        tv_c3_2_first_aid_manual = view.findViewById(R.id.tv_c3_2_first_aid_manual);

        tv_c3_2_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c3_2_first_aid_manual = view.findViewById(R.id.tv_c3_2_first_aid_manual);
        tv_c3_2_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}