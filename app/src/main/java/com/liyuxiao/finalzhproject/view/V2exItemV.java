package com.liyuxiao.finalzhproject.view;

import com.liyuxiao.finalzhproject.base.BaseView;
import com.liyuxiao.finalzhproject.bean.Bean_V2ItemBean;

import java.util.ArrayList;

public interface V2exItemV extends BaseView {

    void OnSuccess(ArrayList<Bean_V2ItemBean> bean_v2ItemBeans);

    void OnFaile(String msg);
}
