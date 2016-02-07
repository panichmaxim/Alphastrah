package com.panichmaxim.alphastrah.model.network.notification;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.utils.ModelObject;

public class NWNotificationField extends ModelObject {
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
