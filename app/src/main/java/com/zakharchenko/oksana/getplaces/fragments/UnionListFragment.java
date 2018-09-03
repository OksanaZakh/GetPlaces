package com.zakharchenko.oksana.getplaces.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zakharchenko.oksana.getplaces.MainActivity;
import com.zakharchenko.oksana.getplaces.R;
import com.zakharchenko.oksana.getplaces.adapters.BasePlaceAdapter;
import com.zakharchenko.oksana.getplaces.adapters.LocationViewHolder;

import com.zakharchenko.oksana.getplaces.db.model.PlaceUnion;
import com.zakharchenko.oksana.getplaces.utils.Constants;
import com.zakharchenko.oksana.getplaces.viewmodel.PlaceUnionViewModel;


public class UnionListFragment extends BaseFragment<PlaceUnion> {

    @Override
    public void onItemClick(View view, int position, PlaceUnion item) {
        ((MainActivity)getActivity()).showListFragment(Constants.Type.GROUP, item.getUnionTitle());
    }

    protected void createAdapter(){
        adapter = new BasePlaceAdapter<PlaceUnion, LocationViewHolder>(){
            @Override
            public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View view = inflater.inflate(R.layout.location_view_holder, parent, false);
                return new LocationViewHolder(view);
            }
            @Override
            public void bindItem(LocationViewHolder holder, final PlaceUnion placeUnion) {
                holder.name.setText(placeUnion.getUnionTitle());
            }
        };
    }

    protected void createViewModel(){
        PlaceUnionViewModel model = ViewModelProviders.of(this).get(PlaceUnionViewModel.class);
        model.getData().observe(this, unions -> adapter.setData(unions));
    }

    protected String setTitle(){
        return getContext().getResources().getString(R.string.unions);
    }

}
