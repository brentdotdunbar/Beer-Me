package com.example.beer_me.Utility;

import android.util.Log;

import com.example.beer_me.Network.model.BreweryContentsModel;
import com.example.beer_me.Network.model.BreweryContentsResponse;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class BreweryContentsParser {

    private static final String TAG = "RecipeParser";

    /**
     * returns a list of beers that match the search term given
     * @param json String json representing the server's response
     * @return list of beers (as BreweryContentsModels)
     */

    public static BreweryContentsModel getMatches(String json)
    {
        //creates new gson model
        Gson gson = new Gson();

        //Deserialize json into BreweryContentsResponsemodel using gson
        BreweryContentsResponse BreweryContentsResponseAppModel = gson.fromJson(json, BreweryContentsResponse.class);

        //get the list of beer models and return it
        return BreweryContentsResponseAppModel.getBreweries();
    }

    public static int getTotalMatches(String json)
    {
        int totalmatches = 0;

        try {
            //converts the raw string into a Java JSONObject
            JSONObject response = new JSONObject();

            //deserializes an integer
            totalmatches = response.getInt("totalResults");
        }catch (JSONException e)
        {
            Log.e(TAG, "getTotalMatches: error parsing JSON",e);
        }

        return totalmatches;
    }

}