package com.viseator.chartit.listener;

import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

/**
 * Created by viseator on 9/17/17.
 * Wu Di
 * viseator@gmail.com
 */

public class LineChartTouchListener extends BarLineChartTouchListener {

    private Entry mTouchingEntry;
    private ViewPortHandler mViewPortHandler;
    private float mSaveY;
    private float mContentHeight;
    private float mChartHeight;
    private float mChartYValueRange = mChart.getYChartMax() - mChart.getYChartMin();
    private static final String TAG = "@vir TouchListener";

    /**
     * Constructor with initialization parameters.
     *
     * @param chart               instance of the chart
     * @param touchMatrix         the touch-matrix of the chart
     * @param dragTriggerDistance the minimum movement distance that will be interpreted as a
     *                            "drag" gesture in dp (3dp equals
     */
    public LineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<?
            extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> chart, Matrix
                                          touchMatrix, float dragTriggerDistance) {
        super(chart, touchMatrix, dragTriggerDistance);
        mViewPortHandler = mChart.getViewPortHandler();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        mContentHeight = mViewPortHandler.contentHeight();
        mChartHeight = mChart.getHeight();
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(event);

        if (event.getActionMasked() == MotionEvent.ACTION_CANCEL) {
            if (mVelocityTracker != null) {
                mVelocityTracker.recycle();
                mVelocityTracker = null;
            }
        }

        if (mTouchMode == NONE) {
            mGestureDetector.onTouchEvent(event);
        }

        if (!mChart.isDragEnabled() && (!mChart.isScaleXEnabled() && !mChart.isScaleYEnabled()))
            return true;

        // Handle touch events here...
        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_DOWN:

                startAction(event);

                stopDeceleration();

                saveTouchStart(event);

                break;
            case MotionEvent.ACTION_POINTER_DOWN:

                if (event.getPointerCount() >= 2) {

                    mChart.disableScroll();

                    saveTouchStart(event);

                    // get the distance between the pointers on the x-axis
                    mSavedXDist = getXDist(event);

                    // get the distance between the pointers on the y-axis
                    mSavedYDist = getYDist(event);

                    // get the total distance between the pointers
                    mSavedDist = spacing(event);

                    if (mSavedDist > 10f) {

                        if (mChart.isPinchZoomEnabled()) {
                            mTouchMode = PINCH_ZOOM;
                        } else {
                            if (mChart.isScaleXEnabled() != mChart.isScaleYEnabled()) {
                                mTouchMode = mChart.isScaleXEnabled() ? X_ZOOM : Y_ZOOM;
                            } else {
                                mTouchMode = mSavedXDist > mSavedYDist ? X_ZOOM : Y_ZOOM;
                            }
                        }
                    }

                    // determine the touch-pointer center
                    midPoint(mTouchPointCenter, event);
                }
                break;
            case MotionEvent.ACTION_MOVE:

                if (mTouchMode == VALUE_DRAG) {
                    // in the mode which can modify data by drag
                    performValueDrag(event);
                } else if (mTouchMode == DRAG) {

                    mChart.disableScroll();
                    performDrag(event);

                } else if (mTouchMode == X_ZOOM || mTouchMode == Y_ZOOM || mTouchMode ==
                        PINCH_ZOOM) {

                    mChart.disableScroll();

                    if (mChart.isScaleXEnabled() || mChart.isScaleYEnabled())
                        performZoom(event);

                } else if (mTouchMode == NONE
                        && Math.abs(distance(event.getX(), mTouchStartPoint.x, event.getY(),
                        mTouchStartPoint.y)) > mDragTriggerDist) {

                    if (mChart.hasNoDragOffset()) {
                        if (mLastGesture == ChartGesture.DOUBLE_TAP) {
                            mTouchMode = VALUE_DRAG;
                            Log.d(TAG, String.valueOf("enter value drag"));
                        } else if (!mChart.isFullyZoomedOut() && mChart.isDragEnabled()) {
                            mTouchMode = DRAG;
                        } else {

                            mLastGesture = ChartGesture.DRAG;

                            if (mChart.isHighlightPerDragEnabled())
                                performHighlightDrag(event);
                        }

                    } else if (mChart.isDragEnabled()) {
                        mLastGesture = ChartGesture.DRAG;
                        mTouchMode = DRAG;
                    }
                }
                break;

            case MotionEvent.ACTION_UP:

                mTouchingEntry = null;
                final VelocityTracker velocityTracker = mVelocityTracker;
                final int pointerId = event.getPointerId(0);
                velocityTracker.computeCurrentVelocity(1000, Utils.getMaximumFlingVelocity());
                final float velocityY = velocityTracker.getYVelocity(pointerId);
                final float velocityX = velocityTracker.getXVelocity(pointerId);

                if (Math.abs(velocityX) > Utils.getMinimumFlingVelocity() ||
                        Math.abs(velocityY) > Utils.getMinimumFlingVelocity()) {

                    if (mTouchMode == DRAG && mChart.isDragDecelerationEnabled()) {

                        stopDeceleration();

                        mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();

                        mDecelerationCurrentPoint.x = event.getX();
                        mDecelerationCurrentPoint.y = event.getY();

                        mDecelerationVelocity.x = velocityX;
                        mDecelerationVelocity.y = velocityY;

                        Utils.postInvalidateOnAnimation(mChart); // This causes computeScroll to
                        // fire, recommended for this by
                        // Google
                    }
                }

                if (mTouchMode == X_ZOOM ||
                        mTouchMode == Y_ZOOM ||
                        mTouchMode == PINCH_ZOOM ||
                        mTouchMode == POST_ZOOM) {

                    // Range might have changed, which means that Y-axis labels
                    // could have changed in size, affecting Y-axis size.
                    // So we need to recalculate offsets.
                    mChart.calculateOffsets();
                    mChart.postInvalidate();
                }

                mTouchMode = NONE;
                mChart.enableScroll();

                if (mVelocityTracker != null) {
                    mVelocityTracker.recycle();
                    mVelocityTracker = null;
                }

                endAction(event);

                break;
            case MotionEvent.ACTION_POINTER_UP:
                Utils.velocityTrackerPointerUpCleanUpIfNecessary(event, mVelocityTracker);

                mTouchMode = POST_ZOOM;
                break;

            case MotionEvent.ACTION_CANCEL:

                mTouchMode = NONE;
                endAction(event);
                break;
        }

        // perform the transformation, update the chart
        mMatrix = mChart.getViewPortHandler().refresh(mMatrix, mChart, true);

        return true; // indicate event was handled
    }


    @Override
    public boolean onDoubleTap(MotionEvent e) {
        mLastGesture = ChartGesture.DOUBLE_TAP;
        mTouchingEntry = mChart.getEntryByTouchPoint(e.getX(), e.getY());
        if (mTouchingEntry != null) {
            mSaveY = mTouchingEntry.getY();
        }
        if (mTouchingEntry != null) {
            Log.d(TAG, mTouchingEntry.toString());
        }
        return false;
    }

    /**
     * Perform the drag by motion event
     *
     * @param event
     */
    private void performValueDrag(MotionEvent event) {
        mLastGesture = ChartGesture.VALUE_DRAG;
        OnChartGestureListener l = mChart.getOnChartGestureListener();
        float dX, dY;
        // check if axis is inverted
        if (inverted()) {

            // if there is an inverted horizontalbarchart
            if (mChart instanceof HorizontalBarChart) {
                dX = -(event.getX() - mTouchStartPoint.x);
                dY = event.getY() - mTouchStartPoint.y;
            } else {
                dX = event.getX() - mTouchStartPoint.x;
                dY = -(event.getY() - mTouchStartPoint.y);
            }
        } else {
            dX = event.getX() - mTouchStartPoint.x;
            dY = event.getY() - mTouchStartPoint.y;
        }

//        Log.d(TAG, String.valueOf(mViewPortHandler.getTransY()));
//        Log.d(TAG, String.valueOf(mViewPortHandler.getScaleY() * mContentHeight));
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (mTouchingEntry != null) {
            // update the value of the touching entry
            mTouchingEntry.setY(mSaveY + getValueDelta(dY));
            // the factor of the point we touched on the screen
            float factor = (event.getY() - mChart.getY()) / mContentHeight;
            // if the point we touched at the top 20% of screen
            if (factor < 0.2) {
                // if not reached the max of Y
                float scrollSpeed = 0.001f + ((0.2f - factor) / 0.2f) * 0.01f;
                if (mViewPortHandler.getTransY() + mContentHeight < mViewPortHandler.getScaleY() *
                        mContentHeight) {

                    float dValueY = Float.valueOf(decimalFormat.format(mChartYValueRange *
                            scrollSpeed));
                    mTouchingEntry.setY(mTouchingEntry.getY() + dValueY);
                    mSaveY = mSaveY + dValueY;
                    mChart.centerViewToY(mTouchingEntry.getY() - Math.abs(getValueDelta
                            (mContentHeight / 2 - event.getY())), mChart.getAxisLeft()
                            .getAxisDependency());
                } else {
                    // reached the max of Y
                    // TODO: 10/10/17 extend the Y axis
                }
            } else if (factor > 0.8) {
                // if the point we touched at the bottom 20% of screen
                float scrollSpeed = 0.001f + ((factor - 0.8f) / 0.2f) * 0.01f;
                if (mViewPortHandler.getTransY() > 0) {
                    // if not reached the bottom of Y
                    float dValueY = Float.valueOf(decimalFormat.format(mChartYValueRange *
                            scrollSpeed));
                    mTouchingEntry.setY(mTouchingEntry.getY() - dValueY);
                    mSaveY = mSaveY - dValueY;
                    mChart.centerViewToY(mTouchingEntry.getY() + (getValueDelta
                            (mContentHeight / 2 - event.getY())), mChart.getAxisLeft()
                            .getAxisDependency());
                } else {
                    // TODO: 10/10/17 extend the Y axis
                }
            }
            mChart.notifyDataSetChanged();
        }
        if (l != null)
            l.onChartTranslate(event, dX, dY);
    }

    /**
     * Map the dY to the delta of value in Y value
     *
     * @param dY
     * @return the mapped value
     */
    private float getValueDelta(float dY) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        float rawData = -dY / mContentHeight / mViewPortHandler.getScaleY() * mChartYValueRange;
        return Float.valueOf(decimalFormat.format(rawData));
    }
}


