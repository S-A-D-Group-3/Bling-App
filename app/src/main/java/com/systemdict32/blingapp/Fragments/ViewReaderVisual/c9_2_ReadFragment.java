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
 * Use the {@link c9_2_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c9_2_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c9_2_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c9_2_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c9_2_ReadFragment newInstance(String param1, String param2) {
        c9_2_ReadFragment fragment = new c9_2_ReadFragment();
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
    public String firstAidManual = "1. Help the casualty lie down, with head and shoulders raised. Reassure the casualty and advise her not to move the bitten limb to prevent venom from spreading. Call for emergency help. \n" +
            "\n2. If you have been properly trained, consider wrapping a pressure bandage around the entire length of the limb that was bitten. The bandage should be comfortably snug but loose enough to allow a finger to be slipped under it. \n" +
            "\n3. Whether or not it is wrapped, the bitten limb should be immobilized with a splint to prevent the casualty from bending it. Keep the limb below the level of the heart. \n" +
            "\n4. Monitor and record vital signs while waiting for emergency help. The casualty must remain still, and should be taken to the hospital as soon as possible. \n";
    View view;
    TextView tv_c9_2_first_aid_manual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c9_2__read, container, false);

        tv_c9_2_first_aid_manual = view.findViewById(R.id.tv_c9_2_first_aid_manual);
        tv_c9_2_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c9_2_first_aid_manual = view.findViewById(R.id.tv_c9_2_first_aid_manual);
        tv_c9_2_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}