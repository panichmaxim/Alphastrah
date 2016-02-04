package com.panichmaxim.alphastrah.controller.network.response;

import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

public final class ServerResponse<DataType> {
    @SerializedName("data")
    private DataType mData;
    @SerializedName("error")
    private ServerError mError;

    @Nullable
    public DataType getData() {
        return this.mData;
    }

    @Nullable
    public ServerError getError() {
        return this.mError;
    }

    public final boolean isSuccessful() {
        return this.mError == null;
    }
}
