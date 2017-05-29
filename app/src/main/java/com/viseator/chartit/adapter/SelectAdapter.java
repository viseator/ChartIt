package com.viseator.chartit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viseator.chartit.R;
import com.viseator.chartit.data.ChartDataRepository;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class SelectAdapter extends RecyclerView.Adapter {
    private ChartDataRepository mChartDataRepository;
    private Context mContext;

    public SelectAdapter(Context context) {
        mChartDataRepository = ChartDataRepository.getInstance();
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_content_label)
        TextView labelView;
        @BindView(R.id.list_content_time)
        TextView itemView;
        @BindView(R.id.list_content_data)
        TextView dataView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_content, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //// TODO: 5/29/17 load data by order

    }

    @Override
    public int getItemCount() {
        return mChartDataRepository.count();
    }
}