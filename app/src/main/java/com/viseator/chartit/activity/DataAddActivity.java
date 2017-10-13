package com.viseator.chartit.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.data.Entry;
import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.adapter.DataAddAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DataAddActivity extends BaseActivity {

    @BindView(R.id.data_add_recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.generate_chart_button)
    Button mButton;

    private DataAddAdapter mDataAddAdapter;

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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mDataAddAdapter = new DataAddAdapter(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mDataAddAdapter);
    }


    @OnClick(R.id.generate_chart_button)
    void onClick() {
        if (getCurrentFocus() != null) {
            getCurrentFocus().clearFocus();
        }
        List<Entry> entries = mDataAddAdapter.getEntries();
    }
}
