package com.lixm.rxjavademo.module;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.base.BaseActivity;
import com.lixm.rxjavademo.base.BaseViewPagerAdapter;
import com.lixm.rxjavademo.constant.GlobalConfig;
import com.lixm.rxjavademo.module.rxjava2.operators.item.OperatorsFragment;
import com.lixm.rxjavademo.module.rxjava2.usecases.UserCasesFragment;
import com.lixm.rxjavademo.module.web.WebViewActivity;
import com.lixm.rxjavademo.utils.ScreenUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.home_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.home_tabLayout)
    TabLayout mTabLayout;
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
            ViewGroup.LayoutParams layoutParams=mToolbarTitle.getLayoutParams();
            layoutParams.height= ScreenUtil.dip2px(this,80);
            mToolbarTitle.setLayoutParams(layoutParams);
        }
        initToolBar(mToolbar,false,"");
        String []titles={
                GlobalConfig.CATEGORY_NAME_OPERATORS,
                GlobalConfig.CATEGORY_NAME_EXAMPLES
        };

        BaseViewPagerAdapter pagerAdapter=new BaseViewPagerAdapter(getSupportFragmentManager(),titles);
        pagerAdapter.addFragment(new OperatorsFragment());
        pagerAdapter.addFragment(new UserCasesFragment());

        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }


    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title){
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

    @OnClick(R.id.fab)
    public void onViewClicked(){
        WebViewActivity.start(this,"https://github.com/xiaomingmuzi","我的gitHub，欢迎star");

    }

    @Override
    protected boolean translucentStatusBar() {
        return true;
    }
}
