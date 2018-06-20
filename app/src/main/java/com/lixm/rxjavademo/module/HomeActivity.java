package com.lixm.rxjavademo.module;

import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.base.BaseActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){//4.4以上版本
            //设置 ToolBar 高度为80dp ，适配状态栏
            ViewGroup.LayoutParams layoutParams;
        }
    }


}
