package com.liyuxiao.finalzhproject.net;

import android.util.Log;
import android.widget.Toast;

import com.liyuxiao.finalzhproject.util.ToastUtil;

import io.reactivex.Observer;

/**
 * Created by $lzj on 2019/5/6.
 */
public abstract class BaseObserver<T> implements Observer<T> {

    private final String TAG = getClass().getName();

    @Override
    public void onComplete() {
        Log.e(TAG,"onComplete");
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG,"onError:" + e.getMessage());
    }
}
