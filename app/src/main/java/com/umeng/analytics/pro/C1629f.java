package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1616e;

/* renamed from: com.umeng.analytics.pro.f */
/* loaded from: classes4.dex */
public class C1629f extends SQLiteOpenHelper {

    /* renamed from: b */
    public static Context f3428b;

    /* renamed from: a */
    public String f3429a;

    /* renamed from: com.umeng.analytics.pro.f$a */
    /* loaded from: classes4.dex */
    public static class C1631a {

        /* renamed from: a */
        public static final C1629f f3430a = new C1629f(C1629f.f3428b, C1635h.m1060b(C1629f.f3428b), C1616e.f3362b, null, 2);
    }

    public C1629f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, TextUtils.isEmpty(str) ? C1616e.f3362b : str, cursorFactory, i);
        this.f3429a = null;
        m1081a();
    }

    public C1629f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new C1605c(context, str), str2, cursorFactory, i);
    }

    /* renamed from: a */
    public static C1629f m1080a(Context context) {
        if (f3428b == null) {
            f3428b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C1631a.f3430a;
    }

    /* renamed from: a */
    private void m1079a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3429a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    /* renamed from: a */
    private void m1078a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }

    /* renamed from: b */
    private void m1076b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3429a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    /* renamed from: c */
    private void m1075c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3429a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    /* renamed from: d */
    private void m1074d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3429a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    /* renamed from: e */
    private void m1073e(SQLiteDatabase sQLiteDatabase) {
        if (!C1635h.m1065a(sQLiteDatabase, C1616e.C1626d.f3403a, "__av")) {
            C1635h.m1064a(sQLiteDatabase, C1616e.C1626d.f3403a, "__sp", "TEXT");
            C1635h.m1064a(sQLiteDatabase, C1616e.C1626d.f3403a, "__pp", "TEXT");
            C1635h.m1064a(sQLiteDatabase, C1616e.C1626d.f3403a, "__av", "TEXT");
            C1635h.m1064a(sQLiteDatabase, C1616e.C1626d.f3403a, "__vc", "TEXT");
        }
        if (!C1635h.m1065a(sQLiteDatabase, C1616e.C1620b.f3377a, "__av")) {
            C1635h.m1064a(sQLiteDatabase, C1616e.C1620b.f3377a, "__av", "TEXT");
            C1635h.m1064a(sQLiteDatabase, C1616e.C1620b.f3377a, "__vc", "TEXT");
        }
        if (!C1635h.m1065a(sQLiteDatabase, C1616e.C1617a.f3366a, "__av")) {
            C1635h.m1064a(sQLiteDatabase, C1616e.C1617a.f3366a, "__av", "TEXT");
            C1635h.m1064a(sQLiteDatabase, C1616e.C1617a.f3366a, "__vc", "TEXT");
        }
    }

    /* renamed from: f */
    private void m1072f(SQLiteDatabase sQLiteDatabase) {
        m1078a(sQLiteDatabase, C1616e.C1626d.f3403a);
        m1078a(sQLiteDatabase, C1616e.C1620b.f3377a);
        m1078a(sQLiteDatabase, C1616e.C1617a.f3366a);
        m1081a();
    }

    /* renamed from: a */
    public void m1081a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!C1635h.m1062a(C1616e.C1626d.f3403a, writableDatabase)) {
                m1075c(writableDatabase);
            }
            if (!C1635h.m1062a(C1616e.C1623c.f3390a, writableDatabase)) {
                m1074d(writableDatabase);
            }
            if (!C1635h.m1062a(C1616e.C1620b.f3377a, writableDatabase)) {
                m1076b(writableDatabase);
            }
            if (C1635h.m1062a(C1616e.C1617a.f3366a, writableDatabase)) {
                return;
            }
            m1079a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                m1075c(sQLiteDatabase);
                m1074d(sQLiteDatabase);
                m1076b(sQLiteDatabase);
                m1079a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            C1635h.m1066a(f3428b);
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable unused3) {
            if (sQLiteDatabase == null) {
                return;
            }
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable unused4) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= i || i != 1) {
            return;
        }
        try {
            try {
                m1073e(sQLiteDatabase);
            } catch (Exception unused) {
                m1072f(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            m1073e(sQLiteDatabase);
        }
    }
}
