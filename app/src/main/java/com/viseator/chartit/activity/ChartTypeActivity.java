package com.viseator.chartit.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;

import butterknife.BindView;
import butterknife.OnItemClick;

public class ChartTypeActivity extends BaseActivity {

    private static final String TAG = "@vir ChartTypeActivity";
    @BindView(R.id.chart_list)
    ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
