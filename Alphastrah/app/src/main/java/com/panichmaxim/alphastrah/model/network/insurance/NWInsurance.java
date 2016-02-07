package com.panichmaxim.alphastrah.model.network.insurance;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.objects.NWPhone;
import java.util.Date;
import java.util.List;

public class NWInsurance {
    @SerializedName("id")
    private String mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("contract_number")
    private String mNumber;
    @SerializedName("start_date")
    private Date mStartDate;
    @SerializedName("InsurancePremium")
    private String mInsurancePremium;
    @SerializedName("end_date")
    private Date mEndDate;
    @SerializedName("owner_participants")
    private List<NWInsuranceParticipant> mOwners;
    @SerializedName("insurer_participants")
    private List<NWInsuranceParticipant> mInsurers;
    @SerializedName("insured_participants")
    private List<NWInsuranceParticipant> mInsured;
    @SerializedName("drivers")
    private List<NWInsuranceParticipant> mDrivers;
    @SerializedName("product_id")
    private String mInsuranceProduct;
    @SerializedName("renew_available")
    private Boolean mCanBeRenewed;
    @SerializedName("renew_url")
    private String mRenewUrl;
    @SerializedName("field_group_list")
    private List<NWInsuranceFieldGroup> mInsuranceFieldGroups;
    @SerializedName("insured_object")
    private String mInsuredObject;
    @SerializedName("emergency_phone")
    private NWPhone mPhone;
    @SerializedName("sos_activities")
    private List<SosActivities> mSosActivities;
    @SerializedName("clinic_id_list")
    private List<String> mClinicIdList;
    @SerializedName("access_clinic_phone")
    private Boolean mAccessClinicPhone;
    @SerializedName("type")
    private InsuranceType mType;
    @SerializedName("archive_date")
    private Date mArchiveDate;
    @SerializedName("file_link")
    private String mFileLink;
    @SerializedName("help_file")
    private String mHelpFileLink;

    @Nullable
    public String getHelpFileLink() {
        return mHelpFileLink;
    }

    @NonNull
    public String getId() {
        return mId;
    }

    @NonNull
    public String getTitle() {
        return mTitle;
    }

    @NonNull
    public String getNumber() {
        return mNumber;
    }

    @NonNull
    public Date getStartDate() {
        return mStartDate;
    }

    @Nullable
    public String getInsurancePremium() {
        return mInsurancePremium;
    }

    @NonNull
    public Date getEndDate() {
        return mEndDate;
    }

    @NonNull
    public List<NWInsuranceParticipant> getOwners() {
        return mOwners;
    }

    @Nullable
    public List<NWInsuranceParticipant> getInsurers() {
        return mInsurers;
    }

    @Nullable
    public List<NWInsuranceParticipant> getInsured() {
        return mInsured;
    }

    @Nullable
    public List<NWInsuranceParticipant> getDrivers() {
        return mDrivers;
    }

    @NonNull
    public String getInsuranceProduct() {
        return mInsuranceProduct;
    }

    @Nullable
    public Boolean getCanBeRenewed() {
        return mCanBeRenewed;
    }

    @Nullable
    public String getRenewUrl() {
        return mRenewUrl;
    }

    @NonNull
    public List<NWInsuranceFieldGroup> getInsuranceFieldGroups() {
        return mInsuranceFieldGroups;
    }

    @NonNull
    public String getInsuredObject() {
        return mInsuredObject;
    }

    @NonNull
    public NWPhone getPhone() {
        return mPhone;
    }

    @NonNull
    public List<SosActivities> getSosActivities() {
        return mSosActivities;
    }

    @Nullable
    public List<String> getClinicIdList() {
        return mClinicIdList;
    }

    @Nullable
    public Boolean getAccessClinicPhone() {
        return mAccessClinicPhone;
    }

    @NonNull
    public InsuranceType getType() {
        return mType;
    }

    @NonNull
    public Date getArchiveDate() {
        return mArchiveDate;
    }

    @Nullable
    public String getFileLink() {
        return mFileLink;
    }
}
