package com.panichmaxim.alphastrah.model.network.location;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class NWAddress {
    @SerializedName("city")
    private String mCity;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("index")
    private String mIndex;
    @SerializedName("street_house_apartment")
    private String mLocalAddress;


    @Nullable
    public String getIndex() {
        return this.mIndex;
    }

    @Nullable
    public String getCountry() {
        return this.mCountry;
    }

    @NonNull
    public String getCity() {
        return this.mCity;
    }

    @NonNull
    public String getLocalAddress() {
        return this.mLocalAddress;
    }

}
