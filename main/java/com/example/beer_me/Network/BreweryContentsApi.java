package com.example.beer_me.Network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BreweryContentsApi
{
    private static final String baseApiUrl = "https://sandbox-api.brewerydb.com/v2/brewery/";
    private static final String key = "Key Goes Here";

    /*This handles the Brewery Api search
    @param input either the beer or brewery
    @return String: json response containing matches
     */
    public static String searchBreweries(String id)
    {

        //put together the url for api
        HttpUrl.Builder urlbuilder = HttpUrl.parse(baseApiUrl).newBuilder();

        //add more stuff to the url
        urlbuilder.addPathSegment(id);
        urlbuilder.addQueryParameter("withLocations","y");
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
