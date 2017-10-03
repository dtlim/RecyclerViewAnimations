package com.dtlim.recyclerviewanimations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

/**
 * Created by dale on 02/10/2017.
 */

public class FeedItemAnimator extends DefaultItemAnimator {
    
    @Override
    public boolean animateAdd(final RecyclerView.ViewHolder holder) {
        holder.itemView.setTranslationX(-holder.itemView.getWidth());
        holder.itemView.animate()
            .translationX(0)
            .setDuration(200)
            .setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(final Animator animation) {
                    dispatchAddStarting(holder);
                }
    
                @Override
                public void onAnimationEnd(final Animator animation) {
                    dispatchAddFinished(holder);
                }
            })
            .start();
        
        return false;
    }
    
    @Override
    public boolean animateRemove(final RecyclerView.ViewHolder holder) {
        holder.itemView.animate()
            .translationX(holder.itemView.getWidth())
            .setDuration(200)
            .setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(final Animator animation) {
                    dispatchRemoveStarting(holder);
                }
    
                @Override
                public void onAnimationEnd(final Animator animation) {
                    dispatchRemoveFinished(holder);
                    holder.itemView.setTranslationX(0);
                }
            })
            .start();
        
        return false;
    }
    
    @NonNull
    @Override
    public ItemHolderInfo recordPreLayoutInformation(@NonNull final RecyclerView.State state,
        @NonNull final RecyclerView.ViewHolder viewHolder, final int changeFlags,
        @NonNull final List<Object> payloads) {
        
        if(changeFlags == FLAG_CHANGED) {
            FeedItemHolderInfo preInfo = new FeedItemHolderInfo();
            for(Object payload : payloads) {
                Log.d("PAYLOAD", "recordPreLayoutInformation: " + payload);
                preInfo.likeAction = (int) payload;
            }
            return preInfo;
        }
        return super.recordPreLayoutInformation(state, viewHolder, changeFlags, payloads);
    }
    
    @NonNull
    @Override
    public ItemHolderInfo recordPostLayoutInformation(@NonNull final RecyclerView.State state,
        @NonNull final RecyclerView.ViewHolder viewHolder) {
        return super.recordPostLayoutInformation(state, viewHolder);
    }
    
    @Override
    public boolean animateChange(@NonNull final RecyclerView.ViewHolder oldHolder,
        @NonNull final RecyclerView.ViewHolder newHolder, @NonNull final ItemHolderInfo preInfo,
        @NonNull final ItemHolderInfo postInfo) {
        
        if(preInfo instanceof FeedItemHolderInfo) {
            FeedItemHolderInfo feedItemHolderInfo = (FeedItemHolderInfo) preInfo;
            if(feedItemHolderInfo.likeAction == FeedAdapter.ACTION_FEED_ITEM_STARRED) {
                animateStarred((FeedViewHolder) newHolder);
            }
            else if(feedItemHolderInfo.likeAction == FeedAdapter.ACTION_FEED_ITEM_UNSTARRED) {
                animateUnstarred((FeedViewHolder) newHolder);
            }
        }
        
        return false;
    }
    
    private void animateStarred(final FeedViewHolder holder) {
        AnimatorSet animatorSet = new AnimatorSet();
        
        ObjectAnimator bounceAnimX = ObjectAnimator.ofFloat(holder.imageViewStar, "scaleX", 1f,
            2f, 1f);
        bounceAnimX.setDuration(500);
    
        ObjectAnimator bounceAnimY = ObjectAnimator.ofFloat(holder.imageViewStar, "scaleY", 1f,
            2f, 1f);
        bounceAnimY.setDuration(500);
    
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                dispatchAnimationFinished(holder);
            }
        });
    
    
        animatorSet.play(bounceAnimX).with(bounceAnimY);
        animatorSet.start();
    
    }
    
    private void animateUnstarred(final FeedViewHolder holder) {
        AnimatorSet animatorSet = new AnimatorSet();
    
        ObjectAnimator bounceAnimX = ObjectAnimator.ofFloat(holder.imageViewStar, "scaleX", 1f,
            0.25f, 1f);
        bounceAnimX.setDuration(500);
    
        ObjectAnimator bounceAnimY = ObjectAnimator.ofFloat(holder.imageViewStar, "scaleY", 1f,
            0.25f, 1f);
        bounceAnimY.setDuration(500);
    
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                dispatchAnimationFinished(holder);
            }
        });
    
        animatorSet.play(bounceAnimX).with(bounceAnimY);
        animatorSet.start();
    }
    
    public static class FeedItemHolderInfo extends ItemHolderInfo {
        public int likeAction;
    }
    
}
