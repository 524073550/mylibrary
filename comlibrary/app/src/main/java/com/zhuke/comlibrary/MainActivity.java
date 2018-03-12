package com.zhuke.comlibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zhuke.comlibrary.base.BaseActivity;
import com.zhuke.comlibrary.utils.RXCountDownTimeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {


    @BindView(R.id.qqqq)
    TextView mQqqq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        RXCountDownTimeUtils.getIntescens().strtCountDown(mQqqq,60,this);
    }

    @Override
    protected View addContent(LayoutInflater layoutInflater, FrameLayout container) {
        return null;
    }

    @Override
    protected void initContent(View view) {

    }

    @Override
    protected void initTitle() {

    }

    // 处理网络状态结果
    @Override
    public void onNetChange(boolean netWorkState) {
        super.onNetChange(netWorkState);
//        textView.setText(netWorkState ? "有网络" : "无网络");
        showToast(netWorkState ? "有网络" : "无网络");
    }


    @OnClick(R.id.qqqq)
    public void onViewClicked() {
        showToast("aaa");
        RXCountDownTimeUtils.getIntescens().strtCountDown(mQqqq,60,this);
    }
}
