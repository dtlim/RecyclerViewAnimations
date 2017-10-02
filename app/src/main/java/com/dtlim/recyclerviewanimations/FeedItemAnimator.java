package com.dtlim.recyclerviewanimations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

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
}
