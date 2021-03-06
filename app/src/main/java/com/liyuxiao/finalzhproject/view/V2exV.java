package com.liyuxiao.finalzhproject.view;

import com.liyuxiao.finalzhproject.base.BaseView;
import com.liyuxiao.finalzhproject.bean.Bean_V2ex;

public interface V2exV extends BaseView {

    void OnSuccess(Bean_V2ex bean_v2ex);

    void OnFaile(String msg);
}

