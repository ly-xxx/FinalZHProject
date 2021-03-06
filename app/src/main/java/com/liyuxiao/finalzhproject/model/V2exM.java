package com.liyuxiao.finalzhproject.model;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BaseModel;
import com.liyuxiao.finalzhproject.bean.Bean_V2ex;
import com.liyuxiao.finalzhproject.net.BaseObserver;
import com.liyuxiao.finalzhproject.net.HttpUtils;
import com.liyuxiao.finalzhproject.net.MyServse;
import com.liyuxiao.finalzhproject.net.RxUtil;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class V2exM extends BaseModel {
    public void getdata(final BaseCallback<Bean_V2ex> callback){
         MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url6, MyServse.class);
         Observable<Bean_V2ex> bean_v2exObservable = apiServse.getv2ex();
        bean_v2exObservable.compose(RxUtil.<Bean_V2ex>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Bean_V2ex>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Bean_V2ex bean_v2ex) {
                        callback.OnSuccess(bean_v2ex);
                    }
                });
    }
}
