package com.example.BrowseFragmentUsingRetrofit;

import static com.example.BrowseFragmentUsingRetrofit.R.drawable.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.leanback.widget.BaseCardView;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;

import com.example.BrowseFragmentUsingRetrofit.Model.RowItem;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;

public class CardPresenter extends Presenter {

    private static final String TAG = "CardPresenter";
    private static Context mContext;
    private  int CARD_WIDTH ;
    private  int CARD_HEIGHT ;



    public class ViewHolder extends Presenter.ViewHolder {
        ImageView mImageView;
        private Drawable mDefaultCardImage;
        private PicassoImageViewTarget mImageViewTarget;

        @SuppressLint("UseCompatLoadingForDrawables")
        public ViewHolder(View view) {
            super(view);
            mImageView = view.findViewById(R.id.poster_image);
            mImageViewTarget = new PicassoImageViewTarget(mImageView);
            mDefaultCardImage = mContext.getResources().getDrawable(app_icon_your_company);
        }
        public void updateViewImage(String uri) {

            if (uri.contains("https")) {
                Picasso.get().load(uri).resize(Utils.convertPixelToDp(mContext, CARD_WIDTH),
                                Utils.convertPixelToDp(mContext, CARD_HEIGHT))
                        .placeholder(mDefaultCardImage)
                        .error(mDefaultCardImage)
                        .into(mImageViewTarget);
            }
            else if (uri.contains("http")) {
                uri = uri.replace("http", "https");
                Picasso.get().load(uri).resize(Utils.convertPixelToDp(mContext, CARD_WIDTH),
                                Utils.convertPixelToDp(mContext, CARD_HEIGHT))
                        .placeholder(mDefaultCardImage)
                        .error(mDefaultCardImage)
                        .into(mImageViewTarget);
            }
            else {
                Picasso.get().load(uri).resize(Utils.convertPixelToDp(mContext, CARD_WIDTH),
                                Utils.convertPixelToDp(mContext, CARD_HEIGHT))
                        .placeholder(mDefaultCardImage)
                        .error(mDefaultCardImage)
                        .into(mImageViewTarget);
            }

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @SuppressLint("ResourceAsColor")
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        Log.d(TAG, "onCreateViewHolder");
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_main,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        RowItem data = (RowItem) item;

        if (data.getLayoutType().equals("landscape") && data.getPoster()!=null) {
            if(data.getTileWidth()== null && data.getTileHeight()== null) {
                CARD_WIDTH = 600;
                CARD_HEIGHT = 338;
            }
            else {
                CARD_WIDTH = Integer.parseInt(data.getTileWidth());
                Log.d(TAG, "Dimension: " + data.getTileWidth());
                CARD_HEIGHT = Integer.parseInt(data.getTileHeight());
                Log.d(TAG, "Dimension: " + data.getTileHeight());
            }
                    ((ViewHolder) viewHolder).mImageView.getLayoutParams().width = CARD_WIDTH;
                    ((ViewHolder) viewHolder).mImageView.getLayoutParams().height = CARD_HEIGHT;
                    ((ViewHolder) viewHolder).updateViewImage(data.getPoster());

        }
        else if((data.getLayoutType().equals("portrait")||(data.getLayoutType().equals("square")))
                && data.getPortrait()!=null){
            if(data.getTileWidth()== null && data.getTileHeight()== null) {
                CARD_WIDTH = 300;
                CARD_HEIGHT = 400;
            }
            else {
                CARD_WIDTH = Integer.parseInt(data.getTileWidth());
                Log.d(TAG, "Dimension of portrait and square : " + data.getTileWidth());
                CARD_HEIGHT = Integer.parseInt(data.getTileHeight());
                Log.d(TAG, "Dimension of portrait and square : " + data.getTileHeight());
            }
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().width=CARD_WIDTH;
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().height=CARD_HEIGHT;
            ((ViewHolder) viewHolder).updateViewImage(data.getPortrait());
        }
        else {

            ((ViewHolder) viewHolder).mImageView.getLayoutParams().width=CARD_WIDTH;
            Log.d(TAG, "Inside main else: " +CARD_WIDTH);
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().height=CARD_HEIGHT;
            Log.d(TAG, "Inside main else: " +CARD_HEIGHT);
            ((ViewHolder) viewHolder).updateViewImage(data.getPortrait());
        }

    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        Log.d(TAG, "onUnbindViewHolder");
    }
    @Override
    public void onViewAttachedToWindow(Presenter.ViewHolder viewHolder) {
        // TO DO
    }

    public static class PicassoImageViewTarget implements Target{
        private ImageView mImageView;

        public PicassoImageViewTarget(ImageView imageView) {
            mImageView = imageView;
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
            Drawable bitmapDrawable = new BitmapDrawable(mContext.getResources(), bitmap);
            mImageView.setImageDrawable(bitmapDrawable);
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {
            mImageView.setImageDrawable(errorDrawable);
            e.printStackTrace();
        }
        @Override
        public void onPrepareLoad(Drawable drawable) {
        }
    }


}
