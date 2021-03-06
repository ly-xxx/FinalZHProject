package com.liyuxiao.finalzhproject.presenter;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BasePresenter;
import com.liyuxiao.finalzhproject.bean.Bean_V2ItemBean;
import com.liyuxiao.finalzhproject.model.V2exItemM;
import com.liyuxiao.finalzhproject.view.V2exItemV;

import java.util.ArrayList;

public class V2exItemP extends BasePresenter<V2exItemM, V2exItemV> {
    public void getdata(String href){
        if (Mymodel!=null){
            Mymodel.getData(href,new BaseCallback<ArrayList<Bean_V2ItemBean>>() {
                @Override
                public void OnSuccess(ArrayList<Bean_V2ItemBean> bean_v2ItemBeans) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_v2ItemBeans);
                    }
                }

                @Override
                public void OnFaile(String msg) {
                    if (Myview!=null){
                        Myview.OnFaile(msg);
                    }

                }
            });
        }
    }
}
