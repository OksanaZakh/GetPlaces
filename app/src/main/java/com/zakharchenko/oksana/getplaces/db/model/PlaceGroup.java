package com.zakharchenko.oksana.getplaces.db.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(foreignKeys = @ForeignKey(entity = PlaceUnion.class, parentColumns = "unionTitle", childColumns = "unionName", onDelete = CASCADE))
public class PlaceGroup extends BasePlace  {

    private static final String TAG = "PlaceGroup";
    @NonNull
    @PrimaryKey
    @SerializedName("Name")
    private String groupTitle;

    private String unionName;

    @SerializedName("PlaceGroupSchemas")
    @Ignore
    private List<PlaceGroupSchema> placeGroupSchemas = null;

    public String getUnionName() {
        return unionName;
    }

    public void setUnionName(String unionName) {
        this.unionName = unionName;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public List<PlaceGroupSchema> getPlaceGroupSchemas() {
        return placeGroupSchemas;
    }

    public void setPlaceGroupSchemas(List<PlaceGroupSchema> placeGroupSchemas) {
        this.placeGroupSchemas = placeGroupSchemas;
    }
}


