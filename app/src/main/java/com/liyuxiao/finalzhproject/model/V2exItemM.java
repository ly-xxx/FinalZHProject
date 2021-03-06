package com.liyuxiao.finalzhproject.model;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BaseModel;
import com.liyuxiao.finalzhproject.bean.Bean_V2ItemBean;
import com.liyuxiao.finalzhproject.net.V2exServise;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;


public class V2exItemM extends BaseModel {
    public void getData(final String href, final BaseCallback<ArrayList<Bean_V2ItemBean>> baseCallBack) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                ArrayList<Bean_V2ItemBean> list = new ArrayList<>();
                try {
                    Document document = Jsoup.connect(V2exServise.baseurl + href).get();
                    Elements select = document.select("div.cell.item");
                    for (Element item: select) {
                         Bean_V2ItemBean bean_v2ItemBean = new Bean_V2ItemBean();
                        //图片路径
                        Elements images = item.select("table tr td a img.avatar");
                        if (images!=null&&images.size()>0){
                            String src = images.get(0).attr("src");
                            bean_v2ItemBean.setImage("https:"+src);
                        }

                        //点赞次数
                        Elements counts = item.select("table tr td a.count_livid");
                        if (counts!=null&&counts.size()>0){
                            String count = counts.get(0).text();
                            bean_v2ItemBean.setCount(count);
                        }

                        //标题
                        Elements titles = item.select("table tr td span.item_title>a");
                        if (titles!=null && titles.size()>0){
                            String title = titles.get(0).text();
                            bean_v2ItemBean.setTitle(title);
                        }

                        //获取二级tab
                        Elements tabs = item.select("table tr td span.topic_info a.node");
                        if (tabs.size()>0){
                            String text = tabs.get(0).text();
                            bean_v2ItemBean.setTab(text);
                        }

                        //获取作者和最后评论人
                        Elements strongs = item.select("table tr td span.topic_info>strong>a");
                        if (strongs.size()>0){
                            String author = strongs.get(0).text();
                            bean_v2ItemBean.setAvatar(author);
                        }

                        if (strongs.size()>1){
                            String lastcomment = strongs.get(1).text();
                            bean_v2ItemBean.setLastcomment(lastcomment);
                        }
                        list.add(bean_v2ItemBean);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (list!=null&&list.size()>0){
                    baseCallBack.OnSuccess(list);
                }else {
                    baseCallBack.OnFaile("失败");
                }
            }
        }.start();
    }
}
