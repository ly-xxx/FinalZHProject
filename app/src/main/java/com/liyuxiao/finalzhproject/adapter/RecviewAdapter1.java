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
import com.liyuxiao.finalzhproject.bean.Bean_Zhihu;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RecviewAdapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Bean_Zhihu.StoriesBean> list1;
    private ArrayList<Bean_Zhihu.TopStoriesBean> list;

    public RecviewAdapter1(Context context, ArrayList<Bean_Zhihu.StoriesBean> list1, ArrayList<Bean_Zhihu.TopStoriesBean> list) {
        this.context = context;
        this.list1 = list1;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            View view=View.inflate(context,R.layout.recview_item1,null);
             ViewHolder1 holder1 = new ViewHolder1(view);
            return holder1;
        }if (viewType==1){
            View view=View.inflate(context,R.layout.recview_item3,null);
            ViewHolder2 holder2 = new ViewHolder2(view);
            return holder2;
        }else {
            View view=View.inflate(context,R.layout.recview_item2,null);
            ViewHolder3 holder3 = new ViewHolder3(view);
            return holder3;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         int viewType = getItemViewType(position);
        if (viewType==0){
             ViewHolder1 holder1= (ViewHolder1) holder;
            holder1.ba.setImages(list).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Bean_Zhihu.TopStoriesBean pa= (Bean_Zhihu.TopStoriesBean) path;
                    Glide.with(context).load(pa.getImage()).into(imageView);
                }
            }).start();
        }else if (viewType==1){
            ViewHolder2 holder2= (ViewHolder2) holder;
            holder2.tv1.setText("今日新闻");
        }else {
            ViewHolder3 holder3= (ViewHolder3) holder;
            holder3.tv.setText(list1.get(position).getTitle());
            Glide.with(context).load(list1.get(position).getImages().get(0)).placeholder(R.mipmap.ic_launcher).into(holder3.im);
        }
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else if (position==1){
            return 1;
        }else {
            return 2;
        }
    }

    class  ViewHolder1 extends RecyclerView.ViewHolder{

        private Banner ba;

        public ViewHolder1(View itemView) {
            super(itemView);
            ba = itemView.findViewById(R.id.ban);
        }
    }
    class  ViewHolder2 extends RecyclerView.ViewHolder{
        private TextView tv1;

        public ViewHolder2(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.itemtv);
        }
    }
    class  ViewHolder3 extends RecyclerView.ViewHolder{

        private ImageView im;
        private TextView tv;

        public ViewHolder3(View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.im);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
