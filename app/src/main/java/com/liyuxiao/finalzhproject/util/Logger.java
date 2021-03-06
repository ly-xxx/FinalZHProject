package com.liyuxiao.finalzhproject.util;


import android.util.Log;

import com.liyuxiao.finalzhproject.BuildConfig;

public class Logger {

    public static void logD(String tag,String msg){
        if (BuildConfig.DEBUG){
            Log.d(tag, "logD: "+msg);
        }
    }
}
