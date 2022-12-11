package org.litepal.util;

/* loaded from: classes5.dex */
public final class LitePalLog {
    public static final int DEBUG = 2;
    public static final int ERROR = 5;
    public static int level = 5;

    /* renamed from: d */
    public static void m30d(String str, String str2) {
        int i = level;
    }

    /* renamed from: e */
    public static void m29e(String str, Exception exc) {
        if (level <= 5) {
            exc.getMessage();
        }
    }
}
