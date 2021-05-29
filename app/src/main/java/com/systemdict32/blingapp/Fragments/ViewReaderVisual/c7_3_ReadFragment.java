package com.systemdict32.blingapp.Fragments.ViewReaderVisual;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.systemdict32.blingapp.Interfaces.FirstAidInterface;
import com.systemdict32.blingapp.Interfaces.ToggleReadVisualInterface;
import com.systemdict32.blingapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c7_3_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c7_3_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c7_3_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c7_3_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c7_3_ReadFragment newInstance(String param1, String param2) {
        c7_3_ReadFragment fragment = new c7_3_ReadFragment();
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

    public String firstAidManual = "1. If the infant is unable to cough or breathe, lay him face down along your forearm (head low), and support his body and head. Give up to five back blows between the shoulder blades with the heel of your hand. \n" +
            "\n2. Turn the infant face up along your other forearm, supporting his back and head. Check the mouth. Pick out any obvious obstructions. If choking persists, proceed to step 3. \n" +
            "\n3. Place two fingertips on the lower half of the infant’s breastbone, in the nipple line. Give up to five compressions. Recheck the mouth. \n" +
            "\n4. Repeat steps 1 to 3 until the object is expelled or the infant loses consciousness. Do CPR on the unconscious infant for two minutes, call for emergency help, then continue CPR until help arrives. \n";
    View view;
    TextView tv_c7_3_first_aid_manual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c7_3__read, container, false);

        tv_c7_3_first_aid_manual = view.findViewById(R.id.tv_c7_3_first_aid_manual);
        tv_c7_3_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c7_3_first_aid_manual = view.findViewById(R.id.tv_c7_3_first_aid_manual);
        tv_c7_3_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}