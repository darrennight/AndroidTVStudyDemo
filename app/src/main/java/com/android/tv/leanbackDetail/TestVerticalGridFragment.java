package com.android.tv.leanbackDetail;

import android.os.Bundle;
import android.support.v17.leanback.app.VerticalGridFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.VerticalGridPresenter;

import com.android.tv.leanback.CardPresenter;
import com.android.tv.leanback.Movie;
import com.android.tv.leanback.MovieList;

import java.util.List;

/**
 * Created by zenghao on 16/8/15.
 */
public class TestVerticalGridFragment extends VerticalGridFragment {

    private ArrayObjectAdapter mRowsAdapter;
    private static final int NUM_COLUMNS = 4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadRows();
    }



    private void loadRows() {

        VerticalGridPresenter gridPresenter = new VerticalGridPresenter();
        gridPresenter.setNumberOfColumns(NUM_COLUMNS);
        setGridPresenter(gridPresenter);


        List<Movie> list = MovieList.setupMovies();


        //右边item
        CardPresenter cardPresenter = new CardPresenter();
        mRowsAdapter = new ArrayObjectAdapter(cardPresenter);

        for (int i = 0; i < 6; i++) {


        }
        mRowsAdapter.addAll(0,list);
        mRowsAdapter.addAll(0,list);
        mRowsAdapter.addAll(0,list);
        mRowsAdapter.addAll(0,list);

        setAdapter(mRowsAdapter);

    }


}
