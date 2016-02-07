package com.panichmaxim.alphastrah.model.db.insurance;

import android.support.annotation.NonNull;

import com.panichmaxim.alphastrah.model.db.location.LocationConverter;
import com.panichmaxim.alphastrah.model.db.objects.ObjectConverter;
import com.panichmaxim.alphastrah.model.db.objects.StringObject;
import com.panichmaxim.alphastrah.model.network.insurance.InsuranceFieldType;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsurance;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsuranceCategory;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsuranceFieldGroup;
import com.panichmaxim.alphastrah.model.network.insurance.NWInsuranceParticipant;

import java.util.ArrayList;
import java.util.List;

public class InsuranceConverter {

    @NonNull
    public static List<Insurance> convertInsuranceList(@NonNull List<NWInsurance> source) {
        List<Insurance> result = new ArrayList<>();
        if (source != null) {
            for (NWInsurance insurance: source) {
                result.add(convert(insurance));
            }
        }
        return result;
    }

    @NonNull
    public static List<InsuranceParticipant> convertInsuranceParticipantList(@NonNull List<NWInsuranceParticipant> source) {
        List<InsuranceParticipant> result = new ArrayList<>();
        if (source != null) {
            for (NWInsuranceParticipant insuranceParticipant: source) {
                result.add(convert(insuranceParticipant));
            }
        }
        return result;
    }

    @NonNull
    public static List<InsuranceCategory> convertInsuranceCategoryList(@NonNull List<NWInsuranceCategory> source) {
        List<InsuranceCategory> result = new ArrayList<>();
        if (source != null) {
            for (NWInsuranceCategory category: source) {
                result.add(convert(category));
            }
        }
        return result;
    }

    @NonNull
    public static Insurance convert(@NonNull NWInsurance source) {
        if (source == null) return null;
        return new Insurance(
                source.getId(),
                source.getTitle(),
                source.getNumber(),
                source.getStartDate(),
                source.getInsurancePremium(),
                source.getEndDate(),
                convertInsuranceParticipantList(source.getOwners()),
                convertInsuranceParticipantList(source.getInsurers()),
                convertInsuranceParticipantList(source.getInsured()),
                convertInsuranceParticipantList(source.getDrivers()),
                source.getInsuranceProduct(),
                source.getCanBeRenewed(),
                source.getRenewUrl(),
                null,
                source.getInsuredObject(),
                ObjectConverter.convert(source.getPhone()),
                null,
                source.getClinicIdList(),
                source.getAccessClinicPhone(),
                null,
                source.getArchiveDate(),
                source.getFileLink(),
                source.getHelpFileLink());
    }

    @NonNull
    public static InsuranceParticipant convert(@NonNull NWInsuranceParticipant source) {
        if (source == null) return null;
        return new InsuranceParticipant(
                LocationConverter.convert(source.getAddress()),
                source.getBirthday(),
                source.getContactInfo(),
                source.getEmail(),
                source.getFirstName(),
                source.getId(),
                source.getLastName(),
                source.getPatronymic(),
                source.getSex());
    }

    @NonNull
    public static InsuranceFieldGroup convert(@NonNull NWInsuranceFieldGroup source) {
        if (source == null) return null;
        return new InsuranceFieldGroup(
                null,
                source.getTitle());
    }

    @NonNull
    public static InsuranceCategory convert(@NonNull NWInsuranceCategory source) {
        if (source == null) return null;
        return new InsuranceCategory(
                source.getDaysToNotify(),
                source.getId(),
                StringObject.convertStringList(source.getProductIds()),
                source.getSubtitle(),
                source.getTermsUrl(),
                source.getTitle(),
                null);
    }
}
