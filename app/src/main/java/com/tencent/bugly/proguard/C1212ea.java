package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.bugly.proguard.ea */
/* loaded from: classes3.dex */
public class C1212ea extends Thread {

    /* renamed from: a */
    public boolean f1499a = false;

    /* renamed from: b */
    public boolean f1500b = false;

    /* renamed from: c */
    public final List<RunnableC1210da> f1501c = new ArrayList();

    /* renamed from: d */
    public List<AbstractC1214fa> f1502d = new ArrayList();

    /* renamed from: e */
    public ArrayList<RunnableC1210da> f1503e = new ArrayList<>();

    /* renamed from: e */
    private int m2973e() {
        int i = 0;
        for (int i2 = 0; i2 < this.f1501c.size(); i2++) {
            try {
                i = Math.max(i, this.f1501c.get(i2).m2998a());
            } catch (Exception e) {
                C1199X.m3083a(e);
            }
        }
        return i;
    }

    /* renamed from: a */
    public void m2982a() {
        m2981a(new Handler(Looper.getMainLooper()));
    }

    /* renamed from: a */
    public void m2981a(Handler handler) {
        m2980a(handler, 5000L);
    }

    /* renamed from: a */
    public void m2980a(Handler handler, long j) {
        if (handler == null) {
            C1199X.m3081b("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i = 0; i < this.f1501c.size(); i++) {
            try {
                if (this.f1501c.get(i).m2995c().equals(handler.getLooper().getThread().getName())) {
                    C1199X.m3081b("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                }
            } catch (Exception e) {
                C1199X.m3083a(e);
            }
        }
        this.f1501c.add(new RunnableC1210da(handler, name, j));
    }

    /* renamed from: a */
    public void m2979a(AbstractC1214fa abstractC1214fa) {
        if (this.f1502d.contains(abstractC1214fa)) {
            C1199X.m3084a("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.f1502d.add(abstractC1214fa);
        }
    }

    /* renamed from: a */
    public void m2978a(boolean z) {
        this.f1500b = z;
    }

    /* renamed from: b */
    public void m2977b() {
        for (int i = 0; i < this.f1501c.size(); i++) {
            try {
                if (this.f1501c.get(i).m2995c().equals(Looper.getMainLooper().getThread().getName())) {
                    C1199X.m3084a("remove handler::%s", this.f1501c.get(i));
                    this.f1501c.remove(i);
                }
            } catch (Exception e) {
                C1199X.m3083a(e);
                return;
            }
        }
    }

    /* renamed from: b */
    public void m2976b(AbstractC1214fa abstractC1214fa) {
        this.f1502d.remove(abstractC1214fa);
    }

    /* renamed from: c */
    public boolean m2975c() {
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e) {
            C1199X.m3083a(e);
            return false;
        }
    }

    /* renamed from: d */
    public boolean m2974d() {
        this.f1499a = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e) {
            C1199X.m3083a(e);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.f1499a) {
            for (int i = 0; i < this.f1501c.size(); i++) {
                try {
                    this.f1501c.get(i).m2992f();
                } catch (Exception | OutOfMemoryError e) {
                    C1199X.m3083a(e);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (long j = 2000; j > 0 && !isInterrupted(); j = 2000 - (SystemClock.uptimeMillis() - uptimeMillis)) {
                Thread.sleep(j);
            }
            int m2973e = m2973e();
            if (m2973e != 0 && m2973e != 1) {
                this.f1503e.clear();
                for (int i2 = 0; i2 < this.f1501c.size(); i2++) {
                    RunnableC1210da runnableC1210da = this.f1501c.get(i2);
                    if (runnableC1210da.m2994d()) {
                        this.f1503e.add(runnableC1210da);
                        runnableC1210da.m2997a(Long.MAX_VALUE);
                    }
                }
                int i3 = 0;
                while (true) {
                    if (this.f1500b) {
                        break;
                    }
                    C1199X.m3084a("do not enable anr continue check", new Object[0]);
                    Thread.sleep(2000L);
                    i3++;
                    if (i3 == 15) {
                        this.f1503e.clear();
                        break;
                    }
                }
                for (int i4 = 0; i4 < this.f1503e.size(); i4++) {
                    RunnableC1210da runnableC1210da2 = this.f1503e.get(i4);
                    for (int i5 = 0; i5 < this.f1502d.size(); i5++) {
                        C1199X.m3081b("main thread blocked,now begin to upload anr stack", new Object[0]);
                        this.f1502d.get(i5).mo2971a(runnableC1210da2);
                        this.f1500b = false;
                    }
                }
            }
        }
    }
}
