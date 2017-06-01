package com.viseator.chartit.activity.chart;

import com.github.mikephil.charting.data.LineData;
import com.viseator.chartit.BasePresenter;
import com.viseator.chartit.BaseView;
import com.viseator.chartit.data.style.ChartSetStyleEntity;

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
    }

    interface View extends BaseView<Presenter> {
        void setData(LineData lineData);

        void init(LineData lineData);

        void showChartSetStylesList(List<ChartSetStyleEntity> list);
    }

}
