package com.panichmaxim.alphastrah.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.auth.AuthorizeResponse;
import com.panichmaxim.alphastrah.controller.tasks.UserLoginTask;
import com.panichmaxim.alphastrah.ui.view.LoginView;

public class LoginPresenter extends MvpBasePresenter<LoginView> {

    private UserLoginTask mLoginTask;

    private void cancelLoginTaskIfRunning(){
        if (mLoginTask != null){
            mLoginTask.cancel(true);
        }
    }

    public void attemptLogin(String email, String password){
        cancelLoginTaskIfRunning();

        mLoginTask = new UserLoginTask(email, password, new UserLoginTask.LoginTaskListener(){
            public void loginCompleted(ServerResponse<AuthorizeResponse> response){
                if (isViewAttached())
                    getView().loginCompleted(response);
            }
        });
        mLoginTask.execute();
    }

    public void detachView(boolean retainPresenterInstance){
        super.detachView(retainPresenterInstance);
        if (!retainPresenterInstance){
            cancelLoginTaskIfRunning();
        }
    }
}
