package com.bw.fengyingchao2331.contract;

import com.bw.fengyingchao2331.model.bean.Bean;

/*
 *@auther: 封英超
 *@Date: 2019/12/31
 *@Time:9:13
 *@Description:${DESCRIPTION}
 *
 */public interface IContract {
    interface IView {
        //学生
        void onSuccess(Bean bean);

        void onFailure(Throwable throwable);

    }

    interface IPresenter {
        //学生
        void getHomData();
    }

    interface IModel {
        void getHomData(IModelCallBack iModelCallBack);

        interface IModelCallBack {
            //学生
            void onSuccess(Bean bean);

            void onFailure(Throwable throwable);

        }

    }


}
