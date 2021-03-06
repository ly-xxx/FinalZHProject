package com.liyuxiao.finalzhproject.model;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BaseModel;
import com.liyuxiao.finalzhproject.bean.Bean_v2Tab;
import com.liyuxiao.finalzhproject.net.V2exServise;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class Vx2TabM extends BaseModel {
    public void getdata(final BaseCallback<ArrayList<Bean_v2Tab>> callback){
        new Thread(){
            @Override
            public void run() {
                super.run();
                 ArrayList<Bean_v2Tab> list = new ArrayList<>();
                try {
                     Document document = Jsoup.connect(V2exServise.baseurl).get();
                     Elements select = document.select("div#Tabs>a");
                    for (Element element :select) {
                         String href = element.attr("href");
                         String text = element.text();
                         Bean_v2Tab bean_v2Tab = new Bean_v2Tab(href, text);
                         list.add(bean_v2Tab);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (list!=null&&list.size()>0){
                    callback.OnSuccess(list);
                }else {
                    callback.OnFaile("失败");
                }
            }
        }.start();

    }
    private static void A() {
        try {
            Document document = Jsoup.connect("https://www.v2ex.com/").get();

            Element tabs = document.getElementById("Tabs");//<div>
            Elements aList = tabs.getElementsByTag("a");
            for (Element element : aList) {
                String href = element.attr("href");
                String text = element.text();

                System.out.println(href + ":" + text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
