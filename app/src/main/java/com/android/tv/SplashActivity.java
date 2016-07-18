package com.android.tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends Activity {

    private TextView mJump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mJump = ((TextView) findViewById(R.id.tv_jump));
        //mJump.requestFocus();
        mJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SplashActivity.this,"哈哈哈哈",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        });
    }
}
