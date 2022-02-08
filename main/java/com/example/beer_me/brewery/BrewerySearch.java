package com.example.beer_me.brewery;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beer_me.HomeScreen;
import com.example.beer_me.Network.BrewerySearchAsyncTask;
import com.example.beer_me.Network.GetLocationWithPerms;
import com.example.beer_me.Network.model.BreweryModel;
import com.example.beer_me.R;
import com.example.beer_me.Utility.LatLngMath;

import java.util.List;


public class BrewerySearch extends AppCompatActivity implements BreweryViewAdapter.OnBreweryListener {

    private Button searchButton;
    private EditText searchEditText;
    private RecyclerView recyclerView;

    private List<BreweryModel> BreweryCollection;
    Button backButton;
    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brewery_search_page);
        //sets the views and listeners for button

        searchButton = findViewById(R.id.search_button);
        searchEditText = findViewById(R.id.search_edit_text);
        recyclerView = findViewById(R.id.recycler_view);

        backButton = findViewById(R.id.back_button);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        LocationManager locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        double[] curLoc;


        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(location == null){
            double[] locationDouble = GetLocationWithPerms.getLocation(mContext,BrewerySearch.this);
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if (location != null){
                    double lat = location.getLatitude();
                    double lng = location.getLongitude();
                    double[] curLoc = new double[]{lat,lng};

                BrewerySearchAsyncTask task = new BrewerySearchAsyncTask();
                task.setListener(new BrewerySearchAsyncTask.BreweryListener() {
                    @Override
                    public void onBreweryCallback(List<BreweryModel> models) {
                        BreweryCollection = models;
                        BreweryViewAdapter newViewAdapter = new BreweryViewAdapter(models, BrewerySearch.this);
                        recyclerView.setAdapter(newViewAdapter);
                        if (models.size() != 0) {
                            for (int i = 0; i < models.size(); i++) {
                                BreweryModel model = models.get(i);
                                model.setDistance(LatLngMath.distance(curLoc[0], curLoc[1], model.getLat(), model.getLng()));
                            }
                            newViewAdapter.notifyDataSetChanged();

                        }
                    }
                });



                    String locString = String.valueOf(curLoc[0]) + " " + String.valueOf(curLoc[1]);
                    task.execute(locString);
                }

            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BrewerySearch.this, HomeScreen.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBreweryClick(int pos) {
        Intent intent = new Intent(BrewerySearch.this, BreweryLanding.class);
        intent.putExtra("BreweryItem", BreweryCollection.get(pos));
        startActivity(intent);
    }
}