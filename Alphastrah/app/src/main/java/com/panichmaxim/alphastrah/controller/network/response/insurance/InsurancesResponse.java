package com.panichmaxim.alphastrah.controller.network.response.insurance;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.insurance.Insurance;
import java.util.List;

public class InsurancesResponse {
    @SerializedName("insurance_list")
    private List<Insurance> mInsurances;

    @NonNull
    public List<Insurance> getInsurances() {
        return this.mInsurances;
    }
}
