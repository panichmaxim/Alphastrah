package com.panichmaxim.alphastrah.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.panichmaxim.alphastrah.App;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import com.panichmaxim.alphastrah.model.network.auth.Account;
import com.panichmaxim.alphastrah.model.network.auth.Session;

public final class SimpleStorage {

    private static final int CURRENT_VERSION = 1;
    private static volatile SimpleStorage instance;
    private final SharedPreferences preferences;
    private final Gson gson;

    private final String TOKEN = "TOKEN";
    private final String SESSION = "SESSION";
    private final String ACCOUNT = "ACCOUNT";
    private final String PASSWORD = "PASSWORD";

    private SimpleStorage() {
        this.gson = GsonFactory.create();
        this.preferences = App.getContext().getSharedPreferences("preferences", 0);
    }

    public static SimpleStorage getInstance() {
        SimpleStorage localInstance = instance;
        if (localInstance == null) {
            synchronized (SimpleStorage.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SimpleStorage();
                }
            }
        }
        return localInstance;
    }

    public final void logout() {
        setPassword(null);
        saveAuthInfo(null, null);
    }

    public final void saveAuthInfo(Session session, Account account) {
        String sessionJson = this.gson.toJson(session);
        String accountJson = this.gson.toJson(account);
        SharedPreferences.Editor ed = preferences.edit();
        if (session != null) {
            ed.putString(TOKEN, session.getToken());
        } else {
            ed.putString(TOKEN, null);
        }
        ed.putString(SESSION, sessionJson);
        ed.putString(ACCOUNT, accountJson);
        ed.commit();
    }

    public String getToken() {
        return this.preferences.getString(TOKEN, null);
    }

    public Session getSession() {
        return this.gson.fromJson(this.preferences.getString(SESSION, null), Session.class);
    }

    public Account getAccount() {
        return this.gson.fromJson(this.preferences.getString(ACCOUNT, null), Account.class);
    }

    public boolean isAuthorized() {
        return !TextUtils.isEmpty(getToken());
    }

    public final void setPassword(String password) {
        SharedPreferences.Editor ed = preferences.edit();
        ed.putString(PASSWORD, password);
        ed.commit();
    }

    public final String getPassword() {
        return this.preferences.getString(PASSWORD, null);
    }

}

