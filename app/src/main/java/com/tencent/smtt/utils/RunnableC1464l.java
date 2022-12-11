package com.tencent.smtt.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import me.tvspark.outline;

/* renamed from: com.tencent.smtt.utils.l */
/* loaded from: classes4.dex */
public class RunnableC1464l implements Runnable {

    /* renamed from: a */
    public static String f2514a = "TBSFileLock";

    /* renamed from: f */
    public static Object f2515f = new Object();

    /* renamed from: g */
    public static Object f2516g = new Object();

    /* renamed from: h */
    public static HashMap<RunnableC1464l, Object> f2517h;

    /* renamed from: i */
    public static Handler f2518i;

    /* renamed from: b */
    public File f2519b;

    /* renamed from: c */
    public RandomAccessFile f2520c = null;

    /* renamed from: d */
    public FileLock f2521d = null;

    /* renamed from: e */
    public long f2522e = 0;

    public RunnableC1464l(File file, String str) {
        this.f2519b = null;
        this.f2519b = new File(file, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".", str, ".lock"));
    }

    /* renamed from: a */
    public Handler m2029a() {
        if (f2518i == null) {
            synchronized (RunnableC1464l.class) {
                if (f2518i == null) {
                    HandlerThread handlerThread = new HandlerThread("QBFileLock.Thread");
                    handlerThread.start();
                    f2518i = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f2518i;
    }

    /* renamed from: a */
    public synchronized void m2028a(boolean z) {
        this.f2519b.getName();
        if (this.f2521d != null) {
            try {
                this.f2521d.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f2521d = null;
        }
        if (this.f2520c != null) {
            try {
                this.f2520c.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f2520c = null;
        }
        if (f2518i != null && this.f2522e > 0) {
            f2518i.removeCallbacks(this);
        }
        if (z) {
            m2025d();
        }
    }

    /* renamed from: b */
    public synchronized void m2027b() {
        FileChannel channel;
        try {
            this.f2520c = new RandomAccessFile(this.f2519b, "rw");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f2520c != null && (channel = this.f2520c.getChannel()) != null) {
            if (this.f2522e > 0) {
                m2029a().postDelayed(this, this.f2522e);
            }
            FileLock fileLock = null;
            long currentTimeMillis = System.currentTimeMillis();
            do {
                try {
                    fileLock = channel.lock();
                    if (fileLock != null) {
                        break;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            } while (Math.abs(System.currentTimeMillis() - currentTimeMillis) < 1000);
            this.f2521d = fileLock;
            this.f2519b.getName();
            System.currentTimeMillis();
        }
        if (this.f2521d != null) {
            m2026c();
        }
    }

    /* renamed from: c */
    public void m2026c() {
        synchronized (f2516g) {
            if (f2517h == null) {
                f2517h = new HashMap<>();
            }
            f2517h.put(this, f2515f);
        }
    }

    /* renamed from: d */
    public void m2025d() {
        synchronized (f2516g) {
            if (f2517h == null) {
                return;
            }
            f2517h.remove(this);
        }
    }

    /* renamed from: e */
    public void m2024e() {
        m2028a(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        m2024e();
    }
}
