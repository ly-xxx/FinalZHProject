package com.liyuxiao.finalzhproject.model;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BaseModel;
import com.liyuxiao.finalzhproject.bean.Bean_Zhihu;
import com.liyuxiao.finalzhproject.net.BaseObserver;
import com.liyuxiao.finalzhproject.net.HttpUtils;
import com.liyuxiao.finalzhproject.net.MyServse;
import com.liyuxiao.finalzhproject.net.RxUtil;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class InfoM extends BaseModel {
    public void getdata(final BaseCallback<Bean_Zhihu> callback){
         MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url, MyServse.class);
         Observable<Bean_Zhihu> getzhihu = apiServse.getzhihu();
        getzhihu.compose(RxUtil.<Bean_Zhihu>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Bean_Zhihu>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Bean_Zhihu bean_zhihu) {
                        callback.OnSuccess(bean_zhihu);

                    }
                });

    }
}
