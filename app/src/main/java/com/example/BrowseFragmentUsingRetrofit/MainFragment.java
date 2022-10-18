package com.example.BrowseFragmentUsingRetrofit;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;

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
    private ArrayObjectAdapter mRowsAdapter;
    private  SimpleBackgroundManager simpleBackgroundManager = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simpleBackgroundManager = new SimpleBackgroundManager(getActivity());
        setupUIElements();
        loadRows();
        setupEventListeners();
    }
    private void setupUIElements(){
        setTitle("Cloud TV");
        setHeadersState(HEADERS_ENABLED);
        // set fastLane (or headers) background color
       // setBrandColor(getResources().getColor(R.color.fastlane_background));
    }

    private void setupEventListeners() {
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, androidx.leanback.widget.Row row) {

            if (item instanceof String) { // GridItemPresenter row
                simpleBackgroundManager.clearBackground();
            } else if (item instanceof RowItem) { // CardPresenter row
                simpleBackgroundManager.updateBackground(getActivity().getDrawable(R.drawable.img));
            }
        }
    }
    private void loadRows() {

        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        Call<Cvte> apiCall = RetrofitClient.getInstance().getApis().getphotos();

        apiCall.enqueue(new Callback<Cvte>() {
            @Override
            public void onResponse(Call<Cvte> call, Response<Cvte> response) {
                Cvte cvte = response.body();

                List<Row> rowlist;
                rowlist = cvte.getRows();
                Log.d(TAG, "rowlist size"+rowlist.size());
                for (int a = 0; a < rowlist.size(); a++) {
                    Row newrow = rowlist.get(a);
                    List<RowItem> newRowItem = newrow.getRowItems();

                    HeaderItem cardPresenterHeader = new HeaderItem(newrow.getRowHeader());
                    CardPresenter cardPresenter = new CardPresenter();
                    ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);

                    for (int i = 0; i <newRowItem.size(); i++) {
                        RowItem newRowi = newRowItem.get(i);
                        newRowi.setLayoutType(newrow.getRowLayout());
                        cardRowAdapter.add(newRowi);

                    }

                    mRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));
                }
                setAdapter(mRowsAdapter);
            }

            @Override
            public void onFailure(Call<Cvte> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

}