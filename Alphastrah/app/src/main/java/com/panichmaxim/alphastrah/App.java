package com.panichmaxim.alphastrah;

import android.app.Application;

import com.panichmaxim.alphastrah.controller.db.DBFactory;

import io.realm.Realm;

public class App extends Application {

    private static App sInstance;
    private static Realm sRealm;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sRealm = Realm.getInstance(this);
        DBFactory.create().init(this);
    }

    public static App getContext() { return sInstance; }

    public static Realm getRealm() {
        return sRealm;
    }
}
