package com.lixm.rxjavademo.module;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.base.BaseActivity;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.home_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.home_tabLayout)
    TableLayout mTabLayout;
    @BindView(R.id.home_appbar)
    AppBarLayout mAppBar;
    @BindView(R.id.home_viewPager)
    ViewPager mViewPager;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.fab)
    FloatingActionButton mFab;



    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4以上版本
            //设置 ToolBar 高度为80dp ，适配状态栏
            ViewGroup.LayoutParams layoutParams;
        }
    }


}
