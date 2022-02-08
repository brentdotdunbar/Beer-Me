package com.example.beer_me.Network.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class BreweryContentsModel {
    //this will get all the info for the beers
    @SerializedName("name")
    private String BreweryName;

    @SerializedName("description")
    private String BreweryDesc;

    @SerializedName("streetAdress")
    private String BreweryStrAdd;

    @SerializedName("locality")
    private String BreweryLocal;

    @SerializedName("region")
    private String BreweryRegion;

    @SerializedName("locations")
    private JsonArray breweryLocations;


    public String getBreweryName() {
        return BreweryName;
    }

    public String getBreweryDesc(){return BreweryDesc;}

    public String getBreweryWebsite() {
        JsonObject usefulObj = breweryLocations.get(0).getAsJsonObject();
        if (usefulObj.get("website")!= null) {
            return usefulObj.get("website").toString().replace("\"", "");
        }
        return "No Website Found";
    }

    public String getBreweryPhoneNum(){
        JsonObject usefulObj = breweryLocations.get(0).getAsJsonObject();
        if(usefulObj.get("phone") != null) {
            return usefulObj.get("phone").toString().replace("\"", "");
        }
        return "No phone number found";
    }

    public String getBreweryStrAdd(){
        JsonObject usefulObj = breweryLocations.get(0).getAsJsonObject();
        if(usefulObj.get("streetAddress") == null || usefulObj.get("locality") == null || usefulObj.get("region") == null){
            return "No address found";
        }
        String streetaddress = usefulObj.get("streetAddress").toString().replace("\"","");

        String city = usefulObj.get("locality").toString().replace("\"","");

        String state = usefulObj.get("region").toString().replace("\"","");
        return streetaddress + " " + city + " " + state;
    }




}