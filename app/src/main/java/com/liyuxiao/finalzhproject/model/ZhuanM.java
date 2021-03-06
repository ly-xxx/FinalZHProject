package com.liyuxiao.finalzhproject.model;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BaseModel;
import com.liyuxiao.finalzhproject.bean.Bean_ZhuanLan;
import com.liyuxiao.finalzhproject.net.BaseObserver;
import com.liyuxiao.finalzhproject.net.HttpUtils;
import com.liyuxiao.finalzhproject.net.MyServse;
import com.liyuxiao.finalzhproject.net.RxUtil;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ZhuanM extends BaseModel {
    public void getdata(final BaseCallback<Bean_ZhuanLan> callback){
         MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url2, MyServse.class);
         Observable<Bean_ZhuanLan> getzhaunlan = apiServse.getzhaunlan();
        getzhaunlan.compose(RxUtil.<Bean_ZhuanLan>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Bean_ZhuanLan>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Bean_ZhuanLan bean_zhuanLan) {
                        callback.OnSuccess(bean_zhuanLan);

                    }
                });

    }
}
