package com.panichmaxim.alphastrah.controller.db.json;

import com.annimon.stream.function.Function;
import com.panichmaxim.alphastrah.model.db.notification.Notification;

final class Json$Lambda$Notification implements Function {
    private static final Json$Lambda$Notification instance;

    static {
        instance = new Json$Lambda$Notification();
    }

    private Json$Lambda$Notification() {
    }

    public static Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object obj) {
        return ((Notification) obj).getmId();
    }
}
