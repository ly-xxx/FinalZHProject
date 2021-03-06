package com.liyuxiao.finalzhproject.bean;

import java.util.ArrayList;

public class Bean_Zhihu {


    /**
     * date : 20190506
     * stories : [{"title":"乒乓球是职业和业余选手差距最小的运动？正好相反","ga_prefix":"050609","images":["https://pic4.zhimg.com/v2-09a6ebc1ea68c2a123fb3f07df8021c7.jpg"],"multipic":true,"type":0,"id":9710929},{"title":"猫能听得懂人话吗？","ga_prefix":"050607","images":["https://pic1.zhimg.com/v2-8e24df6aaf5ab12e09bb28ddf102d6c0.jpg"],"multipic":true,"type":0,"id":9710936},{"images":["https://pic4.zhimg.com/v2-71385d505e788a1d2c02e85a705e2e03.jpg"],"type":0,"id":9710887,"ga_prefix":"050606","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic3.zhimg.com/v2-4963697724c924497665e36d8ad45d6a.jpg","type":0,"id":9710936,"ga_prefix":"050607","title":"猫能听得懂人话吗？"},{"image":"https://pic4.zhimg.com/v2-407a2643d61bc0f4e8f40b22cdea102b.jpg","type":0,"id":9710906,"ga_prefix":"050517","title":"地铁防火，各国是怎么做的？"},{"image":"https://pic2.zhimg.com/v2-ecb20c945f638a7fd783900219e6ed15.jpg","type":0,"id":9465349,"ga_prefix":"050309","title":"对情欲没有了想象力，多么悲哀的一件事"},{"image":"https://pic4.zhimg.com/v2-7555e56f4ae4be4e7916a3f578f3c20b.jpg","type":0,"id":9710753,"ga_prefix":"050107","title":"为什么很多人讨厌剧透？"},{"image":"https://pic4.zhimg.com/v2-66e3354dec06315d47299d0bf6a8ff7f.jpg","type":0,"id":9710786,"ga_prefix":"043008","title":"迄今为止你见过最惊艳的建筑是哪个？"}]
     */

    private String date;
    private ArrayList<StoriesBean> stories;
    private ArrayList<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(ArrayList<StoriesBean> stories) {
        this.stories = stories;
    }

    public ArrayList<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(ArrayList<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * title : 乒乓球是职业和业余选手差距最小的运动？正好相反
         * ga_prefix : 050609
         * images : ["https://pic4.zhimg.com/v2-09a6ebc1ea68c2a123fb3f07df8021c7.jpg"]
         * multipic : true
         * type : 0
         * id : 9710929
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private ArrayList<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public ArrayList<String> getImages() {
            return images;
        }

        public void setImages(ArrayList<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic3.zhimg.com/v2-4963697724c924497665e36d8ad45d6a.jpg
         * type : 0
         * id : 9710936
         * ga_prefix : 050607
         * title : 猫能听得懂人话吗？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
