package com.android.tv;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

/**
 * Created by zenghao on 16/6/4.
 */
public class LinearLayoutActivity extends Activity implements View.OnFocusChangeListener{

    private TextView num1;
    private TextView num2;
    private TextView num3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayout);
        intView();
    }

    private void intView(){
        num1 = ((TextView) findViewById(R.id.tv_num1));
        num2 = ((TextView) findViewById(R.id.tv_num2));
        num3 = ((TextView) findViewById(R.id.tv_num3));

        num1.requestFocus();
        animateSelected(num1);

        num3.setOnFocusChangeListener(this);
        num2.setOnFocusChangeListener(this);
        num1.setOnFocusChangeListener(this);
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
