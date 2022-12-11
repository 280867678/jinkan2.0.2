package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.C1140a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.tencent.bugly.proguard.ba */
/* loaded from: classes3.dex */
public class C1205ba {

    /* renamed from: a */
    public static boolean f1458a = true;

    /* renamed from: b */
    public static SimpleDateFormat f1459b = null;

    /* renamed from: c */
    public static boolean f1460c = true;

    /* renamed from: d */
    public static int f1461d = 30720;

    /* renamed from: e */
    public static StringBuilder f1462e;

    /* renamed from: f */
    public static StringBuilder f1463f;

    /* renamed from: g */
    public static boolean f1464g;

    /* renamed from: h */
    public static C1206a f1465h;

    /* renamed from: i */
    public static String f1466i;

    /* renamed from: j */
    public static String f1467j;

    /* renamed from: k */
    public static Context f1468k;

    /* renamed from: l */
    public static String f1469l;

    /* renamed from: m */
    public static boolean f1470m;

    /* renamed from: n */
    public static boolean f1471n;

    /* renamed from: o */
    public static ExecutorService f1472o;

    /* renamed from: p */
    public static int f1473p;

    /* renamed from: q */
    public static final Object f1474q = new Object();

    /* renamed from: com.tencent.bugly.proguard.ba$a */
    /* loaded from: classes3.dex */
    public static class C1206a {

        /* renamed from: a */
        public boolean f1475a;

        /* renamed from: b */
        public File f1476b;

        /* renamed from: c */
        public String f1477c;

        /* renamed from: d */
        public long f1478d;

        /* renamed from: e */
        public long f1479e = 30720;

        public C1206a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f1477c = str;
            this.f1475a = m3054a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public boolean m3054a() {
            try {
                File file = new File(this.f1477c);
                this.f1476b = file;
                if (file.exists() && !this.f1476b.delete()) {
                    this.f1475a = false;
                    return false;
                } else if (this.f1476b.createNewFile()) {
                    return true;
                } else {
                    this.f1475a = false;
                    return false;
                }
            } catch (Throwable th) {
                C1199X.m3080b(th);
                this.f1475a = false;
                return false;
            }
        }

        /* renamed from: a */
        public boolean m3052a(String str) {
            byte[] bytes;
            if (!this.f1475a) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.f1476b, true);
                try {
                    fileOutputStream2.write(str.getBytes("UTF-8"));
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    this.f1478d += bytes.length;
                    this.f1475a = true;
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        C1199X.m3080b(th);
                        this.f1475a = false;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    static {
        try {
            f1459b = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            C1199X.m3083a(th.getCause());
        }
    }

    /* renamed from: a */
    public static String m3065a(String str, String str2, String str3, long j) {
        f1462e.setLength(0);
        if (str3.length() > 30720) {
            str3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, -1, str3.length() - 30720);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = f1459b;
        String format = simpleDateFormat != null ? simpleDateFormat.format(date) : date.toString();
        StringBuilder sb = f1462e;
        sb.append(format);
        sb.append(StringUtils.SPACE);
        sb.append(f1473p);
        sb.append(StringUtils.SPACE);
        sb.append(j);
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, StringUtils.SPACE, str, StringUtils.SPACE, str2);
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, ": ", str3, "\u0001\r\n");
        return f1462e.toString();
    }

    /* renamed from: a */
    public static void m3068a(int i) {
        synchronized (f1474q) {
            f1461d = i;
            if (i < 0) {
                f1461d = 0;
            } else if (i > 30720) {
                f1461d = 30720;
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m3067a(Context context) {
        synchronized (C1205ba.class) {
            if (f1470m || context == null || !f1460c) {
                return;
            }
            try {
                f1472o = Executors.newSingleThreadExecutor();
                f1463f = new StringBuilder(0);
                f1462e = new StringBuilder(0);
                f1468k = context;
                C1140a m3421a = C1140a.m3421a(context);
                f1466i = m3421a.f1043h;
                m3421a.getClass();
                f1467j = "";
                StringBuilder sb = new StringBuilder();
                sb.append(f1468k.getFilesDir().getPath());
                sb.append("/");
                sb.append("buglylog_");
                sb.append(f1466i);
                sb.append("_");
                sb.append(f1467j);
                sb.append(".txt");
                f1469l = sb.toString();
                f1473p = Process.myPid();
            } catch (Throwable unused) {
            }
            f1470m = true;
        }
    }

    /* renamed from: a */
    public static void m3064a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        m3060c(str, str2, message + '\n' + C1208ca.m3023a(th));
    }

    /* renamed from: a */
    public static byte[] m3069a() {
        if (!f1460c) {
            return null;
        }
        return C1208ca.m3031a((File) null, f1463f.toString(), "BuglyLog.txt");
    }

    /* renamed from: b */
    public static byte[] m3063b() {
        return f1458a ? m3069a() : m3061c();
    }

    /* renamed from: c */
    public static synchronized void m3060c(String str, String str2, String str3) {
        ExecutorService executorService;
        Runnable runnableC1203aa;
        synchronized (C1205ba.class) {
            if (!f1470m || !f1460c) {
                return;
            }
            try {
                if (f1471n) {
                    executorService = f1472o;
                    runnableC1203aa = new RunnableC1201Z(str, str2, str3);
                } else {
                    executorService = f1472o;
                    runnableC1203aa = new RunnableC1203aa(str, str2, str3);
                }
                executorService.execute(runnableC1203aa);
            } catch (Exception e) {
                C1199X.m3083a(e);
            }
        }
    }

    /* renamed from: c */
    public static byte[] m3061c() {
        if (!f1460c) {
            return null;
        }
        if (f1471n) {
            C1199X.m3078c("[LogUtil] Get user log from native.", new Object[0]);
            String m3059d = m3059d();
            if (m3059d != null) {
                C1199X.m3078c("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(m3059d.length()));
                return C1208ca.m3031a((File) null, m3059d, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb = new StringBuilder();
        synchronized (f1474q) {
            if (f1465h != null && f1465h.f1475a && f1465h.f1476b != null && f1465h.f1476b.length() > 0) {
                sb.append(C1208ca.m3034a(f1465h.f1476b, 30720, true));
            }
            if (f1463f != null && f1463f.length() > 0) {
                sb.append(f1463f.toString());
            }
        }
        return C1208ca.m3031a((File) null, sb.toString(), "BuglyLog.txt");
    }

    /* renamed from: d */
    public static String m3059d() {
        try {
            C1140a m3394m = C1140a.m3394m();
            if (m3394m != null && m3394m.f1060pa != null) {
                return m3394m.f1060pa.getLogFromNative();
            }
            return null;
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public static synchronized void m3058d(String str, String str2, String str3) {
        synchronized (C1205ba.class) {
            if (f1458a) {
                m3057e(str, str2, str3);
            } else {
                m3055g(str, str2, str3);
            }
        }
    }

    /* renamed from: e */
    public static synchronized void m3057e(String str, String str2, String str3) {
        synchronized (C1205ba.class) {
            String m3065a = m3065a(str, str2, str3, Process.myTid());
            synchronized (f1474q) {
                f1463f.append(m3065a);
                if (f1463f.length() >= f1461d) {
                    f1463f = f1463f.delete(0, f1463f.indexOf("\u0001\r\n") + 1);
                }
            }
        }
    }

    /* renamed from: f */
    public static boolean m3056f(String str, String str2, String str3) {
        try {
            C1140a m3394m = C1140a.m3394m();
            if (m3394m != null && m3394m.f1060pa != null) {
                return m3394m.f1060pa.appendLogToNative(str, str2, str3);
            }
            return false;
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: g */
    public static synchronized void m3055g(String str, String str2, String str3) {
        synchronized (C1205ba.class) {
            String m3065a = m3065a(str, str2, str3, Process.myTid());
            synchronized (f1474q) {
                try {
                    f1463f.append(m3065a);
                } catch (Throwable unused) {
                }
                if (f1463f.length() <= f1461d) {
                    return;
                }
                if (f1464g) {
                    return;
                }
                f1464g = true;
                if (f1465h == null) {
                    f1465h = new C1206a(f1469l);
                } else if (f1465h.f1476b == null || f1465h.f1476b.length() + f1463f.length() > f1465h.f1479e) {
                    f1465h.m3054a();
                }
                if (f1465h.m3052a(f1463f.toString())) {
                    f1463f.setLength(0);
                    f1464g = false;
                }
            }
        }
    }
}
