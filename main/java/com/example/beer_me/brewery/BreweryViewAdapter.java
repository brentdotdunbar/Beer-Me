package com.example.beer_me.brewery;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beer_me.Network.model.BreweryModel;
import com.example.beer_me.R;

import java.util.List;

public class BreweryViewAdapter extends RecyclerView.Adapter<BreweryViewHolder> {

    private String TAG = "BreweryViewAdapter";
    private List<BreweryModel> BreweryCollection;

    public BreweryViewAdapter(List<BreweryModel> Collection, OnBreweryListener onBreweryListener)
    {
        BreweryCollection = Collection;
        this.mOnBreweryListener = onBreweryListener;
    }

    private OnBreweryListener mOnBreweryListener;

    @NonNull
    @Override
    public BreweryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        Log.d(TAG, "onCreateViewHolder");
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_brewery_item,parent,false);
        return new BreweryViewHolder(inflatedView, mOnBreweryListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BreweryViewHolder breweryViewHolder, int position) {
        Log.d(TAG,"onBindViewHolder: " + position );
        BreweryModel model = BreweryCollection.get(position);
        breweryViewHolder.bindView(model);
    }

    @Override
    public int getItemCount() {
        if(BreweryCollection != null) {
            return BreweryCollection.size();
        }
        return 0;
    }
    public interface OnBreweryListener{
        void onBreweryClick(int pos);
    }
}