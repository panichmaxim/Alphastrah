package com.panichmaxim.alphastrah.controller.db;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;

public interface DatabaseEndpoint<T> {
    @Nullable
    T getItem(@NonNull String str);

    @NonNull
    List<T> getItems();

    void removeItem(@NonNull String str);

    void saveItems(@NonNull List<T> list);

    void saveItem(@NonNull T item);
}
