package com.android.tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zenghao on 16/6/2.
 */
public class GrideStyleActivity extends Activity {

    private TextView mStyle1;
    private TextView mStyle2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gride);
        initView();
        setListener();
    }

    private void initView(){
        mStyle1 = ((TextView) findViewById(R.id.tv_1));
        mStyle2 = ((TextView) findViewById(R.id.tv_2));

    }

    private void setListener(){
        mStyle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GrideStyleActivity.this,GrideStyleOne.class));
            }
        });
        mStyle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GrideStyleActivity.this,GrideStyleTwo.class));
            }
        });
    }
}
