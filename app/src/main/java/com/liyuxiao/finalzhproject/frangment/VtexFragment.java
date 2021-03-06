package com.liyuxiao.finalzhproject.frangment;


import android.content.Intent;

import com.google.android.material.tabs.TabLayout;
import com.liyuxiao.finalzhproject.R;
import android.util.Log;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.liyuxiao.finalzhproject.V2exActivity;
import com.liyuxiao.finalzhproject.V2exItemFrangment;
import com.liyuxiao.finalzhproject.adapter.FrangVp;
import com.liyuxiao.finalzhproject.base.BaseMvpfrangment;
import com.liyuxiao.finalzhproject.bean.Bean_v2Tab;
import com.liyuxiao.finalzhproject.model.Vx2TabM;
import com.liyuxiao.finalzhproject.presenter.V2exTabP;
import com.liyuxiao.finalzhproject.view.V2exTabV;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

public class VtexFragment extends BaseMvpfrangment<Vx2TabM, V2exTabV, V2exTabP> implements V2exTabV {

    @BindView(R.id.goldim)
    ImageView goldim;
    @BindView(R.id.goldtab)
    TabLayout goldtab;
    @BindView(R.id.goldvp)
    ViewPager goldvp;
    Unbinder unbinder;

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.goldfrangment;
    }
    @OnClick(R.id.goldim)
    public void onimaClick(){
         Intent intent = new Intent(getActivity(), V2exActivity.class);
        startActivity(intent);
    }


    @Override
    protected V2exTabV initview() {
        return this;
    }

    @Override
    protected Vx2TabM initmodel() {
        return new Vx2TabM();
    }

    @Override
    protected V2exTabP initpresenter() {
        return new V2exTabP();
    }

    @Override
    public void OnFaile(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            private String TAG;

            @Override
            public void run() {
                Log.e(TAG, "run: "+msg );
            }
        });


    }

    @Override
    public void OnSuccess(final ArrayList<Bean_v2Tab> bean_v2Tab) {
        getActivity().runOnUiThread(new Runnable() {


            private FrangVp frangVp;
            private ArrayList<Fragment> list;

            @Override
            public void run() {
                list = new ArrayList<>();
                for (int i = 0; i <bean_v2Tab.size(); i++) {
                     Bean_v2Tab bean_v2Tab1 = bean_v2Tab.get(i);
                    list.add(new V2exItemFrangment(bean_v2Tab1.getHref()));
                    goldtab.addTab(goldtab.newTab().setText(bean_v2Tab1.getTitle()));
                }
                frangVp = new FrangVp(getChildFragmentManager(), list);
                goldvp.setAdapter(frangVp);

                goldtab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        goldvp.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });

                goldvp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(goldtab));
            }
        });
    }
}
