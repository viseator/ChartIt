package com.viseator.chartit.utils.axis;

/**
 * Created by viseator on 5/31/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public interface IYAxisSetter extends IAxisSetter {

    void setDrawZeroLine(boolean enabled);

    void setZeroLineWidth(float width);

    void setZeroLineColor(int color);

}
