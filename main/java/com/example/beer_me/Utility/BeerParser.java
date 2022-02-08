package com.example.beer_me.Utility;

import android.util.Log;

import com.example.beer_me.Network.model.BeerModel;
import com.example.beer_me.Network.model.BeerResponse;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class BeerParser {

    private static final String TAG = "RecipeParser";

    /**
     * returns a list of beers that match the search term given
     * @param json String json representing the server's response
     * @return list of beers (as BeerModels)
     */

    public static List<BeerModel> getMatches(String json)
    {
        //creates new gson model
        Gson gson = new Gson();

        //Deserialize json into BeerResponsemodel using gson
        BeerResponse BeerResponseAppModel = gson.fromJson(json, BeerResponse.class);

        //get the list of beer models and return it
        return BeerResponseAppModel.getBeers();
    }

    public static int getTotalMatches(String json)
    {
        int totalmatches = 0;

        try {
            //converts the raw string into a Java JSONObject
            JSONObject response = new JSONObject();

            //deserializes an integer
            totalmatches = response.getInt("totalMatchCount");
        }catch (JSONException e)
        {
            Log.e(TAG, "getTotalMatches: error parsing JSON",e);
        }

        return totalmatches;
    }

}
