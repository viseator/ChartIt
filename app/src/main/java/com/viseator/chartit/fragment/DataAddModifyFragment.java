package com.viseator.chartit.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.data.Entry;
import com.viseator.chartit.BaseFragment;
import com.viseator.chartit.R;
import com.viseator.chartit.activity.chart.linechart.LineChartActivity;
import com.viseator.chartit.adapter.DataAddAdapter;
import com.viseator.chartit.data.chart.ChartDataRepository;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viseator on 10/15/17.
 * Wu Di
 * viseator@gmail.com
 */

public class DataAddModifyFragment extends BaseFragment {
    private static final String TAG = "@vir ModifyFragment";

    @BindView(R.id.data_add_recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.generate_chart_button)
    Button mButton;
    @BindView(R.id.data_add_title)
    EditText mEditText;
    private ChartDataRepository mChartDataRepository;
    private int mPos;
    private View mView;

    private DataAddAdapter mDataAddAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mChartDataRepository = ChartDataRepository.getInstance();
        mPos = getArguments().getInt("position");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_data_add_modify, container, false);
        ButterKnife.bind(this, mView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (mPos == -1) {
            mDataAddAdapter = new DataAddAdapter(getActivity());
            mButton.setText(getResources().getString(R.string.generate_chart));
        } else {
            mDataAddAdapter = new DataAddAdapter(getActivity(), mPos);
            mButton.setText(getResources().getString(R.string.update_data));
        }
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mDataAddAdapter);

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                if (((ViewGroup) mView).getFocusedChild() != null) {
                    ((ViewGroup) mView).getFocusedChild().clearFocus();
                }
                DataAddAdapter.MainViewHolder holder = (DataAddAdapter.MainViewHolder) viewHolder;
                mDataAddAdapter.removeItem(holder.getPos());
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
        return mView;
    }

    @OnClick(R.id.generate_chart_button)
    void onClick() {
        if (((ViewGroup) mView).getFocusedChild() != null) {
            ((ViewGroup) mView).getFocusedChild().clearFocus();
        }
        if (mPos == -1) {
            List<Entry> entries = mDataAddAdapter.getEntries();
            if (entries.size() < 2) {
                Toast.makeText(getActivity(), getResources().getString(R.string.no_enough_point),
                        Toast.LENGTH_SHORT).show();
                return;
            }
            mChartDataRepository.addData(entries, mEditText.getText().toString());
            Intent intent = new Intent(getActivity(), LineChartActivity.class);
            intent.putExtra("position", mChartDataRepository.count() - 1);
            startActivity(intent);
            getActivity().finish();
        } else {
            mDataAddAdapter.saveBack(mEditText.getText().toString());
            Toast.makeText(getActivity(), getActivity().getResources().getString(R.string
                    .save_success), Toast.LENGTH_SHORT).show();
        }
    }

}
