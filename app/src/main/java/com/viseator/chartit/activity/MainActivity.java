package com.viseator.chartit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.entry_button_main)
    public void buttonClick(){
        Intent intent = new Intent(this,ChartTypeActivity.class);
        startActivity(intent);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void baseInit() {

    }
}
