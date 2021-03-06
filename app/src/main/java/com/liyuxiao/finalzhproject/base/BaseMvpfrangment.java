package com.liyuxiao.finalzhproject.base;

public abstract class BaseMvpfrangment<M extends BaseModel,V extends BaseView,P extends BasePresenter> extends BaseFrangment{
    protected P Mypresenter;
    @Override
    protected void initMvp() {
        super.initMvp();
        Mypresenter=initpresenter();
        if (Mypresenter!=null){
            Mypresenter.setMymodel(initmodel());
            Mypresenter.setMyview(initview());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (Mypresenter!=null){
            Mypresenter.destory();
            Mypresenter=null;
        }
    }

    protected abstract V initview();

    protected abstract M initmodel();

    protected abstract P initpresenter();
}
