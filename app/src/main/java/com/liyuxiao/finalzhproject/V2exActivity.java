package com.liyuxiao.finalzhproject;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liyuxiao.finalzhproject.adapter.ReV2exAdapetr;
import com.liyuxiao.finalzhproject.base.BaseMvpactivity;
import com.liyuxiao.finalzhproject.bean.Bean_V2ex;
import com.liyuxiao.finalzhproject.model.V2exM;
import com.liyuxiao.finalzhproject.presenter.V2exP;
import com.liyuxiao.finalzhproject.view.V2exV;

import java.util.ArrayList;

import butterknife.BindView;

public class V2exActivity extends BaseMvpactivity<V2exM, V2exV, V2exP> implements V2exV {

    private static final String TAG = V2exActivity.class.getName();
    private ArrayList<Bean_V2ex.DataBean> list=new ArrayList<>();
    @BindView(R.id.re)
    RecyclerView re;
    private ReV2exAdapetr adapetr;

    @Override
    protected void initView() {
        super.initView();
        re.setLayoutManager(new LinearLayoutManager(this));
        adapetr = new ReV2exAdapetr(this, list);
        re.setAdapter(adapetr);
    }
    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata();
    }

    @Override
    protected V2exV initview() {
        return this;
    }

    @Override
    protected V2exM initmodel() {
        return new V2exM();
    }

    @Override
    protected V2exP initpresenter() {
        return new V2exP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_v2ex;

    }

    @Override
    public void OnSuccess(Bean_V2ex bean_v2ex) {
        final ArrayList<Bean_V2ex.DataBean> data = bean_v2ex.getData();
        list.addAll(data);
        RecyclerView.ItemDecoration normalDecoration = new RecyclerView.ItemDecoration() {
            public String getHeaderName(int i) {
                return data.get(i).getName();
            }
        };
        re.addItemDecoration(normalDecoration);
        adapetr.setList(bean_v2ex.getData());
        adapetr.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );
    }
}
