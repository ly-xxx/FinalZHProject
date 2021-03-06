package com.liyuxiao.finalzhproject.frangment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.liyuxiao.finalzhproject.R;
import com.liyuxiao.finalzhproject.adapter.DailyFrangment;
import com.liyuxiao.finalzhproject.adapter.FrangVp;
import com.liyuxiao.finalzhproject.base.BaseFrangment;
import com.liyuxiao.finalzhproject.chilgrangment.HotFrangment;
import com.liyuxiao.finalzhproject.chilgrangment.ZhuanFrangment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

public class SearchFragment extends BaseFrangment {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private ArrayList<Fragment> list;
    private FrangVp vp1;

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_zhihu;
    }

    @Override
    protected void initView() {
        super.initView();
        frangmet();
    }

    private void frangmet() {
        list = new ArrayList<>();
        list.add(new DailyFrangment());
        list.add(new ZhuanFrangment());
        list.add(new HotFrangment());

        vp1 = new FrangVp(getChildFragmentManager(), list);
        vp.setAdapter(vp1);
        tab.addTab(tab.newTab().setText("日报"));
        tab.addTab(tab.newTab().setText("专栏"));
        tab.addTab(tab.newTab().setText("热门"));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
    }
}
