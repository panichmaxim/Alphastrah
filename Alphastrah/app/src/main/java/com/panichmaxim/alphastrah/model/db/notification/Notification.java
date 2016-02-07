package com.panichmaxim.alphastrah.model.db.notification;

import com.panichmaxim.alphastrah.model.db.location.Sto;
import com.panichmaxim.alphastrah.model.db.objects.Phone;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Notification extends RealmObject implements Serializable {
    @PrimaryKey
    private String mId;
    private Boolean isImportant;
    private String mAppointmentId;
    private Date mDate;
    private String mEventNumber;
    private RealmList<NotificationField> mFields;
    private String mInsuranceId;
    private Phone mPhone;
    private String mShortDescription;
    private Sto mSto;
    private String mText;
    private String mTitle;
    private String mType;
    private Date mUserRequestDate;

    public Notification() {
    }

    public Notification(String mId, Boolean isImportant, String mAppointmentId, Date mDate, String mEventNumber, List<NotificationField> mFields, String mInsuranceId, Phone mPhone, String mShortDescription, Sto mSto, String mText, String mTitle, String mType, Date mUserRequestDate) {
        this.mId = mId;
        this.isImportant = isImportant;
        this.mAppointmentId = mAppointmentId;
        this.mDate = mDate;
        this.mEventNumber = mEventNumber;
        this.mFields = new RealmList<>(mFields.toArray(new NotificationField[mFields.size()]));;
        this.mInsuranceId = mInsuranceId;
        this.mPhone = mPhone;
        this.mShortDescription = mShortDescription;
        this.mSto = mSto;
        this.mText = mText;
        this.mTitle = mTitle;
        this.mType = mType;
        this.mUserRequestDate = mUserRequestDate;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public Boolean getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(Boolean isImportant) {
        this.isImportant = isImportant;
    }

    public String getmAppointmentId() {
        return mAppointmentId;
    }

    public void setmAppointmentId(String mAppointmentId) {
        this.mAppointmentId = mAppointmentId;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmEventNumber() {
        return mEventNumber;
    }

    public void setmEventNumber(String mEventNumber) {
        this.mEventNumber = mEventNumber;
    }

    public RealmList<NotificationField> getmFields() {
        return mFields;
    }

    public void setmFields(RealmList<NotificationField> mFields) {
        this.mFields = mFields;
    }

    public String getmInsuranceId() {
        return mInsuranceId;
    }

    public void setmInsuranceId(String mInsuranceId) {
        this.mInsuranceId = mInsuranceId;
    }

    public Phone getmPhone() {
        return mPhone;
    }

    public void setmPhone(Phone mPhone) {
        this.mPhone = mPhone;
    }

    public String getmShortDescription() {
        return mShortDescription;
    }

    public void setmShortDescription(String mShortDescription) {
        this.mShortDescription = mShortDescription;
    }

    public Sto getmSto() {
        return mSto;
    }

    public void setmSto(Sto mSto) {
        this.mSto = mSto;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public Date getmUserRequestDate() {
        return mUserRequestDate;
    }

    public void setmUserRequestDate(Date mUserRequestDate) {
        this.mUserRequestDate = mUserRequestDate;
    }
}