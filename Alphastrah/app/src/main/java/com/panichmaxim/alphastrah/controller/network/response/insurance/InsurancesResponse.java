package com.panichmaxim.alphastrah.controller.network.response.insurance;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsurance;
import java.util.List;

public class InsurancesResponse {
    @SerializedName("insurance_list")
    private List<NWInsurance> mInsurances;

    @NonNull
    public List<NWInsurance> getInsurances() {
        return this.mInsurances;
    }
}
