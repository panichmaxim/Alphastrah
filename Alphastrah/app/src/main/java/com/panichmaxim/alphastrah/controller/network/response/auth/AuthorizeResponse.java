package com.panichmaxim.alphastrah.controller.network.response.auth;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

import com.panichmaxim.alphastrah.model.network.auth.Account;
import com.panichmaxim.alphastrah.model.network.auth.Session;

public class AuthorizeResponse {
    @SerializedName("account")
    private Account mAccount;
    @SerializedName("session")
    private Session mSession;

    @NonNull
    public Session getSession() {
        return this.mSession;
    }

    @NonNull
    public Account getAccount() {
        return this.mAccount;
    }
}
