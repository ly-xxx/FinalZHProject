package com.liyuxiao.finalzhproject;

import android.content.Intent;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liyuxiao.finalzhproject.adapter.RvGoldrecviewAdapter;
import com.liyuxiao.finalzhproject.base.BaseActivity;
import com.liyuxiao.finalzhproject.bean.Gold_bean;
import com.liyuxiao.finalzhproject.util.SimpleItemTouchHelperCallBack;

import java.util.ArrayList;
import butterknife.BindView;

public class GoldActivity extends BaseActivity {
    @BindView(R.id.re)
    RecyclerView re;
    private ArrayList<Gold_bean> list;
    private RvGoldrecviewAdapter adapter;

    @Override
    protected int getlayoutId() {
        return R.layout.goldactivity;
    }

    @Override
    protected void initView() {
        list = (ArrayList<Gold_bean>) getIntent().getSerializableExtra("list");
        adapter = new RvGoldrecviewAdapter(this, list);
        re.setAdapter(adapter);
        re.setLayoutManager(new LinearLayoutManager(this));


        SimpleItemTouchHelperCallBack simpleIte = new SimpleItemTouchHelperCallBack(adapter);
         ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleIte);
        itemTouchHelper.attachToRecyclerView(re);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("list",list);
        setResult(2,intent);
        super.onBackPressed();
    }
}

