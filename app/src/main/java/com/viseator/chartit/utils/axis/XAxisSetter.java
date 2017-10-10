package com.viseator.chartit.utils.axis;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by viseator on 5/31/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class XAxisSetter implements IXAxisSetter {

    private XAxis mXAxis;

    public XAxisSetter(XAxis XAxis) {
        mXAxis = XAxis;
    }

    @Override
    public void setEnabled(Boolean enabled) {
        mXAxis.setEnabled(enabled);
    }

    @Override
    public void setDrawLabels(Boolean enabled) {
        mXAxis.setDrawLabels(enabled);
    }

    @Override
    public void setDrawAxisLine(Boolean enabled) {
        mXAxis.setDrawAxisLine(enabled);
    }

    @Override
    public void setDrawGridLines(Boolean enabled) {
        mXAxis.setDrawGridLines(enabled);
    }

    @Override
    public void setTextColor(int color) {
        mXAxis.setTextColor(color);
    }

    @Override
    public void setTextSize(float size) {
        mXAxis.setTextSize(size);
    }

    @Override
    public void setGridColor(int color) {
        mXAxis.setGridColor(color);
    }

    @Override
    public void setGridLineWidth(float width) {
        mXAxis.setGridLineWidth(width);
    }

    @Override
    public void setAxisLineColor(int color) {
        mXAxis.setAxisLineColor(color);
    }

    @Override
    public void setAxisLineWidth(float width) {
        mXAxis.setAxisLineWidth(width);
    }

    @Override
    public void enableGridDashedLine(Boolean enabled) {
        if (enabled) {
            mXAxis.enableGridDashedLine(10f, 10f, 0f);
        } else {
            mXAxis.disableGridDashedLine();
        }
    }

    @Override
    public void setPosition(int position) {
        switch (position) {
            case 0:
                mXAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
                break;
            case 1:
                mXAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                break;
            case 2:
                mXAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
                break;
            case 3:
                mXAxis.setPosition(XAxis.XAxisPosition.TOP);
                break;
            case 4:
                mXAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE);
                break;
            default:
                break;
        }
    }

    @Override
    public void setFormatter(IAxisValueFormatter formatter) {
        mXAxis.setValueFormatter(formatter);
    }

    @Override
    public void setLabelCount(int num) {
        mXAxis.setLabelCount(num);
    }
}
