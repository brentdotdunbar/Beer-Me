package com.example.beer_me.beers;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.beer_me.Network.model.BeerModel;
import com.example.beer_me.R;

public class BeerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView beerNameText;
    BeerViewAdapter.OnBeerListener onBeerListener;


    public BeerViewHolder(View beerView, BeerViewAdapter.OnBeerListener onBeerListener)
    {
        super(beerView);
        beerNameText = beerView.findViewById(R.id.beer_name);

        this.onBeerListener = onBeerListener;

        itemView.setOnClickListener(this);
    }

    public void bindView(BeerModel model)
    {
        String BeerName = model.getBeerName();
        beerNameText.setText(BeerName);

    }

    @Override
    public void onClick(View v) {
        onBeerListener.onBeerClick(getAdapterPosition());
    }
}