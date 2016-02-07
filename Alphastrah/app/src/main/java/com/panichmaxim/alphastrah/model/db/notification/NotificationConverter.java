package com.panichmaxim.alphastrah.model.db.notification;

import android.support.annotation.NonNull;

import com.panichmaxim.alphastrah.model.db.location.LocationConverter;
import com.panichmaxim.alphastrah.model.db.objects.ObjectConverter;
import com.panichmaxim.alphastrah.model.network.notification.NWNotification;
import com.panichmaxim.alphastrah.model.network.notification.NWNotificationField;

import java.util.ArrayList;
import java.util.List;

public class NotificationConverter {
    @NonNull
    public static List<Notification> convertNotificationList(@NonNull List<NWNotification> source) {
        List<Notification> result = new ArrayList<>();
        if (source != null) {
            for (NWNotification notification: source) {
                result.add(convert(notification));
            }
        }
        return result;
    }

    @NonNull
    public static List<NotificationField> convertNotificationFieldList(@NonNull List<NWNotificationField> source) {
        List<NotificationField> result = new ArrayList<>();
        if (source != null) {
            for (NWNotificationField notificationField: source) {
                result.add(convert(notificationField));
            }
        }
        return result;
    }

    @NonNull
    public static Notification convert(@NonNull NWNotification source) {
        if (source == null) return null;
        return new Notification(
                source.getId(),
                source.getIsImportant(),
                source.getAppointmentId(),
                source.getDate(),
                source.getEventNumber(),
                convertNotificationFieldList(source.getFields()),
                source.getInsuranceId(),
                ObjectConverter.convert(source.getPhone()),
                source.getShortDescription(),
                LocationConverter.convert(source.getSto()),
                source.getText(),
                source.getTitle(),
                "",
                source.getUserRequestDate());
    }

    @NonNull
    public static NotificationField convert(@NonNull NWNotificationField source) {
        if (source == null) return null;
        return new NotificationField(
                source.getTitle(),
                source.getValue());
    }
}
