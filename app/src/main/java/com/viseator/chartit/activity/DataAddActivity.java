package com.viseator.chartit.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;

import butterknife.BindView;
import butterknife.OnClick;

public class DataAddActivity extends BaseActivity {

    @BindView(R.id.data_add_recyclerview)
    RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_data_add;
    }

    @Override
    protected void baseInit() {

    }

    @Override
    protected void initView() {

    }


    @OnClick(R.id.generate_chart_button)
    void onClick(){

    }
}
