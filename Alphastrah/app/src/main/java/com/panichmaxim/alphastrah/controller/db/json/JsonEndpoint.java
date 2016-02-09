package com.panichmaxim.alphastrah.controller.db.json;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.annimon.stream.function.Function;
import com.google.gson.Gson;
import com.panichmaxim.alphastrah.controller.db.DatabaseEndpoint;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class JsonEndpoint<T> implements DatabaseEndpoint<T> {
    private static final String PREFIX_NAME = "json_db_";
    private final Context mContext;
    private final String mFilename;
    private final Gson mGson;
    private final Function<T, String> mIdMapper;
    private Collection<T> mItems;
    private final Type mType;

    JsonEndpoint(@NonNull Function<T, String> idMapper, @NonNull String filename, @NonNull Context context, @NonNull Type type) {
        this.mGson = GsonFactory.createDatabase();
        this.mIdMapper = idMapper;
        this.mFilename = PREFIX_NAME + filename;
        this.mContext = context;
        this.mType = type;
    }

    public final synchronized boolean saveItems(@NonNull List<T> items) {
        mainThreadWarning();
        this.mItems = new ArrayList(items);
        save();
        return !this.mItems.isEmpty();
    }

    @NonNull
    public final synchronized List<T> getItems() {
        mainThreadWarning();
        if (this.mItems == null) {
            restore();
        }
        return new ArrayList(this.mItems);
    }

    @Nullable
    public final synchronized T getItem(@NonNull String id) {
        T result = null;
        mainThreadWarning();
        if (this.mItems == null) {
            restore();
        }
        for (T item2 : this.mItems) {
            if (((String) this.mIdMapper.apply(item2)).equals(id)) {
                result = item2;
                break;
            }
        }
        return result;
    }

    public final synchronized void removeItem(@NonNull String id) {
        T item = getItem(id);
        if (item != null) {
            this.mItems.remove(item);
            save();
        }
    }

    private void save() {
        String serializedForm = this.mGson.toJson(this.mItems);
        FileOutputStream outputStream = null;
        try {
            outputStream = this.mContext.openFileOutput(this.mFilename, 0);
            outputStream.write(serializedForm.getBytes());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (Throwable e2) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
        }
    }

    private void restore() {
        FileInputStream fileInputStream = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (this.mContext.getFileStreamPath(this.mFilename).exists()) {
                fileInputStream = this.mContext.openFileInput(this.mFilename);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuilder.append(line);
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (Throwable e2) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                }
            }
        }
        try {
            this.mItems = (Collection) this.mGson.fromJson(stringBuilder.toString(), this.mType);
        } catch (Throwable e22) {
        }
        if (this.mItems == null) {
            this.mItems = new ArrayList();
        }
    }

    private static void mainThreadWarning() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.d("ERROR", "UI Thread will freeze");
        }
    }
}
