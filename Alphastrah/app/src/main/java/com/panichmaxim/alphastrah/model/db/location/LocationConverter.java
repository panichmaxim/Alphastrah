package com.panichmaxim.alphastrah.model.db.location;

import android.support.annotation.NonNull;

import com.panichmaxim.alphastrah.model.db.objects.ObjectConverter;
import com.panichmaxim.alphastrah.model.network.location.NWAddress;
import com.panichmaxim.alphastrah.model.network.location.NWCoordinate;
import com.panichmaxim.alphastrah.model.network.location.NWSto;

public class LocationConverter {

    @NonNull
    public static Address convert(@NonNull NWAddress source) {
        if (source == null) return null;
        return new Address(
                source.getCity(),
                source.getCountry(),
                source.getIndex(),
                source.getLocalAddress());
    }

    @NonNull
    public static Coordinate convert(@NonNull NWCoordinate source) {
        if (source == null) return null;
        return new Coordinate(
                source.getLat(),
                source.getLon());
    }

    @NonNull
    public static Sto convert(@NonNull NWSto source) {
        if (source == null) return null;
        return new Sto(
                source.getId(),
                source.getAddress(),
                convert(source.getCoordinate()),
                source.getDealer(),
                ObjectConverter.convertList(source.getPhones()),
                source.getServiceHours(),
                source.getTitle());
    }
}
