package com.liyuxiao.finalzhproject.model;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BaseModel;
import com.liyuxiao.finalzhproject.bean.Bean_Wechat;
import com.liyuxiao.finalzhproject.net.BaseObserver;
import com.liyuxiao.finalzhproject.net.HttpUtils;
import com.liyuxiao.finalzhproject.net.MyServse;
import com.liyuxiao.finalzhproject.net.RxUtil;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class WechatM extends BaseModel {
    public void getdata(final BaseCallback<Bean_Wechat> callback){
        final MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url4, MyServse.class);
        final Observable<Bean_Wechat> getwechat = apiServse.getwechat();
        getwechat.compose(RxUtil.<Bean_Wechat>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Bean_Wechat>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Bean_Wechat bean_wechat) {
                        callback.OnSuccess(bean_wechat);

                    }
                });

    }
}
