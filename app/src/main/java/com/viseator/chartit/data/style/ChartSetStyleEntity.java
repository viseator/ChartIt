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
public class ChartSetStyleEntity {
    @Id(autoincrement = true)
    Long id;
    private int position;


    private String valueTextColor;
    private float valueTextSize;

    private Boolean drawValues;

    private String highlightColor;
    private float highlightLineWidth;

    private String fillColor;
    private int fillAlpha;

    private float lineWidth;
    private float circleRadius;
    private Boolean drawCircles;
    private String circleColor;
    private Boolean drawCircleHole;
    private Boolean enableDashedLine;
    private float barSpacePercent;
    private String barShadowColor;

    @Generated(hash = 1967214164)
    public ChartSetStyleEntity(Long id, int position, String valueTextColor, float valueTextSize,
                               Boolean drawValues, String highlightColor, float highlightLineWidth, String fillColor,
                               int fillAlpha, float lineWidth, float circleRadius, Boolean drawCircles, String circleColor,
                               Boolean drawCircleHole, Boolean enableDashedLine, float barSpacePercent,
                               String barShadowColor) {
        this.id = id;
        this.position = position;
        this.valueTextColor = valueTextColor;
        this.valueTextSize = valueTextSize;
        this.drawValues = drawValues;
        this.highlightColor = highlightColor;
        this.highlightLineWidth = highlightLineWidth;
        this.fillColor = fillColor;
        this.fillAlpha = fillAlpha;
        this.lineWidth = lineWidth;
        this.circleRadius = circleRadius;
        this.drawCircles = drawCircles;
        this.circleColor = circleColor;
        this.drawCircleHole = drawCircleHole;
        this.enableDashedLine = enableDashedLine;
        this.barSpacePercent = barSpacePercent;
        this.barShadowColor = barShadowColor;
    }

    @Generated(hash = 120924000)
    public ChartSetStyleEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getValueTextColor() {
        return this.valueTextColor;
    }

    public void setValueTextColor(String valueTextColor) {
        this.valueTextColor = valueTextColor;
    }

    public float getValueTextSize() {
        return this.valueTextSize;
    }

    public void setValueTextSize(float valueTextSize) {
        this.valueTextSize = valueTextSize;
    }

    public Boolean getDrawValues() {
        return this.drawValues;
    }

    public void setDrawValues(Boolean drawValues) {
        this.drawValues = drawValues;
    }

    public String getHighlightColor() {
        return this.highlightColor;
    }

    public void setHighlightColor(String highlightColor) {
        this.highlightColor = highlightColor;
    }

    public float getHighlightLineWidth() {
        return this.highlightLineWidth;
    }

    public void setHighlightLineWidth(float highlightLineWidth) {
        this.highlightLineWidth = highlightLineWidth;
    }

    public String getFillColor() {
        return this.fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public int getFillAlpha() {
        return this.fillAlpha;
    }

    public void setFillAlpha(int fillAlpha) {
        this.fillAlpha = fillAlpha;
    }

    public float getLineWidth() {
        return this.lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public float getCircleRadius() {
        return this.circleRadius;
    }

    public void setCircleRadius(float circleRadius) {
        this.circleRadius = circleRadius;
    }

    public Boolean getDrawCircles() {
        return this.drawCircles;
    }

    public void setDrawCircles(Boolean drawCircles) {
        this.drawCircles = drawCircles;
    }

    public String getCircleColor() {
        return this.circleColor;
    }

    public void setCircleColor(String circleColor) {
        this.circleColor = circleColor;
    }

    public Boolean getDrawCircleHole() {
        return this.drawCircleHole;
    }

    public void setDrawCircleHole(Boolean drawCircleHole) {
        this.drawCircleHole = drawCircleHole;
    }

    public Boolean getEnableDashedLine() {
        return this.enableDashedLine;
    }

    public void setEnableDashedLine(Boolean enableDashedLine) {
        this.enableDashedLine = enableDashedLine;
    }

    public float getBarSpacePercent() {
        return this.barSpacePercent;
    }

    public void setBarSpacePercent(float barSpacePercent) {
        this.barSpacePercent = barSpacePercent;
    }

    public String getBarShadowColor() {
        return this.barShadowColor;
    }

    public void setBarShadowColor(String barShadowColor) {
        this.barShadowColor = barShadowColor;
    }

}
