package com.liyuxiao.finalzhproject.bean;

import java.util.ArrayList;

public class Bean_ReMen {

    private ArrayList<RecentBean> recent;

    public ArrayList<RecentBean> getRecent() {
        return recent;
    }

    public void setRecent(ArrayList<RecentBean> recent) {
        this.recent = recent;
    }

    public static class RecentBean {
        /**
         * news_id : 9710856
         * url : http://news-at.zhihu.com/api/2/news/9710856
         * thumbnail : https://pic1.zhimg.com/v2-ada02f83e400d93e92caba32fe86e184.jpg
         * title : 瞎扯 · 如何正确地吐槽
         */

        private int news_id;
        private String url;
        private String thumbnail;
        private String title;

        public int getNews_id() {
            return news_id;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
