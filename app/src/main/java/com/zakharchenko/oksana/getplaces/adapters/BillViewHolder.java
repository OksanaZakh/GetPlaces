package com.zakharchenko.oksana.getplaces.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zakharchenko.oksana.getplaces.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BillViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvId)
    public TextView tvId;

    @BindView(R.id.tvNumber)
    public TextView tvNumber;

    @BindView(R.id.tvOpened)
    public TextView tvOpened;

    @BindView(R.id.tvTotal)
    public TextView tvTotal;

    @BindView(R.id.tvOpenUser)
    public TextView tvOpenUser;


    public BillViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}