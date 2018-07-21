package com.example.mohamedelnhrawy.baseproject.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.util.Locale;

/**
 * Created by cems-it on 4/10/2018.
 */

public class GetLocation {
    private static FusedLocationProviderClient fusedLocationProviderClient;
    private LocationRequest locationRequest;
    private static LocationCallback locationCallback;
    private static final int REQUEST_CODE = 100;
    private Activity context;

    public GetLocation(Activity context) {
        this.context = context;
    }



    public void PermissionChecked() {
        if (ActivityCompat.shouldShowRequestPermissionRationale
                (context, Manifest.permission.ACCESS_FINE_LOCATION)) {
            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}
                    , REQUEST_CODE);
        } else {
            // location granted
            buildLocationRequest();
            buildLocationCallback();
            fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(context);
            startGetLocation();

        }
    }

    private void buildLocationRequest() {
        locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setSmallestDisplacement(10);
    }


    private void buildLocationCallback() {
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                for (Location location : locationResult.getLocations()) {

                    Log.e("lat",""+location.getLatitude());
                    Log.e("lng",""+location.getLongitude());

                    new GetAddress(context).execute(String.format(Locale.ENGLISH,"%.4f,%.4f",location.getLatitude()
                            ,location.getLongitude()));
                    fusedLocationProviderClient.removeLocationUpdates(locationCallback);



                }
            }

            @Override
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                super.onLocationAvailability(locationAvailability);
            }
        };
    }

    void startGetLocation() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}
                    , REQUEST_CODE);
            return;
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback
                , Looper.myLooper());
    }

    public static void onDestroy()
    {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }

}
