package com.panichmaxim.alphastrah.model.network.auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public final class Phone {
    @SerializedName("human_readable")
    private String forHuman;
    @SerializedName("plain")
    private String forSystem;
    @SerializedName("ip_id")
    private String ipId;

    Phone(@NonNull String forHuman, @NonNull String forSystem, @Nullable String ipId) {
        this.forHuman = forHuman;
        this.forSystem = forSystem;
        this.ipId = ipId;
    }

    @NonNull
    public String getForHuman() {
        return this.forHuman;
    }

    @NonNull
    public String getForSystem() {
        return this.forSystem;
    }

    @Nullable
    public String getIpId() {
        return this.ipId;
    }

}

