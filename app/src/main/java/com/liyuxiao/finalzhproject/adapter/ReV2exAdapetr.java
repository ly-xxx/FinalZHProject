package com.liyuxiao.finalzhproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.liyuxiao.finalzhproject.R;
import com.liyuxiao.finalzhproject.base.FlowLayout;
import com.liyuxiao.finalzhproject.bean.Bean_V2ex;

import java.util.ArrayList;

public class ReV2exAdapetr extends RecyclerView.Adapter<ReV2exAdapetr.ViewHolder> {
    private final LayoutInflater from;
    private Context context;
    private ArrayList<Bean_V2ex.DataBean> list;

    public void setList(ArrayList<Bean_V2ex.DataBean> list) {
        this.list = list;
    }

    public ReV2exAdapetr(Context context, ArrayList<Bean_V2ex.DataBean> list) {
        this.context = context;
        this.list = list;
        from = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ReV2exAdapetr.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=from.inflate(R.layout.rev2exadapter,null);
         ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReV2exAdapetr.ViewHolder holder, final int position) {
        final Bean_V2ex.DataBean dataBean = list.get(position);
        final ArrayList<Bean_V2ex.DataBean.ArticlesBean> articles = dataBean.getArticles();

            for (int i = 0; i <articles.size(); i++) {
                TextView textView = (TextView) from.inflate(R.layout.flow_text, null);
                textView.setText(articles.get(position).getTitle());
                holder.flow.setOnClickListener((View.OnClickListener) v -> Toast.makeText(context, articles.get(position).getTitle(), Toast.LENGTH_SHORT).show());
                holder.flow.addView(textView);
            }
            }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private FlowLayout flow;

        public ViewHolder(View itemView) {
            super(itemView);
            flow = itemView.findViewById(R.id.flow);
        }
    }
}
