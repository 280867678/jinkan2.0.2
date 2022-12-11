package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes4.dex */
public class ULog {
    public static boolean DEBUG = false;
    public static final int LEVEL_DEBUG = 2;
    public static final int LEVEL_ERROR = 5;
    public static final int LEVEL_INFO = 3;
    public static final int LEVEL_VERBOSE = 1;
    public static final int LEVEL_WARN = 4;
    public static int LOG_MAXLENGTH = 2000;
    public static String TAG = "ULog";

    /* renamed from: d */
    public static void m550d(String str) {
        m549d(TAG, str, (Throwable) null);
    }

    /* renamed from: d */
    public static void m549d(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(2, str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m548d(String str, Throwable th) {
        m549d(TAG, str, th);
    }

    /* renamed from: d */
    public static void m547d(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                m549d(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m549d(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m540e(th);
        }
    }

    /* renamed from: d */
    public static void m546d(Throwable th) {
        m549d(TAG, (String) null, th);
    }

    /* renamed from: d */
    public static void m545d(Locale locale, String str, Object... objArr) {
        try {
            m549d(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m540e(th);
        }
    }

    /* renamed from: e */
    public static void m544e(String str) {
        m543e(TAG, str, (Throwable) null);
    }

    /* renamed from: e */
    public static void m543e(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(5, str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m542e(String str, Throwable th) {
        m543e(TAG, str, th);
    }

    /* renamed from: e */
    public static void m541e(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                m543e(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m543e(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m540e(th);
        }
    }

    /* renamed from: e */
    public static void m540e(Throwable th) {
        m543e(TAG, (String) null, th);
    }

    /* renamed from: e */
    public static void m539e(Locale locale, String str, Object... objArr) {
        try {
            m543e(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m540e(th);
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
    public static void m538i(String str) {
        m537i(TAG, str, (Throwable) null);
    }

    /* renamed from: i */
    public static void m537i(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(3, str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m536i(String str, Throwable th) {
        m537i(TAG, str, th);
    }

    /* renamed from: i */
    public static void m535i(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                m537i(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m537i(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m540e(th);
        }
    }

    /* renamed from: i */
    public static void m534i(Throwable th) {
        m537i(TAG, (String) null, th);
    }

    /* renamed from: i */
    public static void m533i(Locale locale, String str, Object... objArr) {
        try {
            m537i(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m540e(th);
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
    public static void m532v(String str) {
        m531v(TAG, str, (Throwable) null);
    }

    /* renamed from: v */
    public static void m531v(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(1, str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m530v(String str, Throwable th) {
        m531v(TAG, str, th);
    }

    /* renamed from: v */
    public static void m529v(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                m531v(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m531v(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m540e(th);
        }
    }

    /* renamed from: v */
    public static void m528v(Throwable th) {
        m531v(TAG, (String) null, th);
    }

    /* renamed from: v */
    public static void m527v(Locale locale, String str, Object... objArr) {
        try {
            m531v(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m540e(th);
        }
    }

    /* renamed from: w */
    public static void m526w(String str) {
        m525w(TAG, str, (Throwable) null);
    }

    /* renamed from: w */
    public static void m525w(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(4, str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m524w(String str, Throwable th) {
        m525w(TAG, str, th);
    }

    /* renamed from: w */
    public static void m523w(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                m525w(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m525w(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m540e(th);
        }
    }

    /* renamed from: w */
    public static void m522w(Throwable th) {
        m525w(TAG, (String) null, th);
    }

    /* renamed from: w */
    public static void m521w(Locale locale, String str, Object... objArr) {
        try {
            m525w(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m540e(th);
        }
    }
}
