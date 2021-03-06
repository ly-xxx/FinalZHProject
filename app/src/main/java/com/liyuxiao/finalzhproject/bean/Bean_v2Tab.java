package com.liyuxiao.finalzhproject.bean;

public class Bean_v2Tab {
    private String href;
    private String title;

    public Bean_v2Tab(String href, String title) {
        this.href = href;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Bean_v2Tab{" +
                "href='" + href + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
