package com.panichmaxim.alphastrah.controller.db.json;

import com.annimon.stream.function.Function;
import com.panichmaxim.alphastrah.model.db.insurance.InsuranceCategory;

final class Json$Lambda$InsuranceCategory implements Function {
    private static final Json$Lambda$InsuranceCategory instance;

    static {
        instance = new Json$Lambda$InsuranceCategory();
    }

    private Json$Lambda$InsuranceCategory() {
    }

    public static Function lambdaFactory$() {
        return instance;
    }

    public Object apply(Object obj) {
        return ((InsuranceCategory) obj).getmId();
    }
}