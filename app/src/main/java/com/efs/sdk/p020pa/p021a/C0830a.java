package com.efs.sdk.p020pa.p021a;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.efs.sdk.p020pa.PAANRListener;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.efs.sdk.pa.a.a */
/* loaded from: classes3.dex */
public final class C0830a {

    /* renamed from: a */
    public volatile boolean f501a;

    /* renamed from: b */
    public final Handler f502b;

    /* renamed from: c */
    public final Thread f503c;

    /* renamed from: d */
    public long f504d;

    /* renamed from: e */
    public long f505e;

    /* renamed from: f */
    public boolean f506f;

    /* renamed from: g */
    public Handler f507g;

    /* renamed from: h */
    public PAANRListener f508h;

    /* renamed from: i */
    public long f509i;

    /* renamed from: j */
    public long f510j;

    /* renamed from: k */
    public final long f511k;

    /* renamed from: l */
    public boolean f512l;

    /* renamed from: m */
    public final Runnable f513m;

    /* renamed from: n */
    public final Runnable f514n;

    /* renamed from: o */
    public HandlerThread f515o;

    /* renamed from: p */
    public Application f516p;

    public C0830a(Application application, long j) {
        this(application, j, true);
    }

    public C0830a(Application application, long j, boolean z) {
        this.f501a = true;
        this.f505e = 4L;
        this.f506f = true;
        this.f509i = 0L;
        this.f513m = new Runnable() { // from class: com.efs.sdk.pa.a.a.1
            /* JADX WARN: Code restructure failed: missing block: B:30:0x006c, code lost:
                if (com.efs.sdk.p020pa.p021a.C0830a.m3939a(r1) != false) goto L24;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                PAANRListener pAANRListener;
                if (C0830a.this.f506f) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                C0830a c0830a = C0830a.this;
                long j2 = uptimeMillis - c0830a.f510j;
                if (j2 > c0830a.f511k && (pAANRListener = c0830a.f508h) != null) {
                    pAANRListener.unexcept(Long.valueOf(j2));
                }
                if (C0830a.this.f501a) {
                    C0830a c0830a2 = C0830a.this;
                    c0830a2.f509i = 0L;
                    c0830a2.f501a = false;
                    C0830a c0830a3 = C0830a.this;
                    c0830a3.f502b.postAtFrontOfQueue(c0830a3.f514n);
                } else {
                    C0830a c0830a4 = C0830a.this;
                    c0830a4.f509i++;
                    if (!c0830a4.f501a) {
                        C0830a c0830a5 = C0830a.this;
                        long j3 = c0830a5.f509i;
                        long j4 = c0830a5.f505e;
                        if (j3 >= j4 && j3 == j4) {
                            StringBuilder sb = new StringBuilder();
                            if (c0830a5.f512l) {
                                sb.append(C0830a.m3938a(c0830a5.f503c));
                            }
                            if (c0830a5.f508h != null && sb.length() > 0) {
                                c0830a5.f508h.anrStack(sb.toString());
                            }
                        }
                    }
                }
                C0830a.this.f510j = SystemClock.uptimeMillis();
                C0830a c0830a6 = C0830a.this;
                c0830a6.f507g.postDelayed(c0830a6.f513m, c0830a6.f504d);
            }
        };
        this.f514n = new Runnable() { // from class: com.efs.sdk.pa.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                C0830a.this.f501a = true;
            }
        };
        this.f511k = j;
        this.f516p = application;
        this.f512l = z;
        long j2 = (((float) j) * 0.8f) / this.f505e;
        this.f504d = j2;
        if (j2 < 100) {
            this.f504d = 100L;
            this.f505e = j / 100;
        }
        this.f503c = Looper.getMainLooper().getThread();
        this.f502b = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("ANR HANDLER THREAD");
        this.f515o = handlerThread;
        handlerThread.start();
        this.f507g = new Handler(this.f515o.getLooper());
    }

    /* renamed from: a */
    public static String m3938a(Thread thread) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        sb.append(thread.getName());
        sb.append(StringUtils.SPACE);
        sb.append(thread.getPriority());
        sb.append(StringUtils.SPACE);
        sb.append(thread.getState());
        sb.append("\n");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElement2 = stackTraceElement.toString();
            sb.append("  at  ");
            sb.append(stackTraceElement2);
            sb.append('\n');
        }
        sb.append("\n");
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m3939a(StringBuilder sb) {
        Set<Map.Entry<Thread, StackTraceElement[]>> entrySet = Thread.getAllStackTraces().entrySet();
        if (entrySet.size() == 0) {
            return false;
        }
        boolean z = false;
        for (Map.Entry<Thread, StackTraceElement[]> entry : entrySet) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            if (key.getId() == Looper.getMainLooper().getThread().getId()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(key.getName());
                sb2.append(StringUtils.SPACE);
                sb2.append(key.getPriority());
                sb2.append(StringUtils.SPACE);
                sb2.append(key.getState());
                sb2.append("\n");
                for (StackTraceElement stackTraceElement : value) {
                    String stackTraceElement2 = stackTraceElement.toString();
                    sb2.append("  at  ");
                    sb2.append(stackTraceElement2);
                    sb2.append('\n');
                }
                sb2.append("\n");
                sb.insert(0, (CharSequence) sb2);
                z = true;
            } else {
                sb.append(key.getName());
                sb.append(StringUtils.SPACE);
                sb.append(key.getPriority());
                sb.append(StringUtils.SPACE);
                sb.append(key.getState());
                sb.append("\n");
                for (StackTraceElement stackTraceElement3 : value) {
                    String stackTraceElement4 = stackTraceElement3.toString();
                    sb.append("  at  ");
                    sb.append(stackTraceElement4);
                    sb.append('\n');
                }
                sb.append("\n");
            }
        }
        if (!z) {
            sb.insert(0, m3938a(Looper.getMainLooper().getThread()));
        }
        return true;
    }
}
