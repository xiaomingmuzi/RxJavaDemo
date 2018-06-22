package com.lixm.rxjavademo.module.web;

import android.app.Activity;

import com.lixm.rxjavademo.base.BasePresenter;
import com.lixm.rxjavademo.base.BaseView;

/**
 * @author Lixm
 * @date 2018/6/21 17:38
 * @detail
 */

public interface WebContract {
    interface IWebView extends BaseView {
        Activity getWebViewContext();

        void setGankTitle(String title);

        void loadGankUrl(String url);

        void initWebView();
    }

    interface IWebPresenter extends BasePresenter {
        String getGankUrl();
    }
}
