package com.tencent.bugly.beta.tinker;

import android.util.Log;
import com.tencent.tinker.lib.util.TinkerLog;

/* loaded from: classes3.dex */
public class TinkerLogger implements TinkerLog.TinkerLogImp {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 5;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    public static final String TAG = "Tinker.TinkerLogger";
    public static int level;

    public static int getLogLevel() {
        return level;
    }

    public static void setLevel(int i) {
        level = i;
    }

    /* renamed from: d */
    public void m3602d(String str, String str2, Object... objArr) {
        if (level > 1 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }

    /* renamed from: e */
    public void m3601e(String str, String str2, Object... objArr) {
        if (level > 4 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }

    /* renamed from: i */
    public void m3600i(String str, String str2, Object... objArr) {
        if (level > 2 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }

    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (objArr != null) {
            String.format(str2, objArr);
        }
        Log.getStackTraceString(th);
    }

    /* renamed from: v */
    public void m3599v(String str, String str2, Object... objArr) {
        if (level > 0 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }

    /* renamed from: w */
    public void m3598w(String str, String str2, Object... objArr) {
        if (level > 3 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }
}
