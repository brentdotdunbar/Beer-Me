package com.example.beer_me.Network;

import android.os.AsyncTask;
import android.util.Log;

import com.example.beer_me.Network.model.BreweryModel;
import com.example.beer_me.Utility.BreweryParser;

import java.util.List;

public class BrewerySearchAsyncTask extends AsyncTask<String , Void, List<BreweryModel>>
{

    private BreweryListener listener;

    public void setListener(BreweryListener listener)
    {
        this.listener = listener;
    }

    @Override
    protected List<BreweryModel> doInBackground(String... params) {
        //what we are searching for
        String searchTerm = params[0];
        Log.d("SearchAsyncTask", "doInBackground" + searchTerm);

        //get the json response from BeerApi
        String responseJson = BrewerySearchApi.searchBreweries(searchTerm);


        //success?
        if (responseJson != null)
        {
            List<BreweryModel> breweryModelList = BreweryParser.getMatches(responseJson);
            return breweryModelList;
        }
        //was not successful so return null
        return null;
    }

    @Override
    protected void onPostExecute(List<BreweryModel> breweryModels)
    {
        super.onPostExecute(breweryModels);
        Log.d("SearchAsyncTask","onPostExecute: " + breweryModels);
        listener.onBreweryCallback(breweryModels);
    }

    public interface BreweryListener {
        void onBreweryCallback(List<BreweryModel> models);
    }
}