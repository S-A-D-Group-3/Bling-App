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
 * Use the {@link c10_10_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_10_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_10_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_10_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_10_ReadFragment newInstance(String param1, String param2) {
        c10_10_ReadFragment fragment = new c10_10_ReadFragment();
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

    public String firstAidManual = "1. Cold Pad, \n" +
            "\nA. Soak a clean washcloth or towel in cold water. Wring it out lightly and fold it into a pad. Hold it firmly against the injury (right). \n" +
            "\nB. Resoak the pad in cold water every few minutes to keep it cold. Cool the injury for at least ten minutes. \n" +
            "\n2. Ice Pack, \n" +
            "\nA. Partly fill a plastic bag with crushed ice, or use a pack of frozen vegetables. Wrap the bag in a dry cloth. \n" +
            "\nB. Hold the pack firmly on the area (left). Cool the injury for no more than ten minutes at a time, removing the pack for five-minute periods. \n";
    TextView tv_c10_10_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c10_10__read, container, false);

        tv_c10_10_first_aid_manual = view.findViewById(R.id.tv_c10_10_first_aid_manual);
        tv_c10_10_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c10_10_first_aid_manual = view.findViewById(R.id.tv_c10_10_first_aid_manual);
        tv_c10_10_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}