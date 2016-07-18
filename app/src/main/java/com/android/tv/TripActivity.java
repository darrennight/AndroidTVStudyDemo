package com.android.tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zenghao on 16/6/2.
 */
public class TripActivity extends Activity {

    private TextView bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);
        initView();
    }

    private void initView(){
        bt1 = ((TextView) findViewById(R.id.tv_bt1));
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TripActivity.this,LinearLayoutActivity.class));
            }
        });
    }






    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /*if(keyCode == KeyEvent.KEYCODE_DPAD_RIGHT){
        //按键拦截
            return true;
        }*/
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
    }
}
