package com.panichmaxim.alphastrah.controller.db.json;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.annimon.stream.function.Function;
import com.google.gson.Gson;
import com.panichmaxim.alphastrah.controller.db.DatabaseEndpoint;
import com.panichmaxim.alphastrah.controller.network.GsonFactory;
import com.panichmaxim.alphastrah.utils.Security;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import se.simbio.encryption.Encryption;

public final class JsonEndpoint<T> implements DatabaseEndpoint<T> {
    private static final String PREFIX_NAME = "json_db_";
    private final Context mContext;
    private final String mFilename;
    private final Gson mGson;
    private final Function<T, String> mIdMapper;
    private HashMap<String, T> mItems;
    private final Type mType;
    private Encryption mEncryption;
    
    JsonEndpoint(@NonNull Function<T, String> idMapper, @NonNull String filename, @NonNull Context context, @NonNull Type type) {
        this.mGson = GsonFactory.createDatabase();
        this.mIdMapper = idMapper;
        this.mFilename = PREFIX_NAME + filename;
        this.mContext = context;
        this.mType = type;
        this.mEncryption = Encryption.getDefault("Key", "Salt", new byte[16]);
    }
    
    public final synchronized void saveItems(@NonNull List<T> items) {
        if (mItems == null) restore();
        for (T item : items) {
            mItems.put(this.mIdMapper.apply(item), item);
        }
        save();
    }
    
    @Override
    public void saveItem(@NonNull T item) {
        if (this.mItems == null) restore();
        mItems.put(this.mIdMapper.apply(item), item);
        save();
    }
    
    @NonNull
    public final synchronized List<T> getItems() {
        if (this.mItems == null) restore();
        return new ArrayList(this.mItems.values());
    }
    
    @Nullable
    public final synchronized T getItem(@NonNull String id) {
        if (this.mItems == null) restore();
        return mItems.get(id);
    }
    
    public final synchronized void removeItem(@NonNull String id) {
        if (this.mItems == null) restore();
        this.mItems.remove(id);
        save();
    }
    
    private void save() {
        FileOutputStream outputStream = null;
        try {
            String serializedForm = Security.encrypt(this.mGson.toJson(this.mItems));
            outputStream = this.mContext.openFileOutput(this.mFilename, Context.MODE_PRIVATE);
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
            this.mItems = this.mGson.fromJson(Security.decrypt(stringBuilder.toString()), this.mType);
        } catch (Throwable e2) {
            
        }
        if (this.mItems == null) {
            this.mItems = new HashMap<>();
        }
    }
    
}
