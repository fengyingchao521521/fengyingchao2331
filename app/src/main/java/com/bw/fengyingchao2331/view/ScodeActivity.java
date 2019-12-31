package com.bw.fengyingchao2331.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.request.RequestOptions;
import com.bw.fengyingchao2331.R;
import com.bw.fengyingchao2331.model.JavaBean;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScodeActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.butt01)
    Button butt01;
    @BindView(R.id.butt02)
    Button butt02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scode);
        ButterKnife.bind(this);
        CodeUtils.init(this);

    }

    @OnClick({R.id.text, R.id.butt01, R.id.butt02})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text:
                //点击
                String string = text.getText().toString();
                if (!TextUtils.isEmpty(string)){
//                    Bitmap ima = CodeUtils.createImage(text, 400, 400,,null);

                }

                break;
            case R.id.butt01:
                EventBus.getDefault().post("微信");

                break;
            case R.id.butt02:
                EventBus.getDefault().post("qq好友,28");
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onStringBean(JavaBean javaBean){
        Toast.makeText(this, "微信朋友", Toast.LENGTH_SHORT).show();
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onString(String string){

        Toast.makeText(this, "qq朋友", Toast.LENGTH_SHORT).show();
    }



}
