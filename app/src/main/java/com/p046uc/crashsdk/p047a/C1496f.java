package com.p046uc.crashsdk.p047a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* renamed from: com.uc.crashsdk.a.f */
/* loaded from: classes4.dex */
public class C1496f {

    /* renamed from: b */
    public static volatile HandlerThread f2638b;

    /* renamed from: c */
    public static volatile HandlerThread f2639c;

    /* renamed from: d */
    public static volatile HandlerThread f2640d;

    /* renamed from: e */
    public static Handler f2641e;

    /* renamed from: f */
    public static Handler f2642f;

    /* renamed from: g */
    public static Handler f2643g;

    /* renamed from: h */
    public static Handler f2644h;

    /* renamed from: a */
    public static final /* synthetic */ boolean f2637a = !C1496f.class.desiredAssertionStatus();

    /* renamed from: i */
    public static final HashMap<Object, Object[]> f2645i = new HashMap<>();

    /* renamed from: a */
    public static Handler m1890a(int i) {
        if (i == 0) {
            if (f2638b == null) {
                m1891a();
            }
            return f2641e;
        } else if (i == 1) {
            if (f2639c == null) {
                m1885b();
            }
            return f2642f;
        } else if (i == 2) {
            if (f2643g == null) {
                f2643g = new Handler(Looper.getMainLooper());
            }
            return f2643g;
        } else if (i == 3) {
            if (f2644h == null) {
                m1883c();
            }
            return f2644h;
        } else {
            throw new RuntimeException("unknown thread type: " + i);
        }
    }

    /* renamed from: a */
    public static synchronized void m1891a() {
        synchronized (C1496f.class) {
            if (f2638b == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKBkgdHandler", 10);
                f2638b = handlerThread;
                handlerThread.start();
                f2641e = new Handler(f2638b.getLooper());
            }
        }
    }

    /* renamed from: a */
    public static void m1887a(int i, Object[] objArr) {
        if (i != 10) {
            if (!f2637a) {
                throw new AssertionError();
            }
        } else if (!f2637a && objArr == null) {
            throw new AssertionError();
        } else {
            Runnable runnable = (Runnable) objArr[0];
            synchronized (f2645i) {
                if (f2645i.get(runnable) != null) {
                    f2645i.remove(runnable);
                }
            }
            runnable.run();
        }
    }

    /* renamed from: a */
    public static void m1886a(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return;
        }
        synchronized (f2645i) {
            objArr = f2645i.get(runnable);
        }
        if (objArr == null) {
            return;
        }
        int intValue = ((Integer) objArr[1]).intValue();
        Handler handler = null;
        if (intValue == 0) {
            handler = f2641e;
        } else if (intValue == 1) {
            handler = f2642f;
        } else if (intValue == 2) {
            handler = f2643g;
        }
        if (handler != null) {
            handler.removeCallbacks((Runnable) objArr[0]);
        }
        synchronized (f2645i) {
            if (f2645i.get(runnable) != null) {
                f2645i.remove(runnable);
            }
        }
    }

    /* renamed from: a */
    public static boolean m1889a(int i, Runnable runnable) {
        return m1888a(i, runnable, 0L);
    }

    /* renamed from: a */
    public static boolean m1888a(int i, Runnable runnable, long j) {
        Handler m1890a;
        if (runnable == null || (m1890a = m1890a(i)) == null) {
            return false;
        }
        RunnableC1495e runnableC1495e = new RunnableC1495e(10, new Object[]{runnable});
        synchronized (f2645i) {
            f2645i.put(runnable, new Object[]{runnableC1495e, Integer.valueOf(i)});
        }
        return m1890a.postDelayed(runnableC1495e, j);
    }

    /* renamed from: b */
    public static synchronized void m1885b() {
        synchronized (C1496f.class) {
            if (f2639c == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKNormalHandler", 0);
                f2639c = handlerThread;
                handlerThread.start();
                f2642f = new Handler(f2639c.getLooper());
            }
        }
    }

    /* renamed from: b */
    public static boolean m1884b(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return false;
        }
        synchronized (f2645i) {
            objArr = f2645i.get(runnable);
        }
        return objArr != null;
    }

    /* renamed from: c */
    public static synchronized void m1883c() {
        synchronized (C1496f.class) {
            if (f2640d == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKAnrHandler", 0);
                f2640d = handlerThread;
                handlerThread.start();
                f2644h = new Handler(f2640d.getLooper());
            }
        }
    }
}
