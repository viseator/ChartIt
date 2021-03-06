package com.viseator.chartit.data.style;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by viseator on 5/31/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

@Entity
public class ChartStyleEntity {
    @Id(autoincrement = true)
    private long id;

    private String backgroundColor;
    private String description;
    private Boolean drawGrid;
    private String gridColor;
    private String borderColor;
    private float borderWidth;
    private int maxVisibleValueCount;
    private Boolean enableXAxis;
    private Boolean enableYAxis;
    private Boolean drawXAxisLabel;
    private Boolean drawYAxisLabel;
    private Boolean drawXAxisLine;
    private Boolean drawYAxisLine;
    private Boolean drawXAxisGridLines;
    private Boolean drawYAxisGridLines;
    //    private String xAxisGridLineColor;
//    private String yAxisGridLineColor;
    private float xAxisGridLineWidth;
    private float yAxisGridLineWidth;
    private Boolean setXAxisGridDashLine;
    private Boolean setYAxisGridDashLine;
    private float textSize;
    private int xAxisPosition;
    private int xAxisTextColor;
    private int yAxisTextColor;
    private Boolean showLeftYAxis;// TODO: 6/7/17 control left or right
    private Boolean showRightYAxis;
    private Boolean drawZeroLine;
    private float zeroLineWidth;
    private String zeroLineColor;
    private Boolean drawLegend;

    @Generated(hash = 733644684)
    public ChartStyleEntity(long id, String backgroundColor, String description,
            Boolean drawGrid, String gridColor, String borderColor,
            float borderWidth, int maxVisibleValueCount, Boolean enableXAxis,
            Boolean enableYAxis, Boolean drawXAxisLabel, Boolean drawYAxisLabel,
            Boolean drawXAxisLine, Boolean drawYAxisLine,
            Boolean drawXAxisGridLines, Boolean drawYAxisGridLines,
            float xAxisGridLineWidth, float yAxisGridLineWidth,
            Boolean setXAxisGridDashLine, Boolean setYAxisGridDashLine,
            float textSize, int xAxisPosition, int xAxisTextColor,
            int yAxisTextColor, Boolean showLeftYAxis, Boolean showRightYAxis,
            Boolean drawZeroLine, float zeroLineWidth, String zeroLineColor,
            Boolean drawLegend) {
        this.id = id;
        this.backgroundColor = backgroundColor;
        this.description = description;
        this.drawGrid = drawGrid;
        this.gridColor = gridColor;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        this.maxVisibleValueCount = maxVisibleValueCount;
        this.enableXAxis = enableXAxis;
        this.enableYAxis = enableYAxis;
        this.drawXAxisLabel = drawXAxisLabel;
        this.drawYAxisLabel = drawYAxisLabel;
        this.drawXAxisLine = drawXAxisLine;
        this.drawYAxisLine = drawYAxisLine;
        this.drawXAxisGridLines = drawXAxisGridLines;
        this.drawYAxisGridLines = drawYAxisGridLines;
        this.xAxisGridLineWidth = xAxisGridLineWidth;
        this.yAxisGridLineWidth = yAxisGridLineWidth;
        this.setXAxisGridDashLine = setXAxisGridDashLine;
        this.setYAxisGridDashLine = setYAxisGridDashLine;
        this.textSize = textSize;
        this.xAxisPosition = xAxisPosition;
        this.xAxisTextColor = xAxisTextColor;
        this.yAxisTextColor = yAxisTextColor;
        this.showLeftYAxis = showLeftYAxis;
        this.showRightYAxis = showRightYAxis;
        this.drawZeroLine = drawZeroLine;
        this.zeroLineWidth = zeroLineWidth;
        this.zeroLineColor = zeroLineColor;
        this.drawLegend = drawLegend;
    }
    @Generated(hash = 1823078858)
    public ChartStyleEntity() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getBackgroundColor() {
        return this.backgroundColor;
    }
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getDrawGrid() {
        return this.drawGrid;
    }
    public void setDrawGrid(Boolean drawGrid) {
        this.drawGrid = drawGrid;
    }
    public String getGridColor() {
        return this.gridColor;
    }
    public void setGridColor(String gridColor) {
        this.gridColor = gridColor;
    }
    public String getBorderColor() {
        return this.borderColor;
    }
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }
    public float getBorderWidth() {
        return this.borderWidth;
    }
    public void setBorderWidth(float borderWidth) {
        this.borderWidth = borderWidth;
    }
    public int getMaxVisibleValueCount() {
        return this.maxVisibleValueCount;
    }
    public void setMaxVisibleValueCount(int maxVisibleValueCount) {
        this.maxVisibleValueCount = maxVisibleValueCount;
    }
    public Boolean getEnableXAxis() {
        return this.enableXAxis;
    }
    public void setEnableXAxis(Boolean enableXAxis) {
        this.enableXAxis = enableXAxis;
    }
    public Boolean getEnableYAxis() {
        return this.enableYAxis;
    }
    public void setEnableYAxis(Boolean enableYAxis) {
        this.enableYAxis = enableYAxis;
    }
    public Boolean getDrawXAxisLabel() {
        return this.drawXAxisLabel;
    }
    public void setDrawXAxisLabel(Boolean drawXAxisLabel) {
        this.drawXAxisLabel = drawXAxisLabel;
    }
    public Boolean getDrawYAxisLabel() {
        return this.drawYAxisLabel;
    }
    public void setDrawYAxisLabel(Boolean drawYAxisLabel) {
        this.drawYAxisLabel = drawYAxisLabel;
    }
    public Boolean getDrawXAxisLine() {
        return this.drawXAxisLine;
    }
    public void setDrawXAxisLine(Boolean drawXAxisLine) {
        this.drawXAxisLine = drawXAxisLine;
    }
    public Boolean getDrawYAxisLine() {
        return this.drawYAxisLine;
    }
    public void setDrawYAxisLine(Boolean drawYAxisLine) {
        this.drawYAxisLine = drawYAxisLine;
    }
    public Boolean getDrawXAxisGridLines() {
        return this.drawXAxisGridLines;
    }
    public void setDrawXAxisGridLines(Boolean drawXAxisGridLines) {
        this.drawXAxisGridLines = drawXAxisGridLines;
    }
    public Boolean getDrawYAxisGridLines() {
        return this.drawYAxisGridLines;
    }
    public void setDrawYAxisGridLines(Boolean drawYAxisGridLines) {
        this.drawYAxisGridLines = drawYAxisGridLines;
    }
    public float getXAxisGridLineWidth() {
        return this.xAxisGridLineWidth;
    }
    public void setXAxisGridLineWidth(float xAxisGridLineWidth) {
        this.xAxisGridLineWidth = xAxisGridLineWidth;
    }
    public float getYAxisGridLineWidth() {
        return this.yAxisGridLineWidth;
    }
    public void setYAxisGridLineWidth(float yAxisGridLineWidth) {
        this.yAxisGridLineWidth = yAxisGridLineWidth;
    }
    public Boolean getSetXAxisGridDashLine() {
        return this.setXAxisGridDashLine;
    }
    public void setSetXAxisGridDashLine(Boolean setXAxisGridDashLine) {
        this.setXAxisGridDashLine = setXAxisGridDashLine;
    }
    public Boolean getSetYAxisGridDashLine() {
        return this.setYAxisGridDashLine;
    }
    public void setSetYAxisGridDashLine(Boolean setYAxisGridDashLine) {
        this.setYAxisGridDashLine = setYAxisGridDashLine;
    }
    public float getTextSize() {
        return this.textSize;
    }
    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }
    public int getXAxisPosition() {
        return this.xAxisPosition;
    }
    public void setXAxisPosition(int xAxisPosition) {
        this.xAxisPosition = xAxisPosition;
    }
    public int getXAxisTextColor() {
        return this.xAxisTextColor;
    }
    public void setXAxisTextColor(int xAxisTextColor) {
        this.xAxisTextColor = xAxisTextColor;
    }
    public int getYAxisTextColor() {
        return this.yAxisTextColor;
    }
    public void setYAxisTextColor(int yAxisTextColor) {
        this.yAxisTextColor = yAxisTextColor;
    }
    public Boolean getShowLeftYAxis() {
        return this.showLeftYAxis;
    }
    public void setShowLeftYAxis(Boolean showLeftYAxis) {
        this.showLeftYAxis = showLeftYAxis;
    }
    public Boolean getShowRightYAxis() {
        return this.showRightYAxis;
    }
    public void setShowRightYAxis(Boolean showRightYAxis) {
        this.showRightYAxis = showRightYAxis;
    }
    public Boolean getDrawZeroLine() {
        return this.drawZeroLine;
    }
    public void setDrawZeroLine(Boolean drawZeroLine) {
        this.drawZeroLine = drawZeroLine;
    }
    public float getZeroLineWidth() {
        return this.zeroLineWidth;
    }
    public void setZeroLineWidth(float zeroLineWidth) {
        this.zeroLineWidth = zeroLineWidth;
    }
    public String getZeroLineColor() {
        return this.zeroLineColor;
    }
    public void setZeroLineColor(String zeroLineColor) {
        this.zeroLineColor = zeroLineColor;
    }
    public Boolean getDrawLegend() {
        return this.drawLegend;
    }
    public void setDrawLegend(Boolean drawLegend) {
        this.drawLegend = drawLegend;
    }
}
