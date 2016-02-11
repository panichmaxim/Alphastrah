package com.panichmaxim.alphastrah.controller.operations;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.panichmaxim.alphastrah.App;
import com.panichmaxim.alphastrah.controller.db.DBFactory;
import com.panichmaxim.alphastrah.controller.network.ServerApi;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.insurance.InsurancesCategoriesResponse;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsuranceCategory;
import com.redmadrobot.chronos.ChronosOperation;
import com.redmadrobot.chronos.ChronosOperationResult;
import java.util.List;

public class LoadInsuranceCategories extends ChronosOperation<List<NWInsuranceCategory>> {
    @Nullable
    @Override
    public List<NWInsuranceCategory> run() {
        ServerResponse<InsurancesCategoriesResponse> response = App.getRestAdapter().create(ServerApi.class).getInsuranceCategories();
        DBFactory.create().getInsuranceCategoryEndpoint().saveItems(response.getData().getInsuranceCategories());
        return response.getData().getInsuranceCategories();
    }

    @NonNull
    @Override
    public Class<? extends ChronosOperationResult<List<NWInsuranceCategory>>> getResultClass(){
        return Result.class;
    }

    public final static class Result extends ChronosOperationResult<List<NWInsuranceCategory>> {
    }
}
