package com.panichmaxim.alphastrah.model.network.auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Account {
    @SerializedName("id")
    private int id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("patronymic")
    private String patronymic;
    @SerializedName("phone")
    private Phone phone;
    @SerializedName("birth_date")
    private Date birthday;
    @SerializedName("email")
    private String email;


    public Account(@NonNull int id, @NonNull String firstName, @NonNull String lastName, @NonNull String patronymic, @NonNull Phone phone, @NonNull Date birthday, @NonNull String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.birthday = birthday;
        this.email = email;
    }

    @NonNull
    public int getId() {
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
    public String getPatronymic() {
        return this.patronymic;
    }

    @NonNull
    public Phone getPhone() {
        return this.phone;
    }

    @NonNull
    public Object getBirthday() {
        return this.birthday;
    }

    @NonNull
    public String getEmail() {
        return this.email;
    }

}
