package com.liyuxiao.finalzhproject.view;


import com.liyuxiao.finalzhproject.base.BaseView;
import com.liyuxiao.finalzhproject.bean.Gold_all;

public interface GoldV extends BaseView {
    void OnSuccess(Gold_all gold_all);

    void OnFaile(String msg);
}
