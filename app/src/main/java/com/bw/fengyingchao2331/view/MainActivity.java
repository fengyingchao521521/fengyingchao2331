package com.bw.fengyingchao2331.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.fengyingchao2331.R;
import com.bw.fengyingchao2331.base.BaseActivity;
import com.bw.fengyingchao2331.contract.IContract;
import com.bw.fengyingchao2331.model.bean.Bean;
import com.bw.fengyingchao2331.presenter.HomePresenter;
import com.bw.fengyingchao2331.view.adapter.MyAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<HomePresenter> implements IContract.IView {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void initData() {
        mPresenter.getHomData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }


    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Bean bean) {

        List<Bean.RankingBean> ranking = bean.getRanking();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //适配器
        MyAdapter myAdapter = new MyAdapter(ranking);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setOnitemClickListener(new MyAdapter.OnitemClickListener() {
            @Override
            public void OnitemClick(int postion) {
                Toast.makeText(MainActivity.this, "跳转成功"+bean.getRanking(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ScodeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFailure(Throwable throwable) {
        Toast.makeText(this, "跳转失败", Toast.LENGTH_SHORT).show();
    }
}
