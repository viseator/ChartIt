package com.viseator.chartit.utils.axis;

import com.github.mikephil.charting.components.YAxis;

/**
 * Created by viseator on 5/31/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class YAxisSetter  implements IYAxisSetter{
    private YAxis mYAxis;

    @Override
    public void setEnabled(Boolean enabled) {
        mYAxis.setEnabled(enabled);
    }

    @Override
    public void setDrawLabels(Boolean enabled) {
        mYAxis.setDrawLabels(enabled);
    }

    @Override
    public void setDrawAxisLine(Boolean enabled) {
        mYAxis.setDrawAxisLine(enabled);
    }

    @Override
    public void setDrawGridLines(Boolean enabled) {
        mYAxis.setDrawGridLines(enabled);
    }

    @Override
    public void setTextColor(int color) {
        mYAxis.setTextColor(color);
    }

    @Override
    public void setTextSize(float size) {
        mYAxis.setTextSize(size);
    }

    @Override
    public void setGridColor(int color) {
        mYAxis.setGridColor(color);
    }

    @Override
    public void setGridLineWidth(float width) {
        mYAxis.setGridLineWidth(width);
    }

    @Override
    public void setAxisLineColor(int color) {
        mYAxis.setAxisLineColor(color);
    }

    @Override
    public void setAxisLineWidth(float width) {
        mYAxis.setAxisLineWidth(width);
    }

    @Override
    public void enableGridDashedLine(Boolean enabled) {
        if (enabled) {
            mYAxis.enableGridDashedLine(10f, 10f, 0f);
        } else {
            mYAxis.disableGridDashedLine();
        }
    }

    @Override
    public void setDrawZeroLine(boolean enabled) {
        mYAxis.setDrawZeroLine(enabled);
    }

    @Override
    public void setZeroLineWidth(float width) {
        mYAxis.setZeroLineWidth(width);
    }

    @Override
    public void setZeroLineColor(int color) {
        mYAxis.setZeroLineColor(color);
    }
}
