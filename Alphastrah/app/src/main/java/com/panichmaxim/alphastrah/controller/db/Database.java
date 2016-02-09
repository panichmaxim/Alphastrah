package com.panichmaxim.alphastrah.controller.db;

import android.content.Context;
import android.support.annotation.NonNull;

import com.panichmaxim.alphastrah.model.db.insurance.Insurance;
import com.panichmaxim.alphastrah.model.db.insurance.InsuranceCategory;
import com.panichmaxim.alphastrah.model.db.notification.Notification;

public interface Database {

    @NonNull
    DatabaseEndpoint<InsuranceCategory> getInsuranceCategoryEndpoint();

    @NonNull
    DatabaseEndpoint<Insurance> getInsuranceEndpoint();

    @NonNull
    DatabaseEndpoint<Notification> getNotificationEndpoint();

    void init(@NonNull Context context);

}
