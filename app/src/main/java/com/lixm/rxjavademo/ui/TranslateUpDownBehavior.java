package com.lixm.rxjavademo.ui;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Lixm
 * @date 2018/6/20 16:01
 * @detail
 */

public class TranslateUpDownBehavior extends FloatingActionButton.Behavior {
    private boolean isAnimating = false;
    private OnStateChangeListener listener;

    public TranslateUpDownBehavior(Context context, AttributeSet attrs) {
        super();
    }

    public static TranslateUpDownBehavior from(View view){
        ViewGroup.LayoutParams params=view.getLayoutParams();
        if (params==null||!(params instanceof CoordinatorLayout.LayoutParams)){
            throw new IllegalArgumentException("parent must be CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior=((CoordinatorLayout.LayoutParams) params).getBehavior();
        if (!(behavior instanceof TranslateUpDownBehavior)){
            throw new IllegalArgumentException("the behavior must be TranslateUpDownBehavior");
        }
        return (TranslateUpDownBehavior) behavior;
    }

    private class MyViewPropertyAnimatorListener implements ViewPropertyAnimatorListener {
        @Override
        public void onAnimationStart(View view) {
            isAnimating = true;
        }

        @Override
        public void onAnimationEnd(View view) {
            isAnimating = false;
        }

        @Override
        public void onAnimationCancel(View view) {
            isAnimating = false;
        }
    }

    public void setOnStateChangeListener(OnStateChangeListener listener) {
        this.listener = listener;
    }

    public interface OnStateChangeListener {
        void onChange(boolean isUp);
    }
}
