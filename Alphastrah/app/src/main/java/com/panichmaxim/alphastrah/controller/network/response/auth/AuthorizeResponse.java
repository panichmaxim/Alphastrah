package com.panichmaxim.alphastrah.controller.network.response.auth;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

import com.panichmaxim.alphastrah.model.network.auth.NWAccount;
import com.panichmaxim.alphastrah.model.network.auth.NWSession;

public class AuthorizeResponse {
    @SerializedName("account")
    private NWAccount mAccount;
    @SerializedName("session")
    private NWSession mSession;

    @NonNull
    public NWSession getSession() {
        return this.mSession;
    }

    @NonNull
    public NWAccount getAccount() {
        return this.mAccount;
    }
}
