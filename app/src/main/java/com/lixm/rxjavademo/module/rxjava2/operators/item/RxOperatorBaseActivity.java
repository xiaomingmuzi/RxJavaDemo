package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.base.ToolbarBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Lixm
 * @date 2018/6/22 10:51
 * @detail 每一种RxJava 2.x 操作符的基类
 */

public abstract class RxOperatorBaseActivity extends ToolbarBaseActivity {
    @BindView(R.id.rx_operators_btn)
    protected Button mRxOperatorsBtn;
    @BindView(R.id.rx_operators_text)
    protected TextView mRxOperatorsText;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_rx_operator_base;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected abstract String getSubTitle();

    protected abstract void doSomething();

    @OnClick(R.id.rx_operators_btn)
    public void onViewClicked(){
        mRxOperatorsText.append("\n");
        doSomething();
    }
}
