package com.liyuxiao.finalzhproject.presenter;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BasePresenter;
import com.liyuxiao.finalzhproject.bean.Bean_v2Tab;
import com.liyuxiao.finalzhproject.model.Vx2TabM;
import com.liyuxiao.finalzhproject.view.V2exTabV;

import java.util.ArrayList;

public class V2exTabP extends BasePresenter<Vx2TabM, V2exTabV> {
    public void getdata(){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<ArrayList<Bean_v2Tab>>() {
                @Override
                public void OnSuccess(ArrayList<Bean_v2Tab> bean_v2Tab) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_v2Tab);
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
