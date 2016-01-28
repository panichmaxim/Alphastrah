package com.panichmaxim.alphastrah.controller.network.response.auth;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

import com.panichmaxim.alphastrah.model.network.auth.Account;
import com.panichmaxim.alphastrah.model.network.auth.Session;

public class AuthorizeResponse {
    @SerializedName("account")
    private Account account;
    @SerializedName("session")
    private Session session;

    @NonNull
    public Session getSession() {
        return this.session;
    }

    @NonNull
    public Account getAccount() {
        return this.account;
    }
}
