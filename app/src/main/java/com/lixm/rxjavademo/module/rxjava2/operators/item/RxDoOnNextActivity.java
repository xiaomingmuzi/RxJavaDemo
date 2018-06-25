package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Describe: doOnNext
 * 让订阅者在接收到数据前干点事情的操作符
 *
 * Author: Lixm
 * Date: 2018/6/25
 * Email: lxm20819@sina.com
 */
public class RxDoOnNextActivity extends RxOperatorBaseActivity {

    private String TAG=getClass().getName();

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_doOnNext);
    }

    @Override
    protected void doSomething() {
        Observable.just(1,2,3,4)
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        mRxOperatorsText.append("doOnNext 保存："+integer+"成功\n");
                        LogUtil.w(TAG,"doOnNext 保存："+integer+"成功\n");
                    }
                });
    }
}
