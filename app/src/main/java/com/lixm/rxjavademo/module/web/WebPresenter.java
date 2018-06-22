package com.lixm.rxjavademo.module.web;

import android.app.Activity;
import android.content.Intent;

/**
 * @author Lixm
 * @date 2018/6/21 17:45
 * @detail
 */

public class WebPresenter implements WebContract.IWebPresenter {

    private WebContract.IWebView mWebView;
    private String mGankUrl;
    private Activity mActivity;

    public WebPresenter(WebContract.IWebView mWebView) {
        this.mWebView = mWebView;
    }

    @Override
    public void subscribe() {
        mActivity=mWebView.getWebViewContext();
        Intent intent=mActivity.getIntent();
        mWebView.setGankTitle(intent.getStringExtra(WebViewActivity.GANK_TITLE));
        mWebView.initWebView();
        mGankUrl=intent.getStringExtra(WebViewActivity.GANK_URL);
        mWebView.loadGankUrl(mGankUrl);
    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public String getGankUrl() {
        return null;
    }
}
