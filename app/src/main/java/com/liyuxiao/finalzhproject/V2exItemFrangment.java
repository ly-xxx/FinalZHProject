package com.liyuxiao.finalzhproject;


import android.annotation.SuppressLint;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liyuxiao.finalzhproject.adapter.V2exRecviewAdapter;
import com.liyuxiao.finalzhproject.base.BaseMvpfrangment;
import com.liyuxiao.finalzhproject.bean.Bean_V2ItemBean;
import com.liyuxiao.finalzhproject.model.V2exItemM;
import com.liyuxiao.finalzhproject.presenter.V2exItemP;
import com.liyuxiao.finalzhproject.view.V2exItemV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;

@SuppressLint("ValidFragment")
public class V2exItemFrangment extends BaseMvpfrangment<V2exItemM, V2exItemV, V2exItemP> implements V2exItemV {

    private ArrayList<Bean_V2ItemBean> list=new ArrayList<>();

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private String name;
    private V2exRecviewAdapter adapter;

    @Override
    protected void initView() {
        super.initView();
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new V2exRecviewAdapter(getContext(), list);
        re.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata(name);
    }

    @SuppressLint("ValidFragment")
    public V2exItemFrangment(String href) {
        this.name = name;
    }

    @Override
    protected V2exItemV initview() {
        return this;
    }

    @Override
    protected V2exItemM initmodel() {
        return new V2exItemM();
    }

    @Override
    protected V2exItemP initpresenter() {
        return new V2exItemP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_v2ex_item_frangment;
    }

    @Override
    public void OnSuccess(final ArrayList<Bean_V2ItemBean> bean_v2ItemBeans) {
    getActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {
            list.addAll(bean_v2ItemBeans);
            adapter.setList(list);
            adapter.notifyDataSetChanged();
        }
    });
    }

    @Override
    public void OnFaile(final String msg) {
       getActivity().runOnUiThread(new Runnable() {
           @Override
           public void run() {
               Log.e(TAG, "OnFaile: "+msg );
           }
       });

    }
}
