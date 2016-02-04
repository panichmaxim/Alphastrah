package com.panichmaxim.alphastrah.model.utils;

import com.panichmaxim.alphastrah.model.network.insurance.Insurance;
import com.panichmaxim.alphastrah.model.network.insurance.InsuranceCategory;
import com.panichmaxim.alphastrah.model.network.notification.Notification;

import java.util.ArrayList;
import java.util.List;

public class InsurancesInfo {
    private List<Insurance> mInsurancesData;
    private List<Notification> mNotificationData;
    private List<InsuranceCategory> mInsuranceCategoryData;

    public InsurancesInfo() {
        mInsurancesData = new ArrayList<>();
        mNotificationData = new ArrayList<>();
        mInsuranceCategoryData = new ArrayList<>();
    }
    public List<Insurance> getmInsurancesData() {
        return mInsurancesData;
    }

    public List<Notification> getmNotificationData() {
        return mNotificationData;
    }

    public List<InsuranceCategory> getmInsuranceCategoryData() {
        return mInsuranceCategoryData;
    }

    public void setmInsurancesData(List<Insurance> mInsurancesData) {
        this.mInsurancesData = mInsurancesData;
    }

    public void setmNotificationData(List<Notification> mNotificationData) {
        this.mNotificationData = mNotificationData;
    }

    public void setmInsuranceCategoryData(List<InsuranceCategory> mInsuranceCategoryData) {
        this.mInsuranceCategoryData = mInsuranceCategoryData;
    }

    public boolean isReady () {
        return mInsurancesData != null && mNotificationData != null && mInsuranceCategoryData != null;
    }
}
