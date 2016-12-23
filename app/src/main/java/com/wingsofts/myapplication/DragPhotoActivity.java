package com.wingsofts.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;

public class DragPhotoActivity extends AppCompatActivity {
    private static float mPerImageViewX;
    private static float mPerImageViewY;
    private static float mPerImageViewHeight;
    private PhotoView mPhotoView;
    private static float mPerImageViewWidth;

    private ViewPager mViewPager;
    private List<String> mList;
    private PhotoView[] mPhotoViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_drag_photo);
        mPhotoView = (PhotoView) findViewById(R.id.imageView);
        mPhotoView.setImageResource(R.drawable.leimu);



    }


    public static void startActivity(Context context, ImageView imageView) {
        mPerImageViewWidth = imageView.getWidth();
        mPerImageViewHeight = imageView.getHeight();
        int[] location = new int[2];
        imageView.getLocationOnScreen(location);
        mPerImageViewX = location[0];
        mPerImageViewY = location[1];
        Intent intent = new Intent(context, DragPhotoActivity.class);
        context.startActivity(intent);

    }
}
