package com.arialyy.aria.orm;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.arialyy.aria.util.CommonUtil;
import java.io.File;
import java.io.IOException;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class DatabaseContext extends ContextWrapper {
    public DatabaseContext(Context context) {
        super(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CommonUtil.getAppPath(getBaseContext()), "DB");
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "/", str);
        File file = new File(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (!file.exists()) {
            file.mkdirs();
        }
        boolean z = false;
        File file2 = new File(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        if (!file2.exists()) {
            try {
                z = file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            z = true;
        }
        if (z) {
            return file2;
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
    }
}
