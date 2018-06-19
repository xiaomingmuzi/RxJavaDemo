package com.lixm.rxjavademo;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * @author Lixm
 * @date 2018/6/19 17:52
 * @detail
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
