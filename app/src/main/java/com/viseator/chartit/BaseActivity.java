package com.viseator.chartit;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.viseator.chartit.data.chart.ChartDataEntityDao;
import com.viseator.chartit.data.chart.ChartDataRepository;
import com.viseator.chartit.data.chart.local.LocalChartData;
import com.viseator.chartit.data.style.ChartSetStyleEntityDao;
import com.viseator.chartit.data.style.ChartStyleEntityDao;
import com.viseator.chartit.data.style.DaoSession;

import butterknife.ButterKnife;

/**
 * Created by viseator on 5/27/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle
            persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        baseInit();
        initView();
    }

    protected void setFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    protected abstract void baseInit();


    protected abstract void initView();

    protected ChartDataEntityDao getChartDataDao() {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        return daoSession.getChartDataEntityDao();
    }

    protected ChartStyleEntityDao getChartStyleDao() {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        return daoSession.getChartStyleEntityDao();
    }

    protected ChartSetStyleEntityDao getChartSetStyleEntityDao() {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        return daoSession.getChartSetStyleEntityDao();
    }

}

