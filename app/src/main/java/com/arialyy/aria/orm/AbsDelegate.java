package com.arialyy.aria.orm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes3.dex */
public abstract class AbsDelegate {
    public static final String TAG = "AbsDelegate";

    public SQLiteDatabase checkDb(SQLiteDatabase sQLiteDatabase) {
        return SqlUtil.checkDb(sQLiteDatabase);
    }

    public void closeCursor(Cursor cursor) {
        SqlUtil.closeCursor(cursor);
    }
}
