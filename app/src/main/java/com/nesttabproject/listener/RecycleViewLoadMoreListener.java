package com.nesttabproject.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nesttabproject.itf.LoadMoreCallBack;

/**
 * 作者：guofeng
 * 日期:16/10/10
 */

public class RecycleViewLoadMoreListener extends RecyclerView.OnScrollListener {


    private int lastVisbleItemPosition;


    private boolean isLoading = false;


    private RecyclerView.LayoutManager layoutManager;

    private LoadMoreCallBack loadMoreCallBack;

    private OnFootViewCallBack footViewCallBack;

    public void setFootViewCallBack(OnFootViewCallBack footViewCallBack) {
        this.footViewCallBack = footViewCallBack;
    }

    public void setLoadMoreCallBack(LoadMoreCallBack loadMoreCallBack) {
        this.loadMoreCallBack = loadMoreCallBack;
    }


    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        initLayoutManager(recyclerView);
        int position = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        if (!isLoading && layoutManager.getChildCount() > 0) {
            if (position != lastVisbleItemPosition && position == (layoutManager.getItemCount() - 1)) {
                if (footViewCallBack != null) {
                    footViewCallBack.setFootViewVisible(View.VISIBLE);
                }
                if (loadMoreCallBack != null) {
                    loadMoreCallBack.onLoadMoreListener(recyclerView);
                }
                isLoading = true;
            }
        }
        lastVisbleItemPosition = position;
    }


    private void initLayoutManager(RecyclerView recyclerView) {
        if (layoutManager == null) {
            layoutManager = recyclerView.getLayoutManager();
        }
    }

    public void onComplete() {
        isLoading = false;
        if (footViewCallBack != null) {
            footViewCallBack.setFootViewVisible(View.GONE);
        }
    }


    public interface OnFootViewCallBack {
        void setFootViewVisible(int state);
    }
}
