package com.bw.fengyingchao2331.model;


import com.bw.fengyingchao2331.contract.IContract;
import com.bw.fengyingchao2331.model.bean.Bean;
import com.bw.fengyingchao2331.util.NetUtil;
import com.google.gson.Gson;

/*
 *@auther: 封英超
 *@Date: 2019/12/31
 *@Time:9:13
 *@Description:${DESCRIPTION}
 *
 */public class HomeModel implements IContract.IModel {
    @Override
    public void getHomData(IModelCallBack iModelCallBack) {
        String httpurl = "http://blog.zhaoliang5156.cn/api/news/ranking.json";

        NetUtil.getInstance().onjsonGet(httpurl, new NetUtil.MyCallback() {
            @Override
            public void ongetjson(String json) {
                Bean bean = new Gson().fromJson(json, Bean.class);
                iModelCallBack.onSuccess(bean);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallBack.onFailure(throwable);
            }
        });
    }
}
