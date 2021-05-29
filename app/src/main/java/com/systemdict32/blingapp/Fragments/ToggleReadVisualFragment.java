package com.systemdict32.blingapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.systemdict32.blingapp.BlingChatbot.BlingChatbot;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_1_CprAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_2_CprChildFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_3_CprInfantFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_4_CprCompFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_5_PulseLocationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c4_1_ShockFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_1_StrokeFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_4_HeartAttackFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_1_ChokingAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_2_ChokingChildFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_3_ChokingInfantFragment;
import com.systemdict32.blingapp.Interfaces.ToggleReadVisualInterface;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToggleReadVisualFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToggleReadVisualFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ToggleReadVisualFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ToggleReadVisualFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ToggleReadVisualFragment newInstance(String param1, String param2) {
        ToggleReadVisualFragment fragment = new ToggleReadVisualFragment();
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

    TextView btn_view_visual, btn_view_reader, btn_nearby_hospital;
    public ToggleReadVisualInterface toggleReadVisualInterface;
    boolean isReader = true;
    View homeFrag;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_toggle_read_visual, container, false);
        homeFrag = inflater.inflate(R.layout.fragment_home, container, false);

        btn_view_reader = view.findViewById(R.id.btn_view_reader);
        btn_view_visual = view.findViewById(R.id.btn_view_visual);
        btn_nearby_hospital = view.findViewById(R.id.btn_nearby_hospital);

        toggleReadVisualInterface = (ToggleReadVisualInterface) getParentFragment();

        Fragment visualFragment = toggleReadVisualInterface.getVisualFragment();
        Fragment readFragment = toggleReadVisualInterface.getReadFragment();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.toggle_first_aid_container, readFragment);
        ft.commit();

        btn_view_reader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.toggle_first_aid_container, readFragment);
                ft.commit();
                if(!isReader) {
                    btn_view_reader.setVisibility(View.GONE);
                    btn_view_visual.setVisibility(View.VISIBLE);
                    isReader = !isReader;
                }
            }
        });

        btn_view_visual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.toggle_first_aid_container, visualFragment);
                ft.commit();

                if(isReader) {
                    btn_view_visual.setVisibility(View.GONE);
                    btn_view_reader.setVisibility(View.VISIBLE);
                    isReader = !isReader;
                }
            }
        });

        btn_nearby_hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.home_fragment_container, new HospitalFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        if(getParentFragment().getClass().equals(c10_1_CprAdultFragment.class)) {
            btn_view_visual.setVisibility(View.VISIBLE);
        }
        if(getParentFragment().getClass().equals(c10_2_CprChildFragment.class)) {
            btn_view_visual.setVisibility(View.VISIBLE);
        }
        if(getParentFragment().getClass().equals(c10_3_CprInfantFragment.class)) {
            btn_view_visual.setVisibility(View.VISIBLE);
        }
        if(getParentFragment().getClass().equals(c10_4_CprCompFragment.class)) {
            btn_view_visual.setVisibility(View.VISIBLE);
        }
        if(getParentFragment().getClass().equals(c10_5_PulseLocationFragment.class)) {
            btn_view_visual.setVisibility(View.VISIBLE);
        }
        if(getParentFragment().getClass().equals(c7_1_ChokingAdultFragment.class)) {
            btn_view_visual.setVisibility(View.VISIBLE);
        }
        if(getParentFragment().getClass().equals(c7_2_ChokingChildFragment.class)) {
            btn_view_visual.setVisibility(View.VISIBLE);
        }
        if(getParentFragment().getClass().equals(c7_3_ChokingInfantFragment.class)) {
            btn_view_visual.setVisibility(View.VISIBLE);
        }
        if(getParentFragment().getClass().equals(c5_4_HeartAttackFragment.class)) {
            btn_view_visual.setVisibility(View.VISIBLE);
        }
        if(getParentFragment().getClass().equals(c4_1_ShockFragment.class)) {
            btn_view_visual.setVisibility(View.VISIBLE);
        }
        if(getParentFragment().getClass().equals(c5_1_StrokeFragment.class)) {
            btn_view_visual.setVisibility(View.VISIBLE);
        }


        return view;
    }
}