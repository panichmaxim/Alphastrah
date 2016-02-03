package com.panichmaxim.alphastrah.controller.network.response.notification;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.notification.Notification;

import java.util.List;

public class NotificationsResponse {
    @SerializedName("notification_list")
    private List<Notification> mNotifications;

    @NonNull
    public List<Notification> getmNotifications() {
        return this.mNotifications;
    }
}
