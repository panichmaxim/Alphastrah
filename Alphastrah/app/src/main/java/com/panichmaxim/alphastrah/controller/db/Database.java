package com.panichmaxim.alphastrah.controller.db;

import android.content.Context;
import android.support.annotation.NonNull;

import com.panichmaxim.alphastrah.model.db.insurance.InsuranceCategory;
import com.panichmaxim.alphastrah.model.db.notification.Notification;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsurance;

public interface Database {

    @NonNull
    DatabaseEndpoint<InsuranceCategory> getInsuranceCategoryEndpoint();

    @NonNull
    DatabaseEndpoint<NWInsurance> getInsuranceEndpoint();

    @NonNull
    DatabaseEndpoint<Notification> getNotificationEndpoint();

    void init(@NonNull Context context);

}
