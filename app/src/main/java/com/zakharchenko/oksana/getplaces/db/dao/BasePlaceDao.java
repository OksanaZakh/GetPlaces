package com.zakharchenko.oksana.getplaces.db.dao;


import android.arch.persistence.db.SimpleSQLiteQuery;
import android.arch.persistence.db.SupportSQLiteQuery;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.RawQuery;
import android.arch.persistence.room.Transaction;


import java.util.List;

public abstract class BasePlaceDao<T> {

    @RawQuery
    protected abstract List<T> rawListQuery(SupportSQLiteQuery query);

    @RawQuery
    protected abstract int rawIntQuery(SupportSQLiteQuery query);

    public List<T> getAll() {
        return rawListQuery(getSelectAllQuery());
    }

    public int deleteAll() {
        SimpleSQLiteQuery query = new SimpleSQLiteQuery("DELETE FROM " + getTableName());
        return rawIntQuery(query);
    }

    private SupportSQLiteQuery getSelectAllQuery() {
        return new SimpleSQLiteQuery("SELECT * FROM " + getTableName());
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(List<T> items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(T... items);

    @Transaction
    public void deleteAndInsert(List<T> items) {
        deleteAll();
        insertAll(items);
    }

    public Class getEntity() {
        throw new IllegalStateException("method getEntity() must be override for each model");
    }

    public String getTableName() {
        return getEntity().getSimpleName();
    }

}
