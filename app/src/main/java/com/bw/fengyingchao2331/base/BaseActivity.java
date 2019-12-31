package com.bw.fengyingchao2331.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/*
 *@auther: 封英超
 *@Date: 2019/12/31
 *@Time:9:04
 *@Description:${DESCRIPTION}
 *
 */public abstract class BaseActivity<P extends BasePresenter>  extends AppCompatActivity {
     protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPresenter=providePresenter();
        if (mPresenter != null) {
            mPresenter.actach(this);
        }
        ButterKnife.bind(this);
        initView();
        initData();

    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P providePresenter();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.datach();
        }
    }
}
