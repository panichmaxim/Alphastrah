package com.panichmaxim.alphastrah.controller.db.json;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
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

import javax.crypto.Cipher;

import se.simbio.encryption.Encryption;

public final class JsonEndpoint<T> implements DatabaseEndpoint<T> {
    private static final String PREFIX_NAME = "json_db_";
    private final Context mContext;
    private final String mFilename;
    private final Gson mGson;
    private final Type mType;
    private final Function<T, String> mIdMapper;
    private Collection<T> mItems;
    private Encryption mEncryption;

    JsonEndpoint(@NonNull Function<T, String> idMapper, @NonNull String filename, @NonNull Context context, @NonNull Type type) {
        this.mGson = GsonFactory.createDatabase();
        this.mIdMapper = idMapper;
        this.mFilename = PREFIX_NAME + filename;
        this.mContext = context;
        this.mType = type;
        this.mEncryption = Encryption.getDefault("Key", "Salt", new byte[16]);
    }

    public final synchronized boolean saveItems(@NonNull List<T> items) {
        this.mItems = new ArrayList(items);
        save();
        return !this.mItems.isEmpty();
    }

    @NonNull
    public final synchronized List<T> getItems() {
        if (this.mItems == null) {
            restore();
        }
        return new ArrayList(this.mItems);
    }

    @Nullable
    public final synchronized T getItem(@NonNull String id) {
        T result = null;
        if (this.mItems == null) {
            restore();
        }
        for (T item : this.mItems) {
            if ((this.mIdMapper.apply(item)).equals(id)) {
                result = item;
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
            outputStream.write(mEncryption.encryptOrNull(serializedForm).getBytes());
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
            this.mItems = this.mGson.fromJson(mEncryption.decryptOrNull(stringBuilder.toString()), this.mType);
        } catch (Throwable e22) {
        }
        if (this.mItems == null) {
            this.mItems = new ArrayList();
        }
    }

}
