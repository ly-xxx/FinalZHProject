package com.liyuxiao.finalzhproject.util;

import android.widget.Toast;

import com.liyuxiao.finalzhproject.base.BaseAppaplication;

public class ToastUtil {
    public static void showShort(String msg){
        Toast.makeText(BaseAppaplication.getInstance(),msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg){
        Toast.makeText(BaseAppaplication.getInstance(),msg,Toast.LENGTH_LONG).show();
    }
}
