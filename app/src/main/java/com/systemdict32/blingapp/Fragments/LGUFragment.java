package com.systemdict32.blingapp.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.ImageView;
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

    TextView tv_currently_on, tv_user_city, tv_e_hotline, tv_fd_hotline, tv_r_hotline, tv_cp_hotline, tv_hd_hotline, tv_rc_hotline, tv_covid_hotline;
    ImageView btn_call_e_hotline, btn_call_fd_hotline, btn_call_r_hotline, btn_call_cp_hotline, btn_call_hd_hotline, btn_call_rc_hotline, btn_call_covid_hotline, btn_call_mmda;

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

        tv_currently_on = view.findViewById(R.id.tv_currently_on);
        btn_call_covid_hotline = view.findViewById(R.id.btn_call_covid_hotline);
        btn_call_cp_hotline = view.findViewById(R.id.btn_call_cp_hotline);
        btn_call_e_hotline = view.findViewById(R.id.btn_call_e_hotline);
        btn_call_fd_hotline = view.findViewById(R.id.btn_call_fd_hotline);
        btn_call_hd_hotline = view.findViewById(R.id.btn_call_hd_hotline);
        btn_call_r_hotline = view.findViewById(R.id.btn_call_r_hotline);
        btn_call_rc_hotline = view.findViewById(R.id.btn_call_rc_hotline);
        btn_call_mmda = view.findViewById(R.id.btn_call_mmda);

        btn_call_covid_hotline.setVisibility(View.GONE);
        btn_call_cp_hotline.setVisibility(View.GONE);
        btn_call_e_hotline.setVisibility(View.GONE);
        btn_call_fd_hotline.setVisibility(View.GONE);
        btn_call_hd_hotline.setVisibility(View.GONE);
        btn_call_r_hotline.setVisibility(View.GONE);
        btn_call_rc_hotline.setVisibility(View.GONE);
        btn_call_mmda.setVisibility(View.VISIBLE);

        btn_call_covid_hotline.setOnClickListener(this);
        btn_call_cp_hotline.setOnClickListener(this);
        btn_call_e_hotline.setOnClickListener(this);
        btn_call_fd_hotline.setOnClickListener(this);
        btn_call_hd_hotline.setOnClickListener(this);
        btn_call_r_hotline.setOnClickListener(this);
        btn_call_rc_hotline.setOnClickListener(this);
        btn_call_mmda.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(getActivity())
                        .setTitle("Permission to use Location")
                        .setMessage("To use our service, granting the location permission is required. It will be used to locate wherever the place you are at this moment and it will help you by means of providing nearest services. Rest assured that we value your privacy.")
                        .setPositiveButton("I understand", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(getActivity(), new String[]{
                                        Manifest.permission.ACCESS_FINE_LOCATION
                                }, 100);
                            }
                        })
                        .create()
                        .show();
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{
                                Manifest.permission.ACCESS_FINE_LOCATION
                        },
                        100);
            }
        } else {
            getLatLng();
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_call_covid_hotline.getId()) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.CALL_PHONE)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Permission to use Call")
                            .setMessage("To use this service, enabling call permission is required." +
                                    "It will make the process convenient by means of automating the call, instead of typing it.")
                            .setPositiveButton("I understand", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //Prompt the user once explanation has been shown
                                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                                            Manifest.permission.CALL_PHONE
                                    }, 101);
                                }
                            })
                            .create()
                            .show();
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                            Manifest.permission.CALL_PHONE
                    }, 101);
                }
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + covid_hotline));
                getActivity().startActivity(intent);
            }
        }
        if (v.getId() == btn_call_cp_hotline.getId()) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.CALL_PHONE)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Permission to use Call")
                            .setMessage("To use this service, enabling call permission is required." +
                                    "It will make the process convenient by means of automating the call, instead of typing it.")
                            .setPositiveButton("I understand", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //Prompt the user once explanation has been shown
                                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                                            Manifest.permission.CALL_PHONE
                                    }, 101);
                                }
                            })
                            .create()
                            .show();
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                            Manifest.permission.CALL_PHONE
                    }, 101);
                }
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + cp_hotline));
                getActivity().startActivity(intent);
            }

        }
        if (v.getId() == btn_call_e_hotline.getId()) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.CALL_PHONE)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Permission to use Call")
                            .setMessage("To use this service, enabling call permission is required." +
                                    "It will make the process convenient by means of automating the call, instead of typing it.")
                            .setPositiveButton("I understand", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //Prompt the user once explanation has been shown
                                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                                            Manifest.permission.CALL_PHONE
                                    }, 101);
                                }
                            })
                            .create()
                            .show();
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                            Manifest.permission.CALL_PHONE
                    }, 101);
                }
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + e_hotline));
                getActivity().startActivity(intent);
            }

        }
        if (v.getId() == btn_call_fd_hotline.getId()) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.CALL_PHONE)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Permission to use Call")
                            .setMessage("To use this service, enabling call permission is required." +
                                    "It will make the process convenient by means of automating the call, instead of typing it.")
                            .setPositiveButton("I understand", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //Prompt the user once explanation has been shown
                                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                                            Manifest.permission.CALL_PHONE
                                    }, 101);
                                }
                            })
                            .create()
                            .show();
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                            Manifest.permission.CALL_PHONE
                    }, 101);
                }
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + fd_hotline));
                getActivity().startActivity(intent);
            }

        }
        if (v.getId() == btn_call_hd_hotline.getId()) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.CALL_PHONE)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Permission to use Call")
                            .setMessage("To use this service, enabling call permission is required." +
                                    "It will make the process convenient by means of automating the call, instead of typing it.")
                            .setPositiveButton("I understand", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //Prompt the user once explanation has been shown
                                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                                            Manifest.permission.CALL_PHONE
                                    }, 101);
                                }
                            })
                            .create()
                            .show();
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                            Manifest.permission.CALL_PHONE
                    }, 101);
                }
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + hd_hotline));
                getActivity().startActivity(intent);
            }

        }
        if (v.getId() == btn_call_r_hotline.getId()) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.CALL_PHONE)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Permission to use Call")
                            .setMessage("To use this service, enabling call permission is required." +
                                    "It will make the process convenient by means of automating the call, instead of typing it.")
                            .setPositiveButton("I understand", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //Prompt the user once explanation has been shown
                                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                                            Manifest.permission.CALL_PHONE
                                    }, 101);
                                }
                            })
                            .create()
                            .show();
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                            Manifest.permission.CALL_PHONE
                    }, 101);
                }
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + r_hotline));
                getActivity().startActivity(intent);
            }

        }
        if (v.getId() == btn_call_rc_hotline.getId()) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.CALL_PHONE)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Permission to use Call")
                            .setMessage("To use this service, enabling call permission is required." +
                                    "It will make the process convenient by means of automating the call, instead of typing it.")
                            .setPositiveButton("I understand", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //Prompt the user once explanation has been shown
                                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                                            Manifest.permission.CALL_PHONE
                                    }, 101);
                                }
                            })
                            .create()
                            .show();
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                            Manifest.permission.CALL_PHONE
                    }, 101);
                }
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + rc_hotline));
                getActivity().startActivity(intent);
            }

        }
        if (v.getId() == btn_call_mmda.getId()) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.CALL_PHONE)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Permission to use Call")
                            .setMessage("To use this service, enabling call permission is required." +
                                    "It will make the process convenient by means of automating the call, instead of typing it.")
                            .setPositiveButton("I understand", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //Prompt the user once explanation has been shown
                                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                                            Manifest.permission.CALL_PHONE
                                    }, 101);
                                }
                            })
                            .create()
                            .show();
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                            Manifest.permission.CALL_PHONE
                    }, 101);
                }
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + mmda_hotline));
                getActivity().startActivity(intent);
            }

        }

    }

    public void getLatLng() {
        getLocation();
        if (mLocation == null) {
            Toasty.info(getActivity(), "Please re-open this service if no data have not shown on the map yet.",
                    Toast.LENGTH_LONG, true).show();
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
            Toasty.error(getActivity(), "Location provider not found! Please enable your location!",
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
        Toasty.warning(getContext(), "Turn on your gps/location!",
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

                    String[] splitAddress = address.split(",");


                    generateCityHotline(address);

                    if (splitAddress[0].contains("City")) {
                        tv_user_city.setText(splitAddress[0]);

                    } else {
                        tv_user_city.setText(splitAddress[0] + " City");
                    }

                    if (!isNCR) {
                        tv_currently_on.setText("Sorry, this feature is not available at your current location.");
                        return;
                    }

                    tv_e_hotline.setText(e_hotline);
                    tv_covid_hotline.setText(covid_hotline);
                    tv_cp_hotline.setText(cp_hotline);
                    tv_fd_hotline.setText(fd_hotline);
                    tv_hd_hotline.setText(hd_hotline);
                    tv_r_hotline.setText(r_hotline);
                    tv_rc_hotline.setText(rc_hotline);


                    btn_call_covid_hotline.setVisibility(View.VISIBLE);
                    btn_call_cp_hotline.setVisibility(View.VISIBLE);
                    btn_call_e_hotline.setVisibility(View.VISIBLE);
                    btn_call_fd_hotline.setVisibility(View.VISIBLE);
                    btn_call_hd_hotline.setVisibility(View.VISIBLE);
                    btn_call_r_hotline.setVisibility(View.VISIBLE);
                    btn_call_rc_hotline.setVisibility(View.VISIBLE);


                }
            }
        }
    }

    String e_hotline = "", fd_hotline = "", r_hotline = "", cp_hotline = "", hd_hotline = "", rc_hotline = "", covid_hotline = "", mmda_hotline = "136";
    boolean isNCR = false;

    public boolean generateCityHotline(String city) {
        if (city.contains("Manila")) {
            e_hotline = "8527-5174";
            fd_hotline = "(02) 527-3627";
            r_hotline = "871-5811";
            cp_hotline = "117 / (02) 8722-0650";
            hd_hotline = "(02) 8527 4950";
            rc_hotline = "(02) 8257 2161 ";
            covid_hotline = "09610627013";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Marikina")) {
            e_hotline = "161";
            fd_hotline = "933-3076";
            r_hotline = "646-2423";
            cp_hotline = "646-1631";
            hd_hotline = "(032) 646 2360";
            rc_hotline = "(02) 8681 483";
            covid_hotline = "09455176926";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Taguig")) {
            e_hotline = "8-789-3200";
            fd_hotline = "(02) 837-0740";
            r_hotline = "165-7777";
            cp_hotline = "(02) 8642 2062";
            hd_hotline = "(02) 8642 126 ";
            rc_hotline = "(02) 8470 9611";
            covid_hotline = "09664194150 / 8628-3449";
            mmda_hotline = "136";
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
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Caloocan")) {
            e_hotline = "5310-6972";
            fd_hotline = "(02) 362 - 4037";
            r_hotline = "288 - 8811 (2295)";
            cp_hotline = "53657230";
            hd_hotline = "Smart/Tnt: 0947-8834430 Globe/Tm: 0977-2393931";
            rc_hotline = "(02) 8364-5752";
            covid_hotline = "5310.6972 / 09478834430 ";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Malabon")) {
            e_hotline = "(02) 8921 - 6009";
            fd_hotline = "(02) 361 - 9712";
            r_hotline = "921 - 6009 ";
            cp_hotline = "Tel#: 287-36-52 / 932-21-34, Mobile#: 09217050770";
            hd_hotline = "(02) 8281 4999";
            rc_hotline = "(02) 8366 6470";
            covid_hotline = "0917-9863823";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Navotas")) {
            e_hotline = "8281-1111";
            fd_hotline = "(02) 281 - 0854";
            r_hotline = "281 - 8531";
            cp_hotline = "(02) 8281 - 9099";
            hd_hotline = "(02) 8283 - 0697";
            rc_hotline = "(02) 8281-9003";
            covid_hotline = "8281.1111";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Valenzuela")) {
            e_hotline = "8352-5000";
            fd_hotline = "292-3519";
            r_hotline = "8352 - 5000";
            cp_hotline = "8352 - 4000 ";
            hd_hotline = "8352 - 6000";
            rc_hotline = "3432 - 0273";
            covid_hotline = "8292-1405";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Quezon City")) {
            e_hotline = "122";
            fd_hotline = "8924-1922";
            r_hotline = "928-4386";
            cp_hotline = "8925-8326 ";
            hd_hotline = "(02) 8929 8038";
            rc_hotline = "(02) 3433 2151";
            covid_hotline = "122";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Pasig")) {
            e_hotline = "641-1907";
            fd_hotline = "641-1939";
            r_hotline = "641-0439";
            cp_hotline = "641-0433";
            hd_hotline = "(02) 8642 7754";
            rc_hotline = "(02) 8470 9611";
            covid_hotline = "8643.0000";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Makati")) {
            e_hotline = "168 / 8236-5790";
            fd_hotline = "(02) 818-5150";
            r_hotline = "870-1940";
            cp_hotline = "8887-1798 / 09297936525";
            hd_hotline = "882-6316 to 36";
            rc_hotline = "(02) 8403 5826";
            covid_hotline = "168 / 8870-195959";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("San Juan")) {
            e_hotline = "7238-4333";
            fd_hotline = "(02) 725-8044";
            r_hotline = "718-0338";
            cp_hotline = "(02) 8724 2515";
            hd_hotline = "744-0736 / 497-4978 / 724-0721";
            rc_hotline = "(02) 3416 1343";
            covid_hotline = "8655-5000 / 7949-8359";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Pasay")) {
            e_hotline = "8551-7777";
            fd_hotline = "(02) 844-2120";
            r_hotline = "833-8512";
            cp_hotline = "(02) 8832 1125";
            hd_hotline = "(02) 8831 8201";
            rc_hotline = "(02) 8884 2748";
            covid_hotline = "09567786253 / 09089937024";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Parañaque")) {
            e_hotline = "911 / 8820-7783";
            fd_hotline = "(02) 826-9131";
            r_hotline = "825-1099";
            cp_hotline = "(02) 8286 2877";
            hd_hotline = "826-61-47";
            rc_hotline = "(02) 8836 4790";
            covid_hotline = "8820-7783";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Las Piñas")) {
            e_hotline = "8552-7694 / 8776-7268";
            fd_hotline = "(02) 245-0387";
            r_hotline = "871-4334";
            cp_hotline = "+638808-7395 ";
            hd_hotline = "824-5764 / 874-6408 / 776-7268";
            rc_hotline = "(02) 8556 7659";
            covid_hotline = "8994-5782 / 09776726211";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Muntinlupa")) {
            e_hotline = "8925-4351";
            fd_hotline = "(02) 842-2201";
            r_hotline = "862-0047";
            cp_hotline = "(02) 8862 2721";
            hd_hotline = " 88622711";
            rc_hotline = "09178387672";
            covid_hotline = "09772405218 / 09772405217";
            mmda_hotline = "136";
            isNCR = true;
        }

        if (city.contains("Pateros")) {
            e_hotline = "8642-5159";
            fd_hotline = "(02) 641-1365";
            r_hotline = "642-5159";
            cp_hotline = "+63 (2) 8875-8596";
            hd_hotline = "(02) 8641 0614";
            rc_hotline = "(02) 8470 9611 ";
            covid_hotline = "8642-5159";
            mmda_hotline = "136";
            isNCR = true;
        }

        return isNCR;
    }
}