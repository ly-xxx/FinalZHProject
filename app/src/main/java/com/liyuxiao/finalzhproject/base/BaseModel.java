package com.liyuxiao.finalzhproject.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseModel {
    protected CompositeDisposable compositeDisposable=new CompositeDisposable();
    public void destory(){
        compositeDisposable.clear();
    }
}
