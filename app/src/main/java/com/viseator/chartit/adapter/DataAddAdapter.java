package com.viseator.chartit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.EntryXComparator;
import com.viseator.chartit.R;
import com.viseator.chartit.data.chart.ChartDataRepository;
import com.viseator.chartit.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.id.list;

/**
 * Created by viseator on 10/12/17.
 * Wu Di
 * viseator@gmail.com
 */

public class DataAddAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "@vir DataAddAdapter";
    public static final int TYPE_MAIN = 0x1;
    public static final int TYPE_BUTTON = 0x2;
    private int mItemIndex = 0;
    private int mLastIndex = -1;
    private int mPos;
    private Context mContext;
    private EditText mLastXEditText;
    private EditText mLastYEditText;
    private List<String> mXValues = new ArrayList<>();
    private List<Float> mYValues = new ArrayList<>();
    private ChartDataRepository mChartDataRepository;

    public DataAddAdapter(Context context) {
        mContext = context;
        mXValues.add(null);
        mYValues.add(null);
    }

    public DataAddAdapter(Context context, int pos) {
        mContext = context;
        mPos = pos;
        initData(pos);
    }

    private void initData(int pos) {
        mChartDataRepository = ChartDataRepository.getInstance();
        List<Entry> entries = (List<Entry>) mChartDataRepository.getData(pos);
        boolean isString = false;
        if (entries.get(0).getData() != null) {
            isString = true;
        }
        for (Entry e : entries) {
            mXValues.add(isString ? (String) e.getData() : String.valueOf(e.getX()));
            mYValues.add(e.getY());
        }
        mItemIndex = entries.size() - 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case TYPE_BUTTON:
                v = LayoutInflater.from(mContext).inflate(R.layout.data_add_recycerview_button,
                        parent, false);
                return new AddButtonViewHolder(v);
            case TYPE_MAIN:
                v = LayoutInflater.from(mContext).inflate(R.layout
                                .data_add_recycerview_content,
                        parent, false);
                return new MainViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        EditText.OnFocusChangeListener onFocusChangeListener = new EditText.OnFocusChangeListener
                () {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                EditText editText = (EditText) v;
                if (!hasFocus) {
                    saveToValueArray(editText, position);
                }
            }
        };

        switch (holder.getItemViewType()) {
            case TYPE_BUTTON:
                AddButtonViewHolder buttonHolder = (AddButtonViewHolder) holder;
                buttonHolder.mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mLastIndex = mItemIndex++;
                        mXValues.add(null);
                        mYValues.add(null);
                        notifyDataSetChanged();
                    }
                });
                break;
            case TYPE_MAIN:
                MainViewHolder viewHolder = (MainViewHolder) holder;
                viewHolder.setPos(position);
                EditText xEditText = viewHolder.mXEditText;
                EditText yEditText = viewHolder.mYEditText;
                xEditText.setOnFocusChangeListener(onFocusChangeListener);
                yEditText.setOnFocusChangeListener(onFocusChangeListener);
                if (position == mLastIndex) {
                    mLastXEditText = xEditText;
                    mLastYEditText = yEditText;
                }
                if (mItemIndex == 0) {
                    xEditText.requestFocus();
                }
                if (position == mItemIndex && mLastIndex != -1) {
                    xEditText.setText(mLastXEditText.getText());
                    yEditText.setText(mLastYEditText.getText());
                    if (Utils.isNumeric(mLastXEditText.getText().toString())) {
                        xEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                    }
                    xEditText.requestFocus();
                    xEditText.selectAll();
                    saveToValueArray(xEditText, position);
                    saveToValueArray(yEditText, position);
                    mLastIndex = -1;
                    mLastXEditText = null;
                    mLastYEditText = null;
                } else {
                    if (mXValues.get(position) != null) {
                        xEditText.setText(mXValues.get(position));
                    }
                    if (mYValues.get(position) != null) {
                        yEditText.setText(mYValues.get(position).toString());
                    }
                }
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == mItemIndex + 1) {
            return TYPE_BUTTON;
        }
        return TYPE_MAIN;
    }

    @Override
    public int getItemCount() {
        return mItemIndex + 2;
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.x_editText)
        EditText mXEditText;
        @BindView(R.id.y_editText)
        EditText mYEditText;

        int mPos;
        View itemView;

        public void setPos(int pos) {
            mPos = pos;
        }

        public int getPos() {
            return mPos;
        }

        public MainViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
            mXEditText.setTag("X");
            mYEditText.setTag("Y");
        }
    }

    public static class AddButtonViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.add_data_recyclerView_button)
        Button mButton;

        View itemView;

        public AddButtonViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

    private void saveToValueArray(EditText v, int position) {
        if (v.getTag().equals("X"))
            mXValues.set(position, v.getText().toString());
        else if (!Objects.equals(v.getText().toString(), "")) {
            mYValues.set(position, Float.valueOf(v.getText().toString()));
        }
    }

    public void saveBack(String label) {
        mChartDataRepository.updateData(mPos, getEntries(), label);
    }

    public List<Entry> getEntries() {
        boolean isString = false;
        List<Entry> result = new ArrayList<>(mItemIndex + 1);
        for (String s : mXValues) {
            if (!Utils.isNumeric(s)) {
                isString = true;
                break;
            }
        }
        for (int i = 0; i < mItemIndex + 1; i++) {
            if (mXValues.get(i) == null || mYValues.get(i) == null) {
                return null;
            }
            if (isString) {
                Entry entry = new Entry(i, mYValues.get(i));
                entry.setData(mXValues.get(i));
                result.add(entry);
            } else {
                Entry entry = new Entry(Float.valueOf(mXValues.get(i)), mYValues.get(i));
                result.add(entry);
            }
        }
        Collections.sort(result, new EntryXComparator());
        return result;
    }

    public void removeItem(int pos) {
        if (mItemIndex == 1) {
            Toast.makeText(mContext, mContext.getString(R.string.least_one_data), Toast
                    .LENGTH_SHORT).show();
            return;
        }
        --mItemIndex;
        mXValues.remove(pos);
        mYValues.remove(pos);
        notifyItemRemoved(pos);
        notifyDataSetChanged();
    }
}

