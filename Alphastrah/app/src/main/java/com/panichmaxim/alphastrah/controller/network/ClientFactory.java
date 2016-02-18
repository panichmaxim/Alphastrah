package com.panichmaxim.alphastrah.controller.network;

import android.support.annotation.NonNull;

import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;
import retrofit.client.OkClient;

public final class ClientFactory {

    // http://stackoverflow.com/questions/24006545/how-can-i-pin-a-certificate-with-square-okhttp
    // 3rd answer
    @NonNull
    public static OkClient create() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(120000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(120000, TimeUnit.MILLISECONDS);
        client.setCertificatePinner(new CertificatePinner.Builder().add(NetworkConstants.BASE_URL, NetworkConstants.PIN).build());
        return new OkClient(client);
    }

}
