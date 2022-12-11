package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.umeng.analytics.pro.h */
/* loaded from: classes4.dex */
public class C1635h {
    /* renamed from: a */
    public static String m1061a(List<String> list) {
        return TextUtils.join("!", list);
    }

    /* renamed from: a */
    public static List<String> m1063a(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }

    /* renamed from: a */
    public static void m1066a(Context context) {
        if (context == null) {
            return;
        }
        try {
            File databasePath = context.getDatabasePath(C1616e.f3362b);
            if (databasePath != null && databasePath.exists()) {
                databasePath.delete();
            }
            C1629f.m1080a(context).m1081a();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m1064a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("alter table " + str + " add " + str2 + StringUtils.SPACE + str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        if (r9.isClosed() == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r9.isClosed() == false) goto L13;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m1065a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query(str, null, null, null, null, null, "LIMIT 0");
            if (cursor != null) {
                if (cursor.getColumnIndex(str2) != -1) {
                    z = true;
                }
            }
            if (cursor != null) {
            }
        } catch (Exception unused) {
            if (cursor != null) {
            }
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r1 == null) goto L14;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m1062a(String str, SQLiteDatabase sQLiteDatabase) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("sqlite_master", new String[]{"count(*)"}, "type=? and name=?", new String[]{"table", str.trim()}, null, null, null, null);
            if (cursor.moveToNext()) {
                if (cursor.getInt(0) > 0) {
                    z = true;
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
        return z;
    }

    /* renamed from: b */
    public static String m1060b(Context context) {
        File databasePath = context.getDatabasePath(C1616e.f3362b);
        return databasePath.getParent() + File.separator;
    }

    /* renamed from: b */
    public static List<String> m1059b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : list) {
                if (Collections.frequency(arrayList, str) < 1) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: c */
    public static String m1058c(Context context) {
        return m1060b(context) + "subprocess/";
    }
}
