package com.zakharchenko.oksana.getplaces.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zakharchenko.oksana.getplaces.R;
import com.zakharchenko.oksana.getplaces.adapters.BasePlaceAdapter;


import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseFragment<T> extends Fragment implements OnItemClickListener<T> {

    @BindView(R.id.rvList)
    protected RecyclerView rvList;

    protected BasePlaceAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createViewModel();
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        createAdapter();
        adapter.setOnItemClickListener(this);
        rvList.setAdapter(adapter);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(setTitle());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    protected abstract void createAdapter();

    protected abstract void createViewModel();

    protected abstract String setTitle();
}
