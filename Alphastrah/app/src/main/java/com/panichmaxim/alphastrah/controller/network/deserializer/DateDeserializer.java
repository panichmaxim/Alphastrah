package com.panichmaxim.alphastrah.controller.network.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Date;

public final class DateDeserializer implements JsonDeserializer<Date>, JsonSerializer<Date> {

    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return new Date(Long.valueOf(json.getAsJsonPrimitive().getAsLong() * 1000).longValue());
    }

    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(Long.valueOf(src.getTime() / 1000));
    }
}