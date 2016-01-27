package com.panichmaxim.alphastrah.controller.network.request;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

public class EstablishSessionRequest {
    @SerializedName("login")
    private final String login;
    @SerializedName("password")
    private final String password;

    public EstablishSessionRequest(@NonNull String login, @NonNull String password) {
        this.login = login;
        this.password = password;
    }
}
