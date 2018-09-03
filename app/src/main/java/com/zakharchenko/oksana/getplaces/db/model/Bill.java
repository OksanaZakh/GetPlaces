package com.zakharchenko.oksana.getplaces.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Place.class, parentColumns = "code", childColumns = "placeCode", onDelete = CASCADE))
public class Bill extends BasePlace {
    private static final String TAG = "Bill";

    @PrimaryKey
    @SerializedName("ID")
    private Integer id;

    private String placeCode;

    @SerializedName("Number")

    private Integer number;
    @SerializedName("Opened")

    private String opened;
    @SerializedName("Total")

    private Integer total;
    @SerializedName("OpenUser")

    private String openUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getOpened() {
        return opened;
    }

    public void setOpened(String opened) {
        this.opened = opened;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getOpenUser() {
        return openUser;
    }

    public void setOpenUser(String openUser) {
        this.openUser = openUser;
    }

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }
}
