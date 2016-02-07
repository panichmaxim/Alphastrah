package com.panichmaxim.alphastrah.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import com.panichmaxim.alphastrah.controller.network.NetworkConstants;
import com.panichmaxim.alphastrah.controller.network.ServerApi;
import com.panichmaxim.alphastrah.controller.network.request.EstablishSessionRequest;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.auth.AuthorizeResponse;
import com.panichmaxim.alphastrah.ui.view.LoginView;
import com.panichmaxim.alphastrah.utils.SimpleStorage;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class LoginPresenter extends MvpBasePresenter<LoginView> {

    public void attemptLogin(String email, final String password){
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(NetworkConstants.BASE_URL).setConverter(new GsonConverter(GsonFactory.create())).build();
        ServerApi serverApi = restAdapter.create(ServerApi.class);
        serverApi.authorize(new EstablishSessionRequest(email, password), new Callback<ServerResponse<AuthorizeResponse>>() {

            @Override
            public void success(ServerResponse<AuthorizeResponse> auth, Response response) {
                SimpleStorage storage = SimpleStorage.getInstance();
                storage.saveAuthInfo(auth.getData().getSession(), auth.getData().getAccount());
                storage.setPassword(password);
                if (isViewAttached()) {
                    getView().loginCompleted(auth);
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }

        });
    }
}
