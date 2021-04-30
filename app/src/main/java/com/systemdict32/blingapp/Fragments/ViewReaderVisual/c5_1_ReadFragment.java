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
 * Use the {@link c5_1_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c5_1_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c5_1_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c5_1_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c5_1_ReadFragment newInstance(String param1, String param2) {
        c5_1_ReadFragment fragment = new c5_1_ReadFragment();
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

    public String firstAidManual = "1. Look at the casualty’s face. Ask him to smile; if he has had a stroke, he may only be able to smile on one side—the other side of his mouth may droop. \n" +
            "\n2. Ask the casualty to raise both his arms; if he has had stroke, he may be able to lift only one arm. \n" +
            "\n3. Find out whether the person can speak clearly and understand what you say. When you ask a question, does he respond appropriately to you?. \n" +
            "\n4. Call for emergency help. Tell the dispatcher that you have used the FAST guide and you suspect a stroke. \n" +
            "\n5. Keep the casualty comfortable and supported. If the casualty is conscious, you can help him lie down. Reassure him that help is on the way. \n" +
            "\n6. Regularly monitor and record vital signs—level of response, breathing, and pulse— while waiting for help to arrive. Do not give the casualty anything to eat or drink because it may be difficult for him to swallow. \n";
    TextView tv_c5_1_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c5_1__read, container, false);

        tv_c5_1_first_aid_manual = view.findViewById(R.id.tv_c5_1_first_aid_manual);
        tv_c5_1_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c5_1_first_aid_manual = view.findViewById(R.id.tv_c5_1_first_aid_manual);
        tv_c5_1_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}