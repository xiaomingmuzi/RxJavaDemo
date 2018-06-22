package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Describe: Concat字符
 *
 * Author: Lixm
 * Date: 2018/6/22
 * Email: lxm20819@sina.com
 */
public class RxConcatActivity extends RxOperatorBaseActivity {

    private String TAG=getClass().getName();

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_concat);
    }

    @Override
    protected void doSomething() {
        Observable.concat(Observable.just(1,2,3),Observable.just(4,5,6))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        mRxOperatorsText.append("concat : "+integer+"\n");
                        LogUtil.i(TAG,"concat : "+integer+"\n");
                    }
                });
    }
}
