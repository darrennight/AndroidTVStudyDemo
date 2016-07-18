package com.android.tv.tvWidget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * Created by zenghao on 16/6/4.
 */
public class GridWidget extends GridView {
    public GridWidget(Context context) {
        super(context);
        init(context);
    }

    public GridWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GridWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    WidgetTvViewBring mWidgetTvViewBring;

    private void init(Context context) {
        //此方法重要
        this.setChildrenDrawingOrderEnabled(true);
        mWidgetTvViewBring = new WidgetTvViewBring(this);
    }

    @Override
    public void bringChildToFront(View child) {
        if(child!=null && child.getVisibility() == View.VISIBLE){
            mWidgetTvViewBring.bringChildToFront(this, child);
        }

    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        return mWidgetTvViewBring.getChildDrawingOrder(childCount, i);
    }



    @Override
    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        }catch (Exception e){

        }

    }
}
