package com.android.tv;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.tv.adapter.CloudMoviesItemAdapter;

import java.util.ArrayList;

/**
 * Created by zenghao on 16/6/2.
 */
public class GrideStyleOne extends Activity {

    private GridView mGrid;
    private CloudMoviesItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_one);
        mGrid = ((GridView) findViewById(R.id.mov_gridview));
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<=50;i++){
            list.add(String.valueOf(i));
        }
        mAdapter = new CloudMoviesItemAdapter(this,list);
        mGrid.setAdapter(mAdapter);

        mGrid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
