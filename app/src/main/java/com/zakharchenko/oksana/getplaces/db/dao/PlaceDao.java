package com.zakharchenko.oksana.getplaces.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.zakharchenko.oksana.getplaces.db.model.Bill;
import com.zakharchenko.oksana.getplaces.db.model.Place;

import java.util.List;

@Dao
public abstract class PlaceDao extends BasePlaceDao<Place> {

    @Override
    public Class getEntity() {
        return Place.class;
    }

    @Query("SELECT * FROM place")
    public abstract LiveData<List<Place>> getAllPlaces();

    @Query("SELECT * FROM place WHERE schemaName=:schemaId")
    public abstract LiveData<List<Place>> findPlacesForSpecificSchema(final String schemaId);
}
