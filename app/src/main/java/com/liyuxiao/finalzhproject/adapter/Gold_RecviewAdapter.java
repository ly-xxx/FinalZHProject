package com.liyuxiao.finalzhproject.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.liyuxiao.finalzhproject.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.liyuxiao.finalzhproject.bean.Gold_all;

import java.util.ArrayList;

public class Gold_RecviewAdapter extends RecyclerView.Adapter<Gold_RecviewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Gold_all.ResultsBean> list;

    public Gold_RecviewAdapter(Context context, ArrayList<Gold_all.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Gold_RecviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.gold_recviewadapter,null);
         ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Gold_RecviewAdapter.ViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView im;
        private TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.goreim);
            tv = itemView.findViewById(R.id.goretv);
        }
    }
}
