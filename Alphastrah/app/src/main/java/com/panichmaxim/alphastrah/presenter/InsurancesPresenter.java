package com.panichmaxim.alphastrah.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import com.panichmaxim.alphastrah.controller.network.NetworkConstants;
import com.panichmaxim.alphastrah.controller.network.ServerApi;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.insurance.InsurancesResponse;
import com.panichmaxim.alphastrah.utils.SimpleStorage;
import com.panichmaxim.alphastrah.ui.view.InsurancesView;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class InsurancesPresenter extends MvpBasePresenter<InsurancesView> {

    public void loadCountries(final boolean pullToRefresh){
        RestAdapter restAdapter = new RestAdapter.Builder().setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestInterceptor.RequestFacade request) {
                request.addHeader("Cookie", "access_token" + "=" + SimpleStorage.getInstance().getToken());
            }
        }).setEndpoint(NetworkConstants.BASE_URL).setConverter(new GsonConverter(GsonFactory.create())).build();
        ServerApi serverApi = restAdapter.create(ServerApi.class);
        serverApi.getInsurances(new Callback<ServerResponse<InsurancesResponse>>() {
            @Override
            public void success(ServerResponse<InsurancesResponse> insurances, Response response) {
                if (isViewAttached()) {
                    getView().setData(insurances.getData().getInsurances());
                    getView().showContent();
                }
            }
            @Override
            public void failure(RetrofitError retrofitError) {
                if (isViewAttached())
                    getView().showError(retrofitError.getCause(), pullToRefresh);
            }
        });
    }

}
