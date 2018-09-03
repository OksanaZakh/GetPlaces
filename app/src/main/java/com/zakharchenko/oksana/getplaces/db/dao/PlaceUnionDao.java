package com.zakharchenko.oksana.getplaces.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.zakharchenko.oksana.getplaces.db.model.PlaceUnion;

import java.util.List;

@Dao
public abstract class PlaceUnionDao extends BasePlaceDao<PlaceUnion> {

    @Override
    public Class<PlaceUnion> getEntity() {
        return PlaceUnion.class;
    }

    @Query("SELECT * FROM placeunion")
    public abstract LiveData<List<PlaceUnion>> getAllUnions();
}
