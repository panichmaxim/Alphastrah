package com.panichmaxim.alphastrah.controller.network.request;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

public class EstablishSessionRequest {
    @SerializedName("login")
    private final String mLogin;
    @SerializedName("password")
    private final String mPassword;

    public EstablishSessionRequest(@NonNull String login, @NonNull String password) {
        this.mLogin = login;
        this.mPassword = password;
    }
}
