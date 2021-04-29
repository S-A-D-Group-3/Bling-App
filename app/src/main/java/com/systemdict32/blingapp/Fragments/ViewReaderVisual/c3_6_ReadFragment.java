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
 * Use the {@link c3_6_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c3_6_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c3_6_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c3_6_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c3_6_ReadFragment newInstance(String param1, String param2) {
        c3_6_ReadFragment fragment = new c3_6_ReadFragment();
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

    public String firstAidManual = "1. Support the ankle in the most comfortable position for the casualty, preferably raised. \n" +
            "\n2. Apply a cold compress, such as an ice pack or a cold pad, to the site to reduce swelling and bruising. \n" +
            "\n3. Apply comfortable support to the ankle. Leave the cold compress in place or wrap a layer of soft padding around the area. Bandage the ankle with a support bandage that extends from the base of the foot to the upper extent of the pain. \n" +
            "\n4. Raise and support the injured limb. Check the circulation beyond the bandaging every ten minutes. To do this, first thing to do, press one of the nails or the skin beyond the bandage, for five seconds until it turns pale, then release the pressure. If the color does not return within two seconds, the bandage is too tight. Second, loosen a tight bandage by unrolling enough turns for warmth and color to return to the skin. The casualty may feel a tingling sensation. If necessary, loosen and reapply the bandage. Recheck every ten minutes. \n" +
            "If the circulation is impaired, loosen the bandage. If you suspect a broken bone, arrange to send the casualty to the hospital. \n";
    View view;
    TextView tv_c3_6_first_aid_manual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c3_6__read, container, false);

        tv_c3_6_first_aid_manual = view.findViewById(R.id.tv_c3_6_first_aid_manual);
        tv_c3_6_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c3_6_first_aid_manual = view.findViewById(R.id.tv_c3_6_first_aid_manual);
        tv_c3_6_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}