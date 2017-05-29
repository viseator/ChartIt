package com.viseator.chartit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.data.Entry;
import com.viseator.chartit.R;
import com.viseator.chartit.data.ChartDataRepository;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class SelectAdapter extends RecyclerView.Adapter<SelectAdapter.ViewHolder> {
    private ChartDataRepository mChartDataRepository;
    private Context mContext;

    public SelectAdapter(Context context) {
        mChartDataRepository = ChartDataRepository.getInstance();
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_content_data)
        TextView dataView;
        @BindView(R.id.list_content_label)
        TextView labelView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public SelectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.data_recyclerview_content, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.labelView.setText(mChartDataRepository.getLabel(position));
        List<Entry> data = (List<Entry>) mChartDataRepository.getData(position);
        StringBuilder sb = new StringBuilder();
        for (Entry entry : data) {
            sb.append(entry.getX() + ":" + entry.getY() + " ");
        }
        holder.dataView.setText(sb);
    }

    @Override
    public int getItemCount() {
        return mChartDataRepository.count();
    }
}
