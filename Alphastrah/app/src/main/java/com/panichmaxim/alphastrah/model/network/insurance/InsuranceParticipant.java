package com.panichmaxim.alphastrah.model.network.insurance;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.location.Address;

import java.util.Date;

public class InsuranceParticipant {
    @SerializedName("address")
    private Address address;
    @SerializedName("birth_date")
    private Date birthday;
    @SerializedName("contact_information")
    private String contactInfo;
    @SerializedName("email")
    private String email;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("id")
    private String id;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("patronymic")
    private String patronymic;
    @SerializedName("sex")
    private String sex;


    @NonNull
    public String getId() {
        return this.id;
    }

    @NonNull
    public String getFirstName() {
        return this.firstName;
    }

    @NonNull
    public String getLastName() {
        return this.lastName;
    }

    @Nullable
    public String getMiddleName() {
        return this.patronymic;
    }

    @NonNull
    public Date getBirthday() {
        return this.birthday;
    }

    @Nullable
    public String getSex() {
        return this.sex;
    }

    @Nullable
    public String getContactInfo() {
        return this.contactInfo;
    }

    @Nullable
    public Address getAddress() {
        return this.address;
    }

    @Nullable
    public String getEmail() {
        return this.email;
    }
}
