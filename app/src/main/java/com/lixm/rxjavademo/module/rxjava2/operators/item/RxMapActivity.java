package com.lixm.rxjavademo.module.rxjava2.operators.item;

import com.lixm.rxjavademo.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @author Lixm
 * @date 2018/6/22 15:54
 * @detail
 */

public class RxMapActivity extends RxOperatorBaseActivity {
    private final String TAG = getClass().getName();

    @Override
    protected String getSubTitle() {
        return "map";
    }

    @Override
    protected void doSomething() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "This is result " + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                mRxOperatorsText.append("accept：" + s + "\n");
                LogUtil.w(TAG, "accept：" + s + "\n");
            }
        });
    }
}
