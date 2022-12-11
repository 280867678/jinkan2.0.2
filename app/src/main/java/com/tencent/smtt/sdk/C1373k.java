package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import me.tvspark.outline;
import org.litepal.parser.LitePalParser;

/* renamed from: com.tencent.smtt.sdk.k */
/* loaded from: classes4.dex */
public class C1373k {

    /* renamed from: a */
    public static final String f2141a = CookieManager.LOGTAG;

    /* renamed from: b */
    public static File f2142b;

    /* renamed from: a */
    public static File m2581a(Context context) {
        if (f2142b == null && context != null) {
            f2142b = new File(context.getDir("webview", 0), "Cookies");
        }
        if (f2142b == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("/data/data/");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(context.getPackageName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(File.separator);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("app_webview");
            f2142b = new File(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, File.separator, "Cookies"));
        }
        return f2142b;
    }

    /* renamed from: a */
    public static String m2578a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        int count = rawQuery.getCount();
        int columnCount = rawQuery.getColumnCount();
        StringBuilder sb = new StringBuilder();
        sb.append(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("raws:", count, ",columns:", columnCount, "\n"));
        if (count <= 0 || !rawQuery.moveToFirst()) {
            return sb.toString();
        }
        do {
            sb.append("\n");
            for (int i = 0; i < columnCount; i++) {
                try {
                    sb.append(rawQuery.getString(i));
                    sb.append(",");
                } catch (Exception unused) {
                }
            }
            sb.append("\n");
        } while (rawQuery.moveToNext());
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r4.isOpen() == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r4.isOpen() == false) goto L15;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<String> m2579a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        if (sQLiteDatabase == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            cursor = sQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(1);
                    cursor.getString(4);
                    arrayList.add(string);
                    m2578a(sQLiteDatabase, string);
                } while (cursor.moveToNext());
                cursor.close();
            } else {
                cursor.close();
            }
        } catch (Throwable unused) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b6, code lost:
        if (r0.isOpen() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b8, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d0, code lost:
        if (r2.isEmpty() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d2, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d3, code lost:
        m2577b(r9);
        r10 = r2.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e2, code lost:
        if (r10.hasNext() == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e4, code lost:
        r11 = (java.util.Map.Entry) r10.next();
        com.tencent.smtt.sdk.CookieManager.getInstance().setCookie((java.lang.String) r11.getKey(), (java.lang.String) r11.getValue(), true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00fe, code lost:
        com.tencent.smtt.sdk.CookieManager.getInstance().flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0105, code lost:
        if (r12 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0107, code lost:
        m2579a(m2576c(r9));
        r10 = m2575d(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0113, code lost:
        if (r10 == (-1)) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0115, code lost:
        com.tencent.smtt.sdk.CookieManager.getInstance();
        com.tencent.smtt.sdk.CookieManager.setROMCookieDBVersion(r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x011b, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c9, code lost:
        if (r0.isOpen() == false) goto L43;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m2580a(Context context, CookieManager.EnumC1274a enumC1274a, String str, boolean z, boolean z2) {
        String[] split;
        SQLiteDatabase m2576c;
        if (context == null) {
            return;
        }
        if ((enumC1274a == CookieManager.EnumC1274a.MODE_KEYS && TextUtils.isEmpty(str)) || (split = str.split(",")) == null || split.length < 1 || (m2576c = m2576c(context)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Cursor cursor = null;
        try {
            cursor = m2576c.rawQuery("select * from cookies", null);
            if (cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                cursor.close();
            } else {
                do {
                    String string = cursor.getString(cursor.getColumnIndex("host_key"));
                    if (enumC1274a == CookieManager.EnumC1274a.MODE_KEYS) {
                        int length = split.length;
                        boolean z3 = false;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            } else if (string.equals(split[i])) {
                                z3 = true;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (!z3) {
                        }
                    }
                    hashMap.put(string, cursor.getString(cursor.getColumnIndex("value")) + ";" + cursor.getString(cursor.getColumnIndex("name")) + ";" + cursor.getInt(cursor.getColumnIndex("expires_utc")) + ";" + cursor.getInt(cursor.getColumnIndex("priority")));
                } while (cursor.moveToNext());
                cursor.close();
            }
        } catch (Throwable th) {
            try {
                th.toString();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                if (m2576c.isOpen()) {
                    m2576c.close();
                }
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public static boolean m2577b(Context context) {
        if (context == null) {
            return false;
        }
        FileUtil.m2188a(m2581a(context), false);
        return true;
    }

    /* renamed from: c */
    public static SQLiteDatabase m2576c(Context context) {
        File m2581a;
        SQLiteDatabase sQLiteDatabase = null;
        if (context == null || (m2581a = m2581a(context)) == null) {
            return null;
        }
        try {
            sQLiteDatabase = SQLiteDatabase.openDatabase(m2581a.getAbsolutePath(), null, 0);
        } catch (Exception unused) {
        }
        if (sQLiteDatabase == null) {
            TbsLog.m2155i(f2141a, "dbPath is not exist!");
        }
        return sQLiteDatabase;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
        r0 = java.lang.Integer.parseInt(r1.getString(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (r4.isOpen() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0064, code lost:
        if (r4.isOpen() != false) goto L27;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m2575d(Context context) {
        SQLiteDatabase sQLiteDatabase;
        System.currentTimeMillis();
        int i = 0;
        Cursor cursor = null;
        try {
            sQLiteDatabase = m2576c(context);
            if (sQLiteDatabase == null) {
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                return -1;
            }
            try {
                cursor = sQLiteDatabase.rawQuery("select * from meta", null);
                int count = cursor.getCount();
                cursor.getColumnCount();
                if (count > 0 && cursor.moveToFirst()) {
                    while (true) {
                        if (!cursor.getString(0).equals(LitePalParser.NODE_VERSION)) {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                cursor.close();
            } catch (Throwable unused) {
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                }
                return i;
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
    }
}
