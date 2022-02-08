package com.example.beer_me.beers;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beer_me.beers.BeerViewHolder;
import com.example.beer_me.Network.model.BeerModel;
import com.example.beer_me.R;

import java.util.List;

public class BeerViewAdapter extends RecyclerView.Adapter<BeerViewHolder> {

    private String TAG = "BeerViewAdapter";
    private List<BeerModel> BeerCollection;
    private OnBeerListener mOnBeerListener;


    public BeerViewAdapter( List<BeerModel> Collection, OnBeerListener onBeerListener)
    {
        BeerCollection = Collection;
        this.mOnBeerListener = onBeerListener;
    }


    @NonNull
    @Override
    public BeerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        Log.d(TAG, "onCreateViewHolder");
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_beer_item,parent,false);
        return new BeerViewHolder(inflatedView, mOnBeerListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BeerViewHolder beerViewHolder, int position) {
        Log.d(TAG,"onBindViewHolder: " + position );
        BeerModel model = BeerCollection.get(position);
        beerViewHolder.bindView(model);
    }

    @Override
    public int getItemCount() {
        if(BeerCollection != null) {
            return BeerCollection.size();
        }
        return 0;
    }
    public interface OnBeerListener{
        void onBeerClick(int pos);
    }
}