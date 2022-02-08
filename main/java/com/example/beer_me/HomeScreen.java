package com.example.beer_me;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
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
import android.widget.Button;
import android.widget.TextView;

//import com.example.beer_me.beers.BeerSearch;
import com.example.beer_me.Utility.BeerFactsGenerator;
import com.example.beer_me.beers.BeerSearch;
import com.example.beer_me.brewery.BrewerySearch;

import java.util.List;

public class HomeScreen extends AppCompatActivity {

    private Button beerSearch;
    private Button brewerySearch;
    private Button favoriteSearch;
    private TextView beerFact;
    LocationManager locationManager;
    Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //sets the views and listeners for button

        beerSearch = findViewById(R.id.beer_button);
        brewerySearch = findViewById(R.id.brewery_button);
        favoriteSearch = findViewById(R.id.favorite_button);
        beerFact = findViewById(R.id.beer_fact);
        beerFact.setText("Did you know: "+ BeerFactsGenerator.getRandomFact());
        locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        isLocationEnabled();
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] perms = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
            requestPermissions(perms,1);
        }
        //isLocationEnabled();
        beerSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, BeerSearch.class);
                startActivity(intent);

            }
        });

        brewerySearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, BrewerySearch.class);
                startActivity(intent);

            }
        });

    }

    private void isLocationEnabled() {
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
            alertDialog.setTitle("Enable Location");
            alertDialog.setMessage("Your locations setting is not enabled. If you do not enable them the app may behave erratically");
            alertDialog.setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                }
            });
            alertDialog.setNegativeButton("Take Me to the app", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });
            AlertDialog alert = alertDialog.create();
            alert.show();
        } else {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        }
    }
}
