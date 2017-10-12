package com.viseator.chartit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.viseator.chartit.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by viseator on 10/12/17.
 * Wu Di
 * viseator@gmail.com
 */

public class DataAddAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_MAIN = 0x1;
    public static final int TYPE_BUTTON = 0x2;
    private int mItemIndex = 0;
    private int mLastIndex = -1;
    private Context mContext;
    private EditText mLastXEditText;
    private EditText mLastYEditText;
    private List<String> mXValues = new ArrayList<>();
    private List<Float> mYValues = new ArrayList<>();

    public DataAddAdapter(Context context) {
        mContext = context;
        mXValues.add(null);
        mYValues.add(null);
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
                EditText xEditText = viewHolder.mXEditText;
                EditText yEditText = viewHolder.mYEditText;
                xEditText.setOnFocusChangeListener(onFocusChangeListener);
                yEditText.setOnFocusChangeListener(onFocusChangeListener);
                if (position == mLastIndex) {
                    mLastXEditText = xEditText;
                    mLastYEditText = yEditText;
                }
                if (position == mItemIndex && mLastIndex != -1) {
                    xEditText.setText(mLastXEditText.getText());
                    yEditText.setText(mLastYEditText.getText());
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

        View itemView;

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
        try {
            if (v.getTag().equals("X"))
                mXValues.set(position, v.getText().toString());
            else mYValues.set(position, Float.valueOf(v.getText().toString()));
        } catch (NumberFormatException e) {
            Toast.makeText(mContext, mContext.getString(R.string.not_float), Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
