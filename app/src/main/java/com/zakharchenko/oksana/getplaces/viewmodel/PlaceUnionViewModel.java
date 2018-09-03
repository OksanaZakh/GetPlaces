package com.zakharchenko.oksana.getplaces.viewmodel;

import android.arch.lifecycle.LiveData;

import com.zakharchenko.oksana.getplaces.ExtApplication;
import com.zakharchenko.oksana.getplaces.db.model.PlaceUnion;

import java.util.List;

public class PlaceUnionViewModel extends BaseViewModel<List<PlaceUnion>> {
    @Override
    public LiveData<List<PlaceUnion>> loadData() {
        return ExtApplication.getInstance().getAppDb().getPlaceUnionDao().getAllUnions();
    }
}
