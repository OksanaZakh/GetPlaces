package com.zakharchenko.oksana.getplaces.viewmodel;

import android.arch.lifecycle.LiveData;

import com.zakharchenko.oksana.getplaces.ExtApplication;
import com.zakharchenko.oksana.getplaces.db.model.Place;

import java.util.List;

public class PlaceViewModel extends BaseQueryViewModel<List<Place>> {
    @Override
    public LiveData<List<Place>> loadData() {
        return ExtApplication.getInstance().getAppDb().getPlaceDao().getAllPlaces();
    }

    @Override
    public LiveData<List<Place>> loadDataWithQuery(String schemaId) {
        return ExtApplication.getInstance().getAppDb().getPlaceDao().findPlacesForSpecificSchema(schemaId);
    }
}
