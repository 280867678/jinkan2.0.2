package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.stub.StubApp;
import com.tencent.smtt.sdk.C1356c;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import me.tvspark.outline;

/* renamed from: com.tencent.smtt.utils.j */
/* loaded from: classes4.dex */
public class C1461j {

    /* renamed from: a */
    public static SharedPreferences f2502a;

    /* renamed from: b */
    public static SharedPreferences.Editor f2503b;

    /* renamed from: a */
    public static String m2047a() {
        try {
            String str = Build.SERIAL;
            if (!TextUtils.isEmpty(str) && !str.contains("unknown")) {
                return str;
            }
            return m2042b();
        } catch (Exception unused) {
            return "unknown";
        }
    }

    /* renamed from: a */
    public static String m2046a(Context context) {
        if (!m2040c(context)) {
            return "";
        }
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("tsui", 0);
        f2502a = sharedPreferences;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("tsui", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        StringBuilder sb = new StringBuilder();
        String m2042b = m2042b();
        String m2110k = C1429b.m2110k(context);
        String m2047a = m2047a();
        String replace = m2041b(context).replace("-", "");
        if (m2042b != null && m2042b.length() > 0) {
            sb.append(m2042b);
            sb.append("|");
        }
        if (m2110k != null && m2110k.length() > 0) {
            sb.append(m2110k);
            sb.append("|");
        }
        if (m2047a != null && m2047a.length() > 0) {
            sb.append(m2047a);
            sb.append("|");
        }
        if (replace != null && replace.length() > 0) {
            sb.append(replace);
        }
        if (sb.length() > 0) {
            try {
                String m2043a = m2043a(m2044a(sb.toString()));
                if (m2043a != null && m2043a.length() > 0) {
                    m2045a(context, "tsui", m2043a);
                    return m2043a;
                }
            } catch (Exception unused) {
            }
        }
        String replace2 = UUID.randomUUID().toString().replace("-", "");
        m2045a(context, "tsui", replace2);
        return replace2;
    }

    /* renamed from: a */
    public static String m2043a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase(Locale.CHINA);
    }

    /* renamed from: a */
    public static void m2045a(Context context, String str, String str2) {
        if (f2502a == null) {
            f2502a = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("tsui", 0);
        }
        SharedPreferences.Editor edit = f2502a.edit();
        f2503b = edit;
        edit.putString(str, str2);
        f2503b.commit();
    }

    /* renamed from: a */
    public static byte[] m2044a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            return messageDigest.digest();
        } catch (Exception unused) {
            return "".getBytes();
        }
    }

    /* renamed from: b */
    public static String m2042b() {
        int nextInt = new Random().nextInt(2147483646);
        return Build.FINGERPRINT + nextInt;
    }

    /* renamed from: b */
    public static String m2041b(Context context) {
        try {
            String m1976d = C1472q.m1976d(context);
            int nextInt = new Random().nextInt(2147483646);
            return new UUID(("" + nextInt + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.DEVICE.length() % 10) + (Build.HARDWARE.length() % 10) + (Build.ID.length() % 10) + (m1976d.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.SERIAL.length() % 10)).hashCode(), Build.SERIAL.hashCode()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: c */
    public static boolean m2040c(final Context context) {
        boolean z = true;
        try {
            z = context.getSharedPreferences("sai", 0).getBoolean("sui", true);
            TbsLog.m2155i("SDKUID", "isSDKUIDEnable is " + z);
            C1356c.m2620a().m2617a(context, (Integer) 1002, new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.j.1
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = context.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("sui", false);
                    edit.commit();
                    TbsLog.m2158e("TBSEmergency", "Execute command [1002](" + str + ")");
                }
            });
            return z;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "SDKUID");
            return z;
        }
    }
}
