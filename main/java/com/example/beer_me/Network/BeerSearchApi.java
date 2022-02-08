package com.example.beer_me.Network;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BeerSearchApi
{
    private static final String baseApiUrl = "https://sandbox-api.brewerydb.com/v2/beers";
    private static final String key = "Key Goes Here";

    /*This handles the Beer Api search
    @param input either the beer or brewery
    @return String: json response containing matches
     */

    public static String searchBeers(String input)
    {
        //put together the url for api
        HttpUrl.Builder urlbuilder = HttpUrl.parse(baseApiUrl).newBuilder();

        //add more stuff to the url

        urlbuilder.addQueryParameter("name","***"+input+"***");
        urlbuilder.addQueryParameter("key", key);

        String url = urlbuilder.build().toString();


        return getResponse(url);

    }

    private static String getResponse(String url)
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
