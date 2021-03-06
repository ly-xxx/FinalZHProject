package com.liyuxiao.finalzhproject.chilgrangment;

import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liyuxiao.finalzhproject.R;
import com.liyuxiao.finalzhproject.adapter.Recadapters3;
import com.liyuxiao.finalzhproject.base.BaseMvpfrangment;
import com.liyuxiao.finalzhproject.bean.Bean_ZhuanLan;
import com.liyuxiao.finalzhproject.model.ZhuanM;
import com.liyuxiao.finalzhproject.presenter.ZhuanP;
import com.liyuxiao.finalzhproject.view.ZhuanV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ZhuanFrangment extends BaseMvpfrangment<ZhuanM, ZhuanV, ZhuanP> implements ZhuanV {
    private static final String TAG = ZhuanFrangment.class.getName();
    private ArrayList<Bean_ZhuanLan.DataBean> list=new ArrayList<>();

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private Recadapters3 recadapters3;

    @Override
    protected void initView() {
        super.initView();
         GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        re.setLayoutManager(manager);
        recadapters3 = new Recadapters3(getContext(), list);
        re.setAdapter(recadapters3);
    }

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata();
    }

    @Override
    protected ZhuanV initview() {
        return this;
    }

    @Override
    protected ZhuanM initmodel() {
        return new ZhuanM();
    }

    @Override
    protected ZhuanP initpresenter() {
        return new ZhuanP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_daily_frangment;
    }

    @Override
    public void OnSuccess(Bean_ZhuanLan bean_zhuanLan) {
         ArrayList<Bean_ZhuanLan.DataBean> data = bean_zhuanLan.getData();
         list.addAll(data);
         recadapters3.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );

    }
}
