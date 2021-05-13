package com.systemdict32.blingapp;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.systemdict32.blingapp.Fragments.AboutFragment;
import com.systemdict32.blingapp.Fragments.HelpFragment;
import com.systemdict32.blingapp.Fragments.HomeFragment;
import com.systemdict32.blingapp.Fragments.JsonParserLGU;
import com.systemdict32.blingapp.Fragments.LGUFragment;
import com.systemdict32.blingapp.Fragments.MyAccountFragment;
import com.systemdict32.blingapp.Fragments.MyICEFragment;

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

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, LocationListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentManager fm;
    HomeFragment homeFragment;
    FirebaseFirestore fStore;
    FirebaseAuth firebaseAuth;
    String fullName, email, address, bloodType, contactPerson, contactPersonNum, medCondition, medTake, userId;
    TextView tv_user_name;
    View chatbot_fragment;
    BottomNavigationView top_nav_view;
    private FirebaseAuth mFireAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mFireAuth = FirebaseAuth.getInstance();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View home = inflater.inflate(R.layout.fragment_home, null);
        homeFragment = new HomeFragment();
        fm = getSupportFragmentManager();

        fm.beginTransaction().add(R.id.dashboard_fragment_container, homeFragment).addToBackStack("nav_home").commit();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_vieww);
        toolbar = findViewById(R.id.toolbar);
        top_nav_view = (BottomNavigationView) home.findViewById(R.id.top_nav_view);
        chatbot_fragment = findViewById(R.id.chatbot_fragment);

        View header = navigationView.getHeaderView(0);

        top_nav_view.setSelectedItemId(R.id.nav_emergency);

        tv_user_name = header.findViewById(R.id.tv_user_name);

        /*----------toolbar TO PREEE------*/
        setSupportActionBar(toolbar);

        /*----------navi  drawer meenuu TO PREEE------*/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        // get data from firebase
        firebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            userId = firebaseAuth.getCurrentUser().getUid();
        } else {
            Intent intent = new Intent(Dashboard.this, Login.class);
            startActivity(intent);
            return;
        }


        fStore.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if (document.getId().equals(userId)) {
                            fullName = document.getString("user_FN");
                            email = document.getString("user_Email");
                            address = document.getString("user_ICE_ADDRESS");
                            bloodType = document.getString("user_ICE_BLOODTYPE");
                            contactPerson = document.getString("user_ICE_CONTACTPERSON");
                            contactPersonNum = document.getString("user_ICE_CONTACTPERSON_NUMBER");
                            medCondition = document.getString("user_ICE_MEDICALCONDITION");
                            medTake = document.getString("user_ICE_MEDICINETAKE");
                            // set username on nav view
                            tv_user_name.setText(fullName);
                        }
                    }
                } else {

                }
            }
        });

        getLatLng();
    }

    @Override
    protected void onStart() {
        super.onStart();
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
            FirebaseUser mFireUser = mFireAuth.getCurrentUser();
            if (mFireUser != null) {

                // eto onse yung di na need ng sharedpref//
                // Toasty.info(Dashboard.this, "Login verified"
                //                   , Toast.LENGTH_LONG, true).show();
            } else {
                Toasty.warning(Dashboard.this, "Oops, you must login first!"
                        , Toast.LENGTH_LONG, true).show();
                Intent intentCheck = new Intent(getApplicationContext(), Login.class);
                intentCheck.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentCheck);
                finish();
            }
        } else {
            connected = false;
            Toasty.info(this, "You are on offline mode!", Toast.LENGTH_LONG).show();
        }


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // get home fragment
        Fragment selectedFragment = null;
        String backstackName = null;
        switch (item.getItemId()) {
            case R.id.nav_home:
                selectedFragment = new HomeFragment();
                backstackName = "nav_home";
                chatbot_fragment.setVisibility(View.VISIBLE);
                break;
            case R.id.nav_account:
                selectedFragment = new MyAccountFragment();
                backstackName = "nav_account";
                chatbot_fragment.setVisibility(View.GONE);
                break;

            case R.id.nav_ice:
                selectedFragment = new MyICEFragment();
                backstackName = "nav_ice";
                chatbot_fragment.setVisibility(View.GONE);
                break;

            case R.id.nav_help:
                selectedFragment = new HelpFragment();
                backstackName = "nav_help";
                chatbot_fragment.setVisibility(View.GONE);
                break;

            case R.id.nav_about:
                selectedFragment = new AboutFragment();
                backstackName = "nav_about";
                chatbot_fragment.setVisibility(View.GONE);
                break;

            case R.id.nav_exitt:
                firebaseAuth.getInstance().signOut();
                mFireAuth.signOut();
                hideNotification(this);
                Intent intentExit = new Intent(getApplicationContext(), Login.class);
                intentExit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentExit);
                System.exit(0);


        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_fragment_container, selectedFragment);
        ft.addToBackStack(backstackName);
        ft.commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(this, Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        // call ice button
        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("ice_cell_num", mContactPersonNum);
        PendingIntent actionIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // call emergency hotline
        Intent broadcastIntent2 = new Intent(this, NotificationReceiver2.class);
        broadcastIntent2.putExtra("lgu_hotline_num", lgu_hotline_num);
        PendingIntent actionIntent2 = PendingIntent.getBroadcast(this, 2, broadcastIntent2, PendingIntent.FLAG_UPDATE_CURRENT);

        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
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

        notificationManager = NotificationManagerCompat.from(this);
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
    protected void onPause() {
        super.onPause();
        if (bloodType != null && address != null && contactPersonNum != null && contactPerson != null && medTake != null && medCondition != null) {
            showNotification(fullName, address, medCondition, medTake, bloodType, contactPerson, contactPersonNum);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bloodType != null && address != null && contactPersonNum != null && contactPerson != null && medTake != null && medCondition != null) {
            showNotification(fullName, address, medCondition, medTake, bloodType, contactPerson, contactPersonNum);
        }
    }

    boolean isExit = false;

    @Override
    public void onBackPressed() {
        // working pero may bugs pa
        // --update-- working na, pwera dun na lang sa paglipat between nearby emergency at instruction
        int stackCount = getSupportFragmentManager().getBackStackEntryCount();
//        Toast.makeText(this, String.valueOf(getSupportFragmentManager().getBackStackEntryAt(stackCount - 2)), Toast.LENGTH_SHORT).show();
        if (stackCount < 2) {
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);

            if (isExit) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
            isExit = true;

        } else {
            getSupportFragmentManager().popBackStack();
            FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(stackCount - 2);
            highlightNavViewOnBackPressed(backStackEntry.getName());
        }
    }

    public void highlightNavViewOnBackPressed(String backStackName) {
        // not working lods
//        if (backStackName.equals("nav_emergency") || backStackName.equals("emergency_services")) {
//            top_nav_view.setSelectedItemId(R.id.nav_emergency);
//            navigationView.setCheckedItem(R.id.nav_home);
//
//        }
//
//        if (backStackName.equals("nav_instruction") || backStackName.equals("instruction_category") || backStackName.equals("instruction_sub_category")) {
//            top_nav_view.setSelectedItemId(R.id.top_nav_view);
//            navigationView.setCheckedItem(R.id.nav_home);
//        }

        if (backStackName.equals("nav_home") && backStackName != null) {
            navigationView.setCheckedItem(R.id.nav_home);

        }

        if (backStackName.equals("nav_account") && backStackName != null) {
            navigationView.setCheckedItem(R.id.nav_account);
        }

        if (backStackName.equals("nav_ice") && backStackName != null) {
            navigationView.setCheckedItem(R.id.nav_ice);
        }

        if (backStackName.equals("nav_help") && backStackName != null) {
            navigationView.setCheckedItem(R.id.nav_help);
        }

        if (backStackName.equals("nav_about") && backStackName != null) {
            navigationView.setCheckedItem(R.id.nav_about);
        }


    }

    // get lgu hotline
    public void getLatLng() {
        getLocation();
        if (mLocation == null) {
            return;
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
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
            locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
            mLocation = getLastKnownLocation();
        } catch (Exception e) {
            Toasty.error(this, "Location provider not found! Turn on your location!",
                    Toast.LENGTH_LONG, true).show();
        }
    }

    private Location getLastKnownLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }
        // eto yung puki ng inang nagpagana sa map
        // https://stackoverflow.com/questions/20438627/getlastknownlocation-returns-null
        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
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
        Toasty.warning(this, "Turn on your gps/location!",
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
