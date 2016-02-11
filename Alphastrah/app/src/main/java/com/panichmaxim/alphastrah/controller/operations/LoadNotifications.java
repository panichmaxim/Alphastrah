package com.panichmaxim.alphastrah.controller.operations;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.panichmaxim.alphastrah.App;
import com.panichmaxim.alphastrah.controller.db.DBFactory;
import com.panichmaxim.alphastrah.controller.network.ServerApi;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.notification.NotificationsResponse;
import com.panichmaxim.alphastrah.model.network.notification.NWNotification;
import com.redmadrobot.chronos.ChronosOperation;
import com.redmadrobot.chronos.ChronosOperationResult;

import java.util.List;

public class LoadNotifications extends ChronosOperation<List<NWNotification>> {
    @Nullable
    @Override
    public List<NWNotification> run() {
        ServerResponse<NotificationsResponse> response = App.getRestAdapter().create(ServerApi.class).getNotifications();
        DBFactory.create().getNotificationEndpoint().saveItems(response.getData().getNotifications());
        return response.getData().getNotifications();
    }

    @NonNull
    @Override
    public Class<? extends ChronosOperationResult<List<NWNotification>>> getResultClass(){
        return Result.class;
    }

    public final static class Result extends ChronosOperationResult<List<NWNotification>> {
    }
}
