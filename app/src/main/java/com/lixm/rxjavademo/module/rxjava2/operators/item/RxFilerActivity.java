package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * Describe: Filter：过滤器操作符，过去掉不符合我们条件的值
 *
 * Author: Lixm
 * Date: 2018/6/23
 * Email: lxm20819@sina.com
 */
public class RxFilerActivity extends RxOperatorBaseActivity {

   private String TAG=getClass().getName();

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_filter);
    }

    @Override
    protected void doSomething() {
        Observable.just(1,20,65,-5,7,19)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer>=10;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                mRxOperatorsText.append("filter : "+integer+"\n");
                LogUtil.i(TAG,"filter : "+integer+"\n");
            }
        });
    }
}
