package com.liyuxiao.finalzhproject.net;

import com.liyuxiao.finalzhproject.bean.Bean_ReMen;
import com.liyuxiao.finalzhproject.bean.Bean_V2ex;
import com.liyuxiao.finalzhproject.bean.Bean_Wechat;
import com.liyuxiao.finalzhproject.bean.Bean_Zhihu;
import com.liyuxiao.finalzhproject.bean.Bean_ZhuanLan;
import com.liyuxiao.finalzhproject.bean.Gold_all;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyServse {
    public String url="http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<Bean_Zhihu> getzhihu();

    public String url2="http://news-at.zhihu.com/api/4/";
    @GET("sections")
    Observable<Bean_ZhuanLan> getzhaunlan();

    public String url3="http://news-at.zhihu.com/api/4/";
    @GET("news/hot")
    Observable<Bean_ReMen> getremen();

    public String url4="http://api.tianapi.com/wxnew/";
    @GET("?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<Bean_Wechat> getwechat();

    public String url5="http://gank.io/api/search/query/{搜索字段}/category/";
    @GET("{name}/count/10/page/1")
    Observable<Gold_all> getgold(@Path("name") String name);

    public String url6="https://www.wanandroid.com/";
    @GET("navi/json")
    Observable<Bean_V2ex> getv2ex();
}
