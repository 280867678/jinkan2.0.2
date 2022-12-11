package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.anr.C1155g;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.C1185J;
import com.tencent.bugly.proguard.C1188L;
import com.tencent.bugly.proguard.C1195T;
import com.tencent.bugly.proguard.C1198W;
import com.tencent.bugly.proguard.C1208ca;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.bugly.crashreport.crash.h */
/* loaded from: classes3.dex */
public class C1164h {

    /* renamed from: a */
    public static int f1231a = 0;

    /* renamed from: b */
    public static boolean f1232b = false;

    /* renamed from: c */
    public static int f1233c = 2;

    /* renamed from: d */
    public static boolean f1234d = true;

    /* renamed from: e */
    public static int f1235e = 20480;

    /* renamed from: f */
    public static int f1236f = 20480;

    /* renamed from: g */
    public static long f1237g = 604800000;

    /* renamed from: h */
    public static String f1238h = null;

    /* renamed from: i */
    public static boolean f1239i = false;

    /* renamed from: j */
    public static String f1240j = null;

    /* renamed from: k */
    public static int f1241k = 5000;

    /* renamed from: l */
    public static boolean f1242l = true;

    /* renamed from: m */
    public static boolean f1243m;

    /* renamed from: n */
    public static String f1244n;

    /* renamed from: o */
    public static String f1245o;

    /* renamed from: p */
    public static C1164h f1246p;

    /* renamed from: q */
    public final Context f1249q;

    /* renamed from: r */
    public final C1161e f1250r;

    /* renamed from: s */
    public final C1173l f1251s;

    /* renamed from: t */
    public final NativeCrashHandler f1252t;

    /* renamed from: v */
    public final C1198W f1254v;

    /* renamed from: w */
    public final C1155g f1255w;

    /* renamed from: x */
    public BuglyStrategy.C1080a f1256x;

    /* renamed from: y */
    public AbstractC1174m f1257y;

    /* renamed from: z */
    public Boolean f1258z;

    /* renamed from: A */
    public int f1247A = 31;

    /* renamed from: B */
    public boolean f1248B = false;

    /* renamed from: u */
    public final C1145c f1253u = C1145c.m3344b();

    public C1164h(int i, Context context, C1198W c1198w, boolean z, BuglyStrategy.C1080a c1080a, AbstractC1174m abstractC1174m, String str) {
        f1231a = i;
        Context m3044a = C1208ca.m3044a(context);
        this.f1249q = m3044a;
        this.f1254v = c1198w;
        this.f1256x = c1080a;
        this.f1257y = abstractC1174m;
        C1195T m3119a = C1195T.m3119a();
        C1185J m3172a = C1185J.m3172a();
        this.f1250r = new C1161e(i, m3044a, m3119a, m3172a, this.f1253u, c1080a, abstractC1174m);
        C1140a m3421a = C1140a.m3421a(m3044a);
        this.f1251s = new C1173l(m3044a, this.f1250r, this.f1253u, m3421a);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(m3044a, m3421a, this.f1250r, this.f1253u, c1198w, z, str);
        this.f1252t = nativeCrashHandler;
        m3421a.f1060pa = nativeCrashHandler;
        this.f1255w = C1155g.m3328a(m3044a, this.f1253u, m3421a, c1198w, m3172a, this.f1250r, c1080a);
    }

    /* renamed from: a */
    public static synchronized C1164h m3276a(int i, Context context, boolean z, BuglyStrategy.C1080a c1080a, AbstractC1174m abstractC1174m, String str) {
        C1164h c1164h;
        synchronized (C1164h.class) {
            if (f1246p == null) {
                f1246p = new C1164h(i, context, C1198W.m3089c(), z, c1080a, abstractC1174m, str);
            }
            c1164h = f1246p;
        }
        return c1164h;
    }

    /* renamed from: g */
    public static synchronized C1164h m3262g() {
        C1164h c1164h;
        synchronized (C1164h.class) {
            c1164h = f1246p;
        }
        return c1164h;
    }

    /* renamed from: a */
    public void m3278a() {
        if (C1140a.m3394m().f1043h.equals(AppInfo.m3431d(this.f1249q))) {
            this.f1252t.removeEmptyNativeRecordFiles();
        }
    }

    /* renamed from: a */
    public void m3277a(int i) {
        this.f1247A = i;
    }

    /* renamed from: a */
    public void m3275a(long j) {
        C1198W.m3089c().m3091a(new C1163g(this), j);
    }

    /* renamed from: a */
    public void m3274a(StrategyBean strategyBean) {
        this.f1251s.m3205a(strategyBean);
        this.f1252t.onStrategyChanged(strategyBean);
        this.f1255w.m3326a(strategyBean);
        m3275a(3000L);
    }

    /* renamed from: a */
    public void m3273a(CrashDetailBean crashDetailBean) {
        this.f1250r.m3280e(crashDetailBean);
    }

    /* renamed from: a */
    public void m3271a(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        this.f1254v.m3092a(new RunnableC1162f(this, z, thread, th, str, bArr, z2));
    }

    /* renamed from: a */
    public void m3270a(boolean z) {
        this.f1248B = z;
    }

    /* renamed from: a */
    public synchronized void m3269a(boolean z, boolean z2, boolean z3) {
        this.f1252t.testNativeCrash(z, z2, z3);
    }

    /* renamed from: b */
    public synchronized void m3268b() {
        m3265d();
        m3264e();
        m3266c();
    }

    /* renamed from: c */
    public void m3266c() {
        this.f1255w.m3319b(false);
    }

    /* renamed from: d */
    public void m3265d() {
        this.f1251s.m3199b();
    }

    /* renamed from: e */
    public void m3264e() {
        this.f1252t.setUserOpened(false);
    }

    /* renamed from: f */
    public boolean m3263f() {
        return this.f1248B;
    }

    /* renamed from: h */
    public boolean m3261h() {
        Boolean bool = this.f1258z;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = C1140a.m3394m().f1043h;
        List<C1188L> m3171a = C1185J.m3172a().m3171a(1);
        ArrayList arrayList = new ArrayList();
        if (m3171a == null || m3171a.size() <= 0) {
            this.f1258z = false;
            return false;
        }
        for (C1188L c1188l : m3171a) {
            if (str.equals(c1188l.f1400c)) {
                this.f1258z = true;
                arrayList.add(c1188l);
            }
        }
        if (arrayList.size() > 0) {
            C1185J.m3172a().m3151a(arrayList);
        }
        return true;
    }

    /* renamed from: i */
    public boolean m3260i() {
        return this.f1255w.m3320b();
    }

    /* renamed from: j */
    public boolean m3259j() {
        return (this.f1247A & 8) > 0;
    }

    /* renamed from: k */
    public boolean m3258k() {
        return (this.f1247A & 16) > 0;
    }

    /* renamed from: l */
    public boolean m3257l() {
        return (this.f1247A & 2) > 0;
    }

    /* renamed from: m */
    public boolean m3256m() {
        return (this.f1247A & 1) > 0;
    }

    /* renamed from: n */
    public boolean m3255n() {
        return (this.f1247A & 4) > 0;
    }

    /* renamed from: o */
    public synchronized void m3254o() {
        m3251r();
        m3250s();
        m3253p();
    }

    /* renamed from: p */
    public void m3253p() {
        this.f1255w.m3319b(true);
    }

    /* renamed from: q */
    public void m3252q() {
        this.f1252t.enableCatchAnrTrace();
    }

    /* renamed from: r */
    public void m3251r() {
        this.f1251s.m3206a();
    }

    /* renamed from: s */
    public void m3250s() {
        this.f1252t.setUserOpened(true);
    }

    /* renamed from: t */
    public synchronized void m3249t() {
        this.f1255w.m3313g();
    }

    /* renamed from: u */
    public void m3248u() {
        this.f1252t.checkUploadRecordCrash();
    }
}
