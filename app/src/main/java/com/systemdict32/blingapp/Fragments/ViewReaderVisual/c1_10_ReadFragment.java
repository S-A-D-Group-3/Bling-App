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
 * Use the {@link c1_10_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c1_10_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c1_10_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c1_10_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c1_10_ReadFragment newInstance(String param1, String param2) {
        c1_10_ReadFragment fragment = new c1_10_ReadFragment();
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

    public String firstAidManual = "1. Tell the casualty to sit down and tilt his head forward to allow the blood to drain from the nostrils. Ask him to breathe through his mouth (this will have a calming effect) and to pinch the soft part of his nose for up to ten minutes, holding constant pressure. Reassure and help him if necessary. \n" +
            "\n2. Advise the casualty not to speak, swallow, cough, spit, or sniff since this may disturb blood clots that have formed in the nose. Give him a clean cloth or tissue to mop up any dribbling. \n" +
            "\n3. After ten minutes, tell the casualty to release the pressure. If the bleeding has not stopped, tell him to reapply the pressure for two further periods of ten minutes. \n" +
            "\n4. Once the bleeding has stopped, and with the casualty still leaning forward, clean around his nose with lukewarm water. Advise him to rest quietly for a few hours. Tell him to avoid exertion and, in particular, not to blow his nose, because this could disturb any clots. \n" +
            "\n5. If bleeding stops and then restarts, help the casualty reapply pressure. \n" +
            "\n6. If the nosebleed is severe, or if it lasts longer than 30 minutes, arrange to take or send the casualty to the hospital. \n";
    TextView tv_c1_10_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c1_10__read, container, false);

        tv_c1_10_first_aid_manual = view.findViewById(R.id.tv_c1_10_first_aid_manual);
        tv_c1_10_first_aid_manual.setText(firstAidManual);

        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c1_10_first_aid_manual = view.findViewById(R.id.tv_c1_10_first_aid_manual);
        tv_c1_10_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}