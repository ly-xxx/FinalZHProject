package com.liyuxiao.finalzhproject.presenter;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BasePresenter;
import com.liyuxiao.finalzhproject.bean.Bean_ReMen;
import com.liyuxiao.finalzhproject.model.HotM;
import com.liyuxiao.finalzhproject.view.HotV;

public class HotP extends BasePresenter<HotM, HotV> {
    public void getdata(){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<Bean_ReMen>() {
                @Override
                public void OnSuccess(Bean_ReMen bean_reMen) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_reMen);
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
