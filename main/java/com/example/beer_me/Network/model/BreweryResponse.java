package com.example.beer_me.Network.model;
import com.example.beer_me.Utility.BreweryParser;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BreweryResponse {


    @SerializedName("data")
    private List<BreweryModel> Breweries;

    public List<BreweryModel> getBreweries() {
        return Breweries;
    }

}