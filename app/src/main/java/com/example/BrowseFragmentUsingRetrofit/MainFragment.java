package com.example.BrowseFragmentUsingRetrofit;

import android.os.Bundle;

import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;

import android.util.Log;

import com.example.BrowseFragmentUsingRetrofit.Model.Cvte;
import com.example.BrowseFragmentUsingRetrofit.Model.Row;
import com.example.BrowseFragmentUsingRetrofit.Model.RowItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends BrowseSupportFragment {

    private static final String TAG = "MainFragment";
    List<Row> rowlist;
    List<RowItem> rowItemList;
    private ArrayObjectAdapter mRowsAdapter;
    private static final int GRID_ITEM_WIDTH = 600;
    private static final int GRID_ITEM_HEIGHT = 200;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUIElements();

        Log.d(TAG, "2 ");
        loadRows();

        Log.d(TAG, "2.1 ");
    }

    private void setupUIElements(){
        setTitle("CVTE Data From JSon");
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        // set fastLane (or headers) background color
        setBrandColor(getResources().getColor(R.color.fastlane_background));
    }
    private void loadRows() {

        Log.d(TAG, "3 ");
        Call<Cvte> apiCall = RetrofitClient.getInstance().getApis().getphotos();
        apiCall.enqueue(new Callback<Cvte>() {
            @Override
            public void onResponse(Call<Cvte> call, Response<Cvte> response) {
                Cvte cvte = response.body();
                rowlist = cvte.getRows();

                    Row newrow = rowlist.get(0);
                    List<RowItem> newRowItem = newrow.getRowItems();

                    mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
                    //FastLane1
                    HeaderItem cardPresenterHeader = new HeaderItem(1, "FastLane1");
                    CardPresenter cardPresenter = new CardPresenter();
                    ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);

                    for (int i = 0; i < newRowItem.size(); i++) {
                        RowItem newRowi = newRowItem.get(i);
                        cardRowAdapter.add(newRowi);
                    }
                    mRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));
                    setAdapter(mRowsAdapter);
            }





            @Override
            public void onFailure(Call<Cvte> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });



    }




}