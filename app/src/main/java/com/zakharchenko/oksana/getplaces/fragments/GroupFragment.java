package com.zakharchenko.oksana.getplaces.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zakharchenko.oksana.getplaces.MainActivity;
import com.zakharchenko.oksana.getplaces.R;
import com.zakharchenko.oksana.getplaces.adapters.BasePlaceAdapter;
import com.zakharchenko.oksana.getplaces.adapters.LocationViewHolder;
import com.zakharchenko.oksana.getplaces.db.model.PlaceGroup;
import com.zakharchenko.oksana.getplaces.utils.Constants;
import com.zakharchenko.oksana.getplaces.viewmodel.PlaceGroupViewModel;

public class GroupFragment extends BaseFragment<PlaceGroup> {

    protected String setTitle(){
        return getContext().getResources().getString(R.string.groups);
    }

    @Override
    public void onItemClick(View view, int position, PlaceGroup item) {
        ((MainActivity)getActivity()).showListFragment(Constants.Type.SCHEMA, item.getGroupTitle());
    }

    @Override
    protected void createAdapter() {
        adapter = new BasePlaceAdapter<PlaceGroup, LocationViewHolder>() {
            @Override
            public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View view = inflater.inflate(R.layout.location_view_holder, parent, false);
                return new LocationViewHolder(view);
            }

            @Override
            public void bindItem(LocationViewHolder holder, final PlaceGroup placeGroup) {
                holder.name.setText(placeGroup.getGroupTitle());
            }
        };
    }

    @Override
    protected void createViewModel() {
        PlaceGroupViewModel model = ViewModelProviders.of(this).get(PlaceGroupViewModel.class);
        String query = getArguments().getString(Constants.QUERY);
        if (!query.isEmpty()) {
            model.getQueryData(query).observe(this, groups -> adapter.setData(groups));
        } else {
            model.getData().observe(this, groups -> adapter.setData(groups));
        }
    }

}
