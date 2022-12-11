package com.tencent.bugly.beta.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import okhttp3.internal.p054ws.WebSocketProtocol;

/* renamed from: com.tencent.bugly.beta.utils.a */
/* loaded from: classes3.dex */
public class C1119a {

    /* renamed from: a */
    public static long f888a = -1;

    /* renamed from: b */
    public static long f889b = 0;

    /* renamed from: c */
    public static long f890c = 1;

    /* renamed from: d */
    public byte[] f891d;

    /* renamed from: e */
    public byte[] f892e;

    /* renamed from: f */
    public byte[] f893f;

    /* renamed from: g */
    public long f894g;

    /* renamed from: h */
    public String f895h;

    /* renamed from: i */
    public BufferedInputStream f896i;

    /* renamed from: j */
    public long f897j;

    /* renamed from: k */
    public long f898k;

    public C1119a(String str) throws Exception {
        this.f891d = new byte[2];
        this.f892e = new byte[4];
        this.f893f = new byte[8];
        this.f894g = f890c;
        this.f895h = null;
        this.f896i = null;
        this.f897j = 0L;
        this.f898k = 0L;
        this.f895h = str;
        this.f896i = new BufferedInputStream(new FileInputStream(this.f895h));
        this.f897j = 0L;
        this.f898k = 0L;
    }

    public C1119a(String str, long j) throws Exception {
        this.f891d = new byte[2];
        this.f892e = new byte[4];
        this.f893f = new byte[8];
        this.f894g = f890c;
        this.f895h = null;
        this.f896i = null;
        this.f897j = 0L;
        this.f898k = 0L;
        this.f895h = str;
        this.f894g = j;
        this.f896i = new BufferedInputStream(new FileInputStream(this.f895h));
        this.f897j = 0L;
        this.f898k = 0L;
    }

    /* renamed from: a */
    public static int m3564a(byte[] bArr, long j) {
        return j == f890c ? m3558c(bArr) : m3561b(bArr);
    }

    /* renamed from: b */
    public static int m3561b(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) m3555d(bArr);
    }

    /* renamed from: b */
    public static long m3560b(byte[] bArr, long j) {
        return j == f890c ? m3553e(bArr) : m3555d(bArr);
    }

    /* renamed from: c */
    public static int m3558c(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) m3553e(bArr);
    }

    /* renamed from: c */
    public static short m3557c(byte[] bArr, long j) {
        return j == f890c ? m3549g(bArr) : m3551f(bArr);
    }

    /* renamed from: d */
    public static long m3555d(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j = 0;
        for (byte b : bArr) {
            j = (j << 8) | (b & 255);
        }
        return j;
    }

    /* renamed from: e */
    public static long m3553e(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            j = (j << 8) | (bArr[length] & 255);
        }
        return j;
    }

    /* renamed from: f */
    public static short m3551f(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return (short) -1;
        }
        return (short) m3561b(bArr);
    }

    /* renamed from: g */
    public static short m3549g(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return (short) -1;
        }
        return (short) m3558c(bArr);
    }

    /* renamed from: a */
    public synchronized void m3566a(long j) {
        this.f894g = j;
    }

    /* renamed from: a */
    public synchronized boolean m3567a() {
        boolean z;
        try {
            if (this.f896i != null) {
                this.f896i.close();
            }
            this.f896i = null;
            this.f895h = null;
            this.f897j = 0L;
            this.f898k = 0L;
            z = true;
        } catch (IOException e) {
            e.getMessage();
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public synchronized boolean m3565a(byte[] bArr) {
        boolean z;
        try {
            this.f896i.read(bArr);
            this.f897j += bArr.length;
            this.f898k += bArr.length;
            z = true;
        } catch (IOException e) {
            e.getMessage();
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public synchronized byte m3563b() throws IOException {
        BufferedInputStream bufferedInputStream = this.f896i;
        if (bufferedInputStream == null) {
            return (byte) 0;
        }
        byte read = (byte) bufferedInputStream.read();
        this.f897j++;
        this.f898k++;
        return read;
    }

    /* renamed from: b */
    public synchronized boolean m3562b(long j) {
        if (this.f896i == null) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        long j2 = j;
        while (j2 > 0) {
            try {
                j2 -= this.f896i.skip(j2);
            } catch (IOException unused) {
                return false;
            }
        }
        this.f897j += j;
        return true;
    }

    /* renamed from: c */
    public synchronized int m3559c() throws IOException {
        BufferedInputStream bufferedInputStream = this.f896i;
        if (bufferedInputStream == null) {
            return 0;
        }
        bufferedInputStream.read(this.f892e);
        int m3564a = m3564a(this.f892e, this.f894g);
        this.f897j += 4;
        this.f898k += 4;
        return m3564a;
    }

    /* renamed from: d */
    public synchronized long m3556d() throws IOException {
        BufferedInputStream bufferedInputStream = this.f896i;
        if (bufferedInputStream == null) {
            return 0L;
        }
        bufferedInputStream.read(this.f893f);
        long m3560b = m3560b(this.f893f, this.f894g);
        this.f897j += 8;
        this.f898k += 8;
        return m3560b;
    }

    /* renamed from: e */
    public synchronized short m3554e() throws IOException {
        BufferedInputStream bufferedInputStream = this.f896i;
        if (bufferedInputStream == null) {
            return (short) 0;
        }
        bufferedInputStream.read(this.f891d);
        short m3557c = m3557c(this.f891d, this.f894g);
        this.f897j += 2;
        this.f898k += 2;
        return m3557c;
    }

    /* renamed from: f */
    public synchronized long m3552f() throws IOException {
        return m3563b() & 255;
    }

    /* renamed from: g */
    public synchronized long m3550g() throws IOException {
        return m3559c() & 4294967295L;
    }

    /* renamed from: h */
    public synchronized long m3548h() throws IOException {
        return m3556d();
    }

    /* renamed from: i */
    public synchronized long m3547i() throws IOException {
        return m3554e() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }
}
