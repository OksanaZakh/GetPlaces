package com.zakharchenko.oksana.getplaces.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zakharchenko.oksana.getplaces.ui.MainActivity;
import com.zakharchenko.oksana.getplaces.R;
import com.zakharchenko.oksana.getplaces.ui.adapters.BasePlaceAdapter;
import com.zakharchenko.oksana.getplaces.ui.adapters.LocationViewHolder;
import com.zakharchenko.oksana.getplaces.db.model.PlaceGroupSchema;
import com.zakharchenko.oksana.getplaces.utils.Constants;
import com.zakharchenko.oksana.getplaces.viewmodel.PlaceGroupSchemaViewModel;


public class SchemaFragment extends BaseFragment<PlaceGroupSchema> {
    private static final String TAG = "SchemaFragment";

    @Override
    public void onItemClick(View view, int position, PlaceGroupSchema item) {
        ((MainActivity) getActivity()).showListFragment(Constants.Type.PLACE, item.getSchemaTitle());
    }

    protected void createAdapter() {
        adapter = new BasePlaceAdapter<PlaceGroupSchema, LocationViewHolder>() {
            @Override
            public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View view = inflater.inflate(R.layout.location_view_holder, parent, false);
                return new LocationViewHolder(view);
            }

            @Override
            public void bindItem(LocationViewHolder holder, final PlaceGroupSchema schema) {
                holder.name.setText(schema.getSchemaTitle());
            }
        };
    }

    protected void createViewModel() {
        PlaceGroupSchemaViewModel model = ViewModelProviders.of(this).get(PlaceGroupSchemaViewModel.class);
        String query = getArguments().getString(Constants.QUERY);
        Log.d(TAG, "createViewModel: "+query);
        if (!query.isEmpty()) {
            model.getQueryData(query).observe(this, groups -> adapter.setData(groups));
        } else {
            model.getData().observe(this, groups -> adapter.setData(groups));
        }
    }

    protected String setTitle(){
        return getContext().getResources().getString(R.string.schemas);
    }

}

