package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.C1563aw;
import com.umeng.analytics.pro.C1572bc;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.proto.C1810a;
import com.umeng.commonsdk.statistics.proto.C1817b;
import com.umeng.commonsdk.statistics.proto.C1824c;
import com.umeng.commonsdk.utils.C1847b;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.tvspark.outline;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.e */
/* loaded from: classes4.dex */
public class C1786e {

    /* renamed from: a */
    public static final long f4095a = 86400000;

    /* renamed from: b */
    public static C1786e f4096b = null;

    /* renamed from: c */
    public static final String f4097c = "umeng_it.cache";

    /* renamed from: j */
    public static Object f4098j = new Object();

    /* renamed from: d */
    public File f4099d;

    /* renamed from: f */
    public long f4101f;

    /* renamed from: i */
    public C1787a f4104i;

    /* renamed from: e */
    public C1824c f4100e = null;

    /* renamed from: h */
    public Set<AbstractC1782a> f4103h = new HashSet();

    /* renamed from: g */
    public long f4102g = 86400000;

    /* renamed from: com.umeng.commonsdk.statistics.idtracking.e$a */
    /* loaded from: classes4.dex */
    public static class C1787a {

        /* renamed from: a */
        public Context f4105a;

        /* renamed from: b */
        public Set<String> f4106b = new HashSet();

        public C1787a(Context context) {
            this.f4105a = context;
        }

        /* renamed from: a */
        public synchronized void m441a() {
            if (!this.f4106b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String str : this.f4106b) {
                    sb.append(str);
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.f4105a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        /* renamed from: a */
        public synchronized boolean m440a(String str) {
            return !this.f4106b.contains(str);
        }

        /* renamed from: b */
        public synchronized void m439b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.f4105a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f4106b.add(str);
                    }
                }
            }
        }

        /* renamed from: b */
        public synchronized void m438b(String str) {
            this.f4106b.add(str);
        }

        /* renamed from: c */
        public void m437c(String str) {
            this.f4106b.remove(str);
        }
    }

    public C1786e(Context context) {
        this.f4104i = null;
        this.f4099d = new File(context.getFilesDir(), f4097c);
        C1787a c1787a = new C1787a(context);
        this.f4104i = c1787a;
        c1787a.m439b();
    }

    /* renamed from: a */
    public static synchronized C1786e m453a(Context context) {
        C1786e c1786e;
        synchronized (C1786e.class) {
            if (f4096b == null) {
                C1786e c1786e2 = new C1786e(context);
                f4096b = c1786e2;
                c1786e2.m452a(new C1788f(context));
                f4096b.m452a(new C1783b(context));
                f4096b.m452a(new C1792j(context));
                f4096b.m452a(new C1785d(context));
                f4096b.m452a(new C1784c(context));
                f4096b.m452a(new C1789g(context));
                f4096b.m452a(new C1791i());
                if (FieldManager.allow(C1847b.f4256G)) {
                    f4096b.m452a(new C1790h(context));
                }
                f4096b.m445f();
            }
            c1786e = f4096b;
        }
        return c1786e;
    }

    /* renamed from: a */
    public static synchronized void m455a() {
        synchronized (C1786e.class) {
            if (f4096b != null) {
                f4096b.m446e();
                f4096b = null;
            }
        }
    }

    /* renamed from: a */
    private void m451a(C1824c c1824c) {
        Map<String, C1817b> map;
        if (c1824c == null || (map = c1824c.f4191a) == null) {
            return;
        }
        if (map.containsKey(C1789g.f4109a) && !FieldManager.allow(C1847b.f4296h)) {
            c1824c.f4191a.remove(C1789g.f4109a);
        }
        if (c1824c.f4191a.containsKey(C1788f.f4107a) && !FieldManager.allow(C1847b.f4295g)) {
            c1824c.f4191a.remove(C1788f.f4107a);
        }
        if (c1824c.f4191a.containsKey(C1783b.f4089a) && !FieldManager.allow(C1847b.f4297i)) {
            c1824c.f4191a.remove(C1783b.f4089a);
        }
        if (c1824c.f4191a.containsKey(C1791i.f4116a) && !FieldManager.allow(C1847b.f4298j)) {
            c1824c.f4191a.remove(C1791i.f4116a);
        }
        if (c1824c.f4191a.containsKey(C1784c.f4091a) && !FieldManager.allow(C1847b.f4311w)) {
            c1824c.f4191a.remove(C1784c.f4091a);
        }
        if (!c1824c.f4191a.containsKey(C1790h.f4114d) || FieldManager.allow(C1847b.f4256G)) {
            return;
        }
        c1824c.f4191a.remove(C1790h.f4114d);
    }

    /* renamed from: a */
    private boolean m452a(AbstractC1782a abstractC1782a) {
        if (this.f4104i.m440a(abstractC1782a.m460b())) {
            return this.f4103h.add(abstractC1782a);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("invalid domain: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(abstractC1782a.m460b());
        MLog.m556w(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        return false;
    }

    /* renamed from: b */
    private void m449b(C1824c c1824c) {
        byte[] m1216a;
        synchronized (f4098j) {
            if (c1824c != null) {
                try {
                    synchronized (this) {
                        m451a(c1824c);
                        m1216a = new C1572bc().m1216a(c1824c);
                    }
                    if (m1216a != null) {
                        HelperUtils.writeFile(this.f4099d, m1216a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: h */
    private synchronized void m443h() {
        C1824c c1824c = new C1824c();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (AbstractC1782a abstractC1782a : this.f4103h) {
            if (abstractC1782a.m459c()) {
                if (abstractC1782a.m458d() != null) {
                    hashMap.put(abstractC1782a.m460b(), abstractC1782a.m458d());
                }
                if (abstractC1782a.m457e() != null && !abstractC1782a.m457e().isEmpty()) {
                    arrayList.addAll(abstractC1782a.m457e());
                }
            }
        }
        c1824c.m328a(arrayList);
        c1824c.m327a(hashMap);
        synchronized (this) {
            this.f4100e = c1824c;
        }
    }

    /* renamed from: i */
    private C1824c m442i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (f4098j) {
            if (!this.f4099d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f4099d);
                try {
                    try {
                        byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                        C1824c c1824c = new C1824c();
                        new C1563aw().m1234a(c1824c, readStreamToByteArray);
                        HelperUtils.safeClose(fileInputStream);
                        return c1824c;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        HelperUtils.safeClose(fileInputStream);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th;
            }
        }
    }

    /* renamed from: a */
    public void m454a(long j) {
        this.f4102g = j;
    }

    /* renamed from: b */
    public synchronized void m450b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f4101f >= this.f4102g) {
            boolean z = false;
            for (AbstractC1782a abstractC1782a : this.f4103h) {
                if (abstractC1782a.m459c() && abstractC1782a.m465a()) {
                    z = true;
                    if (!abstractC1782a.m459c()) {
                        this.f4104i.m438b(abstractC1782a.m460b());
                    }
                }
            }
            if (z) {
                m443h();
                this.f4104i.m441a();
                m444g();
            }
            this.f4101f = currentTimeMillis;
        }
    }

    /* renamed from: c */
    public synchronized C1824c m448c() {
        return this.f4100e;
    }

    /* renamed from: d */
    public String m447d() {
        return null;
    }

    /* renamed from: e */
    public synchronized void m446e() {
        if (f4096b == null) {
            return;
        }
        boolean z = false;
        for (AbstractC1782a abstractC1782a : this.f4103h) {
            if (abstractC1782a.m459c() && abstractC1782a.m457e() != null && !abstractC1782a.m457e().isEmpty()) {
                abstractC1782a.m461a((List<C1810a>) null);
                z = true;
            }
        }
        if (z) {
            this.f4100e.m324b(false);
            m444g();
        }
    }

    /* renamed from: f */
    public synchronized void m445f() {
        C1824c m442i = m442i();
        if (m442i == null) {
            return;
        }
        m451a(m442i);
        ArrayList arrayList = new ArrayList(this.f4103h.size());
        synchronized (this) {
            this.f4100e = m442i;
            for (AbstractC1782a abstractC1782a : this.f4103h) {
                abstractC1782a.m463a(this.f4100e);
                if (!abstractC1782a.m459c()) {
                    arrayList.add(abstractC1782a);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f4103h.remove((AbstractC1782a) it.next());
            }
            m443h();
        }
    }

    /* renamed from: g */
    public synchronized void m444g() {
        if (this.f4100e != null) {
            m449b(this.f4100e);
        }
    }
}
