package com.dtlim.recyclerviewanimations

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.ArrayList

/**
 * Created by dalelim on 11/23/17.
 */
class FeedAdapter(private var context: Context): RecyclerView.Adapter<FeedViewHolder>() {

    companion object {
        const val ACTION_FEED_ITEM_STARRED = 1
        const val ACTION_FEED_ITEM_UNSTARRED = 2
    }

    private var feedItems: MutableList<FeedItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FeedViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.viewholder_feed_item, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val feedItem = feedItems[position]
        holder.setFeedItem(context, feedItem)
        holder.imageViewRemove?.setOnClickListener({ onClickRemove(holder.adapterPosition) })
        holder.imageViewStar?.setOnClickListener({ onClickStar(holder.adapterPosition) })
    }

    override fun getItemCount(): Int = feedItems.size

    fun setFeedItems(feedItems: MutableList<FeedItem>) {
        this.feedItems = feedItems
    }

    fun appendItemToSecond(item: FeedItem) {
        val index: Int = if (feedItems.size > 2) 1 else 0
        feedItems.add(index, item)
        notifyItemInserted(index)
    }

    fun onClickStar(index: Int) {
        val item = feedItems[index]
        item.starred = !item.starred
        notifyItemChanged(index, if (item.starred) ACTION_FEED_ITEM_STARRED else
            ACTION_FEED_ITEM_UNSTARRED)
    }

    fun onClickRemove(index: Int) {
        feedItems.removeAt(index)
        notifyItemRemoved(index)
    }
}