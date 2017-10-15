package com.viseator.chartit.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.fragment.DataAddModifyFragment;

public class DataAddActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_add_data;
    }

    @Override
    protected void baseInit() {
    }

    @Override
    protected void initView() {
        Bundle bundle = new Bundle();
        bundle.putInt("position", -1);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DataAddModifyFragment dataAddModifyFragment = new DataAddModifyFragment();
        dataAddModifyFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.data_add_container, dataAddModifyFragment);
        fragmentTransaction.commit();
    }


}
