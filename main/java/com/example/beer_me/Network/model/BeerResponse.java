package com.example.beer_me.Network.model;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BeerResponse {

    @SerializedName("data")
    private List<BeerModel> beers;

    public List<BeerModel> getBeers() {
        return beers;
    }
}
