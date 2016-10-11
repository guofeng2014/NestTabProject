package com.nesttabproject.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.nesttabproject.itf.LoadMoreCallBack;
import com.nesttabproject.listener.RecycleViewLoadMoreListener;
import com.nesttabproject.base.LoadMoreRecycleViewAdapter;

/**
 * 作者：guofeng
 * ＊ 日期:16/10/11
 */

public class LoadMoreRecycleView extends RecyclerView implements RecycleViewLoadMoreListener.OnFootViewCallBack {

    private RecycleViewLoadMoreListener loadMoreListener = new RecycleViewLoadMoreListener();

    private LoadMoreCallBack loadMoreCallBack;

    public LoadMoreRecycleView(Context context) {
        this(context, null);
    }


    public LoadMoreRecycleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadMoreRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void init() {
        addOnScrollListener(loadMoreListener);
        loadMoreListener.setLoadMoreCallBack(loadMoreCallBack);
        loadMoreListener.setFootViewCallBack(this);
    }

    @Override
    public void setFootViewVisible(int state) {
        Adapter adapter = getAdapter();
        if (adapter instanceof LoadMoreRecycleViewAdapter) {
            LoadMoreRecycleViewAdapter mAdapter = (LoadMoreRecycleViewAdapter) adapter;
            mAdapter.footView.setVisibility(state);
        }
    }

    /**
     * 加载更多回调,处理业务逻辑
     *
     * @param loadMoreCallBack
     */
    public void setAutoLoading(LoadMoreCallBack loadMoreCallBack) {
        this.loadMoreCallBack = loadMoreCallBack;
        init();
    }

    /**
     * 加载完毕
     */
    public void doComplete() {
        loadMoreListener.onComplete();
    }

    /**
     * 设置是否可以加载更多
     *
     * @param canAutoLoading
     */
    public void setCanAutoLoading(boolean canAutoLoading) {
        Adapter adapter = getAdapter();
        if (adapter instanceof LoadMoreRecycleViewAdapter) {
            LoadMoreRecycleViewAdapter mAdapter = (LoadMoreRecycleViewAdapter) adapter;
            mAdapter.setHasLoadMore(canAutoLoading);
        }
    }
}
