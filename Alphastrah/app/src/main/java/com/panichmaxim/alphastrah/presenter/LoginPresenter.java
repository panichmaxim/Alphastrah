package com.panichmaxim.alphastrah.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import com.panichmaxim.alphastrah.controller.network.NetworkConstants;
import com.panichmaxim.alphastrah.controller.network.ServerApi;
import com.panichmaxim.alphastrah.controller.network.request.EstablishSessionRequest;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.auth.AuthorizeResponse;
import com.panichmaxim.alphastrah.controller.operations.UserLogin;
import com.panichmaxim.alphastrah.ui.view.LoginView;
import com.panichmaxim.alphastrah.utils.SimpleStorage;
import com.redmadrobot.chronos.ChronosConnector;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class LoginPresenter extends MvpBasePresenter<LoginView> {

    public void attemptLogin(String email, final String password, ChronosConnector mConnector){
        mConnector.runOperation(new UserLogin(email, password), false);
    }

    public void onOperationFinished(final UserLogin.Result result) {
        if (isViewAttached()) {
            getView().loginCompleted(result.getOutput());
        }
    }
}
