package com.panichmaxim.alphastrah.controller.db.json;

import com.annimon.stream.function.Function;
import com.panichmaxim.alphastrah.model.db.insurance.Insurance;


final class Json$Lambda$Insurance implements Function {
    private static final Json$Lambda$Insurance instance;

    static {
        instance = new Json$Lambda$Insurance();
    }

    private Json$Lambda$Insurance() {
    }

    public static Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object obj) {
        return ((Insurance) obj).getmId();
    }
}