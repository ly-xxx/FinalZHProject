package com.liyuxiao.finalzhproject.chilgrangment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liyuxiao.finalzhproject.R;
import com.liyuxiao.finalzhproject.adapter.RecviewAdapters4;
import com.liyuxiao.finalzhproject.base.BaseMvpfrangment;
import com.liyuxiao.finalzhproject.bean.Bean_ReMen;
import com.liyuxiao.finalzhproject.model.HotM;
import com.liyuxiao.finalzhproject.presenter.HotP;
import com.liyuxiao.finalzhproject.view.HotV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HotFrangment extends BaseMvpfrangment<HotM, HotV, HotP> implements HotV {

private ArrayList<Bean_ReMen.RecentBean> list=new ArrayList<>();
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private RecviewAdapters4 adapters4;

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        re.setLayoutManager(manager);
        adapters4 = new RecviewAdapters4(getContext(), list);
        re.setAdapter(adapters4);
    }

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata();
    }

    @Override
    protected HotV initview() {
        return this;
    }

    @Override
    protected HotM initmodel() {
        return new HotM();
    }

    @Override
    protected HotP initpresenter() {
        return new HotP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_daily_frangment;
    }

    @Override
    public void OnSuccess(Bean_ReMen bean_reMen) {
         ArrayList<Bean_ReMen.RecentBean> recent = bean_reMen.getRecent();
         list.addAll(recent);
         adapters4.notifyDataSetChanged();

    }

    @Override
    public void OnFaile(String msg) {

    }

}
