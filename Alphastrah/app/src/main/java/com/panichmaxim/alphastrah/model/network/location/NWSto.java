package com.panichmaxim.alphastrah.model.network.location;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.objects.NWPhone;

import java.util.List;

public class NWSto {
    @SerializedName("address")
    private String mAddress;
    @SerializedName("coordinate")
    private NWCoordinate mCoordinate;
    @SerializedName("dealer")
    private String mDealer;
    @SerializedName("id")
    private String mId;
    @SerializedName("phone_list")
    private List<NWPhone> mPhones;
    @SerializedName("service_hours")
    private String mServiceHours;
    @SerializedName("title")
    private String mTitle;

    @NonNull
    public String getId() {
        return this.mId;
    }

    @NonNull
    public String getTitle() {
        return this.mTitle;
    }

    @Nullable
    public String getAddress() {
        return this.mAddress;
    }

    @NonNull
    public NWCoordinate getCoordinate() {
        return this.mCoordinate;
    }

    @NonNull
    public String getServiceHours() {
        return this.mServiceHours;
    }

    @NonNull
    public String getDealer() {
        return this.mDealer;
    }

    @NonNull
    public List<NWPhone> getPhones() {
        return this.mPhones;
    }

}
