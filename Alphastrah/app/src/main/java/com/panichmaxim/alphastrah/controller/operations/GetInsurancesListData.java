package com.panichmaxim.alphastrah.controller.operations;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.panichmaxim.alphastrah.controller.db.DBFactory;
import com.panichmaxim.alphastrah.controller.db.Database;
import com.panichmaxim.alphastrah.model.utils.InsurancesListData;
import com.redmadrobot.chronos.ChronosOperation;
import com.redmadrobot.chronos.ChronosOperationResult;

public class GetInsurancesListData extends ChronosOperation<InsurancesListData> {

    public static final class Result extends ChronosOperationResult<InsurancesListData> {
    }

    @Nullable
    public InsurancesListData run() {
        return new InsurancesListData(DBFactory.create().getInsuranceEndpoint().getItems(), DBFactory.create().getInsuranceCategoryEndpoint().getItems());
    }

    @NonNull
    public Class<? extends ChronosOperationResult<InsurancesListData>> getResultClass() {
        return Result.class;
    }
}
