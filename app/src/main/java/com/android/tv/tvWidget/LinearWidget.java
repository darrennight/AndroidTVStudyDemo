package com.android.tv.tvWidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by zenghao on 16/6/4.
 *
 * 忘记说了关键的一步，不要忘记设置函数 setChildrenDrawingOrderEnabled(true)
 * FrameLayout viewGroup ListView gridView等需要此方式的重写
 * RelativeLayout不需要其他都需要
 */
public class LinearWidget extends LinearLayout {
    public LinearWidget(Context context) {
        super(context);
        init(context);
    }

    public LinearWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LinearWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    WidgetTvViewBring mWidgetTvViewBring;

    private void init(Context context) {
        //此方法重要
        this.setChildrenDrawingOrderEnabled(true);
        mWidgetTvViewBring = new WidgetTvViewBring(this);
    }

    /***
     * bringChildToFront 能让child向前突出
     * 是因为重绘了子控件 最后绘制的在所有子控件的上面
     * @param child
     */
    @Override
    public void bringChildToFront(View child) {
        mWidgetTvViewBring.bringChildToFront(this, child);
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        return mWidgetTvViewBring.getChildDrawingOrder(childCount, i);
    }
}
