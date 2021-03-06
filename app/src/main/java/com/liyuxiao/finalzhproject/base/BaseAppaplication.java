package com.liyuxiao.finalzhproject.base;

import android.app.Application;

public class BaseAppaplication extends Application {
    public static BaseAppaplication appaplication;

    @Override
    public void onCreate() {
        super.onCreate();
        appaplication=this;
    }

    public static BaseAppaplication getInstance() {
        return appaplication;
    }
}
