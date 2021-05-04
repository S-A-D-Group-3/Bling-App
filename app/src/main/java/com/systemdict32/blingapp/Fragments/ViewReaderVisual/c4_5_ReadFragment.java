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
 * Use the {@link c4_5_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c4_5_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c4_5_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c4_5_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c4_5_ReadFragment newInstance(String param1, String param2) {
        c4_5_ReadFragment fragment = new c4_5_ReadFragment();
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

    public String firstAidManual = "1. Control blood loss by applying direct pressure and raising the injured part above the casualty’s heart. \n" +
            "\n2. Place a sterile dressing or a clean gauze pad on the wound and secure it with a bandage. If you are trained to use a tourniquet, it may be appropriate. \n" +
            "\n3. Treat the casualty for shock. \n" +
            "\n4. Call for emergency help. Tell the dispatcher that an amputation is involved. Monitor and record vital signs—level of response, breathing, and pulse—while waiting for help to arrive. \n" +
            "\n5. Wrap the severed part in plastic wrap or a plastic bag. \n" +
            "\n6. Wrap the package in gauze or soft fabric and place it in a container full of crushed ice. \n" +
            "\n7. Mark the container with the time of injury and the casualty’s name. \n" +
            "\n8. Give it to the emergency service personnel yourself. \n";
    TextView tv_c4_5_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c4_5__read, container, false);

        tv_c4_5_first_aid_manual = view.findViewById(R.id.tv_c4_5_first_aid_manual);
        tv_c4_5_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c4_5_first_aid_manual = view.findViewById(R.id.tv_c4_5_first_aid_manual);
        tv_c4_5_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}