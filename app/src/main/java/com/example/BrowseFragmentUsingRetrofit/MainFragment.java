package com.example.BrowseFragmentUsingRetrofit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.FocusHighlight;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;

import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.BrowseFragmentUsingRetrofit.Model.Cvte;
import com.example.BrowseFragmentUsingRetrofit.Model.Row;
import com.example.BrowseFragmentUsingRetrofit.Model.RowItem;
import com.example.BrowseFragmentUsingRetrofit.Model.deepLinkRequest;
import com.example.BrowseFragmentUsingRetrofit.Model.deeplinkResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends BrowseSupportFragment {

    private ArrayObjectAdapter mRowsAdapter;
    private final Handler handler = new Handler();
    private Runnable delayedUIRunnable;

    private Map<String, String> headerField = new HashMap<>();
    private Cvte cvte;
    private List<Row> rowlist;
    private List<RowItem> newRowItem;
    private RowItem newRowi;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        headerField.put("brand", "CLOUDWALKER");
        headerField.put("content-type", "application/json; charset=UTF-8");
        headerField.put("cotaversion", "");
        headerField.put("emac", "00:CB:B4:6C:E6:CA");
        headerField.put("factory", "CLOUDWALKER");
        headerField.put("features", "CLOUDTV_VOICE");
        headerField.put("fotaversion", "1667467670");
        headerField.put("keymd5", "FD889462A56360ED250705AF8603A602");
        headerField.put("keysha256", "FF062321D475505A7DB6ED582A3F34118FC74BD1969D8821DEF4E749F83713C8");
        headerField.put("lversion", "3.2.0-12-g9a8afb4-dirty-tt-com");
        headerField.put("mboard", "P75_368_V65");
        headerField.put("model", "CloudTV518");
        headerField.put("package", "tv.cloudwalker.cwnxt.launcher.com");
        headerField.put("panel", "AUO32.ini");
        headerField.put("ram", "1");
        headerField.put("skinversion", "1.0.0-dynamic_skin-47-g6b892d5-CLOUDWALKER-CLOUDWALKER-CLOUDWALKER-4");
        headerField.put("uid", "110203740957376942932");
        headerField.put("user-agent", "CLOUDWALKER-cloudtv-CloudTV518/3.2.0-12-g9a8afb4-dirty-tt-com");
        headerField.put("vendor", "CLOUDWALKER");
        headerField.put("wmac", "");

        setupUIElements();
        loadRows();
        setupEventListeners();
        CustomTitleView customTitleView = new CustomTitleView(getActivity());
        setTitleView(customTitleView);
      //  customTitleView.onClickMethods();


    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private void setupUIElements(){

        setHeadersState(HEADERS_DISABLED);
        setHeadersTransitionOnBackEnabled(false);
        // set fastLane (or headers) background color
      // setBrandColor(getResources().getColor(R.color.fastlane_background));
    }


    private void setupEventListeners() {
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
        setOnItemViewClickedListener(new ItemViewClickedListener());
        setOnSearchClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



    private void loadRows() {

        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter(FocusHighlight.ZOOM_FACTOR_NONE));
        Call<Cvte> apiCall = RetrofitClient.getInstance().getApis().getphotos();

        apiCall.enqueue(new Callback<Cvte>() {
            @Override
            public void onResponse(Call<Cvte> call, Response<Cvte> response) {
                cvte = response.body();
                rowlist = cvte.getRows();
                CardPresenter cardPresenter = new CardPresenter();
                for (int a = 0; a < rowlist.size(); a++) {
                    Row newrow = rowlist.get(a);
                    newRowItem = newrow.getRowItems();
                    HeaderItem cardPresenterHeader = new HeaderItem(newrow.getRowHeader());
                    ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);
                    for (int i = 0; i < newRowItem.size(); i++) {
                        newRowi = newRowItem.get(i);
                        newRowi.setLayoutType(newrow.getRowLayout());
                        cardRowAdapter.add(newRowi);
                    }
                    mRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));
                }
                setAdapter(mRowsAdapter);

            }

            @Override
            public void onFailure(Call<Cvte> call, Throwable t) {
                Log.e("MainFragment", "onFailure: " + t);
            }
        });
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, androidx.leanback.widget.Row row) {


            if (delayedUIRunnable != null) {
                handler.removeCallbacks(delayedUIRunnable);
            }
            delayedUIRunnable = new Runnable() {
                @Override
                public void run() {
                    if (item instanceof RowItem) {
                        ((MainActivity) getActivity()).setMovieName(((RowItem) item).getTitle());
                        ((MainActivity) getActivity()).setMovieRuntime(((RowItem) item).getRuntime());
                        ((MainActivity) getActivity()).setMoviePoster(((RowItem) item).getPoster());
                        ((MainActivity) getActivity()).setYearOfProduction(((RowItem) item).getYear());
                        ((MainActivity) getActivity()).setMovieDescription(((RowItem) item).getSynopsis());
                    }
                }
            };
            handler.postDelayed(delayedUIRunnable, 1000);
        }
    }

    private class ItemViewClickedListener implements OnItemViewClickedListener {
       deepLinkRequest deepLinkRequest = new deepLinkRequest();
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, androidx.leanback.widget.Row row) {

            deepLinkRequest.setPackageName(((RowItem) item).getPackage());

            deepLinkRequest.setDeeplink(((RowItem) item).getTarget().get(0));

            deepLinkRequest.setSourceName(((RowItem) item).getSource());


            Call<deeplinkResponse> apiCall = RetrofitClient.getInstance().getApis().createPost("https://staging.do.cloudwalker.tv/utilityService/getCwIntent", headerField, deepLinkRequest);
            apiCall.enqueue(new Callback<deeplinkResponse>() {
                @Override
                public void onResponse(@NonNull Call<deeplinkResponse> call, @NonNull Response<deeplinkResponse> response) {
                    Log.d("deeplinkResponse", "body: " + response.body());
                    Log.d("deeplinkResponse", "onResponse: " + response.code());

                    deeplinkResponse deeplinkClass=response.body();
                    Intent appIntent;
                    //getPackageManager -Return PackageManager instance to find global package information.
                    //Return a "good" intent to launch a front-door Leanback activity in a package,
                    // for use for example to implement an "open" button when browsing through packages.

                    appIntent = getContext().getPackageManager().getLeanbackLaunchIntentForPackage(deeplinkClass.getAppPackageName());
                    if (appIntent == null) {
                        // Bring user to the market or let them choose an app

                        Intent marketIntent = new Intent(Intent.ACTION_VIEW);
                        marketIntent.setData(Uri.parse(deeplinkClass.getMarketPackageName()));
                        marketIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        marketIntent.setData(Uri.parse(deeplinkClass.getMarketDeeplink()));
                        getContext().startActivity(marketIntent);

                    }
                    appIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    appIntent.setData(Uri.parse(deeplinkClass.getAppDeeplink()));
                    getContext().startActivity(appIntent);

                    // startNewActivity(getContext(), deeplinkClass.getAppPackageName());
                    Log.d("deeplinkResponse", "onResponse: "+deeplinkClass.getAppPackageName());
                }


                @Override
                public void onFailure(Call<deeplinkResponse> call, Throwable t) {
                    Log.d("Sandeep", "onResponse: " + t.getMessage());
                }
            });

            Toast.makeText(getContext(), "title is Clicked", Toast.LENGTH_SHORT).show();

        }
    }
}