package com.example.BrowseFragmentUsingRetrofit;

import static com.example.BrowseFragmentUsingRetrofit.R.drawable.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;
import com.example.BrowseFragmentUsingRetrofit.Model.RowItem;


public class CardPresenter extends Presenter {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;
    private int CARD_WIDTH;
    private int CARD_HEIGHT;

    public class ViewHolder extends Presenter.ViewHolder {
        public ImageView mImageView;
        private final Drawable mDefaultCardImage;

        @SuppressLint("UseCompatLoadingForDrawables")
        public ViewHolder(View view) {
            super(view);
            mImageView = view.findViewById(R.id.poster_image);
            mDefaultCardImage = mContext.getResources().getDrawable(R.drawable.black_bg);
        }


        public void updateViewImage(String uri) {

            if (uri.contains("https")) {
                Glide.with(mContext)
                        .load(Uri.parse(uri))
                        .override(Utils.convertPixelToDp(mContext,CARD_WIDTH),Utils.convertPixelToDp(mContext,CARD_HEIGHT))
                        .placeholder(mDefaultCardImage)
                        .error(mDefaultCardImage)
                        .into(mImageView);
                Log.d("updateViewImage", "updateViewImage: "+Utils.convertPixelToDp(mContext,CARD_WIDTH));
                Log.d("updateViewImage", "updateViewImage: "+Utils.convertPixelToDp(mContext,CARD_HEIGHT));
            }
            else if (uri.contains("http")) {
                uri = uri.replace("http", "https");
                Glide.with(mContext)
                        .load(Uri.parse(uri))
                        .override(Utils.convertPixelToDp(mContext,CARD_WIDTH),Utils.convertPixelToDp(mContext,CARD_HEIGHT))
                        .placeholder(mDefaultCardImage)
                        .error(mDefaultCardImage)
                        .into(mImageView);
                Log.d("updateViewImage", "updateViewImage: "+Utils.convertPixelToDp(mContext,CARD_WIDTH));
                Log.d("updateViewImage", "updateViewImage: "+Utils.convertPixelToDp(mContext,CARD_HEIGHT));
            } else {
                Glide.with(mContext)
                        .load(Uri.parse(uri))
                        .override(Utils.convertPixelToDp(mContext,CARD_WIDTH),Utils.convertPixelToDp(mContext,CARD_HEIGHT))
                        .placeholder(mDefaultCardImage)
                        .error(mDefaultCardImage)
                        .into(mImageView);
                Log.d("updateViewImage", "updateViewImage: "+Utils.convertPixelToDp(mContext,CARD_WIDTH));
                Log.d("updateViewImage", "updateViewImage: "+Utils.convertPixelToDp(mContext,CARD_HEIGHT));
            }
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        Log.d("CardPresenter", "onCreateViewHolder");
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_main, parent, false);
        view.setFocusable(true);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        RowItem data = (RowItem) item;
        if (data.getLayoutType().equals("landscape") && data.getPoster() != null) {
            if (data.getTileWidth() == null || data.getTileHeight() == null) {
                CARD_WIDTH = 350;
                CARD_HEIGHT = 200;
            }
            else {
                CARD_WIDTH = Integer.parseInt(data.getTileWidth());
                CARD_HEIGHT = Integer.parseInt(data.getTileHeight());
            }
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().width = CARD_WIDTH;
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().height = CARD_HEIGHT;
            ((ViewHolder) viewHolder).updateViewImage(data.getPoster());
        }
        else if ((data.getLayoutType().equals("portrait") || (data.getLayoutType().equals("square")))
                && data.getPortrait() != null) {
            if (data.getTileWidth() == null || data.getTileHeight() == null) {
                CARD_WIDTH = 150;
                CARD_HEIGHT = 200;
            }
            else {
                CARD_WIDTH = Integer.parseInt(data.getTileWidth());
                CARD_HEIGHT = Integer.parseInt(data.getTileHeight());
            }
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().width = CARD_WIDTH;
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().height = CARD_HEIGHT;
            ((ViewHolder) viewHolder).updateViewImage(data.getPortrait());
        }
        else {
            CARD_WIDTH = 200;
            CARD_HEIGHT = 200;
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().width = CARD_WIDTH;
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().height = CARD_HEIGHT;
            ((ViewHolder) viewHolder).updateViewImage(data.getBackground());
        }
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        Log.d("Unbind", "onUnbindViewHolder");

    }

}
