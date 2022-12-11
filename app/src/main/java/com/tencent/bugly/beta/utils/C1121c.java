package com.tencent.bugly.beta.utils;

import com.tencent.bugly.proguard.C1199X;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/* renamed from: com.tencent.bugly.beta.utils.c */
/* loaded from: classes3.dex */
public class C1121c {

    /* renamed from: a */
    public static HashMap<Long, String> f905a = new HashMap<>();

    /* renamed from: c */
    public String f907c;

    /* renamed from: b */
    public C1119a f906b = null;

    /* renamed from: d */
    public long f908d = 0;

    /* renamed from: e */
    public long f909e = 0;

    /* renamed from: f */
    public HashMap<String, C1123b> f910f = null;

    /* renamed from: g */
    public byte[] f911g = new byte[16];

    /* renamed from: h */
    public long f912h = 0;

    /* renamed from: i */
    public long f913i = 0;

    /* renamed from: j */
    public String f914j = null;

    /* renamed from: k */
    public long f915k = 0;

    /* renamed from: l */
    public long f916l = 0;

    /* renamed from: m */
    public long f917m = 0;

    /* renamed from: n */
    public long f918n = 0;

    /* renamed from: o */
    public long f919o = 0;

    /* renamed from: p */
    public long f920p = 0;

    /* renamed from: q */
    public long f921q = 0;

    /* renamed from: r */
    public long f922r = 0;

    /* renamed from: s */
    public long f923s = 0;

    /* renamed from: t */
    public long f924t = 0;

    /* renamed from: u */
    public long f925u = 0;

    /* renamed from: com.tencent.bugly.beta.utils.c$a */
    /* loaded from: classes3.dex */
    public static class C1122a {

        /* renamed from: a */
        public long f926a = -1;

        /* renamed from: b */
        public long f927b = 0;

        /* renamed from: c */
        public long f928c = 0;

        /* renamed from: d */
        public long f929d = -1;

        /* renamed from: e */
        public long f930e = -1;

        /* renamed from: f */
        public long f931f = 0;

        /* renamed from: g */
        public long f932g = 0;

        /* renamed from: h */
        public long f933h = 0;

        /* renamed from: i */
        public long f934i = 0;

        /* renamed from: j */
        public long f935j = 0;

        /* renamed from: a */
        public long m3517a() {
            return this.f929d;
        }

        /* renamed from: a */
        public synchronized void m3516a(long j) {
            this.f929d = j;
        }

        /* renamed from: b */
        public long m3515b() {
            return this.f935j;
        }

        /* renamed from: b */
        public synchronized void m3514b(long j) {
            this.f934i = j;
        }

        /* renamed from: c */
        public long m3513c() {
            return this.f926a;
        }

        /* renamed from: c */
        public synchronized void m3512c(long j) {
            this.f935j = j;
        }

        /* renamed from: d */
        public long m3511d() {
            return this.f930e;
        }

        /* renamed from: d */
        public synchronized void m3510d(long j) {
            this.f928c = j;
        }

        /* renamed from: e */
        public long m3509e() {
            return this.f931f;
        }

        /* renamed from: e */
        public synchronized void m3508e(long j) {
            this.f933h = j;
        }

        /* renamed from: f */
        public synchronized void m3507f(long j) {
            this.f932g = j;
        }

        /* renamed from: g */
        public synchronized void m3506g(long j) {
            this.f926a = j;
        }

        /* renamed from: h */
        public synchronized void m3505h(long j) {
            this.f930e = j;
        }

        /* renamed from: i */
        public synchronized void m3504i(long j) {
            this.f931f = j;
        }

        /* renamed from: j */
        public synchronized void m3503j(long j) {
            this.f927b = j;
        }
    }

    /* renamed from: com.tencent.bugly.beta.utils.c$b */
    /* loaded from: classes3.dex */
    public static class C1123b {

        /* renamed from: a */
        public String f936a = null;

        /* renamed from: b */
        public long f937b = -1;

        /* renamed from: c */
        public long f938c = -1;

        /* renamed from: d */
        public long f939d = 0;

        /* renamed from: e */
        public long f940e = 0;

        /* renamed from: a */
        public long m3502a() {
            return this.f938c;
        }

        /* renamed from: a */
        public synchronized void m3501a(long j) {
            this.f937b = j;
        }

        /* renamed from: a */
        public synchronized void m3500a(String str) {
            this.f936a = str;
        }

        /* renamed from: b */
        public synchronized void m3499b(long j) {
            this.f940e = j;
        }

        /* renamed from: c */
        public synchronized void m3498c(long j) {
            this.f938c = j;
        }

        /* renamed from: d */
        public synchronized void m3497d(long j) {
            this.f939d = j;
        }
    }

    public C1121c(String str) {
        this.f907c = null;
        this.f907c = str;
        f905a.put(3L, "x86");
        f905a.put(7L, "x86");
        f905a.put(8L, "mips");
        f905a.put(10L, "mips");
        f905a.put(40L, "armeabi");
        f905a.put(62L, "x86_64");
        f905a.put(183L, "arm64-v8a");
    }

    /* renamed from: a */
    private long m3535a(byte b) {
        return 1 == b ? C1119a.f890c : 2 == b ? C1119a.f889b : C1119a.f888a;
    }

    /* renamed from: a */
    public static String m3534a(long j, long j2) {
        String str = f905a.get(Long.valueOf(j));
        return (64 != j2 || !str.equals("mips")) ? str : "mips64";
    }

    /* renamed from: a */
    private synchronized HashMap<String, C1123b> m3533a(long j, long j2, long j3) {
        if (!m3524g()) {
            m3531b();
            return null;
        } else if (!this.f906b.m3562b(j)) {
            m3531b();
            return null;
        } else {
            HashMap<String, C1123b> m3529b = m3529b(j2, j3);
            m3531b();
            return m3529b;
        }
    }

    /* renamed from: a */
    public static boolean m3532a(byte[] bArr) {
        return bArr.length >= 3 && Byte.MAX_VALUE == bArr[0] && 69 == bArr[1] && 76 == bArr[2] && 70 == bArr[3];
    }

    /* renamed from: b */
    private long m3530b(byte b) {
        if (1 == b) {
            return 32L;
        }
        return 2 == b ? 64L : 0L;
    }

    /* renamed from: b */
    private synchronized HashMap<String, C1123b> m3529b(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            C1199X.m3076e("The SO file is invalid or has a shell.", new Object[0]);
            return null;
        }
        Vector vector = new Vector();
        for (int i = 0; i < j; i++) {
            vector.add(m3519l());
        }
        C1122a c1122a = (C1122a) vector.get((int) j2);
        long length = new File(this.f907c).length();
        C1199X.m3084a("File length = %d", Long.valueOf(length));
        if (c1122a.m3511d() >= length) {
            C1199X.m3076e("The SO file is invalid or has a shell.", new Object[0]);
            return null;
        }
        C1124d c1124d = new C1124d(this.f907c, c1122a.m3511d(), c1122a.m3509e());
        HashMap<String, C1123b> hashMap = new HashMap<>();
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            C1122a c1122a2 = (C1122a) it.next();
            String m3495a = c1124d.m3495a(c1122a2.m3513c());
            C1123b c1123b = new C1123b();
            c1123b.m3500a(m3495a);
            c1123b.m3501a(c1122a2.m3517a());
            c1123b.m3498c(c1122a2.m3511d());
            c1123b.m3497d(c1122a2.m3509e());
            c1123b.m3499b(c1122a2.m3515b());
            hashMap.put(m3495a, c1123b);
        }
        c1124d.m3496a();
        return hashMap;
    }

    /* renamed from: b */
    private synchronized void m3531b() {
        C1119a c1119a = this.f906b;
        if (c1119a == null) {
            return;
        }
        if (!c1119a.m3567a()) {
            return;
        }
        this.f906b = null;
    }

    /* renamed from: c */
    private String m3528c() {
        return this.f914j;
    }

    /* renamed from: d */
    private long m3527d() {
        return this.f918n;
    }

    /* renamed from: e */
    private long m3526e() {
        return this.f924t;
    }

    /* renamed from: f */
    private long m3525f() {
        return this.f925u;
    }

    /* renamed from: g */
    private synchronized boolean m3524g() {
        boolean z;
        if (this.f906b != null) {
            m3531b();
        }
        try {
            this.f906b = new C1119a(this.f907c, this.f909e);
            z = true;
        } catch (Exception e) {
            e.getMessage();
            z = false;
        }
        return z;
    }

    /* renamed from: h */
    private synchronized boolean m3523h() {
        boolean z;
        if (this.f906b != null) {
            m3531b();
        }
        try {
            this.f906b = new C1119a(this.f907c);
            z = true;
        } catch (Exception e) {
            e.getMessage();
            z = false;
        }
        return z;
    }

    /* renamed from: i */
    private boolean m3522i() {
        if (!m3523h()) {
            return false;
        }
        boolean m3521j = m3521j();
        m3531b();
        return m3521j;
    }

    /* renamed from: j */
    private synchronized boolean m3521j() {
        long m3548h;
        if (!m3520k()) {
            return false;
        }
        try {
            this.f912h = this.f906b.m3547i();
            long m3547i = this.f906b.m3547i();
            this.f913i = m3547i;
            this.f914j = m3534a(m3547i, this.f908d);
            this.f915k = this.f906b.m3550g();
            if (32 == this.f908d) {
                long m3550g = this.f906b.m3550g();
                this.f915k = m3550g;
                this.f916l = m3550g;
                this.f917m = this.f906b.m3550g();
                m3548h = this.f906b.m3550g();
            } else if (64 != this.f908d) {
                return false;
            } else {
                long m3548h2 = this.f906b.m3548h();
                this.f915k = m3548h2;
                this.f916l = m3548h2;
                this.f917m = this.f906b.m3548h();
                m3548h = this.f906b.m3548h();
            }
            this.f918n = m3548h;
            this.f919o = this.f906b.m3550g();
            this.f920p = this.f906b.m3547i();
            this.f921q = this.f906b.m3547i();
            this.f922r = this.f906b.m3547i();
            this.f923s = this.f906b.m3547i();
            this.f924t = this.f906b.m3547i();
            this.f925u = this.f906b.m3547i();
            return true;
        } catch (IOException e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: k */
    private synchronized boolean m3520k() {
        if (!this.f906b.m3565a(this.f911g)) {
            return false;
        }
        if (!m3532a(this.f911g)) {
            return false;
        }
        long m3530b = m3530b(this.f911g[4]);
        this.f908d = m3530b;
        if (0 == m3530b) {
            byte b = this.f911g[4];
            return false;
        }
        long m3535a = m3535a(this.f911g[5]);
        this.f909e = m3535a;
        if (C1119a.f888a == m3535a) {
            byte b2 = this.f911g[5];
            return false;
        }
        this.f906b.m3566a(m3535a);
        return true;
    }

    /* renamed from: l */
    private synchronized C1122a m3519l() {
        long m3548h;
        long m3548h2;
        C1122a c1122a = new C1122a();
        try {
            c1122a.m3506g(this.f906b.m3550g());
            c1122a.m3503j(this.f906b.m3550g());
            if (32 == this.f908d) {
                c1122a.m3510d(this.f906b.m3550g());
                c1122a.m3516a(this.f906b.m3550g());
                c1122a.m3505h(this.f906b.m3550g());
                m3548h = this.f906b.m3550g();
            } else if (64 != this.f908d) {
                return null;
            } else {
                c1122a.m3510d(this.f906b.m3548h());
                c1122a.m3516a(this.f906b.m3548h());
                c1122a.m3505h(this.f906b.m3548h());
                m3548h = this.f906b.m3548h();
            }
            c1122a.m3504i(m3548h);
            c1122a.m3507f(this.f906b.m3550g());
            c1122a.m3508e(this.f906b.m3550g());
            if (32 == this.f908d) {
                c1122a.m3514b(this.f906b.m3550g());
                m3548h2 = this.f906b.m3550g();
            } else if (64 != this.f908d) {
                return null;
            } else {
                c1122a.m3514b(this.f906b.m3548h());
                m3548h2 = this.f906b.m3548h();
            }
            c1122a.m3512c(m3548h2);
            return c1122a;
        } catch (IOException e) {
            e.getMessage();
            return null;
        }
    }

    /* renamed from: m */
    private synchronized boolean m3518m() {
        HashMap<String, C1123b> m3533a;
        m3533a = m3533a(m3527d(), m3526e(), m3525f());
        this.f910f = m3533a;
        return m3533a != null;
    }

    /* renamed from: a */
    public synchronized String m3536a() {
        if (!m3522i()) {
            return null;
        }
        String m3528c = m3528c();
        if (!m3528c.equals("armeabi")) {
            return m3528c;
        }
        if (!m3518m()) {
            return m3528c;
        }
        C1123b c1123b = this.f910f.get(".ARM.attributes");
        if (c1123b == null) {
            return m3528c;
        }
        return C1120b.m3543a(this.f907c, this.f909e, c1123b.m3502a());
    }
}
