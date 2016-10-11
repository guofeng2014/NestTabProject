package com.nesttabproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nesttabproject.adapter.HotHireAdapter;
import com.nesttabproject.bean.HotHireBean;
import com.nesttabproject.itf.LoadMoreCallBack;
import com.nesttabproject.view.LoadMoreRecycleView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：guofeng
 * 日期:16/10/10
 */
public class TabHotHireFragment extends Fragment implements LoadMoreCallBack {

    private HotHireAdapter adapter;
    private LoadMoreRecycleView mRecyclerView;
    private List<HotHireBean> sList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fregment_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (LoadMoreRecycleView) view.findViewById(R.id.recycle);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new HotHireAdapter();
        mRecyclerView.setAdapter(adapter);
        sList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sList.add(new HotHireBean());
        }
        adapter.addData(sList);
        mRecyclerView.setCanAutoLoading(true);
        mRecyclerView.setAutoLoading(this);
    }

    @Override
    public void onLoadMoreListener(RecyclerView recycleView) {
        handler.sendEmptyMessageDelayed(0, 2000);
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            adapter.addData(new HotHireBean());
            mRecyclerView.doComplete();
            return false;
        }
    });
}
