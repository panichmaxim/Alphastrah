package com.panichmaxim.alphastrah.model.network.insurance;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.objects.Phone;
import java.util.Date;
import java.util.List;

public class Insurance {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("contract_number")
    private String number;
    @SerializedName("start_date")
    private Date startDate;
    @SerializedName("InsurancePremium")
    private String insurancePremium;
    @SerializedName("end_date")
    private Date endDate;
    @SerializedName("owner_participants")
    private List<InsuranceParticipant> owners;
    @SerializedName("insurer_participants")
    private List<InsuranceParticipant> insurers;
    @SerializedName("insured_participants")
    private List<InsuranceParticipant> insured;
    @SerializedName("drivers")
    private List<InsuranceParticipant> drivers;
    @SerializedName("product_id")
    private String insuranceProduct;
    @SerializedName("renew_available")
    private Boolean canBeRenewed;
    @SerializedName("renew_url")
    private String renewUrl;
    @SerializedName("field_group_list")
    private List<InsuranceFieldGroup> insuranceFieldGroups;
    @SerializedName("insured_object")
    private String insuredObject;
    @SerializedName("emergency_phone")
    private Phone phone;
    @SerializedName("sos_activities")
    private List<SosActivities> sosActivities;
    @SerializedName("clinic_id_list")
    private List<String> clinicIdList;
    @SerializedName("access_clinic_phone")
    private Boolean accessClinicPhone;
    @SerializedName("type")
    private InsuranceType type;
    @SerializedName("archive_date")
    private Date archiveDate;
    @SerializedName("file_link")
    private String fileLink;
    @SerializedName("help_file")
    private String helpFileLink;

    @Nullable
    public String getHelpFileLink() {
        return helpFileLink;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getNumber() {
        return number;
    }

    @NonNull
    public Date getStartDate() {
        return startDate;
    }

    @Nullable
    public String getInsurancePremium() {
        return insurancePremium;
    }

    @NonNull
    public Date getEndDate() {
        return endDate;
    }

    @NonNull
    public List<InsuranceParticipant> getOwners() {
        return owners;
    }

    @Nullable
    public List<InsuranceParticipant> getInsurers() {
        return insurers;
    }

    @Nullable
    public List<InsuranceParticipant> getInsured() {
        return insured;
    }

    @Nullable
    public List<InsuranceParticipant> getDrivers() {
        return drivers;
    }

    @NonNull
    public String getInsuranceProduct() {
        return insuranceProduct;
    }

    @Nullable
    public Boolean getCanBeRenewed() {
        return canBeRenewed;
    }

    @Nullable
    public String getRenewUrl() {
        return renewUrl;
    }

    @NonNull
    public List<InsuranceFieldGroup> getInsuranceFieldGroups() {
        return insuranceFieldGroups;
    }

    @NonNull
    public String getInsuredObject() {
        return insuredObject;
    }

    @NonNull
    public Phone getPhone() {
        return phone;
    }

    @NonNull
    public List<SosActivities> getSosActivities() {
        return sosActivities;
    }

    @Nullable
    public List<String> getClinicIdList() {
        return clinicIdList;
    }

    @Nullable
    public Boolean getAccessClinicPhone() {
        return accessClinicPhone;
    }

    @NonNull
    public InsuranceType getType() {
        return type;
    }

    @NonNull
    public Date getArchiveDate() {
        return archiveDate;
    }

    @Nullable
    public String getFileLink() {
        return fileLink;
    }
}
