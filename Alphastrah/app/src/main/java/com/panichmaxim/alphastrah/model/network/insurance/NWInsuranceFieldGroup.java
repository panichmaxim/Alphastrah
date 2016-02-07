package com.panichmaxim.alphastrah.model.network.insurance;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NWInsuranceFieldGroup {
    @SerializedName("fields")
    private List<NWInsuranceField> mFields;
    @SerializedName("title")
    private String mTitle;

    @NonNull
    public String getTitle() {
        return this.mTitle;
    }

    @NonNull
    public List<NWInsuranceField> getFields() {
        return this.mFields;
    }

}
