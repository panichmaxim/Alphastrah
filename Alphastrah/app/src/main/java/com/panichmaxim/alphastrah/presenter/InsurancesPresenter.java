package com.panichmaxim.alphastrah.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.panichmaxim.alphastrah.controller.network.InternetConnection;
import com.panichmaxim.alphastrah.controller.operations.GetInsurancesListData;
import com.panichmaxim.alphastrah.controller.operations.LoadInsuranceCategories;
import com.panichmaxim.alphastrah.controller.operations.LoadInsurances;
import com.panichmaxim.alphastrah.controller.operations.LoadNotifications;
import com.panichmaxim.alphastrah.model.utils.InsurancesListData;
import com.panichmaxim.alphastrah.ui.view.InsurancesView;
import com.redmadrobot.chronos.ChronosConnector;

public class InsurancesPresenter extends MvpBasePresenter<InsurancesView> {

    private InsurancesListData mInsurancesListData;
    private boolean insurancesLoaded;
    private boolean notificationsLoaded;
    private boolean insuranceCategoriesLoaded;
    private boolean pullToRefresh;

    public void loadData(final boolean pullToRefresh, ChronosConnector mConnector) {
        this.pullToRefresh = pullToRefresh;
        if(InternetConnection.checkNetworkStatus()) {
            insurancesLoaded = false;
            notificationsLoaded = false;
            insuranceCategoriesLoaded = false;
            mInsurancesListData = new InsurancesListData();
            mConnector.runOperation(new LoadInsuranceCategories(), false);
            mConnector.runOperation(new LoadInsurances(), false);
            mConnector.runOperation(new LoadNotifications(), false);
        } else {
            mConnector.runOperation(new GetInsurancesListData(), false);
        }
    }

    public void onOperationFinished(final LoadInsuranceCategories.Result result) {
        if (result.isSuccessful()) {
            mInsurancesListData.setmInsuranceCategoryData(result.getOutput());
            insuranceCategoriesLoaded = true;
            if (isViewAttached() && insurancesLoaded && notificationsLoaded && insuranceCategoriesLoaded) {
                getView().setData(mInsurancesListData);
                getView().showContent();
            }
        } else {
            if (isViewAttached()) getView().showError(result.getException(), pullToRefresh);
        }
    }

    public void onOperationFinished(final LoadInsurances.Result result) {
        if (result.isSuccessful()) {
            mInsurancesListData.setmInsurancesData(result.getOutput());
            insurancesLoaded = true;
            if (isViewAttached() && insurancesLoaded && notificationsLoaded && insuranceCategoriesLoaded) {
                getView().setData(mInsurancesListData);
                getView().showContent();
            }
        } else {
            if (isViewAttached()) getView().showError(result.getException(), pullToRefresh);
        }
    }

    public void onOperationFinished(final LoadNotifications.Result result) {
        if (result.isSuccessful()) {
            notificationsLoaded = true;
            if (isViewAttached() && insurancesLoaded && notificationsLoaded && insuranceCategoriesLoaded) {
                getView().setData(mInsurancesListData);
                getView().showContent();
            }
        } else {
            if (isViewAttached()) getView().showError(result.getException(), pullToRefresh);
        }
    }

    public void onOperationFinished(final GetInsurancesListData.Result result) {
        if (result.isSuccessful()) {
            if (isViewAttached()) {
                getView().setData(result.getOutput());
                getView().showContent();
            }
        } else {
            if (isViewAttached()) getView().showError(result.getException(), pullToRefresh);
        }
    }

}
