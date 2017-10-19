package com.viseator.chartit.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viseator.chartit.R;
import com.viseator.chartit.activity.chart.linechart.LineChartActivity;
import com.viseator.chartit.data.chart.ChartDataRepository;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class SelectAdapter extends RecyclerView.Adapter<SelectAdapter.ViewHolder> {
    private static final String TAG = "@vir SelectAdapter";
    private ChartDataRepository mChartDataRepository;
    private Context mContext;
    Intent mIntent;

    public SelectAdapter(Context context) {
        mChartDataRepository = ChartDataRepository.getInstance();
        mContext = context;
        mIntent = new Intent(mContext, LineChartActivity.class);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_content_label)
        TextView labelView;

        View itemView;

        int mPos;

        public int getPos() {
            return mPos;
        }

        public void setPos(int pos) {
            mPos = pos;
        }

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

    public SelectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.data_recyclerview_content,
                parent, false);
        return new ViewHolder(v);
    }

    public void setTargetActivity(Class<?> targetActivity) {
        mIntent = new Intent(mContext, targetActivity);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String label = mChartDataRepository.getLabel(position);
        holder.labelView.setText(label);
        holder.setPos(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent.putExtra("position", position);
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mChartDataRepository.count();
    }

    public void removeItem(int pos){
        mChartDataRepository.removeData(pos);
        notifyItemRemoved(pos);
        notifyDataSetChanged();
    }
}
