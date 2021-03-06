package com.liyuxiao.finalzhproject.base;

import java.util.ArrayList;

public abstract class BasePresenter<M extends BaseModel,V extends BaseView> {
    protected M Mymodel;
    protected V Myview;
    private ArrayList<BaseModel> list=new ArrayList<>();

    public void setMymodel(M mymodel) {
        this.Mymodel = mymodel;
        list.add(Mymodel);
    }

    public void setMyview(V myview) {
        this.Myview = myview;
    }
    public void destory(){
        for (BaseModel baseModel:list) {
            baseModel.destory();
        }
        if (Mymodel!=null){
            Mymodel=null;
        }
        if (Myview!=null){
            Myview=null;
        }
    }
}
