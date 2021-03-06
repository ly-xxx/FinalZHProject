package com.liyuxiao.finalzhproject.view;


import com.liyuxiao.finalzhproject.base.BaseView;
import com.liyuxiao.finalzhproject.bean.Bean_Zhihu;

public interface InfoV extends BaseView {
    void OnSuccess(Bean_Zhihu bean_zhihu);

    void OnFaile(String msg);
}
