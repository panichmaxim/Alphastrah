package com.panichmaxim.alphastrah.model.network.notification;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

public class NotificationField {
    @SerializedName("title")
    private String mTitle;
    @SerializedName("value")
    private String mValue;

    @NonNull
    public String getTitle() {
        return this.mTitle;
    }

    @NonNull
    public String getValue() {
        return this.mValue;
    }
}
