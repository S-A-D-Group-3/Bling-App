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
 * Use the {@link c6_2_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c6_2_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c6_2_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c6_2_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c6_2_ReadFragment newInstance(String param1, String param2) {
        c6_2_ReadFragment fragment = new c6_2_ReadFragment();
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

    public String firstAidManual = "1. Flood the injured part with cold water for at least ten minutes or until the pain is relieved. If water is not available, any cold, harmless liquid, such as milk, can be used. \n" +
            "\n2. Gently remove any jewelry, watches, belts, or constricting clothing from the injured area before it begins to swell. \n" +
            "\n3. When the burn is cooled, cover it with plastic wrap or place a clean plastic bag over a foot or hand. Apply the wrap lengthwise over the burn, not around the limb because the tissues swell. If you do not have plastic wrap or a plastic bag, use a sterile dressing or a gauze pad, bandaged loosely in place. \n" +
            "\n4. Take or send the casualty to the hospital if the casualty is a child, or if you are in any doubt about the casualty’s condition. \n";
    View view;
    TextView tv_c6_2_first_aid_manual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c6_2__read, container, false);

        tv_c6_2_first_aid_manual = view.findViewById(R.id.tv_c6_2_first_aid_manual);
        tv_c6_2_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c6_2_first_aid_manual = view.findViewById(R.id.tv_c6_2_first_aid_manual);
        tv_c6_2_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}