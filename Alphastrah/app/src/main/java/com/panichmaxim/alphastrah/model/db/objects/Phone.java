package com.panichmaxim.alphastrah.model.db.objects;

import io.realm.RealmObject;

public class Phone extends RealmObject {
    private String mForHuman;
    private String mForSystem;
    private String mIpId;

    public Phone() {
    }

    public Phone(String mForHuman, String mForSystem, String mIpId) {
        this.mForHuman = mForHuman;
        this.mForSystem = mForSystem;
        this.mIpId = mIpId;
    }

    public String getmForHuman() {
        return mForHuman;
    }

    public void setmForHuman(String mForHuman) {
        this.mForHuman = mForHuman;
    }

    public String getmForSystem() {
        return mForSystem;
    }

    public void setmForSystem(String mForSystem) {
        this.mForSystem = mForSystem;
    }

    public String getmIpId() {
        return mIpId;
    }

    public void setmIpId(String mIpId) {
        this.mIpId = mIpId;
    }
}
