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
 * Use the {@link c6_1_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c6_1_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c6_1_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c6_1_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c6_1_ReadFragment newInstance(String param1, String param2) {
        c6_1_ReadFragment fragment = new c6_1_ReadFragment();
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

    public String firstAidManual = "1. Start cooling the burn as soon as possible after the injury occurred. Flood the burn with plenty of cool tap water, but do not delay removal of the casualty to the hospital. Help the casualty sit or lie down. If possible, try to prevent the burned area from coming into contact with the ground. \n" +
            "\n2. Call for emergency help; if possible, get someone to do this while you cool the burn. \n" +
            "\n3. Continue cooling the affected area for at least ten minutes, or until the pain is relieved. Watch for signs of breathing difficulty. Do not overcool the casualty because you may lower the body temperature to a dangerous level. This is a particular hazard for babies and elderly people. \n" +
            "\n4. Do not touch or otherwise interfere with the burn. Gently remove rings, watches, belts, shoes, and burned or smoldering clothing before the tissues begin to swell. A helper can do this while you are cooling the burn. Do not remove clothing that is stuck to the burn. \n" +
            "\n5. When the burn is cooled, cover the injured area with plastic wrap to protect it from infection. Discard the first two turns from the roll and then wrap it lengthwise over the burn. A clean plastic bag can be used to cover a hand or foot; secure it with a bandage or adhesive tape applied over the plastic, not the damaged skin. If there is no plastic wrap available, use a sterile nonstick dressing, or improvise with gauze. Apply any dressing very loosely. \n" +
            "\n6. Reassure the casualty and treat him for shock if necessary. Record details of the casualty’s injuries. Monitor and record his vital signs—level of response, breathing, and pulse—while waiting for emergency help to arrive. \n";

    View view;
    TextView tv_c6_1_first_aid_manual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c6_1__read, container, false);
        tv_c6_1_first_aid_manual = view.findViewById(R.id.tv_c6_1_first_aid_manual);
        tv_c6_1_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c6_1_first_aid_manual = view.findViewById(R.id.tv_c6_1_first_aid_manual);
        tv_c6_1_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}