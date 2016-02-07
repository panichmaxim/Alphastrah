package com.panichmaxim.alphastrah.model.db.insurance;

import com.panichmaxim.alphastrah.model.db.objects.StringObject;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class InsuranceCategory extends RealmObject {

    @PrimaryKey
    private String mId;
    private Integer mDaysToNotify;
    private RealmList<StringObject> mProductIds;
    private String mSubtitle;
    private String mTermsUrl;
    private String mTitle;
    private String mType;

    public InsuranceCategory()  {

    }

    public InsuranceCategory(Integer mDaysToNotify, String mId, List<StringObject> mProductIds, String mSubtitle, String mTermsUrl, String mTitle, String mType) {
        this.mDaysToNotify = mDaysToNotify;
        this.mId = mId;
        this.mProductIds = new RealmList<>(mProductIds.toArray(new StringObject[mProductIds.size()]));
        this.mSubtitle = mSubtitle;
        this.mTermsUrl = mTermsUrl;
        this.mTitle = mTitle;
        this.mType = mType;
    }

    public Integer getmDaysToNotify() {
        return mDaysToNotify;
    }

    public String getmId() {
        return mId;
    }

    public RealmList<StringObject> getmProductIds() {
        return mProductIds;
    }

    public String getmSubtitle() {
        return mSubtitle;
    }

    public String getmTermsUrl() {
        return mTermsUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmType() {
        return mType;
    }

    public void setmDaysToNotify(Integer mDaysToNotify) {
        this.mDaysToNotify = mDaysToNotify;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public void setmProductIds(RealmList<StringObject> mProductIds) {
        this.mProductIds = mProductIds;
    }

    public void setmSubtitle(String mSubtitle) {
        this.mSubtitle = mSubtitle;
    }

    public void setmTermsUrl(String mTermsUrl) {
        this.mTermsUrl = mTermsUrl;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }
}
