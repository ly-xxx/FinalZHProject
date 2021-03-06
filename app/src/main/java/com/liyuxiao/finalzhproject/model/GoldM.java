package com.liyuxiao.finalzhproject.model;

import com.liyuxiao.finalzhproject.base.BaseCallback;
import com.liyuxiao.finalzhproject.base.BaseModel;
import com.liyuxiao.finalzhproject.bean.Gold_all;
import com.liyuxiao.finalzhproject.net.MyServse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GoldM extends BaseModel {
    public void  getdata(final BaseCallback<Gold_all> baseCallback){
         Retrofit retrofit = new Retrofit.Builder().baseUrl(MyServse.url5)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
         MyServse myServse = retrofit.create(MyServse.class);
         Observable<Gold_all> name = myServse.getgold("name");
         name.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<Gold_all>() {
                     @Override
                     public void onSubscribe(Disposable d) {
                         compositeDisposable.add(d);
                     }

                     @Override
                     public void onNext(Gold_all gold_all) {
                         baseCallback.OnSuccess(gold_all);

                     }

                     @Override
                     public void onError(Throwable e) {
                        baseCallback.OnFaile(e.getMessage());

                     }

                     @Override
                     public void onComplete() {

                     }
                 });
    }
}
