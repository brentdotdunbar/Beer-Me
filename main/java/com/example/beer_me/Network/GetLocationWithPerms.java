package com.example.beer_me.Network;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class GetLocationWithPerms extends AppCompatActivity {
    public static LocationManager locationManager;

    public static double[] getLocation(Context context, Activity activity){
        checkLocPerms(context,activity);
        getLocationUpdates(context,activity);
        return getLatLng();
    }

    public static void checkLocPerms(Context context, Activity activity){
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            getLocationUpdates(context,activity);
        }
    }

    public static void getLocationUpdates(Context context,Activity activity){
        checkLocPerms(context, activity);
        locationManager=(LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListenerGPS);
        }
        catch (SecurityException ex){
            //
        }
        isLocationEnabled(context);
    }
    protected void onResume(){
        super.onResume();
    }
    public static  LocationListener locationListenerGPS=new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };
    private static void isLocationEnabled(Context context) {

        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            AlertDialog.Builder alertDialog=new AlertDialog.Builder(context);
            alertDialog.setTitle("Enable Location");
            alertDialog.setMessage("Your locations setting is not enabled. Please enabled it in settings menu.");
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    dialog.cancel();
                }
            });
            AlertDialog alert=alertDialog.create();
            alert.show();
        }

    }
    private static double[] getLatLng(){
        try {
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null){
                double lat = location.getLatitude();
                double lng = location.getLongitude();
                double[] latlng = new double[]{lat,lng};
                return latlng;
            }
        }
        catch (SecurityException ex){
        }

        return null;
    }
}
