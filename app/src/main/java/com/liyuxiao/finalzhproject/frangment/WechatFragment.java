package com.liyuxiao.finalzhproject.frangment;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liyuxiao.finalzhproject.R;
import com.liyuxiao.finalzhproject.adapter.WechatRecviewAdapter;
import com.liyuxiao.finalzhproject.base.BaseMvpfrangment;
import com.liyuxiao.finalzhproject.bean.Bean_Wechat;
import com.liyuxiao.finalzhproject.model.WechatM;
import com.liyuxiao.finalzhproject.presenter.WeChatP;
import com.liyuxiao.finalzhproject.view.WeChatV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;

public class WechatFragment extends BaseMvpfrangment<WechatM, WeChatV, WeChatP> implements WeChatV {

private ArrayList<Bean_Wechat.NewslistBean> list=new ArrayList<>();
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private WechatRecviewAdapter adapter;

    @Override
    protected void initView() {
        super.initView();
         LinearLayoutManager manager = new LinearLayoutManager(getContext());
        re.setLayoutManager(manager);
        adapter = new WechatRecviewAdapter(getContext(), list);
        re.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata();
    }

    @Override
    protected WeChatV initview() {
        return this;
    }

    @Override
    protected WechatM initmodel() {
        return new WechatM();
    }

    @Override
    protected WeChatP initpresenter() {
        return new WeChatP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_daily_frangment;
    }

    @Override
    public void OnSuccess(Bean_Wechat bean_wechat) {
         ArrayList<Bean_Wechat.NewslistBean> newslist = bean_wechat.getNewslist();
         list.addAll(newslist);
         adapter.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );

    }
}
