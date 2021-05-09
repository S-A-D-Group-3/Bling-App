package com.systemdict32.blingapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AboutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
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

    TextView tv_ourmission, tv_missionhead, tv_m1, tv_m2, tv_ourteam, tv_t1, tv_attrib, tv_a1, tv_a2, tv_link;
    ImageView aboutlogo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        tv_ourmission = view.findViewById(R.id.abt_ourmission);
        tv_missionhead = view.findViewById(R.id.abt_ourmissionhead);
        aboutlogo = view.findViewById(R.id.abt_headpic);
        tv_m1 = view.findViewById(R.id.abt_ourmission1);
        tv_m2 = view.findViewById(R.id.abt_ourmission2);
        tv_ourteam = view.findViewById(R.id.abt_ourteam);
        tv_t1 = view.findViewById(R.id.abt_ourteam1);
        tv_attrib = view.findViewById(R.id.abt_attrib);
        tv_a1 = view.findViewById(R.id.abt_attrib1);
        tv_a2 = view.findViewById(R.id.abt_attrib2);
       tv_link = view.findViewById(R.id.abt_attrib3);


        if (tv_link != null) {
            tv_link.setMovementMethod(LinkMovementMethod.getInstance());
        }

        return view;
    }
}