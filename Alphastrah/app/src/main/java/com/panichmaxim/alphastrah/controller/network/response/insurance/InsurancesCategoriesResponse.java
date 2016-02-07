package com.panichmaxim.alphastrah.controller.network.response.insurance;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsuranceCategory;
import java.util.List;

public class InsurancesCategoriesResponse {
    @SerializedName("insurance_category_list")
    private List<NWInsuranceCategory> mInsuranceCategories;

    @NonNull
    public List<NWInsuranceCategory> getInsuranceCategories() {
        return this.mInsuranceCategories;
    }
}
