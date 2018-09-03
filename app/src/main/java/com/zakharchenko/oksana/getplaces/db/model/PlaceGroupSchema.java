package com.zakharchenko.oksana.getplaces.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.annotations.SerializedName;


import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = PlaceGroup.class, parentColumns = "groupTitle", childColumns = "groupName", onDelete = CASCADE))
public class PlaceGroupSchema extends BasePlace {
    private static final String TAG = "PlaceGroupSchema";

    private String groupName;
    @NonNull
    @PrimaryKey
    @SerializedName("Name")
    private String schemaTitle;

    @SerializedName("Places")
    @Ignore
    private List<Place> places = null;

    @NonNull
    public String getSchemaTitle() {
        return schemaTitle;
    }

    public void setSchemaTitle(@NonNull String schemaTitle) {
        this.schemaTitle = schemaTitle;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
