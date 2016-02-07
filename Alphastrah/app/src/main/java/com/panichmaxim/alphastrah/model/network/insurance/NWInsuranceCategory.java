package com.panichmaxim.alphastrah.model.network.insurance;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NWInsuranceCategory {
    @SerializedName("days_left")
    private Integer mDaysToNotify;
    @SerializedName("id")
    private String mId;
    @SerializedName("product_id_list")
    private List<String> mProductIds;
    @SerializedName("subtitle")
    private String mSubtitle;
    @SerializedName("terms_url")
    private String mTermsUrl;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private InsuranceCategoryType mType;

    @NonNull
    public String getId() {
        return this.mId;
    }

    @NonNull
    public String getTitle() {
        return this.mTitle;
    }

    @Nullable
    public String getTermsUrl() {
        return this.mTermsUrl;
    }

    @NonNull
    public Integer getDaysToNotify() {
        return this.mDaysToNotify;
    }

    @NonNull
    public List<String> getProductIds() {
        return this.mProductIds;
    }

    @NonNull
    public InsuranceCategoryType getType() {
        return this.mType;
    }

    @NonNull
    public String getSubtitle() {
        return this.mSubtitle;
    }

}
