package com.zakharchenko.oksana.getplaces.viewmodel;

import android.arch.lifecycle.LiveData;

import com.zakharchenko.oksana.getplaces.ExtApplication;
import com.zakharchenko.oksana.getplaces.db.model.PlaceGroup;

import java.util.List;

public class PlaceGroupViewModel extends BaseQueryViewModel<List<PlaceGroup>>{
    @Override
    public LiveData<List<PlaceGroup>> loadData() {
        return ExtApplication.getInstance().getAppDb().getPlaceGroupDao().getAllPlaceGroup();
    }

    @Override
    public LiveData<List<PlaceGroup>> loadDataWithQuery(String query) {
        return ExtApplication.getInstance().getAppDb().getPlaceGroupDao().findGroupsForSpecificUnion(query);
    }
}
