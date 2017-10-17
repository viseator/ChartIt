package com.viseator.chartit.activity.chart;

import android.content.Context;
import android.graphics.Color;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.viseator.chartit.R;
import com.viseator.chartit.adapter.XAxisFormatter;
import com.viseator.chartit.data.chart.IDataSource;
import com.viseator.chartit.data.style.ChartSetStyle;
import com.viseator.chartit.data.style.ChartSetStyleEntity;
import com.viseator.chartit.data.style.ChartStyle;
import com.viseator.chartit.data.style.ChartStyleEntity;
import com.viseator.chartit.data.style.ChartStyleEntityDao;

import java.util.ArrayList;
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
    private Context mContext;

    public void showAllChartSetStyles() {
        List<ChartSetStyleEntity> list = mChartSetStyle.getAllChartSetStyles();
        mView.showChartSetStylesList(list);
    }

    @Override
    public void updateData(int pos, List<? extends Entry> entries) {
        mChartDataRepo.updateData(pos, entries, mChartDataRepo.getLabel(0));
    }

    public LineChartPresenter(Context context, IDataSource dataSource, LineChartContract.View view,
                              ChartSetStyle chartSetStyle, ChartStyleEntityDao
                                      chartStyleEntityDao) {
        mContext = context;
        mChartSetStyle = chartSetStyle;
        mChartDataRepo = dataSource;
        mView = view;
        mChartStyleEntity = ChartStyle.getChartStyleEntity(chartStyleEntityDao);
    }

    public void initView() {
        initTestStyle();
        mView.initChart(); // TODO: 6/1/17 separate initChart and set data
        mView.setProperties(mChartStyleEntity);
    }


    public void setViewData(int pos) {
        List<Entry> entries = (ArrayList<Entry>) mChartDataRepo.getData(pos);
        LineDataSet lineDataSet = new LineDataSet(entries, mChartDataRepo.getLabel(mPos));
        setDataStyle(0, lineDataSet);
        mLineData = new LineData(lineDataSet);
        mView.setData(mLineData);
        if (entries.get(0).getData() == null) {
            mView.cancelFormatter();
        } else {
            List<String> formatterString = new ArrayList<>(entries.size());
            for (Entry e : entries) {
                formatterString.add((String) e.getData());
            }
            mView.setXFormatter(new XAxisFormatter(formatterString));
        }
        mView.setOnTouchListener();
    }

    private void initTestStyle() {
        ChartSetStyleEntity style = new ChartSetStyleEntity();
//        style.setLineWidth(20f);
//        style.setValueTextColor("#ff0000");
        style.setLineWidth(2f);
        style.setFillAlpha(100); // FIXME: 6/9/17 mpchart
//        style.setDrawValues(false);
        style.setFillColor(mContext.getResources().getColor(R.color.colorPrimary));

        style.setDrawCircleHole(false);
        style.setCircleColor(mContext.getResources().getColor(R.color.colorPrimary));
        style.setCircleRadius(4f);
        style.setDrawFill(true);
        style.setMode(ChartSetStyle.MODE_LINEAR);
        mChartSetStyle.removeAllChartSetStyle();
        mChartSetStyle.addChartSetStyleEntity(style);
    }

    public void setDataStyle(int pos, LineDataSet lineDataSet) {
//        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER); // FIXME: 6/9/17 mpchart
        lineDataSet.setColor(mContext.getResources().getColor(R.color.colorPrimary));
        lineDataSet.setValueTextColor(mContext.getResources().getColor(R.color.colorPrimary));
        ChartSetStyleEntity styleEntity = mChartSetStyle.getChartSetStyle(pos);
        if (isSetted(styleEntity.getMode())) {
            switch (styleEntity.getMode()) {
                case ChartSetStyle.MODE_CUBIC:
                    lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                    break;
                case ChartSetStyle.MODE_LINEAR:
                    lineDataSet.setMode(LineDataSet.Mode.LINEAR);
            }
        }
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
