package com.liyuxiao.finalzhproject.presenter;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BasePresenter;
import com.liyuxiao.finalzhproject.bean.Gold_all;
import com.liyuxiao.finalzhproject.model.GoldM;
import com.liyuxiao.finalzhproject.view.GoldV;

public class GoldP extends BasePresenter<GoldM, GoldV> {
    public void getdata(String name){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<Gold_all>() {
                @Override
                public void OnSuccess(Gold_all gold_all) {
                    if (Myview!=null){
                        Myview.OnSuccess(gold_all);
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
