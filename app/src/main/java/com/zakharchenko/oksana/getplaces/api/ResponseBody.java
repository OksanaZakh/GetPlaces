package com.zakharchenko.oksana.getplaces.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zakharchenko.oksana.getplaces.db.model.PlaceGroup;
import com.zakharchenko.oksana.getplaces.db.model.PlaceUnion;

import java.util.List;

public class ResponseBody {


    @SerializedName("PlaceUnions")
    @Expose
    private List<PlaceUnion> placeUnions = null;

    public List<PlaceUnion> getPlaceUnions() {
        return placeUnions;
    }

    public void setPlaceUnions(List<PlaceUnion> placeUnions) {
        this.placeUnions = placeUnions;
    }
}
