package com.panichmaxim.alphastrah.model.network.insurance;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.location.Address;

import java.util.Date;

public class InsuranceParticipant {
    @SerializedName("address")
    private Address mAddress;
    @SerializedName("birth_date")
    private Date mBirthday;
    @SerializedName("contact_information")
    private String mContactInfo;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("first_name")
    private String mFirstName;
    @SerializedName("id")
    private String mId;
    @SerializedName("last_name")
    private String mLastName;
    @SerializedName("patronymic")
    private String mPatronymic;
    @SerializedName("sex")
    private String mSex;


    @NonNull
    public String getId() {
        return this.mId;
    }

    @NonNull
    public String getFirstName() {
        return this.mFirstName;
    }

    @NonNull
    public String getLastName() {
        return this.mLastName;
    }

    @Nullable
    public String getMiddleName() {
        return this.mPatronymic;
    }

    @NonNull
    public Date getBirthday() {
        return this.mBirthday;
    }

    @Nullable
    public String getSex() {
        return this.mSex;
    }

    @Nullable
    public String getContactInfo() {
        return this.mContactInfo;
    }

    @Nullable
    public Address getAddress() {
        return this.mAddress;
    }

    @Nullable
    public String getEmail() {
        return this.mEmail;
    }
}
