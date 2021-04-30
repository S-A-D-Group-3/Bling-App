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
 * Use the {@link c5_4_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c5_4_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c5_4_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c5_4_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c5_4_ReadFragment newInstance(String param1, String param2) {
        c5_4_ReadFragment fragment = new c5_4_ReadFragment();
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

    public String firstAidManual = "1. Call for emergency help. Tell the dispatcher that you suspect a heart attack. If the casualty asks you to do so, call his own doctor too. \n" +
            "\n2. Make the casualty as comfortable as possible to ease the strain on his heart. A half sitting position, with his head and shoulders supported and his knees bent, is often best. Place cushions behind him and under his knees. \n" +
            "\n3. Assist the casualty to take up to one full-dose adult aspirin tablet (325 mg) or four baby aspirin (81 mg each). Advise him to chew it slowly. \n" +
            "\n4. If the casualty has angina medication, such as tablets or a pump-action or aerosol spray, let him administer it; help him if necessary. Encourage him to rest. \n" +
            "\n5. Monitor and record vital signs—level of response, breathing, and pulse—while waiting for help. Stay calm to avoid undue stress. \n";
    View view;
    TextView tv_c5_4_first_aid_manual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c5_4__read, container, false);

        tv_c5_4_first_aid_manual = view.findViewById(R.id.tv_c5_4_first_aid_manual);
        tv_c5_4_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c5_4_first_aid_manual = view.findViewById(R.id.tv_c5_4_first_aid_manual);
        tv_c5_4_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}