package com.panichmaxim.alphastrah.model.db.location;

import io.realm.RealmObject;

public class Address extends RealmObject {
    private String mCity;
    private String mCountry;
    private String mIndex;
    private String mLocalAddress;

    public Address() {
    }

    public Address(String mCity, String mCountry, String mIndex, String mLocalAddress) {
        this.mCity = mCity;
        this.mCountry = mCountry;
        this.mIndex = mIndex;
        this.mLocalAddress = mLocalAddress;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmIndex() {
        return mIndex;
    }

    public void setmIndex(String mIndex) {
        this.mIndex = mIndex;
    }

    public String getmLocalAddress() {
        return mLocalAddress;
    }

    public void setmLocalAddress(String mLocalAddress) {
        this.mLocalAddress = mLocalAddress;
    }
}
