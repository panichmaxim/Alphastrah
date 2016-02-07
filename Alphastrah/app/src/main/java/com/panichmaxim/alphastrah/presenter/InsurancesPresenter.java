package com.panichmaxim.alphastrah.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.panichmaxim.alphastrah.App;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import com.panichmaxim.alphastrah.controller.network.InternetConnection;
import com.panichmaxim.alphastrah.controller.network.NetworkConstants;
import com.panichmaxim.alphastrah.controller.network.ServerApi;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.insurance.InsurancesCategoriesResponse;
import com.panichmaxim.alphastrah.controller.network.response.insurance.InsurancesResponse;
import com.panichmaxim.alphastrah.controller.network.response.notification.NotificationsResponse;
import com.panichmaxim.alphastrah.model.db.insurance.Insurance;
import com.panichmaxim.alphastrah.model.db.insurance.InsuranceCategory;
import com.panichmaxim.alphastrah.model.db.insurance.InsuranceConverter;
import com.panichmaxim.alphastrah.model.db.notification.Notification;
import com.panichmaxim.alphastrah.model.db.notification.NotificationConverter;
import com.panichmaxim.alphastrah.model.utils.InsurancesInfo;
import com.panichmaxim.alphastrah.utils.SimpleStorage;
import com.panichmaxim.alphastrah.ui.view.InsurancesView;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class InsurancesPresenter extends MvpBasePresenter<InsurancesView> {

    private InsurancesInfo mInsurancesInfo = new InsurancesInfo();
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
                    mInsurancesInfo.setmInsurancesData(InsuranceConverter.convertInsuranceList(insurances.getData().getInsurances()));
                    insurancesLoaded = true;
                    App.getRealm().beginTransaction();
                    App.getRealm().copyToRealmOrUpdate(mInsurancesInfo.getmInsurancesData());
                    App.getRealm().commitTransaction();
                    if (isViewAttached() && insurancesLoaded && notificationsLoaded && insuranceCategoriesLoaded) {
                        getView().setData(mInsurancesInfo);
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
                    mInsurancesInfo.setmNotificationData(NotificationConverter.convertNotificationList(notifications.getData().getmNotifications()));
                    notificationsLoaded = true;
                    App.getRealm().beginTransaction();
                    App.getRealm().copyToRealmOrUpdate(mInsurancesInfo.getmNotificationData());
                    App.getRealm().commitTransaction();
                    if (isViewAttached() && insurancesLoaded && notificationsLoaded && insuranceCategoriesLoaded) {
                        getView().setData(mInsurancesInfo);
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
                    mInsurancesInfo.setmInsuranceCategoryData(InsuranceConverter.convertInsuranceCategoryList(categories.getData().getInsuranceCategories()));
                    insuranceCategoriesLoaded = true;
                    App.getRealm().beginTransaction();
                    App.getRealm().copyToRealmOrUpdate(mInsurancesInfo.getmInsuranceCategoryData());
                    App.getRealm().commitTransaction();
                    if (isViewAttached() && insurancesLoaded && notificationsLoaded && insuranceCategoriesLoaded) {
                        getView().setData(mInsurancesInfo);
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
            mInsurancesInfo.setmNotificationData(App.getRealm().where(Notification.class).findAll());
            mInsurancesInfo.setmInsuranceCategoryData(App.getRealm().where(InsuranceCategory.class).findAll());
            mInsurancesInfo.setmInsurancesData(App.getRealm().where(Insurance.class).findAll());
            getView().setData(mInsurancesInfo);
            getView().showContent();
        }
    }

}
