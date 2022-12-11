package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes4.dex */
public class MLog {
    public static boolean DEBUG = false;
    public static final int LEVEL_DEBUG = 2;
    public static final int LEVEL_ERROR = 5;
    public static final int LEVEL_INFO = 3;
    public static final int LEVEL_VERBOSE = 1;
    public static final int LEVEL_WARN = 4;
    public static int LOG_MAXLENGTH = 2000;
    public static String TAG = "MobclickAgent";

    /* renamed from: d */
    public static void m580d(String str) {
        m579d(TAG, str, (Throwable) null);
    }

    /* renamed from: d */
    public static void m579d(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(2, str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m578d(String str, Throwable th) {
        m579d(TAG, str, th);
    }

    /* renamed from: d */
    public static void m577d(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                m579d(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m579d(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m570e(th);
        }
    }

    /* renamed from: d */
    public static void m576d(Throwable th) {
        m579d(TAG, (String) null, th);
    }

    /* renamed from: d */
    public static void m575d(Locale locale, String str, Object... objArr) {
        try {
            m579d(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m570e(th);
        }
    }

    /* renamed from: e */
    public static void m574e(String str) {
        m573e(TAG, str, (Throwable) null);
    }

    /* renamed from: e */
    public static void m573e(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(5, str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m572e(String str, Throwable th) {
        m573e(TAG, str, th);
    }

    /* renamed from: e */
    public static void m571e(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                m573e(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m573e(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m570e(th);
        }
    }

    /* renamed from: e */
    public static void m570e(Throwable th) {
        m573e(TAG, (String) null, th);
    }

    /* renamed from: e */
    public static void m569e(Locale locale, String str, Object... objArr) {
        try {
            m573e(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m570e(th);
        }
    }

    public static String getStackTrace(Throwable th) {
        PrintWriter printWriter;
        StringWriter stringWriter = null;
        try {
            StringWriter stringWriter2 = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter2);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    stringWriter2.flush();
                    String stringWriter3 = stringWriter2.toString();
                    try {
                        stringWriter2.close();
                    } catch (Throwable unused) {
                    }
                    printWriter.close();
                    return stringWriter3;
                } catch (Throwable unused2) {
                    stringWriter = stringWriter2;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    return "";
                }
            } catch (Throwable unused4) {
                printWriter = null;
            }
        } catch (Throwable unused5) {
            printWriter = null;
        }
    }

    /* renamed from: i */
    public static void m568i(String str) {
        m567i(TAG, str, (Throwable) null);
    }

    /* renamed from: i */
    public static void m567i(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(3, str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m566i(String str, Throwable th) {
        m567i(TAG, str, th);
    }

    /* renamed from: i */
    public static void m565i(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                m567i(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m567i(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m570e(th);
        }
    }

    /* renamed from: i */
    public static void m564i(Throwable th) {
        m567i(TAG, (String) null, th);
    }

    /* renamed from: i */
    public static void m563i(Locale locale, String str, Object... objArr) {
        try {
            m567i(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m570e(th);
        }
    }

    public static void print(int i, String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2)) {
            int length = str2.length();
            int i2 = LOG_MAXLENGTH;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= 100) {
                    break;
                } else if (length > i2) {
                    if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                        str2.substring(i4, i2);
                    }
                    i3++;
                    i4 = i2;
                    i2 = LOG_MAXLENGTH + i2;
                } else if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                    str2.substring(i4, length);
                }
            }
        }
        if (th != null) {
            TextUtils.isEmpty(getStackTrace(th));
        }
    }

    /* renamed from: v */
    public static void m562v(String str) {
        m561v(TAG, str, (Throwable) null);
    }

    /* renamed from: v */
    public static void m561v(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(1, str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m560v(String str, Throwable th) {
        m561v(TAG, str, th);
    }

    /* renamed from: v */
    public static void m559v(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                m561v(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m561v(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m570e(th);
        }
    }

    /* renamed from: v */
    public static void m558v(Throwable th) {
        m561v(TAG, (String) null, th);
    }

    /* renamed from: v */
    public static void m557v(Locale locale, String str, Object... objArr) {
        try {
            m561v(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m570e(th);
        }
    }

    /* renamed from: w */
    public static void m556w(String str) {
        m555w(TAG, str, (Throwable) null);
    }

    /* renamed from: w */
    public static void m555w(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(4, str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m554w(String str, Throwable th) {
        m555w(TAG, str, th);
    }

    /* renamed from: w */
    public static void m553w(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                m555w(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m555w(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m570e(th);
        }
    }

    /* renamed from: w */
    public static void m552w(Throwable th) {
        m555w(TAG, (String) null, th);
    }

    /* renamed from: w */
    public static void m551w(Locale locale, String str, Object... objArr) {
        try {
            m555w(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m570e(th);
        }
    }
}
