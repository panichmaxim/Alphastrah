package com.panichmaxim.alphastrah.model.network.insurance;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InsuranceFieldGroup {
    @SerializedName("fields")
    private List<InsuranceField> fields;
    @SerializedName("title")
    private String title;

    @NonNull
    public String getTitle() {
        return this.title;
    }

    @NonNull
    public List<InsuranceField> getFields() {
        return this.fields;
    }

}
