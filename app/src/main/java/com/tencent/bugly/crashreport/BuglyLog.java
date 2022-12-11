package com.tencent.bugly.crashreport;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.C1082b;
import com.tencent.bugly.proguard.C1205ba;
import org.mozilla.javascript.optimizer.OptRuntime;

/* loaded from: classes3.dex */
public class BuglyLog {
    /* renamed from: d */
    public static void m3486d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = C1082b.f703c;
        C1205ba.m3060c("D", str, str2);
    }

    /* renamed from: e */
    public static void m3485e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = C1082b.f703c;
        C1205ba.m3060c(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    /* renamed from: e */
    public static void m3484e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        boolean z = C1082b.f703c;
        C1205ba.m3064a(ExifInterface.LONGITUDE_EAST, str, th);
    }

    /* renamed from: i */
    public static void m3483i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = C1082b.f703c;
        C1205ba.m3060c(OptRuntime.GeneratorState.resumptionPoint_TYPE, str, str2);
    }

    public static void setCache(int i) {
        C1205ba.m3068a(i);
    }

    /* renamed from: v */
    public static void m3482v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = C1082b.f703c;
        C1205ba.m3060c(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2);
    }

    /* renamed from: w */
    public static void m3481w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = C1082b.f703c;
        C1205ba.m3060c(ExifInterface.LONGITUDE_WEST, str, str2);
    }
}
