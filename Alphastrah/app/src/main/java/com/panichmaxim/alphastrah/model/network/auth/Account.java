package com.panichmaxim.alphastrah.model.network.auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.panichmaxim.alphastrah.model.network.objects.Phone;

import java.util.Date;

public class Account {
    @SerializedName("id")
    private int mId;
    @SerializedName("first_name")
    private String mFirstName;
    @SerializedName("last_name")
    private String mLastName;
    @SerializedName("patronymic")
    private String mPatronymic;
    @SerializedName("phone")
    private Phone mPhone;
    @SerializedName("birth_date")
    private Date mBirthday;
    @SerializedName("email")
    private String mEmail;


    public Account(@NonNull int id, @NonNull String firstName, @NonNull String lastName, @NonNull String patronymic, @NonNull Phone phone, @NonNull Date birthday, @NonNull String email) {
        this.mId = id;
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mPatronymic = patronymic;
        this.mPhone = phone;
        this.mBirthday = birthday;
        this.mEmail = email;
    }

    @NonNull
    public int getId() {
        return this.mId;
    }

    @NonNull
    public String getFirstName() {
        return this.mFirstName;
    }

    @NonNull
    public String getLastName() {
        return this.mLastName;
    }

    @Nullable
    public String getPatronymic() {
        return this.mPatronymic;
    }

    @NonNull
    public Phone getPhone() {
        return this.mPhone;
    }

    @NonNull
    public Object getBirthday() {
        return this.mBirthday;
    }

    @NonNull
    public String getEmail() {
        return this.mEmail;
    }

}
