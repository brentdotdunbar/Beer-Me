package com.example.beer_me.Network.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BreweryContentsResponse {


    @SerializedName("data")
    private BreweryContentsModel Breweries;

    public BreweryContentsModel getBreweries() {
        return Breweries;
    }

}