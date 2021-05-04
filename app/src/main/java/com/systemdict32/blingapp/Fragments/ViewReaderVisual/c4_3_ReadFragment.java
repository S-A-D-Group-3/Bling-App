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
 * Use the {@link c4_3_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c4_3_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c4_3_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c4_3_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c4_3_ReadFragment newInstance(String param1, String param2) {
        c4_3_ReadFragment fragment = new c4_3_ReadFragment();
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

    public String firstAidManual = "1. Control bleeding by pressing firmly on either side of the embedded object to push the edges of the wound together. \n" +
            "\n2. Do not press directly on the object or try to remove it. Raise the injury above the level of the heart. \n" +
            "\n3. To protect the wound, drape a piece of gauze over the object. \n" +
            "\n4. Build up padding on either side, then carefully bandage over the object and pads without pressing on the object. \n" +
            "\n5. Check the circulation beyond the bandage every ten minutes. \n" +
            "\n6. If the circulation is impaired, loosen the bandage and reapply. \n" +
            "\n7. Treat for shock. Call for emergency help. Monitor and record vital signs—level of response, breathing, and pulse—while waiting for help to arrive. \n";
    TextView tv_c4_3_first_aid_manual;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c4_3__read, container, false);

        tv_c4_3_first_aid_manual = view.findViewById(R.id.tv_c4_3_first_aid_manual);
        tv_c4_3_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c4_3_first_aid_manual = view.findViewById(R.id.tv_c4_3_first_aid_manual);
        tv_c4_3_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}