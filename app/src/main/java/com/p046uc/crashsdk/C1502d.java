package com.p046uc.crashsdk;

import android.os.Bundle;
import android.webkit.ValueCallback;
import androidx.core.app.Person;
import com.p046uc.crashsdk.export.ICrashClient;
import com.p046uc.crashsdk.p047a.C1491a;
import com.p046uc.crashsdk.p047a.C1497g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.uc.crashsdk.d */
/* loaded from: classes4.dex */
public final class C1502d {

    /* renamed from: a */
    public static ICrashClient f2739a = null;

    /* renamed from: b */
    public static int f2740b = 3;

    /* renamed from: c */
    public static volatile List<ValueCallback<Bundle>> f2741c;

    /* renamed from: d */
    public static volatile List<ValueCallback<Bundle>> f2742d;

    /* renamed from: e */
    public static volatile List<ValueCallback<Bundle>> f2743e;

    /* renamed from: f */
    public static volatile List<ValueCallback<Bundle>> f2744f;

    /* renamed from: g */
    public static final Object f2745g = new Object();

    /* renamed from: a */
    public static File m1719a(File file) {
        ICrashClient iCrashClient = f2739a;
        if (iCrashClient != null) {
            try {
                return iCrashClient.onBeforeUploadLog(file);
            } catch (Throwable th) {
                C1497g.m1868a(th);
            }
        }
        return file;
    }

    /* renamed from: a */
    public static String m1716a(String str, boolean z) {
        ICrashClient iCrashClient = f2739a;
        return iCrashClient != null ? iCrashClient.onGetCallbackInfo(str, z) : "";
    }

    /* renamed from: a */
    public static void m1720a(ICrashClient iCrashClient) {
        f2739a = iCrashClient;
    }

    /* renamed from: a */
    public static void m1718a(String str, int i, int i2) {
        ICrashClient iCrashClient = f2739a;
        if (iCrashClient != null) {
            iCrashClient.onAddCrashStats(str, i, i2);
        }
        if (f2744f != null) {
            synchronized (f2744f) {
                for (ValueCallback<Bundle> valueCallback : f2744f) {
                    Bundle bundle = new Bundle();
                    bundle.putString("processName", str);
                    bundle.putInt(Person.KEY_KEY, i);
                    bundle.putInt("count", i2);
                    valueCallback.onReceiveValue(bundle);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m1717a(String str, String str2, String str3) {
        if (C1497g.m1872a(str)) {
            C1491a.m1924a("crashsdk", "onLogGenerated file name is null!", null);
            return;
        }
        boolean equals = C1503e.m1610h().equals(str2);
        if (f2739a != null) {
            File file = new File(str);
            try {
                if (equals) {
                    f2739a.onLogGenerated(file, str3);
                } else {
                    f2739a.onClientProcessLogGenerated(str2, file, str3);
                }
            } catch (Throwable th) {
                C1497g.m1868a(th);
            }
        }
        List<ValueCallback<Bundle>> list = f2741c;
        if (!equals) {
            list = f2742d;
        }
        if (list == null) {
            return;
        }
        synchronized (list) {
            for (ValueCallback<Bundle> valueCallback : list) {
                Bundle bundle = new Bundle();
                bundle.putString("filePathName", str);
                if (!equals) {
                    bundle.putString("processName", str2);
                }
                bundle.putString("logType", str3);
                valueCallback.onReceiveValue(bundle);
            }
        }
    }

    /* renamed from: a */
    public static void m1715a(boolean z) {
        ICrashClient iCrashClient = f2739a;
        if (iCrashClient != null) {
            try {
                iCrashClient.onCrashRestarting(z);
            } catch (Throwable th) {
                C1497g.m1868a(th);
            }
        }
        if (f2743e != null) {
            synchronized (f2743e) {
                for (ValueCallback<Bundle> valueCallback : f2743e) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isJava", z);
                    valueCallback.onReceiveValue(bundle);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m1721a(ValueCallback<Bundle> valueCallback) {
        if (f2741c == null) {
            synchronized (f2745g) {
                if (f2741c == null) {
                    f2741c = new ArrayList();
                }
            }
        }
        synchronized (f2741c) {
            if (f2741c.size() >= f2740b) {
                return false;
            }
            f2741c.add(valueCallback);
            return true;
        }
    }

    /* renamed from: b */
    public static boolean m1714b(ValueCallback<Bundle> valueCallback) {
        if (f2742d == null) {
            synchronized (f2745g) {
                if (f2742d == null) {
                    f2742d = new ArrayList();
                }
            }
        }
        synchronized (f2742d) {
            if (f2742d.size() >= f2740b) {
                return false;
            }
            f2742d.add(valueCallback);
            return true;
        }
    }

    /* renamed from: c */
    public static boolean m1713c(ValueCallback<Bundle> valueCallback) {
        if (f2743e == null) {
            synchronized (f2745g) {
                if (f2743e == null) {
                    f2743e = new ArrayList();
                }
            }
        }
        synchronized (f2743e) {
            if (f2743e.size() >= f2740b) {
                return false;
            }
            f2743e.add(valueCallback);
            return true;
        }
    }

    /* renamed from: d */
    public static boolean m1712d(ValueCallback<Bundle> valueCallback) {
        if (f2744f == null) {
            synchronized (f2745g) {
                if (f2744f == null) {
                    f2744f = new ArrayList();
                }
            }
        }
        synchronized (f2744f) {
            if (f2744f.size() >= f2740b) {
                return false;
            }
            f2744f.add(valueCallback);
            return true;
        }
    }
}
