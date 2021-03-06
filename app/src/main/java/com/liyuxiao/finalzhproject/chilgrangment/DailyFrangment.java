package com.liyuxiao.finalzhproject.chilgrangment;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liyuxiao.finalzhproject.R;
import com.liyuxiao.finalzhproject.adapter.RecviewAdapter1;
import com.liyuxiao.finalzhproject.base.BaseMvpfrangment;
import com.liyuxiao.finalzhproject.bean.Bean_Zhihu;
import com.liyuxiao.finalzhproject.model.InfoM;
import com.liyuxiao.finalzhproject.presenter.Infop;
import com.liyuxiao.finalzhproject.view.InfoV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

public class DailyFrangment extends BaseMvpfrangment<InfoM, InfoV, Infop> implements InfoV {

    private static final String TAG = DailyFrangment.class.getName();
    private ArrayList<Bean_Zhihu.StoriesBean> list1=new ArrayList<>();
    private ArrayList<Bean_Zhihu.TopStoriesBean> list=new ArrayList<>();
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private RecviewAdapter1 adapter1;

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        re.setLayoutManager(manager);
        adapter1 = new RecviewAdapter1(getContext(), list1, list);
        re.setAdapter(adapter1);
    }

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata();
    }

    @Override
    protected InfoV initview() {
        return this;

    }

    @Override
    protected InfoM initmodel() {
        return new InfoM();
    }

    @Override
    protected Infop initpresenter() {
        return new Infop();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_daily_frangment;
    }

    @Override
    public void OnSuccess(Bean_Zhihu bean_zhihu) {
         ArrayList<Bean_Zhihu.StoriesBean> stories = bean_zhihu.getStories();
         list1.addAll(stories);
         ArrayList<Bean_Zhihu.TopStoriesBean> top_stories = bean_zhihu.getTop_stories();
         list.addAll(top_stories);
         adapter1.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );

    }
}
