package com.panichmaxim.alphastrah;

import android.app.Application;
import com.panichmaxim.alphastrah.controller.db.DBFactory;


public class App extends Application {

    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        DBFactory.create().init(this);
    }

    public static App getContext() { return sInstance; }

}
