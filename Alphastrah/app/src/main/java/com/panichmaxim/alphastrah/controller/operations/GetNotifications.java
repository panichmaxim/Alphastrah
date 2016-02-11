package com.panichmaxim.alphastrah.controller.operations;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.panichmaxim.alphastrah.controller.db.DBFactory;
import com.panichmaxim.alphastrah.model.network.notification.NWNotification;
import com.redmadrobot.chronos.ChronosOperation;
import com.redmadrobot.chronos.ChronosOperationResult;

import java.util.List;

public class GetNotifications extends ChronosOperation<List<NWNotification>> {

    public static final class Result extends ChronosOperationResult<List<NWNotification>> {
    }

    @Nullable
    public List<NWNotification> run() {
        return DBFactory.create().getNotificationEndpoint().getItems();
    }

    @NonNull
    public Class<? extends ChronosOperationResult<List<NWNotification>>> getResultClass() {
        return Result.class;
    }
}
