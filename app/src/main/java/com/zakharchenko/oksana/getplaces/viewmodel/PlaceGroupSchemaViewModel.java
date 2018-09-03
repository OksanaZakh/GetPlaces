package com.zakharchenko.oksana.getplaces.viewmodel;

import android.arch.lifecycle.LiveData;

import com.zakharchenko.oksana.getplaces.ui.ExtApplication;
import com.zakharchenko.oksana.getplaces.db.model.PlaceGroupSchema;

import java.util.List;

public class PlaceGroupSchemaViewModel extends BaseQueryViewModel<List<PlaceGroupSchema>> {

    private static final String TAG = "PlaceGroupSchemaViewMod";

    @Override
    public LiveData<List<PlaceGroupSchema>> loadData() {
        return ExtApplication.getInstance().getAppDb().getPlaceGroupSchemaDao().getAllPlaceGroupSchema();
    }

    @Override
    public LiveData<List<PlaceGroupSchema>> loadDataWithQuery(String query) {
        return ExtApplication.getInstance().getAppDb().getPlaceGroupSchemaDao().findSchemaForSpecificGroup(query);
    }

}
