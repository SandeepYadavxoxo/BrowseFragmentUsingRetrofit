package com.example.BrowseFragmentUsingRetrofit;

import static com.example.BrowseFragmentUsingRetrofit.R.drawable.selector;
import static com.example.BrowseFragmentUsingRetrofit.R.drawable.title_images_border;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.leanback.widget.TitleViewAdapter;

public class CustomTitleView extends RelativeLayout implements TitleViewAdapter.Provider {
    private ImageView mWifiImage;
    private ImageView mInputImage;
    private ImageView mSettingImage;
    private ImageView mMenuImage;
    private ImageView mTitleView;
    private ImageView mSerachView;
    // private View mSearchOrbView;


    private final TitleViewAdapter mTitleViewAdapter = new TitleViewAdapter() {
        @Override
        public View getSearchAffordanceView() {
            return null;
        }


        @Override
        public void setTitle(CharSequence titleText) {
            CustomTitleView.this.setTitle(titleText);
        }


        @Override
        public void setBadgeDrawable(Drawable drawable) {
            // CustomTitleView.this.setBadgeDrawable(drawable);
        }
        @SuppressLint("ResourceAsColor")
        @Override
        public void setOnSearchClickedListener(OnClickListener listener) {
            // mSearchOrbView.setOnClickListener(listener);
        }

        @Override
        public void updateComponentsVisibility(int flags) {
//            int visibility = (flags & SEARCH_VIEW_VISIBLE) == SEARCH_VIEW_VISIBLE
//                    ? View.VISIBLE : View.INVISIBLE;
//            mSearchOrbView.setVisibility(visibility);
        }

        private void updateBadgeVisibility(boolean visible) {
            if (visible) {
                mInputImage.setVisibility(View.VISIBLE);
                mMenuImage.setVisibility(View.VISIBLE);
                mWifiImage.setVisibility(View.VISIBLE);
                mSettingImage.setVisibility(View.VISIBLE);
                mSerachView.setVisibility(View.VISIBLE);

            } else {
                mInputImage.setVisibility(View.GONE);
                mMenuImage.setVisibility(View.GONE);
                mWifiImage.setVisibility(View.GONE);
                mSettingImage.setVisibility(View.GONE);
                mSerachView.setVisibility(View.GONE);
            }
        }
    };

    public CustomTitleView(Context context) {
        this(context, null);
    }

    public CustomTitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public CustomTitleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        View root = LayoutInflater.from(context).inflate(R.layout.custom_title_view, this);
        mSerachView = root.findViewById(R.id.search_badge);
        mSerachView.requestFocus();
        mSerachView.setBackground((getResources().getDrawable(title_images_border)));
        mTitleView = root.findViewById(R.id.header_title);
        mInputImage = root.findViewById(R.id.input_badge);
        mMenuImage = root.findViewById(R.id.menu_badge);
        mSettingImage = root.findViewById(R.id.setting_badge);
        mWifiImage = root.findViewById(R.id.wifi_badge);

    }

    public void setTitle(CharSequence title) {
        if (title != null) {
            mTitleView.setVisibility(View.VISIBLE);
            mInputImage.setVisibility(View.VISIBLE);
            mMenuImage.setVisibility(View.VISIBLE);
            mWifiImage.setVisibility(View.VISIBLE);
            mSettingImage.setVisibility(View.VISIBLE);
            mSerachView.setVisibility(View.VISIBLE);
        }
    }

    public void setBadgeDrawable(Drawable drawable) {
        if (drawable != null) {
            mInputImage.setImageDrawable(drawable);
            mInputImage.setVisibility(View.VISIBLE);

            mMenuImage.setImageDrawable(drawable);
            mMenuImage.setVisibility(View.VISIBLE);

            mWifiImage.setImageDrawable(drawable);
            mWifiImage.setVisibility(View.VISIBLE);

            mSettingImage.setImageDrawable(drawable);
            mSettingImage.setVisibility(View.VISIBLE);

            mTitleView.setVisibility(View.VISIBLE);
            mTitleView.setImageDrawable(drawable);

            mSerachView.setVisibility(View.VISIBLE);
            mSerachView.setImageDrawable(drawable);

        }
    }
    @Override
    public TitleViewAdapter getTitleViewAdapter() {
        return mTitleViewAdapter;
    }

}


