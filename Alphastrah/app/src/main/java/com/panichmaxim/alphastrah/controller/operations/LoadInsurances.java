package com.panichmaxim.alphastrah.controller.operations;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.panichmaxim.alphastrah.App;
import com.panichmaxim.alphastrah.controller.db.DBFactory;
import com.panichmaxim.alphastrah.controller.network.ServerApi;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.insurance.InsurancesResponse;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsurance;
import com.redmadrobot.chronos.ChronosOperation;
import com.redmadrobot.chronos.ChronosOperationResult;
import java.util.List;

public class LoadInsurances extends ChronosOperation<List<NWInsurance>> {

    @Nullable
    @Override
    public List<NWInsurance> run() {
        ServerResponse<InsurancesResponse> response = App.getRestAdapter().create(ServerApi.class).getInsurances();
        DBFactory.create().getInsuranceEndpoint().saveItems(response.getData().getInsurances());
        return response.getData().getInsurances();
    }

    @NonNull
    @Override
    public Class<? extends ChronosOperationResult<List<NWInsurance>>> getResultClass(){
        return Result.class;
    }

    public final static class Result extends ChronosOperationResult<List<NWInsurance>> {
    }
}
