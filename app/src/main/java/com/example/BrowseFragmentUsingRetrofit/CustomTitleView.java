package com.example.BrowseFragmentUsingRetrofit;

import static com.example.BrowseFragmentUsingRetrofit.R.drawable.selector;
import static com.example.BrowseFragmentUsingRetrofit.R.drawable.title_images_border;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
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

public class CustomTitleView extends ConstraintLayout implements TitleViewAdapter.Provider {

    private final ImageView mWifiImage;
    private final ImageView mInputImage;
    private final ImageView mSettingImage;
    private final ImageView mMenuImage;
    private final ImageView mTitleView;
    private final ImageView mSerachView;
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
            CustomTitleView.this.setBadgeDrawable(drawable);
        }
        @SuppressLint("ResourceAsColor")
        @Override
        public void setOnSearchClickedListener(OnClickListener listener) {
            // mSearchOrbView.setOnClickListener(listener);
        }

        @Override
        public void updateComponentsVisibility(int flags) {
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

        mTitleView = root.findViewById(R.id.header_title);

        mSerachView = root.findViewById(R.id.search_badge);
        mSerachView.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus) {
                    mSerachView.setBackground((getResources().getDrawable(title_images_border)));
                }

            }
        });


        mWifiImage = root.findViewById(R.id.wifi_badge);
        mWifiImage.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    mWifiImage.setBackground((getResources().getDrawable(title_images_border)));
                }

            }
        });

        mInputImage = root.findViewById(R.id.input_badge);
        mInputImage.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    mInputImage.setBackground((getResources().getDrawable(title_images_border)));
                }

            }
        });

        mSettingImage = root.findViewById(R.id.setting_badge);
        mSettingImage.setOnFocusChangeListener(new OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus) {
                    mSettingImage.setBackground((getResources().getDrawable(title_images_border)));
                }
            }
        });

        mMenuImage = root.findViewById(R.id.menu_badge);
        mMenuImage.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    mMenuImage.setBackground((getResources().getDrawable(title_images_border)));
                }
            }
        });





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


