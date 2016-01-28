package com.panichmaxim.alphastrah.presenter;

import android.os.AsyncTask;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import com.panichmaxim.alphastrah.controller.network.NetworkConstants;
import com.panichmaxim.alphastrah.controller.network.ServerApi;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.insurance.InsurancesResponse;
import com.panichmaxim.alphastrah.utils.SimpleStorage;
import com.panichmaxim.alphastrah.view.InsurancesView;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class InsurancesPresenter extends MvpBasePresenter<InsurancesView> {

    private InsurancesTask insurancesTask = null;

    public void loadCountries(final boolean pullToRefresh){
        insurancesTask = new InsurancesTask();
        insurancesTask.execute();
//        api.getCountries(new Callback<List<Insurance>>(){
//            @Override
//            public void success(List<Country> countries, Response response) {
//                if (isViewAttached()){
//                    getView().setData(countries);
//                    getView().showContent();
//                }
//            }
//
//            @Override
//            public void failure(RetrofitError retrofitError) {
//                if(isViewAttached())
//                    getView().showError(retrofitError.getCause(), pullToRefresh);
//            }
//        });
    }

    public class InsurancesTask extends AsyncTask<Void, Void, ServerResponse<InsurancesResponse>> {

        @Override
        protected ServerResponse<InsurancesResponse> doInBackground(Void... params) {
            RestAdapter restAdapter = new RestAdapter.Builder().setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestInterceptor.RequestFacade request) {
                    request.addHeader("Cookie", "access_token" + "=" + SimpleStorage.getInstance().getToken());
                }
            }).setEndpoint(NetworkConstants.BASE_URL).setConverter(new GsonConverter(GsonFactory.create())).build();
            ServerApi serverApi = restAdapter.create(ServerApi.class);
            ServerResponse<InsurancesResponse> response = serverApi.getInsurances();
            return response;
        }

        @Override
        protected void onPostExecute(final ServerResponse<InsurancesResponse> response) {
            insurancesTask = null;
            if (response != null && isViewAttached()) {
                getView().setData(response.getData().getInsurances());
                getView().showContent();
            } else {
                // TODO
                // getView().showError(retrofitError.getCause(), pullToRefresh);
            }
        }

        @Override
        protected void onCancelled() {
            insurancesTask = null;
        }
    }
}
