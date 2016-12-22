package com.wingsofts.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoView;

public class DragPhotoActivity extends AppCompatActivity {
    private static float mPerImageViewX;
    private static float mPerImageViewY;
    private static float mPerImageViewHeight;
    private PhotoView photoView;
    private static float mPerImageViewWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_photo);
        photoView = (PhotoView) findViewById(R.id.imageView);
        photoView.setImageResource(R.drawable.leimu);

        photoView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                // remove previous listener
                photoView.getViewTreeObserver().removeOnPreDrawListener(this);

                float imgWidth = photoView.getWidth();
                float imgHeight = photoView.getHeight();
                int[] screenLocation = new int[2];
                photoView.getLocationOnScreen(screenLocation);
                photoView.setScaleX(mPerImageViewWidth /imgWidth);
                photoView.setScaleY(mPerImageViewHeight /imgHeight);
                photoView.setTranslationX(mPerImageViewX - screenLocation[0] );
                photoView.setTranslationY(mPerImageViewY - screenLocation[1]);
//
                return true;
            }
        });
    }




    @Override
    public void onWindowFocusChanged(boolean hasFocus) {


//        Log.e("wing",imgWidth + " " + mPerImageViewWidth);
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(mPerImageViewWidth /imgWidth,1);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                float value = (float) valueAnimator.getAnimatedValue();
//                photoView.setScaleY(value);
//                photoView.setScaleX(value);
//            }
//        });
//
//        valueAnimator.setDuration(300);
//        valueAnimator.start();

        super.onWindowFocusChanged(hasFocus);
    }

    public static void startActivity(Context context, ImageView imageView){
        mPerImageViewWidth = imageView.getWidth();
        mPerImageViewHeight = imageView.getHeight();
        int [] location = new int[2];
        imageView.getLocationOnScreen(location);
        mPerImageViewX = location[0];
        mPerImageViewY = location[1];
        Intent intent = new Intent(context,DragPhotoActivity.class);
        context.startActivity(intent);

    }
}
