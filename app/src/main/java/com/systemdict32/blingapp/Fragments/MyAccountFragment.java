package com.systemdict32.blingapp.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.systemdict32.blingapp.Dashboard;
import com.systemdict32.blingapp.LauncherActivity;
import com.systemdict32.blingapp.Login;
import com.systemdict32.blingapp.R;
import com.systemdict32.blingapp.SignUp;
import com.systemdict32.blingapp.splashscreen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyAccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyAccountFragment extends Fragment implements Executor {

    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    public static final int EXTERNAL_REQUEST_CODE = 103;
    public static final int GALLERY_REQUEST_CODE = 105;
    String currentPhotoPath;
    TextView fullname, email, btn_create, btn_update, btn_delete;
    Button dismiss;
    FirebaseFirestore fStore;
    FirebaseAuth firebaseAuth;
    StorageReference storageReference;
    ImageView picture;
    String userId;
    String get;
    EditText txtAddress, txtbloodType, txtmedCon, txtmedTake, txtcontactPerson, txtcontPerNumber, txtBdate, txtAllergy, txtMaintenance;
    CheckBox chkAdd, chkBlood, chkMedCon, chkMedtake, chkContPer, chkContPerNum;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    String date;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyAccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyAccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyAccountFragment newInstance(String param1, String param2) {
        MyAccountFragment fragment = new MyAccountFragment();
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

    String fullName2, email2, address2, bloodType2, contactPerson2, contactPersonNum2, medCondition2, medTake2, userId2, bday2, mainte2, allergy2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_account, container, false);
        View mview = inflater.inflate(R.layout.crud_createdialog, container, false);
        fullname = view.findViewById(R.id.profile_fname);
        email = view.findViewById(R.id.profile_email);
        picture = view.findViewById(R.id.profile_pic);
        btn_create = view.findViewById(R.id.txtbtn_create);
        btn_update = view.findViewById(R.id.txtbtn_update);
        btn_delete = view.findViewById(R.id.txtbtn_delete);

        //initialize date
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                date = month + "/" + dayOfMonth + "/" + year;
                txtBdate.setText(date);
            }
        };
        firebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = firebaseAuth.getCurrentUser().getUid();
        fStore.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if (document.getId().equals(userId)) {
                            fullName2 = document.getString("user_FN");
                            email2 = document.getString("user_Email");
                            address2 = document.getString("user_ICE_ADDRESS");
                            bloodType2 = document.getString("user_ICE_BLOODTYPE");
                            contactPerson2 = document.getString("user_ICE_CONTACTPERSON");
                            contactPersonNum2 = document.getString("user_ICE_CONTACTPERSON_NUMBER");
                            medCondition2 = document.getString("user_ICE_MEDICALCONDITION");
                            medTake2 = document.getString("user_ICE_MEDICINETAKE");
                            allergy2 = document.getString("user_ICE_ALLERGY");
                            bday2 = document.getString("user_ICE_BDATE");
                            mainte2 = document.getString("user_ICE_MAINTENANCE");
                        }
                    }
                } else {

                }
            }
        });


        //  final EditText txtbloodType = (EditText)mview.findViewById(R.id.tx_bloodtype);
        //final EditText txtmedCon = (EditText)mview.findViewById(R.id.tx_medcon);
        // final EditText txtmedTake = (EditText)mview.findViewById(R.id.tx_medtake);
        // final EditText txtcontactPerson = (EditText)mview.findViewById(R.id.tx_personcont);


        storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference profileRefence = storageReference.child("users/" + firebaseAuth.getUid() + "/profile_image.jpg");
        profileRefence.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).resize(100, 100).centerCrop().into(picture, new Callback() {
                    @Override
                    public void onSuccess() {
                        Bitmap imageBitmap = ((BitmapDrawable) picture.getDrawable()).getBitmap();
                        RoundedBitmapDrawable imageDrawable = RoundedBitmapDrawableFactory.create(getResources(), imageBitmap);
                        imageDrawable.setCircular(true);
                        imageDrawable.setCornerRadius(Math.max(imageBitmap.getWidth(), imageBitmap.getHeight()) / 2.0f);
                        picture.setImageDrawable(imageDrawable);
                    }

                    @Override
                    public void onError(Exception e) {

                    }

                });
            }
        });

        fStore.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if (document.getId().equals(userId)) {
                            fullname.setText(document.getString("user_FN"));
                            email.setText(document.getString("user_Email"));
                        }
                    }
                } else {
                    Toasty.error(getActivity(), "failed", Toast.LENGTH_SHORT, true).show();
                }
            }
        });

        picture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // your code here
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                return;

                            case DialogInterface.BUTTON_NEGATIVE:
                                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        switch (which) {
                                            case DialogInterface.BUTTON_POSITIVE:
                                                return;

                                            //dispatchTakePictureIntent();
                                            case DialogInterface.BUTTON_NEGATIVE:
                                                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                                                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                                                            Manifest.permission.READ_EXTERNAL_STORAGE
                                                    }, 100);
                                                } else {
                                                    Intent openFiles = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                                    startActivityForResult(openFiles, 1000);
                                                }

                                                break;
                                        }
                                    }
                                };

                                AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
                                builder2.create();
                                builder2.setCancelable(false);
                                builder2.setIcon(R.drawable.logo_bling);
                                builder2.setMessage("Set Profile Photo").setPositiveButton("Go back", dialogClickListener)
                                        .setNegativeButton("Choose from Files", dialogClickListener).show();

                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.create();
                builder.setCancelable(false);
                builder.setIcon(R.drawable.logo_bling);
                builder.setMessage("Profile Photo Options").setPositiveButton("Go back", dialogClickListener)
                        .setNegativeButton("Update", dialogClickListener).show();


            }

        });

        btn_create.setOnClickListener(new View.OnClickListener() {

            // final EditText txtbloodType = new EditText(getContext());
            //   final   EditText txtmedCon =  new EditText(getContext());
            // final  EditText txtmedTake =  new EditText(getContext());
            //  final  EditText txtcontactPerson =new EditText(getContext());

            @Override

            public void onClick(View v) {
                // your code here


                        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                switch (which) {


                                    case DialogInterface.BUTTON_POSITIVE:
                                        return;

                                    case DialogInterface.BUTTON_NEGATIVE:
                                        String myAllergy = txtAllergy.getText().toString();
                                        String myBdate = txtBdate.getText().toString();
                                        String myMaintenance = txtMaintenance.getText().toString();
                                        String myAddress = txtAddress.getText().toString();
                                        String bloodType = txtbloodType.getText().toString();
                                        String medicalCond = txtmedCon.getText().toString();
                                        String medicalTaken = txtmedTake.getText().toString();
                                        String contactPer = txtcontactPerson.getText().toString();
                                        String contactPerNum = txtcontPerNumber.getText().toString();

                                        if (myAddress.isEmpty() || myAllergy.isEmpty() || myBdate.isEmpty() || myMaintenance.isEmpty() || bloodType.isEmpty() || medicalCond.isEmpty() || medicalTaken.isEmpty() || contactPer.isEmpty() || contactPerNum.isEmpty()) {
                                            Toasty.error(getActivity(), "Please complete up the field(s)",
                                                    Toast.LENGTH_LONG, true).show();

                                        } else {
                                            firebaseAuth = FirebaseAuth.getInstance();
                                            userId = firebaseAuth.getCurrentUser().getUid();
                                            DocumentReference documentReference = fStore.collection("users").document(userId);
                                            Map<String, Object> user = new HashMap<>();
                                            user.put("user_FN", fullname.getText());
                                            user.put("user_Email", email.getText());
                                            user.put("user_ICE_ADDRESS", myAddress);
                                            user.put("user_ICE_BDATE", myBdate);
                                            user.put("user_ICE_BLOODTYPE", bloodType);
                                            user.put("user_ICE_MEDICALCONDITION", medicalCond);
                                            user.put("user_ICE_ALLERGY", myAllergy);
                                            user.put("user_ICE_MAINTENANCE", myMaintenance);
                                            user.put("user_ICE_MEDICINETAKE", medicalTaken);
                                            user.put("user_ICE_CONTACTPERSON", contactPer);
                                            user.put("user_ICE_CONTACTPERSON_NUMBER", contactPerNum);

                                            documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                                                @Override
                                                public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                                                }
                                            });

                                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Toasty.success(getActivity(), "Thank you, ICE information has been added",
                                                            Toast.LENGTH_LONG, true).show();


                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toasty.error(getActivity(), " Error, please try again",
                                                            Toast.LENGTH_LONG, true).show();
                                                }
                                            });
                                        }
                                }
                            }
                        };

                        AlertDialog.Builder builderr = new AlertDialog.Builder(getActivity());
                        // set the custom layout

                        final View customLayout
                                = getLayoutInflater()
                                .inflate(R.layout.crud_createdialog, null);

                        builderr.setView(customLayout);
                        txtBdate = (EditText) customLayout.findViewById(R.id.txt_icebdate);
                        txtAddress = (EditText) customLayout.findViewById(R.id.txt_iceaddress);
                        txtbloodType = (EditText) customLayout.findViewById(R.id.txt_bloodtype);
                        txtmedCon = (EditText) customLayout.findViewById(R.id.txt_medcon);
                        txtmedTake = (EditText) customLayout.findViewById(R.id.txt_medtake);
                        txtMaintenance = (EditText) customLayout.findViewById(R.id.txt_maintenance);
                        txtAllergy = (EditText) customLayout.findViewById(R.id.txt_allergy);
                        txtcontactPerson = (EditText) customLayout.findViewById(R.id.txt_personcont);
                        txtcontPerNumber = (EditText) customLayout.findViewById(R.id.txt_personcontNumber);

                        txtBdate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Calendar cal = Calendar.getInstance();
                                int year = cal.get(Calendar.YEAR);
                                int month = cal.get(Calendar.MONTH);
                                int day = cal.get(Calendar.DAY_OF_MONTH);

                                DatePickerDialog dialog = new DatePickerDialog(getActivity(),
                                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                        mDateSetListener,
                                        year, month, day);

                                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                dialog.show();
                            }
                        });
                        builderr.create();
                        builderr.setCancelable(false);
                        builderr.setIcon(R.drawable.logo_bling);
                        builderr.setPositiveButton("Go back", dialogClickListener)
                                .setNegativeButton("Add my info", dialogClickListener).show();


                    }



        });


        btn_update.setOnClickListener(new View.OnClickListener() {

            // final EditText txtbloodType = new EditText(getContext());
            //   final   EditText txtmedCon =  new EditText(getContext());
            // final  EditText txtmedTake =  new EditText(getContext());
            //  final  EditText txtcontactPerson =new EditText(getContext());

            @Override

            public void onClick(View v) {
                // your code here
                fStore.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if (document.getId().equals(userId)) {
                                    fullName2 = document.getString("user_FN");
                                    email2 = document.getString("user_Email");
                                    address2 = document.getString("user_ICE_ADDRESS");
                                    bloodType2 = document.getString("user_ICE_BLOODTYPE");
                                    contactPerson2 = document.getString("user_ICE_CONTACTPERSON");
                                    contactPersonNum2 = document.getString("user_ICE_CONTACTPERSON_NUMBER");
                                    medCondition2 = document.getString("user_ICE_MEDICALCONDITION");
                                    medTake2 = document.getString("user_ICE_MEDICINETAKE");
                                    allergy2 = document.getString("user_ICE_ALLERGY");
                                    bday2 = document.getString("user_ICE_BDATE");
                                    mainte2 = document.getString("user_ICE_MAINTENANCE");
                                }
                            }
                        } else {

                        }
                    }
                });

                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        switch (which) {


                            case DialogInterface.BUTTON_POSITIVE:
                                return;

                            case DialogInterface.BUTTON_NEGATIVE:

                                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {


                                        switch (which) {


                                            case DialogInterface.BUTTON_POSITIVE:
                                                return;

                                            case DialogInterface.BUTTON_NEGATIVE:
                                                String myAllergy = txtAllergy.getText().toString();
                                                String myBdate = txtBdate.getText().toString();
                                                String myMaintenance = txtMaintenance.getText().toString();
                                                String myAddress = txtAddress.getText().toString();
                                                String bloodType = txtbloodType.getText().toString();
                                                String medicalCond = txtmedCon.getText().toString();
                                                String medicalTaken = txtmedTake.getText().toString();
                                                String contactPer = txtcontactPerson.getText().toString();
                                                String contactPerNum = txtcontPerNumber.getText().toString();

                                                if (myAddress.isEmpty() || myAllergy.isEmpty() || myBdate.isEmpty() || myMaintenance.isEmpty() || bloodType.isEmpty() || medicalCond.isEmpty() || medicalTaken.isEmpty() || contactPer.isEmpty() || contactPerNum.isEmpty()) {
                                                    Toasty.error(getActivity(), "Please complete up the field(s)",
                                                            Toast.LENGTH_LONG, true).show();

                                                } else {
                                                    firebaseAuth = FirebaseAuth.getInstance();
                                                    userId = firebaseAuth.getCurrentUser().getUid();
                                                    DocumentReference documentReference = fStore.collection("users").document(userId);
                                                    Map<String, Object> user = new HashMap<>();
                                                    user.put("user_FN", fullname.getText());
                                                    user.put("user_Email", email.getText());
                                                    user.put("user_ICE_ADDRESS", myAddress);
                                                    user.put("user_ICE_BDATE", myBdate);
                                                    user.put("user_ICE_BLOODTYPE", bloodType);
                                                    user.put("user_ICE_MEDICALCONDITION", medicalCond);
                                                    user.put("user_ICE_ALLERGY", myAllergy);
                                                    user.put("user_ICE_MAINTENANCE", myMaintenance);
                                                    user.put("user_ICE_MEDICINETAKE", medicalTaken);
                                                    user.put("user_ICE_CONTACTPERSON", contactPer);
                                                    user.put("user_ICE_CONTACTPERSON_NUMBER", contactPerNum);

                                                    documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                                                        @Override
                                                        public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                                                        }
                                                    });

                                                    documentReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                        @Override
                                                        public void onSuccess(Void aVoid) {
                                                            Toasty.success(getActivity(), "Thank you, ICE information has been updated",
                                                                    Toast.LENGTH_LONG, true).show();


                                                        }
                                                    }).addOnFailureListener(new OnFailureListener() {
                                                        @Override
                                                        public void onFailure(@NonNull Exception e) {
                                                            Toasty.error(getActivity(), " Error, please try again",
                                                                    Toast.LENGTH_LONG, true).show();
                                                        }
                                                    });
                                                }
                                        }
                                    }
                                };

                                AlertDialog.Builder builderr = new AlertDialog.Builder(getActivity());


                                // set the custom layout

                                final View customLayout
                                        = getLayoutInflater()
                                        .inflate(R.layout.crud_createdialog, null);

                                //wew
                                builderr.setView(customLayout);
                                txtBdate = (EditText) customLayout.findViewById(R.id.txt_icebdate);
                                txtAddress = (EditText) customLayout.findViewById(R.id.txt_iceaddress);
                                txtbloodType = (EditText) customLayout.findViewById(R.id.txt_bloodtype);
                                txtmedCon = (EditText) customLayout.findViewById(R.id.txt_medcon);
                                txtmedTake = (EditText) customLayout.findViewById(R.id.txt_medtake);
                                txtMaintenance = (EditText) customLayout.findViewById(R.id.txt_maintenance);
                                txtAllergy = (EditText) customLayout.findViewById(R.id.txt_allergy);
                                txtcontactPerson = (EditText) customLayout.findViewById(R.id.txt_personcont);
                                txtcontPerNumber = (EditText) customLayout.findViewById(R.id.txt_personcontNumber);

                                txtBdate.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Calendar cal = Calendar.getInstance();
                                        int year = cal.get(Calendar.YEAR);
                                        int month = cal.get(Calendar.MONTH);
                                        int day = cal.get(Calendar.DAY_OF_MONTH);

                                        DatePickerDialog dialog = new DatePickerDialog(getActivity(),
                                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                                mDateSetListener,
                                                year, month, day);

                                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                        dialog.show();
                                    }
                                });

                                txtAddress.setText(address2);
                                txtbloodType.setText(bloodType2);
                                txtmedCon.setText(medCondition2);
                                txtmedTake.setText(medTake2);
                                txtcontactPerson.setText(contactPerson2);
                                txtcontPerNumber.setText(contactPersonNum2);
                                txtAllergy.setText(allergy2);
                                txtBdate.setText(bday2);
                                txtMaintenance.setText(mainte2);

                                builderr.create();
                                builderr.setCancelable(false);
                                builderr.setIcon(R.drawable.logo_bling);
                                builderr.setPositiveButton("Go back", dialogClickListener)
                                        .setNegativeButton("Update my info", dialogClickListener).show();


                        }

                    }

                };

                AlertDialog.Builder builderr = new AlertDialog.Builder(getActivity());
                // set the custom layout

                builderr.create();
                builderr.setCancelable(false);
                builderr.setIcon(R.drawable.logo_bling);
                builderr.setTitle("Warning ! ! !");
                builderr.setMessage("Once you Clicked Proceed, you must update all the data again").setPositiveButton("Go back", dialogClickListener)
                        .setNegativeButton("Proceed", dialogClickListener).show();
            }


        });


        btn_delete.setOnClickListener(new View.OnClickListener() {

            // final EditText txtbloodType = new EditText(getContext());
            //   final   EditText txtmedCon =  new EditText(getContext());
            // final  EditText txtmedTake =  new EditText(getContext());
            //  final  EditText txtcontactPerson =new EditText(getContext());

            @Override

            public void onClick(View v) {
                // your code here

                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        switch (which) {


                            case DialogInterface.BUTTON_POSITIVE:
                                return;

                            case DialogInterface.BUTTON_NEGATIVE:

                                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {


                                        switch (which) {


                                            case DialogInterface.BUTTON_POSITIVE:
                                                return;

                                            case DialogInterface.BUTTON_NEGATIVE:

                                                firebaseAuth = FirebaseAuth.getInstance();
                                                userId = firebaseAuth.getCurrentUser().getUid();
                                                DocumentReference documentReference = fStore.collection("users").document(userId);
                                                Map<String, Object> user = new HashMap<>();
                                                user.put("user_FN", fullname.getText());
                                                user.put("user_Email", email.getText());
                                                user.put("user_ICE_ADDRESS", FieldValue.delete());
                                                user.put("user_ICE_BDATE", FieldValue.delete());
                                                user.put("user_ICE_ALLERGY", FieldValue.delete());
                                                user.put("user_ICE_MAINTENANCE", FieldValue.delete());
                                                user.put("user_ICE_BLOODTYPE", FieldValue.delete());
                                                user.put("user_ICE_MEDICALCONDITION", FieldValue.delete());
                                                user.put("user_ICE_MEDICINETAKE", FieldValue.delete());
                                                user.put("user_ICE_CONTACTPERSON", FieldValue.delete());
                                                user.put("user_ICE_CONTACTPERSON_NUMBER", FieldValue.delete());


                                                documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                                                    @Override
                                                    public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                                                    }
                                                });

                                                documentReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        Toasty.success(getActivity(), "Your I.C.E Data has been deleted",
                                                                Toast.LENGTH_LONG, true).show();


                                                    }
                                                }).addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Toasty.error(getActivity(), " Error, please try again",
                                                                Toast.LENGTH_LONG, true).show();
                                                    }
                                                });


                                        }
                                    }
                                };

                                AlertDialog.Builder builderr = new AlertDialog.Builder(getActivity());

                                // set the custom layout
                                builderr.create();
                                builderr.setCancelable(false);
                                builderr.setIcon(R.drawable.logo_bling);
                                builderr.setMessage("Please Confirm deletion of data").setPositiveButton("Go back", dialogClickListener)
                                        .setNegativeButton("Delete my info", dialogClickListener).show();


                        }

                    }

                };

                AlertDialog.Builder builderr = new AlertDialog.Builder(getActivity());
                // set the custom layout

                builderr.create();
                builderr.setCancelable(false);
                builderr.setIcon(R.drawable.logo_bling);
                builderr.setTitle("Warning ! ! !");
                builderr.setMessage("Once you Clicked Delete, all of your I.C.E info will be gone").setPositiveButton("Go back", dialogClickListener)
                        .setNegativeButton("Delete", dialogClickListener).show();
            }


        });


        // Inflate the layout for this fragment

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
        MyAccountFragment.super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imgUri = data.getData();
                // picture.setImageURI(imgUri);
                uploadImageToFirebase(imgUri);


            }

        }

    }

    private void uploadImageToFirebase(Uri uri) {

        StorageReference fileReference = storageReference.child("users/" + firebaseAuth.getUid() + "/profile_image.jpg");
        fileReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        Picasso.get().load(uri).resize(100, 100).centerCrop().into(picture, new Callback() {
                            @Override
                            public void onSuccess() {
                                Bitmap imageBitmap = ((BitmapDrawable) picture.getDrawable()).getBitmap();
                                RoundedBitmapDrawable imageDrawable = RoundedBitmapDrawableFactory.create(getResources(), imageBitmap);
                                imageDrawable.setCircular(true);
                                imageDrawable.setCornerRadius(Math.max(imageBitmap.getWidth(), imageBitmap.getHeight()) / 2.0f);
                                picture.setImageDrawable(imageDrawable);
                            }

                            @Override
                            public void onError(Exception e) {

                            }

                        });
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toasty.error(getActivity(), "Failed to Update", Toast.LENGTH_SHORT, true).show();
            }
        });
    }


    @Override
    public void execute(Runnable command) {

    }
}







