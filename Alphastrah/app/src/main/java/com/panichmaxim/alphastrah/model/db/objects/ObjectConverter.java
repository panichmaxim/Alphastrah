package com.panichmaxim.alphastrah.model.db.objects;

import android.support.annotation.NonNull;

import com.panichmaxim.alphastrah.model.network.objects.NWPhone;

import java.util.ArrayList;
import java.util.List;

public class ObjectConverter {

    @NonNull
    public static List<Phone> convertList(@NonNull List<NWPhone> source) {
        List<Phone> result = new ArrayList<>();
        if (source != null) {
            for (NWPhone phone: source) {
                result.add(convert(phone));
            }
        }
        return result;
    }

    @NonNull
    public static Phone convert(@NonNull NWPhone source) {
        if (source == null) return null;
        return new Phone(
                source.getForHuman(),
                source.getForSystem(),
                source.getIpId());
    }

}
