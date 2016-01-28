package com.panichmaxim.alphastrah.model.network.location;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Address {
    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;
    @SerializedName("index")
    private String index;
    @SerializedName("street_house_apartment")
    private String localAddress;


    @Nullable
    public String getIndex() {
        return this.index;
    }

    @Nullable
    public String getCountry() {
        return this.country;
    }

    @NonNull
    public String getCity() {
        return this.city;
    }

    @NonNull
    public String getLocalAddress() {
        return this.localAddress;
    }

}
