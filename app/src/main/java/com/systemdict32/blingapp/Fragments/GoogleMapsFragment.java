package com.systemdict32.blingapp.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.systemdict32.blingapp.Dashboard;
//import com.systemdict32.blingapp.Interfaces.EmergencyServiceType;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_1_CprAdultFragment;
import com.systemdict32.blingapp.R;
import com.systemdict32.blingapp.SignUp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

import es.dmoral.toasty.Toasty;

public class GoogleMapsFragment extends Fragment implements LocationListener, View.OnClickListener {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            List<Fragment> fragmentList = getFragmentManager().getFragments();
            fragId = fragmentList.get(2).getId();

            if (fragmentList.get(2).getClass().equals(HospitalFragment.class)) {
                emergencyType = "hospital";
                tv_nearby_services_name.setText("Health Care");
            }
            if (fragmentList.get(2).getClass().equals(FireStationFragment.class)) {
                emergencyType = "fire_station";
                tv_nearby_services_name.setText("Fire Safety");
            }
            if (fragmentList.get(2).getClass().equals(PoliceStationsFragment.class)) {
                emergencyType = "police";
                tv_nearby_services_name.setText("Security and Order");
            }

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
//                                  run this after accepting the permission -- not working
//                                    if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
//                                        Toasty.info(getActivity(), "Please re-open this service.",
//                                                Toast.LENGTH_LONG, true).show();
//                                    }
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
            }

            getLocation();
            if (mLocation == null) {
                Toasty.info(getActivity(), "Please re-open this service if no data have not shown on the map yet.",
                        Toast.LENGTH_LONG, true).show();
                return;
            }

            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setZoomControlsEnabled(true);

            LATITUDE = mLocation.getLatitude();
            LONGITUDE = mLocation.getLongitude();

            LOCATION = new LatLng(LATITUDE, LONGITUDE);

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(LOCATION)
                    .zoom(13)
                    .bearing(0)
                    .tilt(30)
                    .build();

            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            boolean connected = false;
            ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
            if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                //we are connected to a network
                connected = true;
            } else {
                connected = false;
                Toasty.warning(getContext(), "You can't use this feature without cellular data or internet connection!", Toast.LENGTH_LONG).show();
                return;
            }

            String url = generateUrlPlace(LATITUDE, LONGITUDE);

            new PlaceTask().execute(url);
        }
    };

    //    public EmergencyServiceType emergencyServiceType;
    TextView tv_np_name, tv_np_address, tv_np_cp_number, tv_np_tp_number, tv_nearby_services_name;
    RelativeLayout place_data_container;
    ImageView btn_call_np_tp_hotline, btn_call_np_cp_hotline;
    String tp_num, cp_num;
    ScrollView sv_hospital;
    View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_google_maps, container, false);

        tv_np_cp_number = view.findViewById(R.id.tv_np_cp_number);
        tv_np_name = view.findViewById(R.id.tv_np_name);
        tv_np_address = view.findViewById(R.id.tv_np_address);
        tv_np_tp_number = view.findViewById(R.id.tv_np_tp_number);
        tv_nearby_services_name = view.findViewById(R.id.tv_nearby_services_name);
        place_data_container = view.findViewById(R.id.place_data_container);
        btn_call_np_tp_hotline = view.findViewById(R.id.btn_call_np_tp_hotline);
        btn_call_np_cp_hotline = view.findViewById(R.id.btn_call_np_cp_hotline);
        sv_hospital = view.findViewById(R.id.sv_hospital);
        btn_call_np_cp_hotline.setOnClickListener(this);
        btn_call_np_tp_hotline.setOnClickListener(this);

        if (mMap == null) {
            SupportMapFragment mapFragment = (WorkaroundMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    mMap = googleMap;
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    mMap.getUiSettings().setZoomControlsEnabled(true);

                    sv_hospital = view.findViewById(R.id.sv_hospital); //parent scrollview in xml, give your scrollview id value
                    ((WorkaroundMapFragment) getChildFragmentManager().findFragmentById(R.id.map))
                            .setListener(new WorkaroundMapFragment.OnTouchListener() {
                                @Override
                                public void onTouch() {
                                    sv_hospital.requestDisallowInterceptTouchEvent(true);
                                }
                            });
                }
            });
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_call_np_cp_hotline.getId()) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.CALL_PHONE)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Permission to Call")
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
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + cp_num.trim()));
                getActivity().startActivity(intent);
            }
        }

        if (v.getId() == btn_call_np_tp_hotline.getId()) {
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
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + tp_num.trim()));
                getActivity().startActivity(intent);
            }
        }
    }

    private GoogleMap mMap;
    private double LONGITUDE = 0, LATITUDE = 0;
    private LatLng LOCATION;
    int fragId;
    String emergencyType = "";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toasty.success(getActivity(), "Location Permission enabled",
                        Toast.LENGTH_LONG, true).show();
                Fragment fragment = null;
                if(getParentFragment().getClass().equals(HospitalFragment.class)) {
                    fragment = new HospitalFragment();
                }
                if(getParentFragment().getClass().equals(FireStationFragment.class)) {
                    fragment = new FireStationFragment();
                }
                if(getParentFragment().getClass().equals(PoliceStationsFragment.class)) {
                    fragment = new PoliceStationsFragment();
                }

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.home_fragment_container, fragment);
                ft.addToBackStack("emergency_services");
                ft.commit();
            } else {
                Toasty.error(getActivity(), "Location Permission denied",
                        Toast.LENGTH_LONG, true).show();
            }
        }
        if (requestCode == 101) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toasty.success(getActivity(), "Call Permission enabled",
                        Toast.LENGTH_LONG, true).show();
            }
        }
    }

    LocationManager locationManager;
    Location mLocation;

    @SuppressLint("MissingPermission")
    public void getLocation() {
        try {
            locationManager = (LocationManager) getActivity().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, GoogleMapsFragment.this);
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
        LATITUDE = location.getLatitude();
        LONGITUDE = location.getLongitude();
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        // crash app dito lods
//        Toasty.warning(getActivity(), "Please refresh this page to enable gps.",
//                Toast.LENGTH_LONG, true).show();
    }


    @Override
    public void onProviderDisabled(@NonNull String provider) {
//        may error
        Toasty.warning(getActivity(), "Please turn on your gps!",
                Toast.LENGTH_LONG, true).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    // gmap api request
    public String generateUrlPlace(Double lat, Double lng) {

        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                "location=" + lat + "," + lng +
                "&radius=5000" +
                "&type=" + emergencyType +
                "&sensor=true" +
                "&key=" + getResources().getString(R.string.google_api_key);

        return url;
    }

    public String generateUrlNumber(String place_id) {

        String url = "https://maps.googleapis.com/maps/api/place/details/json?" +
                "placeid=" + place_id +
                "&key=" + getResources().getString(R.string.google_api_key);

        return url;
    }

    ArrayList<String> nearbyPlaceName = new ArrayList<>();
    ArrayList<String> nearbyPlaceId = new ArrayList<>();

    // nearby place
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

            connection.getErrorStream();

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
            if (s == null) {
                Toast.makeText(getActivity(), "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!s.contains("ZERO_RESULTS")) {
                new ParserTask().execute(s);
            } else {
                Toasty.warning(getActivity(), "Sorry, we're unable to locate any nearby services in your area.",
                        Toast.LENGTH_LONG, true).show();
            }
        }

        private class ParserTask extends AsyncTask<String, Integer, List<HashMap<String, String>>> {

            @Override
            protected List<HashMap<String, String>> doInBackground(String... strings) {
                JsonParser jsonParser = new JsonParser();

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
                mMap.clear();
                for (int i = 0; i < hashMaps.size(); i++) {
                    HashMap<String, String> hashMap = hashMaps.get(i);

                    //store data in the variable
                    double lat = Double.parseDouble(hashMap.get("lat"));
                    double lng = Double.parseDouble(hashMap.get("lng"));
                    String name = hashMap.get("name");
                    String address = hashMap.get("address");
                    String place_id = hashMap.get("place_id");

                    LatLng latLng = new LatLng(lat, lng);

                    MarkerOptions options = new MarkerOptions();

                    options.position(latLng);

                    options.title(name);
                    options.snippet(address);

                    nearbyPlaceName.add(name);
                    nearbyPlaceId.add(place_id);

                    if (emergencyType.equals("fire_station")) {
                        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_nearby_firestation));
                    }
                    if (emergencyType.equals("hospital")) {
                        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_nearby_hospital));
                    }
                    if (emergencyType.equals("police")) {
                        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_nearby_police));
                    }

                    mMap.addMarker(options);

                    mMap.addMarker(new MarkerOptions()
                            .anchor(0.0f, 0.1f)
                            .position(LOCATION)
                            .title("My Location")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_main_marker))
                    );
                }
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        String title = marker.getTitle();
                        String place_id = null;

                        for (int i = 0; i < nearbyPlaceName.size(); i++) {
                            if (title.equals(nearbyPlaceName.get(i))) {
                                place_id = nearbyPlaceId.get(i);
                            }
                        }

                        String urlNumber = generateUrlNumber(place_id);
                        new PlaceTaskPlace().execute(urlNumber);

                        return false;
                    }
                });

            }
        }
    }

    // place number
    public class PlaceTaskPlace extends AsyncTask<String, Integer, String> {

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
            if (s.contains("formatted_phone_number") && s.contains("international_phone_number")) {
                btn_call_np_cp_hotline.setVisibility(View.VISIBLE);
                btn_call_np_tp_hotline.setVisibility(View.VISIBLE);
                sv_hospital.post(new Runnable() {
                    public void run() {
                        sv_hospital.smoothScrollBy(0, sv_hospital.getBottom());
                    }
                });
                new ParserTaskPlace().execute(s);


            } else {
                btn_call_np_cp_hotline.setVisibility(View.GONE);
                btn_call_np_tp_hotline.setVisibility(View.GONE);
                Toasty.warning(getActivity(), "No contact information fetched on that current marker.",
                        Toast.LENGTH_LONG, true).show();
                tv_np_name.setText("This marker didn't provide a contact data ");
                tv_np_address.setText("This marker didn't provide a contact data");
                tv_np_cp_number.setText("This marker didn't provide a contact data");
                tv_np_tp_number.setText("This marker didn't provide a contact data");
            }
        }

        private class ParserTaskPlace extends AsyncTask<String, Integer, List<HashMap<String, String>>> {

            @Override
            protected List<HashMap<String, String>> doInBackground(String... strings) {
                JsonParserPlace jsonParserPlace = new JsonParserPlace();

                List<HashMap<String, String>> mapList = null;
                JSONObject object = null;
                try {
                    object = new JSONObject(strings[0]);

                    mapList = jsonParserPlace.parseResult(object);
                } catch (JSONException e) {
                    e.printStackTrace();

                }
                return mapList;
            }

            @Override
            protected void onPostExecute(List<HashMap<String, String>> hashMaps) {
                HashMap<String, String> hashMap = hashMaps.get(0);

                //store data in the variable
                String name = hashMap.get("name");
                String address = hashMap.get("address");
                String phone_num = hashMap.get("phone_num");
                String cellphone_num = hashMap.get("cellphone_num");

                tv_np_name.setText(name);
                tv_np_address.setText(address);
                tv_np_cp_number.setText(cellphone_num.trim());
                tv_np_tp_number.setText(phone_num.trim());

                tp_num = phone_num;
                cp_num = cellphone_num;
            }
        }
    }


}



