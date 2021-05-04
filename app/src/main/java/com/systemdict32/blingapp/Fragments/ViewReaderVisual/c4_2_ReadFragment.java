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
 * Use the {@link c4_2_ReadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c4_2_ReadFragment extends Fragment implements FirstAidInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public c4_2_ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c4_2_ReadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c4_2_ReadFragment newInstance(String param1, String param2) {
        c4_2_ReadFragment fragment = new c4_2_ReadFragment();
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

    public String firstAidManual = "1. Remove or cut clothing as necessary to expose the wound. \n" +
            "\n2. Apply direct pressure over the wound with your fingers using a sterile dressing or clean, gauze pad. \n" +
            "\n3. If you do not have a dressing, ask the casualty to apply direct pressure himself. If there is an object in the wound, apply pressure on either side of the object (opposite). \n" +
            "\n4. Maintain direct pressure on the wound to control bleeding. \n" +
            "\n5. Raise and support the injured limb above the level of the casualty’s heart to reduce blood loss. \n" +
            "\n6. Help the casualty lie down—on a rug or blanket if there is one, because this will protect him from the cold. \n" +
            "\n7. Since shock may develop, raise, and support his legs so that they are above the level of his heart. \n" +
            "\n8. Ask a helper to call for emergency help, and to give the dispatcher details of the site and extent of the bleeding. \n" +
            "\n9. Secure the dressing with a bandage that is firm enough to maintain pressure, but not so tight that it impairs circulation. \n" +
            "\n10. Call for emergency help if this has not been done already. \n" +
            "\n11. If bleeding shows through the dressing, apply a second one on top of the first. If blood seeps through the second dressing, remove both and apply a fresh one, ensuring that pressure is applied accurately at the point of bleeding. \n" +
            "\n12. Support the injured part in a raised position with a sling and/or bandage. \n" +
            "\n13. Check the circulation beyond the bandage every ten minutes. If the circulation is impaired, loosen the bandage and reapply. \n" +
            "\n14. Monitor and record vital signs—level of response, breathing, and pulse— while waiting for help to arrive. \n";
    TextView tv_c4_2_first_aid_manual;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_c4_2__read, container, false);

        tv_c4_2_first_aid_manual = view.findViewById(R.id.tv_c4_2_first_aid_manual);
        tv_c4_2_first_aid_manual.setText(firstAidManual);
        return view;
    }

    public void setFirstAidText(Spannable text){
        tv_c4_2_first_aid_manual = view.findViewById(R.id.tv_c4_2_first_aid_manual);
        tv_c4_2_first_aid_manual.setText(text);
    }

    @Override
    public String getFirstAid() {
        return firstAidManual;
    }
}