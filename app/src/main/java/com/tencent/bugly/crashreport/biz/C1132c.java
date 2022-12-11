package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.AbstractC1184I;
import com.tencent.bugly.proguard.AbstractC1228m;
import com.tencent.bugly.proguard.C1185J;
import com.tencent.bugly.proguard.C1189M;
import com.tencent.bugly.proguard.C1195T;
import com.tencent.bugly.proguard.C1198W;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.tencent.bugly.proguard.C1235pa;
import com.tencent.bugly.proguard.C1245ua;
import com.umeng.analytics.pro.C1553ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.crashreport.biz.c */
/* loaded from: classes3.dex */
public class C1132c {

    /* renamed from: a */
    public Context f972a;

    /* renamed from: b */
    public long f973b;

    /* renamed from: c */
    public int f974c;

    /* renamed from: d */
    public boolean f975d;

    /* renamed from: com.tencent.bugly.crashreport.biz.c$a */
    /* loaded from: classes3.dex */
    public class RunnableC1133a implements Runnable {

        /* renamed from: a */
        public boolean f976a;

        /* renamed from: b */
        public UserInfoBean f977b;

        public RunnableC1133a(UserInfoBean userInfoBean, boolean z) {
            this.f977b = userInfoBean;
            this.f976a = z;
        }

        /* renamed from: a */
        private void m3465a(UserInfoBean userInfoBean) {
            C1140a m3394m;
            if (userInfoBean == null || (m3394m = C1140a.m3394m()) == null) {
                return;
            }
            userInfoBean.f959j = m3394m.m3386u();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f977b != null) {
                    m3465a(this.f977b);
                    C1199X.m3084a("[UserInfo] Record user info.", new Object[0]);
                    C1132c.this.m3474a(this.f977b, false);
                }
                if (!this.f976a) {
                    return;
                }
                C1132c.this.m3469b();
            } catch (Throwable th) {
                if (C1199X.m3080b(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.tencent.bugly.crashreport.biz.c$b */
    /* loaded from: classes3.dex */
    public class RunnableC1134b implements Runnable {
        public RunnableC1134b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < C1132c.this.f973b) {
                C1198W.m3089c().m3091a(new RunnableC1134b(), (C1132c.this.f973b - currentTimeMillis) + 5000);
                return;
            }
            C1132c.this.m3479a(3, false, 0L);
            C1132c.this.m3480a();
        }
    }

    /* renamed from: com.tencent.bugly.crashreport.biz.c$c */
    /* loaded from: classes3.dex */
    public class RunnableC1135c implements Runnable {

        /* renamed from: a */
        public long f980a;

        public RunnableC1135c(long j) {
            this.f980a = 21600000L;
            this.f980a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1132c.this.m3469b();
            C1132c.this.m3468b(this.f980a);
        }
    }

    public C1132c(Context context, boolean z) {
        this.f975d = true;
        this.f972a = context;
        this.f975d = z;
    }

    /* renamed from: a */
    public static UserInfoBean m3477a(Context context, int i) {
        C1140a m3421a = C1140a.m3421a(context);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f951b = i;
        userInfoBean.f952c = m3421a.f1043h;
        userInfoBean.f953d = m3421a.m3382y();
        userInfoBean.f954e = System.currentTimeMillis();
        userInfoBean.f955f = -1L;
        userInfoBean.f963n = m3421a.f1008E;
        int i2 = 1;
        if (i != 1) {
            i2 = 0;
        }
        userInfoBean.f964o = i2;
        userInfoBean.f961l = m3421a.m3427C();
        userInfoBean.f962m = m3421a.f1026W;
        userInfoBean.f956g = m3421a.f1027X;
        userInfoBean.f957h = m3421a.f1028Y;
        userInfoBean.f958i = m3421a.f1029Z;
        userInfoBean.f960k = m3421a.f1030aa;
        userInfoBean.f967r = m3421a.m3399h();
        userInfoBean.f968s = m3421a.m3401g();
        userInfoBean.f965p = m3421a.m3429A();
        userInfoBean.f966q = m3421a.m3387t();
        return userInfoBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3474a(UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> m3471a;
        if (userInfoBean == null) {
            return;
        }
        if (!z && userInfoBean.f951b != 1 && (m3471a = m3471a(C1140a.m3421a(this.f972a).f1043h)) != null && m3471a.size() >= 20) {
            C1199X.m3078c("[UserInfo] There are too many user info in local: %d", Integer.valueOf(m3471a.size()));
            return;
        }
        long m3155a = C1185J.m3172a().m3155a("t_ui", m3475a(userInfoBean), (AbstractC1184I) null, true);
        if (m3155a < 0) {
            return;
        }
        C1199X.m3084a("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(m3155a));
        userInfoBean.f950a = m3155a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ee A[Catch: all -> 0x016f, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:63:0x00cc, B:73:0x00d3, B:74:0x00e8, B:76:0x00ee, B:78:0x00f3, B:81:0x00fa, B:84:0x0112, B:86:0x0118, B:89:0x0121, B:91:0x0127, B:94:0x0130, B:96:0x013a, B:99:0x0143, B:102:0x0161, B:107:0x0166, B:111:0x00e2), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0118 A[Catch: all -> 0x016f, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:63:0x00cc, B:73:0x00d3, B:74:0x00e8, B:76:0x00ee, B:78:0x00f3, B:81:0x00fa, B:84:0x0112, B:86:0x0118, B:89:0x0121, B:91:0x0127, B:94:0x0130, B:96:0x013a, B:99:0x0143, B:102:0x0161, B:107:0x0166, B:111:0x00e2), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0121 A[Catch: all -> 0x016f, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:63:0x00cc, B:73:0x00d3, B:74:0x00e8, B:76:0x00ee, B:78:0x00f3, B:81:0x00fa, B:84:0x0112, B:86:0x0118, B:89:0x0121, B:91:0x0127, B:94:0x0130, B:96:0x013a, B:99:0x0143, B:102:0x0161, B:107:0x0166, B:111:0x00e2), top: B:2:0x0001 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m3466c() {
        boolean z;
        C1245ua m3132a;
        int i;
        if (!this.f975d) {
            return;
        }
        C1195T m3119a = C1195T.m3119a();
        if (m3119a == null) {
            return;
        }
        C1145c m3344b = C1145c.m3344b();
        if (m3344b == null) {
            return;
        }
        if (m3344b.m3341d() && !m3119a.m3118a(1001)) {
            return;
        }
        String str = C1140a.m3421a(this.f972a).f1043h;
        ArrayList arrayList = new ArrayList();
        List<UserInfoBean> m3471a = m3471a(str);
        if (m3471a != null) {
            int size = m3471a.size() - 20;
            if (size > 0) {
                int i2 = 0;
                while (i2 < m3471a.size() - 1) {
                    int i3 = i2 + 1;
                    for (int i4 = i3; i4 < m3471a.size(); i4++) {
                        if (m3471a.get(i2).f954e > m3471a.get(i4).f954e) {
                            m3471a.set(i2, m3471a.get(i4));
                            m3471a.set(i4, m3471a.get(i2));
                        }
                    }
                    i2 = i3;
                }
                for (int i5 = 0; i5 < size; i5++) {
                    arrayList.add(m3471a.get(i5));
                }
            }
            Iterator<UserInfoBean> it = m3471a.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                UserInfoBean next = it.next();
                if (next.f955f != -1) {
                    it.remove();
                    if (next.f954e < C1208ca.m3018b()) {
                        arrayList.add(next);
                    }
                }
                if (next.f954e > System.currentTimeMillis() - 600000 && ((i = next.f951b) == 1 || i == 4 || i == 3)) {
                    i6++;
                }
            }
            if (i6 > 15) {
                C1199X.m3076e("[UserInfo] Upload user info too many times in 10 min: %d", Integer.valueOf(i6));
                z = false;
                if (arrayList.size() > 0) {
                    m3470a(arrayList);
                }
                if (z && m3471a.size() != 0) {
                    C1199X.m3084a("[UserInfo] Upload user info(size: %d)", Integer.valueOf(m3471a.size()));
                    m3132a = C1189M.m3132a(m3471a, this.f974c != 1 ? 1 : 2);
                    if (m3132a != null) {
                        C1199X.m3076e("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
                        return;
                    }
                    byte[] m3134a = C1189M.m3134a((AbstractC1228m) m3132a);
                    if (m3134a == null) {
                        C1199X.m3076e("[UserInfo] Failed to encode data.", new Object[0]);
                        return;
                    }
                    C1235pa m3136a = C1189M.m3136a(this.f972a, 840, m3134a);
                    if (m3136a == null) {
                        C1199X.m3076e("[UserInfo] Request package is null.", new Object[0]);
                        return;
                    }
                    C1195T.m3119a().m3112a(1001, m3136a, C1145c.m3344b().m3342c().f1100q, StrategyBean.f1084a, new C1130a(this, m3471a), this.f974c == 1);
                    return;
                }
                C1199X.m3084a("[UserInfo] There is no user info in local database.", new Object[0]);
            }
        } else {
            m3471a = new ArrayList<>();
        }
        z = true;
        if (arrayList.size() > 0) {
        }
        if (z) {
            C1199X.m3084a("[UserInfo] Upload user info(size: %d)", Integer.valueOf(m3471a.size()));
            m3132a = C1189M.m3132a(m3471a, this.f974c != 1 ? 1 : 2);
            if (m3132a != null) {
            }
        }
        C1199X.m3084a("[UserInfo] There is no user info in local database.", new Object[0]);
    }

    /* renamed from: a */
    public ContentValues m3475a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f950a > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.f950a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f954e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f955f));
            contentValues.put(C1553ao.f3116e, Integer.valueOf(userInfoBean.f951b));
            contentValues.put("_pc", userInfoBean.f952c);
            contentValues.put("_dt", C1208ca.m3036a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public UserInfoBean m3476a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) C1208ca.m3019a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f950a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public List<UserInfoBean> m3471a(String str) {
        Throwable th;
        Cursor cursor;
        String sb;
        try {
            if (C1208ca.m3012b(str)) {
                sb = null;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("_pc = '");
                sb2.append(str);
                sb2.append("'");
                sb = sb2.toString();
            }
            cursor = C1185J.m3172a().m3152a("t_ui", null, sb, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb3 = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean m3476a = m3476a(cursor);
                    if (m3476a != null) {
                        arrayList.add(m3476a);
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
                    int m3153a = C1185J.m3172a().m3153a("t_ui", sb4.substring(4), (String[]) null, (AbstractC1184I) null, true);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_ui";
                    objArr[1] = Integer.valueOf(m3153a);
                    C1199X.m3076e("[Database] deleted %s error data %d", objArr);
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!C1199X.m3080b(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* renamed from: a */
    public void m3480a() {
        this.f973b = C1208ca.m3018b() + 86400000;
        C1198W.m3089c().m3091a(new RunnableC1134b(), (this.f973b - System.currentTimeMillis()) + 5000);
    }

    /* renamed from: a */
    public void m3479a(int i, boolean z, long j) {
        C1145c m3344b = C1145c.m3344b();
        if (m3344b != null && !m3344b.m3342c().f1090g && i != 1 && i != 3) {
            C1199X.m3081b("UserInfo is disable", new Object[0]);
            return;
        }
        if (i == 1 || i == 3) {
            this.f974c++;
        }
        C1198W.m3089c().m3091a(new RunnableC1133a(m3477a(this.f972a, i), z), j);
    }

    /* renamed from: a */
    public void m3478a(long j) {
        C1198W.m3089c().m3091a(new RunnableC1133a(null, true), j);
    }

    /* renamed from: a */
    public void m3470a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() && i < 50; i++) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, " or ", "_id", " = ");
            sb.append(list.get(i).f950a);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        String str = sb2;
        sb.setLength(0);
        try {
            int m3153a = C1185J.m3172a().m3153a("t_ui", str, (String[]) null, (AbstractC1184I) null, true);
            Object[] objArr = new Object[2];
            objArr[0] = "t_ui";
            objArr[1] = Integer.valueOf(m3153a);
            C1199X.m3084a("[Database] deleted %s data %d", objArr);
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m3469b() {
        C1198W m3089c = C1198W.m3089c();
        if (m3089c != null) {
            m3089c.m3092a(new RunnableC1131b(this));
        }
    }

    /* renamed from: b */
    public void m3468b(long j) {
        C1198W.m3089c().m3091a(new RunnableC1135c(j), j);
    }
}
