package com.viseator.chartit.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.github.mikephil.charting.data.ChartData;
import com.viseator.chartit.App;
import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.data.ChartDataEntity;
import com.viseator.chartit.data.ChartDataEntityDao;
import com.viseator.chartit.data.DaoSession;

import java.util.List;

import butterknife.BindView;
import butterknife.OnItemClick;

public class ChartTypeActivity extends BaseActivity {

    private static final String TAG = "@vir ChartTypeActivity";
    @BindView(R.id.chart_list)
    ListView listView;
    DaoSession daoSession;
    ChartDataEntityDao chartDataEntityDao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        daoSession = ((App) getApplication()).getDaoSession();
        chartDataEntityDao = daoSession.getChartDataEntityDao();
//        test();
    }

    private void test() {
        ChartDataEntity charData = new ChartDataEntity();
        charData.setMapValue("Hi");
        charData.setMainValue("Hello");
        charData.setId(2L);
        chartDataEntityDao.insert(charData);
        chartDataEntityDao.deleteByKey(3L);
        test1();
    }

    private void test1() {
        ChartDataEntity chartDataEntity;
        ChartDataEntityDao chartDataEntityDao;
        chartDataEntityDao = daoSession.getChartDataEntityDao();
        List<ChartDataEntity> list = chartDataEntityDao.queryBuilder().list();
        for (ChartDataEntity chart : list) {
            Log.d(TAG, chart.toString());
        }
    }

    @OnItemClick(R.id.chart_list)
    void onListItemClick(int position) {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_chart_type;
    }

    @Override
    protected void initView() {
        String[] listContent = new String[]{"LineChart", "BarChart", "PieChart"};
        ListAdapter listAdapter = new ArrayAdapter<>(this, R.layout.list_content, listContent);
        listView.setAdapter(listAdapter);
    }

    @Override
    protected void baseInit() {

    }

}
