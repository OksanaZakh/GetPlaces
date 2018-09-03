package com.zakharchenko.oksana.getplaces.viewmodel;

import android.arch.lifecycle.LiveData;
import android.support.annotation.WorkerThread;

import com.zakharchenko.oksana.getplaces.db.model.BasePlace;

import java.util.List;

public abstract class BaseQueryViewModel<T> extends BaseViewModel<T> {

    protected LiveData<T> queryData;

    public abstract LiveData<T> loadDataWithQuery(String query);

    @WorkerThread
    public LiveData<T> getQueryData(String query) {
        queryData = loadDataWithQuery(query);
        return queryData;
    }
}
