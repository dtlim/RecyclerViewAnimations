package com.dtlim.recyclerviewanimations;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dale on 9/24/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter {

    private List<FeedItem> feedItems = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.viewholder_feed_item, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("BIND", "onBindViewHolder: " + position);
    }

    @Override
    public int getItemCount() {
        return 5;//feedItems.size();
    }
}
