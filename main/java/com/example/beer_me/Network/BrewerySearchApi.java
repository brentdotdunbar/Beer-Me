package com.example.beer_me.Network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BrewerySearchApi
{
    private static final String baseApiUrl = "https://sandbox-api.brewerydb.com/v2/search/geo/point";
    private static final String key = "key goes here";

    /*This handles the Brewery Api search
    @param input either the beer or brewery
    @return String: json response containing matches
     */
    public static String searchBreweries(String response)
    {

        String[] x = response.split(" ");
        //put together the url for api
        HttpUrl.Builder urlbuilder = HttpUrl.parse(baseApiUrl).newBuilder();

        //add more stuff to the url

        urlbuilder.addQueryParameter("lat",x[0]);
        urlbuilder.addQueryParameter("lng",x[1]);
        urlbuilder.addQueryParameter("radius","100");
        urlbuilder.addQueryParameter("withAlternateNames","y");
        urlbuilder.addQueryParameter("key", key);

        String url = urlbuilder.build().toString();


        return getResponse(url);
    }

    public static String getResponse(String url)
    {
        Request request = new Request.Builder().url(url).build();

        OkHttpClient client = new OkHttpClient();

        try {
            Response response = client.newCall(request).execute();

            return response.body().string();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;

    }
}
