package com.panichmaxim.alphastrah.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.panichmaxim.alphastrah.controller.db.DBFactory;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import com.panichmaxim.alphastrah.controller.network.InternetConnection;
import com.panichmaxim.alphastrah.controller.network.NetworkConstants;
import com.panichmaxim.alphastrah.controller.network.ServerApi;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.insurance.InsurancesCategoriesResponse;
import com.panichmaxim.alphastrah.controller.network.response.insurance.InsurancesResponse;
import com.panichmaxim.alphastrah.controller.network.response.notification.NotificationsResponse;
import com.panichmaxim.alphastrah.model.utils.InsurancesListData;
import com.panichmaxim.alphastrah.utils.SimpleStorage;
import com.panichmaxim.alphastrah.ui.view.InsurancesView;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class InsurancesPresenter extends MvpBasePresenter<InsurancesView> {

    private InsurancesListData mInsurancesListData = new InsurancesListData();
    private boolean insurancesLoaded;
    private boolean notificationsLoaded;
    private boolean insuranceCategoriesLoaded;

    public void loadData(final boolean pullToRefresh) {
        if(InternetConnection.checkNetworkStatus()) {
            insurancesLoaded = false;
            notificationsLoaded = false;
            insuranceCategoriesLoaded = false;
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
                    DBFactory.create().getInsuranceEndpoint().saveItems(insurances.getData().getInsurances());
                    mInsurancesListData.setmInsurancesData(insurances.getData().getInsurances());
                    insurancesLoaded = true;
                    if (isViewAttached() && insurancesLoaded && notificationsLoaded && insuranceCategoriesLoaded) {
                        getView().setData(mInsurancesListData);
                        getView().showContent();
                    }
                }
                @Override
                public void failure(RetrofitError retrofitError) {
                    if (isViewAttached())
                        getView().showError(retrofitError.getCause(), pullToRefresh);
                }
            });

            serverApi.getNotifications(new Callback<ServerResponse<NotificationsResponse>>() {
                @Override
                public void success(ServerResponse<NotificationsResponse> notifications, Response response) {
                    DBFactory.create().getNotificationEndpoint().saveItems(notifications.getData().getmNotifications());
                    notificationsLoaded = true;
                    if (isViewAttached() && insurancesLoaded && notificationsLoaded && insuranceCategoriesLoaded) {
                        getView().setData(mInsurancesListData);
                        getView().showContent();
                    }
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    if (isViewAttached())
                        getView().showError(retrofitError.getCause(), pullToRefresh);
                }
            });

            serverApi.getInsuranceCategories(new Callback<ServerResponse<InsurancesCategoriesResponse>>() {
                @Override
                public void success(ServerResponse<InsurancesCategoriesResponse> categories, Response response) {
                    DBFactory.create().getInsuranceCategoryEndpoint().saveItems(categories.getData().getInsuranceCategories());
                    mInsurancesListData.setmInsuranceCategoryData(categories.getData().getInsuranceCategories());
                    insuranceCategoriesLoaded = true;
                    if (isViewAttached() && insurancesLoaded && notificationsLoaded && insuranceCategoriesLoaded) {
                        getView().setData(mInsurancesListData);
                        getView().showContent();
                    }
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    if (isViewAttached())
                        getView().showError(retrofitError.getCause(), pullToRefresh);
                }
            });
        } else {
            mInsurancesListData.setmInsuranceCategoryData(DBFactory.create().getInsuranceCategoryEndpoint().getItems());
            mInsurancesListData.setmInsurancesData(DBFactory.create().getInsuranceEndpoint().getItems());
            getView().setData(mInsurancesListData);
            getView().showContent();
        }
    }

}
