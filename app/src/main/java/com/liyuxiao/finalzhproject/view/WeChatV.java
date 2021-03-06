package com.liyuxiao.finalzhproject.view;

import com.liyuxiao.finalzhproject.base.BaseView;
import com.liyuxiao.finalzhproject.bean.Bean_Wechat;

public interface WeChatV extends BaseView {
    void OnSuccess(Bean_Wechat bean_wechat);

    void OnFaile(String msg);
}
