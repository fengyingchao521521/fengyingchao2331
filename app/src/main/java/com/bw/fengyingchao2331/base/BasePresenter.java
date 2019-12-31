package com.bw.fengyingchao2331.base;

/*
 *@auther: 封英超
 *@Date: 2019/12/31
 *@Time:9:04
 *@Description:${DESCRIPTION}
 *
 */public abstract class BasePresenter<V> {
    protected V view;

    public void actach(V view) {
        this.view = view;
    }

    public void datach() {
        view=null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
