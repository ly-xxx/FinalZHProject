package com.liyuxiao.finalzhproject.base;

public interface BaseCallback<T> {
    void OnSuccess(T t);
    void OnFaile(String msg);
}
