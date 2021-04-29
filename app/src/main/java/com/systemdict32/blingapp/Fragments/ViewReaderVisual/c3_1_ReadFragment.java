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

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link c3_1_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c3_1_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c3_1_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c3_1_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c3_1_ReadFragment newInstance(String param1, String param2) {
        c3_1_ReadFragment fragment = new c3_1_ReadFragment();
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

    public String firstAidManual = "1. Sit the casualty down and give him a cold compress to hold against the injury. Identify the casualty's level of consciousness. Treat any scalp wound by applying direct pressure to the wound. \n" +
            "\n2. regularly monitor and record vital signs. Breathing, pulse, and level of response. Watch especially for changes in his level of response. \n" +
            "\n3. When the casualty has recovered, ask a responsible person to look after him. \n" +
            "\n4. If a casualty’s injury is the result of a sporting accident, do not allow him to return to the sport until he has been fully assessed by a medical practitioner. \n" +
            "\n5. Advise the casualty to seek medical help or arrange transportation to a hospital if he develops signs and symptoms of a worsening head injury such as:  increasing drowsiness, persistent headache, confusion, dizziness, balance problems, and/or memory loss, difficulty speaking, difficulty walking, vomiting episodes after the injury, Double vision, and Seizure. \n";

    TextView tv_c3_1_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c3_1__read, container, false);

        tv_c3_1_first_aid_manual = view.findViewById(R.id.tv_c3_1_first_aid_manual);

        tv_c3_1_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c3_1_first_aid_manual = view.findViewById(R.id.tv_c3_1_first_aid_manual);
        tv_c3_1_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}