package com.zakharchenko.oksana.getplaces.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zakharchenko.oksana.getplaces.R;
import com.zakharchenko.oksana.getplaces.ui.adapters.BasePlaceAdapter;
import com.zakharchenko.oksana.getplaces.ui.adapters.BillViewHolder;
import com.zakharchenko.oksana.getplaces.db.model.Bill;
import com.zakharchenko.oksana.getplaces.utils.Constants;
import com.zakharchenko.oksana.getplaces.viewmodel.BillViewModel;

public class BillFragment extends BaseFragment<Bill> {

    protected String setTitle(){
        return getContext().getResources().getString(R.string.bills);
    }

    @Override
    public void onItemClick(View view, int position, Bill item) {
    }

    @Override
    protected void createAdapter() {
        adapter = new BasePlaceAdapter<Bill, BillViewHolder>() {
            @Override
            public BillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View view = inflater.inflate(R.layout.bill_view_holder, parent, false);
                return new BillViewHolder(view);
            }

            @Override
            public void bindItem(BillViewHolder holder, final Bill bill) {
                holder.tvId.setText(bill.getId().toString());
                holder.tvNumber.setText(bill.getNumber().toString());
                holder.tvOpened.setText(bill.getOpened());
                holder.tvOpenUser.setText(bill.getOpenUser());
                holder.tvTotal.setText(bill.getTotal().toString());
            }
        };
    }

    @Override
    protected void createViewModel() {
        BillViewModel model = ViewModelProviders.of(this).get(BillViewModel.class);
        String query = getArguments().getString(Constants.QUERY);
        if (!query.isEmpty()) {
            model.getQueryData(query).observe(this, groups -> adapter.setData(groups));
        } else {
            model.getData().observe(this, groups -> adapter.setData(groups));
        }
    }

}

