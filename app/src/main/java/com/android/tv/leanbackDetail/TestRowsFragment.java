package com.android.tv.leanbackDetail;

import android.os.Bundle;
import android.support.v17.leanback.app.RowsFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;

import com.android.tv.leanback.CardPresenter;
import com.android.tv.leanback.Movie;
import com.android.tv.leanback.MovieList;

import java.util.Collections;
import java.util.List;

/**
 * Created by zenghao on 16/8/15.
 * RowsSupportFragment
 * RowsFragment
 */
public class TestRowsFragment extends RowsFragment {
    private ArrayObjectAdapter mRowsAdapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadRows();
    }


    private void loadRows() {
        List<Movie> list = MovieList.setupMovies();

        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        //右边item
        CardPresenter cardPresenter = new CardPresenter();

        int i;
        for (i = 0; i < 6; i++) {
            if (i != 0) {
                Collections.shuffle(list);
            }
            ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(cardPresenter);
            for (int j = 0; j < 6; j++) {
                listRowAdapter.add(list.get(j % 5));
            }
            HeaderItem header = new HeaderItem(i, MovieList.MOVIE_CATEGORY[i]);
            mRowsAdapter.add(new ListRow(header, listRowAdapter));
        }
        setAdapter(mRowsAdapter);

    }
}
