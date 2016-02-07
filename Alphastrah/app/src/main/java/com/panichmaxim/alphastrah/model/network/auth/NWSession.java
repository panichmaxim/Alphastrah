package com.panichmaxim.alphastrah.model.network.auth;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

public class NWSession {
    @SerializedName("id")
    private int mId;
    @SerializedName("access_token")
    private String mToken;

    @NonNull
    public int getId() {
        return this.mId;
    }

    @NonNull
    public String getToken() {
        return this.mToken;
    }

}
