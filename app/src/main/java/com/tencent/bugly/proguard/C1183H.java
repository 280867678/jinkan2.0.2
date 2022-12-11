package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.bugly.crashreport.common.info.C1140a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.H */
/* loaded from: classes3.dex */
public class C1183H {

    /* renamed from: a */
    public static C1183H f1367a;

    /* renamed from: b */
    public static final long f1368b = System.currentTimeMillis();

    /* renamed from: c */
    public Context f1369c;

    /* renamed from: f */
    public SharedPreferences f1372f;

    /* renamed from: e */
    public Map<Integer, Map<String, C1180E>> f1371e = new HashMap();

    /* renamed from: d */
    public String f1370d = C1140a.m3394m().f1043h;

    public C1183H(Context context) {
        this.f1369c = context;
        this.f1372f = context.getSharedPreferences("crashrecord", 0);
    }

    /* renamed from: a */
    public static synchronized C1183H m3186a() {
        C1183H c1183h;
        synchronized (C1183H.class) {
            c1183h = f1367a;
        }
        return c1183h;
    }

    /* renamed from: a */
    public static synchronized C1183H m3182a(Context context) {
        C1183H c1183h;
        synchronized (C1183H.class) {
            if (f1367a == null) {
                f1367a = new C1183H(context);
            }
            c1183h = f1367a;
        }
        return c1183h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
        if (r2 == null) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f A[Catch: all -> 0x0053, Exception -> 0x0055, TRY_ENTER, TryCatch #5 {Exception -> 0x0055, blocks: (B:8:0x0006, B:10:0x000c, B:12:0x001a, B:18:0x0032, B:31:0x004f, B:32:0x0052), top: B:7:0x0006, outer: #1 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T extends List<?>> void m3183a(int i, T t) {
        ObjectOutputStream objectOutputStream;
        IOException e;
        if (t == null) {
            return;
        }
        try {
            File dir = this.f1369c.getDir("crashrecord", 0);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("");
            ObjectOutputStream objectOutputStream2 = null;
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(dir, sb.toString())));
                try {
                    try {
                        objectOutputStream.writeObject(t);
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        C1199X.m3078c("open record file error", new Object[0]);
                    }
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                objectOutputStream = null;
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream2 != null) {
                }
                throw th;
            }
            objectOutputStream.close();
        } catch (Exception unused) {
            C1199X.m3081b("writeCrashRecord error", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized boolean m3178b(int i) {
        try {
            List<C1180E> m3175c = m3175c(i);
            if (m3175c == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (C1180E c1180e : m3175c) {
                if (c1180e.f1356b != null && c1180e.f1356b.equalsIgnoreCase(this.f1370d) && c1180e.f1358d > 0) {
                    arrayList.add(c1180e);
                }
                if (c1180e.f1357c + 86400000 < currentTimeMillis) {
                    arrayList2.add(c1180e);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() < 2) {
                m3175c.removeAll(arrayList2);
                m3183a(i, (int) m3175c);
                return false;
            } else if (arrayList.size() <= 0 || ((C1180E) arrayList.get(arrayList.size() - 1)).f1357c + 86400000 >= currentTimeMillis) {
                return true;
            } else {
                m3175c.clear();
                m3183a(i, (int) m3175c);
                return false;
            }
        } catch (Exception unused) {
            C1199X.m3081b("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
        if (r6 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
        if (r6 == null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T extends List<?>> T m3175c(int i) {
        ObjectInputStream objectInputStream;
        try {
            File dir = this.f1369c.getDir("crashrecord", 0);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("");
            File file = new File(dir, sb.toString());
            ?? exists = file.exists();
            try {
                if (exists == 0) {
                    return null;
                }
                try {
                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    try {
                        T t = (T) objectInputStream.readObject();
                        objectInputStream.close();
                        return t;
                    } catch (IOException unused) {
                        C1199X.m3078c("open record file error", new Object[0]);
                    } catch (ClassNotFoundException unused2) {
                        C1199X.m3078c("get object error", new Object[0]);
                    }
                } catch (IOException unused3) {
                    objectInputStream = null;
                } catch (ClassNotFoundException unused4) {
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    exists = 0;
                    if (exists != 0) {
                        exists.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused5) {
            C1199X.m3081b("readCrashRecord error", new Object[0]);
        }
        return null;
    }

    /* renamed from: a */
    public void m3184a(int i, int i2) {
        C1198W.m3089c().m3092a(new RunnableC1181F(this, i, i2));
    }

    /* renamed from: a */
    public synchronized boolean m3185a(int i) {
        boolean z;
        z = true;
        try {
            SharedPreferences sharedPreferences = this.f1372f;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("_");
            sb.append(this.f1370d);
            z = sharedPreferences.getBoolean(sb.toString(), true);
            C1198W.m3089c().m3092a(new RunnableC1182G(this, i));
        } catch (Exception unused) {
            C1199X.m3081b("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
