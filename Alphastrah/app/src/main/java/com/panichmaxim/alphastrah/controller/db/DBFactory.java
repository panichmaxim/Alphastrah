package com.panichmaxim.alphastrah.controller.db;

import android.support.annotation.NonNull;
import com.panichmaxim.alphastrah.controller.db.json.JsonDb;

public class DBFactory {
    private static final Database JSON_DB;

    static {
        JSON_DB = new JsonDb();
    }

    private DBFactory() {
    }

    @NonNull
    public static Database create() {
        return JSON_DB;
    }
}
