package com.panichmaxim.alphastrah.model.utils;

import com.panichmaxim.alphastrah.controller.adapter.SimpleSectionedRecyclerViewAdapter;
import com.panichmaxim.alphastrah.model.db.insurance.Insurance;
import com.panichmaxim.alphastrah.model.db.insurance.InsuranceCategory;
import com.panichmaxim.alphastrah.model.db.notification.Notification;
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

    public SimpleSectionedRecyclerViewAdapter.Section[] sortAndGetSections() {
        List<SimpleSectionedRecyclerViewAdapter.Section> sections = new ArrayList<>();
        List<Insurance> sortedList = new ArrayList<>();
        int i = 0;
        for (InsuranceCategory category: mInsuranceCategoryData) {
            boolean hasCategory = false;
            for (Insurance insurance: mInsurancesData) {
                if (category.getmProductIds().contains(insurance.getmInsuranceProduct())) {
                    hasCategory = true;
                    sortedList.add(insurance);
                }
            }
            if (hasCategory) {
                sections.add(new SimpleSectionedRecyclerViewAdapter.Section(i,category.getmTitle()));
                i++;
            }
        }
        return sections.toArray(new SimpleSectionedRecyclerViewAdapter.Section[sections.size()]);
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

}
