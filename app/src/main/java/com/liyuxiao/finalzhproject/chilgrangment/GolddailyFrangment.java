package com.liyuxiao.finalzhproject.chilgrangment;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liyuxiao.finalzhproject.R;
import com.liyuxiao.finalzhproject.adapter.Gold_RecviewAdapter;
import com.liyuxiao.finalzhproject.base.BaseMvpfrangment;
import com.liyuxiao.finalzhproject.bean.Gold_all;
import com.liyuxiao.finalzhproject.model.GoldM;
import com.liyuxiao.finalzhproject.presenter.GoldP;
import com.liyuxiao.finalzhproject.view.GoldV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class GolddailyFrangment extends BaseMvpfrangment<GoldM, GoldV, GoldP> implements GoldV {

    private static final String TAG = GolddailyFrangment.class.getName();
    private ArrayList<Gold_all.ResultsBean> list=new ArrayList<>();
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private String name;
    private Gold_RecviewAdapter adapter;

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        re.setLayoutManager(layoutManager);
        adapter = new Gold_RecviewAdapter(getContext(), list);
        re.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata(name);
    }

    @SuppressLint("ValidFragment")
    public GolddailyFrangment(String name) {
        this.name = name;
    }


    @Override
    protected GoldV initview() {
        return this;
    }

    @Override
    protected GoldM initmodel() {
        return new GoldM();
    }

    @Override
    protected GoldP initpresenter() {
        return new GoldP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_daily_frangment;
    }

    @Override
    public void OnSuccess(Gold_all gold_all) {
         ArrayList<Gold_all.ResultsBean> results = gold_all.getResults();
         list.addAll(results);
         adapter.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );

    }
}
