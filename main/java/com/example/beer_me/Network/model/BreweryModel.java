package com.example.beer_me.Network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

public class BreweryModel implements Parcelable
{
    //this will get all the info for the beers
    @SerializedName("breweryId")
    private String BreweryID;

    @SerializedName("brewery")
    private JsonObject breweryObj;

    @SerializedName("latitude")
    private double lat;

    @SerializedName("longitude")
    private double lng;

    private double distance = 0;

    protected BreweryModel(Parcel in) {
        BreweryID = in.readString();
    }

    public static final Creator<BreweryModel> CREATOR = new Creator<BreweryModel>() {
        @Override
        public BreweryModel createFromParcel(Parcel in) {
            return new BreweryModel(in);
        }

        @Override
        public BreweryModel[] newArray(int size) {
            return new BreweryModel[size];
        }
    };

    public String getBreweryName() {
        return breweryObj.get("name").toString().replace("\"","");
    }

    public String getBreweryID(){ return BreweryID;}

    public double getLat(){return lat;}

    public double getLng(){return lng;}

    public double getDistance(){return distance;}

    public void setDistance(double distance1){distance = distance1;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(BreweryID);
    }
}