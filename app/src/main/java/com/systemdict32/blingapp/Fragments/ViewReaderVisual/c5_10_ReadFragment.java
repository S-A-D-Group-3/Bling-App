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
 * Use the {@link c5_10_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c5_10_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c5_10_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c5_10_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c5_10_ReadFragment newInstance(String param1, String param2) {
        c5_10_ReadFragment fragment = new c5_10_ReadFragment();
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
    public String firstAidManual = "1. Call for emergency help. Give the emergency personnel dispatcher details of the stage the mother has reached, the length of each contraction and the intervals between them. Follow the instructions of the dispatcher. \n" +
            "\n2. During the first stage, help her sit or kneel on the floor in a comfortable position. Support her with cushions or let her move around. Stay calm, and encourage her to breathe deeply during her contractions. \n" +
            "\n3. Massage her lower back gently using the heel of your hand. She may find having her face and hands wiped soothing, or you can spray her face with cool water and give her ice cubes to suck. \n" +
            "\n4. When the second stage starts, the mother will want to push. Make sure the surroundings are as clean as possible to reduce the risk of infection. The mother should remove any items of clothing that could interfere with the birth. Put clean sheets or towels under the woman; she may also want to be covered. Encourage her to stay as upright as possible. \n" +
            "\n5. As the baby is born, handle him carefully— newborns are very slippery. Make sure he is breathing, wrap him in a clean cloth, towel, or blanket, and place him between his mother’s legs so he is on the same level as the afterbirth. \n" +
            "\n6. As the third stage begins, reassure the mother. Support her as she delivers the afterbirth; do not cut the cord. Keep the placenta and the umbilical cord intact because the doctor or ambulance crew need to check that it is complete. If bleeding or pain is severe, treat for shock. Help the mother lie down and raise her legs. \n";
    TextView tv_c5_10_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c5_10__read, container, false);

        tv_c5_10_first_aid_manual = view.findViewById(R.id.tv_c5_10_first_aid_manual);
        tv_c5_10_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c5_10_first_aid_manual = view.findViewById(R.id.tv_c5_10_first_aid_manual);
        tv_c5_10_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}