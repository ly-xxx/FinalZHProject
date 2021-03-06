package com.liyuxiao.finalzhproject.presenter;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BasePresenter;
import com.liyuxiao.finalzhproject.bean.Bean_ZhuanLan;
import com.liyuxiao.finalzhproject.model.ZhuanM;
import com.liyuxiao.finalzhproject.view.ZhuanV;

public class ZhuanP extends BasePresenter<ZhuanM, ZhuanV> {
    public void getdata(){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<Bean_ZhuanLan>() {
                @Override
                public void OnSuccess(Bean_ZhuanLan bean_zhuanLan) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_zhuanLan);
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
