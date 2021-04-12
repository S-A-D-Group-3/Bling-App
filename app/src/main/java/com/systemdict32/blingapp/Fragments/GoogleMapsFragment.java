package com.systemdict32.blingapp.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.systemdict32.blingapp.Dashboard;
import com.systemdict32.blingapp.R;

import java.util.zip.Inflater;

public class GoogleMapsFragment extends Fragment {

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

            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION
                }, 100);
            }

            getLocation();

            Criteria locationCritera = new Criteria();
            locationCritera.setAccuracy(Criteria.ACCURACY_FINE);
            locationCritera.setAltitudeRequired(false);
            locationCritera.setBearingRequired(false);
            locationCritera.setCostAllowed(true);
            locationCritera.setPowerRequirement(Criteria.NO_REQUIREMENT);

            String providerName = locationManager.getBestProvider(locationCritera, true);
            Location location  = locationManager.getLastKnownLocation(providerName);

            LATITUDE = location.getLatitude();
            LONGITUDE = location.getLongitude();

            LOCATION = new LatLng(LATITUDE, LONGITUDE);

            if(LOCATION != null){
                mMap.addMarker(new MarkerOptions()
                        .anchor(0.0f, 0.1f)
                        .position(LOCATION)
                        .title("My Location")
                );

                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(LOCATION)
                        .zoom(18)
                        .bearing(0)
                        .tilt(30)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_google_maps, container, false);

        return view;
    }

    private GoogleMap mMap;
    private double LONGITUDE, LATITUDE;
    private LatLng LOCATION;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    LocationManager locationManager;

    @SuppressLint("MissingPermission")
    public void getLocation() {
        try {
            locationManager = (LocationManager) getActivity().getApplicationContext().getSystemService(getActivity().LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, (LocationListener) getActivity());
        } catch (Exception e) {

        }
    }
}