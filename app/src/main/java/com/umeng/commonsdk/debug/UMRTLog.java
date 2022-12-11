package com.umeng.commonsdk.debug;

import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes4.dex */
public class UMRTLog {
    public static final String RTLOG_ENABLE = "1";
    public static final String RTLOG_PROP = "debug.umeng.rtlog";
    public static final String RTLOG_TAG = "MobclickRT";

    /* renamed from: d */
    public static void m768d(String str, String str2) {
        if (shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    /* renamed from: e */
    public static void m767e(String str, String str2) {
        if (shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    /* renamed from: i */
    public static void m766i(String str, String str2) {
        if (shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    /* renamed from: sd */
    public static void m765sd(String str, String str2) {
        if (shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    /* renamed from: se */
    public static void m764se(String str, String str2) {
        if (shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    public static boolean shouldOutput() {
        return "1".equals(UMUtils.getSystemProperty(RTLOG_PROP, "0"));
    }

    /* renamed from: si */
    public static void m763si(String str, String str2) {
        if (shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    /* renamed from: sv */
    public static void m762sv(String str, String str2) {
        if (shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    /* renamed from: sw */
    public static void m761sw(String str, String str2) {
        if (shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    /* renamed from: v */
    public static void m760v(String str, String str2) {
        if (shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    /* renamed from: w */
    public static void m759w(String str, String str2) {
        if (shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    public static String warpperMsg(String str, boolean z) {
        if (!z) {
            return str;
        }
        StringBuffer stringBuffer = null;
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length >= 3) {
                String fileName = stackTrace[2].getFileName();
                String methodName = stackTrace[2].getMethodName();
                int lineNumber = stackTrace[2].getLineNumber();
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("<");
                stringBuffer2.append(fileName);
                stringBuffer2.append(":");
                stringBuffer2.append(methodName);
                stringBuffer2.append(":");
                stringBuffer2.append(lineNumber);
                stringBuffer2.append("> ");
                stringBuffer2.append(str);
                stringBuffer = stringBuffer2;
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
