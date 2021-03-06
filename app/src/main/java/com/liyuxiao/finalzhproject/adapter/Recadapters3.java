package com.liyuxiao.finalzhproject.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.liyuxiao.finalzhproject.bean.Bean_ZhuanLan;
import com.liyuxiao.finalzhproject.R;

import java.util.ArrayList;

public class Recadapters3 extends RecyclerView.Adapter<Recadapters3.ViewHolder> {
    private Context context;
    private ArrayList<Bean_ZhuanLan.DataBean> list;

    public Recadapters3(Context context, ArrayList<Bean_ZhuanLan.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Recadapters3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.frmeng2_review,null);
         ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recadapters3.ViewHolder holder, int position) {
        holder.tv1.setText(list.get(position).getDescription());
        holder.tv2.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getThumbnail()).placeholder(R.mipmap.ic_launcher).into(holder.im1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv1;
        private TextView tv2;
        private ImageView im1;

        public ViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            im1 = itemView.findViewById(R.id.im1);
        }
    }
}
