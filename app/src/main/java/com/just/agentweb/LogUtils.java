package com.just.agentweb;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class LogUtils {
    public static final String PREFIX = "agentweb-";

    /* renamed from: e */
    public static void m3703e(String str, String str2) {
        if (isDebug()) {
            PREFIX.concat(str);
        }
    }

    /* renamed from: e */
    public static void m3702e(String str, String str2, Throwable th) {
    }

    /* renamed from: i */
    public static void m3701i(String str, String str2) {
        if (isDebug()) {
            PREFIX.concat(str);
        }
    }

    public static boolean isDebug() {
        return AgentWebConfig.DEBUG;
    }

    public static void safeCheckCrash(String str, String str2, Throwable th) {
        if (!isDebug()) {
            PREFIX.concat(str);
            return;
        }
        throw new RuntimeException(PREFIX.concat(str) + StringUtils.SPACE + str2, th);
    }

    /* renamed from: v */
    public static void m3700v(String str, String str2) {
        if (isDebug()) {
            PREFIX.concat(str);
        }
    }
}
