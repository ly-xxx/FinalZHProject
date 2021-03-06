package com.liyuxiao.finalzhproject.adapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.liyuxiao.finalzhproject.R;
import com.liyuxiao.finalzhproject.base.BaseMvpfrangment;
import com.liyuxiao.finalzhproject.model.InfoM;
import com.liyuxiao.finalzhproject.presenter.Infop;
import com.liyuxiao.finalzhproject.view.InfoV;

import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyFrangment extends BaseMvpfrangment<InfoM, InfoV, Infop> {

    RecyclerView re;
    Unbinder unbinder;

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected InfoV initview() {
        return null;
    }

    @Override
    protected InfoM initmodel() {
        return null;
    }

    @Override
    protected Infop initpresenter() {
        return null;
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_daily_frangment;
    }

}
