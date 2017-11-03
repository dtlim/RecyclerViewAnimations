package com.dtlim.recyclerviewanimations;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dale on 9/24/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private List<FeedItem> feedItems = new ArrayList<>();
    private Context context;

    public FeedAdapter(Context context) {
        this.context = context;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.viewholder_feed_item, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FeedViewHolder holder, int position) {
        final FeedItem item = feedItems.get(position);
        holder.setFeedItem(context, item);
        holder.imageViewRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRemove(holder.getAdapterPosition());
            }
        });
        holder.imageViewStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStar(holder.getAdapterPosition());
            }
        });
    }

    public void setFeedItems(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
        notifyDataSetChanged();
    }

    public void appendItemToSecond(FeedItem item) {
        int index = feedItems.size() >= 2 ? 1:0;
        feedItems.add(index, item);
        notifyDataSetChanged();
    }

    public void onClickStar(int index) {
        FeedItem item = feedItems.get(index);
        item.setStarred(!item.isStarred());
        notifyDataSetChanged();
    }

    public void onClickRemove(int index) {
        feedItems.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }
}
