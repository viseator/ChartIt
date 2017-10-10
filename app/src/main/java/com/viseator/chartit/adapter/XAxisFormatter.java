package com.viseator.chartit.adapter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viseator on 10/10/17.
 * Wu Di
 * viseator@gmail.com
 */

public class XAxisFormatter implements IAxisValueFormatter{

    private List<String> mStrings;
    public XAxisFormatter(List<String> strings){
        mStrings = strings;
    }
    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mStrings.get((int)value);
    }
}
