package com.viseator.chartit.activity.chart;

import com.github.mikephil.charting.data.LineData;
import com.viseator.chartit.BasePresenter;
import com.viseator.chartit.BaseView;

/**
 * Created by viseator on 5/30/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public interface LineChartContract {
    interface Presenter extends BasePresenter {
        void initView();
    }

    interface View extends BaseView<Presenter> {
        void setData(LineData lineData);

    }

}
