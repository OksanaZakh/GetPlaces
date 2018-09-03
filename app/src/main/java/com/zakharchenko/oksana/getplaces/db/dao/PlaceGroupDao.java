package com.zakharchenko.oksana.getplaces.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.zakharchenko.oksana.getplaces.db.model.PlaceGroup;
import com.zakharchenko.oksana.getplaces.db.model.PlaceGroupSchema;

import java.util.List;

@Dao
public abstract class PlaceGroupDao extends BasePlaceDao<PlaceGroup> {

    @Override
    public Class<PlaceGroup> getEntity() {
        return PlaceGroup.class;
    }

    @Query("SELECT * FROM placegroup")
    public abstract LiveData<List<PlaceGroup>> getAllPlaceGroup();

    @Query("SELECT * FROM placegroup WHERE unionName=:unionId")
    public abstract LiveData<List<PlaceGroup>> findGroupsForSpecificUnion(final String unionId);
}
