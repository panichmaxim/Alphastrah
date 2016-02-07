package com.panichmaxim.alphastrah.model.db.location;

import com.panichmaxim.alphastrah.model.db.objects.Phone;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Sto extends RealmObject {

    @PrimaryKey
    private String mId;
    private String mAddress;
    private Coordinate mCoordinate;
    private String mDealer;
    private RealmList<Phone> mPhones;
    private String mServiceHours;
    private String mTitle;

    public Sto() {
    }

    public Sto(String mId, String mAddress, Coordinate mCoordinate, String mDealer, List<Phone> mPhones, String mServiceHours, String mTitle) {
        this.mId = mId;
        this.mAddress = mAddress;
        this.mCoordinate = mCoordinate;
        this.mDealer = mDealer;
        this.mPhones = new RealmList<>(mPhones.toArray(new Phone[mPhones.size()]));
        this.mServiceHours = mServiceHours;
        this.mTitle = mTitle;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public Coordinate getmCoordinate() {
        return mCoordinate;
    }

    public void setmCoordinate(Coordinate mCoordinate) {
        this.mCoordinate = mCoordinate;
    }

    public String getmDealer() {
        return mDealer;
    }

    public void setmDealer(String mDealer) {
        this.mDealer = mDealer;
    }

    public RealmList<Phone> getmPhones() {
        return mPhones;
    }

    public void setmPhones(RealmList<Phone> mPhones) {
        this.mPhones = mPhones;
    }

    public String getmServiceHours() {
        return mServiceHours;
    }

    public void setmServiceHours(String mServiceHours) {
        this.mServiceHours = mServiceHours;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
