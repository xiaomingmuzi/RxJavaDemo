package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Describe: debounce 去除发送频率过快的项
 *
 * Author: Lixm
 * Date: 2018/6/25
 * Email: lxm20819@sina.com
 */
public class RxDebounceActivity extends RxOperatorBaseActivity {


    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_debounce);
    }

    @Override
    protected void doSomething() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                //send events with simulated time wait
                observableEmitter.onNext(1);//skip
                Thread.sleep(400);
                observableEmitter.onNext(2);//deliver
                Thread.sleep(505);
                observableEmitter.onNext(3);//skip
                Thread.sleep(100);
                observableEmitter.onNext(4);//deliver
                Thread.sleep(605);
                observableEmitter.onNext(5);//deliver
                Thread.sleep(510);
                observableEmitter.onComplete();
            }
        })
        .debounce(500, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                mRxOperatorsText.append("debounce accept ："+integer+"\n");
                LogUtil.w("debounce accept ："+integer+"\n");
            }
        })
        ;
    }
}
