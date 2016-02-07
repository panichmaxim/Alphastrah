package com.panichmaxim.alphastrah.controller.network;

import android.support.annotation.NonNull;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.Callback;
import com.panichmaxim.alphastrah.controller.network.request.EstablishSessionRequest;
import com.panichmaxim.alphastrah.controller.network.response.auth.AuthorizeResponse;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;
import com.panichmaxim.alphastrah.controller.network.response.insurance.InsurancesCategoriesResponse;
import com.panichmaxim.alphastrah.controller.network.response.insurance.InsurancesResponse;
import com.panichmaxim.alphastrah.controller.network.response.notification.NotificationsResponse;

public interface ServerApi {
    @POST("/sessions/establish")
    void authorize(@Body @NonNull EstablishSessionRequest establishSessionRequest, Callback<ServerResponse<AuthorizeResponse>> callback);

    @GET("/insurances")
    void getInsurances(Callback<ServerResponse<InsurancesResponse>> callback);

    @GET("/insurances/categories")
    void getInsuranceCategories(Callback<ServerResponse<InsurancesCategoriesResponse>> callback);

    @GET("/notifications")
    void getNotifications(Callback<ServerResponse<NotificationsResponse>> callback);


}
