package com.panichmaxim.alphastrah.model.network.objects;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public final class Phone {
    @SerializedName("human_readable")
    private String mForHuman;
    @SerializedName("plain")
    private String mForSystem;
    @SerializedName("ip_id")
    private String mIpId;

    Phone(@NonNull String forHuman, @NonNull String forSystem, @Nullable String ipId) {
        this.mForHuman = forHuman;
        this.mForSystem = forSystem;
        this.mIpId = ipId;
    }

    @NonNull
    public String getForHuman() {
        return this.mForHuman;
    }

    @NonNull
    public String getForSystem() {
        return this.mForSystem;
    }

    @Nullable
    public String getIpId() {
        return this.mIpId;
    }

}

