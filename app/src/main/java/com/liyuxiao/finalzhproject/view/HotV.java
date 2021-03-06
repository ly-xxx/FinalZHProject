package com.liyuxiao.finalzhproject.view;

import com.liyuxiao.finalzhproject.base.BaseView;
import com.liyuxiao.finalzhproject.bean.Bean_ReMen;

public interface HotV extends BaseView {
    void OnSuccess(Bean_ReMen bean_reMen);

    void OnFaile(String msg);
}
