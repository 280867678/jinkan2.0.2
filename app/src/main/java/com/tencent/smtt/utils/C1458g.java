package com.tencent.smtt.utils;

import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import me.tvspark.outline;
import org.mozilla.javascript.v8dtoa.FastDtoa;

/* renamed from: com.tencent.smtt.utils.g */
/* loaded from: classes4.dex */
public class C1458g {

    /* renamed from: b */
    public static String f2491b = "";

    /* renamed from: c */
    public static byte[] f2492c;

    /* renamed from: g */
    public static String f2494g;

    /* renamed from: d */
    public Cipher f2495d;

    /* renamed from: e */
    public Cipher f2496e;

    /* renamed from: a */
    public static final char[] f2490a = "0123456789abcdef".toCharArray();

    /* renamed from: f */
    public static C1458g f2493f = null;

    public C1458g() throws Exception {
        this.f2495d = null;
        this.f2496e = null;
        f2494g = String.valueOf(new Random().nextInt(89999999) + FastDtoa.kTen7) + String.valueOf(new Random().nextInt(89999999) + FastDtoa.kTen7) + String.valueOf(new Random().nextInt(89999999) + FastDtoa.kTen7);
        String str = "00000000";
        int i = 0;
        while (true) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            if (i >= 12) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f2494g);
                f2492c = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().getBytes();
                this.f2495d = Cipher.getInstance("RSA/ECB/NoPadding");
                this.f2495d.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(android.util.Base64.decode((m2059d() + m2058e()).getBytes(), 0))));
                f2491b = m2063b(this.f2495d.doFinal(f2492c));
                SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f2494g.getBytes()));
                Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
                this.f2496e = cipher;
                cipher.init(1, generateSecret);
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(String.valueOf(new Random().nextInt(89999999) + FastDtoa.kTen7));
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            i++;
        }
    }

    /* renamed from: a */
    public static C1458g m2067a() {
        try {
            if (f2493f == null) {
                f2493f = new C1458g();
            }
            return f2493f;
        } catch (Exception e) {
            f2493f = null;
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m2065a(byte[] bArr, String str) throws Exception {
        SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(1, generateSecret);
        return cipher.doFinal(bArr);
    }

    /* renamed from: b */
    public static String m2063b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f2490a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: b */
    public static byte[] m2062b(byte[] bArr, String str) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, generateSecret);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static String m2061c() {
        return f2494g;
    }

    /* renamed from: d */
    private String m2059d() {
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0";
    }

    /* renamed from: e */
    private String m2058e() {
        return "fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB";
    }

    /* renamed from: a */
    public byte[] m2066a(byte[] bArr) throws Exception {
        return this.f2496e.doFinal(bArr);
    }

    /* renamed from: b */
    public String m2064b() {
        return f2491b;
    }

    /* renamed from: c */
    public byte[] m2060c(byte[] bArr) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f2494g.getBytes()));
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, generateSecret);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            TbsLog.m2152i(e);
            return null;
        }
    }
}
