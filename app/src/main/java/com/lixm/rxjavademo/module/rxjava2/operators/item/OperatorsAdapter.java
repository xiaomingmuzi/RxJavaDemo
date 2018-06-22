package com.lixm.rxjavademo.module.rxjava2.operators.item;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lixm.rxjavademo.R;
import com.lixm.rxjavademo.model.OperatorModel;

import java.util.List;

/**
 * @author Lixm
 * @date 2018/6/21 11:08
 * @detail
 */

public abstract class OperatorsAdapter extends BaseQuickAdapter<OperatorModel,BaseViewHolder> {

    public OperatorsAdapter(@Nullable List<OperatorModel> data) {
        super(R.layout.layout_item_operator,data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, OperatorModel item) {
        if (item!=null){
            helper.setText(R.id.item_title,item.title)
                    .setText(R.id.item_des,item.des)
                    .getConvertView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick(helper.getAdapterPosition());
                }
            });
        }
    }
    public abstract void onItemClick(int position);
}
