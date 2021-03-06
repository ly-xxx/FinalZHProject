package com.liyuxiao.finalzhproject.view;

import com.liyuxiao.finalzhproject.base.BaseView;
import com.liyuxiao.finalzhproject.bean.Bean_v2Tab;

import java.util.ArrayList;

public interface V2exTabV extends BaseView {

    void OnFaile(String msg);

    void OnSuccess(ArrayList<Bean_v2Tab> bean_v2Tab);
}
