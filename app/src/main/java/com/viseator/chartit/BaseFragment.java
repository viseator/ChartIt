package com.viseator.chartit;

import android.support.v4.app.Fragment;

import com.viseator.chartit.data.chart.ChartDataEntityDao;
import com.viseator.chartit.data.style.ChartSetStyleEntityDao;
import com.viseator.chartit.data.style.ChartStyleEntityDao;
import com.viseator.chartit.data.style.DaoSession;

/**
 * Created by viseator on 10/14/17.
 * Wu Di
 * viseator@gmail.com
 */

public abstract class BaseFragment extends Fragment {

    protected ChartDataEntityDao getChartDataDao() {
        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
        return daoSession.getChartDataEntityDao();
    }

    protected ChartStyleEntityDao getChartStyleDao() {
        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
        return daoSession.getChartStyleEntityDao();
    }

    protected ChartSetStyleEntityDao getChartSetStyleEntityDao() {
        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
        return daoSession.getChartSetStyleEntityDao();
    }

}
