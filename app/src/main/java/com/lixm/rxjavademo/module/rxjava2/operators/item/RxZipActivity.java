package com.lixm.rxjavademo.module.rxjava2.operators.item;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * Describe: zip
 * <p>
 * 合并事件专用
 * 分别从两个上游事件中各取出一个组合
 * 一个事件只能被使用一次，顺序严格按照事件发送的顺序
 * 最终下游事件收到的是和上游时间最少的数目相同（必须两两配对，多余的舍弃）
 * <p>
 * Author: Lixm
 * Date: 2018/6/22
 */
public class RxZipActivity extends RxOperatorBaseActivity {

    private String TAG = getClass().getName();

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_zip);
    }

    @Override
    protected void doSomething() {
        Observable.zip(getStringObervable(), getIntegerObervable(), new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer integer) throws Exception {
                return s + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                mRxOperatorsText.append("zip : accept :" + s + "\n");
                LogUtil.i(TAG, "zip : accept : " + s + "\n");
            }
        });
    }

    private Observable<String> getStringObervable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext("A");
                    mRxOperatorsText.append("String emit ：A \n");
                    LogUtil.w(TAG, "String emit ：A \n");

                    e.onNext("B");
                    mRxOperatorsText.append("String emit : B \n");
                    LogUtil.w(TAG, "String emit : B \n");

                    e.onNext("C");
                    mRxOperatorsText.append("String emit : C \n");
                    LogUtil.w(TAG, "String emit : C \n");

                }
            }
        });
    }

    private Observable<Integer> getIntegerObervable() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(1);
                    mRxOperatorsText.append("Integer emit : 1 \n");
                    LogUtil.i(TAG, "Integer emit : 1 \n");

                    e.onNext(2);
                    mRxOperatorsText.append("Integer emit : 2 \n");
                    LogUtil.i(TAG, "Integer emit : 2 \n");

                    e.onNext(3);
                    mRxOperatorsText.append("Integer emit : 3 \n");
                    LogUtil.i(TAG, "Integer emit : 3 \n");

                    e.onNext(4);
                    mRxOperatorsText.append("Integer emit : 4 \n");
                    LogUtil.i(TAG, "Integer emit : 4 \n");

                    e.onNext(5);
                    mRxOperatorsText.append("Integer emit : 5 \n");
                    LogUtil.i(TAG, "Integer emit : 5 \n");

                    e.onNext(6);
                    mRxOperatorsText.append("Integer emit : 6 \n");
                    LogUtil.i(TAG, "Integer emit : 6 \n");
                }
            }
        });
    }
}
