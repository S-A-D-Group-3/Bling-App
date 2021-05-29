package com.systemdict32.blingapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.systemdict32.blingapp.Fragments.Categories.c10_1_CprFragment;
import com.systemdict32.blingapp.Fragments.Categories.c10_2_VitalSignsFragment;
import com.systemdict32.blingapp.Fragments.Categories.c10_5_SlingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_10_ColdCompressFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_11_RollerBandageFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_15_BroadBandageFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_16_ArmSlingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_17_ElevateSlingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_9_CirculationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c4_1_ShockFragment;
import com.systemdict32.blingapp.Interfaces.RelatedFirstAidInterface;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RelatedFirstAidFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RelatedFirstAidFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RelatedFirstAidFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RelatedFirstAidFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RelatedFirstAidFragment newInstance(String param1, String param2) {
        RelatedFirstAidFragment fragment = new RelatedFirstAidFragment();
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

    RelatedFirstAidInterface relatedFirstAidInterface;
    TextView btn_to_vital_signs, btn_to_cold_compress, btn_to_elevation_sling, btn_to_shock, btn_to_rolled, btn_to_broad_fold,
            btn_to_arm_sling, btn_to_pulse, btn_to_sling, btn_to_circulation, btn_to_cpr;
    TextView relatedButtons[];
    View view;
    boolean isRelated[];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_related_first_aid, container, false);

        relatedFirstAidInterface = (RelatedFirstAidInterface) getParentFragment();

        btn_to_vital_signs = view.findViewById(R.id.btn_to_vital_signs);
        btn_to_cold_compress = view.findViewById(R.id.btn_to_cold_compress);
        btn_to_elevation_sling = view.findViewById(R.id.btn_to_elevation_sling);
        btn_to_shock = view.findViewById(R.id.btn_to_shock);
        btn_to_rolled = view.findViewById(R.id.btn_to_rolled);
        btn_to_broad_fold = view.findViewById(R.id.btn_to_broad_fold);
        btn_to_arm_sling = view.findViewById(R.id.btn_to_arm_sling);
        btn_to_pulse = view.findViewById(R.id.btn_to_pulse);
        btn_to_sling = view.findViewById(R.id.btn_to_sling);
        btn_to_circulation = view.findViewById(R.id.btn_to_circulation);
        btn_to_cpr = view.findViewById(R.id.btn_to_cpr);

        btn_to_vital_signs.setOnClickListener(this);
        btn_to_cold_compress.setOnClickListener(this);
        btn_to_elevation_sling.setOnClickListener(this);
        btn_to_shock.setOnClickListener(this);
        btn_to_rolled.setOnClickListener(this);
        btn_to_broad_fold.setOnClickListener(this);
        btn_to_arm_sling.setOnClickListener(this);
        btn_to_pulse.setOnClickListener(this);
        btn_to_sling.setOnClickListener(this);
        btn_to_circulation.setOnClickListener(this);
        btn_to_cpr.setOnClickListener(this);


        relatedButtons = new TextView[]{btn_to_vital_signs, btn_to_cold_compress, btn_to_elevation_sling,
                btn_to_shock, btn_to_rolled, btn_to_broad_fold,
                btn_to_arm_sling, btn_to_pulse, btn_to_sling,
                btn_to_circulation, btn_to_cpr};
        isRelated = relatedFirstAidInterface.isFirstAidRelated();

        showRelatedFirstAid();
        return view;
    }

    public void showRelatedFirstAid(){
        for(int i = 0; i < isRelated.length; i++){
            if(isRelated[i]){
                relatedButtons[i].setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btn_to_vital_signs.getId()) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.home_fragment_container, new c10_2_VitalSignsFragment());
            ft.addToBackStack(null);
            ft.commit();
        }

        if(v.getId() == btn_to_cold_compress.getId()) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.home_fragment_container, new c10_10_ColdCompressFragment());
            ft.addToBackStack(null);
            ft.commit();
        }

        if(v.getId() == btn_to_elevation_sling.getId()) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.home_fragment_container, new c10_17_ElevateSlingFragment());
            ft.addToBackStack(null);
            ft.commit();
        }

        if(v.getId() == btn_to_shock.getId()) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.home_fragment_container, new c4_1_ShockFragment());
            ft.addToBackStack(null);
            ft.commit();
        }

        if(v.getId() == btn_to_rolled.getId()) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.home_fragment_container, new c10_11_RollerBandageFragment());
            ft.addToBackStack(null);
            ft.commit();
        }

        if(v.getId() == btn_to_broad_fold.getId()) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.home_fragment_container, new c10_15_BroadBandageFragment());
            ft.addToBackStack(null);
            ft.commit();
        }

        if(v.getId() == btn_to_arm_sling.getId()) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.home_fragment_container, new c10_16_ArmSlingFragment());
            ft.addToBackStack(null);
            ft.commit();
        }

        if(v.getId() == btn_to_pulse.getId()) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.home_fragment_container, new c10_2_VitalSignsFragment());
            ft.addToBackStack(null);
            ft.commit();
        }

        if(v.getId() == btn_to_sling.getId()) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.home_fragment_container, new c10_5_SlingFragment());
            ft.addToBackStack(null);
            ft.commit();
        }

        if(v.getId() == btn_to_circulation.getId()) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.home_fragment_container, new c10_9_CirculationFragment());
            ft.addToBackStack(null);
            ft.commit();
        }

        if(v.getId() == btn_to_cpr.getId()) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.home_fragment_container, new c10_1_CprFragment());
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}