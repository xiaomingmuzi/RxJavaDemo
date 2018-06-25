package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Describe: just 一个简单的发射器，依次调用onNext方法
 *
 * Author: Lixm
 * Date: 2018/6/25
 * Email: lxm20819@sina.com
 */
public class RxJustActivity extends RxOperatorBaseActivity {

   private String TAG=getClass().getName();

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_just);
    }

    @Override
    protected void doSomething() {
        Observable.just(1,2,3,4,5,6)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        mRxOperatorsText.append("just accept："+integer+"\n");
                        LogUtil.i(TAG,"just accept："+integer+"\n");
                    }
                });

    }
}
