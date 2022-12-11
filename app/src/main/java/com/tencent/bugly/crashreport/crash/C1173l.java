package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.info.C1141b;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1205ba;
import com.tencent.bugly.proguard.C1208ca;
import java.lang.Thread;
import java.util.HashMap;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.crashreport.crash.l */
/* loaded from: classes3.dex */
public class C1173l implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public static String f1310a;

    /* renamed from: b */
    public static final Object f1311b = new Object();

    /* renamed from: c */
    public final Context f1312c;

    /* renamed from: d */
    public final C1161e f1313d;

    /* renamed from: e */
    public final C1145c f1314e;

    /* renamed from: f */
    public final C1140a f1315f;

    /* renamed from: g */
    public Thread.UncaughtExceptionHandler f1316g;

    /* renamed from: h */
    public Thread.UncaughtExceptionHandler f1317h;

    /* renamed from: i */
    public boolean f1318i = false;

    /* renamed from: j */
    public int f1319j;

    public C1173l(Context context, C1161e c1161e, C1145c c1145c, C1140a c1140a) {
        this.f1312c = context;
        this.f1313d = c1161e;
        this.f1314e = c1145c;
        this.f1315f = c1140a;
    }

    /* renamed from: a */
    public static String m3200a(Throwable th, int i) {
        if (th.getMessage() == null) {
            return "";
        }
        if (i < 0 || th.getMessage().length() <= i) {
            return th.getMessage();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(th.getMessage().substring(0, i));
        sb.append("\n[Message over limit size:");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, i, ", has been cutted!]");
    }

    /* renamed from: a */
    private boolean m3204a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        StackTraceElement[] stackTrace;
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m3203a(Thread thread) {
        synchronized (f1311b) {
            if (f1310a != null && thread.getName().equals(f1310a)) {
                return true;
            }
            f1310a = thread.getName();
            return false;
        }
    }

    /* renamed from: b */
    public static String m3197b(Throwable th, int i) {
        StackTraceElement[] stackTrace;
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i > 0 && sb.length() >= i) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("\n[Stack over limit size :");
                        sb2.append(i);
                        sb2.append(" , has been cutted !]");
                        sb.append(sb2.toString());
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            C1199X.m3081b("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public CrashDetailBean m3201a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String m3197b;
        if (th == null) {
            C1199X.m3076e("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean m3260i = C1164h.m3262g().m3260i();
        String str2 = (!m3260i || !z) ? "" : " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
        if (m3260i && z) {
            C1199X.m3081b("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f1123C = C1141b.m3365h();
        crashDetailBean.f1124D = C1141b.m3361j();
        crashDetailBean.f1125E = C1141b.m3367g();
        crashDetailBean.f1126F = this.f1315f.m3385v();
        crashDetailBean.f1127G = this.f1315f.m3384w();
        crashDetailBean.f1128H = this.f1315f.m3383x();
        crashDetailBean.f1167w = C1208ca.m3043a(this.f1312c, C1164h.f1235e, C1164h.f1238h);
        byte[] m3063b = C1205ba.m3063b();
        crashDetailBean.f1169y = m3063b;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(m3063b == null ? 0 : m3063b.length);
        C1199X.m3078c("user log size:%d", objArr);
        crashDetailBean.f1146b = z ? 0 : 2;
        crashDetailBean.f1149e = this.f1315f.m3395l();
        C1140a c1140a = this.f1315f;
        crashDetailBean.f1150f = c1140a.f1008E;
        crashDetailBean.f1151g = c1140a.m3398i();
        crashDetailBean.f1157m = this.f1315f.m3382y();
        String name = th.getClass().getName();
        String m3200a = m3200a(th, 1000);
        if (m3200a == null) {
            m3200a = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        C1199X.m3081b("stack frame :%d, has cause %b", objArr2);
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 == null || th2 == th) {
            crashDetailBean.f1158n = name;
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m3200a, "", str2);
            crashDetailBean.f1159o = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                crashDetailBean.f1159o = "";
            }
            crashDetailBean.f1160p = stackTraceElement;
            m3197b = m3197b(th, C1164h.f1236f);
            crashDetailBean.f1161q = m3197b;
        } else {
            crashDetailBean.f1158n = th2.getClass().getName();
            String m3200a2 = m3200a(th2, 1000);
            crashDetailBean.f1159o = m3200a2;
            if (m3200a2 == null) {
                crashDetailBean.f1159o = "";
            }
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.f1160p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(m3200a);
            sb.append("\n");
            sb.append(stackTraceElement);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.f1158n);
            sb.append(":");
            sb.append(crashDetailBean.f1159o);
            sb.append("\n");
            m3197b = m3197b(th2, C1164h.f1236f);
            sb.append(m3197b);
            crashDetailBean.f1161q = sb.toString();
        }
        crashDetailBean.f1162r = System.currentTimeMillis();
        crashDetailBean.f1165u = C1208ca.m3004c(crashDetailBean.f1161q.getBytes());
        try {
            crashDetailBean.f1170z = C1208ca.m3046a(C1164h.f1236f, false);
            crashDetailBean.f1121A = this.f1315f.f1043h;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(thread.getName());
            sb2.append("(");
            sb2.append(thread.getId());
            sb2.append(")");
            String sb3 = sb2.toString();
            crashDetailBean.f1122B = sb3;
            crashDetailBean.f1170z.put(sb3, m3197b);
            crashDetailBean.f1129I = this.f1315f.m3389r();
            crashDetailBean.f1152h = this.f1315f.m3391p();
            crashDetailBean.f1153i = this.f1315f.m3392o();
            crashDetailBean.f1134N = this.f1315f.f1035d;
            crashDetailBean.f1135O = this.f1315f.m3427C();
            if (z) {
                this.f1313d.m3284c(crashDetailBean);
            } else {
                boolean z2 = str != null && str.length() > 0;
                boolean z3 = bArr != null && bArr.length > 0;
                if (z2) {
                    HashMap hashMap = new HashMap(1);
                    crashDetailBean.f1136P = hashMap;
                    hashMap.put("UserData", str);
                }
                if (z3) {
                    crashDetailBean.f1142V = bArr;
                }
            }
            crashDetailBean.f1138R = this.f1315f.m3429A();
            crashDetailBean.f1139S = this.f1315f.m3387t();
            crashDetailBean.f1140T = this.f1315f.m3399h();
            crashDetailBean.f1141U = this.f1315f.m3401g();
        } catch (Throwable th3) {
            C1199X.m3081b("handle crash error %s", th3.toString());
        }
        return crashDetailBean;
    }

    /* renamed from: a */
    public synchronized void m3206a() {
        if (this.f1319j >= 10) {
            C1199X.m3078c("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f1318i = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (C1173l.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                C1199X.m3078c("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f1317h = defaultUncaughtExceptionHandler;
            } else {
                C1199X.m3078c("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
            }
            this.f1316g = defaultUncaughtExceptionHandler;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f1319j++;
        C1199X.m3078c("registered java monitor: %s", toString());
    }

    /* renamed from: a */
    public synchronized void m3205a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.f1089f;
            if (z != this.f1318i) {
                C1199X.m3078c("java changed to %b", Boolean.valueOf(z));
                if (strategyBean.f1089f) {
                    m3206a();
                } else {
                    m3199b();
                }
            }
        }
    }

    /* renamed from: a */
    public void m3202a(Thread thread, Throwable th) {
        C1199X.m3081b("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    /* renamed from: b */
    public synchronized void m3199b() {
        this.f1318i = false;
        C1199X.m3078c("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            C1199X.m3078c("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f1316g);
            this.f1319j--;
        }
    }

    /* renamed from: b */
    public void m3198b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        if (z) {
            C1199X.m3081b("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (m3203a(thread)) {
                C1199X.m3078c("this class has handled this exception", new Object[0]);
                if (this.f1317h != null) {
                    C1199X.m3078c("call system handler", new Object[0]);
                    this.f1317h.uncaughtException(thread, th);
                } else {
                    m3202a(thread, th);
                }
            }
        } else {
            C1199X.m3081b("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f1318i) {
                C1199X.m3084a("Java crash handler is disable. Just return.", new Object[0]);
                if (!z) {
                    return;
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f1316g;
                if (uncaughtExceptionHandler != null && m3204a(uncaughtExceptionHandler)) {
                    C1199X.m3081b("sys default last handle start!", new Object[0]);
                    this.f1316g.uncaughtException(thread, th);
                    C1199X.m3081b("sys default last handle end!", new Object[0]);
                    return;
                } else if (this.f1317h != null) {
                    C1199X.m3081b("system handle start!", new Object[0]);
                    this.f1317h.uncaughtException(thread, th);
                    C1199X.m3081b("system handle end!", new Object[0]);
                    return;
                } else {
                    C1199X.m3081b("crashreport last handle start!", new Object[0]);
                    m3202a(thread, th);
                    C1199X.m3081b("crashreport last handle end!", new Object[0]);
                    return;
                }
            }
            if (!this.f1314e.m3341d()) {
                C1199X.m3076e("no remote but still store!", new Object[0]);
            }
            String str2 = "JAVA_CRASH";
            if (!this.f1314e.m3342c().f1089f && this.f1314e.m3341d()) {
                C1199X.m3081b("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                C1161e.m3293a(z ? str2 : "JAVA_CATCH", C1208ca.m3047a(), this.f1315f.f1043h, thread.getName(), C1208ca.m3010b(th), null);
                if (!z) {
                    return;
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f1316g;
                if (uncaughtExceptionHandler2 != null && m3204a(uncaughtExceptionHandler2)) {
                    C1199X.m3081b("sys default last handle start!", new Object[0]);
                    this.f1316g.uncaughtException(thread, th);
                    C1199X.m3081b("sys default last handle end!", new Object[0]);
                    return;
                } else if (this.f1317h != null) {
                    C1199X.m3081b("system handle start!", new Object[0]);
                    this.f1317h.uncaughtException(thread, th);
                    C1199X.m3081b("system handle end!", new Object[0]);
                    return;
                } else {
                    C1199X.m3081b("crashreport last handle start!", new Object[0]);
                    m3202a(thread, th);
                    C1199X.m3081b("crashreport last handle end!", new Object[0]);
                    return;
                }
            }
            CrashDetailBean m3201a = m3201a(thread, th, z, str, bArr);
            if (m3201a == null) {
                C1199X.m3081b("pkg crash datas fail!", new Object[0]);
                if (!z) {
                    return;
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f1316g;
                if (uncaughtExceptionHandler3 != null && m3204a(uncaughtExceptionHandler3)) {
                    C1199X.m3081b("sys default last handle start!", new Object[0]);
                    this.f1316g.uncaughtException(thread, th);
                    C1199X.m3081b("sys default last handle end!", new Object[0]);
                    return;
                } else if (this.f1317h != null) {
                    C1199X.m3081b("system handle start!", new Object[0]);
                    this.f1317h.uncaughtException(thread, th);
                    C1199X.m3081b("system handle end!", new Object[0]);
                    return;
                } else {
                    C1199X.m3081b("crashreport last handle start!", new Object[0]);
                    m3202a(thread, th);
                    C1199X.m3081b("crashreport last handle end!", new Object[0]);
                    return;
                }
            }
            if (!z) {
                str2 = "JAVA_CATCH";
            }
            C1161e.m3293a(str2, C1208ca.m3047a(), this.f1315f.f1043h, thread.getName(), C1208ca.m3010b(th), m3201a);
            if (!this.f1313d.m3286b(m3201a)) {
                this.f1313d.m3295a(m3201a, 3000L, z);
            }
            if (z) {
                this.f1313d.m3282d(m3201a);
            }
            if (!z) {
                return;
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f1316g;
            if (uncaughtExceptionHandler4 != null && m3204a(uncaughtExceptionHandler4)) {
                C1199X.m3081b("sys default last handle start!", new Object[0]);
                this.f1316g.uncaughtException(thread, th);
                C1199X.m3081b("sys default last handle end!", new Object[0]);
            } else if (this.f1317h != null) {
                C1199X.m3081b("system handle start!", new Object[0]);
                this.f1317h.uncaughtException(thread, th);
                C1199X.m3081b("system handle end!", new Object[0]);
            } else {
                C1199X.m3081b("crashreport last handle start!", new Object[0]);
                m3202a(thread, th);
                C1199X.m3081b("crashreport last handle end!", new Object[0]);
            }
        } catch (Throwable th2) {
            try {
                if (!C1199X.m3080b(th2)) {
                    th2.printStackTrace();
                }
                if (!z) {
                    return;
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f1316g;
                if (uncaughtExceptionHandler5 != null && m3204a(uncaughtExceptionHandler5)) {
                    C1199X.m3081b("sys default last handle start!", new Object[0]);
                    this.f1316g.uncaughtException(thread, th);
                    C1199X.m3081b("sys default last handle end!", new Object[0]);
                } else if (this.f1317h != null) {
                    C1199X.m3081b("system handle start!", new Object[0]);
                    this.f1317h.uncaughtException(thread, th);
                    C1199X.m3081b("system handle end!", new Object[0]);
                } else {
                    C1199X.m3081b("crashreport last handle start!", new Object[0]);
                    m3202a(thread, th);
                    C1199X.m3081b("crashreport last handle end!", new Object[0]);
                }
            } catch (Throwable th3) {
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f1316g;
                    if (uncaughtExceptionHandler6 != null && m3204a(uncaughtExceptionHandler6)) {
                        C1199X.m3081b("sys default last handle start!", new Object[0]);
                        this.f1316g.uncaughtException(thread, th);
                        C1199X.m3081b("sys default last handle end!", new Object[0]);
                    } else if (this.f1317h != null) {
                        C1199X.m3081b("system handle start!", new Object[0]);
                        this.f1317h.uncaughtException(thread, th);
                        C1199X.m3081b("system handle end!", new Object[0]);
                    } else {
                        C1199X.m3081b("crashreport last handle start!", new Object[0]);
                        m3202a(thread, th);
                        C1199X.m3081b("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        synchronized (f1311b) {
            m3198b(thread, th, true, null, null);
        }
    }
}
