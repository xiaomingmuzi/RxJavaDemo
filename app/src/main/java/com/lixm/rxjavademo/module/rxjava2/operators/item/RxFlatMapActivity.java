package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Describe: FlatMap 操作符
 * <p>它可以把一个发射器Observable 通过某种方法转换为多个Observables，
 * 然后再把这些分散的Observables装进一个单一的发射器Observable。
 * 但有个需要注意的是，flatMap并不能保证事件的顺序，
 * 如果需要保证，需要用到我们下面要讲的ConcatMap
 * <p>
 * Author: Lixm
 * Date: 2018/6/22
 * Email: lxm20819@sina.com
 */
public class RxFlatMapActivity extends RxOperatorBaseActivity {

    private String TAG = getClass().getName();

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_flatMap);
    }

    @Override
    protected void doSomething() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                observableEmitter.onNext(1);
                observableEmitter.onNext(2);
                observableEmitter.onNext(3);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("I am value " + integer);
                }
                int delayTime = (int) (1 + Math.random() * 10);
                return Observable.fromIterable(list).delay(delayTime, TimeUnit.MICROSECONDS);
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        LogUtil.w(TAG, "flatMap: accept: " + s + "\n");
                        mRxOperatorsText.append("flatMap: accept: " + s + "\n");
                    }
                });
    }
}
