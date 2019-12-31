package com.bw.fengyingchao2331.presenter;


import com.bw.fengyingchao2331.base.BasePresenter;
import com.bw.fengyingchao2331.contract.IContract;
import com.bw.fengyingchao2331.model.HomeModel;
import com.bw.fengyingchao2331.model.bean.Bean;

/*
 *@auther: 封英超
 *@Date: 2019/12/31
 *@Time:9:13
 *@Description:${DESCRIPTION}
 *
 */public class HomePresenter extends BasePresenter<IContract.IView> implements IContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHomData() {
        homeModel.getHomData(new IContract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(Bean bean) {
                view.onSuccess(bean);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }
}
