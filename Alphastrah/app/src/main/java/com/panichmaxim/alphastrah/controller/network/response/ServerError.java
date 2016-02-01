package com.panichmaxim.alphastrah.controller.network.response;

import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

public final class ServerError {
    @SerializedName("code")
    private int mCode;
    @SerializedName("error_message")
    private String mMessage;

    public int getCode() {
        return this.mCode;
    }

    @Nullable
    public String getMessage() {
        return this.mMessage;
    }
}
