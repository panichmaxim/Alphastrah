package com.panichmaxim.alphastrah.controller.db.json;

import android.content.Context;
import android.support.annotation.NonNull;
import com.annimon.stream.function.Function;
import com.panichmaxim.alphastrah.controller.db.Database;
import com.panichmaxim.alphastrah.controller.db.DatabaseEndpoint;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsurance;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsuranceCategory;
import com.panichmaxim.alphastrah.model.network.notification.NWNotification;

public class JsonDb implements Database {

    private DatabaseEndpoint<NWInsuranceCategory> mInsuranceCategoryEndpoint;
    private DatabaseEndpoint<NWInsurance> mInsuranceEndpoint;
    private DatabaseEndpoint<NWNotification> mNotificationEndpoint;

    public void init(@NonNull Context context) {
        this.mInsuranceCategoryEndpoint = new JsonEndpoint(new Function<NWInsuranceCategory, String>() {
            @Override
            public String apply(NWInsuranceCategory value) {
                return value.getId();
            }
        } , "InsuranceCategory", context, NWInsuranceCategory.class);
        this.mNotificationEndpoint = new JsonEndpoint(new Function<NWNotification, String>() {
            @Override
            public String apply(NWNotification value) {
                return value.getId();
            }
        }, "Notification", context, NWNotification.class);
        this.mInsuranceEndpoint = new JsonEndpoint(new Function<NWInsurance, String>() {
            @Override
            public String apply(NWInsurance value) {
                return value.getId();
            }
        }, "Insurance", context, NWInsurance.class);
    }

    @NonNull
    @Override
    public DatabaseEndpoint<NWInsuranceCategory> getInsuranceCategoryEndpoint() {
        return mInsuranceCategoryEndpoint;
    }

    @NonNull
    @Override
    public DatabaseEndpoint<NWInsurance> getInsuranceEndpoint() {
        return mInsuranceEndpoint;
    }

    @NonNull
    @Override
    public DatabaseEndpoint<NWNotification> getNotificationEndpoint() {
        return mNotificationEndpoint;
    }
}
