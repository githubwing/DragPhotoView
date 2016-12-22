package com.wingsofts.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by wing on 2016/12/22.
 */

public class DragPhotoView extends PhotoView {
    private Paint mPaint;
    private float mDownX;
    private float mDownY;
    private float mTranslateY;
    private float mTranslateX;
    private float mScale = 1;
    private int mWidth;
    private int mHeight;
    private float mMinScale = 0.5f;
    private int mAlpha = 255;
    private final static int MAX_TRANSLATE_Y = 500;

    public DragPhotoView(Context context) {
        this(context, null);
    }

    public DragPhotoView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public DragPhotoView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setAlpha(mAlpha);
        canvas.drawRect(0, 0, 2000, 2000, mPaint);
        canvas.translate(mTranslateX, mTranslateY);
        canvas.scale(mScale, mScale, mWidth / 2, mHeight / 2);
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = w;
        mHeight = h;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        //only scale == 1 can drag
        if (getScale() == 1) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    onActionDown(event);

                    break;
                case MotionEvent.ACTION_MOVE:
                    onActionMove(event);
                    return true;

                case MotionEvent.ACTION_UP:
                    onActionUp(event);

            }

        }

        return super.dispatchTouchEvent(event);
    }

    private void onActionUp(MotionEvent event) {

        if (mTranslateY > MAX_TRANSLATE_Y) {
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
                return;
            }
        }

        invalidate();
        mTranslateX = 0;
        mTranslateY = 0;
        mScale = 1;
        mAlpha = 255;
    }

    private void onActionMove(MotionEvent event) {
        float moveY = event.getY();
        float moveX = event.getX();
        mTranslateX = moveX - mDownX;
        mTranslateY = moveY - mDownY;

        float percent = mTranslateY / MAX_TRANSLATE_Y;

        if (mScale >= mMinScale && mScale <= 1f) {
            mScale = 1 - percent;
            mAlpha = (int) (255 * (1 - percent));
            if (mAlpha > 255) {
                mAlpha = 255;
            } else if (mAlpha < 0) {
                mAlpha = 0;
            }
        }
        if (mScale < mMinScale) {
            mScale = mMinScale;
        } else if (mScale > 1f) {
            mScale = 1;
        }


        invalidate();

    }


    private void onActionDown(MotionEvent event) {
        mDownX = event.getX();
        mDownY = event.getY();
    }

    public float getMinScale() {
        return mMinScale;
    }

    public void setMinScale(float minScale) {
        this.mMinScale = mMinScale;
    }
}
