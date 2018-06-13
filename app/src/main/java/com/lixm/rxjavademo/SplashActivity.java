package com.lixm.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.lixm.rxjavademo.utils.LogUtil;
import com.lixm.rxjavademo.utils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;


public class SplashActivity extends AppCompatActivity {
    private String TAG = getClass().getName();

    @BindView(R.id.iv_splash)
    ImageView iv_splash;

    private Subscriber<String> subscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        iv_splash.setBackgroundResource(R.mipmap.welcome);


        subscriber = new Subscriber<String>() {

            @Override
            public void onStart() {
                super.onStart();
                LogUtil.w(TAG, "开始");
            }

            @Override
            public void onCompleted() {
                LogUtil.w(TAG, "观察者完成");
            }

            @Override
            public void onError(Throwable e) {
                if (x.isDebug)
                    e.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                LogUtil.i(TAG, "观察者：" + s);
            }
        };

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("在么");
                subscriber.onNext("Bye");
                subscriber.onCompleted();
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!subscriber.isUnsubscribed())
            subscriber.unsubscribe();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
