package com.liyuxiao.finalzhproject.bean;

public class Bean_V2ItemBean {
    private String image;
    private String title;
    private String count;
    private String avatar;
    private String tab;
    private String lastcomment;

    public Bean_V2ItemBean() {
        this.image = image;
        this.title = title;
        this.count = count;
        this.avatar = avatar;
        this.tab = tab;
        this.lastcomment = lastcomment;
    }

    @Override
    public String toString() {
        return "Bean_V2ItemBean{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", count='" + count + '\'' +
                ", avatar='" + avatar + '\'' +
                ", tab='" + tab + '\'' +
                ", lastcomment='" + lastcomment + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getLastcomment() {
        return lastcomment;
    }

    public void setLastcomment(String lastcomment) {
        this.lastcomment = lastcomment;
    }
}
