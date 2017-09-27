package com.dtlim.recyclerviewanimations;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

    @BindView(R.id.imageview_share)
    ImageView imageViewShare;
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
}
