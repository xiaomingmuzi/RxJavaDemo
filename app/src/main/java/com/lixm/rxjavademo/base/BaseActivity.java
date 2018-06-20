package com.lixm.rxjavademo.base;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.ui.SystemBarTintManager;

import butterknife.ButterKnife;

/**
 * @author Lixm
 * @date 2018/6/19 15:36
 * @detail Actvity基类
 */

public abstract class BaseActivity extends Activity {
    /**
     * 获取布局ID
     *
     * @return 布局ID
     */
    protected abstract int getContentViewLayoutID();

    /**
     * 界面初始化前期准备
     */
    protected void beforeInit() {
    }

    /**
     * 初始化布局以及View控件
     *
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 子类可以重写，决定是否使用透明状态栏
     *
     * @return
     */
    protected boolean translucentStatusBar() {
        return false;
    }

    /**
     * 子类可以重写，改变颜色
     *
     * @return
     */
    protected int setStatusBarColor() {
        return R.color.blue;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSystemBarTint();
        beforeInit();
        if (getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
            initView(savedInstanceState);
        }
    }

    protected void initSystemBarTint() {
        Window window = getWindow();
        if (translucentStatusBar()) {
            //设置状态栏全透明
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
            return;
        }
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0以上，使用原生方法
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(setStatusBarColor());
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4-5.0 使用三方工具类，有些4.4 的手机有问题，这里为演示方便，不使用沉浸式
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintColor(setStatusBarColor());
        }
    }

    private Toast mToast;
    protected void showToast(String desc){
        if (mToast==null){
            mToast=Toast.makeText(this.getApplicationContext(),desc,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(desc);
        }
        mToast.show();
    }
}
