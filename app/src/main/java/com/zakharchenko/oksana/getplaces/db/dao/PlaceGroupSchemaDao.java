package com.zakharchenko.oksana.getplaces.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.zakharchenko.oksana.getplaces.db.model.PlaceGroupSchema;

import java.util.List;

@Dao
public abstract class PlaceGroupSchemaDao extends BasePlaceDao<PlaceGroupSchema> {

    @Override
    public Class getEntity() {
        return PlaceGroupSchema.class;
    }

    @Query("SELECT * FROM placegroupschema")
    public abstract LiveData<List<PlaceGroupSchema>> getAllPlaceGroupSchema();

    @Query("SELECT * FROM placegroupschema WHERE groupName=:groupName")
    public abstract LiveData<List<PlaceGroupSchema>> findSchemaForSpecificGroup(final String groupName);
}
