package com.example.beer_me.Network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BeerModel implements Parcelable
{
    //this will get all the info for the beers
    @SerializedName("name")
    private String BeerName;
    @SerializedName("abv")
    private String BeerAbv;
    @SerializedName("description")
    private String BeerDesc;
    @SerializedName("id")
    private String BeerID;

    private List<String> smallImageUrls;

    protected BeerModel(Parcel in)
    {
        BeerName = in.readString();
        BeerAbv = in.readString();
        BeerDesc = in.readString();
        BeerID= in.readString();
    }

    public static final Parcelable.Creator<BeerModel> CREATOR = new Parcelable.Creator<BeerModel>() {
        @Override
        public BeerModel createFromParcel(Parcel in) {
            return new BeerModel(in);
        }

        @Override
        public BeerModel[] newArray(int size) {
            return new BeerModel[size ];
        }
    };

    public String getBeerName() {
        return BeerName;
    }

    public String getBeerAbv() {
        return BeerAbv;
    }

    public String getBeerDesc() {
        return BeerDesc;
    }

    public String getBeerID() {
        return BeerID;
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(BeerName);
        dest.writeString(BeerAbv);
        dest.writeString(BeerDesc);
        dest.writeString(BeerID);
    }

    /*public String getOriginBrewery() {
        return OriginBrewery;
    }

    public int getAlcoholAvg() {
        return AlcoholAvg;
    }

    public int getOZ() {
        return OZ;
    }

    public String getBeerType() {
        return BeerType;
    }

    public String getPlacebottled() {
        return Placebottled;
    }

    public String getIngredients() {
        return ingredients;
    }

    public List<String> getSmallImageUrls() {
        return smallImageUrls;
    }
*/



}
