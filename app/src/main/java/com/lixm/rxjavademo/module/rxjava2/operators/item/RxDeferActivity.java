package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Describe: defer
 * 简单的说就是每次订阅都会创建一个新的Observable
 * 并且如果该Observable没有被订阅，就不会生成新的Observable
 * <p>
 * Author: Lixm
 * Date: 2018/6/25
 * Email: lxm20819@sina.com
 */
public class RxDeferActivity extends RxOperatorBaseActivity {

    private String TAG = getClass().getName();

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_defer);
    }

    @Override
    protected void doSomething() {
        Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(1, 2, 3);
            }
        });
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
                mRxOperatorsText.append("defer onNext : " + integer + "\n");
                LogUtil.w(TAG, "defer onNext : " + integer + "\n");
            }

            @Override
            public void onError(Throwable throwable) {
                mRxOperatorsText.append("defer onError : "+throwable.getMessage()+"\n");
                LogUtil.i(TAG,"defer onError : "+throwable.getMessage()+"\n");
            }

            @Override
            public void onComplete() {
                mRxOperatorsText.append("defer onComplete \n");
                LogUtil.i(TAG,"defer : onComplete \n");
            }
        });
    }
}
