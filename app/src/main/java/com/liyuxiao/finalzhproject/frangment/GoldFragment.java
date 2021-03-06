package com.liyuxiao.finalzhproject.frangment;


import android.content.Intent;

import com.google.android.material.tabs.TabLayout;
import com.liyuxiao.finalzhproject.GoldActivity;
import com.liyuxiao.finalzhproject.R;
import com.liyuxiao.finalzhproject.adapter.GoldFrangVp;
import com.liyuxiao.finalzhproject.base.BaseFrangment;
import com.liyuxiao.finalzhproject.bean.Gold_bean;
import com.liyuxiao.finalzhproject.chilgrangment.GolddailyFrangment;

import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GoldFragment extends BaseFrangment {


    private String[] type=new String[]{"All","Android","iOS","休息视频","拓展资源","瞎推荐","前端"};
    @BindView(R.id.goldim)
    ImageView goldim;
    @BindView(R.id.goldtab)
    TabLayout goldtab;
    @BindView(R.id.goldvp)
    ViewPager goldvp;
    Unbinder unbinder;
    private ArrayList<Gold_bean> list;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> title;
    private GoldFrangVp frangVp;
    private Serializable list1;

    @Override
    protected int getlayoutId() {
        return R.layout.goldfrangment;
    }

    @Override
    protected void initView() {
        super.initView();
        list = new ArrayList<>();
        for (int i = 0; i <7 ; i++) {
        if (i%3==0){
             Gold_bean gold_bean = new Gold_bean(type[i], true);
             list.add(gold_bean);
        }else {
             Gold_bean gold_bean = new Gold_bean(type[i], false);
            list.add(gold_bean);
        }
        }
        fragments = new ArrayList<>();
        title = new ArrayList<>();
    }

    @Override
    protected void initData() {
        super.initData();
        for (int i = 0; i <list.size() ; i++) {
             Gold_bean gold_bean = list.get(i);
            if (gold_bean.isSelected()){
                fragments.add(new GolddailyFrangment(gold_bean.getName()));
                title.add(gold_bean.getName());
            }
        }
        frangVp = new GoldFrangVp(getChildFragmentManager(), fragments, type);
        goldvp.setAdapter(frangVp);
        goldtab.setupWithViewPager(goldvp);
    }

    @Override
    protected void initListener() {
        super.initListener();
        goldim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GoldActivity.class);
                intent.putExtra("list",list);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1&&resultCode==2){
            list = (ArrayList<Gold_bean>) data.getSerializableExtra("list");
            fragments.clear();
            title.clear();
            initData();
        }
//        super.onActivityResult(requestCode, resultCode, data);
    }
}
