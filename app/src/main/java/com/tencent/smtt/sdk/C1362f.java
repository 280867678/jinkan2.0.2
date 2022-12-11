package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.C1435c;
import java.io.IOException;
import java.util.UnknownFormatConversionException;

/* renamed from: com.tencent.smtt.sdk.f */
/* loaded from: classes4.dex */
public class C1362f {

    /* renamed from: a */
    public static int f2108a = 5;

    /* renamed from: b */
    public static int f2109b = 16;

    /* renamed from: c */
    public static char[] f2110c = new char[16];

    /* renamed from: d */
    public static String f2111d = "dex2oat-cmdline";

    /* renamed from: e */
    public static long f2112e = 4096;

    /* renamed from: a */
    public static String m2604a(Context context, String str) throws Exception {
        C1435c c1435c = new C1435c(str);
        c1435c.m2101a(f2110c);
        boolean z = true;
        if (f2110c[f2108a] != 1) {
            z = false;
        }
        c1435c.m2103a(z);
        c1435c.m2104a(f2112e);
        return m2602a(new String(m2603a(c1435c)));
    }

    /* renamed from: a */
    public static String m2602a(String str) {
        String[] split = str.split(new String("\u0000"));
        int i = 0;
        while (i < split.length) {
            int i2 = i + 1;
            String str2 = split[i];
            int i3 = i2 + 1;
            String str3 = split[i2];
            if (str2.equals(f2111d)) {
                return str3;
            }
            i = i3;
        }
        return "";
    }

    /* renamed from: a */
    public static char[] m2603a(C1435c c1435c) throws IOException {
        char[] cArr = new char[4];
        char[] cArr2 = new char[4];
        c1435c.m2101a(cArr);
        if (cArr[0] == 'o' && cArr[1] == 'a' && cArr[2] == 't') {
            c1435c.m2101a(cArr2);
            c1435c.m2100b();
            c1435c.m2100b();
            c1435c.m2100b();
            c1435c.m2100b();
            c1435c.m2100b();
            c1435c.m2100b();
            c1435c.m2100b();
            c1435c.m2100b();
            if (cArr2[1] <= '4') {
                c1435c.m2100b();
                c1435c.m2100b();
                c1435c.m2100b();
            }
            c1435c.m2100b();
            c1435c.m2100b();
            c1435c.m2100b();
            c1435c.m2100b();
            c1435c.m2100b();
            c1435c.m2100b();
            c1435c.m2100b();
            char[] cArr3 = new char[c1435c.m2100b()];
            c1435c.m2101a(cArr3);
            return cArr3;
        }
        throw new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", Character.valueOf(cArr[0]), Character.valueOf(cArr[1]), Character.valueOf(cArr[2])));
    }
}
