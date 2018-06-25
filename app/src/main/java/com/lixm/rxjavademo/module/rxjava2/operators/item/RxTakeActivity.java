package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Describe: take 接收一个long类型count，代表至多接收count个数据
 *
 * Author: Lixm
 * Date: 2018/6/25
 * Email: lxm20819@sina.com
 */
public class RxTakeActivity extends RxOperatorBaseActivity {

   private String TAG=getClass().getName();

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_take);
    }

    @Override
    protected void doSomething() {
        Observable.just(1,2,3,4,5)
                .take(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        mRxOperatorsText.append("接收到的内容为："+integer+"\n");
                        LogUtil.i(TAG,"接收到的内容为："+integer+"\n");
                    }
                });
    }
}
