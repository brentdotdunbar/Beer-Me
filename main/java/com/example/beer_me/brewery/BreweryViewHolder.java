package com.example.beer_me.brewery;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.beer_me.Network.model.BreweryModel;
import com.example.beer_me.R;

public class BreweryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView beerNameText;
    private TextView distanceText;
    BreweryViewAdapter.OnBreweryListener onBreweryListener;


    public BreweryViewHolder(View beerView, BreweryViewAdapter.OnBreweryListener onBreweryListener)
    {
        super(beerView);
        beerNameText = beerView.findViewById(R.id.brewery_name);
        distanceText = beerView.findViewById(R.id.distance_text);

        this.onBreweryListener = onBreweryListener;

        itemView.setOnClickListener(this);
    }

    public void bindView(BreweryModel model)
    {
        String BreweryName = model.getBreweryName();
        beerNameText.setText(BreweryName);

        double brewDist = model.getDistance();
        distanceText.setText(brewDist+" MI");


    }

    @Override
    public void onClick(View v) {
        onBreweryListener.onBreweryClick(getAdapterPosition());
    }
}
