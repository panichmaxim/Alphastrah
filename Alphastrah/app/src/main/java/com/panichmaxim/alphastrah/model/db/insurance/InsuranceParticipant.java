package com.panichmaxim.alphastrah.model.db.insurance;

import com.panichmaxim.alphastrah.model.db.location.Address;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class InsuranceParticipant extends RealmObject {
    @PrimaryKey
    private String mId;
    private Address mAddress;
    private Date mBirthday;
    private String mContactInfo;
    private String mEmail;
    private String mFirstName;
    private String mLastName;
    private String mPatronymic;
    private String mSex;

    public InsuranceParticipant() {
    }

    public InsuranceParticipant(Address mAddress, Date mBirthday, String mContactInfo, String mEmail, String mFirstName, String mId, String mLastName, String mPatronymic, String mSex) {
        this.mAddress = mAddress;
        this.mBirthday = mBirthday;
        this.mContactInfo = mContactInfo;
        this.mEmail = mEmail;
        this.mFirstName = mFirstName;
        this.mId = mId;
        this.mLastName = mLastName;
        this.mPatronymic = mPatronymic;
        this.mSex = mSex;
    }

    public Address getmAddress() {
        return mAddress;
    }

    public void setmAddress(Address mAddress) {
        this.mAddress = mAddress;
    }

    public Date getmBirthday() {
        return mBirthday;
    }

    public void setmBirthday(Date mBirthday) {
        this.mBirthday = mBirthday;
    }

    public String getmContactInfo() {
        return mContactInfo;
    }

    public void setmContactInfo(String mContactInfo) {
        this.mContactInfo = mContactInfo;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getmPatronymic() {
        return mPatronymic;
    }

    public void setmPatronymic(String mPatronymic) {
        this.mPatronymic = mPatronymic;
    }

    public String getmSex() {
        return mSex;
    }

    public void setmSex(String mSex) {
        this.mSex = mSex;
    }
}
