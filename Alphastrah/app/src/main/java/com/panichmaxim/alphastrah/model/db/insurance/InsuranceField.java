package com.panichmaxim.alphastrah.model.db.insurance;

import com.panichmaxim.alphastrah.model.db.location.Coordinate;
import com.panichmaxim.alphastrah.model.network.insurance.InsuranceFieldType;

import io.realm.RealmObject;

public class InsuranceField extends RealmObject {
    private Coordinate mCoordinate;
    private String mText;
    private String mTitle;
    private String mType;

    public InsuranceField() {
    }

    public InsuranceField(Coordinate mCoordinate, String mText, String mTitle, String mType) {
        this.mCoordinate = mCoordinate;
        this.mText = mText;
        this.mTitle = mTitle;
        this.mType = mType;
    }

    public Coordinate getmCoordinate() {
        return mCoordinate;
    }

    public void setmCoordinate(Coordinate mCoordinate) {
        this.mCoordinate = mCoordinate;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }
}
