package com.viseator.chartit.data.style;

import android.util.Log;

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
        Log.d(TAG, String.valueOf("Create new chartStyle"));
        ChartStyleEntity chartStyleEntity = new ChartStyleEntity();
        chartStyleEntityDao.insert(chartStyleEntity);
   }
}
