package com.liyuxiao.finalzhproject.adapter;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.liyuxiao.finalzhproject.R;
import com.liyuxiao.finalzhproject.bean.Gold_bean;
import com.liyuxiao.finalzhproject.util.TouchCallBack;

import java.util.ArrayList;
import java.util.Collections;

public class RvGoldrecviewAdapter extends RecyclerView.Adapter<RvGoldrecviewAdapter.ViewHolder>implements TouchCallBack {
    private Context context;
    private ArrayList<Gold_bean> list;

    public RvGoldrecviewAdapter(Context context, ArrayList<Gold_bean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RvGoldrecviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=View.inflate(context,R.layout.item_golddailyfrangment,null);
         ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RvGoldrecviewAdapter.ViewHolder holder, int position) {
         final Gold_bean gold_bean = list.get(position);
         holder.tv.setText(gold_bean.getName());
         holder.add.setChecked(gold_bean.isSelected());
         holder.add.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 gold_bean.setSelected(isChecked);
             }
         });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    //上下拖动，实现数据位置交换，刷新局部位置
    public void oniteMove(int fromPosition, int toPosition) {
        //数据位置交换
        Collections.swap(list,fromPosition,toPosition);
        //局部刷新位置
        notifyItemMoved(fromPosition,toPosition);
    }

    //想左滑动，实现数据删除，刷新局部页面
    @Override
    public void onitemDelete(int position) {

        //数据删除
        list.remove(position);
        //刷新局部页面
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;
        private SwitchCompat add;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.itemtv);
            add = itemView.findViewById(R.id.itemadd);
        }
    }
}
