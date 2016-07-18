package com.android.tv;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;

import com.android.tv.adapter.GridTwoAdapter;
import com.android.tv.tvWidget.GridWidget;

import java.util.ArrayList;

/**
 * Created by zenghao on 16/6/2.
 */
public class GrideStyleTwo extends Activity {

    private GridWidget mGrid;
    private GridTwoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_two);
        mGrid = ((GridWidget) findViewById(R.id.mov_gridview));
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<=50;i++){
            list.add(String.valueOf(i));
        }
        mAdapter = new GridTwoAdapter(this,list);
        mGrid.setSelector(new ColorDrawable(Color.TRANSPARENT));
        mGrid.setAdapter(mAdapter);

        mGrid.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                mGrid.setSelection();
//                mGrid.getChildCount()
//                int count =   mGrid.getCount();
//               int selectPos =  mGrid.getSelectedItemPosition();
//                View view = mGrid.getSelectedView();

//                mGrid.getNumColumns()


//                if(selectPos == 49 && keyCode == KeyEvent.KEYCODE_DPAD_DOWN && event.getAction()==KeyEvent.ACTION_DOWN){
//                    mGrid.setSelection(50);
//                    return true;
//                }

//                if(view!=null){
//                    animateSelected(view);
//                }

                return false;
            }
        });
        mGrid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Log.e("===","===onItemSelected"+position);
//                Log.e("===","===onItemSelected");
                /*View focus = parent.focusSearch(View.FOCUS_DOWN);
                if(focus!=null){
                    Log.e("====","==="+focus.getClass().getName());
                }*/
                if(view!=null && view.getVisibility() == View.VISIBLE){
//                    view.bringToFront();
                   // animateSelected(view);

                    mGrid.bringChildToFront(view);
                }
//                if(position == 49){
//                    mGrid.smoothScrollByOffset(10);
//                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        mGrid.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
//                Log.e("====","==="+v.getClass().getName());
            }
        });

        mGrid.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

//        Log.e("===","===keydown");

        return super.onKeyDown(keyCode, event);
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
