package com.android.tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.android.tv.leanback.LeanBackMainActivity;

/**
 * Created by zenghao on 16/6/1.
 */
public class MainActivity extends Activity implements View.OnFocusChangeListener{

    private TextView mTrip;
    private TextView mHunter;
    private TextView mFound;
    private TextView mGride;
    private TextView mMe;
    private TextView mSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrip = ((TextView) findViewById(R.id.tv_trip));
        mHunter = ((TextView) findViewById(R.id.tv_hunter));
        mFound = ((TextView) findViewById(R.id.tv_found));
        mGride = ((TextView) findViewById(R.id.tv_girde));
        mMe = ((TextView) findViewById(R.id.tv_me));
        mSetting = ((TextView) findViewById(R.id.tv_setting));
        setListener();
        mHunter.requestFocus();
        animateSelected(mHunter);
    }

    private void setListener(){
            mTrip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,TripActivity.class
                    ));
                }
            });
            mGride.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,GrideStyleActivity.class
                    ));
                }
            });

        mMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LeanBackMainActivity.class
                ));
            }
        });

            mTrip.setOnFocusChangeListener(this);
            mHunter.setOnFocusChangeListener(this);
            mFound.setOnFocusChangeListener(this);
            mGride.setOnFocusChangeListener(this);
            mMe.setOnFocusChangeListener(this);
            mSetting.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){
            animateSelected(v);
        }else{
            animateUnselected(v);
        }
    }

    /** 分类块动画 */
    private Animation animSelected;
    public void animateSelected( View view) {
        if (animSelected != null) {
            animSelected.cancel();
            animSelected = null;
        }
        //关键方法让控件向前突出
        view.bringToFront();
        animSelected = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animSelected.setDuration(100);
        animSelected.setInterpolator(new AccelerateDecelerateInterpolator());
        animSelected.setFillAfter(true);
        view.startAnimation(animSelected);
    }

    private void animateUnselected( View view) {
        if (animSelected != null) {
            animSelected.cancel();
            animSelected = null;
        }
        animSelected = new ScaleAnimation(1.0f, 1.0f, 1.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animSelected.setDuration(100);
        animSelected.setInterpolator(new AccelerateDecelerateInterpolator());
        animSelected.setFillAfter(true);
        view.startAnimation(animSelected);
    }
}
