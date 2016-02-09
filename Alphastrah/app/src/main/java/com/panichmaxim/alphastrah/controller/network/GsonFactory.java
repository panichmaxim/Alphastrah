package com.panichmaxim.alphastrah.controller.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.panichmaxim.alphastrah.controller.network.deserializer.DateDeserializer;

import java.util.Date;

public class GsonFactory {

    public static Gson create() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
        return gsonBuilder.create();
    }

    public static Gson createDatabase() {
        return new GsonBuilder().create();
    }
}
