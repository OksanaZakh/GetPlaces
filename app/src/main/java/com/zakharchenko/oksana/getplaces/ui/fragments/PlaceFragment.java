package com.zakharchenko.oksana.getplaces.ui.fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zakharchenko.oksana.getplaces.ui.MainActivity;
import com.zakharchenko.oksana.getplaces.R;
import com.zakharchenko.oksana.getplaces.ui.adapters.BasePlaceAdapter;
import com.zakharchenko.oksana.getplaces.ui.adapters.PlaceViewHolder;
import com.zakharchenko.oksana.getplaces.db.model.Place;
import com.zakharchenko.oksana.getplaces.utils.Constants;
import com.zakharchenko.oksana.getplaces.viewmodel.PlaceViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceFragment extends BaseFragment<Place> {

    protected String setTitle() {
        return getContext().getResources().getString(R.string.places);
    }

    @Override
    public void onItemClick(View view, int position, Place item) {
        ((MainActivity) getActivity()).showListFragment(Constants.Type.BILL, item.getCode());
    }

    @Override
    protected void createAdapter() {

        adapter = new BasePlaceAdapter<Place, PlaceViewHolder>() {
            @Override
            public void bindItem(PlaceViewHolder holder, Place item) {
                holder.tvName.setText(item.getName());
                holder.tvCode.setText(item.getCode());
                holder.tvLeft.setText(item.getLeft().toString());
                holder.tvTop.setText(item.getTop().toString());
                holder.tvWidth.setText(item.getWidth().toString());
                holder.tvHeight.setText(item.getHeight().toString());
                holder.tvShapeType.setText(item.getShapeType().toString());
                holder.tvShapeOrient.setText(item.getShapeOrient().toString());
                holder.tvColor.setText(item.getColor().toString());
                holder.tvStyle.setText(item.getStyle().toString());
                holder.tvFrameColor.setText(item.getFrameColor().toString());
                holder.tvFontColor.setText(item.getFontColor().toString());
            }

            @Override
            public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View view = inflater.inflate(R.layout.place_view_holder, parent, false);
                return new PlaceViewHolder(view);
            }
        };
    }

    @Override
    protected void createViewModel() {
        PlaceViewModel model = ViewModelProviders.of(this).get(PlaceViewModel.class);
        String query = getArguments().getString(Constants.QUERY);
        if (!query.isEmpty()) {
            model.getQueryData(query).observe(this, groups -> adapter.setData(groups));
        } else {
            model.getData().observe(this, groups -> adapter.setData(groups));
        }
    }

}
