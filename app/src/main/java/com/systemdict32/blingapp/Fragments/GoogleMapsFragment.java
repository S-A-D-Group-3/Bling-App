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
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.systemdict32.blingapp.Dashboard;
//import com.systemdict32.blingapp.Interfaces.EmergencyServiceType;
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
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

import es.dmoral.toasty.Toasty;

public class GoogleMapsFragment extends Fragment implements LocationListener {

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

            if(fragmentList.get(2).getClass().equals(HospitalFragment.class)){
                emergencyType = "hospital";
            }
            if(fragmentList.get(2).getClass().equals(FireStationFragment.class)){
                emergencyType = "fire_station";
            }
            if(fragmentList.get(2).getClass().equals(PoliceStationsFragment.class)){
                emergencyType = "police";
            }

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


            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setZoomControlsEnabled(true);

            LATITUDE = mLocation.getLatitude();
            LONGITUDE = mLocation.getLongitude();

            String url = generateUrlPlace(LATITUDE, LONGITUDE);

            new PlaceTask().execute(url);

            LOCATION = new LatLng(LATITUDE, LONGITUDE);

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(LOCATION)
                    .zoom(13)
                    .bearing(0)
                    .tilt(30)
                    .build();

            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        }
    };

//    public EmergencyServiceType emergencyServiceType;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_google_maps, container, false);

        return view;
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
        Toasty.warning(getActivity(), "Google Map will not work with your location turned off!",
                Toast.LENGTH_LONG, true).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    // gmap api request
    public String generateUrlPlace(Double lat, Double lng){

        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                "location=" + lat + "," + lng +
                "&radius=5000" +
                "&type=" + emergencyType +
                "&sensor=true" +
                "&key=" + getResources().getString(R.string.google_api_key);

        return url;
    }

    public String generateUrlNumber(String place_id){

        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                "placeid=" + place_id +
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

                for(int i = 0; i < hashMaps.size(); i++) {
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

                    if(emergencyType.equals("fire_station")){
                        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_nearby_firestation));
                    }
                    if(emergencyType.equals("hospital")){
                        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_nearby_hospital));
                    }
                    if(emergencyType.equals("police")){
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
            }
        }
    }
}