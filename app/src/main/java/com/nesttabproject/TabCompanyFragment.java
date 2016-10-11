package com.nesttabproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nesttabproject.adapter.CompanyDescAdapter;
import com.nesttabproject.bean.CompanyDesBean;
import com.nesttabproject.view.LoadMoreRecycleView;

import java.util.ArrayList;
import java.util.List;


public class TabCompanyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fregment_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LoadMoreRecycleView mRecyclerView = (LoadMoreRecycleView) view.findViewById(R.id.recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CompanyDescAdapter adapter = new CompanyDescAdapter();
        List<CompanyDesBean> sList = new ArrayList<>();
        sList.add(new CompanyDesBean());
        adapter.addData(sList);
        mRecyclerView.setAdapter(adapter);
    }

}
