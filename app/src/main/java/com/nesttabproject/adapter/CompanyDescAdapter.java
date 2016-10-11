package com.nesttabproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nesttabproject.R;
import com.nesttabproject.base.LoadMoreRecycleViewAdapter;
import com.nesttabproject.bean.CompanyDesBean;

/**
 * 作者：guofeng
 * ＊ 日期:16/10/11
 */

public class CompanyDescAdapter extends LoadMoreRecycleViewAdapter<CompanyDesBean> {
    @Override
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_company_desc_item, parent, false);
        return new CompanyDesHolder(view);
    }

    @Override
    public int getRvItemViewType(int position) {
        return 0;
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CompanyDesHolder) holder).tvCompanyDesc.setText("公司描述");
    }

    /**
     * 公司概况卡片
     */
    public class CompanyDesHolder extends RecyclerView.ViewHolder {
        public TextView tvCompanyDesc;

        public CompanyDesHolder(View itemView) {
            super(itemView);
            tvCompanyDesc = (TextView) itemView.findViewById(R.id.tv_company_desc);
        }
    }
}
