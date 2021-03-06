package com.liyuxiao.finalzhproject.presenter;


import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BasePresenter;
import com.liyuxiao.finalzhproject.bean.Bean_Zhihu;
import com.liyuxiao.finalzhproject.model.InfoM;
import com.liyuxiao.finalzhproject.view.InfoV;

public class Infop extends BasePresenter<InfoM, InfoV> {
    public void getdata(){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<Bean_Zhihu>() {
                @Override
                public void OnSuccess(Bean_Zhihu bean_zhihu) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_zhihu);
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
