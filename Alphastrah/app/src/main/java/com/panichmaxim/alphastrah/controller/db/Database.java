package com.panichmaxim.alphastrah.controller.db;

import android.content.Context;
import android.support.annotation.NonNull;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsurance;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsuranceCategory;
import com.panichmaxim.alphastrah.model.network.notification.NWNotification;

public interface Database {

    @NonNull
    DatabaseEndpoint<NWInsuranceCategory> getInsuranceCategoryEndpoint();

    @NonNull
    DatabaseEndpoint<NWInsurance> getInsuranceEndpoint();

    @NonNull
    DatabaseEndpoint<NWNotification> getNotificationEndpoint();

    void init(@NonNull Context context);

}
