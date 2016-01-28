package com.panichmaxim.alphastrah.model.network.insurance;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.location.Coordinate;

public class InsuranceField {
    @SerializedName("coordinate")
    private Coordinate coordinate;
    @SerializedName("text")
    private String text;
    @SerializedName("title")
    private String title;
    @SerializedName("type")
    private InsuranceFieldType type;

    @NonNull
    public InsuranceFieldType getType() {
        return this.type;
    }

    @NonNull
    public String getTitle() {
        return this.title;
    }

    @NonNull
    public String getText() {
        return this.text;
    }

    @Nullable
    public Coordinate getCoordinate() {
        return this.coordinate;
    }
}
