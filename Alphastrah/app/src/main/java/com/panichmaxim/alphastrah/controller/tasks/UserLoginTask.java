package com.panichmaxim.alphastrah.controller.tasks;

import android.os.AsyncTask;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import com.panichmaxim.alphastrah.controller.network.NetworkConstants;
import com.panichmaxim.alphastrah.controller.network.ServerApi;
import com.panichmaxim.alphastrah.controller.network.request.EstablishSessionRequest;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.auth.AuthorizeResponse;
import com.panichmaxim.alphastrah.utils.SimpleStorage;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class UserLoginTask extends AsyncTask<Void, Void, ServerResponse<AuthorizeResponse>> {

    public interface LoginTaskListener{
        void loginCompleted(ServerResponse<AuthorizeResponse> response);
    }

    private LoginTaskListener listener;
    private final String email;
    private final String password;

    public UserLoginTask(String email, String password, LoginTaskListener listener) {
        this.email = email;
        this.password = password;
        this.listener = listener;
    }

    @Override
    protected ServerResponse<AuthorizeResponse> doInBackground(Void... params) {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(NetworkConstants.BASE_URL).setConverter(new GsonConverter(GsonFactory.create())).build();
        ServerApi serverApi = restAdapter.create(ServerApi.class);
        ServerResponse<AuthorizeResponse> response = serverApi.authorize(new EstablishSessionRequest(email, password));
        if (response.isSuccessful() && response.getData() != null) {
            SimpleStorage storage = SimpleStorage.getInstance();
            storage.saveAuthInfo((response.getData()).getSession(), (response.getData()).getAccount());
            storage.setPassword(this.password);
        }
        return response;
    }

    @Override
    protected void onPostExecute(final ServerResponse<AuthorizeResponse> response) {
        listener.loginCompleted(response);
    }
    
}
