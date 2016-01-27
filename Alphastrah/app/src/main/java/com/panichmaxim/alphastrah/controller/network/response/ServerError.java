package com.panichmaxim.alphastrah.controller.network.response;

import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

public final class ServerError {
    @SerializedName("code")
    private int code;
    @SerializedName("error_message")
    private String message;

    public int getCode() {
        return this.code;
    }

    @Nullable
    public String getMessage() {
        return this.message;
    }
}
