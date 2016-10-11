package com.nesttabproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nesttabproject.R;
import com.nesttabproject.base.LoadMoreRecycleViewAdapter;
import com.nesttabproject.bean.HotHireBean;

/**
 * 作者：guofeng
 * ＊ 日期:16/10/11
 */

public class HotHireAdapter extends LoadMoreRecycleViewAdapter<HotHireBean> {
    @Override
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_hot_hire_job_item, parent, false);
        return new HotHireJobHolder(view);
    }

    @Override
    public int getRvItemViewType(int position) {
        return 0;
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    /**
     * 热招职位卡片
     */
    public class HotHireJobHolder extends RecyclerView.ViewHolder {
        public TextView tvName;

        public HotHireJobHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
