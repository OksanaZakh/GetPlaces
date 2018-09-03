package com.zakharchenko.oksana.getplaces.viewmodel;

import android.arch.lifecycle.LiveData;

import com.zakharchenko.oksana.getplaces.ExtApplication;
import com.zakharchenko.oksana.getplaces.db.model.Bill;

import java.util.List;

public class BillViewModel extends BaseQueryViewModel<List<Bill>> {
    @Override
    public LiveData<List<Bill>> loadData() {
        return ExtApplication.getInstance().getAppDb().getBillDao().getAllBills();
    }

    @Override
    public LiveData<List<Bill>> loadDataWithQuery(String query) {
        return ExtApplication.getInstance().getAppDb().getBillDao().findBillsForSpecificPlaces(query);
    }
}
