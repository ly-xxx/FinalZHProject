package com.liyuxiao.finalzhproject.app;

import android.os.Environment;

import com.liyuxiao.finalzhproject.base.BaseAppaplication;

import java.io.File;

public interface AppConstants {

    int Type_Zhihu=0;
    int Type_Wechat=1;
    int Type_Gank=2;
    int Type_Gold=3;
    int Type_Vtex=4;
    int Type_Collect=5;
    int Type_Setting=6;
    int Type_About=7;

    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "code" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY="com.baidu.geek.fileprovider";

    //网络缓存的地址

    String PATH_CACHE = BaseAppaplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "/NetCache";
}
