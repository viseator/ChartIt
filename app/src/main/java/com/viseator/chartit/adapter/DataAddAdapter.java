package com.viseator.chartit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.viseator.chartit.R;

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
    private Context mContext;

    public DataAddAdapter(Context context) {
        mContext = context;
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case TYPE_BUTTON:
                break;
            case TYPE_MAIN:
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
}
