package com.example.BrowseFragmentUsingRetrofit;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

import androidx.leanback.app.BackgroundManager;

public class SimpleBackgroundManager {

    private static final String TAG = SimpleBackgroundManager.class.getSimpleName();
    private final int DEFAULT_BACKGROUND_RES_ID = R.drawable.app_icon_your_company;
    private static Drawable mDefaultBackground;
    private Activity mActivity;
    private BackgroundManager mBackgroundManager;
    public SimpleBackgroundManager(Activity activity) {
        mActivity = activity;
        mDefaultBackground = activity.getDrawable(DEFAULT_BACKGROUND_RES_ID);
        mBackgroundManager = BackgroundManager.getInstance(activity);
        mBackgroundManager.attach(activity.getWindow());
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
    }
    public void updateBackground(Drawable drawable) {
        mBackgroundManager.setDrawable(drawable);
    }
    public void clearBackground() {
        mBackgroundManager.setDrawable(mDefaultBackground);
    }


}
