package com.zakharchenko.oksana.getplaces.api;

import android.util.Log;

import com.zakharchenko.oksana.getplaces.ui.ExtApplication;

import com.zakharchenko.oksana.getplaces.db.dao.BillDao;
import com.zakharchenko.oksana.getplaces.db.dao.PlaceDao;
import com.zakharchenko.oksana.getplaces.db.dao.PlaceGroupDao;
import com.zakharchenko.oksana.getplaces.db.dao.PlaceGroupSchemaDao;
import com.zakharchenko.oksana.getplaces.db.dao.PlaceUnionDao;
import com.zakharchenko.oksana.getplaces.db.model.Bill;
import com.zakharchenko.oksana.getplaces.db.model.Place;
import com.zakharchenko.oksana.getplaces.db.model.PlaceGroup;
import com.zakharchenko.oksana.getplaces.db.model.PlaceGroupSchema;
import com.zakharchenko.oksana.getplaces.db.model.PlaceUnion;
import com.zakharchenko.oksana.getplaces.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIRequest implements Interceptor {

    private static final String TAG = "APIRequest";
    private static APIRequest instance;

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        okhttp3.Response response = chain.proceed(chain.request());
        return response;
    }

    private APIService getApi() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(APIService.class);
    }

    public static APIRequest getInstance() {
        if (instance == null) {
            instance = new APIRequest();
        }
        return instance;
    }

    public void getPlaces() {
        Log.d(TAG, "getPlaces: ");
        Call<ResponseBody> call = getApi().getPlaces(Constants.REQUEST);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                PlaceUnionDao placeUnionDao = ExtApplication.getInstance().getAppDb().getPlaceUnionDao();
                PlaceGroupDao placeGroupDao = ExtApplication.getInstance().getAppDb().getPlaceGroupDao();
                PlaceGroupSchemaDao placeGroupSchemaDao = ExtApplication.getInstance().getAppDb().getPlaceGroupSchemaDao();
                PlaceDao placeDao = ExtApplication.getInstance().getAppDb().getPlaceDao();
                BillDao billDao = ExtApplication.getInstance().getAppDb().getBillDao();

                List<PlaceUnion> placeUnions = response.body().getPlaceUnions();
                placeUnionDao.deleteAndInsert(placeUnions);

                List<PlaceGroup> placeGroups = new ArrayList<>();
                for (PlaceUnion placeUnion : placeUnions) {
                    for(PlaceGroup placeGroup: placeUnion.getPlaceGroups()){
                        placeGroup.setUnionName(placeUnion.getUnionTitle());
                        placeGroups.add(placeGroup);
                    }
                    placeGroupDao.deleteAndInsert(placeGroups);
                }

                List<PlaceGroupSchema> placeGroupSchemas=new ArrayList<>();
                for (PlaceGroup placeGroup : placeGroups) {
                    for(PlaceGroupSchema placeGroupSchema: placeGroup.getPlaceGroupSchemas()){
                        placeGroupSchema.setGroupName(placeGroup.getGroupTitle());
                        placeGroupSchemas.add(placeGroupSchema);
                        Log.d(TAG, "onResponse: placeGroupSchema size "+placeGroupSchemas.size());
                    }
                    placeGroupSchemaDao.deleteAndInsert(placeGroupSchemas);
                }

                List<Place> places=new ArrayList<>();
                for (PlaceGroupSchema placeGroupSchema : placeGroupSchemas) {
                    for(Place place: placeGroupSchema.getPlaces()){
                       place.setSchemaName(placeGroupSchema.getSchemaTitle());
                       places.add(place);
                    }
                    placeDao.deleteAndInsert(places);
                }

                List<Bill> bills=new ArrayList<>();
                for (Place place : places) {
                    for(Bill bill: place.getBills()){
                        bill.setPlaceCode(place.getCode());
                        bills.add(bill);
                    }
                    billDao.deleteAndInsert(bills);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });

    }
}
