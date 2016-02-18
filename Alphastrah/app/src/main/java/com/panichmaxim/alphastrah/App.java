package com.panichmaxim.alphastrah;

import android.app.Application;
import com.panichmaxim.alphastrah.controller.db.DBFactory;
import com.panichmaxim.alphastrah.controller.network.ClientFactory;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import com.panichmaxim.alphastrah.controller.network.NetworkConstants;
import com.panichmaxim.alphastrah.utils.SimpleStorage;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;


public class App extends Application {

    private static App sInstance;
    private static RestAdapter sRestAdapter;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        DBFactory.create().init(this);
        sRestAdapter = new RestAdapter.Builder().setClient(ClientFactory.create()).setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestInterceptor.RequestFacade request) {
                request.addHeader("Cookie", "access_token" + "=" + SimpleStorage.getInstance().getToken());
            }
        }).setEndpoint(NetworkConstants.BASE_URL).setConverter(new GsonConverter(GsonFactory.create())).build();
    }

    public static App getContext() { return sInstance; }

    public static RestAdapter getRestAdapter() {
        return sRestAdapter;
    }
}
