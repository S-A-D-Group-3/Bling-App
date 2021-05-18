package com.systemdict32.blingapp.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.systemdict32.blingapp.Dashboard;
import com.systemdict32.blingapp.NotificationReceiver;
import com.systemdict32.blingapp.NotificationReceiver2;
import com.systemdict32.blingapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyICEFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyICEFragment extends Fragment implements LocationListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String PREFS_NAME = "Notif";

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
    String fullname, address, medCon, medTake, blood, cPerson, cPersonNum, allerGy, mainTenance, birthDate;
    TextView tv_ice_blood, tv_ice_contactperson, tv_ice_contactperson_num, tv_ice_medtake, tv_ice_medcon, tv_ice_address, tv_ice_name, tv_ice_allergy, tv_ice_maintenance, tv_ice_bdate;
    Switch sw_notif;
    SharedPreferences settings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_ice, container, false);

        getLatLng();

        tv_ice_bdate  = view.findViewById(R.id.tv_ice_bdate);
        tv_ice_name  = view.findViewById(R.id.tv_ice_name); //ONSE DI KO NA TANDA PANO TO FEFETCH HAHAHAHA
        tv_ice_maintenance  = view.findViewById(R.id.tv_ice_maintenance);
        tv_ice_allergy = view.findViewById(R.id.tv_ice_allergy);
        tv_ice_blood = view.findViewById(R.id.tv_ice_blood);
        tv_ice_address = view.findViewById(R.id.tv_ice_address);
        tv_ice_contactperson = view.findViewById(R.id.tv_ice_contactperson);
        tv_ice_contactperson_num = view.findViewById(R.id.tv_ice_contactperson_num);
        tv_ice_medtake = view.findViewById(R.id.tv_ice_medtake);
        tv_ice_medcon = view.findViewById(R.id.tv_ice_medcon);
        sw_notif = view.findViewById(R.id.sw_notif);
        settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
        boolean silent = settings.getBoolean("switchkey", false);
        sw_notif.setChecked(silent);

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
                            allerGy =  document.getString("user_ICE_ALLERGY");
                            birthDate =  document.getString("user_ICE_BDATE");
                            mainTenance =  document.getString("user_ICE_MAINTENANCE");


                            tv_ice_name.setText(fullname);
                            tv_ice_bdate.setText(birthDate);
                            tv_ice_allergy.setText(allerGy);
                            tv_ice_maintenance.setText(mainTenance);
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

        sw_notif.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    showNotification(fullname, address, medCon, medTake, blood, cPerson, cPersonNum);
                } else {
                    hideNotification(getActivity());
                }
                settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("switchkey", isChecked);
                editor.commit();
            }
        });

        return view;
    }

    private static final String CHANNEL_ID = "notif";
    NotificationCompat.Builder builder;
    NotificationManagerCompat notificationManager;
    String lgu_hotline_num;

    public void showNotification(String mFullname, String mAddress, String mMedCondition, String mMedTake
            , String mBloodType, String mContactPerson, String mContactPersonNum) {
        StringBuffer buffer = new StringBuffer();

        buffer.append("Name: " + mFullname + "\n");
        buffer.append("Address: " + mAddress + "\n");
        buffer.append("Medical Condition: " + mMedCondition + "\n");
        buffer.append("Medicine Taken: " + mMedTake + "\n");
        buffer.append("Blood Type: " + mBloodType + "\n");
        buffer.append("ICE Contact Person: " + mContactPerson + "\n");
        buffer.append("ICE Contact Person #: " + mContactPersonNum + "\n");
//        buffer.append("ICE Number: " +  +"N/A");

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "notification";
            String description = "user notification";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(getActivity(), Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
        // call ice button
        Intent broadcastIntent = new Intent(getActivity(), NotificationReceiver.class);
        broadcastIntent.putExtra("ice_cell_num", mContactPersonNum);
        PendingIntent actionIntent = PendingIntent.getBroadcast(getActivity(), 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // call emergency hotline
        Intent broadcastIntent2 = new Intent(getActivity(), NotificationReceiver2.class);
        broadcastIntent2.putExtra("lgu_hotline_num", lgu_hotline_num);
        PendingIntent actionIntent2 = PendingIntent.getBroadcast(getActivity(), 2, broadcastIntent2, PendingIntent.FLAG_UPDATE_CURRENT);

        builder = new NotificationCompat.Builder(getActivity(), CHANNEL_ID)
                .setSmallIcon(R.drawable.logov2)
                .setContentTitle("In Case of Emergency")
                .setContentText("User Information")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(buffer.toString()))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setColor(Color.BLUE)
                .addAction(R.drawable.ic_baseline_call, "Call", actionIntent)
                .setAutoCancel(true).setOngoing(true);

        if(isNCR) {
            builder.addAction(R.drawable.ic_baseline_call, "Call E-Hotline", actionIntent2);
        }

        notificationManager = NotificationManagerCompat.from(getActivity());
//            builder.setVisibility(Notification.VISIBILITY_SECRET);
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, builder.build());
    }

    public void hideNotification(Context context) {
        notificationManager = NotificationManagerCompat.from(context);

        if (notificationManager.areNotificationsEnabled()) {
            notificationManager.cancel(1);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        boolean silent = settings.getBoolean("switchkey", false);

        if(silent) {
            showNotification(fullname, address, medCon, medTake, blood, cPerson, cPersonNum);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        boolean silent = settings.getBoolean("switchkey", false);

        if(silent) {
            showNotification(fullname, address, medCon, medTake, blood, cPerson, cPersonNum);
        }
    }

    // get lgu hotline
    public void getLatLng() {
        getLocation();
        if (mLocation == null) {
            return;
        }

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }

        LATITUDE = mLocation.getLatitude();
        LONGITUDE = mLocation.getLongitude();

        String url = generateAddress(LATITUDE, LONGITUDE);

        new PlaceTask().execute(url);
    }

    LocationManager locationManager;
    Location mLocation;
    private double LONGITUDE = 0, LATITUDE = 0;

    @SuppressLint("MissingPermission")
    public void getLocation() {
        try {
            locationManager = (LocationManager) getActivity().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
            mLocation = getLastKnownLocation();
        } catch (Exception e) {
            Toasty.error(getActivity(), "Location provider not found! Turn on your location!",
                    Toast.LENGTH_LONG, true).show();
        }
    }

    private Location getLastKnownLocation() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }
        // eto yung puki ng inang nagpagana sa map
        // https://stackoverflow.com/questions/20438627/getlastknownlocation-returns-null
        locationManager = (LocationManager) getActivity().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        Toasty.warning(getActivity(), "Turn on your gps/location!",
                Toast.LENGTH_LONG, true).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    public String generateAddress(Double lat, Double lng) {

        String url = "https://maps.googleapis.com/maps/api/geocode/json?" +
                "latlng=" + lat + "," + lng +
                "&result_type=locality" +
                "&key=" + getResources().getString(R.string.google_api_key);

        return url;
    }

    public class PlaceTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            String data = null;

            try {
                //string[0] value is the url from generate url function
                data = downloadUrl(strings[0]);
            } catch (IOException e) {

                e.printStackTrace();
            }

            return data;
        }

        public String downloadUrl(String string) throws IOException {
            URL url = new URL(string);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.connect();

            InputStream stream = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder builder = new StringBuilder();

            String line = "";

            while ((line = reader.readLine()) != null) {
                builder.append(line);

            }

            String data = builder.toString();

            reader.close();

            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s != null) {
                new ParserTask().execute(s);
            }
        }

        private class ParserTask extends AsyncTask<String, Integer, List<HashMap<String, String>>> {

            @Override
            protected List<HashMap<String, String>> doInBackground(String... strings) {
                JsonParserLGU jsonParser = new JsonParserLGU();

                List<HashMap<String, String>> mapList = null;
                JSONObject object = null;
                try {
                    object = new JSONObject(strings[0]);

                    mapList = jsonParser.parseResult(object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return mapList;
            }

            @Override
            protected void onPostExecute(List<HashMap<String, String>> hashMaps) {

                for (int i = 0; i < hashMaps.size(); i++) {
                    HashMap<String, String> hashMap = hashMaps.get(i);

                    //store data in the variable
                    String address = hashMap.get("address");

                    generateCityHotline(address);

                    if(!isNCR) {
                        lgu_hotline_num = null;
                        return;
                    }
                }
            }
        }
    }



    boolean isNCR = false;

    public void generateCityHotline(String city) {
        if (city.contains("Manila")) {
            lgu_hotline_num = "8527-5174";
            isNCR = true;
        }

        if (city.contains("Marikina")) {
            lgu_hotline_num = "161";
            isNCR = true;
        }

        if (city.contains("Taguig")) {
            lgu_hotline_num = "8-789-3200";
            isNCR = true;
        }

        if (city.contains("Mandaluyong")) {
            lgu_hotline_num = "8533-2225";
            isNCR = true;
        }

        if (city.contains("Caloocan")) {
            lgu_hotline_num = "5310-6972";
            isNCR = true;
        }

        if (city.contains("Malabon")) {
            lgu_hotline_num = "(02) 8921 - 6009";
            isNCR = true;
        }

        if (city.contains("Navotas")) {
            lgu_hotline_num = "8281-1111";
            isNCR = true;
        }

        if (city.contains("Valenzuela")) {
            lgu_hotline_num = "8352-5000";
            isNCR = true;
        }

        if (city.contains("Quezon City")) {
            lgu_hotline_num = "122";
            isNCR = true;
        }

        if (city.contains("Pasig")) {
            lgu_hotline_num = "641-1907";
            isNCR = true;
        }

        if (city.contains("Makati")) {
            lgu_hotline_num = "168";
            isNCR = true;
        }

        if (city.contains("San Juan")) {
            lgu_hotline_num = "7238-4333";
            isNCR = true;
        }

        if (city.contains("Pasay")) {
            lgu_hotline_num = "8551-7777";
            isNCR = true;
        }

        if (city.contains("Parañaque")) {
            lgu_hotline_num = "8820-7783";
            isNCR = true;
        }

        if (city.contains("Las Piñas")) {
            lgu_hotline_num = "8776-7268";
            isNCR = true;
        }

        if (city.contains("Muntinlupa")) {
            lgu_hotline_num = "8925-4351";
            isNCR = true;
        }

        if (city.contains("Pateros")) {
            lgu_hotline_num = "8642-5159";
            isNCR = true;
        }
    }
}