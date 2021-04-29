package com.systemdict32.blingapp.Fragments.SubCategories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c3_8_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c3_8_VisualFragment;
import com.systemdict32.blingapp.Interfaces.ToggleReadVisualInterface;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c3_8_FacialInjuryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c3_8_FacialInjuryFragment extends Fragment implements ToggleReadVisualInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c3_8_FacialInjuryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c3_8_FacialInjuryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c3_8_FacialInjuryFragment newInstance(String param1, String param2) {
        c3_8_FacialInjuryFragment fragment = new c3_8_FacialInjuryFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c3_8__facial_injury, container, false);
    }

    @Override
    public Fragment getVisualFragment() {
        return new c3_8_VisualFragment();
    }

    @Override
    public Fragment getReadFragment() {
        return new c3_8_ReadFragment();
    }
}