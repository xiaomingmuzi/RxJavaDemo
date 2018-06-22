package com.lixm.rxjavademo.module.rxjava2;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.base.BaseFragment;
import com.lixm.rxjavademo.model.OperatorModel;
import com.lixm.rxjavademo.module.rxjava2.operators.item.OperatorsAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * @author Lixm
 * @date 2018/6/21 10:48
 * @detail
 */

public abstract class CatagoryBaseFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    protected List<OperatorModel> data;

    @BindView(R.id.operaotrs_recycler)
    RecyclerView mRecyclerView;
    @BindView(R.id.operators_refresh)
    SwipeRefreshLayout mRefreshLayout;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_operators;
    }

    protected abstract void fillData();

    protected abstract void itemClick(int poisition);

    @Override
    protected void init() {
        fillData();
        OperatorsAdapter adapter = new OperatorsAdapter(data) {
            @Override
            public void onItemClick(int position) {
                itemClick(position);
            }
        };
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);

        mRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        mRefreshLayout.setOnRefreshListener(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        });
    }
}
