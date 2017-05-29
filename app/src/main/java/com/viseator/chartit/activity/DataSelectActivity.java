package com.viseator.chartit.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;

import butterknife.BindView;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class DataSelectActivity extends BaseActivity {
    @BindView(R.id.data_recyclerView)
    RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_data_selecte;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void baseInit() {

    }
}
