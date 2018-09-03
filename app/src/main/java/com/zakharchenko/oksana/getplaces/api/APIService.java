package com.zakharchenko.oksana.getplaces.api;


import com.zakharchenko.oksana.getplaces.utils.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {
    @POST(Constants.GET_PLACES_URL)
    Call<ResponseBody> getPlaces(@Body String request);
}
