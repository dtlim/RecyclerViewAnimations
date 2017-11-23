package com.dtlim.recyclerviewanimations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView
import android.util.Log

/**
 * Created by dalelim on 11/23/17.
 */

class FeedItemAnimator: DefaultItemAnimator() {
    override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {
        holder.itemView.translationX = (-holder.itemView.width).toFloat()
        holder.itemView.animate()
                .translationX(0f)
                .setDuration(200)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationStart(animation: Animator) {
                        dispatchAddStarting(holder)
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        dispatchAddFinished(holder)
                    }
                })
                .start()

        return false
    }

    override fun animateRemove(holder: RecyclerView.ViewHolder): Boolean {
        holder.itemView.animate()
                .translationX(holder.itemView.width.toFloat())
                .setDuration(200)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationStart(animation: Animator) {
                        dispatchRemoveStarting(holder)
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        dispatchRemoveFinished(holder)
                        holder.itemView.translationX = 0f
                    }
                })
                .start()

        return false
    }

    override fun recordPreLayoutInformation(state: RecyclerView.State,
                                            viewHolder: RecyclerView.ViewHolder, changeFlags: Int,
                                            payloads: List<Any>): RecyclerView.ItemAnimator.ItemHolderInfo {

        if (changeFlags == RecyclerView.ItemAnimator.FLAG_CHANGED) {
            val preInfo = FeedItemHolderInfo()
            for (payload in payloads) {
                Log.d("PAYLOAD", "recordPreLayoutInformation: " + payload)
                preInfo.likeAction = payload as Int
            }
            return preInfo
        }
        return super.recordPreLayoutInformation(state, viewHolder, changeFlags, payloads)
    }

    override fun animateChange(oldHolder: RecyclerView.ViewHolder, newHolder: RecyclerView.ViewHolder, preInfo: ItemHolderInfo, postInfo: ItemHolderInfo): Boolean {
        if(preInfo is FeedItemHolderInfo) {
            if(preInfo.likeAction == FeedAdapter.ACTION_FEED_ITEM_STARRED) {
                animateStarred(newHolder as FeedViewHolder)
            }
            else if(preInfo.likeAction == FeedAdapter.ACTION_FEED_ITEM_UNSTARRED) {
                animateUnstarred(newHolder as FeedViewHolder)
            }
        }
        return false
    }

    private fun animateStarred(holder: FeedViewHolder) {
        val animatorSet = AnimatorSet()

        val bounceAnimX = ObjectAnimator.ofFloat(holder.imageViewStar, "scaleX", 1f,
                2f, 1f)
        bounceAnimX.duration = 500

        val bounceAnimY = ObjectAnimator.ofFloat(holder.imageViewStar, "scaleY", 1f,
                2f, 1f)
        bounceAnimY.duration = 500

        animatorSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                dispatchAnimationFinished(holder)
            }
        })


        animatorSet.play(bounceAnimX).with(bounceAnimY)
        animatorSet.start()

    }

    private fun animateUnstarred(holder: FeedViewHolder) {
        val animatorSet = AnimatorSet()

        val bounceAnimX = ObjectAnimator.ofFloat(holder.imageViewStar, "scaleX", 1f,
                0.25f, 1f)
        bounceAnimX.duration = 500

        val bounceAnimY = ObjectAnimator.ofFloat(holder.imageViewStar, "scaleY", 1f,
                0.25f, 1f)
        bounceAnimY.duration = 500

        animatorSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                dispatchAnimationFinished(holder)
            }
        })

        animatorSet.play(bounceAnimX).with(bounceAnimY)
        animatorSet.start()
    }

    class FeedItemHolderInfo: ItemHolderInfo() {
        var likeAction: Int = 0
    }
}