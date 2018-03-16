package com.zhuke.comlibrary;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.zhuke.comlibrary.base.BaseActivity;
import com.zhuke.comlibrary.bean.A;
import com.zhuke.comlibrary.bean.HttpResult;
import com.zhuke.comlibrary.bean.LoginBean;
import com.zhuke.comlibrary.bean.UserEntity;
import com.zhuke.comlibrary.http.RetrofitManage;
import com.zhuke.comlibrary.http.Subscriber.BaseDataSubscriber;
import com.zhuke.comlibrary.http.Interceptor.Transformer;
import com.zhuke.comlibrary.http.Subscriber.CommonObserver;
import com.zhuke.comlibrary.http.Subscriber.ProgressSubscriber;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;


public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RXCountDownTimeUtils.getIntescens().strtCountDown(mQqqq, 60, this);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("加载中....");
        RetrofitManage.getInstance().getService().setPass(new HashMap<String, Object>())
                .compose(Transformer.<UserEntity>switchSchedulers(progressDialog))
                .subscribe(new CommonObserver<UserEntity>(progressDialog) {
                    @Override
                    protected void onError(String errorMsg) {

                    }

                    @Override
                    protected void onSuccess(UserEntity userEntity) {

                    }
                });
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


    public void onViewClicked() {
        showToast("aaa");
//        RXCountDownTimeUtils.getIntescens().strtCountDown(mQqqq, 60, this);
    }

}
