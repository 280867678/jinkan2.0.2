package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;
import me.tvspark.outline;

/* renamed from: com.umeng.analytics.pro.am */
/* loaded from: classes4.dex */
public class C1551am extends SQLiteOpenHelper {

    /* renamed from: b */
    public static final Object f3100b = new Object();

    /* renamed from: c */
    public static C1551am f3101c = null;

    /* renamed from: d */
    public static final String f3102d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";

    /* renamed from: e */
    public static final String f3103e = "DROP TABLE IF EXISTS stf";

    /* renamed from: f */
    public static final String f3104f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";

    /* renamed from: a */
    public final Context f3105a;

    public C1551am(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.f3105a = context;
    }

    /* renamed from: a */
    public static final int m1297a() {
        return 1;
    }

    /* renamed from: a */
    public static C1551am m1296a(Context context) {
        C1551am c1551am;
        synchronized (f3100b) {
            if (f3101c == null) {
                f3101c = new C1551am(context, C1553ao.f3113b, null, 1);
            }
            c1551am = f3101c;
        }
        return c1551am;
    }

    /* renamed from: a */
    private void m1295a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f3103e);
            sQLiteDatabase.execSQL(f3102d);
        } catch (SQLException unused) {
        }
    }

    /* renamed from: b */
    private void m1288b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f3102d);
        } catch (SQLiteDatabaseCorruptException unused) {
            m1295a(sQLiteDatabase);
        } catch (Throwable th) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("--->>> [有状态]创建二级缓存数据库失败: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.getMessage());
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* renamed from: d */
    private void m1285d() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.execSQL(f3104f);
            } catch (Throwable unused) {
            }
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public Cursor m1290a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null && writableDatabase.isOpen()) {
                return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
        if (r1 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x007a, code lost:
        return r0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C1552an m1294a(String str) {
        Cursor cursor;
        C1552an c1552an = null;
        try {
            cursor = m1290a(str, new String[]{C1553ao.f3120i, C1553ao.f3116e, C1553ao.f3117f, C1553ao.f3118g, C1553ao.f3121j, C1553ao.f3122k}, null, null, null, null, null, "1");
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        C1552an c1552an2 = new C1552an();
                        try {
                            c1552an2.f3106a = cursor.getString(0);
                            c1552an2.f3107b = cursor.getString(1);
                            String string = cursor.getString(2);
                            String string2 = cursor.getString(3);
                            c1552an2.f3108c = C1636i.m1056a(this.f3105a).m1031d(string);
                            c1552an2.f3109d = C1636i.m1056a(this.f3105a).m1031d(string2);
                            c1552an2.f3110e = cursor.getString(4);
                            c1552an2.f3111f = cursor.getString(5);
                            c1552an = c1552an2;
                        } catch (Throwable unused) {
                            c1552an = c1552an2;
                            try {
                                m1285d();
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    /* renamed from: a */
    public void m1293a(String str, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insert(str, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
            } catch (Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public void m1292a(String str, String str2) {
        m1291a(str, "_uuid=?", new String[]{str2});
    }

    /* renamed from: a */
    public void m1291a(String str, String str2, String[] strArr) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.delete(str, str2, strArr);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: b */
    public void m1289b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            writableDatabase.close();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public boolean m1287b(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.isOpen()) {
                        cursor = sQLiteDatabase.query(str, null, null, null, null, null, null, null);
                    }
                } catch (Throwable unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase == null) {
                        return false;
                    }
                    sQLiteDatabase.close();
                    return false;
                }
            }
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    cursor.close();
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return true;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase == null) {
                return false;
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
        sQLiteDatabase.close();
        return false;
    }

    /* renamed from: c */
    public boolean m1286c() {
        return !m1287b(C1553ao.f3114c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m1288b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
