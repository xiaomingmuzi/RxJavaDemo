package com.lixm.rxjavademo.module.rxjava2.operators.item;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * create
 * <p>
 * 最常见的操作符，用于生产一个发射对象
 *
 * @author Lixm
 * @date 2018/6/22
 */
public class RxCreateActivity extends RxOperatorBaseActivity {

    private String TAG = getClass().getName();

    @Override
    protected String getSubTitle() {
        return getString(R.string.rx_create);
    }

    @Override
    protected void doSomething() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                mRxOperatorsText.append("Observable emit 1 \n");
                LogUtil.w(TAG, "Observable emit 1 \n");
                e.onNext(1);
                mRxOperatorsText.append("Observable emit 2 \n");
                LogUtil.w(TAG, "Observable emit 2 \n");
                e.onNext(2);
                mRxOperatorsText.append("Observable emit 3 \n");
                LogUtil.w(TAG, "Observable emit 3 \n");
                e.onNext(3);
                e.onComplete();
                mRxOperatorsText.append("Observable emit 4 \n");
                LogUtil.w(TAG, "Observable emit 4 \n");
                e.onNext(4);
                mRxOperatorsText.append("Observable emit 5 \n");
                LogUtil.w(TAG, "Observable emit 5 \n");
                e.onNext(5);
            }
        }).subscribe(new Observer<Integer>() {

            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                mRxOperatorsText.append("onSubscribe：" + d.isDisposed() + "\n");
                LogUtil.w(TAG, "onSubscribe：" + d.isDisposed() + "\n");
                mDisposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                mRxOperatorsText.append("onNext：value ："+integer+"\n");
                LogUtil.w(TAG,"onNext：value："+integer+"\n");
                i++;
                if (i==4){
                    //在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让observer观察者不再接收上游事件
                    mDisposable.dispose();
                    mRxOperatorsText.append("onNext ：isDisposable："+mDisposable.isDisposed()+"\n");
                    LogUtil.i(TAG,"onNext：isDisposable："+mDisposable.isDisposed()+"\n");
                }
            }

            @Override
            public void onError(Throwable e) {
                mRxOperatorsText.append("onError：value："+e.getMessage()+"\n");
                LogUtil.w(TAG,"onError：value："+e.getMessage()+"\n");
            }

            @Override
            public void onComplete() {
                mRxOperatorsText.append("onComplete \n");
                LogUtil.w(TAG,"onComplete \n");
            }
        });
    }
}
