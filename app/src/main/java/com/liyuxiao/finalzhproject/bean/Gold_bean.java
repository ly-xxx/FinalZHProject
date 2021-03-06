package com.liyuxiao.finalzhproject.bean;

import java.io.Serializable;

public class Gold_bean implements Serializable {
    private String name;
    private boolean isSelected;

    public Gold_bean(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }

    public String getName() {

        return name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return "Gold_bean{" +
                "name='" + name + '\'' +
                ", isSelected=" + isSelected +
                '}';
    }
}
