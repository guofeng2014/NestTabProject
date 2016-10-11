package com.nesttabproject.view;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * 作者：guofeng
 * 日期:16/10/10
 */

public class NestParentView extends LinearLayout implements NestedScrollingParent {
    /**
     * Scroll headView
     */
    private View headView;

    private View containerView;

    private View tabView;

    public NestParentView(Context context) {
        this(context, null);
    }

    public NestParentView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        setOrientation(VERTICAL);
    }

    public void setContainerView(View containerView) {
        this.containerView = containerView;
    }

    public void setTabView(View tabView) {
        this.tabView = tabView;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ViewGroup.LayoutParams params = containerView.getLayoutParams();
        params.height = getMeasuredHeight() - tabView.getMeasuredHeight();
        setMeasuredDimension(getMeasuredWidth(), headView.getMeasuredHeight() + tabView.getMeasuredHeight() + containerView.getMeasuredHeight());
    }

    /**
     * Set HeadView
     *
     * @param headView
     */
    public void setHeadView(View headView) {
        this.headView = headView;
    }


    /**
     * OverRidden scrollTo
     *
     * @param x
     * @param y
     */
    @Override
    public void scrollTo(int x, int y) {

        if (y < 0) {
            y = 0;
        }
        if (y > headView.getMeasuredHeight()) {
            y = headView.getMeasuredHeight();
        }
        if (y != getScrollY()) {
            super.scrollTo(x, y);
        }

    }


    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
    }

    @Override
    public void onStopNestedScroll(View target) {

    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        boolean hideTop = dy > 0 && getScrollY() < headView.getMeasuredHeight();
        boolean showTop = dy < 0 && getScrollY() > 0;// &&!ViewCompat.canScrollVertically(target, -1);
        if (showTop || hideTop) {
            scrollBy(0, dy);
            consumed[1] = dy;
        }
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return true;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public int getNestedScrollAxes() {
        return 0;
    }
}
