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
 * Use the {@link cv2_1_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cv2_1_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public cv2_1_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cv2_1_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static cv2_1_ReadFragment newInstance(String param1, String param2) {
        cv2_1_ReadFragment fragment = new cv2_1_ReadFragment();
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

    public String firstAidManual = "Do not put yourself or others in further danger. \n" +
            "Take the following precautions. \n" +
            "1. Park safely, well away from the site of the " +
            "accident, set your hazard lights flashing, " +
            "and put on a high-visibility jacket/vest if " +
            "you have one. \n" +
            "2. Set up warning triangles or flares (or position " +
            "another vehicle that has hazard lights) at " +
            "least 50 yards (45 meters) from the accident " +
            "in each direction; bystanders can do this " +
            "while you attend to the casualty. If possible, " +
            "send helpers to warn oncoming drivers to " +
            "slow down. \n" +
            "2. Make vehicles safe. For example, switch off " +
            "the ignition of any damaged vehicle. Stabilize " +
            "vehicles. If a vehicle is upright, and you can " +
            "get in without risk to yourself, apply the " +
            "emergency brake, put it in park, or place " +
            "blocks in front of the wheels. If it is on its side, " +
            "do not attempt to right it. \n" +
            "3. Watch out for physical dangers, such as " +
            "traffic. Make sure that no one smokes " +
            "anywhere near the accident. \n" +
            "4. Alert the emergency services to damaged " +
            "power lines, fuel spills, or any vehicles with " +
            "HAZMAT signs (opposite). ";

    TextView tv_cv2_1_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cv2_1__read, container, false);


        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_cv2_1_first_aid_manual = view.findViewById(R.id.tv_cv2_1_first_aid_manual);
        tv_cv2_1_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}