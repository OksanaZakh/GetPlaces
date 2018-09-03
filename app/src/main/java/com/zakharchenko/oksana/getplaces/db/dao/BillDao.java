package com.zakharchenko.oksana.getplaces.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.zakharchenko.oksana.getplaces.db.model.Bill;
import java.util.List;

@Dao
public abstract class BillDao extends BasePlaceDao<Bill> {

    @Query("SELECT * FROM bill")
    public abstract LiveData<List<Bill>> getAllBills();

    @Query("SELECT * FROM bill WHERE placeCode=:placeId")
    public abstract LiveData<List<Bill>> findBillsForSpecificPlaces(final String placeId);

    @Override
    public Class<Bill> getEntity() {
        return Bill.class;
    }
}
