package com.viseator.chartit.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.viseator.chartit.App;
import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.data.ChartDataEntityDao;
import com.viseator.chartit.data.chart.ChartDataRepository;
import com.viseator.chartit.data.DaoSession;
import com.viseator.chartit.data.chart.local.LocalChartData;

import butterknife.BindView;
import butterknife.OnItemClick;

public class ChartTypeActivity extends BaseActivity {

    private static final String TAG = "@vir ChartTypeActivity";
    @BindView(R.id.chart_list)
    ListView mListView;
    DaoSession daoSession;
    ChartDataEntityDao chartDataEntityDao;
    ChartDataRepository mChartDataRepository;
    LocalChartData mLocalChartData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        daoSession = ((App) getApplication()).getDaoSession();
        chartDataEntityDao = daoSession.getChartDataEntityDao();
        mLocalChartData = LocalChartData.getInstance(chartDataEntityDao);
        mChartDataRepository = ChartDataRepository.getInstance(mLocalChartData);
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
        mListView.setAdapter(listAdapter);
    }

    @Override
    protected void baseInit() {

    }

}
