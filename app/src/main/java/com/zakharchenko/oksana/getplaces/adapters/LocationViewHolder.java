package com.zakharchenko.oksana.getplaces.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zakharchenko.oksana.getplaces.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.location_name)
    public TextView name;


    public LocationViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}