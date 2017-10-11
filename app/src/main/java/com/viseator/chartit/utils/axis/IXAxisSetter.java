package com.viseator.chartit.utils.axis;

import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by viseator on 5/31/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public interface IXAxisSetter extends IAxisSetter {
    void setPosition(int position);
    void setFormatter(IAxisValueFormatter formatter);
    void setLabelCount(int num);
    void cancelFormatter();
}
