package com.viseator.chartit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;

import butterknife.BindView;
import butterknife.OnItemSelected;

public class ChartTypeActivity extends BaseActivity {

    @BindView(R.id.chart_list)
    ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnItemSelected(R.id.chart_list)
    public void onListItemSelected(int position){

    }
    @Override
    protected int getLayout() {
        return R.layout.activity_chart_type;
    }

    @Override
    protected void initView() {
        String[] listContent = new String[]{"LineChart","BarChart","PieChart"};
        ListAdapter listAdapter = new ArrayAdapter<>(this,R.layout.list_content,listContent);
        listView.setAdapter(listAdapter);
    }

    @Override
    protected void baseInit() {

    }

}
