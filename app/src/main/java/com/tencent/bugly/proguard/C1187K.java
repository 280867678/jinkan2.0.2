package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.AbstractC1081a;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.info.C1141b;
import com.umeng.analytics.pro.C1553ao;
import java.io.File;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.transform.ClassTransform;

/* renamed from: com.tencent.bugly.proguard.K */
/* loaded from: classes3.dex */
public class C1187K extends SQLiteOpenHelper {

    /* renamed from: a */
    public static String f1394a = "bugly_db";

    /* renamed from: b */
    public static int f1395b = 15;

    /* renamed from: c */
    public Context f1396c;

    /* renamed from: d */
    public List<AbstractC1081a> f1397d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C1187K(Context context, List<AbstractC1081a> list) {
        super(context, r0.toString(), (SQLiteDatabase.CursorFactory) null, f1395b);
        StringBuilder sb = new StringBuilder();
        sb.append(f1394a);
        sb.append("_");
        C1140a.m3421a(context).getClass();
        sb.append("");
        this.f1396c = context;
        this.f1397d = list;
    }

    /* renamed from: a */
    public synchronized boolean m3137a(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i = 0; i < 3; i++) {
                String str = strArr[i];
                StringBuilder sb = new StringBuilder();
                sb.append("DROP TABLE IF EXISTS ");
                sb.append(str);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            }
        } catch (Throwable th) {
            if (!C1199X.m3083a(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i = 0;
        while (sQLiteDatabase == null && i < 5) {
            i++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                C1199X.m3076e("[Database] Try to get db(count: %d).", Integer.valueOf(i));
                if (i == 5) {
                    C1199X.m3081b("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i = 0;
        while (sQLiteDatabase == null && i < 5) {
            i++;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            }
        }
        if (sQLiteDatabase == null) {
            C1199X.m3076e("[Database] db error delay error record 1min.", new Object[0]);
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append(" CREATE TABLE IF NOT EXISTS ");
        sb.append("t_ui");
        sb.append(" ( ");
        sb.append("_id");
        sb.append(StringUtils.SPACE);
        sb.append("INTEGER PRIMARY KEY");
        sb.append(" , ");
        sb.append("_tm");
        sb.append(StringUtils.SPACE);
        sb.append(ClassTransform.INTEGER);
        sb.append(" , ");
        sb.append("_ut");
        sb.append(StringUtils.SPACE);
        sb.append(ClassTransform.INTEGER);
        sb.append(" , ");
        sb.append(C1553ao.f3116e);
        sb.append(StringUtils.SPACE);
        sb.append(ClassTransform.INTEGER);
        sb.append(" , ");
        sb.append("_dt");
        sb.append(StringUtils.SPACE);
        sb.append("blob");
        sb.append(" , ");
        sb.append("_pc");
        sb.append(StringUtils.SPACE);
        sb.append("text");
        sb.append(" ) ");
        C1199X.m3084a(sb.toString(), new Object[0]);
        sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        sb.setLength(0);
        sb.append(" CREATE TABLE IF NOT EXISTS ");
        sb.append("t_lr");
        sb.append(" ( ");
        sb.append("_id");
        sb.append(StringUtils.SPACE);
        sb.append("INTEGER PRIMARY KEY");
        sb.append(" , ");
        sb.append(C1553ao.f3116e);
        sb.append(StringUtils.SPACE);
        sb.append(ClassTransform.INTEGER);
        sb.append(" , ");
        sb.append("_tm");
        sb.append(StringUtils.SPACE);
        sb.append(ClassTransform.INTEGER);
        sb.append(" , ");
        sb.append("_pc");
        sb.append(StringUtils.SPACE);
        sb.append("text");
        sb.append(" , ");
        sb.append("_th");
        sb.append(StringUtils.SPACE);
        sb.append("text");
        sb.append(" , ");
        sb.append("_dt");
        sb.append(StringUtils.SPACE);
        sb.append("blob");
        sb.append(" ) ");
        C1199X.m3084a(sb.toString(), new Object[0]);
        sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        sb.setLength(0);
        sb.append(" CREATE TABLE IF NOT EXISTS ");
        sb.append("t_pf");
        sb.append(" ( ");
        sb.append("_id");
        sb.append(StringUtils.SPACE);
        sb.append("integer");
        sb.append(" , ");
        sb.append(C1553ao.f3116e);
        sb.append(StringUtils.SPACE);
        sb.append("text");
        sb.append(" , ");
        sb.append("_tm");
        sb.append(StringUtils.SPACE);
        sb.append(ClassTransform.INTEGER);
        sb.append(" , ");
        sb.append("_dt");
        sb.append(StringUtils.SPACE);
        sb.append("blob");
        sb.append(",primary key(");
        sb.append("_id");
        sb.append(",");
        sb.append(C1553ao.f3116e);
        sb.append(" )) ");
        C1199X.m3084a(sb.toString(), new Object[0]);
        sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        sb.setLength(0);
        sb.append(" CREATE TABLE IF NOT EXISTS ");
        sb.append("t_cr");
        sb.append(" ( ");
        sb.append("_id");
        sb.append(StringUtils.SPACE);
        sb.append("INTEGER PRIMARY KEY");
        sb.append(" , ");
        sb.append("_tm");
        sb.append(StringUtils.SPACE);
        sb.append(ClassTransform.INTEGER);
        sb.append(" , ");
        sb.append("_s1");
        sb.append(StringUtils.SPACE);
        sb.append("text");
        sb.append(" , ");
        sb.append("_up");
        sb.append(StringUtils.SPACE);
        sb.append(ClassTransform.INTEGER);
        sb.append(" , ");
        sb.append("_me");
        sb.append(StringUtils.SPACE);
        sb.append(ClassTransform.INTEGER);
        sb.append(" , ");
        sb.append("_uc");
        sb.append(StringUtils.SPACE);
        sb.append(ClassTransform.INTEGER);
        sb.append(" , ");
        sb.append("_dt");
        sb.append(StringUtils.SPACE);
        sb.append("blob");
        sb.append(" ) ");
        C1199X.m3084a(sb.toString(), new Object[0]);
        sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        sb.setLength(0);
        sb.append(" CREATE TABLE IF NOT EXISTS ");
        sb.append("dl_1002");
        sb.append(" (");
        sb.append("_id");
        sb.append(" integer primary key autoincrement, ");
        sb.append("_dUrl");
        sb.append(" varchar(100), ");
        sb.append("_sFile");
        sb.append(" varchar(100), ");
        sb.append("_sLen");
        sb.append(" INTEGER, ");
        sb.append("_tLen");
        sb.append(" INTEGER, ");
        sb.append("_MD5");
        sb.append(" varchar(100), ");
        sb.append("_DLTIME");
        sb.append(" INTEGER)");
        C1199X.m3084a(sb.toString(), new Object[0]);
        sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        sb.setLength(0);
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append("ge_1002");
        sb.append(" (");
        sb.append("_id");
        sb.append(" integer primary key autoincrement, ");
        sb.append("_time");
        sb.append(" INTEGER, ");
        sb.append("_datas");
        sb.append(" blob)");
        C1199X.m3084a(sb.toString(), new Object[0]);
        sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        sb.setLength(0);
        sb.append(" CREATE TABLE IF NOT EXISTS ");
        sb.append("st_1002");
        sb.append(" ( ");
        sb.append("_id");
        sb.append(StringUtils.SPACE);
        sb.append("integer");
        sb.append(" , ");
        sb.append(C1553ao.f3116e);
        sb.append(StringUtils.SPACE);
        sb.append("text");
        sb.append(" , ");
        sb.append("_tm");
        sb.append(StringUtils.SPACE);
        sb.append(ClassTransform.INTEGER);
        sb.append(" , ");
        sb.append("_dt");
        sb.append(StringUtils.SPACE);
        sb.append("blob");
        sb.append(",primary key(");
        sb.append("_id");
        sb.append(",");
        sb.append(C1553ao.f3116e);
        sb.append(" )) ");
        C1199X.m3084a(sb.toString(), new Object[0]);
        sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        List<AbstractC1081a> list = this.f1397d;
        if (list == null) {
            return;
        }
        for (AbstractC1081a abstractC1081a : list) {
            abstractC1081a.onDbCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (C1141b.m3375c() >= 11) {
            C1199X.m3076e("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i), Integer.valueOf(i2));
            List<AbstractC1081a> list = this.f1397d;
            if (list != null) {
                for (AbstractC1081a abstractC1081a : list) {
                    abstractC1081a.onDbDowngrade(sQLiteDatabase, i, i2);
                }
            }
            if (m3137a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
            } else {
                C1199X.m3076e("[Database] Failed to drop, delete db.", new Object[0]);
                File databasePath = this.f1396c.getDatabasePath(f1394a);
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C1199X.m3076e("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i), Integer.valueOf(i2));
        List<AbstractC1081a> list = this.f1397d;
        if (list != null) {
            for (AbstractC1081a abstractC1081a : list) {
                abstractC1081a.onDbUpgrade(sQLiteDatabase, i, i2);
            }
        }
        if (m3137a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
        } else {
            C1199X.m3076e("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f1396c.getDatabasePath(f1394a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }
}
