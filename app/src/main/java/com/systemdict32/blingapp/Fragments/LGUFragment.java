package com.systemdict32.blingapp.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
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
 * Use the {@link LGUFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LGUFragment extends Fragment implements LocationListener, View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LGUFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LGUFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LGUFragment newInstance(String param1, String param2) {
        LGUFragment fragment = new LGUFragment();
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

    TextView tv_user_city, tv_e_hotline, tv_fd_hotline, tv_r_hotline, tv_cp_hotline, tv_hd_hotline, tv_rc_hotline, tv_covid_hotline;
    TextView btn_call_e_hotline, btn_call_fd_hotline, btn_call_r_hotline, btn_call_cp_hotline, btn_call_hd_hotline, btn_call_rc_hotline, btn_call_covid_hotline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_l_g_u, container, false);

        tv_user_city = view.findViewById(R.id.tv_user_city);
        tv_e_hotline = view.findViewById(R.id.tv_e_hotline);
        tv_fd_hotline = view.findViewById(R.id.tv_fd_hotline);
        tv_r_hotline = view.findViewById(R.id.tv_r_hotline);
        tv_cp_hotline = view.findViewById(R.id.tv_cp_hotline);
        tv_hd_hotline = view.findViewById(R.id.tv_hd_hotline);
        tv_rc_hotline = view.findViewById(R.id.tv_rc_hotline);
        tv_covid_hotline = view.findViewById(R.id.tv_covid_hotline);

        btn_call_covid_hotline = view.findViewById(R.id.btn_call_covid_hotline);
        btn_call_cp_hotline = view.findViewById(R.id.btn_call_cp_hotline);
        btn_call_e_hotline = view.findViewById(R.id.btn_call_e_hotline);
        btn_call_fd_hotline = view.findViewById(R.id.btn_call_fd_hotline);
        btn_call_hd_hotline = view.findViewById(R.id.btn_call_hd_hotline);
        btn_call_r_hotline = view.findViewById(R.id.btn_call_r_hotline);
        btn_call_rc_hotline = view.findViewById(R.id.btn_call_rc_hotline);

        btn_call_covid_hotline.setOnClickListener(this);
        btn_call_cp_hotline.setOnClickListener(this);
        btn_call_e_hotline.setOnClickListener(this);
        btn_call_fd_hotline.setOnClickListener(this);
        btn_call_hd_hotline.setOnClickListener(this);
        btn_call_r_hotline.setOnClickListener(this);
        btn_call_rc_hotline.setOnClickListener(this);

        getLatLng();

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btn_call_covid_hotline.getId()) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + covid_hotline));
            getActivity().startActivity(intent);
        }
        if(v.getId() == btn_call_cp_hotline.getId()) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + cp_hotline));
            getActivity().startActivity(intent);
        }
        if(v.getId() == btn_call_e_hotline.getId()) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + e_hotline));
            getActivity().startActivity(intent);
        }
        if(v.getId() == btn_call_fd_hotline.getId()) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + fd_hotline));
            getActivity().startActivity(intent);
        }
        if(v.getId() == btn_call_hd_hotline.getId()) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + hd_hotline));
            getActivity().startActivity(intent);
        }
        if(v.getId() == btn_call_r_hotline.getId()) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + r_hotline));
            getActivity().startActivity(intent);
        }
        if(v.getId() == btn_call_rc_hotline.getId()) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + rc_hotline));
            getActivity().startActivity(intent);
        }
    }

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
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, LGUFragment.this);
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

    public String generateAddress(Double lat, Double lng){

        String url = "https://maps.googleapis.com/maps/api/geocode/json?" +
                "latlng=" + lat + "," + lng +
                "&result_type=locality" +
                "&key=" + getResources().getString(R.string.google_api_key);

        return url;
    }

    public class PlaceTask extends AsyncTask<String,Integer,String> {

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
            URL url= new URL(string);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.connect();

            InputStream stream = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder builder = new StringBuilder();

            String line = "";

            while((line = reader.readLine()) != null) {
                builder.append(line);

            }

            String data = builder.toString();

            reader.close();

            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s!= null){
                new ParserTask().execute(s);
            }
        }

        private class ParserTask extends AsyncTask<String,Integer, List<HashMap<String,String>>>{

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

                for(int i = 0; i < hashMaps.size(); i++) {
                    HashMap<String, String> hashMap = hashMaps.get(i);

                    //store data in the variable
                    String address = hashMap.get("address");

                    tv_user_city.setText(address);

                    generateCityHotline(address);

                    if(!isNCR) {
                        tv_user_city.setText("You are not on NCR!");
                        return;
                    }

                    tv_e_hotline.setText(e_hotline);
                    tv_covid_hotline.setText(covid_hotline);
                    tv_cp_hotline.setText(cp_hotline);
                    tv_fd_hotline.setText(fd_hotline);
                    tv_hd_hotline.setText(hd_hotline);
                    tv_r_hotline.setText(r_hotline);
                    tv_rc_hotline.setText(rc_hotline);
                }
            }
        }
    }

    String e_hotline, fd_hotline, r_hotline, cp_hotline, hd_hotline, rc_hotline, covid_hotline;
    boolean isNCR = false;

    public boolean generateCityHotline(String city) {
        if (city.contains("Marikina")) {
            e_hotline = "161";
            fd_hotline = "933-3076";
            r_hotline = "646-2423";
            cp_hotline = "646-1631";
            hd_hotline = "646 2360";
            rc_hotline = "8681 483";
            covid_hotline = "09455176926";
            isNCR = true;
        }

        if (city.contains("Taguig")) {
            e_hotline = "8-789-3200";
            fd_hotline = "837-0740";
            r_hotline = "165-7777";
            cp_hotline = "8642 2062";
            hd_hotline = "8642 126 ";
            rc_hotline = "8470 9611";
            covid_hotline = "09664194150 / 8628-3449";
            isNCR = true;
        }

        if (city.contains("Mandaluyong")) {
            e_hotline = "8533-2225";
            fd_hotline = "532-2402";
            r_hotline = "533-2225";
            cp_hotline = "532 2145";
            hd_hotline = "8532 5001";
            rc_hotline = "8571 9894";
            covid_hotline = "09162558130 / 09615716959";
            isNCR = true;
        }
        return isNCR;
    }
}