package com.viseator.chartit.utils.axis;

/**
 * Created by viseator on 5/31/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public interface IAxisSetter {
    void setEnabled(Boolean enabled);

    void setDrawLabels(Boolean enabled);

    void setDrawAxisLine(Boolean enabled);

    void setDrawGridLines(Boolean enabled);

    void setTextColor(int color);

    void setTextSize(float size);

    void setGridColor(int color);

    void setGridLineWidth(float width);

    void setAxisLineColor(int color);

    void setAxisLineWidth(float width);

    void enableGridDashedLine(Boolean enabled);

}
