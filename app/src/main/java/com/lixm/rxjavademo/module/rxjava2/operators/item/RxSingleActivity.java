package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import java.util.Random;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.single.SingleObserveOn;

/**
 * Describe: Single 只接收一个参数，而SingleObservaser只会调用onError，或者是onSuccess
 *
 * Author: Lixm
 * Date: 2018/6/25
 * Email: lxm20819@sina.com
 */
public class RxSingleActivity extends RxOperatorBaseActivity {

   private String TAG=getClass().getName();

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_single);
    }

    @Override
    protected void doSomething() {
        Single.just(new Random().nextInt())
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        mRxOperatorsText.append("single ：onSuccess ："+integer+"\n");
                        LogUtil.i(TAG,"single ：onSuccess ："+integer+"\n");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        mRxOperatorsText.append("single: onError :"+ throwable.getMessage()+"\n");
                        LogUtil.i("single: onError :"+ throwable.getMessage()+"\n");
                    }
                });
    }
}
