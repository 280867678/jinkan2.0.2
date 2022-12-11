package com.tencent.smtt.utils;

import android.os.Build;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.smtt.utils.p */
/* loaded from: classes4.dex */
public class C1469p {

    /* renamed from: a */
    public C1471b f2543a = null;

    /* renamed from: b */
    public C1471b f2544b = null;

    /* renamed from: com.tencent.smtt.utils.p$a */
    /* loaded from: classes4.dex */
    public class C1470a {

        /* renamed from: b */
        public String f2546b;

        /* renamed from: c */
        public long f2547c;

        /* renamed from: d */
        public long f2548d;

        public C1470a(String str, long j, long j2) {
            this.f2546b = str;
            this.f2547c = j;
            this.f2548d = j2;
        }

        /* renamed from: a */
        public long m1996a() {
            return this.f2547c;
        }

        /* renamed from: b */
        public long m1995b() {
            return this.f2548d;
        }
    }

    /* renamed from: com.tencent.smtt.utils.p$b */
    /* loaded from: classes4.dex */
    public class C1471b {

        /* renamed from: b */
        public Map<String, C1470a> f2550b;

        public C1471b(File file) {
            HashMap hashMap = new HashMap();
            this.f2550b = hashMap;
            hashMap.clear();
            m1993a(file);
        }

        /* renamed from: a */
        private void m1993a(File file) {
            if (!file.isDirectory()) {
                if (!file.isFile()) {
                    return;
                }
                m1992a(file.getName(), file.length(), file.lastModified());
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null && Build.VERSION.SDK_INT >= 26) {
                return;
            }
            for (File file2 : listFiles) {
                m1993a(file2);
            }
        }

        /* renamed from: a */
        private void m1992a(String str, long j, long j2) {
            if (str == null || str.length() <= 0 || j <= 0 || j2 <= 0) {
                return;
            }
            C1470a c1470a = new C1470a(str, j, j2);
            if (this.f2550b.containsKey(str)) {
                return;
            }
            this.f2550b.put(str, c1470a);
        }

        /* renamed from: a */
        public Map<String, C1470a> m1994a() {
            return this.f2550b;
        }
    }

    /* renamed from: a */
    private boolean m1999a(C1471b c1471b, C1471b c1471b2) {
        if (c1471b == null || c1471b.m1994a() == null || c1471b2 == null || c1471b2.m1994a() == null) {
            return false;
        }
        Map<String, C1470a> m1994a = c1471b.m1994a();
        Map<String, C1470a> m1994a2 = c1471b2.m1994a();
        for (Map.Entry<String, C1470a> entry : m1994a.entrySet()) {
            String key = entry.getKey();
            C1470a value = entry.getValue();
            if (m1994a2.containsKey(key)) {
                C1470a c1470a = m1994a2.get(key);
                if (value.m1996a() == c1470a.m1996a()) {
                    if (value.m1995b() != c1470a.m1995b()) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m1998a(File file) {
        this.f2543a = new C1471b(file);
    }

    /* renamed from: a */
    public boolean m2000a() {
        C1471b c1471b = this.f2544b;
        return c1471b != null && this.f2543a != null && c1471b.m1994a().size() == this.f2543a.m1994a().size() && m1999a(this.f2543a, this.f2544b);
    }

    /* renamed from: b */
    public void m1997b(File file) {
        this.f2544b = new C1471b(file);
    }
}
