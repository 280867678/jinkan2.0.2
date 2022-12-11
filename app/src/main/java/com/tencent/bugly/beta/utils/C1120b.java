package com.tencent.bugly.beta.utils;

import java.io.IOException;
import java.util.HashMap;

/* renamed from: com.tencent.bugly.beta.utils.b */
/* loaded from: classes3.dex */
public class C1120b {

    /* renamed from: a */
    public String f899a;

    /* renamed from: c */
    public long f901c;

    /* renamed from: d */
    public long f902d;

    /* renamed from: f */
    public final HashMap<Long, String> f904f;

    /* renamed from: b */
    public C1119a f900b = null;

    /* renamed from: e */
    public String f903e = null;

    public C1120b(String str, long j, long j2) {
        this.f899a = null;
        this.f901c = 0L;
        this.f902d = 0L;
        HashMap<Long, String> hashMap = new HashMap<>();
        this.f904f = hashMap;
        hashMap.put(1L, "armeabi-v4");
        this.f904f.put(2L, "armeabi-v4t");
        this.f904f.put(3L, "armeabi-v5t");
        this.f904f.put(4L, "armeabi-v5te");
        this.f904f.put(5L, "armeabi-v5tej");
        this.f904f.put(6L, "armeabi-v6");
        this.f904f.put(7L, "armeabi-v6kz");
        this.f904f.put(8L, "armeabi-v6t2");
        this.f904f.put(9L, "armeabi-v6k");
        this.f904f.put(10L, "armeabi-v7a");
        this.f904f.put(11L, "armeabi-v6-m");
        this.f904f.put(12L, "armeabi-v6s-m");
        this.f904f.put(13L, "armeabi-v7e-m");
        this.f904f.put(14L, "armeabi-v8a");
        this.f899a = str;
        this.f901c = j;
        this.f902d = j2;
    }

    /* renamed from: a */
    public static synchronized long m3544a(C1119a c1119a) throws IOException {
        long j;
        byte m3563b;
        synchronized (C1120b.class) {
            long j2 = 0;
            j = 0;
            do {
                m3563b = c1119a.m3563b();
                j |= (m3563b & 127) << ((int) j2);
                j2 += 7;
            } while ((m3563b & 128) != 0);
        }
        return j;
    }

    /* renamed from: a */
    public static String m3543a(String str, long j, long j2) {
        C1120b c1120b = new C1120b(str, j, j2);
        if (!c1120b.m3540d()) {
            return null;
        }
        return c1120b.f903e;
    }

    /* renamed from: a */
    private boolean m3546a() {
        return 0 != this.f902d;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0001 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean m3545a(long j) {
        String m3538f;
        while (j > 0) {
            try {
                int m3544a = (int) m3544a(this.f900b);
                if (m3544a != 34 && m3544a != 36 && m3544a != 38 && m3544a != 42 && m3544a != 44 && m3544a != 70) {
                    switch (m3544a) {
                        case 4:
                        case 5:
                        case 32:
                            m3538f = m3538f();
                            if (m3538f != null) {
                                break;
                            } else {
                                j -= m3538f.length();
                                break;
                            }
                        case 6:
                            this.f903e = this.f904f.get(Long.valueOf(m3544a(this.f900b)));
                            return true;
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                            break;
                        default:
                            switch (m3544a) {
                                case 64:
                                case 66:
                                case 68:
                                    break;
                                case 65:
                                case 67:
                                    m3538f = m3538f();
                                    if (m3538f != null) {
                                    }
                                    break;
                                default:
                                    return false;
                            }
                    }
                }
                m3544a(this.f900b);
            } catch (IOException e) {
                e.getMessage();
                return false;
            }
        }
        return false;
    }

    /* renamed from: b */
    private synchronized void m3542b() {
        C1119a c1119a = this.f900b;
        if (c1119a == null) {
            return;
        }
        if (!c1119a.m3567a()) {
            return;
        }
        this.f900b = null;
    }

    /* renamed from: c */
    private synchronized boolean m3541c() {
        if (!m3546a()) {
            return false;
        }
        if (this.f900b != null) {
            m3542b();
        }
        try {
            C1119a c1119a = new C1119a(this.f899a, this.f901c);
            this.f900b = c1119a;
            return c1119a.m3562b(this.f902d);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: d */
    private boolean m3540d() {
        if (!m3541c()) {
            m3542b();
            return false;
        }
        m3539e();
        m3542b();
        return true;
    }

    /* renamed from: e */
    private synchronized boolean m3539e() {
        try {
            if (65 != this.f900b.m3552f()) {
                return false;
            }
            long m3550g = this.f900b.m3550g();
            String m3537g = m3537g();
            if (m3537g != null && m3537g.equals("aeabi")) {
                long length = m3550g - m3537g.length();
                while (length > 0) {
                    long m3552f = this.f900b.m3552f();
                    long m3550g2 = this.f900b.m3550g() - 5;
                    if (1 == m3552f) {
                        return m3545a(m3550g2);
                    }
                    this.f900b.m3562b(m3550g2);
                }
                return true;
            }
            return false;
        } catch (IOException e) {
            e.getMessage();
            return false;
        }
    }

    /* renamed from: f */
    private synchronized String m3538f() {
        StringBuilder sb;
        sb = new StringBuilder();
        while (true) {
            try {
                char m3563b = (char) this.f900b.m3563b();
                if (m3563b != 0) {
                    sb.append(m3563b);
                }
            } catch (IOException e) {
                e.getMessage();
                return null;
            }
        }
        return sb.toString();
    }

    /* renamed from: g */
    private String m3537g() {
        return m3538f();
    }
}
