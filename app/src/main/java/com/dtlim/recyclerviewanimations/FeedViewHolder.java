package com.dtlim.recyclerviewanimations;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dale on 9/26/2017.
 */

public class FeedViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageview_profile_picture)
    ImageView imageViewProfilePicture;
    @BindView(R.id.imageview_content)
    ImageView imageViewContent;

    @BindView(R.id.imageview_remove)
    ImageView imageViewRemove;
    @BindView(R.id.imageview_star)
    ImageView imageViewStar;

    @BindView(R.id.textview_name)
    TextView textViewName;
    @BindView(R.id.textview_username)
    TextView textViewUsername;
    @BindView(R.id.textview_content)
    TextView textViewContent;
    @BindView(R.id.textview_location)
    TextView textViewLocation;
    @BindView(R.id.textview_time)
    TextView textViewTime;

    public FeedViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setFeedItem(Context context, final FeedItem item) {
        if(!item.getProfilePictureUrl().isEmpty()) {
            Picasso.with(context)
                    .load(item.getProfilePictureUrl())
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.ic_profile)
                    .error(R.drawable.ic_profile)
                    .into(imageViewProfilePicture);
        }

        if(!item.getImageUrl().isEmpty()) {
            imageViewContent.setVisibility(View.VISIBLE);
            Picasso.with(context)
                    .load(item.getImageUrl())
                    .fit()
                    .centerCrop()
                    .into(imageViewContent, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            Log.d("IMAGE", "onError: " + item.getImageUrl());
                            imageViewContent.setVisibility(View.GONE);
                        }
                    });
        }
        else {
            imageViewContent.setVisibility(View.GONE);
        }

        if(item.isStarred()) {
            imageViewStar.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_star));
        }
        else {
            imageViewStar.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_star_border));
        }

        textViewName.setText(item.getName());
        textViewUsername.setText(item.getUsername());
        textViewContent.setText(item.getContent());
        textViewLocation.setText(item.getLocation());
        textViewTime.setText(item.getTime());
    }
}
