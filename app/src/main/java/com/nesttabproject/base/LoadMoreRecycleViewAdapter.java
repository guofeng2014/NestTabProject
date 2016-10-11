package com.nesttabproject.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nesttabproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：guofeng
 * 日期:16/10/10
 */
public abstract class LoadMoreRecycleViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected static final int FOOT_VIEW = 0x1000;

    protected List<T> mData = new ArrayList<>();

    private boolean hasLoadMore = false;

    public LinearLayout footView;

    public void setHasLoadMore(boolean hasLoadMore) {
        this.hasLoadMore = hasLoadMore;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //卡片样式是加载更多
        if (viewType == FOOT_VIEW) {
            footView = defaultFooter(parent);
            return new FootViewHolder(footView);
        }
        //卡片样式是普通样式
        else {
            return onCreateItemViewHolder(parent, viewType);
        }
    }

    public abstract RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (!(hasLoadMore && position == getItemCount() - 1)) {
            onBindItemViewHolder(holder, position);
        }
    }

    public final int getItemCount() {
        int count = mData.size();
        return count == 0 ? 0 : count + (hasLoadMore ? 1 : 0);
    }

    @Override
    public final int getItemViewType(int position) {
        if (hasLoadMore && position == getItemCount() - 1) {
            return FOOT_VIEW;
        } else {
            return getRvItemViewType(position);
        }
    }

    /**
     * 添加集合数据
     *
     * @param listData
     */
    public void addData(List<T> listData) {
        if (listData != null && listData.size() > 0) {
            mData.addAll(listData);
            notifyDataSetChanged();
        }
    }

    /**
     * 添加一个数据
     *
     * @param data
     */
    public void addData(T data) {
        if (data != null) {
            mData.add(data);
            notifyDataSetChanged();
        }
    }


    private LinearLayout defaultFooter(ViewGroup parent) {
        return (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.view_loading_more_item, parent, false);
    }

    public abstract int getRvItemViewType(int position);

    public abstract void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position);

    public class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }
}
