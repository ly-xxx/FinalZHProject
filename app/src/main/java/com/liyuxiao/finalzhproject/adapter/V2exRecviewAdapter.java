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
import com.liyuxiao.finalzhproject.bean.Bean_V2ItemBean;

import java.util.ArrayList;

public class V2exRecviewAdapter extends RecyclerView.Adapter<V2exRecviewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Bean_V2ItemBean> list;

    public void setList(ArrayList<Bean_V2ItemBean> list) {
        this.list = list;
    }

    public V2exRecviewAdapter(Context context, ArrayList<Bean_V2ItemBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.v2recviewadapter_item,null);
         ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.author.setText(list.get(position).getAvatar());
        holder.comment.setText(list.get(position).getCount());
        holder.sectab.setText(list.get(position).getTab());
        holder.timee.setText("最后回复"+list.get(position).getLastcomment());
        holder.title.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView im;
        private TextView author;
        private TextView timee;
        private TextView comment;
        private TextView sectab;
        private TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.immm);
            author = itemView.findViewById(R.id.author);
            timee = itemView.findViewById(R.id.timee);
            comment = itemView.findViewById(R.id.comment);
            sectab = itemView.findViewById(R.id.sectab);
            title = itemView.findViewById(R.id.title);
        }
    }
}
