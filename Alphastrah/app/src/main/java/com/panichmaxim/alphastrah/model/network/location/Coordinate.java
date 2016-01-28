package com.panichmaxim.alphastrah.model.network.location;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Coordinate {
    @SerializedName("latitude")
    private Double lat;
    @SerializedName("longitude")
    private Double lon;

    @NonNull
    public Double getLon() {
        return this.lon;
    }

    @NonNull
    public Double getLat() {
        return this.lat;
    }
}
