package com.example.beer_me.brewery;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.beer_me.Network.BreweryContentsSearchAsyncTask;
import com.example.beer_me.Network.model.BreweryContentsModel;
import com.example.beer_me.Network.model.BreweryModel;
import com.example.beer_me.R;

public class BreweryLanding extends AppCompatActivity {
    Button backButton;
    TextView nameText;
    TextView descText;
    TextView phoneNumber;
    TextView streetAddress;
    TextView website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brewery_landing);
        Intent intent = getIntent();

        BreweryModel breweryModel = intent.getParcelableExtra("BreweryItem");


        String breweryID = breweryModel.getBreweryID();

        backButton = findViewById(R.id.backButton);
        nameText = findViewById(R.id.nameText);
        descText = (TextView) findViewById(R.id.desc_text);
        phoneNumber = findViewById(R.id.phone_number);
        website = findViewById(R.id.website);
        streetAddress = findViewById(R.id.street_address);

        descText.setMovementMethod(new ScrollingMovementMethod());

        BreweryContentsSearchAsyncTask task = new BreweryContentsSearchAsyncTask();
        task.setListener(new BreweryContentsSearchAsyncTask.BreweryContentsListener() {
            @Override
            public void onBreweryContentsCallback(BreweryContentsModel models) {
                if(models != null) {
                    descText.setText(models.getBreweryDesc());
                    nameText.setText(models.getBreweryName());
                    phoneNumber.setText(models.getBreweryPhoneNum());
                    website.setText(models.getBreweryWebsite());
                    streetAddress.setText(models.getBreweryStrAdd());
                }
            }
        });
            task.execute(breweryID);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BreweryLanding.this, BrewerySearch.class);
                startActivity(intent);
            }
        });

    }

}