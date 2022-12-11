package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.stub.StubApp;
import com.tencent.smtt.sdk.C1356c;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.C1428a;
import com.tencent.smtt.utils.C1429b;
import com.tencent.smtt.utils.C1456f;
import com.tencent.smtt.utils.C1467n;
import com.tencent.smtt.utils.C1472q;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";

    /* renamed from: a */
    public static boolean f1858a = false;

    /* renamed from: b */
    public static String f1859b = null;

    /* renamed from: c */
    public static Context f1860c = null;

    /* renamed from: d */
    public static Handler f1861d = null;

    /* renamed from: e */
    public static String f1862e = null;

    /* renamed from: f */
    public static Object f1863f = new byte[0];

    /* renamed from: g */
    public static C1377m f1864g = null;

    /* renamed from: h */
    public static HandlerThread f1865h = null;

    /* renamed from: i */
    public static boolean f1866i = false;

    /* renamed from: j */
    public static String f1867j = "";

    /* renamed from: k */
    public static boolean f1868k = false;

    /* renamed from: l */
    public static boolean f1869l = false;

    /* renamed from: m */
    public static int f1870m = 0;

    /* renamed from: n */
    public static boolean f1871n = false;

    /* renamed from: o */
    public static int f1872o = 0;

    /* renamed from: p */
    public static long f1873p = 0;

    /* renamed from: q */
    public static int f1874q = 0;

    /* renamed from: r */
    public static JSONObject f1875r = null;

    /* renamed from: s */
    public static JSONObject f1876s = null;

    /* renamed from: t */
    public static boolean f1877t = false;

    /* renamed from: u */
    public static int f1878u = 0;

    /* renamed from: v */
    public static int f1879v = 0;

    /* renamed from: w */
    public static JSONObject f1880w = null;

    /* renamed from: x */
    public static long f1881x = -1;

    /* loaded from: classes4.dex */
    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z, int i);
    }

    /* renamed from: a */
    public static File m2811a(int i) {
        String str;
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int length = coreProviderAppList.length;
        File file = null;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String str2 = coreProviderAppList[i2];
            if (!str2.equals(f1860c.getApplicationInfo().packageName)) {
                file = new File(FileUtil.m2195a(f1860c, str2, 4, false), getOverSea(f1860c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
                if (!file.exists()) {
                    str = "can not find local backup core file";
                } else if (C1428a.m2139a(f1860c, file) == i) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("local tbs version fond,path = ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file.getAbsolutePath());
                    TbsLog.m2155i(LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    break;
                } else {
                    str = "version is not match";
                }
                TbsLog.m2155i(LOGTAG, str);
            }
            i2++;
        }
        return file;
    }

    /* renamed from: a */
    public static String m2805a(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: a */
    public static JSONArray m2802a(boolean z) {
        boolean z2;
        JSONArray jSONArray = new JSONArray();
        for (String str : TbsShareManager.getCoreProviderAppList()) {
            String m2195a = FileUtil.m2195a(f1860c, str, 4, false);
            File file = z ? new File(m2195a, getOverSea(f1860c) ? "x5.oversea.tbs.org" : getBackupFileName(false)) : new File(m2195a, "x5.tbs.decouple");
            if (file.exists()) {
                long m2139a = C1428a.m2139a(f1860c, file);
                if (m2139a > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= jSONArray.length()) {
                            z2 = false;
                            break;
                        } else if (jSONArray.optInt(i) == m2139a) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (!z2) {
                        jSONArray.put(m2139a);
                    }
                }
            }
        }
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e6 A[Catch: Exception -> 0x03a8, TryCatch #0 {Exception -> 0x03a8, blocks: (B:132:0x0075, B:134:0x007d, B:136:0x0086, B:138:0x0095, B:139:0x00b1, B:20:0x00d6, B:22:0x00e6, B:23:0x00ee, B:25:0x00fb, B:27:0x00ff, B:32:0x01b8, B:33:0x01cd, B:35:0x01e9, B:37:0x0222, B:38:0x0245, B:41:0x02aa, B:44:0x02b6, B:47:0x02c4, B:48:0x02cd, B:52:0x030b, B:55:0x0316, B:56:0x031e, B:58:0x0327, B:61:0x0331, B:63:0x0337, B:64:0x0346, B:66:0x0350, B:67:0x033c, B:69:0x031a, B:70:0x0357, B:72:0x036c, B:74:0x0377, B:76:0x037b, B:78:0x0385, B:80:0x038c, B:81:0x0391, B:83:0x0399, B:85:0x03a3, B:96:0x0229, B:98:0x0236, B:102:0x0240, B:105:0x01c3, B:110:0x0107, B:112:0x011c, B:114:0x0133, B:116:0x013f, B:118:0x0150, B:120:0x0179, B:121:0x0187, B:123:0x01a5, B:127:0x0127, B:140:0x009c, B:142:0x00ab, B:13:0x00b6, B:15:0x00c5, B:18:0x00d2), top: B:131:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fb A[Catch: Exception -> 0x03a8, TryCatch #0 {Exception -> 0x03a8, blocks: (B:132:0x0075, B:134:0x007d, B:136:0x0086, B:138:0x0095, B:139:0x00b1, B:20:0x00d6, B:22:0x00e6, B:23:0x00ee, B:25:0x00fb, B:27:0x00ff, B:32:0x01b8, B:33:0x01cd, B:35:0x01e9, B:37:0x0222, B:38:0x0245, B:41:0x02aa, B:44:0x02b6, B:47:0x02c4, B:48:0x02cd, B:52:0x030b, B:55:0x0316, B:56:0x031e, B:58:0x0327, B:61:0x0331, B:63:0x0337, B:64:0x0346, B:66:0x0350, B:67:0x033c, B:69:0x031a, B:70:0x0357, B:72:0x036c, B:74:0x0377, B:76:0x037b, B:78:0x0385, B:80:0x038c, B:81:0x0391, B:83:0x0399, B:85:0x03a3, B:96:0x0229, B:98:0x0236, B:102:0x0240, B:105:0x01c3, B:110:0x0107, B:112:0x011c, B:114:0x0133, B:116:0x013f, B:118:0x0150, B:120:0x0179, B:121:0x0187, B:123:0x01a5, B:127:0x0127, B:140:0x009c, B:142:0x00ab, B:13:0x00b6, B:15:0x00c5, B:18:0x00d2), top: B:131:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01e9 A[Catch: Exception -> 0x03a8, TryCatch #0 {Exception -> 0x03a8, blocks: (B:132:0x0075, B:134:0x007d, B:136:0x0086, B:138:0x0095, B:139:0x00b1, B:20:0x00d6, B:22:0x00e6, B:23:0x00ee, B:25:0x00fb, B:27:0x00ff, B:32:0x01b8, B:33:0x01cd, B:35:0x01e9, B:37:0x0222, B:38:0x0245, B:41:0x02aa, B:44:0x02b6, B:47:0x02c4, B:48:0x02cd, B:52:0x030b, B:55:0x0316, B:56:0x031e, B:58:0x0327, B:61:0x0331, B:63:0x0337, B:64:0x0346, B:66:0x0350, B:67:0x033c, B:69:0x031a, B:70:0x0357, B:72:0x036c, B:74:0x0377, B:76:0x037b, B:78:0x0385, B:80:0x038c, B:81:0x0391, B:83:0x0399, B:85:0x03a3, B:96:0x0229, B:98:0x0236, B:102:0x0240, B:105:0x01c3, B:110:0x0107, B:112:0x011c, B:114:0x0133, B:116:0x013f, B:118:0x0150, B:120:0x0179, B:121:0x0187, B:123:0x01a5, B:127:0x0127, B:140:0x009c, B:142:0x00ab, B:13:0x00b6, B:15:0x00c5, B:18:0x00d2), top: B:131:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02c4 A[Catch: Exception -> 0x03a8, TRY_ENTER, TryCatch #0 {Exception -> 0x03a8, blocks: (B:132:0x0075, B:134:0x007d, B:136:0x0086, B:138:0x0095, B:139:0x00b1, B:20:0x00d6, B:22:0x00e6, B:23:0x00ee, B:25:0x00fb, B:27:0x00ff, B:32:0x01b8, B:33:0x01cd, B:35:0x01e9, B:37:0x0222, B:38:0x0245, B:41:0x02aa, B:44:0x02b6, B:47:0x02c4, B:48:0x02cd, B:52:0x030b, B:55:0x0316, B:56:0x031e, B:58:0x0327, B:61:0x0331, B:63:0x0337, B:64:0x0346, B:66:0x0350, B:67:0x033c, B:69:0x031a, B:70:0x0357, B:72:0x036c, B:74:0x0377, B:76:0x037b, B:78:0x0385, B:80:0x038c, B:81:0x0391, B:83:0x0399, B:85:0x03a3, B:96:0x0229, B:98:0x0236, B:102:0x0240, B:105:0x01c3, B:110:0x0107, B:112:0x011c, B:114:0x0133, B:116:0x013f, B:118:0x0150, B:120:0x0179, B:121:0x0187, B:123:0x01a5, B:127:0x0127, B:140:0x009c, B:142:0x00ab, B:13:0x00b6, B:15:0x00c5, B:18:0x00d2), top: B:131:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0385 A[Catch: Exception -> 0x03a8, TryCatch #0 {Exception -> 0x03a8, blocks: (B:132:0x0075, B:134:0x007d, B:136:0x0086, B:138:0x0095, B:139:0x00b1, B:20:0x00d6, B:22:0x00e6, B:23:0x00ee, B:25:0x00fb, B:27:0x00ff, B:32:0x01b8, B:33:0x01cd, B:35:0x01e9, B:37:0x0222, B:38:0x0245, B:41:0x02aa, B:44:0x02b6, B:47:0x02c4, B:48:0x02cd, B:52:0x030b, B:55:0x0316, B:56:0x031e, B:58:0x0327, B:61:0x0331, B:63:0x0337, B:64:0x0346, B:66:0x0350, B:67:0x033c, B:69:0x031a, B:70:0x0357, B:72:0x036c, B:74:0x0377, B:76:0x037b, B:78:0x0385, B:80:0x038c, B:81:0x0391, B:83:0x0399, B:85:0x03a3, B:96:0x0229, B:98:0x0236, B:102:0x0240, B:105:0x01c3, B:110:0x0107, B:112:0x011c, B:114:0x0133, B:116:0x013f, B:118:0x0150, B:120:0x0179, B:121:0x0187, B:123:0x01a5, B:127:0x0127, B:140:0x009c, B:142:0x00ab, B:13:0x00b6, B:15:0x00c5, B:18:0x00d2), top: B:131:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x038c A[Catch: Exception -> 0x03a8, TryCatch #0 {Exception -> 0x03a8, blocks: (B:132:0x0075, B:134:0x007d, B:136:0x0086, B:138:0x0095, B:139:0x00b1, B:20:0x00d6, B:22:0x00e6, B:23:0x00ee, B:25:0x00fb, B:27:0x00ff, B:32:0x01b8, B:33:0x01cd, B:35:0x01e9, B:37:0x0222, B:38:0x0245, B:41:0x02aa, B:44:0x02b6, B:47:0x02c4, B:48:0x02cd, B:52:0x030b, B:55:0x0316, B:56:0x031e, B:58:0x0327, B:61:0x0331, B:63:0x0337, B:64:0x0346, B:66:0x0350, B:67:0x033c, B:69:0x031a, B:70:0x0357, B:72:0x036c, B:74:0x0377, B:76:0x037b, B:78:0x0385, B:80:0x038c, B:81:0x0391, B:83:0x0399, B:85:0x03a3, B:96:0x0229, B:98:0x0236, B:102:0x0240, B:105:0x01c3, B:110:0x0107, B:112:0x011c, B:114:0x0133, B:116:0x013f, B:118:0x0150, B:120:0x0179, B:121:0x0187, B:123:0x01a5, B:127:0x0127, B:140:0x009c, B:142:0x00ab, B:13:0x00b6, B:15:0x00c5, B:18:0x00d2), top: B:131:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0399 A[Catch: Exception -> 0x03a8, TryCatch #0 {Exception -> 0x03a8, blocks: (B:132:0x0075, B:134:0x007d, B:136:0x0086, B:138:0x0095, B:139:0x00b1, B:20:0x00d6, B:22:0x00e6, B:23:0x00ee, B:25:0x00fb, B:27:0x00ff, B:32:0x01b8, B:33:0x01cd, B:35:0x01e9, B:37:0x0222, B:38:0x0245, B:41:0x02aa, B:44:0x02b6, B:47:0x02c4, B:48:0x02cd, B:52:0x030b, B:55:0x0316, B:56:0x031e, B:58:0x0327, B:61:0x0331, B:63:0x0337, B:64:0x0346, B:66:0x0350, B:67:0x033c, B:69:0x031a, B:70:0x0357, B:72:0x036c, B:74:0x0377, B:76:0x037b, B:78:0x0385, B:80:0x038c, B:81:0x0391, B:83:0x0399, B:85:0x03a3, B:96:0x0229, B:98:0x0236, B:102:0x0240, B:105:0x01c3, B:110:0x0107, B:112:0x011c, B:114:0x0133, B:116:0x013f, B:118:0x0150, B:120:0x0179, B:121:0x0187, B:123:0x01a5, B:127:0x0127, B:140:0x009c, B:142:0x00ab, B:13:0x00b6, B:15:0x00c5, B:18:0x00d2), top: B:131:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03a3 A[Catch: Exception -> 0x03a8, TRY_LEAVE, TryCatch #0 {Exception -> 0x03a8, blocks: (B:132:0x0075, B:134:0x007d, B:136:0x0086, B:138:0x0095, B:139:0x00b1, B:20:0x00d6, B:22:0x00e6, B:23:0x00ee, B:25:0x00fb, B:27:0x00ff, B:32:0x01b8, B:33:0x01cd, B:35:0x01e9, B:37:0x0222, B:38:0x0245, B:41:0x02aa, B:44:0x02b6, B:47:0x02c4, B:48:0x02cd, B:52:0x030b, B:55:0x0316, B:56:0x031e, B:58:0x0327, B:61:0x0331, B:63:0x0337, B:64:0x0346, B:66:0x0350, B:67:0x033c, B:69:0x031a, B:70:0x0357, B:72:0x036c, B:74:0x0377, B:76:0x037b, B:78:0x0385, B:80:0x038c, B:81:0x0391, B:83:0x0399, B:85:0x03a3, B:96:0x0229, B:98:0x0236, B:102:0x0240, B:105:0x01c3, B:110:0x0107, B:112:0x011c, B:114:0x0133, B:116:0x013f, B:118:0x0150, B:120:0x0179, B:121:0x0187, B:123:0x01a5, B:127:0x0127, B:140:0x009c, B:142:0x00ab, B:13:0x00b6, B:15:0x00c5, B:18:0x00d2), top: B:131:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0229 A[Catch: Exception -> 0x03a8, TryCatch #0 {Exception -> 0x03a8, blocks: (B:132:0x0075, B:134:0x007d, B:136:0x0086, B:138:0x0095, B:139:0x00b1, B:20:0x00d6, B:22:0x00e6, B:23:0x00ee, B:25:0x00fb, B:27:0x00ff, B:32:0x01b8, B:33:0x01cd, B:35:0x01e9, B:37:0x0222, B:38:0x0245, B:41:0x02aa, B:44:0x02b6, B:47:0x02c4, B:48:0x02cd, B:52:0x030b, B:55:0x0316, B:56:0x031e, B:58:0x0327, B:61:0x0331, B:63:0x0337, B:64:0x0346, B:66:0x0350, B:67:0x033c, B:69:0x031a, B:70:0x0357, B:72:0x036c, B:74:0x0377, B:76:0x037b, B:78:0x0385, B:80:0x038c, B:81:0x0391, B:83:0x0399, B:85:0x03a3, B:96:0x0229, B:98:0x0236, B:102:0x0240, B:105:0x01c3, B:110:0x0107, B:112:0x011c, B:114:0x0133, B:116:0x013f, B:118:0x0150, B:120:0x0179, B:121:0x0187, B:123:0x01a5, B:127:0x0127, B:140:0x009c, B:142:0x00ab, B:13:0x00b6, B:15:0x00c5, B:18:0x00d2), top: B:131:0x0075 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject m2800a(boolean z, boolean z2, boolean z3) {
        String str;
        boolean z4;
        int i;
        int m2446j;
        boolean z5;
        String str2;
        boolean z6;
        int i2;
        int i3;
        Object m2832a;
        int m2448i;
        TbsLog.m2155i(LOGTAG, "[TbsDownloader.postJsonData]isQuery: " + z + " forDecoupleCore is " + z3);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f1860c);
        String m2796b = m2796b(f1860c);
        String m2112i = C1429b.m2112i(f1860c);
        String m2113h = C1429b.m2113h(f1860c);
        String m2110k = C1429b.m2110k(f1860c);
        String id = TimeZone.getDefault().getID();
        String str3 = "";
        String str4 = id != null ? id : str3;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) f1860c.getSystemService("phone");
            if (telephonyManager != null) {
                id = telephonyManager.getSimCountryIso();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id != null) {
            str3 = id;
        }
        JSONObject jSONObject = new JSONObject();
        if (z3) {
            if (C1472q.m1982b(f1860c)) {
                jSONObject.put("REQUEST_TPATCH", 1);
                if (C1429b.m2121b()) {
                    if (C1379n.m2526a(f1860c).m2515c("stable_64_tpatch_fail") == 1) {
                        jSONObject.put("REQUEST_TPATCH", 0);
                        str = "[TbsDownloader.postJsonData] stable_64_last_tpatch_fail and set REQUEST_TPATCH  0 ";
                        TbsLog.m2155i(LOGTAG, str);
                        z4 = true;
                    }
                    z4 = false;
                } else {
                    if (C1379n.m2526a(f1860c).m2515c("stable_32_tpatch_fail") == 1) {
                        jSONObject.put("REQUEST_TPATCH", 0);
                        str = "[TbsDownloader.postJsonData] stable_32_last_tpatch_fail and set REQUEST_TPATCH  0 ";
                        TbsLog.m2155i(LOGTAG, str);
                        z4 = true;
                    }
                    z4 = false;
                }
                jSONObject.put("TIMEZONEID", str4);
                jSONObject.put("COUNTRYISO", str3);
                if (!C1429b.m2121b()) {
                    i = 1;
                    jSONObject.put("REQUEST_64", 1);
                } else {
                    i = 1;
                }
                jSONObject.put("PROTOCOLVERSION", i);
                if (!TbsShareManager.isThirdPartyApp(f1860c)) {
                    m2446j = QbSdk.f1742c ? TbsShareManager.m2733a(f1860c, false) : TbsDownloadConfig.getInstance(f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                    z5 = z4;
                } else {
                    m2446j = z3 ? C1381p.m2503a().m2446j(f1860c) : C1381p.m2503a().m2441n(f1860c);
                    if (m2446j == 0 && C1381p.m2503a().m2442m(f1860c)) {
                        m2446j = -1;
                        if (TbsConfig.APP_QQ.equals(f1860c.getApplicationInfo().packageName)) {
                            TbsDownloadUpload.clear();
                            TbsDownloadUpload tbsDownloadUpload = TbsDownloadUpload.getInstance(f1860c);
                            z5 = z4;
                            tbsDownloadUpload.f1850a.put(TbsDownloadUpload.TbsUploadKey.KEY_LOCAL_CORE_VERSION, -1);
                            tbsDownloadUpload.commit();
                            TbsPVConfig.releaseInstance();
                            if (TbsPVConfig.getInstance(f1860c).getLocalCoreVersionMoreTimes() == 1) {
                                m2446j = C1381p.m2503a().m2446j(f1860c);
                            }
                            TbsLog.m2155i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + m2446j + " isDownloadForeground=" + z2);
                            if (z2 && !C1381p.m2503a().m2442m(f1860c)) {
                                m2446j = 0;
                            }
                        }
                    }
                    z5 = z4;
                    TbsLog.m2155i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + m2446j + " isDownloadForeground=" + z2);
                    if (z2) {
                        m2446j = 0;
                    }
                }
                if (!z) {
                    jSONObject.put("FUNCTION", 2);
                    str2 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                } else {
                    jSONObject.put("FUNCTION", m2446j == 0 ? 0 : 1);
                    str2 = m2446j == 0 ? "C" : "B";
                }
                C1472q.m1985a(ExifInterface.GPS_MEASUREMENT_2D + str2);
                if (!TbsShareManager.isThirdPartyApp(f1860c)) {
                    JSONArray m2784g = m2784g();
                    jSONObject.put("TBSVLARR", m2784g);
                    f1867j = m2784g.toString();
                    C1472q.m1985a("3is" + m2784g.toString());
                    tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, m2784g.toString());
                    tbsDownloadConfig.commit();
                    if (QbSdk.f1742c) {
                        jSONObject.put("THIRDREQ", 1);
                    }
                } else {
                    JSONArray m2802a = m2802a(z3);
                    if (Apn.getApnType(f1860c) != 3 && m2802a.length() != 0 && m2446j == 0 && z) {
                        jSONObject.put("TBSBACKUPARR", m2802a);
                    }
                }
                jSONObject.put("APPN", f1860c.getPackageName());
                jSONObject.put("APPVN", m2805a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null)));
                jSONObject.put("APPVC", tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0));
                jSONObject.put("APPMETA", m2805a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null)));
                jSONObject.put("TBSSDKV", 44115);
                jSONObject.put("TBSV", m2446j);
                C1472q.m1985a("4is" + m2446j);
                jSONObject.put("DOWNLOADDECOUPLECORE", !z3 ? 1 : 0);
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(!z3 ? 1 : 0));
                tbsDownloadConfig.commit();
                if (m2446j != 0) {
                    jSONObject.put("TBSBACKUPV", f1864g.m2548c(z3));
                }
                jSONObject.put("CPU", f1862e);
                jSONObject.put("UA", m2796b);
                jSONObject.put("IMSI", m2805a(m2112i));
                jSONObject.put("IMEI", m2805a(m2113h));
                jSONObject.put("ANDROID_ID", m2805a(m2110k));
                jSONObject.put("GUID", C1429b.m2115f(f1860c));
                if (!TbsShareManager.isThirdPartyApp(f1860c)) {
                    if (m2446j != 0) {
                        jSONObject.put("STATUS", QbSdk.m2837a(f1860c, m2446j) ? 0 : 1);
                    } else {
                        jSONObject.put("STATUS", 0);
                    }
                    if (C1472q.m1982b(f1860c)) {
                        m2448i = TbsShareManager.getTbsStableCoreVersion(f1860c, 0);
                        if (z3 && m2448i > 0 && jSONObject.getInt("FUNCTION") == 0) {
                            jSONObject.put("FUNCTION", 1);
                        }
                    } else {
                        m2448i = C1381p.m2503a().m2448i(f1860c);
                    }
                    jSONObject.put("TBSDV", m2446j % 10000);
                    jSONObject.put("TBSBACKUPV", m2448i);
                    if (z5) {
                        jSONObject.put("TBSDV", 0);
                        jSONObject.put("TBSBACKUPV", 0);
                    }
                }
                z6 = false;
                boolean z7 = TbsDownloadConfig.getInstance(f1860c).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, false);
                if (!((QbSdk.isEnableSensitiveApi() || (m2832a = QbSdk.m2832a(f1860c, "can_unlzma", (Bundle) null)) == null || !(m2832a instanceof Boolean)) ? false : ((Boolean) m2832a).booleanValue())) {
                    i2 = 1;
                    z6 = !z7;
                } else {
                    i2 = 1;
                }
                if (z6) {
                    jSONObject.put("REQUEST_LZMA", i2);
                }
                if (!getOverSea(f1860c)) {
                    i3 = 1;
                    jSONObject.put("OVERSEA", 1);
                } else {
                    i3 = 1;
                }
                if (z2) {
                    jSONObject.put("DOWNLOAD_FOREGROUND", i3);
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsDownloader.postJsonData] jsonData=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(jSONObject.toString());
                TbsLog.m2155i(LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                return jSONObject;
            }
        }
        jSONObject.put("REQUEST_TPATCH", C1379n.m2526a(f1860c).m2515c("tpatch_num") < 5 ? TbsShareManager.isThirdPartyApp(f1860c) ? 2 : 1 : 0);
        z4 = false;
        jSONObject.put("TIMEZONEID", str4);
        jSONObject.put("COUNTRYISO", str3);
        if (!C1429b.m2121b()) {
        }
        jSONObject.put("PROTOCOLVERSION", i);
        if (!TbsShareManager.isThirdPartyApp(f1860c)) {
        }
        if (!z) {
        }
        C1472q.m1985a(ExifInterface.GPS_MEASUREMENT_2D + str2);
        if (!TbsShareManager.isThirdPartyApp(f1860c)) {
        }
        jSONObject.put("APPN", f1860c.getPackageName());
        jSONObject.put("APPVN", m2805a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null)));
        jSONObject.put("APPVC", tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0));
        jSONObject.put("APPMETA", m2805a(tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null)));
        jSONObject.put("TBSSDKV", 44115);
        jSONObject.put("TBSV", m2446j);
        C1472q.m1985a("4is" + m2446j);
        jSONObject.put("DOWNLOADDECOUPLECORE", !z3 ? 1 : 0);
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(!z3 ? 1 : 0));
        tbsDownloadConfig.commit();
        if (m2446j != 0) {
        }
        jSONObject.put("CPU", f1862e);
        jSONObject.put("UA", m2796b);
        jSONObject.put("IMSI", m2805a(m2112i));
        jSONObject.put("IMEI", m2805a(m2113h));
        jSONObject.put("ANDROID_ID", m2805a(m2110k));
        jSONObject.put("GUID", C1429b.m2115f(f1860c));
        if (!TbsShareManager.isThirdPartyApp(f1860c)) {
        }
        z6 = false;
        boolean z72 = TbsDownloadConfig.getInstance(f1860c).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, false);
        if (!((QbSdk.isEnableSensitiveApi() || (m2832a = QbSdk.m2832a(f1860c, "can_unlzma", (Bundle) null)) == null || !(m2832a instanceof Boolean)) ? false : ((Boolean) m2832a).booleanValue())) {
        }
        if (z6) {
        }
        if (!getOverSea(f1860c)) {
        }
        if (z2) {
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsDownloader.postJsonData] jsonData=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(jSONObject.toString());
        TbsLog.m2155i(LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        return jSONObject;
    }

    /* renamed from: a */
    public static void m2803a(JSONArray jSONArray) {
        String[] m2785f;
        boolean z;
        String[] m2785f2 = m2785f();
        int length = m2785f2.length;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= length) {
                break;
            }
            String str = m2785f2[i];
            int sharedTbsCoreVersion = TbsShareManager.getSharedTbsCoreVersion(f1860c, str);
            if (sharedTbsCoreVersion > 0) {
                Context packageContext = TbsShareManager.getPackageContext(f1860c, str, true);
                if (packageContext != null && !C1381p.m2503a().m2453g(packageContext)) {
                    TbsLog.m2158e(LOGTAG, "host check failed,packageName = " + str);
                } else if (m2808a(f1860c, sharedTbsCoreVersion)) {
                    TbsLog.m2155i(LOGTAG, "add CoreVersionToJsonData,version+" + sharedTbsCoreVersion + " is in black list");
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        } else if (jSONArray.optInt(i2) == sharedTbsCoreVersion) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z2) {
                        TbsLog.m2155i(LOGTAG, "addCoreVersionToJsonData,pkg=" + str + ";version=" + sharedTbsCoreVersion);
                        jSONArray.put(sharedTbsCoreVersion);
                    }
                }
            }
            i++;
        }
        if (TbsShareManager.isThirdPartyApp(f1860c)) {
            return;
        }
        for (String str2 : m2785f()) {
            int coreShareDecoupleCoreVersion = TbsShareManager.getCoreShareDecoupleCoreVersion(f1860c, str2);
            if (coreShareDecoupleCoreVersion > 0) {
                Context packageContext2 = TbsShareManager.getPackageContext(f1860c, str2, true);
                if (packageContext2 == null || C1381p.m2503a().m2453g(packageContext2)) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= jSONArray.length()) {
                            z = false;
                            break;
                        } else if (jSONArray.optInt(i3) == coreShareDecoupleCoreVersion) {
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z) {
                        TbsLog.m2155i(LOGTAG, "addCoreVersionToJsonDataByDecouple,pkg=" + str2 + ";version=" + coreShareDecoupleCoreVersion);
                        jSONArray.put(coreShareDecoupleCoreVersion);
                    }
                } else {
                    TbsLog.m2158e(LOGTAG, "host check failed,packageName = " + str2);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2801a(boolean z, TbsDownloaderCallback tbsDownloaderCallback, boolean z2) {
        TbsLog.m2155i(LOGTAG, "[TbsDownloader.queryConfig]");
        f1861d.removeMessages(100);
        Message obtain = Message.obtain(f1861d, 100);
        if (tbsDownloaderCallback != null) {
            obtain.obj = tbsDownloaderCallback;
        }
        obtain.arg1 = 0;
        obtain.arg1 = z ? 1 : 0;
        obtain.arg2 = z2 ? 1 : 0;
        obtain.sendToTarget();
    }

    /* renamed from: a */
    public static boolean m2810a(int i, int i2, int i3) {
        try {
            TbsLog.m2155i(LOGTAG, "copyFromOldBackupDone newCoreVersion is " + i + " localStableCoreVersion is " + i2 + " cpuType is " + i3);
            if (i > 0 && i != i2) {
                File file = new File(FileUtil.m2198a(f1860c, 3), getBackupFileName(false, i3));
                int i4 = -1;
                if (file.exists() && file.canRead() && (i4 = C1428a.m2131b(file)) <= 0) {
                    i4 = C1428a.m2139a(f1860c, file);
                }
                f1879v = i4;
                TbsLog.m2155i(LOGTAG, "copyFromOldBackupDone oldBackupCoreVersion is " + i4);
                if (i == i4) {
                    File file2 = new File(FileUtil.m2195a(f1860c, TbsConfig.APP_WX, 4, true));
                    boolean m2174b = FileUtil.m2174b(file, new File(file2, getBackupFileName(false, i3)));
                    TbsLog.m2155i(LOGTAG, "copyFromOldBackupDone #01 result is " + m2174b);
                    if (m2174b) {
                        File[] listFiles = file2.listFiles();
                        Pattern compile = Pattern.compile(C1428a.m2133a(false, i3));
                        for (File file3 : listFiles) {
                            if (compile.matcher(file3.getName()).find() && file3.isFile() && file3.exists()) {
                                file3.delete();
                            }
                        }
                        File file4 = new File(file2, C1428a.m2133a(false, i3) + "." + i);
                        if (!file4.exists()) {
                            file4.createNewFile();
                        }
                    }
                    return m2174b;
                }
            }
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), LOGTAG);
        }
        TbsLog.m2155i(LOGTAG, "copyFromOldBackupDone result is false  #10");
        return false;
    }

    /* renamed from: a */
    public static boolean m2809a(Context context) {
        return TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1;
    }

    /* renamed from: a */
    public static boolean m2808a(Context context, int i) {
        return Build.VERSION.SDK_INT > 28 && context.getApplicationInfo().targetSdkVersion > 28 && i > 0 && i < 45114;
    }

    /* renamed from: a */
    public static boolean m2807a(Context context, boolean z) {
        int i;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        if (QbSdk.f1742c || !TbsShareManager.isThirdPartyApp(f1860c) || m2793c()) {
            if (!tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                if (z && !TbsConfig.APP_WX.equals(context.getApplicationInfo().packageName)) {
                    TbsLog.m2155i(LOGTAG, "needDownload-oversea is true, but not WX");
                    z = false;
                }
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, Boolean.valueOf(z));
                tbsDownloadConfig.commit();
                f1868k = z;
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("needDownload-first-called--isoversea = ", z, LOGTAG);
            }
            if (getOverSea(context)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("needDownload- return false,  because of  version is ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Build.VERSION.SDK_INT);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", and overea");
                TbsLog.m2155i(LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                i = -103;
            } else {
                Matcher matcher = null;
                String string = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, null);
                f1862e = string;
                if (TextUtils.isEmpty(string)) {
                    return true;
                }
                try {
                    matcher = Pattern.compile("i686|mips|x86_64").matcher(f1862e);
                } catch (Exception unused) {
                }
                if (matcher == null || !matcher.find()) {
                    return true;
                }
                TbsLog.m2158e(LOGTAG, "can not support x86 devices!!");
                i = -104;
            }
            tbsDownloadConfig.setDownloadInterruptCode(i);
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x012a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m2806a(Context context, boolean z, boolean z2) {
        String str;
        boolean z3;
        String str2;
        long j;
        long j2;
        long j3;
        final TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
        C1356c.m2620a().m2617a(context, (Integer) 1000, new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.sdk.TbsDownloader.1
            @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
            /* renamed from: a */
            public void mo1965a(String str3) {
                TbsLog.m2155i(TbsDownloader.LOGTAG, "Execute command [1000](" + str3 + "), force tbs downloader request");
                SharedPreferences.Editor edit = TbsDownloadConfig.this.mPreferences.edit();
                edit.putLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
                edit.apply();
                edit.commit();
            }
        });
        if (!z) {
            String string = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            int i = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0);
            String string2 = tbsDownloadConfig.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null);
            String m2117d = C1429b.m2117d(f1860c);
            int m2116e = C1429b.m2116e(f1860c);
            String m2127a = C1429b.m2127a(f1860c, TBS_METADATA);
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.needSendQueryRequest] appVersionName=" + m2117d + " oldAppVersionName=" + string + " appVersionCode=" + m2116e + " oldAppVersionCode=" + i + " appMetadata=" + m2127a + " oldAppVersionMetadata=" + string2);
            long currentTimeMillis = System.currentTimeMillis();
            long j4 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
            StringBuilder sb = new StringBuilder();
            sb.append("[TbsDownloader.needSendQueryRequest] timeLastCheck=");
            sb.append(j4);
            sb.append(" timeNow=");
            sb.append(currentTimeMillis);
            TbsLog.m2155i(LOGTAG, sb.toString());
            if (z2) {
                boolean contains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK);
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=", contains, LOGTAG);
                if (contains) {
                    j = 0;
                    if (j4 == 0) {
                        j4 = currentTimeMillis;
                    }
                    long j5 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, j);
                    long j6 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, j);
                    long retryInterval = tbsDownloadConfig.getRetryInterval();
                    TbsLog.m2155i(LOGTAG, "retryInterval = " + retryInterval + " s");
                    TbsPVConfig.releaseInstance();
                    int emergentCoreVersion = TbsPVConfig.getInstance(f1860c).getEmergentCoreVersion();
                    int i2 = TbsDownloadConfig.getInstance(f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                    j2 = currentTimeMillis - j4;
                    j3 = retryInterval * 1000;
                    if (j2 <= j3) {
                        str = "needSendRequest  true  #1";
                    } else if (emergentCoreVersion > C1381p.m2503a().m2446j(f1860c) && emergentCoreVersion > i2) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("emergentCoreVersion is ", emergentCoreVersion, " getTbsCoreInstalledVerInNolock is ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1381p.m2503a().m2446j(f1860c));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" responseCoreVersion is ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i2);
                        str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                    } else if (!TbsShareManager.isThirdPartyApp(f1860c) || j5 <= 0 || currentTimeMillis - j5 <= j3 || j6 >= 11) {
                        if (TbsShareManager.isThirdPartyApp(f1860c) && TbsShareManager.findCoreForThirdPartyApp(f1860c) == 0 && !m2786e()) {
                            TbsLog.m2155i(LOGTAG, "needSendRequest  true  #4");
                            C1381p.m2503a().m2460e(f1860c);
                            str2 = null;
                            z3 = true;
                            if (!z3) {
                            }
                            return z3;
                        }
                        if (m2117d == null || m2116e == 0 || m2127a == null) {
                            if (TbsShareManager.isThirdPartyApp(f1860c)) {
                                str2 = "timeNow - timeLastCheck is " + j2 + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(f1860c) + " sendRequestWithSameHostCoreVersion() is " + m2786e() + " appVersionName is " + m2117d + " appVersionCode is " + m2116e + " appMetadata is " + m2127a + " oldAppVersionName is " + string + " oldAppVersionCode is " + i + " oldAppVersionMetadata is " + string2;
                                z3 = false;
                                if (!z3 && TbsShareManager.isThirdPartyApp(f1860c)) {
                                    TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(f1860c).tbsLogInfo();
                                    tbsLogInfo.setErrorCode(-119);
                                    tbsLogInfo.setFailDetail(str2);
                                    TbsLogReport.getInstance(f1860c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                                }
                                return z3;
                            }
                        } else if (!m2117d.equals(string) || m2116e != i || !m2127a.equals(string2)) {
                            str = "needSendRequest  true  #5";
                        }
                        str2 = null;
                        z3 = false;
                        if (!z3) {
                            TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(f1860c).tbsLogInfo();
                            tbsLogInfo2.setErrorCode(-119);
                            tbsLogInfo2.setFailDetail(str2);
                            TbsLogReport.getInstance(f1860c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo2);
                        }
                        return z3;
                    } else {
                        str = "needSendRequest  true  #3";
                    }
                }
            }
            j = 0;
            long j52 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, j);
            long j62 = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, j);
            long retryInterval2 = tbsDownloadConfig.getRetryInterval();
            TbsLog.m2155i(LOGTAG, "retryInterval = " + retryInterval2 + " s");
            TbsPVConfig.releaseInstance();
            int emergentCoreVersion2 = TbsPVConfig.getInstance(f1860c).getEmergentCoreVersion();
            int i22 = TbsDownloadConfig.getInstance(f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            j2 = currentTimeMillis - j4;
            j3 = retryInterval2 * 1000;
            if (j2 <= j3) {
            }
        } else {
            str = "needSendRequest  true  #6";
        }
        TbsLog.m2155i(LOGTAG, str);
        str2 = null;
        z3 = true;
        if (!z3) {
        }
        return z3;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:286:0x017f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:82)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    @android.annotation.TargetApi(11)
    /* renamed from: a */
    public static boolean m2804a(java.lang.String r30, int r31, boolean r32, boolean r33, boolean r34) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 2092
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.m2804a(java.lang.String, int, boolean, boolean, boolean):boolean");
    }

    /* renamed from: b */
    public static File m2797b(int i) {
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int length = coreProviderAppList.length;
        File file = null;
        int i2 = 0;
        while (i2 < length) {
            File file2 = new File(FileUtil.m2195a(f1860c, coreProviderAppList[i2], 4, false), getOverSea(f1860c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
            if (file2.exists() && C1428a.m2139a(f1860c, file2) == i) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("local tbs version fond,path = ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file2.getAbsolutePath());
                TbsLog.m2155i(LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                return file2;
            }
            i2++;
            file = file2;
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m2796b(Context context) {
        String str;
        String str2;
        String replaceAll;
        if (!TextUtils.isEmpty(f1859b)) {
            return f1859b;
        }
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str3 = Build.VERSION.RELEASE;
        try {
            str3 = new String(str3.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        if (str3 != null && str3.length() > 0) {
            stringBuffer.append(str3);
        } else {
            stringBuffer.append("1.0");
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                str = country.toLowerCase();
            }
            if ("REL".equals(Build.VERSION.CODENAME)) {
                String m1976d = C1472q.m1976d(context);
                try {
                    m1976d = new String(m1976d.getBytes("UTF-8"), "ISO8859-1");
                } catch (Exception unused2) {
                }
                if (m1976d == null) {
                    stringBuffer.append("; ");
                } else if (m1976d.length() > 0) {
                    stringBuffer.append("; ");
                    stringBuffer.append(m1976d);
                }
            }
            str2 = Build.ID;
            if (str2 == null) {
                str2 = "";
            }
            replaceAll = str2.replaceAll("[一-龥]", "");
            if (replaceAll == null) {
                if (replaceAll.length() > 0) {
                    stringBuffer.append(" Build/");
                }
                String format = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
                f1859b = format;
                return format;
            }
            stringBuffer.append(" Build/");
            replaceAll = "00";
            stringBuffer.append(replaceAll);
            String format2 = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
            f1859b = format2;
            return format2;
        }
        str = "en";
        stringBuffer.append(str);
        if ("REL".equals(Build.VERSION.CODENAME)) {
        }
        str2 = Build.ID;
        if (str2 == null) {
        }
        replaceAll = str2.replaceAll("[一-龥]", "");
        if (replaceAll == null) {
        }
        stringBuffer.append(replaceAll);
        String format22 = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
        f1859b = format22;
        return format22;
    }

    /* renamed from: b */
    public static void m2795b(JSONArray jSONArray) {
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            int m2484a = C1381p.m2503a().m2484a(TbsShareManager.getHostCorePathAppDefined());
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= jSONArray.length()) {
                    break;
                } else if (jSONArray.optInt(i) == m2484a) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return;
            }
            TbsLog.m2155i(LOGTAG, "addAppDefinedToCoreVersions, version=" + m2484a);
            jSONArray.put(m2484a);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:140:0x074a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:82)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: b */
    public static boolean m2794b(boolean r29, boolean r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 1913
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.m2794b(boolean, boolean, boolean, boolean):boolean");
    }

    /* renamed from: c */
    public static void m2792c(int i) {
        String str;
        int i2;
        int i3;
        try {
            TbsLog.m2155i(LOGTAG, "sendRequestForOtherStableCore cpuType is " + i + " mJsonDataQuery is " + f1875r + " mJsonDataDownloadUpdate is " + f1876s);
            if (!C1472q.m1982b(f1860c)) {
                TbsLog.m2155i(LOGTAG, "sendRequestForOtherStableCore isStableCoreForHostEnable is false and return ");
            } else if (i < 32) {
            } else {
                if (f1875r == null) {
                    f1875r = f1876s;
                }
                if (f1875r == null) {
                    return;
                }
                if (System.currentTimeMillis() - TbsDownloadConfig.getInstance(f1860c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_STABLE_CORE_OTHER_CPU, 0L) < TbsDownloadConfig.getInstance(f1860c).getRetryInterval() * 1000) {
                    TbsLog.m2155i(LOGTAG, "sendRequestForOtherStableCore less than and return ");
                    return;
                }
                int i4 = -1;
                if (i == 64) {
                    f1875r.put("REQUEST_64", 1);
                    i4 = 1;
                } else if (i == 32) {
                    f1875r.remove("REQUEST_64");
                }
                f1875r.put("DOWNLOADDECOUPLECORE", 1);
                if (i == 64) {
                    if (C1379n.m2526a(f1860c).m2515c("stable_64_tpatch_fail") == 1) {
                        str = "sendRequestForOtherStableCore stable_64_last_tpatch_fail and set REQUEST_TPATCH  0 ";
                        TbsLog.m2155i(LOGTAG, str);
                        i2 = 0;
                    }
                    i2 = 1;
                } else {
                    if (C1379n.m2526a(f1860c).m2515c("stable_32_tpatch_fail") == 1) {
                        str = "sendRequestForOtherStableCore stable_32_last_tpatch_fail and set REQUEST_TPATCH  0 ";
                        TbsLog.m2155i(LOGTAG, str);
                        i2 = 0;
                    }
                    i2 = 1;
                }
                f1875r.put("REQUEST_TPATCH", i2);
                int tbsStableCoreVersion = TbsShareManager.getTbsStableCoreVersion(f1860c, i);
                f1875r.put("TBSDV", C1381p.m2503a().m2446j(f1860c) % 10000);
                f1875r.put("TBSBACKUPV", tbsStableCoreVersion);
                if (i2 == 0) {
                    f1875r.put("TBSDV", 0);
                    f1875r.put("TBSBACKUPV", 0);
                }
                if (tbsStableCoreVersion > 0) {
                    f1875r.put("FUNCTION", 1);
                    i3 = 1;
                } else {
                    f1875r.put("FUNCTION", 0);
                    i3 = 0;
                }
                f1875r.put("TBSV", 0);
                String m2012g = C1467n.m2018a(f1860c).m2012g();
                TbsLog.m2155i(LOGTAG, "[TbsDownloader.sendRequestForOtherStableCore] postUrl=" + m2012g);
                TbsLog.m2155i(LOGTAG, "[TbsDownloader.sendRequestForOtherStableCore] mJsonDataQuery=" + f1875r.toString());
                f1880w = f1875r;
                C1472q.m1981b(f1860c, "request_download_update_other", (((("requesttpatch=is=" + i2) + "_tbsdv=is=" + tbsStableCoreVersion) + "_tbsbackupv=is=" + tbsStableCoreVersion) + "_request64=is=" + i4) + "_functionUpload=is=" + i3);
                String m2072a = C1456f.m2072a(m2012g, f1875r.toString().getBytes("utf-8"), new C1456f.AbstractC1457a() { // from class: com.tencent.smtt.sdk.TbsDownloader.4
                    @Override // com.tencent.smtt.utils.C1456f.AbstractC1457a
                    /* renamed from: a */
                    public void mo2068a(int i5) {
                    }
                }, false);
                StringBuilder sb = new StringBuilder();
                sb.append("[TbsDownloader.sendRequestForOtherStableCore] response=");
                sb.append(m2072a);
                TbsLog.m2155i(LOGTAG, sb.toString());
                JSONObject jSONObject = new JSONObject(m2072a);
                TbsDownloadConfig.getInstance(f1860c).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_STABLE_CORE_OTHER_CPU, Long.valueOf(System.currentTimeMillis()));
                TbsDownloadConfig.getInstance(f1860c).commit();
                String string = jSONObject.getString("DOWNLOADURL");
                long j = jSONObject.getLong("TBSAPKFILESIZE");
                String string2 = jSONObject.getString("PKGMD5");
                int i5 = jSONObject.getInt("TBSAPKSERVERVERSION");
                int i6 = jSONObject.getInt("RESPONSECODE");
                f1877t = false;
                if (C1472q.m1982b(f1860c)) {
                    int tbsStableCoreVersion2 = TbsShareManager.getTbsStableCoreVersion(f1860c, i);
                    C1472q.m1981b(f1860c, "response_download_update_other", ((((("newcore=is=" + i5) + "_oldcore=is=" + tbsStableCoreVersion2) + "_RESPONSECODE=is=" + i6) + "_DOWNLOADURLEmpty=is=" + TextUtils.isEmpty(string)) + "_TBSAPKSERVERVERSION=is=" + i5) + "_TBSAPKFILESIZE=is=" + j);
                    if (tbsStableCoreVersion2 < i5) {
                        if (m2810a(i5, tbsStableCoreVersion2, i)) {
                            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f1860c);
                            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, Integer.valueOf(i));
                            tbsDownloadConfig.commit();
                            TbsLog.m2155i(LOGTAG, "sendRequestForOtherStableCore stable core " + i5 + " copy from old backup and return ");
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("oldcore=is=");
                            sb2.append(tbsStableCoreVersion2);
                            C1472q.m1981b(f1860c, "copy_other_cpu_core_ok", sb2.toString() + "_newcore=is=" + i5);
                            return;
                        }
                        TbsDownloadConfig tbsDownloadConfig2 = TbsDownloadConfig.getInstance(f1860c);
                        tbsDownloadConfig2.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, string);
                        tbsDownloadConfig2.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, Long.valueOf(j));
                        tbsDownloadConfig2.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, Integer.valueOf(i));
                        Map<String, Object> map = tbsDownloadConfig2.mSyncMap;
                        if (string2 == null) {
                            string2 = "";
                        }
                        map.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, string2);
                        tbsDownloadConfig2.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 1);
                        tbsDownloadConfig2.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, Integer.valueOf(i5));
                        tbsDownloadConfig2.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i6));
                        tbsDownloadConfig2.commit();
                        TbsLog.m2153i(LOGTAG, "sendRequestForOtherStableCore downloadUrl is " + string, true);
                        if (!TextUtils.isEmpty(string)) {
                            f1864g.m2551b(false, true);
                        }
                    } else if (TextUtils.isEmpty(string) && i5 == 0 && j > 0) {
                        f1877t = true;
                    }
                }
                m2788d(i);
                if (!f1877t) {
                    return;
                }
                int tbsStableCoreVersion3 = TbsShareManager.getTbsStableCoreVersion(f1860c, i);
                f1879v = 0;
                boolean m2810a = m2810a(f1878u, tbsStableCoreVersion3, i);
                TbsLog.m2155i(LOGTAG, "other cpu stable core is flowed and copyFromOldBackupDone is " + m2810a + " tbsDownloadVersion is " + i5 + " oldBackupCoreVersion is " + f1879v + " localStableCore is " + tbsStableCoreVersion3 + " cpuType is " + i);
                C1472q.m1981b(f1860c, "copy_other_cpu_core_ok_flowed", (((("newcore=is=" + f1878u) + "_backupcore=is=" + f1879v) + "_localstablecore=is=" + tbsStableCoreVersion3) + "_cputype=is=" + i) + "_result=is=" + m2810a);
            }
        } catch (Throwable unused) {
        }
    }

    @TargetApi(11)
    /* renamed from: c */
    public static void m2791c(Context context) {
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.getInstance(context).clear();
        C1377m.m2542e(context);
        context.getSharedPreferences("tbs_extension_config", 4).edit().clear().commit();
        context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4).edit().clear().commit();
    }

    /* renamed from: c */
    public static void m2790c(JSONArray jSONArray) {
        String[] m2785f;
        StringBuilder sb;
        String str;
        boolean z;
        if (!TbsPVConfig.getInstance(f1860c).isDisableHostBackupCore()) {
            for (String str2 : m2785f()) {
                int backupCoreVersion = TbsShareManager.getBackupCoreVersion(f1860c, str2);
                boolean z2 = true;
                if (backupCoreVersion > 0) {
                    Context packageContext = TbsShareManager.getPackageContext(f1860c, str2, false);
                    if (packageContext != null && !C1381p.m2503a().m2453g(packageContext)) {
                        sb = new StringBuilder();
                        str = "addBackupVersionToJsonData,host check failed,packageName = ";
                        sb.append(str);
                        sb.append(str2);
                        TbsLog.m2158e(LOGTAG, sb.toString());
                    } else if (m2808a(f1860c, backupCoreVersion)) {
                        TbsLog.m2155i(LOGTAG, "add addBackupVersionToJsonData,version+" + backupCoreVersion + " is in black list");
                    } else {
                        int i = 0;
                        while (true) {
                            if (i >= jSONArray.length()) {
                                z = false;
                                break;
                            } else if (jSONArray.optInt(i) == backupCoreVersion) {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (!z) {
                            TbsLog.m2155i(LOGTAG, "addBackupVersionToJsonData,pkg=" + str2 + ";version=" + backupCoreVersion);
                            jSONArray.put(backupCoreVersion);
                        }
                    }
                }
                int backupDecoupleCoreVersion = TbsShareManager.getBackupDecoupleCoreVersion(f1860c, str2);
                if (backupDecoupleCoreVersion > 0) {
                    Context packageContext2 = TbsShareManager.getPackageContext(f1860c, str2, false);
                    if (packageContext2 == null || C1381p.m2503a().m2453g(packageContext2)) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= jSONArray.length()) {
                                z2 = false;
                                break;
                            } else if (jSONArray.optInt(i2) == backupDecoupleCoreVersion) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (!z2) {
                            TbsLog.m2155i(LOGTAG, "addBackupVersionToJsonDataByDecouple,pkg=" + str2 + ";version=" + backupDecoupleCoreVersion);
                            jSONArray.put(backupDecoupleCoreVersion);
                        }
                    } else {
                        sb = new StringBuilder();
                        str = "host check failed,packageName = ";
                        sb.append(str);
                        sb.append(str2);
                        TbsLog.m2158e(LOGTAG, sb.toString());
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public static boolean m2793c() {
        try {
            for (String str : TbsShareManager.getCoreProviderAppList()) {
                if (TbsShareManager.getSharedTbsCoreVersion(f1860c, str) > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: d */
    public static synchronized void m2789d() {
        synchronized (TbsDownloader.class) {
            if (f1865h == null) {
                f1865h = HandlerThreadC1380o.m2510a();
                try {
                    f1864g = new C1377m(f1860c);
                    f1861d = new Handler(f1865h.getLooper()) { // from class: com.tencent.smtt.sdk.TbsDownloader.2
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            FileOutputStream fileOutputStream;
                            int i = message.what;
                            boolean z = true;
                            if (i != 108) {
                                if (i == 109) {
                                    if (TbsDownloader.f1864g == null) {
                                        return;
                                    }
                                    TbsDownloader.f1864g.m2540f();
                                    return;
                                }
                                switch (i) {
                                    case 100:
                                        boolean z2 = message.arg1 == 1;
                                        boolean m2794b = TbsDownloader.m2794b(true, false, false, message.arg2 == 1);
                                        Object obj = message.obj;
                                        if (obj != null && (obj instanceof TbsDownloaderCallback)) {
                                            TbsLog.m2155i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish needStartDownload=" + m2794b);
                                            String str = (TbsDownloader.f1860c == null || StubApp.getOrigApplicationContext(TbsDownloader.f1860c.getApplicationContext()) == null || StubApp.getOrigApplicationContext(TbsDownloader.f1860c.getApplicationContext()).getApplicationInfo() == null) ? "" : StubApp.getOrigApplicationContext(TbsDownloader.f1860c.getApplicationContext()).getApplicationInfo().packageName;
                                            if (m2794b && !z2) {
                                                if (TbsConfig.APP_WX.equals(str) || TbsConfig.APP_QQ.equals(str)) {
                                                    outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = ", m2794b, TbsDownloader.LOGTAG);
                                                }
                                            }
                                            ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(m2794b, TbsDownloadConfig.getInstance(TbsDownloader.f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                        }
                                        if (!TbsShareManager.isThirdPartyApp(TbsDownloader.f1860c) || !m2794b) {
                                            return;
                                        }
                                        TbsDownloader.startDownload(TbsDownloader.f1860c);
                                        return;
                                    case 101:
                                        break;
                                    case 102:
                                        TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                                        int m2733a = TbsShareManager.isThirdPartyApp(TbsDownloader.f1860c) ? TbsShareManager.m2733a(TbsDownloader.f1860c, false) : C1381p.m2503a().m2441n(TbsDownloader.f1860c);
                                        TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=" + m2733a);
                                        TbsDownloader.f1864g.m2573a(m2733a);
                                        TbsLogReport.getInstance(TbsDownloader.f1860c).dailyReport();
                                        return;
                                    case 103:
                                        TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                                        if (message.arg1 == 0) {
                                            C1381p.m2503a().m2490a((Context) message.obj, true);
                                            return;
                                        } else {
                                            C1381p.m2503a().m2490a((Context) message.obj, false);
                                            return;
                                        }
                                    case 104:
                                        TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                                        TbsLogReport.getInstance(TbsDownloader.f1860c).reportTbsLog();
                                        return;
                                    default:
                                        return;
                                }
                            }
                            if (Apn.getApnType(TbsDownloader.f1860c) != 3 && !QbSdk.getDownloadWithoutWifi()) {
                                TbsLog.m2155i(TbsDownloader.LOGTAG, "not wifi,no need send request");
                                QbSdk.f1753n.onDownloadFinish(111);
                                return;
                            }
                            FileLock fileLock = null;
                            if (!TbsShareManager.isThirdPartyApp(TbsDownloader.f1860c)) {
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tbs_download_lock_file");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TbsDownloadConfig.getInstance(TbsDownloader.f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(".txt");
                                fileOutputStream = FileUtil.m2176b(TbsDownloader.f1860c, false, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                                if (fileOutputStream != null) {
                                    fileLock = FileUtil.m2197a(TbsDownloader.f1860c, fileOutputStream);
                                    if (fileLock == null) {
                                        QbSdk.f1753n.onDownloadFinish(177);
                                        TbsLog.m2155i(TbsDownloader.LOGTAG, "file lock locked,wx or qq is downloading");
                                        TbsDownloadConfig.getInstance(TbsDownloader.f1860c).setDownloadInterruptCode(-203);
                                        TbsLog.m2155i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                                        return;
                                    }
                                } else if (FileUtil.m2199a(TbsDownloader.f1860c)) {
                                    QbSdk.f1753n.onDownloadFinish(-204);
                                    TbsDownloadConfig.getInstance(TbsDownloader.f1860c).setDownloadInterruptCode(-204);
                                    TbsLog.m2155i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                                    return;
                                }
                            } else {
                                fileOutputStream = null;
                            }
                            boolean z3 = message.arg1 == 1;
                            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(TbsDownloader.f1860c);
                            boolean m2794b2 = TbsDownloader.m2794b(false, z3, 108 == message.what, true);
                            StringBuilder sb = new StringBuilder();
                            sb.append("needStartDownload is ");
                            sb.append(m2794b2);
                            sb.append(" forDecoupleCore is ");
                            sb.append(108 == message.what);
                            TbsLog.m2155i(TbsDownloader.LOGTAG, sb.toString());
                            TbsLog.m2155i(TbsDownloader.LOGTAG, "idownloadConfig.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false) is " + tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false));
                            if (m2794b2) {
                                if (z3 && C1381p.m2503a().m2480b(TbsDownloader.f1860c, TbsDownloadConfig.getInstance(TbsDownloader.f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))) {
                                    TbsLog.m2155i(TbsDownloader.LOGTAG, "in needStartDownload true #1");
                                    QbSdk.f1753n.onDownloadFinish(122);
                                    QbSdk.f1753n.onInstallFinish(TbsListener.ErrorCode.DOWNLOAD_FAILED_FOR_PREINIT_CALLBACK);
                                    tbsDownloadConfig.setDownloadInterruptCode(-213);
                                } else if (tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                                    TbsDownloadConfig.getInstance(TbsDownloader.f1860c).setDownloadInterruptCode(-215);
                                    if (108 == message.what) {
                                        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, 0);
                                        tbsDownloadConfig.commit();
                                    }
                                    C1377m c1377m = TbsDownloader.f1864g;
                                    if (108 != message.what) {
                                        z = false;
                                    }
                                    c1377m.m2551b(z3, z);
                                }
                                TbsLog.m2155i(TbsDownloader.LOGTAG, "------freeFileLock called :");
                                FileUtil.m2179a(fileLock, fileOutputStream);
                            }
                            QbSdk.f1753n.onDownloadFinish(110);
                            QbSdk.f1753n.onInstallFinish(TbsListener.ErrorCode.DOWNLOAD_FAILED_FOR_PREINIT_CALLBACK);
                            TbsLog.m2155i(TbsDownloader.LOGTAG, "------freeFileLock called :");
                            FileUtil.m2179a(fileLock, fileOutputStream);
                        }
                    };
                } catch (Exception unused) {
                    f1866i = true;
                    TbsLog.m2158e(LOGTAG, "TbsApkDownloader init has Exception");
                }
            }
        }
    }

    /* renamed from: d */
    public static void m2788d(int i) {
        JSONObject jSONObject = f1880w;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("FUNCTION", 2);
            String m2012g = C1467n.m2018a(f1860c).m2012g();
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.resetOtherCpuStableCore] postUrl=" + m2012g);
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.resetOtherCpuStableCore] mJsonDataQueryReset=" + f1880w.toString());
            String m2072a = C1456f.m2072a(m2012g, f1880w.toString().getBytes("utf-8"), new C1456f.AbstractC1457a() { // from class: com.tencent.smtt.sdk.TbsDownloader.5
                @Override // com.tencent.smtt.utils.C1456f.AbstractC1457a
                /* renamed from: a */
                public void mo2068a(int i2) {
                }
            }, false);
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.resetOtherCpuStableCore] response=" + m2072a);
            f1878u = 0;
            JSONObject jSONObject2 = new JSONObject(m2072a);
            if (jSONObject2.getInt("RESETDECOUPLECORE") != 1) {
                f1878u = jSONObject2.getInt("DECOUPLECOREVERSION");
                return;
            }
            Context packageContext = TbsShareManager.getPackageContext(f1860c, TbsConfig.APP_WX, false);
            File file = packageContext == null ? new File(FileUtil.m2195a(f1860c, TbsConfig.APP_WX, 4, true)) : new File(FileUtil.m2198a(packageContext, 4));
            TbsLog.m2153i(LOGTAG, "[TbsDownloader.resetOtherCpuStableCore] resetDecoupleCore mFilePathStable is " + file.getAbsolutePath(), true);
            File[] listFiles = file.listFiles();
            Pattern compile = Pattern.compile(C1428a.m2133a(false, i));
            for (File file2 : listFiles) {
                if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    TbsLog.m2153i(LOGTAG, "resetOtherCpuStableCore file is " + file2.getAbsolutePath(), true);
                    file2.delete();
                }
            }
            File file3 = new File(file, getBackupFileName(false, i));
            TbsLog.m2153i(LOGTAG, "resetOtherCpuStableCore file is " + file3.getAbsolutePath(), true);
            file3.delete();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public static void m2787d(JSONArray jSONArray) {
        String[] m2785f;
        boolean z;
        for (String str : m2785f()) {
            int stableCoreVersion = TbsShareManager.getStableCoreVersion(f1860c, str);
            if (stableCoreVersion > 0) {
                Context packageContext = TbsShareManager.getPackageContext(f1860c, str, false);
                if (packageContext == null || C1381p.m2503a().m2453g(packageContext)) {
                    int i = 0;
                    while (true) {
                        if (i >= jSONArray.length()) {
                            z = false;
                            break;
                        } else if (jSONArray.optInt(i) == stableCoreVersion) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (!z) {
                        TbsLog.m2155i(LOGTAG, "addStableVersionToJsonData,pkg=" + str + ";version=" + stableCoreVersion);
                        jSONArray.put(stableCoreVersion);
                    }
                } else {
                    TbsLog.m2158e(LOGTAG, "addStableVersionToJsonData,host check failed,packageName = " + str);
                }
            }
        }
    }

    /* renamed from: e */
    public static boolean m2786e() {
        try {
            return TbsDownloadConfig.getInstance(f1860c).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, "").equals(m2784g().toString());
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: f */
    public static String[] m2785f() {
        if (QbSdk.getOnlyDownload()) {
            return new String[]{StubApp.getOrigApplicationContext(f1860c.getApplicationContext()).getPackageName()};
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        String packageName = StubApp.getOrigApplicationContext(f1860c.getApplicationContext()).getPackageName();
        if (!packageName.equals(TbsShareManager.m2725f(f1860c))) {
            return coreProviderAppList;
        }
        int length = coreProviderAppList.length;
        String[] strArr = new String[length + 1];
        System.arraycopy(coreProviderAppList, 0, strArr, 0, length);
        strArr[length] = packageName;
        return strArr;
    }

    /* renamed from: g */
    public static JSONArray m2784g() {
        if (TbsShareManager.isThirdPartyApp(f1860c)) {
            JSONArray jSONArray = new JSONArray();
            m2803a(jSONArray);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getHostCoreVersions addCoreVersionToJsonData is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(jSONArray.toString());
            TbsLog.m2155i(LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            m2790c(jSONArray);
            TbsLog.m2155i(LOGTAG, "getHostCoreVersions addBackupVersionToJsonData is " + jSONArray.toString());
            m2795b(jSONArray);
            TbsLog.m2155i(LOGTAG, "getHostCoreVersions addAppDefinedToCoreVersions is " + jSONArray.toString());
            m2787d(jSONArray);
            TbsLog.m2155i(LOGTAG, "getHostCoreVersions addStableVersionToJsonData is " + jSONArray.toString());
            return jSONArray;
        }
        return null;
    }

    public static String getBackupFileName(boolean z) {
        return getBackupFileName(z, 0);
    }

    public static String getBackupFileName(boolean z, int i) {
        boolean m2121b = i == 64 ? true : i == 32 ? false : C1429b.m2121b();
        return z ? m2121b ? "x5.tbs.decouple.64" : "x5.tbs.decouple" : m2121b ? "x5.tbs.org.64" : "x5.tbs.org";
    }

    public static int getCoreShareDecoupleCoreVersion() {
        return C1381p.m2503a().m2448i(f1860c);
    }

    public static int getCoreShareDecoupleCoreVersionByContext(Context context) {
        return C1381p.m2503a().m2448i(context);
    }

    public static synchronized boolean getOverSea(Context context) {
        boolean z;
        synchronized (TbsDownloader.class) {
            if (!f1869l) {
                f1869l = true;
                TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
                if (tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                    f1868k = tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, false);
                    TbsLog.m2155i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + f1868k);
                }
                TbsLog.m2155i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + f1868k);
            }
            z = f1868k;
        }
        return z;
    }

    public static long getRetryIntervalInSeconds() {
        return f1881x;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return f1865h;
    }

    /* renamed from: h */
    public static boolean m2783h() {
        int i;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f1860c);
        if (tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.m2153i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            i = -115;
        } else if (tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
            TbsLog.m2153i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            i = -116;
        } else if (FileUtil.m2178b(f1860c)) {
            if (System.currentTimeMillis() - tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0L) <= 86400000) {
                long j = tbsDownloadConfig.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0L);
                TbsLog.m2155i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=" + j);
                if (j >= tbsDownloadConfig.getDownloadMaxflow()) {
                    TbsLog.m2153i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                    i = -120;
                }
            }
            return true;
        } else {
            TbsLog.m2153i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            i = -117;
        }
        tbsDownloadConfig.setDownloadInterruptCode(i);
        return false;
    }

    public static boolean isDownloadForeground() {
        C1377m c1377m = f1864g;
        return c1377m != null && c1377m.m2546d();
    }

    public static synchronized boolean isDownloading() {
        boolean z;
        synchronized (TbsDownloader.class) {
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.isDownloading] is " + f1858a);
            z = f1858a;
        }
        return z;
    }

    public static boolean needDownload(Context context, boolean z) {
        return needDownload(context, z, false, true, null);
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, TbsDownloaderCallback tbsDownloaderCallback) {
        return needDownload(context, z, z2, true, tbsDownloaderCallback);
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, boolean z3, TbsDownloaderCallback tbsDownloaderCallback) {
        boolean contains;
        boolean z4;
        int i;
        C1472q.m1981b(context, "need_download", "");
        C1472q.m1986a(context, "need_download", "");
        f1860c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        C1472q.m1985a("1");
        TbsLog.initIfNeed(context);
        TbsLog.m2155i(LOGTAG, "needDownload,process=" + QbSdk.getCurrentProcessName(context) + "stack=" + Log.getStackTraceString(new Throwable()));
        TbsDownloadUpload.clear();
        TbsDownloadUpload tbsDownloadUpload = TbsDownloadUpload.getInstance(context);
        tbsDownloadUpload.f1850a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 140);
        tbsDownloadUpload.commit();
        C1381p.m2503a().m2473b(context, C1363g.f2113a == 0);
        int m2481b = C1381p.m2503a().m2481b(context);
        TbsLog.m2155i(LOGTAG, "[TbsDownloader.needDownload],renameRet=" + m2481b);
        if (m2481b != 0) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.f1898a = 129;
            tbsLogInfo.setFailDetail("code=2" + m2481b);
            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, tbsLogInfo);
        }
        if (m2481b < 0) {
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.needDownload],needReNameFile=" + m2481b);
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        TbsLog.m2155i(LOGTAG, "[TbsDownloader.needDownload] oversea=" + z + ",isDownloadForeground=" + z2);
        if (C1381p.f2183b) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.needDownload]#1 Static Installing, return false");
            tbsDownloadUpload.f1850a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1));
            tbsDownloadUpload.commit();
            return false;
        }
        TbsLog.app_extra(LOGTAG, context);
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        f1860c = origApplicationContext;
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(origApplicationContext);
        tbsDownloadConfig.setDownloadInterruptCode(-100);
        if (!m2807a(f1860c, z)) {
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.needDownload]#2 Not shouldDoNeedDownload, return false");
            tbsDownloadUpload.f1850a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 141);
            tbsDownloadUpload.commit();
            tbsDownloadUpload.f1850a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2));
            tbsDownloadUpload.commit();
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        m2789d();
        if (f1866i) {
            tbsDownloadConfig.setDownloadInterruptCode(-105);
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.needDownload]#3 TbsApkDownloader init Exception, return false");
            tbsDownloadUpload.f1850a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 142);
            tbsDownloadUpload.commit();
            tbsDownloadUpload.f1850a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3));
            tbsDownloadUpload.commit();
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        boolean m2806a = m2806a(f1860c, z2, false);
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsDownloader.needDownload],needSendRequest=", m2806a, LOGTAG);
        if (m2806a) {
            m2801a(z2, tbsDownloaderCallback, z3);
            tbsDownloadConfig.setDownloadInterruptCode(-114);
        } else {
            tbsDownloadUpload.f1850a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 143);
            tbsDownloadUpload.commit();
        }
        f1861d.removeMessages(102);
        Message.obtain(f1861d, 102).sendToTarget();
        if (QbSdk.f1742c || !TbsShareManager.isThirdPartyApp(context)) {
            contains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsDownloader.needDownload] hasNeedDownloadKey=", contains, LOGTAG);
            z4 = (contains || TbsShareManager.isThirdPartyApp(context)) ? tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false) : true;
        } else {
            z4 = false;
            contains = false;
        }
        TbsLog.m2155i(LOGTAG, "[TbsDownloader.needDownload]#4,needDownload=" + z4 + ",hasNeedDownloadKey=" + contains);
        if (!z4) {
            int m2441n = C1381p.m2503a().m2441n(f1860c);
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + m2441n + ",needSendRequest=" + m2806a);
            if (m2806a || m2441n <= 0) {
                f1861d.removeMessages(103);
                ((m2441n > 0 || m2806a) ? Message.obtain(f1861d, 103, 1, 0, f1860c) : Message.obtain(f1861d, 103, 0, 0, f1860c)).sendToTarget();
                i = -121;
            } else {
                i = -119;
            }
            tbsDownloadConfig.setDownloadInterruptCode(i);
        } else if (!m2783h()) {
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.needDownload]#5,set needDownload = false");
            z4 = false;
        } else {
            tbsDownloadConfig.setDownloadInterruptCode(-118);
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.needDownload]#6");
        }
        if (!m2806a && tbsDownloaderCallback != null) {
            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        tbsDownloadUpload.f1850a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(z4 ? 170 : TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4));
        tbsDownloadUpload.commit();
        return z4;
    }

    public static boolean needDownloadDecoupleCore() {
        int i;
        if (!TbsShareManager.isThirdPartyApp(f1860c) && !m2809a(f1860c)) {
            return System.currentTimeMillis() - TbsDownloadConfig.getInstance(f1860c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0L) >= TbsDownloadConfig.getInstance(f1860c).getRetryInterval() * 1000 && (i = TbsDownloadConfig.getInstance(f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0)) > 0 && i != C1381p.m2503a().m2448i(f1860c) && TbsDownloadConfig.getInstance(f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i;
        }
        return false;
    }

    public static boolean needSendRequest(Context context, boolean z) {
        f1860c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        TbsLog.initIfNeed(context);
        boolean z2 = false;
        if (!m2807a(f1860c, z)) {
            return false;
        }
        int m2441n = C1381p.m2503a().m2441n(context);
        TbsLog.m2155i(LOGTAG, "[TbsDownloader.needSendRequest] localTbsVersion=" + m2441n);
        if (m2441n > 0) {
            return false;
        }
        if (m2806a(f1860c, false, true)) {
            return true;
        }
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f1860c);
        boolean contains = tbsDownloadConfig.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsDownloader.needSendRequest] hasNeedDownloadKey=", contains, LOGTAG);
        boolean z3 = !contains ? true : tbsDownloadConfig.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsDownloader.needSendRequest] needDownload=", z3, LOGTAG);
        if (z3 && m2783h()) {
            z2 = true;
        }
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsDownloader.needSendRequest] ret=", z2, LOGTAG);
        return z2;
    }

    public static void pauseDownload() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("called pauseDownload,downloader=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1864g);
        TbsLog.m2155i(LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        C1377m c1377m = f1864g;
        if (c1377m != null) {
            c1377m.m2543e();
        }
    }

    public static void resumeDownload() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("called resumeDownload,downloader=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1864g);
        TbsLog.m2155i(LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        Handler handler = f1861d;
        if (handler != null) {
            handler.removeMessages(109);
            f1861d.sendEmptyMessage(109);
        }
    }

    public static void setAppContext(Context context) {
        if (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
            return;
        }
        f1860c = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static void setRetryIntervalInSeconds(Context context, long j) {
        if (context == null) {
            return;
        }
        if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
            f1881x = j;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("mRetryIntervalInSeconds is ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1881x);
        TbsLog.m2155i(LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public static boolean startDecoupleCoreIfNeeded() {
        if (!C1472q.m1982b(f1860c)) {
            TbsLog.m2155i(LOGTAG, "startDecoupleCoreIfNeeded isStableCoreForHostEnable is false and return ");
            return false;
        }
        boolean startDecoupleCoreIfNeededImpl = startDecoupleCoreIfNeededImpl();
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("startDecoupleCoreIfNeeded startDecoupleCoreIfNeededImpl return is ", startDecoupleCoreIfNeededImpl, LOGTAG);
        if (!startDecoupleCoreIfNeededImpl && C1472q.m1982b(f1860c)) {
            int i = TbsDownloadConfig.getInstance(f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, 0);
            TbsLog.m2155i(LOGTAG, "startDecoupleCoreIfNeeded cpuTypeForOtherStableCore is " + i);
            int i2 = 64;
            if (i == 0) {
                if (C1429b.m2121b()) {
                    i2 = 32;
                }
                m2792c(i2);
            } else if (i == 32 || i == 64) {
                TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f1860c);
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, "");
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, 0);
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, "");
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                tbsDownloadConfig.commit();
            }
        }
        return startDecoupleCoreIfNeededImpl;
    }

    public static boolean startDecoupleCoreIfNeededImpl() {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        TbsLog.m2155i(LOGTAG, "startDecoupleCoreIfNeeded ");
        if (TbsShareManager.isThirdPartyApp(f1860c)) {
            return false;
        }
        TbsLog.m2155i(LOGTAG, "startDecoupleCoreIfNeeded #1");
        C1377m.m2567a(f1860c);
        C1377m.m2553b(f1860c);
        if (m2809a(f1860c) || f1861d == null) {
            return false;
        }
        TbsLog.m2155i(LOGTAG, "startDecoupleCoreIfNeeded #2");
        if (System.currentTimeMillis() - TbsDownloadConfig.getInstance(f1860c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0L) < TbsDownloadConfig.getInstance(f1860c).getRetryInterval() * 1000) {
            return false;
        }
        TbsLog.m2155i(LOGTAG, "startDecoupleCoreIfNeeded #3");
        int i = TbsDownloadConfig.getInstance(f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        int tbsStableCoreVersion = C1472q.m1982b(f1860c) ? TbsShareManager.getTbsStableCoreVersion(f1860c, 0) : C1381p.m2503a().m2448i(f1860c);
        TbsLog.m2155i(LOGTAG, "startDecoupleCoreIfNeeded coreVersionForThirdApp is " + tbsStableCoreVersion + " deCoupleCoreVersion is " + i);
        if (i <= 0 || i == tbsStableCoreVersion) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is ", i, " getTbsCoreShareDecoupleCoreVersion is ", tbsStableCoreVersion);
        } else if (m2810a(i, tbsStableCoreVersion, 0)) {
            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(f1860c);
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, 0);
            tbsDownloadConfig.commit();
            TbsLog.m2155i(LOGTAG, "startDecoupleCoreIfNeededImpl stable core " + i + " copy from old backup and return ");
            StringBuilder sb = new StringBuilder();
            sb.append("oldcore=is=");
            sb.append(tbsStableCoreVersion);
            String sb2 = sb.toString();
            C1472q.m1981b(f1860c, "copy_my_cpu_core_ok", sb2 + "_newcore=is=" + i);
            return false;
        } else if (TbsDownloadConfig.getInstance(f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i || TbsDownloadConfig.getInstance(f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
            TbsLog.m2155i(LOGTAG, "startDecoupleCoreIfNeeded #4");
            f1858a = true;
            f1861d.removeMessages(108);
            Message obtain = Message.obtain(f1861d, 108, QbSdk.f1753n);
            obtain.arg1 = 0;
            obtain.sendToTarget();
            TbsDownloadConfig.getInstance(f1860c).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, Long.valueOf(System.currentTimeMillis()));
            return true;
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(TbsDownloadConfig.getInstance(f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" deCoupleCoreVersion is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" KEY_TBS_DOWNLOAD_V_TYPE is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(TbsDownloadConfig.getInstance(f1860c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        }
        TbsLog.m2155i(LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return false;
    }

    public static void startDownload(Context context) {
        startDownload(context, false);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        synchronized (TbsDownloader.class) {
            TbsLog.initIfNeed(context);
            TbsDownloadUpload tbsDownloadUpload = TbsDownloadUpload.getInstance(context);
            tbsDownloadUpload.f1850a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 160);
            tbsDownloadUpload.commit();
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + f1860c);
            if (C1381p.f2183b) {
                tbsDownloadUpload.f1850a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 161);
                tbsDownloadUpload.commit();
                return;
            }
            int i = 0;
            C1381p.m2503a().m2473b(context, C1363g.f2113a == 0);
            int m2481b = C1381p.m2503a().m2481b(context);
            TbsLog.m2155i(LOGTAG, "[TbsDownloader.needDownload],renameRet=" + m2481b);
            if (m2481b != 0) {
                TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                tbsLogInfo.f1898a = 129;
                tbsLogInfo.setFailDetail("code=2" + m2481b);
                TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, tbsLogInfo);
            }
            if (m2481b < 0) {
                TbsLog.m2155i(LOGTAG, "[TbsDownloader.needDownload],needReNameFile=" + m2481b);
                return;
            }
            f1858a = true;
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            f1860c = origApplicationContext;
            TbsDownloadConfig.getInstance(origApplicationContext).setDownloadInterruptCode(-200);
            m2789d();
            if (f1866i) {
                QbSdk.f1753n.onDownloadFinish(121);
                TbsDownloadConfig.getInstance(f1860c).setDownloadInterruptCode(-202);
                tbsDownloadUpload.f1850a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 163);
                tbsDownloadUpload.commit();
                return;
            }
            if (z) {
                stopDownload();
            }
            f1861d.removeMessages(101);
            f1861d.removeMessages(100);
            Message obtain = Message.obtain(f1861d, 101, QbSdk.f1753n);
            if (z) {
                i = 1;
            }
            obtain.arg1 = i;
            obtain.sendToTarget();
        }
    }

    public static void stopDownload() {
        if (f1866i) {
            return;
        }
        TbsLog.m2155i(LOGTAG, "[TbsDownloader.stopDownload]");
        C1377m c1377m = f1864g;
        if (c1377m != null) {
            c1377m.m2555b();
        }
        Handler handler = f1861d;
        if (handler == null) {
            return;
        }
        handler.removeMessages(100);
        f1861d.removeMessages(101);
        f1861d.removeMessages(108);
    }
}
