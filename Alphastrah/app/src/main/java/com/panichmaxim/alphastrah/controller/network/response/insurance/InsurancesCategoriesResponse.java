package com.panichmaxim.alphastrah.controller.network.response.insurance;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.insurance.InsuranceCategory;
import java.util.List;

public class InsurancesCategoriesResponse {
    @SerializedName("insurance_category_list")
    private List<InsuranceCategory> mInsuranceCategories;

    @NonNull
    public List<InsuranceCategory> getInsuranceCategories() {
        return this.mInsuranceCategories;
    }
}
