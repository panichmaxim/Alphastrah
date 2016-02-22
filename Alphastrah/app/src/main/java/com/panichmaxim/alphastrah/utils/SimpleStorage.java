package com.panichmaxim.alphastrah.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

import com.google.gson.Gson;
import com.panichmaxim.alphastrah.App;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import com.panichmaxim.alphastrah.model.network.auth.NWAccount;
import com.panichmaxim.alphastrah.model.network.auth.NWSession;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class SimpleStorage {

    private static volatile SimpleStorage sInstance;
    private final SharedPreferences mPreferences;
    private final Gson mGson;

    private final String TOKEN = "TOKEN";
    private final String SESSION = "SESSION";
    private final String ACCOUNT = "ACCOUNT";
    private final String PASSWORD = "PASSWORD";
    private final String CRYPTOKEY = "CRYPTOKEY";

    private SimpleStorage() {
        this.mGson = GsonFactory.create();
        this.mPreferences = App.getContext().getSharedPreferences("preferences", 0);
    }

    public static SimpleStorage getInstance() {
        SimpleStorage localInstance = sInstance;
        if (localInstance == null) {
            synchronized (SimpleStorage.class) {
                localInstance = sInstance;
                if (localInstance == null) {
                    sInstance = localInstance = new SimpleStorage();
                }
            }
        }
        return localInstance;
    }

    public final byte[] getCryptoKey() {
        if (!mPreferences.contains(CRYPTOKEY)) return null;
        return Base64.decode(mPreferences.getString(CRYPTOKEY, ""), Base64.DEFAULT);
    }

    public final void saveCryptoKey(byte[] key) {
        SharedPreferences.Editor ed = mPreferences.edit();
        ed.putString(CRYPTOKEY, Base64.encodeToString(key, Base64.DEFAULT));
        ed.commit();
    }

    public final void logout() {
        setPassword(null);
        saveAuthInfo(null, null);
    }

    public final void saveAuthInfo(NWSession session, NWAccount account)  {
        String sessionJson = this.mGson.toJson(session);
        String accountJson = this.mGson.toJson(account);
        SharedPreferences.Editor ed = mPreferences.edit();
        if (session != null) {
            ed.putString(TOKEN, Security.encrypt(session.getToken()));
        } else {
            ed.putString(TOKEN, null);
        }
        ed.putString(SESSION, Security.encrypt(sessionJson));
        ed.putString(ACCOUNT, Security.encrypt(accountJson));
        ed.commit();
    }

    public String getToken()  {
        return Security.decrypt(this.mPreferences.getString(TOKEN, null));
    }

    public NWSession getSession()  {
        return this.mGson.fromJson(Security.decrypt(this.mPreferences.getString(SESSION, null)), NWSession.class);
    }

    public NWAccount getAccount()  {
        return this.mGson.fromJson(Security.decrypt(this.mPreferences.getString(ACCOUNT, null)), NWAccount.class);
    }

    public boolean isAuthorized()  {
        return !TextUtils.isEmpty(getToken());
    }

    public final void setPassword(String password)  {
        SharedPreferences.Editor ed = mPreferences.edit();
        ed.putString(PASSWORD, Security.encrypt(password));
        ed.commit();
    }

    public final String getPassword() {
        return Security.decrypt(this.mPreferences.getString(PASSWORD, null));
    }

}

