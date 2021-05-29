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
 * Use the {@link c10_14_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c10_14_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c10_14_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c10_14_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c10_14_ReadFragment newInstance(String param1, String param2) {
        c10_14_ReadFragment fragment = new c10_14_ReadFragment();
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

    public String firstAidManual = "1. Cut a piece of tubular gauze about two-and-ahalf times the length of the injured finger. Push the whole length of the tubular gauze onto the applicator, then gently slide the applicator over the casualty’s finger. \n" +
            "\n2. Holding the end of the gauze on the finger, pull the applicator slightly beyond the fingertip to leave a gauze layer on the finger. Twist the applicator twice to seal the bandage over the end of the finger. \n" +
            "\n3. While still holding the gauze at the base of the finger, gently push the applicator back over the finger to apply a second layer of gauze. Once the gauze has been applied, remove the applicator from the finger. \n" +
            "\n4. Secure the gauze at the base of the finger with adhesive tape. Check the circulation to the finger immediately and then again, every ten minutes. Ask the casualty if the finger feels cold or tingly. If it does, remove the gauze and reapply it more loosely. \n";
    TextView tv_c10_14_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c10_14__read, container, false);

        tv_c10_14_first_aid_manual = view.findViewById(R.id.tv_c10_14_first_aid_manual);
        tv_c10_14_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text) {
        tv_c10_14_first_aid_manual = view.findViewById(R.id.tv_c10_14_first_aid_manual);
        tv_c10_14_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}