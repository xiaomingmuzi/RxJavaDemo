package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;
import com.lixm.rxjavademo.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Describe: timer
 * 在Rxjava中timer 操作符既可以延迟执行一段逻辑，也可以间隔执行一段逻辑
 * 【注意】在Rxjava 2.x 已经过时了，现在用interval操作符来间隔执行，详见RxIntervalActivity
 * timer和interval都默认执行在一个新的线程上
 *
 * Author: Lixm
 * Date: 2018/6/23
 * Email: lxm20819@sina.com
 */
public class RxTimerActivity extends RxOperatorBaseActivity {

    private String TAG=getClass().getName();

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_timer);
    }

    @Override
    protected void doSomething() {
        mRxOperatorsText.append("timer start："+ TimeUtil.getNowStrTime()+"\n");
        LogUtil.w(TAG,"timer start："+ TimeUtil.getNowStrTime());
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        LogUtil.i(TAG,"当前线程："+Thread.currentThread().getName());
                        mRxOperatorsText.append("timer : "+aLong+" at "+TimeUtil.getNowStrTime()+"\n");
                        LogUtil.w(TAG,"timer : "+aLong+" at "+TimeUtil.getNowStrTime()+"\n");
                    }
                });
    }
}
