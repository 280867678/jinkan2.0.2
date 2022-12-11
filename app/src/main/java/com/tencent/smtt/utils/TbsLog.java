package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import com.stub.StubApp;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class TbsLog {
    public static final int TBSLOG_CODE_SDK_BASE = 1000;
    public static final int TBSLOG_CODE_SDK_CONFLICT_X5CORE = 993;
    public static final int TBSLOG_CODE_SDK_INIT = 999;
    public static final int TBSLOG_CODE_SDK_INVOKE_ERROR = 997;
    public static final int TBSLOG_CODE_SDK_LOAD_ERROR = 998;
    public static final int TBSLOG_CODE_SDK_NO_SHARE_X5CORE = 994;
    public static final int TBSLOG_CODE_SDK_SELF_MODE = 996;
    public static final int TBSLOG_CODE_SDK_THIRD_MODE = 995;
    public static final int TBSLOG_CODE_SDK_UNAVAIL_X5CORE = 992;
    public static final String X5LOGTAG = "x5logtag";

    /* renamed from: a */
    public static boolean f2375a = false;

    /* renamed from: b */
    public static boolean f2376b = true;

    /* renamed from: c */
    public static TbsLogClient f2377c;
    public static List<String> sTbsLogList = new LinkedList();
    public static int sLogMaxCount = 10;

    public static void addLog(int i, String str, Object... objArr) {
        synchronized (sTbsLogList) {
            try {
                if (sTbsLogList.size() > sLogMaxCount) {
                    int size = sTbsLogList.size() - sLogMaxCount;
                    while (true) {
                        int i2 = size - 1;
                        if (size <= 0 || sTbsLogList.size() <= 0) {
                            break;
                        }
                        sTbsLogList.remove(0);
                        size = i2;
                    }
                }
                String str2 = null;
                if (str != null) {
                    try {
                        str2 = String.format(str, objArr);
                    } catch (Exception unused) {
                    }
                }
                if (str2 == null) {
                    str2 = "";
                }
                sTbsLogList.add(String.format("[%d][%d][%c][%d]%s", Long.valueOf(System.currentTimeMillis()), 1, '0', Integer.valueOf(i), str2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void app_extra(String str, Context context) {
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            String[] strArr = {TbsConfig.APP_DEMO, TbsConfig.APP_QB, TbsConfig.APP_WX, TbsConfig.APP_QQ, TbsConfig.APP_DEMO_TEST, TbsConfig.APP_QZONE};
            String[] strArr2 = {"DEMO", "QB", "WX", "QQ", "TEST", "QZ"};
            int i = 0;
            while (true) {
                if (i >= 6) {
                    break;
                } else if (origApplicationContext.getPackageName().contains(strArr[i])) {
                    m2155i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:" + strArr2[i] + "!");
                    break;
                } else {
                    i++;
                }
            }
            if (i != 6) {
                return;
            }
            m2155i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:OTHER!");
        } catch (Throwable th) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("app_extra exception:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(th));
            m2148w(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    /* renamed from: d */
    public static void m2161d(String str, String str2) {
        m2160d(str, "", str2);
    }

    /* renamed from: d */
    public static void m2160d(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f2377c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.m2144d(str, "TBS:" + str2 + StringUtils.SPACE + str3);
    }

    /* renamed from: d */
    public static void m2159d(String str, String str2, boolean z) {
        m2161d(str, str2);
        TbsLogClient tbsLogClient = f2377c;
        if (tbsLogClient == null || !f2375a || !z) {
            return;
        }
        tbsLogClient.showLog(str + ": " + str2);
    }

    /* renamed from: e */
    public static void m2158e(String str, String str2) {
        m2157e(str, "", str2);
    }

    /* renamed from: e */
    public static void m2157e(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f2377c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.m2143e(str, "TBS:" + str2 + StringUtils.SPACE + str3);
        TbsLogClient tbsLogClient2 = f2377c;
        tbsLogClient2.writeLog("(E)-" + str + "-TBS:" + str2 + StringUtils.SPACE + str3);
    }

    /* renamed from: e */
    public static void m2156e(String str, String str2, boolean z) {
        m2158e(str, str2);
        TbsLogClient tbsLogClient = f2377c;
        if (tbsLogClient == null || !f2375a || !z) {
            return;
        }
        tbsLogClient.showLog(str + ": " + str2);
    }

    public static String getTbsLogFilePath() {
        File file = TbsLogClient.f2379c;
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* renamed from: i */
    public static void m2155i(String str, String str2) {
        m2154i(str, "", str2);
    }

    /* renamed from: i */
    public static void m2154i(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f2377c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.m2142i(str, "TBS:" + str2 + StringUtils.SPACE + str3);
        TbsLogClient tbsLogClient2 = f2377c;
        tbsLogClient2.writeLog("(I)-" + str + "-TBS:" + str2 + StringUtils.SPACE + str3);
    }

    /* renamed from: i */
    public static void m2153i(String str, String str2, boolean z) {
        m2155i(str, str2);
        TbsLogClient tbsLogClient = f2377c;
        if (tbsLogClient == null || !f2375a || !z) {
            return;
        }
        tbsLogClient.showLog(str + ": " + str2);
    }

    /* renamed from: i */
    public static void m2152i(Throwable th) {
        m2155i("handle_throwable", Log.getStackTraceString(th));
    }

    public static synchronized void initIfNeed(Context context) {
        synchronized (TbsLog.class) {
            if (f2377c == null) {
                setTbsLogClient(new TbsLogClient(context));
            }
        }
    }

    public static void setLogView(TextView textView) {
        TbsLogClient tbsLogClient;
        if (textView == null || (tbsLogClient = f2377c) == null) {
            return;
        }
        tbsLogClient.setLogView(textView);
    }

    public static boolean setTbsLogClient(TbsLogClient tbsLogClient) {
        if (tbsLogClient == null) {
            return false;
        }
        f2377c = tbsLogClient;
        TbsLogClient.setWriteLogJIT(f2376b);
        return true;
    }

    public static void setWriteLogJIT(boolean z) {
        f2376b = z;
        if (f2377c == null) {
            return;
        }
        TbsLogClient.setWriteLogJIT(z);
    }

    /* renamed from: v */
    public static void m2151v(String str, String str2) {
        m2150v(str, "", str2);
    }

    /* renamed from: v */
    public static void m2150v(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f2377c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.m2141v(str, "TBS:" + str2 + StringUtils.SPACE + str3);
    }

    /* renamed from: v */
    public static void m2149v(String str, String str2, boolean z) {
        m2151v(str, str2);
        TbsLogClient tbsLogClient = f2377c;
        if (tbsLogClient == null || !f2375a || !z) {
            return;
        }
        tbsLogClient.showLog(str + ": " + str2);
    }

    /* renamed from: w */
    public static void m2148w(String str, String str2) {
        m2147w(str, "", str2);
    }

    /* renamed from: w */
    public static void m2147w(String str, String str2, String str3) {
        TbsLogClient tbsLogClient = f2377c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.m2140w(str, "TBS:" + str2 + StringUtils.SPACE + str3);
        TbsLogClient tbsLogClient2 = f2377c;
        tbsLogClient2.writeLog("(W)-" + str + "-TBS:" + str2 + StringUtils.SPACE + str3);
    }

    /* renamed from: w */
    public static void m2146w(String str, String str2, boolean z) {
        m2148w(str, str2);
        TbsLogClient tbsLogClient = f2377c;
        if (tbsLogClient == null || !f2375a || !z) {
            return;
        }
        tbsLogClient.showLog(str + ": " + str2);
    }

    public static synchronized void writeLogToDisk() {
        synchronized (TbsLog.class) {
            if (f2377c != null) {
                f2377c.writeLogToDisk();
            }
        }
    }
}
