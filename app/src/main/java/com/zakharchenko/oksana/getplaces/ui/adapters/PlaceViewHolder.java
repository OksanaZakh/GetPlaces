package com.zakharchenko.oksana.getplaces.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zakharchenko.oksana.getplaces.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlaceViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvName)
    public TextView tvName;

    @BindView(R.id.tvCode)
    public TextView tvCode;

    @BindView(R.id.tvLeft)
    public TextView tvLeft;

    @BindView(R.id.tvTop)
    public TextView tvTop;

    @BindView(R.id.tvWidth)
    public TextView tvWidth;

    @BindView(R.id.tvHeight)
    public TextView tvHeight;

    @BindView(R.id.tvCorner)
    public TextView tvCorner;

    @BindView(R.id.tvShapeType)
    public TextView tvShapeType;

    @BindView(R.id.tvColor)
    public TextView tvColor;

    @BindView(R.id.tvShapeOrient)
    public TextView tvShapeOrient;

    @BindView(R.id.tvStyle)
    public TextView tvStyle;

    @BindView(R.id.tvFontColor)
    public TextView tvFontColor;

    @BindView(R.id.tvFrameColor)
    public TextView tvFrameColor;


    public PlaceViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
