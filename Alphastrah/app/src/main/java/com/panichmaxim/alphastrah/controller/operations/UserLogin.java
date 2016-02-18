package com.panichmaxim.alphastrah.controller.operations;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.panichmaxim.alphastrah.controller.network.ClientFactory;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import com.panichmaxim.alphastrah.controller.network.NetworkConstants;
import com.panichmaxim.alphastrah.controller.network.ServerApi;
import com.panichmaxim.alphastrah.controller.network.request.EstablishSessionRequest;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.auth.AuthorizeResponse;
import com.panichmaxim.alphastrah.utils.SimpleStorage;
import com.redmadrobot.chronos.ChronosOperation;
import com.redmadrobot.chronos.ChronosOperationResult;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class UserLogin extends ChronosOperation<ServerResponse<AuthorizeResponse>> {

    private final String mEmail;
    private final String mPassword;

    public UserLogin(@NonNull String mEmail, @NonNull String password) {
        this.mEmail = mEmail;
        this.mPassword = password;
    }

    @Nullable
    @Override
    public ServerResponse<AuthorizeResponse> run() {
        RestAdapter restAdapter = new RestAdapter.Builder().setClient(ClientFactory.create()).setEndpoint(NetworkConstants.SERVER_URL).setConverter(new GsonConverter(GsonFactory.create())).build();
        ServerApi serverApi = restAdapter.create(ServerApi.class);
        ServerResponse<AuthorizeResponse> response = serverApi.authorize(new EstablishSessionRequest(mEmail, mPassword));
        if (response.isSuccessful() && response.getData() != null) {
            SimpleStorage storage = SimpleStorage.getInstance();
            storage.saveAuthInfo(response.getData().getSession(), response.getData().getAccount());
            try {
                storage.setPassword(mPassword);
            } catch (Exception e) {
                Log.e("Error", "Ups, cant save password");
            }
        }
        return response;
    }

    @NonNull
    @Override
    public Class<? extends ChronosOperationResult<ServerResponse<AuthorizeResponse>>> getResultClass(){
        return Result.class;
    }

    public final static class Result extends ChronosOperationResult<ServerResponse<AuthorizeResponse>> {
    }
}
