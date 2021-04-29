package com.systemdict32.blingapp.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.systemdict32.blingapp.Dashboard;
import com.systemdict32.blingapp.Login;
import com.systemdict32.blingapp.R;
import com.systemdict32.blingapp.SignUp;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    String currentPhotoPath;
    TextView fullname, email;
    Button dismiss;
    FirebaseFirestore fStore;
    FirebaseAuth firebaseAuth;
    StorageReference storageReference;
    ImageView picture;
    String userId;



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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_account, container, false);
        fullname = view.findViewById(R.id.profile_fname);
        email = view.findViewById(R.id.profile_email);
        picture = view.findViewById(R.id.profile_pic);
        dismiss = view.findViewById(R.id.button_dis);
        firebaseAuth = FirebaseAuth.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference profileRefence = storageReference.child("users/"+firebaseAuth.getUid()+"/profile_image.jpg");
        profileRefence.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(picture);
            }
        });
        fStore = FirebaseFirestore.getInstance();
        userId = firebaseAuth.getCurrentUser().getUid();


        fStore.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if(document.getId().equals(userId)){
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
                                Dialog builder = new Dialog(getActivity());
                                builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                builder.getWindow().setBackgroundDrawable(
                                        new ColorDrawable(Color.GRAY));
                                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                    @Override
                                    public void onDismiss(DialogInterface dialogInterface) {
                                    }
                                });
                                Uri imgUri = Uri.parse("android.resource://com.systemdict32.blingapp/drawable/default_user");
                                 picture = new ImageView(getActivity());
                               picture.setImageURI(imgUri);
                                builder.addContentView(picture, new RelativeLayout.LayoutParams(
                                        ViewGroup.LayoutParams.MATCH_PARENT,
                                        ViewGroup.LayoutParams.MATCH_PARENT));
                                builder.show();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        switch(which) {
                                            case DialogInterface.BUTTON_POSITIVE:

                                            // ONSE DITO NEED GUMAWA NG PERMISSION SA WRITE_EXTERNAL (STORAGE)

                                           // case DialogInterface.BUTTON_POSITIVE:
                                            //    if(ActivityCompat.checkSelfPermission(getContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                                            //        requestPermissions(getActivity(),
                                           //                 new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                             //               REQUEST_LOCATION);
                                             //   } else {

                                                useCameraPermission();
                                              //  }
                                               //dispatchTakePictureIntent();
                                                break;

                                            case DialogInterface.BUTTON_NEGATIVE:
                                                Intent openFiles = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                                startActivityForResult(openFiles, 1000);
                                                break;
                                        }
                                    }
                                };





                                AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
                                builder2.create();
                                builder2.setCancelable(false);
                                builder2.setMessage("Set Profile Photo").setPositiveButton("Use Camera", dialogClickListener)
                                        .setNegativeButton("Choose from Files", dialogClickListener).show();

                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.create();
                builder.setCancelable(false);
                builder.setMessage("Profile Photo Options").setPositiveButton("View Photo", dialogClickListener)
                        .setNegativeButton("Update", dialogClickListener).show();


            }

        });




        // Inflate the layout for this fragment
        return view;
    }

    private void useCameraPermission() {
        if(ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[] {Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
        }else {
           dispatchTakePictureIntent();
        }





    }//



  protected void onActivityResultt(int requestCode, int resultCode, @Nullable Intent data){
    if(requestCode == CAMERA_REQUEST_CODE){
        if(resultCode== Activity.RESULT_OK){

            File f = new File(currentPhotoPath);
            picture.setImageURI(Uri.fromFile(f));
        }
    }
  }


    private File createImageFile() throws IOException {
        // Create an image file name

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";
            //  File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

            File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",   /* suffix */
                    storageDir      /* directory */
            );

            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = image.getAbsolutePath();
            return image;
        }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
              //

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(getActivity(), "com.systemdict32.android.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                getActivity().startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE);
            }
        }
    }

    public void onRequestPermissionResult(int requestCode,  @NonNull String[] permissions, @NonNull int[] grantResults){
       if(requestCode == CAMERA_PERM_CODE){
           if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

          dispatchTakePictureIntent();
           }else{
               Toasty.error(getActivity(), "Camera Permission Denied",
                       Toast.LENGTH_LONG, true).show();
           }
       }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data){
        MyAccountFragment.super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000) {
            if(resultCode == Activity.RESULT_OK) {
                String test1;
                Uri imgUri = data.getData();
                // picture.setImageURI(imgUri);
                uploadImageToFirebase(imgUri);



            }

        }
    }

    private void uploadImageToFirebase(Uri imgUri) {

        StorageReference fileReference = storageReference.child("users/"+firebaseAuth.getUid()+"/profile_image.jpg");
        fileReference.putFile(imgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        Picasso.get().load(uri).into(picture);
                        String bitch = fileReference.getDownloadUrl().toString();
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