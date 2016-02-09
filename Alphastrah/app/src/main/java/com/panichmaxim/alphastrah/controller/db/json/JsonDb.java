package com.panichmaxim.alphastrah.controller.db.json;

import android.content.Context;
import android.support.annotation.NonNull;

import com.panichmaxim.alphastrah.controller.db.Database;
import com.panichmaxim.alphastrah.controller.db.DatabaseEndpoint;
import com.panichmaxim.alphastrah.model.db.insurance.Insurance;
import com.panichmaxim.alphastrah.model.db.insurance.InsuranceCategory;
import com.panichmaxim.alphastrah.model.db.notification.Notification;

public class JsonDb implements Database {

    private DatabaseEndpoint<InsuranceCategory> mInsuranceCategoryEndpoint;
    private DatabaseEndpoint<Insurance> mInsuranceEndpoint;
    private DatabaseEndpoint<Notification> mNotificationEndpoint;

    public void init(@NonNull Context context) {
        // ((InsuranceCategory item) -> { return item.getmId(); })
        this.mInsuranceCategoryEndpoint = new JsonEndpoint(Json$Lambda$InsuranceCategory.lambdaFactory$() , "InsuranceCategory", context, InsuranceCategory.class);
        this.mNotificationEndpoint = new JsonEndpoint(Json$Lambda$Notification.lambdaFactory$(), "Notification", context, Notification.class);
        this.mInsuranceEndpoint = new JsonEndpoint(Json$Lambda$Insurance.lambdaFactory$(), "Insurance", context, Insurance.class);
    }

    @NonNull
    @Override
    public DatabaseEndpoint<InsuranceCategory> getInsuranceCategoryEndpoint() {
        return mInsuranceCategoryEndpoint;
    }

    @NonNull
    @Override
    public DatabaseEndpoint<Insurance> getInsuranceEndpoint() {
        return mInsuranceEndpoint;
    }

    @NonNull
    @Override
    public DatabaseEndpoint<Notification> getNotificationEndpoint() {
        return mNotificationEndpoint;
    }
}
