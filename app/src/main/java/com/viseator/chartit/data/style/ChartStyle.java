package com.viseator.chartit.data.style;

import android.graphics.Color;
import android.util.Log;

import com.viseator.chartit.R;

/**
 * Created by viseator on 5/31/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class ChartStyle {
    private static final String TAG = "@vir ChartStyle";
    private static ChartStyleEntity INSTANCE;

    public static ChartStyleEntity getChartStyleEntity(ChartStyleEntityDao chartStyleEntityDao) {
        if (INSTANCE == null) {
            chartStyleEntityDao.deleteAll(); // test
            if (chartStyleEntityDao.count() == 0) {
                Log.d(TAG, String.valueOf("create database"));
                create(chartStyleEntityDao);
            }

            INSTANCE = chartStyleEntityDao.queryBuilder().list().get(0);
        }
        return INSTANCE;
    }

    private ChartStyle(ChartStyleEntityDao chartStyleEntityDao){
    }

    private static void create(ChartStyleEntityDao chartStyleEntityDao) {
        // init chart style here
        Log.d(TAG, String.valueOf("Create new chartStyle"));
        ChartStyleEntity chartStyleEntity = new ChartStyleEntity();
        chartStyleEntity.setXAxisPosition(1);
        chartStyleEntity.setDrawXAxisGridLines(false);
        chartStyleEntity.setDrawYAxisGridLines(false);
        chartStyleEntity.setDrawXAxisLine(false);
        chartStyleEntity.setDrawYAxisLine(false);
        chartStyleEntity.setXAxisTextColor(Color.parseColor("#767676"));
        chartStyleEntity.setYAxisTextColor(Color.parseColor("#767676"));
        chartStyleEntity.setDrawLegend(false);
        chartStyleEntityDao.insert(chartStyleEntity);
   }
}
