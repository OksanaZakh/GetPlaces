package com.zakharchenko.oksana.getplaces.db.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@Entity
public class PlaceUnion extends BasePlace {
    @NonNull
    @PrimaryKey
    @SerializedName("Name")
    private String unionTitle;

    @SerializedName("PlaceGroups")
    @Ignore
    private List<PlaceGroup> placeGroups = null;

    public String getUnionTitle() {
        return unionTitle;
    }

    public void setUnionTitle(String unionTitle) {
        this.unionTitle = unionTitle;
    }

    public List<PlaceGroup> getPlaceGroups() {
        return placeGroups;
    }

    public void setPlaceGroups(List<PlaceGroup> placeGroups) {
        this.placeGroups = placeGroups;
    }

}
