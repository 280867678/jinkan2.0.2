package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.AbstractC1081a;
import com.umeng.analytics.pro.C1553ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.J */
/* loaded from: classes3.dex */
public class C1185J {

    /* renamed from: a */
    public static C1185J f1373a;

    /* renamed from: b */
    public static C1187K f1374b;

    /* renamed from: c */
    public static boolean f1375c;

    /* renamed from: com.tencent.bugly.proguard.J$a */
    /* loaded from: classes3.dex */
    public class C1186a extends Thread {

        /* renamed from: a */
        public int f1376a;

        /* renamed from: b */
        public AbstractC1184I f1377b;

        /* renamed from: c */
        public String f1378c;

        /* renamed from: d */
        public ContentValues f1379d;

        /* renamed from: e */
        public boolean f1380e;

        /* renamed from: f */
        public String[] f1381f;

        /* renamed from: g */
        public String f1382g;

        /* renamed from: h */
        public String[] f1383h;

        /* renamed from: i */
        public String f1384i;

        /* renamed from: j */
        public String f1385j;

        /* renamed from: k */
        public String f1386k;

        /* renamed from: l */
        public String f1387l;

        /* renamed from: m */
        public String f1388m;

        /* renamed from: n */
        public String[] f1389n;

        /* renamed from: o */
        public int f1390o;

        /* renamed from: p */
        public String f1391p;

        /* renamed from: q */
        public byte[] f1392q;

        public C1186a(int i, AbstractC1184I abstractC1184I) {
            this.f1376a = i;
            this.f1377b = abstractC1184I;
        }

        /* renamed from: a */
        public void m3142a(int i) {
            this.f1390o = i;
        }

        /* renamed from: a */
        public void m3141a(int i, String str, byte[] bArr) {
            this.f1390o = i;
            this.f1391p = str;
            this.f1392q = bArr;
        }

        /* renamed from: a */
        public void m3140a(String str, ContentValues contentValues) {
            this.f1378c = str;
            this.f1379d = contentValues;
        }

        /* renamed from: a */
        public void m3139a(String str, String str2, String[] strArr) {
            this.f1378c = str;
            this.f1388m = str2;
            this.f1389n = strArr;
        }

        /* renamed from: a */
        public void m3138a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f1380e = z;
            this.f1378c = str;
            this.f1381f = strArr;
            this.f1382g = str2;
            this.f1383h = strArr2;
            this.f1384i = str3;
            this.f1385j = str4;
            this.f1386k = str5;
            this.f1387l = str6;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            switch (this.f1376a) {
                case 1:
                    C1185J.this.m3156a(this.f1378c, this.f1379d, this.f1377b);
                    return;
                case 2:
                    C1185J.this.m3154a(this.f1378c, this.f1388m, this.f1389n, this.f1377b);
                    return;
                case 3:
                    Cursor m3150a = C1185J.this.m3150a(this.f1380e, this.f1378c, this.f1381f, this.f1382g, this.f1383h, this.f1384i, this.f1385j, this.f1386k, this.f1387l, this.f1377b);
                    if (m3150a == null) {
                        return;
                    }
                    m3150a.close();
                    return;
                case 4:
                    C1185J.this.m3167a(this.f1390o, this.f1391p, this.f1392q, this.f1377b);
                    return;
                case 5:
                    C1185J.this.m3170a(this.f1390o, this.f1377b);
                    return;
                case 6:
                    C1185J.this.m3168a(this.f1390o, this.f1391p, this.f1377b);
                    return;
                default:
                    return;
            }
        }
    }

    public C1185J(Context context, List<AbstractC1081a> list) {
        f1374b = new C1187K(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized int m3154a(String str, String str2, String[] strArr, AbstractC1184I abstractC1184I) {
        int i;
        i = 0;
        Integer.valueOf(0);
        SQLiteDatabase writableDatabase = f1374b.getWritableDatabase();
        if (writableDatabase != null) {
            i = writableDatabase.delete(str, str2, strArr);
        }
        if (abstractC1184I != null) {
            abstractC1184I.m3173a(Integer.valueOf(i));
        }
        if (f1375c && writableDatabase != null) {
            writableDatabase.close();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized long m3156a(String str, ContentValues contentValues, AbstractC1184I abstractC1184I) {
        long j;
        j = 0;
        Long.valueOf(0L);
        SQLiteDatabase writableDatabase = f1374b.getWritableDatabase();
        if (writableDatabase != null && contentValues != null) {
            long replace = writableDatabase.replace(str, "_id", contentValues);
            if (replace >= 0) {
                C1199X.m3084a("[Database] insert %s success.", str);
            } else {
                C1199X.m3076e("[Database] replace %s error.", str);
            }
            j = replace;
        }
        if (abstractC1184I != null) {
            abstractC1184I.m3173a(Long.valueOf(j));
        }
        if (f1375c && writableDatabase != null) {
            writableDatabase.close();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized Cursor m3150a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, AbstractC1184I abstractC1184I) {
        Cursor cursor;
        cursor = null;
        SQLiteDatabase writableDatabase = f1374b.getWritableDatabase();
        if (writableDatabase != null) {
            cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
        }
        if (abstractC1184I != null) {
            abstractC1184I.m3173a(cursor);
        }
        return cursor;
    }

    /* renamed from: a */
    public static synchronized C1185J m3172a() {
        C1185J c1185j;
        synchronized (C1185J.class) {
            c1185j = f1373a;
        }
        return c1185j;
    }

    /* renamed from: a */
    public static synchronized C1185J m3165a(Context context, List<AbstractC1081a> list) {
        C1185J c1185j;
        synchronized (C1185J.class) {
            if (f1373a == null) {
                f1373a = new C1185J(context, list);
            }
            c1185j = f1373a;
        }
        return c1185j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003b, code lost:
        if (r5 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:
        return r0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, byte[]> m3170a(int i, AbstractC1184I abstractC1184I) {
        HashMap hashMap = null;
        try {
            List<C1188L> m3145c = m3145c(i);
            if (m3145c != null) {
                HashMap hashMap2 = new HashMap();
                try {
                    for (C1188L c1188l : m3145c) {
                        byte[] bArr = c1188l.f1404g;
                        if (bArr != null) {
                            hashMap2.put(c1188l.f1403f, bArr);
                        }
                    }
                    hashMap = hashMap2;
                } catch (Throwable th) {
                    th = th;
                    hashMap = hashMap2;
                    try {
                        if (!C1199X.m3080b(th)) {
                            th.printStackTrace();
                        }
                    } finally {
                        if (abstractC1184I != null) {
                            abstractC1184I.m3173a(hashMap);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x007c, code lost:
        if (r3 != null) goto L15;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean m3168a(int i, String str, AbstractC1184I abstractC1184I) {
        boolean z;
        String sb;
        z = false;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = f1374b.getWritableDatabase();
            if (sQLiteDatabase2 != null) {
                try {
                    if (C1208ca.m3012b(str)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("_id = ");
                        sb2.append(i);
                        sb = sb2.toString();
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("_id = ");
                        sb3.append(i);
                        sb3.append(" and ");
                        sb3.append(C1553ao.f3116e);
                        sb3.append(" = \"");
                        sb3.append(str);
                        sb3.append("\"");
                        sb = sb3.toString();
                    }
                    int delete = sQLiteDatabase2.delete("t_pf", sb, null);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_pf";
                    objArr[1] = Integer.valueOf(delete);
                    C1199X.m3084a("[Database] deleted %s data %d", objArr);
                    if (delete > 0) {
                        z = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = sQLiteDatabase2;
                    if (!C1199X.m3080b(th)) {
                        th.printStackTrace();
                    }
                    if (abstractC1184I != null) {
                        abstractC1184I.m3173a(false);
                    }
                    if (f1375c && sQLiteDatabase != null) {
                        sQLiteDatabase2 = sQLiteDatabase;
                        sQLiteDatabase2.close();
                    }
                    return z;
                }
            }
            if (abstractC1184I != null) {
                abstractC1184I.m3173a(Boolean.valueOf(z));
            }
            if (f1375c) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m3167a(int i, String str, byte[] bArr, AbstractC1184I abstractC1184I) {
        boolean z = false;
        try {
            C1188L c1188l = new C1188L();
            c1188l.f1398a = i;
            c1188l.f1403f = str;
            c1188l.f1402e = System.currentTimeMillis();
            c1188l.f1404g = bArr;
            z = m3143d(c1188l);
            if (abstractC1184I != null) {
                abstractC1184I.m3173a(Boolean.valueOf(z));
            }
        } catch (Throwable th) {
            try {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
            } finally {
                if (abstractC1184I != null) {
                    abstractC1184I.m3173a(false);
                }
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x00dd, code lost:
        if (r1 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00c3, code lost:
        if (r1 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00df, code lost:
        r1.close();
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<C1188L> m3145c(int i) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        try {
            sQLiteDatabase = f1374b.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
            cursor = null;
        }
        if (sQLiteDatabase == null) {
            if (f1375c) {
            }
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("_id = ");
            sb.append(i);
            String sb2 = sb.toString();
            cursor = sQLiteDatabase.query("t_pf", null, sb2, null, null, null, null);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                if (f1375c) {
                    sQLiteDatabase.close();
                }
                return null;
            }
            try {
                StringBuilder sb3 = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    C1188L m3147b = m3147b(cursor);
                    if (m3147b != null) {
                        arrayList.add(m3147b);
                    } else {
                        String string = cursor.getString(cursor.getColumnIndex(C1553ao.f3116e));
                        sb3.append(" or ");
                        sb3.append(C1553ao.f3116e);
                        sb3.append(" = ");
                        sb3.append(string);
                    }
                }
                if (sb3.length() > 0) {
                    sb3.append(" and ");
                    sb3.append("_id");
                    sb3.append(" = ");
                    sb3.append(i);
                    int delete = sQLiteDatabase.delete("t_pf", sb2.substring(4), null);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_pf";
                    objArr[1] = Integer.valueOf(delete);
                    C1199X.m3076e("[Database] deleted %s illegal data %d.", objArr);
                }
                cursor.close();
                if (f1375c) {
                    sQLiteDatabase.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (f1375c) {
                }
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* renamed from: d */
    private synchronized boolean m3143d(C1188L c1188l) {
        ContentValues m3146b;
        if (c1188l == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = f1374b.getWritableDatabase();
        if (writableDatabase == null || (m3146b = m3146b(c1188l)) == null) {
            if (f1375c && writableDatabase != null) {
                writableDatabase.close();
            }
            return false;
        }
        long replace = writableDatabase.replace("t_pf", "_id", m3146b);
        if (replace < 0) {
            if (f1375c) {
                writableDatabase.close();
            }
            return false;
        }
        Object[] objArr = new Object[1];
        objArr[0] = "t_pf";
        C1199X.m3084a("[Database] insert %s success.", objArr);
        c1188l.f1398a = replace;
        if (f1375c) {
            writableDatabase.close();
        }
        return true;
    }

    /* renamed from: a */
    public int m3153a(String str, String str2, String[] strArr, AbstractC1184I abstractC1184I, boolean z) {
        if (!z) {
            C1186a c1186a = new C1186a(2, abstractC1184I);
            c1186a.m3139a(str, str2, strArr);
            C1198W.m3089c().m3092a(c1186a);
            return 0;
        }
        return m3154a(str, str2, strArr, abstractC1184I);
    }

    /* renamed from: a */
    public long m3155a(String str, ContentValues contentValues, AbstractC1184I abstractC1184I, boolean z) {
        if (!z) {
            C1186a c1186a = new C1186a(1, abstractC1184I);
            c1186a.m3140a(str, contentValues);
            C1198W.m3089c().m3092a(c1186a);
            return 0L;
        }
        return m3156a(str, contentValues, abstractC1184I);
    }

    /* renamed from: a */
    public ContentValues m3157a(C1188L c1188l) {
        if (c1188l == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (c1188l.f1398a > 0) {
                contentValues.put("_id", Long.valueOf(c1188l.f1398a));
            }
            contentValues.put(C1553ao.f3116e, Integer.valueOf(c1188l.f1399b));
            contentValues.put("_pc", c1188l.f1400c);
            contentValues.put("_th", c1188l.f1401d);
            contentValues.put("_tm", Long.valueOf(c1188l.f1402e));
            if (c1188l.f1404g != null) {
                contentValues.put("_dt", c1188l.f1404g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public Cursor m3152a(String str, String[] strArr, String str2, String[] strArr2, AbstractC1184I abstractC1184I, boolean z) {
        return m3149a(false, str, strArr, str2, strArr2, (String) null, (String) null, (String) null, (String) null, abstractC1184I, z);
    }

    /* renamed from: a */
    public Cursor m3149a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, AbstractC1184I abstractC1184I, boolean z2) {
        if (!z2) {
            C1186a c1186a = new C1186a(3, abstractC1184I);
            c1186a.m3138a(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            C1198W.m3089c().m3092a(c1186a);
            return null;
        }
        return m3150a(z, str, strArr, str2, strArr2, str3, str4, str5, str6, abstractC1184I);
    }

    /* renamed from: a */
    public C1188L m3164a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C1188L c1188l = new C1188L();
            c1188l.f1398a = cursor.getLong(cursor.getColumnIndex("_id"));
            c1188l.f1399b = cursor.getInt(cursor.getColumnIndex(C1553ao.f3116e));
            c1188l.f1400c = cursor.getString(cursor.getColumnIndex("_pc"));
            c1188l.f1401d = cursor.getString(cursor.getColumnIndex("_th"));
            c1188l.f1402e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c1188l.f1404g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c1188l;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00bd A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:13:0x0033, B:14:0x0036, B:16:0x003a, B:52:0x00a7, B:54:0x00ae, B:62:0x00c2, B:63:0x00c5, B:65:0x00c9, B:58:0x00b7, B:60:0x00bd), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c2 A[Catch: all -> 0x00dd, TRY_ENTER, TryCatch #3 {, blocks: (B:3:0x0001, B:13:0x0033, B:14:0x0036, B:16:0x003a, B:52:0x00a7, B:54:0x00ae, B:62:0x00c2, B:63:0x00c5, B:65:0x00c9, B:58:0x00b7, B:60:0x00bd), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c9 A[Catch: all -> 0x00dd, TryCatch #3 {, blocks: (B:3:0x0001, B:13:0x0033, B:14:0x0036, B:16:0x003a, B:52:0x00a7, B:54:0x00ae, B:62:0x00c2, B:63:0x00c5, B:65:0x00c9, B:58:0x00b7, B:60:0x00bd), top: B:2:0x0001 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<C1188L> m3171a(int i) {
        String sb;
        Throwable th;
        Cursor cursor;
        SQLiteDatabase writableDatabase = f1374b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("_tp = ");
                    sb2.append(i);
                    sb = sb2.toString();
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    if (!C1199X.m3080b(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (f1375c) {
                        writableDatabase.close();
                    }
                    return null;
                }
            } else {
                sb = null;
            }
            cursor = writableDatabase.query("t_lr", null, sb, null, null, null, null);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                if (f1375c) {
                    writableDatabase.close();
                }
                return null;
            }
            try {
                StringBuilder sb3 = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    C1188L m3164a = m3164a(cursor);
                    if (m3164a != null) {
                        arrayList.add(m3164a);
                    } else {
                        long j = cursor.getLong(cursor.getColumnIndex("_id"));
                        sb3.append(" or ");
                        sb3.append("_id");
                        sb3.append(" = ");
                        sb3.append(j);
                    }
                }
                String sb4 = sb3.toString();
                if (sb4.length() > 0) {
                    int delete = writableDatabase.delete("t_lr", sb4.substring(4), null);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_lr";
                    objArr[1] = Integer.valueOf(delete);
                    C1199X.m3076e("[Database] deleted %s illegal data %d", objArr);
                }
                cursor.close();
                if (f1375c) {
                    writableDatabase.close();
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                if (!C1199X.m3080b(th)) {
                }
                if (cursor != null) {
                }
                if (f1375c) {
                }
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public Map<String, byte[]> m3169a(int i, AbstractC1184I abstractC1184I, boolean z) {
        if (!z) {
            C1186a c1186a = new C1186a(5, abstractC1184I);
            c1186a.m3142a(i);
            C1198W.m3089c().m3092a(c1186a);
            return null;
        }
        return m3170a(i, abstractC1184I);
    }

    /* renamed from: a */
    public synchronized void m3151a(List<C1188L> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f1374b.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (C1188L c1188l : list) {
                        sb.append(" or ");
                        sb.append("_id");
                        sb.append(" = ");
                        sb.append(c1188l.f1398a);
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(4);
                    }
                    sb.setLength(0);
                    int delete = writableDatabase.delete("t_lr", sb2, null);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_lr";
                    objArr[1] = Integer.valueOf(delete);
                    C1199X.m3084a("[Database] deleted %s data %d", objArr);
                    if (f1375c) {
                        writableDatabase.close();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m3166a(int i, String str, byte[] bArr, AbstractC1184I abstractC1184I, boolean z) {
        if (!z) {
            C1186a c1186a = new C1186a(4, abstractC1184I);
            c1186a.m3141a(i, str, bArr);
            C1198W.m3089c().m3092a(c1186a);
            return true;
        }
        return m3167a(i, str, bArr, abstractC1184I);
    }

    /* renamed from: b */
    public ContentValues m3146b(C1188L c1188l) {
        if (c1188l != null && !C1208ca.m3012b(c1188l.f1403f)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (c1188l.f1398a > 0) {
                    contentValues.put("_id", Long.valueOf(c1188l.f1398a));
                }
                contentValues.put(C1553ao.f3116e, c1188l.f1403f);
                contentValues.put("_tm", Long.valueOf(c1188l.f1402e));
                if (c1188l.f1404g != null) {
                    contentValues.put("_dt", c1188l.f1404g);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public C1188L m3147b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C1188L c1188l = new C1188L();
            c1188l.f1398a = cursor.getLong(cursor.getColumnIndex("_id"));
            c1188l.f1402e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c1188l.f1403f = cursor.getString(cursor.getColumnIndex(C1553ao.f3116e));
            c1188l.f1404g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c1188l;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public synchronized void m3148b(int i) {
        String str;
        SQLiteDatabase writableDatabase = f1374b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("_tp = ");
                sb.append(i);
                str = sb.toString();
            } else {
                str = null;
            }
            int delete = writableDatabase.delete("t_lr", str, null);
            Object[] objArr = new Object[2];
            objArr[0] = "t_lr";
            objArr[1] = Integer.valueOf(delete);
            C1199X.m3084a("[Database] deleted %s data %d", objArr);
            if (f1375c) {
                writableDatabase.close();
            }
        }
    }

    /* renamed from: c */
    public synchronized boolean m3144c(C1188L c1188l) {
        ContentValues m3157a;
        if (c1188l == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = f1374b.getWritableDatabase();
        if (writableDatabase == null || (m3157a = m3157a(c1188l)) == null) {
            if (f1375c && writableDatabase != null) {
                writableDatabase.close();
            }
            return false;
        }
        long replace = writableDatabase.replace("t_lr", "_id", m3157a);
        if (replace < 0) {
            if (f1375c) {
                writableDatabase.close();
            }
            return false;
        }
        Object[] objArr = new Object[1];
        objArr[0] = "t_lr";
        C1199X.m3084a("[Database] insert %s success.", objArr);
        c1188l.f1398a = replace;
        if (f1375c) {
            writableDatabase.close();
        }
        return true;
    }
}
