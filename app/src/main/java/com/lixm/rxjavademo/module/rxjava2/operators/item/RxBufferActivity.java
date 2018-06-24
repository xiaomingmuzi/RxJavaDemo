package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Describe: buffer
 * buffer(count,skip) 从定义就差不多能看出作用了，
 * 将obervable中的数据按 skip 步长分成最长不超过 count 的buffer，然后生成一个observable
 *
 * Author: Lixm
 * Date: 2018/6/23
 * Email: lxm20819@sina.com
 */
public class RxBufferActivity extends RxOperatorBaseActivity {

    private String TAG=getClass().getName();

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_buffer);
    }

    @Override
    protected void doSomething() {
        Observable.just(1,2,3,4,5)
                .buffer(3,2)
        .subscribe(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) throws Exception {
                mRxOperatorsText.append("buffer size："+integers.size()+"\n");
                LogUtil.i(TAG,"buffer size："+integers.size()+"\n");
                mRxOperatorsText.append("buffer value: ");
                LogUtil.w(TAG,"buffer value: ");
                for (Integer i:integers){
                    mRxOperatorsText.append(i+"");
                    LogUtil.w(TAG,i+"");
                }
                mRxOperatorsText.append("\n");
                LogUtil.w(TAG,"\n");
            }
        });
    }
}
