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
 * Use the {@link c5_2_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c5_2_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c5_2_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c5_2_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c5_2_ReadFragment newInstance(String param1, String param2) {
        c5_2_ReadFragment fragment = new c5_2_ReadFragment();
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

    public String firstAidManual = "1. If you have rescued the casualty from the water, help him lie down on a rug or coat with his head lower than the rest of the body so that water can drain from his mouth. This reduces the risk of inhaling water. \n" +
            "\n2. Treat the casualty for hypothermia; replace wet clothing with dry clothes if possible and cover him with dry blankets or coats. If the casualty is fully conscious, give him a warm drink. \n" +
            "\n3. Call for emergency help even if he appears to recover fully because of the risk of secondary drowning. Monitor and record his vital signs—level of response, breathing, and pulse—until help arrives. \n" +
            "\n4. If the casualty is unconscious and you are on your own, give CPR for two minutes before you call for emergency help. To do this: First, Check for a response. Gently shake the casualty’s shoulders, and talk to him. Assess breathing; if casualty is not breathing or only gasping. Second, kneel level with the casualty's chest. Put one hand on the center of the chest and the heel of your other hand on top; interlock your fingers. Depress chest at least 2 in (5 cm), and release but keep your hands in place. Do compressions at a rate of 100 per minute. Third, give chest compressions until emergency help arrives; the casualty shows signs of regaining consciousness, such as coughing, opening his eyes, speaking, or moving purposefully, and starts to breathe normally; or you are too exhausted to continue. Fourth, maintaining head tilt and chin lift, take your mouth away from the casualty’s. Look along the chest and watch it fall. Repeat to give TWO rescue breaths. Repeat 30 chest compressions followed by TWO rescue breaths. Fifth, continue CPR until emergency help arrives, the casualty starts to breathe normally, or you are too exhausted to continue. If you are unwilling or unable to give rescue breaths, you can give chest compressions alone (below). \n" +
            "\n5. If an unconscious casualty starts to breathe, treat him for hypothermia by covering him with warm clothes and blankets. If he recovers, replace his wet clothes with dry ones if possible and cover him with warm clothes and blankets. Monitor and record vital signs—breathing, pulse and level of response—until help arrives. \n";
    TextView tv_c5_2_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c5_2__read, container, false);

        tv_c5_2_first_aid_manual = view.findViewById(R.id.tv_c5_2_first_aid_manual);
        tv_c5_2_first_aid_manual.setText(firstAidManual)
        ;
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c5_2_first_aid_manual = view.findViewById(R.id.tv_c5_2_first_aid_manual);
        tv_c5_2_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}