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
    private int maxVisiableValueCount;
    private boolean enableXAxis;
    private boolean enableYAxis;
    private boolean drawXAxisLabel;
    private boolean drawYAxisLabel;
    private boolean drawXAxisLine;
    private boolean drawYAxisLine;
    private boolean drawXAxisGridLines;
    private boolean drawYAxisGridLines;
    private String xAxisGridLineColor;
    private String yAxisGridLineColor;
    private float xAxisGridLineWidth;
    private float yAxisGridLineWidth;
    private boolean setXAxisGridDashLine;
    private boolean setYAxisGridDashLine;
    private float textSize;
    private int xAxisPosition;
    private String xAxisTextColor;
    private String yAxisTextColor;
    private boolean showLeftYAxis;
    private boolean showRightYAxis;
    private boolean drawZeroLine;
    private float zeroLineWidth;
    private String zeroLineColor;



    @Generated(hash = 371898038)
    public ChartStyleEntity(long id, String backgroundColor, String description,
            Boolean drawGrid, String gridColor, String borderColor,
            float borderWidth, int maxVisiableValueCount, boolean enableXAxis,
            boolean enableYAxis, boolean drawXAxisLabel, boolean drawYAxisLabel,
            boolean drawXAxisLine, boolean drawYAxisLine,
            boolean drawXAxisGridLines, boolean drawYAxisGridLines,
            String xAxisGridLineColor, String yAxisGridLineColor,
            float xAxisGridLineWidth, float yAxisGridLineWidth,
            boolean setXAxisGridDashLine, boolean setYAxisGridDashLine,
            float textSize, int xAxisPosition, String xAxisTextColor,
            String yAxisTextColor, boolean showLeftYAxis, boolean showRightYAxis,
            boolean drawZeroLine, float zeroLineWidth, String zeroLineColor) {
        this.id = id;
        this.backgroundColor = backgroundColor;
        this.description = description;
        this.drawGrid = drawGrid;
        this.gridColor = gridColor;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        this.maxVisiableValueCount = maxVisiableValueCount;
        this.enableXAxis = enableXAxis;
        this.enableYAxis = enableYAxis;
        this.drawXAxisLabel = drawXAxisLabel;
        this.drawYAxisLabel = drawYAxisLabel;
        this.drawXAxisLine = drawXAxisLine;
        this.drawYAxisLine = drawYAxisLine;
        this.drawXAxisGridLines = drawXAxisGridLines;
        this.drawYAxisGridLines = drawYAxisGridLines;
        this.xAxisGridLineColor = xAxisGridLineColor;
        this.yAxisGridLineColor = yAxisGridLineColor;
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
    }

    @Generated(hash = 1823078858)
    public ChartStyleEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getMaxVisiableValueCount() {
        return this.maxVisiableValueCount;
    }

    public void setMaxVisiableValueCount(int maxVisiableValueCount) {
        this.maxVisiableValueCount = maxVisiableValueCount;
    }

    public boolean getEnableXAxis() {
        return this.enableXAxis;
    }

    public void setEnableXAxis(boolean enableXAxis) {
        this.enableXAxis = enableXAxis;
    }

    public boolean getEnableYAxis() {
        return this.enableYAxis;
    }

    public void setEnableYAxis(boolean enableYAxis) {
        this.enableYAxis = enableYAxis;
    }

    public boolean getDrawXAxisLabel() {
        return this.drawXAxisLabel;
    }

    public void setDrawXAxisLabel(boolean drawXAxisLabel) {
        this.drawXAxisLabel = drawXAxisLabel;
    }

    public boolean getDrawYAxisLabel() {
        return this.drawYAxisLabel;
    }

    public void setDrawYAxisLabel(boolean drawYAxisLabel) {
        this.drawYAxisLabel = drawYAxisLabel;
    }

    public boolean getDrawXAxisLine() {
        return this.drawXAxisLine;
    }

    public void setDrawXAxisLine(boolean drawXAxisLine) {
        this.drawXAxisLine = drawXAxisLine;
    }

    public boolean getDrawYAxisLine() {
        return this.drawYAxisLine;
    }

    public void setDrawYAxisLine(boolean drawYAxisLine) {
        this.drawYAxisLine = drawYAxisLine;
    }

    public boolean getDrawXAxisGridLines() {
        return this.drawXAxisGridLines;
    }

    public void setDrawXAxisGridLines(boolean drawXAxisGridLines) {
        this.drawXAxisGridLines = drawXAxisGridLines;
    }

    public boolean getDrawYAxisGridLines() {
        return this.drawYAxisGridLines;
    }

    public void setDrawYAxisGridLines(boolean drawYAxisGridLines) {
        this.drawYAxisGridLines = drawYAxisGridLines;
    }

    public String getXAxisGridLineColor() {
        return this.xAxisGridLineColor;
    }

    public void setXAxisGridLineColor(String xAxisGridLineColor) {
        this.xAxisGridLineColor = xAxisGridLineColor;
    }

    public String getYAxisGridLineColor() {
        return this.yAxisGridLineColor;
    }

    public void setYAxisGridLineColor(String yAxisGridLineColor) {
        this.yAxisGridLineColor = yAxisGridLineColor;
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

    public boolean getSetXAxisGridDashLine() {
        return this.setXAxisGridDashLine;
    }

    public void setSetXAxisGridDashLine(boolean setXAxisGridDashLine) {
        this.setXAxisGridDashLine = setXAxisGridDashLine;
    }

    public boolean getSetYAxisGridDashLine() {
        return this.setYAxisGridDashLine;
    }

    public void setSetYAxisGridDashLine(boolean setYAxisGridDashLine) {
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

    public String getXAxisTextColor() {
        return this.xAxisTextColor;
    }

    public void setXAxisTextColor(String xAxisTextColor) {
        this.xAxisTextColor = xAxisTextColor;
    }

    public String getYAxisTextColor() {
        return this.yAxisTextColor;
    }

    public void setYAxisTextColor(String yAxisTextColor) {
        this.yAxisTextColor = yAxisTextColor;
    }

    public boolean getShowLeftYAxis() {
        return this.showLeftYAxis;
    }

    public void setShowLeftYAxis(boolean showLeftYAxis) {
        this.showLeftYAxis = showLeftYAxis;
    }

    public boolean getShowRightYAxis() {
        return this.showRightYAxis;
    }

    public void setShowRightYAxis(boolean showRightYAxis) {
        this.showRightYAxis = showRightYAxis;
    }

    public boolean getDrawZeroLine() {
        return this.drawZeroLine;
    }

    public void setDrawZeroLine(boolean drawZeroLine) {
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


}
