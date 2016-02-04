package com.panichmaxim.alphastrah.model.network.location;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Coordinate {
    @SerializedName("latitude")
    private Double mLat;
    @SerializedName("longitude")
    private Double mLon;

    @NonNull
    public Double getLon() {
        return this.mLon;
    }

    @NonNull
    public Double getLat() {
        return this.mLat;
    }
}
