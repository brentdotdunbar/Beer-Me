package com.example.beer_me.beers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beer_me.HomeScreen;
import com.example.beer_me.Network.BeerSearchAsyncTask;
import com.example.beer_me.Network.model.BeerModel;
import com.example.beer_me.R;

import java.util.Dictionary;
import java.util.List;

//import com.example.beer_me.Network.LocationFromIDAsyncTask;

public class BeerSearch extends AppCompatActivity implements BeerViewAdapter.OnBeerListener {


    private Button searchButton;
    private EditText searchEditText;
    private RecyclerView recyclerView;

    private List<BeerModel> BeerCollection;
    Button backButton;
    private Dictionary Locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_search_page);
        //sets the views and listeners for button

        searchButton = findViewById(R.id.search_button);
        searchEditText = findViewById(R.id.search_edit_text);
        recyclerView = findViewById(R.id.recycler_view);
        backButton = findViewById(R.id.back_button);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                BeerSearchAsyncTask task = new BeerSearchAsyncTask();
                task.setListener(new BeerSearchAsyncTask.BeerListener() {
                    @Override
                    public void onBeerCallback(List<BeerModel> models) {
                        BeerCollection=models;
                        BeerViewAdapter newViewAdapter = new BeerViewAdapter(models, BeerSearch.this);
                        recyclerView.setAdapter(newViewAdapter);


                    }
                });
                task.execute(searchEditText.getText().toString());
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeerSearch.this, HomeScreen.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBeerClick(int pos) {
        Intent intent = new Intent(BeerSearch.this, com.example.beer_me.beers.BeerLanding.class);
        intent.putExtra("BeerItem", BeerCollection.get(pos));
        startActivity(intent);
    }
}