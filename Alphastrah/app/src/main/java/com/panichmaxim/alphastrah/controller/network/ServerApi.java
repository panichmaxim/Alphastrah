package com.panichmaxim.alphastrah.controller.network;

import android.support.annotation.NonNull;
import retrofit.http.Body;
import retrofit.http.POST;

import com.panichmaxim.alphastrah.controller.network.request.EstablishSessionRequest;
import com.panichmaxim.alphastrah.controller.network.response.auth.AuthorizeResponse;
import com.panichmaxim.alphastrah.controller.network.response.ServerResponse;

public interface ServerApi {
    @POST("/sessions/establish")
    ServerResponse<AuthorizeResponse> authorize(@Body @NonNull EstablishSessionRequest establishSessionRequest);
}
