package com.dtlim.recyclerviewanimations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by dale on 02/10/2017.
 */

public class FeedItemAnimator extends DefaultItemAnimator {

    // TODO 1: Study how animate add is done.
    // Note how we initially set the translation to exactly outside the screen,
    // then use View.animate() on holder.itemView to bring it back.

    // Also note that we added a listener in order to call the dispatch...() methods
    // These methods are required in order inform RecyclerView the status of your animations
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

    // TODO 2: Implement the remove animation.  Make the item move out of the screen.  Don't forget
    // to call the corresponding dispatch methods!
    @Override
    public boolean animateRemove(final RecyclerView.ViewHolder holder) {
        
        return false;
    }
}
