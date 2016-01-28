package com.panichmaxim.alphastrah.ui.view;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.auth.AuthorizeResponse;

public interface LoginView extends MvpView {
    void loginCompleted(ServerResponse<AuthorizeResponse> response);
}
