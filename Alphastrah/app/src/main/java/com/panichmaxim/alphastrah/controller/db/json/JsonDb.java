package com.panichmaxim.alphastrah.controller.db.json;

import android.content.Context;
import android.support.annotation.NonNull;
import com.annimon.stream.function.Function;
import com.panichmaxim.alphastrah.controller.db.Database;
import com.panichmaxim.alphastrah.controller.db.DatabaseEndpoint;
import com.panichmaxim.alphastrah.model.db.insurance.Insurance;
import com.panichmaxim.alphastrah.model.db.insurance.InsuranceCategory;
import com.panichmaxim.alphastrah.model.db.notification.Notification;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsurance;

public class JsonDb implements Database {

    private DatabaseEndpoint<InsuranceCategory> mInsuranceCategoryEndpoint;
    private DatabaseEndpoint<NWInsurance> mInsuranceEndpoint;
    private DatabaseEndpoint<Notification> mNotificationEndpoint;

    public void init(@NonNull Context context) {
        this.mInsuranceCategoryEndpoint = new JsonEndpoint(new Function<InsuranceCategory, String>() {
            @Override
            public String apply(InsuranceCategory value) {
                return value.getmId();
            }
        } , "InsuranceCategory", context, InsuranceCategory.class);
        this.mNotificationEndpoint = new JsonEndpoint(new Function<Notification, String>() {
            @Override
            public String apply(Notification value) {
                return value.getmId();
            }
        }, "Notification", context, Notification.class);
        this.mInsuranceEndpoint = new JsonEndpoint(new Function<Insurance, String>() {
            @Override
            public String apply(Insurance value) {
                return value.getmId();
            }
        }, "Insurance", context, NWInsurance.class);
    }

    @NonNull
    @Override
    public DatabaseEndpoint<InsuranceCategory> getInsuranceCategoryEndpoint() {
        return mInsuranceCategoryEndpoint;
    }

    @NonNull
    @Override
    public DatabaseEndpoint<NWInsurance> getInsuranceEndpoint() {
        return mInsuranceEndpoint;
    }

    @NonNull
    @Override
    public DatabaseEndpoint<Notification> getNotificationEndpoint() {
        return mNotificationEndpoint;
    }
}
