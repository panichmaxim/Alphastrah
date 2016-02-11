package com.panichmaxim.alphastrah.model.utils;

import com.panichmaxim.alphastrah.controller.adapter.SimpleSectionedRecyclerViewAdapter;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsurance;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsuranceCategory;
import java.util.ArrayList;
import java.util.List;

public class InsurancesListData {
    private List<NWInsurance> mInsurancesData = new ArrayList<>();
    private List<NWInsuranceCategory> mInsuranceCategoryData = new ArrayList<>();

    public InsurancesListData() {
    }

    public InsurancesListData(List<NWInsurance> insurancesData, List<NWInsuranceCategory> insuranceCategoryData) {
        mInsurancesData = insurancesData;
        mInsuranceCategoryData = insuranceCategoryData;
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

    public List<NWInsuranceCategory> getmInsuranceCategoryData() {
        return mInsuranceCategoryData;
    }

    public void setmInsurancesData(List<NWInsurance> mInsurancesData) {
        this.mInsurancesData = mInsurancesData;
    }

    public void setmInsuranceCategoryData(List<NWInsuranceCategory> mInsuranceCategoryData) {
        this.mInsuranceCategoryData = mInsuranceCategoryData;
    }

}
