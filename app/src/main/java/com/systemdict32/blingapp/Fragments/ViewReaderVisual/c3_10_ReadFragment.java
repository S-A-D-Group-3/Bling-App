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
 * Use the {@link c3_10_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c3_10_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c3_10_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c3_10_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c3_10_ReadFragment newInstance(String param1, String param2) {
        c3_10_ReadFragment fragment = new c3_10_ReadFragment();
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

    public String firstAidManual = "1. Help the casualty lie down, and carefully steady and support the injured leg. If there is a wound, carefully expose it and treat the bleeding. Place a dressing over the wound to protect it. \n" +
            "\n2. Remove any foot jewelry before the area begins to swell. \n" +
            "\n3. Apply a cold compress, such as an ice pack or a cold pad. This will also help relieve swelling and reduce pain. \n" +
            "\n4. Place padding around the casualty’s foot and bandage the ice pack firmly in place. \n" +
            "\n5. Arrange to take or send the casualty to the hospital. If he is not being transported by ambulance, try to ensure that the injured foot remains elevated during travel. \n";
    View view;
    TextView tv_c3_10_first_aid_manual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c3_10__read, container, false);

        tv_c3_10_first_aid_manual = view.findViewById(R.id.tv_c3_10_first_aid_manual);
        tv_c3_10_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c3_10_first_aid_manual = view.findViewById(R.id.tv_c3_10_first_aid_manual);
        tv_c3_10_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}