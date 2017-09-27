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

        if(!item.getProfilePictureUrl().isEmpty()) {
            Picasso.with(context)
                    .load(item.getProfilePictureUrl())
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.ic_profile)
                    .error(R.drawable.ic_profile)
                    .into(holder.imageViewProfilePicture);
        }

        if(!item.getImageUrl().isEmpty()) {
            holder.imageViewContent.setVisibility(View.VISIBLE);
            Picasso.with(context)
                    .load(item.getImageUrl())
                    .fit()
                    .centerCrop()
                    .into(holder.imageViewContent, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            Log.d("IMAGE", "onError: " + item.getImageUrl());
                            holder.imageViewContent.setVisibility(View.GONE);
                        }
                    });
        }
        else {
            holder.imageViewContent.setVisibility(View.GONE);
        }

        holder.textViewName.setText(item.getName());
        holder.textViewUsername.setText(item.getUsername());
        holder.textViewContent.setText(item.getContent());
        holder.textViewLocation.setText(item.getLocation());
        holder.textViewTime.setText(item.getTime());
    }

    public void setFeedItems(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }
}
