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
 * Use the {@link c5_9_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c5_9_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c5_9_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c5_9_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c5_9_ReadFragment newInstance(String param1, String param2) {
        c5_9_ReadFragment fragment = new c5_9_ReadFragment();
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

    public String firstAidManual = "1. Place pillows or soft padding around the child so that even violent movement will not result in injury. Do not restrain the child in any way. \n" +
            "\n2. If the child’s seizure was caused by a fever, cool him by removing any bedding and clothes, for example T-shirt or pajama top; you may have to wait until the seizure stops. Ensure a good supply of fresh air (but do not overcool the child). \n" +
            "\n3. Once the seizures have stopped, maintain an open airway by placing the casualty in the recovery position. Call for emergency help. \n" +
            "\n4. Reassure the child as well as the parents or caregiver. Monitor and record vital signs—level of response, breathing, and pulse—until emergency help arrives. \n";
    TextView tv_c5_9_first_aid_manual;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c5_9__read, container, false);

        tv_c5_9_first_aid_manual = view.findViewById(R.id.tv_c5_9_first_aid_manual);
        tv_c5_9_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c5_9_first_aid_manual = view.findViewById(R.id.tv_c5_9_first_aid_manual);
        tv_c5_9_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}