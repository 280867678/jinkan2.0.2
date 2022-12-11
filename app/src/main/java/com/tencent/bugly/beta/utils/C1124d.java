package com.tencent.bugly.beta.utils;

/* renamed from: com.tencent.bugly.beta.utils.d */
/* loaded from: classes3.dex */
public class C1124d {

    /* renamed from: a */
    public String f941a;

    /* renamed from: b */
    public long f942b;

    /* renamed from: c */
    public long f943c;

    /* renamed from: d */
    public C1119a f944d = null;

    public C1124d(String str, long j, long j2) {
        this.f941a = null;
        this.f942b = 0L;
        this.f943c = 0L;
        this.f941a = str;
        this.f942b = j;
        this.f943c = j2;
    }

    /* renamed from: b */
    private synchronized String m3493b(long j) {
        if (this.f944d == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            this.f944d.m3562b(this.f942b);
            this.f944d.m3562b(j);
            while (true) {
                byte m3563b = this.f944d.m3563b();
                if (m3563b == 0) {
                    break;
                }
                stringBuffer.append((char) m3563b);
            }
            this.f944d.m3567a();
            this.f944d = new C1119a(this.f941a);
        } catch (Exception e) {
            this.f944d = null;
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private boolean m3494b() {
        return (this.f942b == 0 || this.f943c == 0) ? false : true;
    }

    /* renamed from: c */
    private synchronized boolean m3492c() {
        if (!m3494b()) {
            return false;
        }
        if (this.f944d == null) {
            try {
                this.f944d = new C1119a(this.f941a);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public synchronized String m3495a(long j) {
        if (j >= 0) {
            if (j < this.f943c) {
                if (this.f944d == null && !m3492c()) {
                    return null;
                }
                return m3493b(j);
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized void m3496a() {
        C1119a c1119a = this.f944d;
        if (c1119a == null) {
            return;
        }
        c1119a.m3567a();
        this.f944d = null;
    }
}
