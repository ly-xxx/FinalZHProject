package com.liyuxiao.finalzhproject.view;

import com.liyuxiao.finalzhproject.base.BaseView;
import com.liyuxiao.finalzhproject.bean.Bean_ZhuanLan;

public interface ZhuanV extends BaseView {
    void OnSuccess(Bean_ZhuanLan bean_zhuanLan);

    void OnFaile(String msg);
}
