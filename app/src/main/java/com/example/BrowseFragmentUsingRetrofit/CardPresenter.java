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
    private  int CARD_WIDTH  =600;
    private  int CARD_HEIGHT  =338;



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

        if (data.getLayoutType().equals("landscape") &&
                data.getTileWidth() != null && data.getTileHeight() != null
                && data.getPoster()!=null) {
                CARD_WIDTH = Integer.parseInt(data.getTileWidth());
                CARD_HEIGHT = Integer.parseInt(data.getTileHeight());
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().width=CARD_WIDTH;
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().height=CARD_HEIGHT;
             ((ViewHolder) viewHolder).updateViewImage(data.getPoster());
        }
        else if( (data.getLayoutType().equals("portrait") || data.getLayoutType().equals("square"))
                && ((data.getTileWidth()!= null) && (data.getTileHeight()!= null ) && data.getPortrait()!=null)){

                CARD_WIDTH = Integer.parseInt(data.getTileWidth());
                CARD_HEIGHT = Integer.parseInt(data.getTileHeight());

                 ((ViewHolder) viewHolder).mImageView.getLayoutParams().width=CARD_WIDTH;
                ((ViewHolder) viewHolder).mImageView.getLayoutParams().height=CARD_HEIGHT;
                ((ViewHolder) viewHolder).updateViewImage(data.getPortrait());
        }

        else {
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().width=CARD_WIDTH;
            ((ViewHolder) viewHolder).mImageView.getLayoutParams().height=CARD_HEIGHT;
            ((ViewHolder) viewHolder).updateViewImage(data.getPoster());
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
