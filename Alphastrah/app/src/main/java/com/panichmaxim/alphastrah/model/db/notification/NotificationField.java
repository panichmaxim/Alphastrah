package com.panichmaxim.alphastrah.model.db.notification;

import java.io.Serializable;

import io.realm.RealmObject;

public class NotificationField extends RealmObject implements Serializable {
    private String mTitle;
    private String mValue;

    public NotificationField() {
    }

    public NotificationField(String mTitle, String mValue) {
        this.mTitle = mTitle;
        this.mValue = mValue;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmValue() {
        return mValue;
    }

    public void setmValue(String mValue) {
        this.mValue = mValue;
    }
}
