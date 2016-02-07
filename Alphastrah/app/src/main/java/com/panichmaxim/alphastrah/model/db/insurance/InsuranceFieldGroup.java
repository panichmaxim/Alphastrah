package com.panichmaxim.alphastrah.model.db.insurance;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class InsuranceFieldGroup extends RealmObject {

    private RealmList<InsuranceField> mFields;
    private String mTitle;

    public InsuranceFieldGroup() {
    }

    public InsuranceFieldGroup(List<InsuranceField> mFields, String mTitle) {
        this.mFields = new RealmList<>(mFields.toArray(new InsuranceField[mFields.size()]));
        this.mTitle = mTitle;
    }

    public RealmList<InsuranceField> getmFields() {
        return mFields;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmFields(RealmList<InsuranceField> mFields) {
        this.mFields = mFields;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
