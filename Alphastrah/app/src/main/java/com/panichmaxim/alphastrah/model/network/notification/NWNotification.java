package com.panichmaxim.alphastrah.model.network.notification;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.location.NWSto;
import com.panichmaxim.alphastrah.model.network.objects.NWPhone;
import com.panichmaxim.alphastrah.model.utils.ModelObject;
import java.util.Date;
import java.util.List;

public class NWNotification extends ModelObject {
    @SerializedName("important")
    private Boolean isImportant;
    @SerializedName("appointment_id")
    private String mAppointmentId;
    @SerializedName("date")
    private Date mDate;
    @SerializedName("event_number")
    private String mEventNumber;
    @SerializedName("field_list")
    private List<NWNotificationField> mFields;
    @SerializedName("id")
    private String mId;
    @SerializedName("insurance_id")
    private String mInsuranceId;
    @SerializedName("phone")
    private NWPhone mPhone;
    @SerializedName("annotation")
    private String mShortDescription;
    @SerializedName("stoa")
    private NWSto mSto;
    @SerializedName("full_text")
    private String mText;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private NotificationType mType;
    @SerializedName("user_request_date")
    private Date mUserRequestDate;

    @NonNull
    public String getId() {
        return this.mId;
    }

    @NonNull
    public String getTitle() {
        return this.mTitle;
    }

    @NonNull
    public String getShortDescription() {
        return this.mShortDescription;
    }

    @NonNull
    public String getText() {
        return this.mText;
    }

    @NonNull
    public Date getDate() {
        return this.mDate;
    }

    @NonNull
    public Boolean getIsImportant() {
        return this.isImportant;
    }

    @NonNull
    public String getInsuranceId() {
        return this.mInsuranceId;
    }

    @Nullable
    public NWSto getSto() {
        return this.mSto;
    }

    @Nullable
    public String getAppointmentId() {
        return this.mAppointmentId;
    }

    @Nullable
    public List<NWNotificationField> getFields() {
        return this.mFields;
    }

    @Nullable
    public NWPhone getPhone() {
        return this.mPhone;
    }

    @NonNull
    public Date getUserRequestDate() {
        return this.mUserRequestDate;
    }

    @NonNull
    public String getEventNumber() {
        return this.mEventNumber;
    }

    @NonNull
    public NotificationType getType() {
        return this.mType;
    }
}
