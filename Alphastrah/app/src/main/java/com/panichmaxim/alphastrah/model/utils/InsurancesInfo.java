package com.panichmaxim.alphastrah.model.utils;

import com.panichmaxim.alphastrah.controller.adapter.SimpleSectionedRecyclerViewAdapter;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsurance;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsuranceCategory;
import com.panichmaxim.alphastrah.model.network.notification.NWNotification;
import java.util.ArrayList;
import java.util.List;

public class InsurancesInfo {
    private List<NWInsurance> mInsurancesData;
    private List<NWNotification> mNotificationData;
    private List<NWInsuranceCategory> mInsuranceCategoryData;

    public InsurancesInfo() {
        mInsurancesData = new ArrayList<>();
        mNotificationData = new ArrayList<>();
        mInsuranceCategoryData = new ArrayList<>();
    }

    public SimpleSectionedRecyclerViewAdapter.Section[] sortAndGetSections() {
        List<SimpleSectionedRecyclerViewAdapter.Section> sections = new ArrayList<>();
        List<NWInsurance> sortedList = new ArrayList<>();
        int i = 0;
        for (NWInsuranceCategory category: mInsuranceCategoryData) {
            boolean hasCategory = false;
            for (NWInsurance insurance: mInsurancesData) {
                if (category.getProductIds().contains(insurance.getInsuranceProduct())) {
                    hasCategory = true;
                    sortedList.add(insurance);
                }
            }
            if (hasCategory) {
                sections.add(new SimpleSectionedRecyclerViewAdapter.Section(i,category.getTitle()));
                i++;
            }
        }
        return sections.toArray(new SimpleSectionedRecyclerViewAdapter.Section[sections.size()]);
    }
    public List<NWInsurance> getmInsurancesData() {
        return mInsurancesData;
    }

    public List<NWNotification> getmNotificationData() {
        return mNotificationData;
    }

    public void setmInsurancesData(List<NWInsurance> mInsurancesData) {
        this.mInsurancesData = mInsurancesData;
    }

    public void setmNotificationData(List<NWNotification> mNotificationData) {
        this.mNotificationData = mNotificationData;
    }

    public void setmInsuranceCategoryData(List<NWInsuranceCategory> mInsuranceCategoryData) {
        this.mInsuranceCategoryData = mInsuranceCategoryData;
    }

}
