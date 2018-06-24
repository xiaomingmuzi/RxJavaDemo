package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Describe: distinct ：去重操作符，就是简单的去重操作
 *
 * Author: Lixm
 * Date: 2018/6/23
 * Email: lxm20819@sina.com
 */
public class RxDistinctActivity extends RxOperatorBaseActivity {

    private String TAG=getClass().getName();


    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_distinct);
    }

    @Override
    protected void doSomething() {
        Observable.just(1,1,1,2,2,3,4,5)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        mRxOperatorsText.append("distinct："+integer+"\n");
                        LogUtil.i(TAG,"distinct："+integer+"\n");
                    }
                });
    }
}
