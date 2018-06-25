package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Describe: skip 接受一个long型参数，代表跳过多少个数目的事件，在开始接收
 *
 * Author: Lixm
 * Date: 2018/6/25
 * Email: lxm20819@sina.com
 */
public class RxSkipActivity extends RxOperatorBaseActivity {

   private String TAG=getClass().getName();

    @Override
    protected String getSubTitle() {
        return getResources().getString(R.string.rx_skip);
    }

    @Override
    protected void doSomething() {
        Observable.just("1","2","3","4","5")
                .skip(2)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        mRxOperatorsText.append("当前内容是："+s+"\n");
                        LogUtil.w(TAG,"当前内容是："+s+"\n");
                    }
                });
    }
}
