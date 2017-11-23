package com.dtlim.recyclerviewanimations

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

/**
 * Created by dalelim on 11/21/17.
 */
class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var imageViewProfilePicture: ImageView? = null
    var imageViewContent: ImageView? = null

    var imageViewRemove: ImageView? = null
    var imageViewStar: ImageView? = null

    var textViewName: TextView? = null
    var textViewUsername: TextView? = null
    var textViewContent: TextView? = null
    var textViewLocation: TextView? = null
    var textViewTime: TextView? = null

    init {
        imageViewProfilePicture = itemView.findViewById(R.id.imageview_profile_picture)
        imageViewContent = itemView.findViewById(R.id.imageview_content)
        imageViewRemove = itemView.findViewById(R.id.imageview_remove)
        imageViewStar = itemView.findViewById(R.id.imageview_star)
        textViewName = itemView.findViewById(R.id.textview_name)
        textViewUsername = itemView.findViewById(R.id.textview_username)
        textViewContent = itemView.findViewById(R.id.textview_content)
        textViewLocation = itemView.findViewById(R.id.textview_location)
        textViewTime = itemView.findViewById(R.id.textview_time)
    }

    fun setFeedItem(context: Context, feedItem: FeedItem) {
        if(!feedItem.profilePictureUrl.isEmpty()) {
            Picasso.with(context)
                    .load(feedItem.profilePictureUrl)
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.ic_profile)
                    .error(R.drawable.ic_profile)
                    .into(imageViewProfilePicture)
        }

        if(!feedItem.imageUrl.isEmpty()) {
            imageViewContent?.visibility = View.VISIBLE
            Picasso.with(context)
                    .load(feedItem.imageUrl)
                    .fit()
                    .centerCrop()
                    .into(imageViewContent, object : Callback {
                        override fun onSuccess() {
                        }

                        override fun onError() {
                            Log.d("IMAGE", "onError: " + feedItem.imageUrl)
                            imageViewContent?.visibility = View.GONE
                        }
                    })
        }
        else {
            imageViewContent?.visibility = View.GONE
        }

        if(feedItem.starred) {
            imageViewStar?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_star))
        }
        else {
            imageViewStar?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_star_border))
        }

        textViewName?.text = feedItem.name
        textViewUsername?.text = feedItem.username
        textViewContent?.text = feedItem.content
        textViewLocation?.text = feedItem.location
        textViewTime?.text = feedItem.time
    }
}