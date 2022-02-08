package com.example.beer_me.beers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.beer_me.Network.model.BeerModel;
import com.example.beer_me.R;

public class BeerLanding extends AppCompatActivity {
    Button backButton;
    TextView nameText;
    TextView descText;
    TextView abvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_landing);

        Intent intent = getIntent();
        BeerModel beerModel = intent.getParcelableExtra("BeerItem");



        backButton = findViewById(R.id.backButton);
        nameText = findViewById(R.id.nameText);
        descText = findViewById(R.id.descText);

        abvText = findViewById(R.id.abvText);
        descText.setMovementMethod(new ScrollingMovementMethod());

        nameText.setText(beerModel.getBeerName());
        if(beerModel.getBeerAbv() != null){
            abvText.setText("ABV: " + beerModel.getBeerAbv() + "%");
        }
        if(beerModel.getBeerDesc() != null) {
            descText.setText(beerModel.getBeerDesc());
        }
        else{
            descText.setText("Description not available");
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeerLanding.this, com.example.beer_me.beers.BeerSearch.class);

                startActivity(intent);
            }
        });

    }
}
