package com.panichmaxim.alphastrah.controller.network.response;

import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

public final class ServerResponse<DataType> {
    @SerializedName("data")
    private DataType data;
    @SerializedName("error")
    private ServerError error;

    @Nullable
    public DataType getData() {
        return this.data;
    }

    @Nullable
    public ServerError getError() {
        return this.error;
    }

    public final boolean isSuccessful() {
        return this.error == null;
    }
}
