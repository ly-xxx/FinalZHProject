package com.liyuxiao.finalzhproject.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

public abstract class BaseFrangment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View inflate = inflater.inflate(getlayoutId(), null);
        ButterKnife.bind(this,inflate);
        initMvp();
        initView();
        initData();
        initListener();
        return inflate;
    }
    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView() {

    }

    protected void initMvp() {
    }

    protected abstract int getlayoutId();

}
