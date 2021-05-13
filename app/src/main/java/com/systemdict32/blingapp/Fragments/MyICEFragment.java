package com.systemdict32.blingapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.systemdict32.blingapp.Dashboard;
import com.systemdict32.blingapp.R;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyICEFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyICEFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyICEFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyICEFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyICEFragment newInstance(String param1, String param2) {
        MyICEFragment fragment = new MyICEFragment();
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

    FirebaseFirestore fStore;
    FirebaseAuth firebaseAuth;
    String userId;
    String fullname, address, medCon, medTake, blood, cPerson, cPersonNum;
    TextView btn_remove_notif, tv_ice_blood, tv_ice_contactperson, tv_ice_contactperson_num, tv_ice_medtake, tv_ice_medcon, tv_ice_address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_ice, container, false);

        tv_ice_blood = view.findViewById(R.id.tv_ice_blood);
        tv_ice_address = view.findViewById(R.id.tv_ice_address);
        tv_ice_contactperson = view.findViewById(R.id.tv_ice_contactperson);
        tv_ice_contactperson_num = view.findViewById(R.id.tv_ice_contactperson_num);
        tv_ice_medtake = view.findViewById(R.id.tv_ice_medtake);
        tv_ice_medcon = view.findViewById(R.id.tv_ice_medcon);
        btn_remove_notif = view.findViewById(R.id.btn_remove_notif);

        firebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = firebaseAuth.getCurrentUser().getUid();


        fStore.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
       // fStore.collection("I.C.E").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if (document.getId().equals(userId)) {
                            fullname = document.getString("user_FN");
                            address = document.getString("user_ICE_ADDRESS");
                            medCon = document.getString("user_ICE_MEDICALCONDITION");
                            medTake = document.getString("user_ICE_MEDICINETAKE");
                            blood = document.getString("user_ICE_BLOODTYPE");
                            cPerson = document.getString("user_ICE_CONTACTPERSON");
                            cPersonNum = document.getString("user_ICE_CONTACTPERSON_NUMBER");

                            tv_ice_blood.setText(blood);
                            tv_ice_address.setText(address);
                            tv_ice_contactperson.setText(cPerson);
                            tv_ice_contactperson_num.setText(cPersonNum);
                            tv_ice_medtake.setText(medTake);
                            tv_ice_medcon.setText(medCon);
                        }
                    }
                } else {
                    Toasty.error(getActivity(), "failed", Toast.LENGTH_SHORT, true).show();
                }
            }
        });

        btn_remove_notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dashboard dashboard = new Dashboard();
                dashboard.hideNotification(getActivity());
            }
        });

        return view;
    }
}