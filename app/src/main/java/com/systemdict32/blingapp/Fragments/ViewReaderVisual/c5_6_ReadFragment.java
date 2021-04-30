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
 * Use the {@link c5_6_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c5_6_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c5_6_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c5_6_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c5_6_ReadFragment newInstance(String param1, String param2) {
        c5_6_ReadFragment fragment = new c5_6_ReadFragment();
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

    public String firstAidManual = "1. Make sure that contact with the electrical source is broken before you touch the casualty. \n" +
            "\n2. Flood the injury with cold water (at the entry and exit points if both are present) for at least ten minutes or until pain is relieved. If water is not available, any cold, harmless liquid can be used. \n" +
            "\n3. Gently remove any jewelry, watches, belts, or constricting clothing from the injured area before it begins to swell. Do not touch the burn. \n" +
            "\n4. When the burn is cooled, place a clean plastic bag over a burn on a foot or hand, taping the bag loosely in place (attach tape to the bag, not the skin). Or, cover the burn with plastic wrap, laying it along the length of the limb so that it does not become too tight. If neither is available, use a sterile dressing or a clean gauze pad loosely. \n" +
            "\n5. Call for emergency help. Reassure the casualty and treat him for shock. Monitor and record vital signs—level of response, breathing and pulse—while waiting for help to arrive. \n";
    TextView tv_c5_6_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c5_6__read, container, false);

        tv_c5_6_first_aid_manual = view.findViewById(R.id.tv_c5_6_first_aid_manual);
        tv_c5_6_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c5_6_first_aid_manual = view.findViewById(R.id.tv_c5_6_first_aid_manual);
        tv_c5_6_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}