package com.panichmaxim.alphastrah.model.db.location;

import io.realm.RealmObject;

public class Coordinate extends RealmObject {
    private Double mLat;
    private Double mLon;

    public Coordinate() {
    }

    public Coordinate(Double mLat, Double mLon) {
        this.mLat = mLat;
        this.mLon = mLon;
    }

    public Double getmLat() {
        return mLat;
    }

    public void setmLat(Double mLat) {
        this.mLat = mLat;
    }

    public Double getmLon() {
        return mLon;
    }

    public void setmLon(Double mLon) {
        this.mLon = mLon;
    }
}
