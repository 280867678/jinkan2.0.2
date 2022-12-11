package com.tencent.smtt.utils;

import com.tencent.smtt.sdk.stat.C1396a;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import org.mozilla.javascript.v8dtoa.FastDtoa;

/* renamed from: com.tencent.smtt.utils.h */
/* loaded from: classes4.dex */
public class C1459h {

    /* renamed from: a */
    public static final char[] f2497a = "0123456789abcdef".toCharArray();

    /* renamed from: b */
    public static C1459h f2498b;

    /* renamed from: c */
    public String f2499c;

    /* renamed from: d */
    public String f2500d;

    /* renamed from: e */
    public String f2501e;

    public C1459h() {
        int nextInt = new Random().nextInt(89999999) + FastDtoa.kTen7;
        int nextInt2 = new Random().nextInt(89999999) + FastDtoa.kTen7;
        this.f2501e = String.valueOf(nextInt);
        this.f2499c = this.f2501e + String.valueOf(nextInt2);
    }

    /* renamed from: a */
    public static synchronized C1459h m2057a() {
        C1459h c1459h;
        synchronized (C1459h.class) {
            if (f2498b == null) {
                f2498b = new C1459h();
            }
            c1459h = f2498b;
        }
        return c1459h;
    }

    /* renamed from: b */
    private String m2054b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f2497a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public byte[] m2056a(byte[] bArr) throws Exception {
        return C1396a.m2396a(this.f2501e.getBytes(), bArr, 1);
    }

    /* renamed from: b */
    public void m2055b() throws Exception {
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    }

    /* renamed from: c */
    public String m2053c() throws Exception {
        if (this.f2500d == null) {
            byte[] bytes = this.f2499c.getBytes();
            Cipher cipher = null;
            try {
                try {
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception unused) {
                m2055b();
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(android.util.Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.f2500d = m2054b(cipher.doFinal(bytes));
        }
        return this.f2500d;
    }
}
