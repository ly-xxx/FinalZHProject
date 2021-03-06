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
import com.liyuxiao.finalzhproject.bean.Bean_ReMen;

import java.util.ArrayList;

public class RecviewAdapters4 extends RecyclerView.Adapter<RecviewAdapters4.ViewHolder>{
    private Context context;
    private ArrayList<Bean_ReMen.RecentBean> list;

    public RecviewAdapters4(Context context, ArrayList<Bean_ReMen.RecentBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecviewAdapters4.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.framng4_item,null);
         ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecviewAdapters4.ViewHolder holder, int position) {
        holder.tv2.setText(list.get(position).getTitle());
       Glide.with(context).load(list.get(position).getThumbnail()).placeholder(R.mipmap.ic_launcher).into(holder.im2);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv2;
        private ImageView im2;

        public ViewHolder(View itemView) {
            super(itemView);
            tv2 = itemView.findViewById(R.id.tv4);
            im2 = itemView.findViewById(R.id.im4);
        }
    }
}
