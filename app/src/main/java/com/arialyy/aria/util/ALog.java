package com.arialyy.aria.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import me.tvspark.outline;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ALog {
    public static final boolean DEBUG = true;
    public static final int LOG_CLOSE = 8;
    public static final int LOG_DEFAULT = 3;
    public static int LOG_LEVEL = 3;
    public static final int LOG_LEVEL_ASSERT = 7;
    public static final int LOG_LEVEL_DEBUG = 3;
    public static final int LOG_LEVEL_ERROR = 6;
    public static final int LOG_LEVEL_INFO = 4;
    public static final int LOG_LEVEL_VERBOSE = 2;
    public static final int LOG_LEVEL_WARN = 5;

    /* renamed from: d */
    public static int m4192d(String str, String str2) {
        return println(3, str, str2);
    }

    /* renamed from: e */
    public static int m4191e(String str, String str2) {
        return println(6, str, str2);
    }

    /* renamed from: e */
    public static void m4190e(String str, String str2, Throwable th) {
    }

    public static String getExceptionString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ExceptionDetailed:\n", "====================Exception Info====================\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.toString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\n");
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\n");
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("【Caused by】: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cause.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\n");
            for (StackTraceElement stackTraceElement2 : cause.getStackTrace()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(stackTraceElement2.toString());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\n");
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("===================================================");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    /* renamed from: i */
    public static int m4189i(String str, String str2) {
        return println(4, str, str2);
    }

    /* renamed from: j */
    public static void m4188j(String str, String str2) {
        if (LOG_LEVEL <= 3) {
            try {
                if (str2.startsWith("{")) {
                    str2 = new JSONObject(str2).toString(4);
                } else if (str2.startsWith("[")) {
                    str2 = new JSONArray(str2).toString(4);
                }
            } catch (JSONException unused) {
            }
            println(3, str, str2);
        }
    }

    /* renamed from: m */
    public static void m4187m(String str, Map map) {
        if (LOG_LEVEL <= 3) {
            Set<Map.Entry> entrySet = map.entrySet();
            if (entrySet.size() < 1) {
                m4192d(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            }
            int i = 0;
            String[] strArr = new String[entrySet.size()];
            for (Map.Entry entry : entrySet) {
                strArr[i] = entry.getKey() + " = " + entry.getValue() + ",\n";
                i++;
            }
            println(3, str, Arrays.toString(strArr));
        }
    }

    public static int println(int i, String str, String str2) {
        if (LOG_LEVEL <= i) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "null";
            }
            return Log.println(i, str, str2);
        }
        return -1;
    }

    /* renamed from: v */
    public static int m4186v(String str, String str2) {
        return println(2, str, str2);
    }

    /* renamed from: w */
    public static int m4185w(String str, String str2) {
        return println(5, str, str2);
    }
}
