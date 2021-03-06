package com.liyuxiao.finalzhproject.presenter;
import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BasePresenter;
import com.liyuxiao.finalzhproject.bean.Bean_Wechat;
import com.liyuxiao.finalzhproject.model.WechatM;
import com.liyuxiao.finalzhproject.view.WeChatV;

public class WeChatP extends BasePresenter<WechatM, WeChatV> {
    public void getdata(){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<Bean_Wechat>() {
                @Override
                public void OnSuccess(Bean_Wechat bean_wechat) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_wechat);
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
