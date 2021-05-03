package com.systemdict32.blingapp.Fragments.SubCategories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_11_ReadFragment;
import com.systemdict32.blingapp.Fragments.ViewReaderVisual.c1_11_VisualFragment;
import com.systemdict32.blingapp.Interfaces.ToggleReadVisualInterface;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c1_11_MouthBleedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c1_11_MouthBleedFragment extends Fragment implements ToggleReadVisualInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c1_11_MouthBleedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c1_11_MouthBleedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c1_11_MouthBleedFragment newInstance(String param1, String param2) {
        c1_11_MouthBleedFragment fragment = new c1_11_MouthBleedFragment();
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
        return inflater.inflate(R.layout.fragment_c1_11__mouth_bleed, container, false);
    }

    @Override
    public Fragment getVisualFragment() {
        return new c1_11_VisualFragment();
    }

    @Override
    public Fragment getReadFragment() {
        return new c1_11_ReadFragment();
    }
}