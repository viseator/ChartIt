package com.viseator.chartit.activity.chart;

import android.graphics.Color;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.viseator.chartit.R;
import com.viseator.chartit.data.chart.IDataSource;
import com.viseator.chartit.data.style.ChartSetStyle;
import com.viseator.chartit.data.style.ChartSetStyleEntity;
import com.viseator.chartit.data.style.ChartStyle;
import com.viseator.chartit.data.style.ChartStyleEntity;
import com.viseator.chartit.data.style.ChartStyleEntityDao;

import java.util.List;

import static com.viseator.chartit.utils.NullChecker.isSetted;

/**
 * Created by viseator on 5/30/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class LineChartPresenter implements LineChartContract.Presenter {

    private IDataSource mChartDataRepo;
    private ChartSetStyle mChartSetStyle;
    private LineData mLineData;
    private ChartStyleEntity mChartStyleEntity;
    private LineChartContract.View mView;
    private int mPos;

    public void showAllChartSetStyles() {
        List<ChartSetStyleEntity> list = mChartSetStyle.getAllChartSetStyles();
        mView.showChartSetStylesList(list);
    }

    public LineChartPresenter(IDataSource dataSource, LineChartContract.View view, ChartSetStyle
            chartSetStyle, ChartStyleEntityDao chartStyleEntityDao, int pos) {
        mChartSetStyle = chartSetStyle;
        mChartDataRepo = dataSource;
        mView = view;
        mPos = pos;
        mChartStyleEntity = ChartStyle.getChartStyleEntity(chartStyleEntityDao);
    }

    public void initView() {
        List<Entry> entries = (List<Entry>) mChartDataRepo.getData(mPos);
        LineDataSet lineDataSet = new LineDataSet(entries, mChartDataRepo.getLabel(mPos));
        initTestStyle();
        setDataStyle(0, lineDataSet);
        mLineData = new LineData(lineDataSet);
        mView.init(mLineData); // TODO: 6/1/17 separate init and set data
        mView.setProperties(mChartStyleEntity);
    }

    private void initTestStyle() {
        ChartSetStyleEntity style = new ChartSetStyleEntity();
//        style.setLineWidth(20f);
//        style.setValueTextColor("#ff0000");
        style.setLineWidth(2f);
        style.setFillAlpha(255); // FIXME: 6/9/17 mpchart
        style.setDrawValues(false);
        style.setFillColor(R.color.chartBlue);
        style.setDrawCircleHole(false);
        style.setCircleColor(R.color.chartBlue);
        style.setCircleRadius(4f);
        style.setDrawFill(true);
        mChartSetStyle.removeAllChartSetStyle();
        mChartSetStyle.addChartSetStyleEntity(style);
    }
    public void setDataStyle(int pos, LineDataSet lineDataSet) {
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER); // FIXME: 6/9/17 mpchart
        lineDataSet.setColor(R.color.chartBlue);
        ChartSetStyleEntity styleEntity = mChartSetStyle.getChartSetStyle(pos);
        if (isSetted(styleEntity.getValueTextColor())) {
            lineDataSet.setValueTextColor(Color.parseColor(styleEntity.getValueTextColor()));
        }
        if (isSetted(styleEntity.getValueTextSize())) {
            lineDataSet.setValueTextSize(styleEntity.getValueTextSize());
        }
        if (isSetted(styleEntity.getDrawValues())) {
            lineDataSet.setDrawValues(styleEntity.getDrawValues());
        }
        if (isSetted(styleEntity.getHighlightColor())) {
            lineDataSet.setHighLightColor(Color.parseColor(styleEntity.getHighlightColor()));
        }
        if (isSetted(styleEntity.getHighlightLineWidth())) {
            lineDataSet.setHighlightLineWidth(styleEntity.getHighlightLineWidth());
        }
        if (isSetted(styleEntity.getFillColor())) {
            lineDataSet.setFillColor(styleEntity.getFillColor());
        }
        if (isSetted(styleEntity.getFillAlpha())) {
            lineDataSet.setFillAlpha(styleEntity.getFillAlpha());
        }
        if (isSetted(styleEntity.getLineWidth())) {
            lineDataSet.setLineWidth(styleEntity.getLineWidth());
        }
        if (isSetted(styleEntity.getCircleRadius())) {
            lineDataSet.setCircleRadius(styleEntity.getCircleRadius());
        }
        if (isSetted(styleEntity.getDrawCircles())) {
            lineDataSet.setDrawCircles(styleEntity.getDrawCircles());
        }
        if (isSetted(styleEntity.getCircleColor())) {
            lineDataSet.setCircleColor(styleEntity.getCircleColor());
        }
        if (isSetted(styleEntity.getDrawCircleHole())) {
            lineDataSet.setDrawCircleHole(styleEntity.getDrawCircleHole());
        }
        if (isSetted(styleEntity.getDrawFill())) {
            lineDataSet.setDrawFilled(styleEntity.getDrawFill());
        }
        if (isSetted(styleEntity.getEnableDashedLine())) {
            if (styleEntity.getEnableDashedLine()) {
                lineDataSet.enableDashedLine(10f, 10f, 0f);
            } else {
                lineDataSet.disableDashedLine();
            }
        }

    }


}
