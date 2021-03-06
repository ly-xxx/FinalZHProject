package com.liyuxiao.finalzhproject.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.liyuxiao.finalzhproject.R;
import com.liyuxiao.finalzhproject.bean.Bean_Wechat;

import java.util.ArrayList;

public class WechatRecviewAdapter extends RecyclerView.Adapter<WechatRecviewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Bean_Wechat.NewslistBean> list;

    public WechatRecviewAdapter(Context context, ArrayList<Bean_Wechat.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public WechatRecviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.wechat_item,null);
         ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WechatRecviewAdapter.ViewHolder holder, int position) {
        holder.tv1.setText(list.get(position).getTitle());
        holder.tv2.setText(list.get(position).getDescription());
        holder.tv3.setText(list.get(position).getCtime());
        Glide.with(context).load(list.get(position).getPicUrl()).into(holder.im);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView im;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;

        public ViewHolder(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.wechatim);
            tv1 = itemView.findViewById(R.id.wechattv1);
            tv2 = itemView.findViewById(R.id.wechattv2);
            tv3 = itemView.findViewById(R.id.wechattv3);
        }
    }
}
