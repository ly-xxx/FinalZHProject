package com.liyuxiao.finalzhproject.model;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BaseModel;
import com.liyuxiao.finalzhproject.bean.Bean_ReMen;
import com.liyuxiao.finalzhproject.net.BaseObserver;
import com.liyuxiao.finalzhproject.net.HttpUtils;
import com.liyuxiao.finalzhproject.net.MyServse;
import com.liyuxiao.finalzhproject.net.RxUtil;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class HotM extends BaseModel {
    public void  getdata(final BaseCallback<Bean_ReMen> callback){
        final MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url3, MyServse.class);
        final Observable<Bean_ReMen> getremen = apiServse.getremen();
        getremen.compose(RxUtil.<Bean_ReMen>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Bean_ReMen>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Bean_ReMen bean_reMen) {
                        callback.OnSuccess(bean_reMen);

                    }
                });

    }
}
