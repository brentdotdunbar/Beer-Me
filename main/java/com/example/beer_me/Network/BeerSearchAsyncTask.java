package com.example.beer_me.Network;

import android.os.AsyncTask;
import android.util.Log;

import com.example.beer_me.Network.model.BeerModel;
import com.example.beer_me.Utility.BeerParser;

import java.util.List;

public class BeerSearchAsyncTask extends AsyncTask<String , Void, List<BeerModel>>
{

    private BeerListener listener;

    public void setListener(BeerListener listener)
    {
        this.listener = listener;
    }

    @Override
    protected List<BeerModel> doInBackground(String... params) {
        //what we are searching for
        String searchTerm = params[0];
        Log.d("SearchAsyncTask", "doInBackground" + searchTerm);

        //get the json response from BeerApi
        String responseJson = BeerSearchApi.searchBeers(searchTerm);


        //success?
        if (responseJson != null)
        {
            List<BeerModel> beerModelList = BeerParser.getMatches(responseJson);

            return beerModelList;
        }
        //was not successful so return null
        return null;
    }

    @Override
    protected void onPostExecute(List<BeerModel> beerModels)
    {
        super.onPostExecute(beerModels);
        Log.d("SearchAsyncTask","onPostExecute: " + beerModels);
        listener.onBeerCallback(beerModels);
    }

    public interface BeerListener {
        void onBeerCallback(List<BeerModel> models);
    }
}
