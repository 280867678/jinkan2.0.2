package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import com.umeng.analytics.pro.C1553ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.p */
/* loaded from: classes3.dex */
public class C1234p {

    /* renamed from: a */
    public static C1234p f1572a = new C1234p();

    /* renamed from: a */
    public synchronized int m2881a() {
        return C1185J.m3172a().m3153a("ge_1002", (String) null, (String[]) null, (AbstractC1184I) null, true);
    }

    /* renamed from: a */
    public synchronized int m2879a(long j) {
        return C1185J.m3172a().m3153a("ge_1002", "_time = ?", new String[]{String.valueOf(j)}, (AbstractC1184I) null, true);
    }

    /* renamed from: a */
    public synchronized int m2878a(DownloadTask downloadTask) {
        return C1185J.m3172a().m3153a("dl_1002", "_dUrl = ?", new String[]{downloadTask.getDownloadUrl()}, (AbstractC1184I) null, true);
    }

    /* renamed from: a */
    public synchronized boolean m2880a(int i, String str, byte[] bArr) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(i));
        contentValues.put("_tm", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(C1553ao.f3116e, str);
        contentValues.put("_dt", bArr);
        z = true;
        if (C1185J.m3172a().m3155a("st_1002", contentValues, (AbstractC1184I) null, true) < 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public synchronized boolean m2877a(C1250z c1250z) {
        boolean z = false;
        if (c1250z == null) {
            return false;
        }
        byte[] m3134a = C1189M.m3134a((AbstractC1228m) c1250z);
        if (m3134a != null && m3134a.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_time", Long.valueOf(c1250z.f1683e));
            contentValues.put("_datas", m3134a);
            if (C1185J.m3172a().m3155a("ge_1002", contentValues, (AbstractC1184I) null, true) >= 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    /* renamed from: a */
    public synchronized boolean m2876a(String str) {
        boolean z;
        z = false;
        if (C1185J.m3172a().m3153a("st_1002", "_id = ? and _tp = ? ", new String[]{"1002", str}, (AbstractC1184I) null, true) > 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public synchronized int m2873b(String str) {
        return C1185J.m3172a().m3153a("dl_1002", "_sFile = ?", new String[]{str}, (AbstractC1184I) null, true);
    }

    /* renamed from: b */
    public synchronized List<C1250z> m2875b() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor m3152a = C1185J.m3172a().m3152a("ge_1002", null, null, null, null, true);
        while (m3152a != null && m3152a.moveToNext()) {
            C1250z c1250z = (C1250z) C1189M.m3130a(m3152a.getBlob(m3152a.getColumnIndex("_datas")), C1250z.class);
            if (c1250z != null) {
                arrayList.add(c1250z);
            }
        }
        if (m3152a != null) {
            m3152a.close();
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return arrayList;
    }

    /* renamed from: b */
    public synchronized boolean m2874b(DownloadTask downloadTask) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_dUrl", downloadTask.getDownloadUrl());
        contentValues.put("_sFile", downloadTask.getSaveFile().getAbsolutePath());
        contentValues.put("_sLen", Long.valueOf(downloadTask.getSavedLength()));
        contentValues.put("_tLen", Long.valueOf(downloadTask.getTotalLength()));
        contentValues.put("_MD5", downloadTask.getMD5());
        contentValues.put("_DLTIME", Long.valueOf(downloadTask.getCostTime()));
        z = true;
        if (C1185J.m3172a().m3155a("dl_1002", contentValues, (AbstractC1184I) null, true) < 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    public synchronized ContentValues m2871c(String str) {
        ContentValues contentValues = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor m3152a = C1185J.m3172a().m3152a("dl_1002", null, "_dUrl=?", new String[]{str}, null, true);
        if (m3152a != null && m3152a.moveToFirst()) {
            contentValues = new ContentValues();
            contentValues.put("_dUrl", m3152a.getString(m3152a.getColumnIndex("_dUrl")));
            contentValues.put("_sFile", m3152a.getString(m3152a.getColumnIndex("_sFile")));
            contentValues.put("_sLen", Long.valueOf(m3152a.getLong(m3152a.getColumnIndex("_sLen"))));
            contentValues.put("_tLen", Long.valueOf(m3152a.getLong(m3152a.getColumnIndex("_tLen"))));
            contentValues.put("_MD5", m3152a.getString(m3152a.getColumnIndex("_MD5")));
            contentValues.put("_DLTIME", Long.valueOf(m3152a.getLong(m3152a.getColumnIndex("_DLTIME"))));
        }
        if (m3152a != null) {
            m3152a.close();
        }
        return contentValues;
    }

    /* renamed from: c */
    public synchronized Map<String, byte[]> m2872c() {
        Throwable th;
        Cursor cursor;
        try {
            cursor = C1185J.m3172a().m3152a("st_1002", null, "_id = 1002", null, null, true);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                HashMap hashMap = new HashMap();
                while (cursor.moveToNext()) {
                    hashMap.put(cursor.getString(cursor.getColumnIndex(C1553ao.f3116e)), cursor.getBlob(cursor.getColumnIndex("_dt")));
                }
                cursor.close();
                return hashMap;
            } catch (Throwable th2) {
                th = th2;
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }
}
