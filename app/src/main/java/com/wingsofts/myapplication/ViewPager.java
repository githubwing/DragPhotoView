package com.wingsofts.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * Created by wing on 16-12-23.
 */

public class ViewPager extends android.support.v4.view.ViewPager {

    private int downX;
    private int downY;
    private int mTouchSlop;

    public ViewPager(Context context) {
        this(context, null);
    }

    public ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        int action = ev.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                downX = (int) ev.getRawX();
//                downY = (int) ev.getRawY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int moveY = (int) ev.getRawY();
//                if (Math.abs(moveY - downY) > mTouchSlop) {
//                    Log.e("wing", "intercept");
//                    return false;
//                }
//        }


        return  super.onInterceptTouchEvent(ev);
    }

}
