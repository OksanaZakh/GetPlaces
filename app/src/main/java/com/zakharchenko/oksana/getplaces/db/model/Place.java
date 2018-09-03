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

@Entity(foreignKeys = @ForeignKey(entity = PlaceGroupSchema.class, parentColumns = "schemaTitle", childColumns = "schemaName", onDelete = CASCADE))
public class Place extends BasePlace {

    private static final String TAG = "Place";

    private String schemaName;

    @SerializedName("Name")
    private String name;

    @NonNull
    @PrimaryKey
    @SerializedName("Code")
    private String code;

    @SerializedName("Left")
    private Integer left;

    @SerializedName("Top")
    private Integer top;

    @SerializedName("Width")
    private Integer width;

    @SerializedName("Height")
    private Integer height;

    @SerializedName("Corner")
    private Integer corner;

    @SerializedName("ShapeType")
    private Integer shapeType;

    @SerializedName("ShapeOrient")
    private Integer shapeOrient;

    @SerializedName("Color")
    private Integer color;

    @SerializedName("Style")
    private Integer style;

    @SerializedName("FrameColor")
    private Integer frameColor;

    @SerializedName("FontColor")
    private Integer fontColor;

    @SerializedName("Bills")
    @Ignore
    private List<Bill> bills = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getCorner() {
        return corner;
    }

    public void setCorner(Integer corner) {
        this.corner = corner;
    }

    public Integer getShapeType() {
        return shapeType;
    }

    public void setShapeType(Integer shapeType) {
        this.shapeType = shapeType;
    }

    public Integer getShapeOrient() {
        return shapeOrient;
    }

    public void setShapeOrient(Integer shapeOrient) {
        this.shapeOrient = shapeOrient;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public Integer getFrameColor() {
        return frameColor;
    }

    public void setFrameColor(Integer frameColor) {
        this.frameColor = frameColor;
    }

    public Integer getFontColor() {
        return fontColor;
    }

    public void setFontColor(Integer fontColor) {
        this.fontColor = fontColor;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
