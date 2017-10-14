package com.viseator.chartit.activity.chart;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.viseator.chartit.BasePresenter;
import com.viseator.chartit.BaseView;
import com.viseator.chartit.data.style.ChartSetStyleEntity;
import com.viseator.chartit.data.style.ChartStyle;
import com.viseator.chartit.data.style.ChartStyleEntity;

import java.util.List;

/**
 * Created by viseator on 5/30/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public interface LineChartContract {
    interface Presenter extends BasePresenter {
        void initView();

        void showAllChartSetStyles();

        void updateData(List<? extends Entry> entries);
        void setViewData(int pos);
    }

    interface View extends BaseView<Presenter> {
        void setData(LineData lineData);

        void initChart();

        void showChartSetStylesList(List<ChartSetStyleEntity> list);

        void setProperties(ChartStyleEntity chartStyle);

        void setXFormatter(IAxisValueFormatter formatter);

        void cancelFormatter();

        void setOnTouchListener();
    }

}
