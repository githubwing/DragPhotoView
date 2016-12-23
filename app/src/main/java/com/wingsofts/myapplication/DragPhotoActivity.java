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
    private DragPhotoView[] mPhotoViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_drag_photo);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mList = new ArrayList<>();

        mList.add("path");
        mList.add("path");
        mList.add("path");

        mPhotoViews = new DragPhotoView[mList.size()];

        for(int i = 0;i<mPhotoViews.length;i++){
            mPhotoViews[i] = new DragPhotoView(this);
            mPhotoViews[i].setImageResource(R.drawable.leimu);
        }

        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mList.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mPhotoViews[position]);
                return mPhotoViews[position];
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mPhotoViews[position]);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });

    }


    public static void startActivity(Context context, ImageView imageView) {
        Intent intent = new Intent(context, DragPhotoActivity.class);
        context.startActivity(intent);

    }
}
