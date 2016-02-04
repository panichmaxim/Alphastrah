package com.panichmaxim.alphastrah.model.network.insurance;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InsuranceFieldGroup {
    @SerializedName("fields")
    private List<InsuranceField> mFields;
    @SerializedName("title")
    private String mTitle;

    @NonNull
    public String getTitle() {
        return this.mTitle;
    }

    @NonNull
    public List<InsuranceField> getFields() {
        return this.mFields;
    }

}
