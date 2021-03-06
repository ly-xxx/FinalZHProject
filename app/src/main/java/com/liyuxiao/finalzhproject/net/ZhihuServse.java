package com.liyuxiao.finalzhproject.net;

import com.liyuxiao.finalzhproject.bean.Bean_ReMen;
import com.liyuxiao.finalzhproject.bean.Bean_Zhihu;
import com.liyuxiao.finalzhproject.bean.Bean_ZhuanLan;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ZhihuServse {
    public String url="http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<Bean_Zhihu> getzhihu();

    public String url2="http://news-at.zhihu.com/api/4/";
    @GET("sections")
    Observable<Bean_ZhuanLan> getzhaunlan();

    public String url3="http://news-at.zhihu.com/api/4/";
    @GET("news/hot")
    Observable<Bean_ReMen> getremen();
}
