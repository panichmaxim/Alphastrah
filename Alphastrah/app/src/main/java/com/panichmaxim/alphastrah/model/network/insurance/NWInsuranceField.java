package com.panichmaxim.alphastrah.model.network.insurance;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.location.NWCoordinate;

public class NWInsuranceField {
    @SerializedName("coordinate")
    private NWCoordinate mCoordinate;
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
    public NWCoordinate getCoordinate() {
        return this.mCoordinate;
    }
}
