package com.nesttabproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.nesttabproject.view.NestParentView;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout llHeadView = (LinearLayout) findViewById(R.id.ll_head);
        LinearLayout llTab = (LinearLayout) findViewById(R.id.ll_tab);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        NestParentView parent = (NestParentView) findViewById(R.id.ll_parent);
        parent.setHeadView(llHeadView);
        parent.setTabView(llTab);
        parent.setContainerView(viewPager);
        final Fragment[] fragments = new Fragment[2];
        fragments[0] = new TabCompanyFragment();
        fragments[1] = new TabHotHireFragment();
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        });
    }


}
