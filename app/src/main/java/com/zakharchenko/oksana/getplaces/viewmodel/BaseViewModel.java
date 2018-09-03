package com.zakharchenko.oksana.getplaces.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.WorkerThread;

import com.zakharchenko.oksana.getplaces.db.model.BasePlace;

import java.util.List;

public abstract class BaseViewModel<T> extends ViewModel {

    private LiveData<T> data;

    @WorkerThread
    public LiveData<T> getData() {
        data = loadData();
        return data;
    }

    public abstract LiveData<T> loadData();
}
