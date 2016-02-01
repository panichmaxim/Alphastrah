package com.panichmaxim.alphastrah.model.network.insurance;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.location.Coordinate;

public class InsuranceField {
    @SerializedName("coordinate")
    private Coordinate mCoordinate;
    @SerializedName("text")
    private String mText;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private InsuranceFieldType mType;

    @NonNull
    public InsuranceFieldType getType() {
        return this.mType;
    }

    @NonNull
    public String getTitle() {
        return this.mTitle;
    }

    @NonNull
    public String getText() {
        return this.mText;
    }

    @Nullable
    public Coordinate getCoordinate() {
        return this.mCoordinate;
    }
}
