package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;
import com.lixm.rxjavademo.utils.TimeUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Describe: interval 操作符
 * 间隔执行操作，默认在新线程
 *
 * Author: Lixm
 * Date: 2018/6/25
 * Email: lxm20819@sina.com
 */
public class RxIntervalActivity extends RxOperatorBaseActivity {
    private String TAG=getClass().getName();
    private Disposable mDisposable;

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_interval);
    }

    @Override
    protected void doSomething() {
        mRxOperatorsText.append("interval start :"+ TimeUtil.getNowStrTime()+"\n");
        LogUtil.w(TAG,"interval start :"+ TimeUtil.getNowStrTime()+"\n");
        mDisposable= Observable.interval(3,5, TimeUnit.SECONDS).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        mRxOperatorsText.append("interval : "+aLong+" at "+TimeUtil.getNowStrTime()+"\n");
                        LogUtil.i(TAG,"interval : "+aLong+" at "+TimeUtil.getNowStrTime()+"\n");
                    }

                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (mDisposable!=null && !mDisposable.isDisposed())
//            mDisposable.dispose();
    }
}
