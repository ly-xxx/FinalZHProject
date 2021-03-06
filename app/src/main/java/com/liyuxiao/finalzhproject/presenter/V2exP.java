package com.liyuxiao.finalzhproject.presenter;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BasePresenter;
import com.liyuxiao.finalzhproject.bean.Bean_V2ex;
import com.liyuxiao.finalzhproject.model.V2exM;
import com.liyuxiao.finalzhproject.view.V2exV;

public class V2exP extends BasePresenter<V2exM, V2exV> {
    public void getdata(){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<Bean_V2ex>() {
                @Override
                public void OnSuccess(Bean_V2ex bean_v2ex) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_v2ex);
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
