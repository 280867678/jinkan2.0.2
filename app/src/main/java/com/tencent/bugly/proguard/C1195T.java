package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.C1082b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.eclipse.jetty.server.AsyncContinuation;

/* renamed from: com.tencent.bugly.proguard.T */
/* loaded from: classes3.dex */
public class C1195T {

    /* renamed from: a */
    public static C1195T f1413a;

    /* renamed from: c */
    public final Context f1415c;

    /* renamed from: d */
    public AbstractC1192P f1416d;

    /* renamed from: f */
    public long f1418f;

    /* renamed from: g */
    public long f1419g;

    /* renamed from: e */
    public Map<Integer, Long> f1417e = new HashMap();

    /* renamed from: h */
    public LinkedBlockingQueue<Runnable> f1420h = new LinkedBlockingQueue<>();

    /* renamed from: i */
    public LinkedBlockingQueue<Runnable> f1421i = new LinkedBlockingQueue<>();

    /* renamed from: j */
    public final Object f1422j = new Object();

    /* renamed from: k */
    public long f1423k = 0;

    /* renamed from: l */
    public int f1424l = 0;

    /* renamed from: b */
    public final C1185J f1414b = C1185J.m3172a();

    public C1195T(Context context) {
        this.f1415c = context;
    }

    /* renamed from: a */
    public static synchronized C1195T m3119a() {
        C1195T c1195t;
        synchronized (C1195T.class) {
            c1195t = f1413a;
        }
        return c1195t;
    }

    /* renamed from: a */
    public static synchronized C1195T m3110a(Context context) {
        C1195T c1195t;
        synchronized (C1195T.class) {
            if (f1413a == null) {
                f1413a = new C1195T(context);
            }
            c1195t = f1413a;
        }
        return c1195t;
    }

    /* renamed from: a */
    private void m3108a(Runnable runnable, long j) {
        if (runnable == null) {
            C1199X.m3076e("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        C1199X.m3084a("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread m3028a = C1208ca.m3028a(runnable, "BUGLY_SYNC_UPLOAD");
        if (m3028a == null) {
            C1199X.m3081b("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            m3107a(runnable, true);
            return;
        }
        try {
            m3028a.join(j);
        } catch (Throwable th) {
            C1199X.m3081b("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            m3107a(runnable, true);
            m3102c(0);
        }
    }

    /* renamed from: a */
    private void m3106a(Runnable runnable, boolean z, boolean z2, long j) {
        if (runnable == null) {
            C1199X.m3076e("[UploadManager] Upload task should not be null", new Object[0]);
        }
        C1199X.m3084a("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z2) {
            m3108a(runnable, j);
            return;
        }
        m3107a(runnable, z);
        m3102c(0);
    }

    /* renamed from: a */
    private boolean m3107a(Runnable runnable, boolean z) {
        if (runnable == null) {
            C1199X.m3078c("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            C1199X.m3084a("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f1422j) {
                (z ? this.f1420h : this.f1421i).put(runnable);
            }
            return true;
        } catch (Throwable th) {
            C1199X.m3081b("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    public static /* synthetic */ int m3103b(C1195T c1195t) {
        int i = c1195t.f1424l - 1;
        c1195t.f1424l = i;
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c A[Catch: all -> 0x015c, TRY_LEAVE, TryCatch #4 {, blocks: (B:10:0x001f, B:14:0x004b, B:15:0x0050, B:21:0x0062, B:25:0x006c, B:28:0x008e, B:32:0x0094, B:35:0x00b6, B:37:0x00b9, B:89:0x0059, B:91:0x005d, B:27:0x0077, B:34:0x009f), top: B:9:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094 A[Catch: all -> 0x015c, TRY_LEAVE, TryCatch #4 {, blocks: (B:10:0x001f, B:14:0x004b, B:15:0x0050, B:21:0x0062, B:25:0x006c, B:28:0x008e, B:32:0x0094, B:35:0x00b6, B:37:0x00b9, B:89:0x0059, B:91:0x005d, B:27:0x0077, B:34:0x009f), top: B:9:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m3102c(int i) {
        int i2;
        int i3;
        int i4;
        if (i < 0) {
            C1199X.m3078c("[UploadManager] Number of task to execute should >= 0", new Object[0]);
            return;
        }
        C1198W m3089c = C1198W.m3089c();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f1422j) {
            C1199X.m3084a("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.f1420h.size();
            int size2 = this.f1421i.size();
            if (size == 0 && size2 == 0) {
                C1199X.m3084a("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            if (i != 0) {
                if (i < size) {
                    size2 = 0;
                    if (m3089c != null || !m3089c.m3088d()) {
                        size2 = 0;
                    }
                    for (i2 = 0; i2 < i; i2++) {
                        Runnable peek = this.f1420h.peek();
                        if (peek == null) {
                            break;
                        }
                        linkedBlockingQueue.put(peek);
                        this.f1420h.poll();
                    }
                    for (i3 = 0; i3 < size2; i3++) {
                        Runnable peek2 = this.f1421i.peek();
                        if (peek2 == null) {
                            break;
                        }
                        linkedBlockingQueue2.put(peek2);
                        this.f1421i.poll();
                    }
                    if (i > 0) {
                        C1199X.m3084a("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(i), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    }
                    for (i4 = 0; i4 < i; i4++) {
                        Runnable runnable = (Runnable) linkedBlockingQueue.poll();
                        if (runnable == null) {
                            break;
                        }
                        synchronized (this.f1422j) {
                            if (this.f1424l < 2 || m3089c == null) {
                                C1199X.m3078c("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                                if (C1208ca.m3028a(new RunnableC1193Q(this, runnable), "BUGLY_ASYNC_UPLOAD") != null) {
                                    synchronized (this.f1422j) {
                                        this.f1424l++;
                                    }
                                } else {
                                    C1199X.m3076e("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new Object[0]);
                                    m3107a(runnable, true);
                                }
                            } else {
                                m3089c.m3092a(runnable);
                            }
                        }
                    }
                    if (size2 > 0) {
                        C1199X.m3084a("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    }
                    if (m3089c != null) {
                        return;
                    }
                    m3089c.m3092a(new RunnableC1194S(this, size2, linkedBlockingQueue2));
                    return;
                } else if (i < size + size2) {
                    size2 = i - size;
                }
            }
            i = size;
            if (m3089c != null) {
            }
            size2 = 0;
            while (i2 < i) {
            }
            while (i3 < size2) {
            }
            if (i > 0) {
            }
            while (i4 < i) {
            }
            if (size2 > 0) {
            }
            if (m3089c != null) {
            }
        }
    }

    /* renamed from: a */
    public long m3105a(boolean z) {
        long j;
        long m3018b = C1208ca.m3018b();
        int i = z ? 5 : 3;
        List<C1188L> m3171a = this.f1414b.m3171a(i);
        if (m3171a == null || m3171a.size() <= 0) {
            j = z ? this.f1419g : this.f1418f;
        } else {
            j = 0;
            try {
                C1188L c1188l = m3171a.get(0);
                if (c1188l.f1402e >= m3018b) {
                    j = C1208ca.m3009b(c1188l.f1404g);
                    if (i == 3) {
                        this.f1418f = j;
                    } else {
                        this.f1419g = j;
                    }
                    m3171a.remove(c1188l);
                }
            } catch (Throwable th) {
                C1199X.m3080b(th);
            }
            if (m3171a.size() > 0) {
                this.f1414b.m3151a(m3171a);
            }
        }
        C1199X.m3084a("[UploadManager] Local network consume: %d KB", Long.valueOf(j / 1024));
        return j;
    }

    /* renamed from: a */
    public void m3117a(int i, int i2, byte[] bArr, String str, String str2, AbstractC1192P abstractC1192P, int i3, int i4, boolean z, Map<String, String> map) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            m3106a(new RunnableC1196U(this.f1415c, i, i2, bArr, str, str2, abstractC1192P, true, i3, i4, false, map), z, false, 0L);
        } catch (Throwable th2) {
            th = th2;
            if (C1199X.m3080b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m3116a(int i, int i2, byte[] bArr, String str, String str2, AbstractC1192P abstractC1192P, long j, boolean z) {
        try {
            try {
                m3106a(new RunnableC1196U(this.f1415c, i, i2, bArr, str, str2, abstractC1192P, true, z), true, true, j);
            } catch (Throwable th) {
                th = th;
                if (C1199X.m3080b(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public void m3115a(int i, int i2, byte[] bArr, String str, String str2, AbstractC1192P abstractC1192P, boolean z, Map<String, String> map) {
        m3117a(i, i2, bArr, str, str2, abstractC1192P, 0, 0, z, map);
    }

    /* renamed from: a */
    public synchronized void m3114a(int i, long j) {
        if (i >= 0) {
            this.f1417e.put(Integer.valueOf(i), Long.valueOf(j));
            C1188L c1188l = new C1188L();
            c1188l.f1399b = i;
            c1188l.f1402e = j;
            c1188l.f1400c = "";
            c1188l.f1401d = "";
            c1188l.f1404g = new byte[0];
            this.f1414b.m3148b(i);
            this.f1414b.m3144c(c1188l);
            C1199X.m3084a("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i), C1208ca.m3045a(j));
        } else {
            C1199X.m3081b("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    public void m3113a(int i, C1235pa c1235pa, String str, String str2, AbstractC1192P abstractC1192P, long j, boolean z) {
        m3116a(i, c1235pa.f1581i, C1189M.m3133a((Object) c1235pa), str, str2, abstractC1192P, j, z);
    }

    /* renamed from: a */
    public void m3112a(int i, C1235pa c1235pa, String str, String str2, AbstractC1192P abstractC1192P, boolean z) {
        m3117a(i, c1235pa.f1581i, C1189M.m3133a((Object) c1235pa), str, str2, abstractC1192P, 0, 0, z, null);
    }

    /* renamed from: a */
    public synchronized void m3111a(long j, boolean z) {
        int i = z ? 5 : 3;
        C1188L c1188l = new C1188L();
        c1188l.f1399b = i;
        c1188l.f1402e = C1208ca.m3018b();
        c1188l.f1400c = "";
        c1188l.f1401d = "";
        c1188l.f1404g = C1208ca.m3017b(j);
        this.f1414b.m3148b(i);
        this.f1414b.m3144c(c1188l);
        if (z) {
            this.f1419g = j;
        } else {
            this.f1418f = j;
        }
        C1199X.m3084a("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
    }

    /* renamed from: a */
    public boolean m3118a(int i) {
        if (C1082b.f703c) {
            C1199X.m3084a("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - m3104b(i);
        C1199X.m3084a("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i));
        if (currentTimeMillis >= AsyncContinuation.DEFAULT_TIMEOUT) {
            return true;
        }
        C1199X.m3078c("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    /* renamed from: b */
    public synchronized long m3104b(int i) {
        long j = 0;
        if (i >= 0) {
            Long l = this.f1417e.get(Integer.valueOf(i));
            if (l != null) {
                return l.longValue();
            }
            List<C1188L> m3171a = this.f1414b.m3171a(i);
            if (m3171a != null && m3171a.size() > 0) {
                if (m3171a.size() > 1) {
                    for (C1188L c1188l : m3171a) {
                        long j2 = c1188l.f1402e;
                        if (j2 > j) {
                            j = j2;
                        }
                    }
                    this.f1414b.m3148b(i);
                } else {
                    j = m3171a.get(0).f1402e;
                }
            }
        } else {
            C1199X.m3081b("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i));
        }
        return j;
    }
}
