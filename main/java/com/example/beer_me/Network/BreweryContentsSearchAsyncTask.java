package com.example.beer_me.Network;

import android.os.AsyncTask;
import android.util.Log;

import com.example.beer_me.Network.model.BreweryContentsModel;
import com.example.beer_me.Utility.BreweryContentsParser;

import java.util.List;

public class BreweryContentsSearchAsyncTask extends AsyncTask<String , Void, BreweryContentsModel>
{

    private BreweryContentsListener listener;

    public void setListener(BreweryContentsListener listener)
    {
        this.listener = listener;
    }

    @Override
    protected BreweryContentsModel doInBackground(String... params) {
        //what we are searching for
        String searchTerm = params[0];
        Log.d("SearchAsyncTask", "doInBackground" + searchTerm);

        //get the json response from BeerApi
        String responseJson = BreweryContentsApi.searchBreweries(searchTerm);


        //success?
        if (responseJson != null)
        {
            BreweryContentsModel breweryModelList = BreweryContentsParser.getMatches(responseJson);
            return breweryModelList;
        }
        //was not successful so return null
        return null;
    }

    @Override
    protected void onPostExecute(BreweryContentsModel breweryModels)
    {
        super.onPostExecute(breweryModels);
        Log.d("SearchAsyncTask","onPostExecute: " + breweryModels);
        listener.onBreweryContentsCallback(breweryModels);
    }

    public interface BreweryContentsListener {
        void onBreweryContentsCallback(BreweryContentsModel models);
    }
}