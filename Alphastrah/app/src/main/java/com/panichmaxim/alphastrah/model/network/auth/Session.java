package com.panichmaxim.alphastrah.model.network.auth;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

public class Session {
    @SerializedName("id")
    private int id;
    @SerializedName("access_token")
    private String token;

    @NonNull
    public int getId() {
        return this.id;
    }

    @NonNull
    public String getToken() {
        return this.token;
    }

}
