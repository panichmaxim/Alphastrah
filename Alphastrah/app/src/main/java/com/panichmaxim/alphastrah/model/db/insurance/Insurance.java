package com.panichmaxim.alphastrah.model.db.insurance;

import com.panichmaxim.alphastrah.model.db.objects.Phone;
import com.panichmaxim.alphastrah.model.db.objects.StringObject;
import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Insurance extends RealmObject {
    @PrimaryKey
    private String mId;
    private String mTitle;
    private String mNumber;
    private Date mStartDate;
    private String mInsurancePremium;
    private Date mEndDate;
    private RealmList<InsuranceParticipant> mOwners;
    private RealmList<InsuranceParticipant> mInsurers;
    private RealmList<InsuranceParticipant> mInsured;
    private RealmList<InsuranceParticipant> mDrivers;
    private String mInsuranceProduct;
    private Boolean mCanBeRenewed;
    private String mRenewUrl;
    private RealmList<InsuranceFieldGroup> mInsuranceFieldGroups;
    private String mInsuredObject;
    private Phone mPhone;
    private RealmList<StringObject> mSosActivities;
    private RealmList<StringObject> mClinicIdList;
    private Boolean mAccessClinicPhone;
    private String mType;
    private Date mArchiveDate;
    private String mFileLink;
    private String mHelpFileLink;

    public Insurance() {
    }

    public Insurance(String mId, String mTitle, String mNumber, Date mStartDate, String mInsurancePremium, Date mEndDate, List<InsuranceParticipant> mOwners, List<InsuranceParticipant> mInsurers, List<InsuranceParticipant> mInsured, List<InsuranceParticipant> mDrivers, String mInsuranceProduct, Boolean mCanBeRenewed, String mRenewUrl, List<InsuranceFieldGroup> mInsuranceFieldGroups, String mInsuredObject, Phone mPhone, List<String> mSosActivities, List<String> mClinicIdList, Boolean mAccessClinicPhone, String mType, Date mArchiveDate, String mFileLink, String mHelpFileLink) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mNumber = mNumber;
        this.mStartDate = mStartDate;
        this.mInsurancePremium = mInsurancePremium;
        this.mEndDate = mEndDate;
        this.mOwners = new RealmList<>(mOwners.toArray(new InsuranceParticipant[mOwners.size()]));
        this.mInsurers = new RealmList<>(mInsurers.toArray(new InsuranceParticipant[mInsurers.size()]));
        this.mInsured = new RealmList<>(mInsured.toArray(new InsuranceParticipant[mInsured.size()]));
        this.mDrivers = new RealmList<>(mDrivers.toArray(new InsuranceParticipant[mDrivers.size()]));
        this.mInsuranceProduct = mInsuranceProduct;
        this.mCanBeRenewed = mCanBeRenewed;
        this.mRenewUrl = mRenewUrl;
        this.mInsuranceFieldGroups = new RealmList<>();
        // this.mInsuranceFieldGroups = new RealmList<>(mInsuranceFieldGroups.toArray(new InsuranceFieldGroup[mInsuranceFieldGroups.size()]));
        this.mInsuredObject = mInsuredObject;
        this.mPhone = mPhone;
        this.mSosActivities = new RealmList<>();
        // this.mSosActivities = new RealmList<>(mSosActivities.toArray(new StringObject[mSosActivities.size()]));
        this.mClinicIdList = new RealmList<>();
        // this.mClinicIdList = new RealmList<>(mClinicIdList.toArray(new StringObject[mClinicIdList.size()]));
        this.mAccessClinicPhone = mAccessClinicPhone;
        this.mType = mType;
        this.mArchiveDate = mArchiveDate;
        this.mFileLink = mFileLink;
        this.mHelpFileLink = mHelpFileLink;
    }

    public String getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmNumber() {
        return mNumber;
    }

    public Date getmStartDate() {
        return mStartDate;
    }

    public String getmInsurancePremium() {
        return mInsurancePremium;
    }

    public Date getmEndDate() {
        return mEndDate;
    }

    public RealmList<InsuranceParticipant> getmOwners() {
        return mOwners;
    }

    public RealmList<InsuranceParticipant> getmInsurers() {
        return mInsurers;
    }

    public RealmList<InsuranceParticipant> getmInsured() {
        return mInsured;
    }

    public RealmList<InsuranceParticipant> getmDrivers() {
        return mDrivers;
    }

    public String getmInsuranceProduct() {
        return mInsuranceProduct;
    }

    public Boolean getmCanBeRenewed() {
        return mCanBeRenewed;
    }

    public String getmRenewUrl() {
        return mRenewUrl;
    }

    public RealmList<InsuranceFieldGroup> getmInsuranceFieldGroups() {
        return mInsuranceFieldGroups;
    }

    public String getmInsuredObject() {
        return mInsuredObject;
    }

    public Phone getmPhone() {
        return mPhone;
    }

    public RealmList<StringObject> getmSosActivities() {
        return mSosActivities;
    }

    public RealmList<StringObject> getmClinicIdList() {
        return mClinicIdList;
    }

    public Boolean getmAccessClinicPhone() {
        return mAccessClinicPhone;
    }

    public String getmType() {
        return mType;
    }

    public Date getmArchiveDate() {
        return mArchiveDate;
    }

    public String getmFileLink() {
        return mFileLink;
    }

    public String getmHelpFileLink() {
        return mHelpFileLink;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public void setmStartDate(Date mStartDate) {
        this.mStartDate = mStartDate;
    }

    public void setmInsurancePremium(String mInsurancePremium) {
        this.mInsurancePremium = mInsurancePremium;
    }

    public void setmEndDate(Date mEndDate) {
        this.mEndDate = mEndDate;
    }

    public void setmOwners(RealmList<InsuranceParticipant> mOwners) {
        this.mOwners = mOwners;
    }

    public void setmInsurers(RealmList<InsuranceParticipant> mInsurers) {
        this.mInsurers = mInsurers;
    }

    public void setmInsured(RealmList<InsuranceParticipant> mInsured) {
        this.mInsured = mInsured;
    }

    public void setmDrivers(RealmList<InsuranceParticipant> mDrivers) {
        this.mDrivers = mDrivers;
    }

    public void setmInsuranceProduct(String mInsuranceProduct) {
        this.mInsuranceProduct = mInsuranceProduct;
    }

    public void setmCanBeRenewed(Boolean mCanBeRenewed) {
        this.mCanBeRenewed = mCanBeRenewed;
    }

    public void setmRenewUrl(String mRenewUrl) {
        this.mRenewUrl = mRenewUrl;
    }

    public void setmInsuranceFieldGroups(RealmList<InsuranceFieldGroup> mInsuranceFieldGroups) {
        this.mInsuranceFieldGroups = mInsuranceFieldGroups;
    }

    public void setmInsuredObject(String mInsuredObject) {
        this.mInsuredObject = mInsuredObject;
    }

    public void setmPhone(Phone mPhone) {
        this.mPhone = mPhone;
    }

    public void setmSosActivities(RealmList<StringObject> mSosActivities) {
        this.mSosActivities = mSosActivities;
    }

    public void setmClinicIdList(RealmList<StringObject> mClinicIdList) {
        this.mClinicIdList = mClinicIdList;
    }

    public void setmAccessClinicPhone(Boolean mAccessClinicPhone) {
        this.mAccessClinicPhone = mAccessClinicPhone;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public void setmArchiveDate(Date mArchiveDate) {
        this.mArchiveDate = mArchiveDate;
    }

    public void setmFileLink(String mFileLink) {
        this.mFileLink = mFileLink;
    }

    public void setmHelpFileLink(String mHelpFileLink) {
        this.mHelpFileLink = mHelpFileLink;
    }
}
