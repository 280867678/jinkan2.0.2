package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.stub.StubApp;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.C1429b;
import com.tencent.smtt.utils.C1458g;
import com.tencent.smtt.utils.C1463k;
import com.tencent.smtt.utils.C1467n;
import com.tencent.smtt.utils.C1472q;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import me.tvspark.outline;
import org.eclipse.jetty.http.HttpHeaderValues;
import org.json.JSONObject;

/* renamed from: com.tencent.smtt.sdk.stat.b */
/* loaded from: classes4.dex */
public class C1397b {

    /* renamed from: a */
    public static byte[] f2232a;

    /* renamed from: b */
    public static ThirdAppInfoNew f2233b;

    static {
        try {
            f2232a = "65dRa93L".getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00bf A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c2  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m2385a(Context context) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("cpuabi", C1429b.m2121b() ? "64" : "32");
                if (!TbsShareManager.isThirdPartyApp(context) && C1472q.m1982b(context)) {
                    int tbsStableCoreVersion = TbsShareManager.getTbsStableCoreVersion(context, 32);
                    jSONObject.put("stableCore32", tbsStableCoreVersion);
                    if (tbsStableCoreVersion <= 0) {
                        jSONObject.put("stableCoreErrorReason32", TbsShareManager.getStableCoreZeroReason());
                    }
                    int tbsStableCoreVersion2 = TbsShareManager.getTbsStableCoreVersion(context, 64);
                    jSONObject.put("stableCore64", tbsStableCoreVersion2);
                    if (tbsStableCoreVersion2 <= 0) {
                        jSONObject.put("stableCoreErrorReason64", TbsShareManager.getStableCoreZeroReason());
                    }
                }
                if (TbsShareManager.isThirdPartyApp(context)) {
                    jSONObject.put("canReadSDCard", C1429b.m2109l(context));
                    if (C1472q.m1978c(context)) {
                        String replace = C1472q.m1983b().replace(",", "-");
                        if (!TextUtils.isEmpty(replace)) {
                            jSONObject.put("coreUpdate", replace);
                        }
                    }
                }
                C1472q.m1979c();
                if (TbsShareManager.isThirdPartyApp(context) && C1472q.m1971i(context)) {
                    String m1977d = C1472q.m1977d();
                    if (!TextUtils.isEmpty(m1977d)) {
                        jSONObject.put("destroyCode", m1977d);
                    }
                }
                if (TbsShareManager.isThirdPartyApp(context) && C1472q.m1972h(context)) {
                    String m1970j = C1472q.m1970j(context);
                    if (!TextUtils.isEmpty(m1970j)) {
                        jSONObject.put("coreSource", m1970j);
                        C1472q.m1990a(QbSdk.getTbsVersion(context));
                    }
                }
            } catch (Throwable unused) {
                jSONObject2 = jSONObject;
                jSONObject = jSONObject2;
                if (jSONObject != null) {
                }
            }
        } catch (Throwable unused2) {
        }
        return jSONObject != null ? "" : jSONObject.toString();
    }

    /* renamed from: a */
    public static void m2387a(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        m2386a(thirdAppInfoNew, context, null, null);
    }

    /* renamed from: a */
    public static void m2386a(final ThirdAppInfoNew thirdAppInfoNew, final Context context, final String str, final String str2) {
        new Thread("HttpUtils") { // from class: com.tencent.smtt.sdk.stat.b.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String str3;
                String str4;
                StringBuilder sb;
                String str5;
                String sb2;
                String str6;
                String str7;
                C1429b.m2119b(context, thirdAppInfoNew.sGuid);
                thirdAppInfoNew.sCpu = C1429b.m2130a();
                JSONObject jSONObject = null;
                if (C1397b.f2232a == null) {
                    try {
                        C1397b.f2232a = "65dRa93L".getBytes("utf-8");
                    } catch (UnsupportedEncodingException unused) {
                        C1397b.f2232a = null;
                        TbsLog.m2158e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
                    }
                }
                if (C1397b.f2232a == null) {
                    sb2 = "Post failed -- POST_DATA_KEY is null!";
                } else {
                    String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "");
                    if (!TextUtils.isEmpty(string)) {
                        str4 = string.substring(0, string.indexOf("&"));
                        str3 = string.substring(string.indexOf("&") + 1, string.length());
                    } else {
                        str3 = "";
                        str4 = str3;
                    }
                    boolean z = TextUtils.isEmpty(str4) || str4.length() != 96 || TextUtils.isEmpty(str3) || str3.length() != 24;
                    try {
                        C1467n m2019a = C1467n.m2019a();
                        if (z) {
                            str6 = m2019a.m2017b() + C1458g.m2067a().m2064b();
                        } else {
                            str6 = m2019a.m2010i() + str4;
                        }
                        TbsLog.m2155i("sdkreport", "Post post_url is " + str6);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str6).openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setConnectTimeout(20000);
                        httpURLConnection.setRequestProperty("Connection", HttpHeaderValues.CLOSE);
                        try {
                            jSONObject = C1397b.m2375c(thirdAppInfoNew, context);
                        } catch (Exception e) {
                            TbsLog.m2152i(e);
                        }
                        if (jSONObject != null) {
                            try {
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put(str, str2);
                                        str7 = jSONObject2.toString();
                                    } catch (Throwable unused2) {
                                        str7 = "";
                                    }
                                    jSONObject.put("EXT_INFO", str7);
                                    jSONObject.put("PV", 0);
                                }
                            } catch (Exception e2) {
                                TbsLog.m2152i(e2);
                            }
                            try {
                                TbsLog.m2155i("sdkreport", "Post jsonData.toString() is " + jSONObject.toString());
                                byte[] bytes = jSONObject.toString().getBytes("utf-8");
                                byte[] m2066a = z ? C1458g.m2067a().m2066a(bytes) : C1458g.m2065a(bytes, str3);
                                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(m2066a.length));
                                try {
                                    OutputStream outputStream = httpURLConnection.getOutputStream();
                                    outputStream.write(m2066a);
                                    outputStream.flush();
                                    if (httpURLConnection.getResponseCode() == 200) {
                                        TbsLog.m2155i("sdkreport", "Post successful!");
                                        TbsLog.m2155i("sdkreport", "SIGNATURE is " + jSONObject.getString("SIGNATURE"));
                                        C1397b.m2378b(context, C1397b.m2376b(httpURLConnection, str3, z));
                                        new TbsDownloadUpload(context).clearUploadCode();
                                        return;
                                    }
                                    TbsLog.m2158e("sdkreport", "Post failed -- not 200 code is " + httpURLConnection.getResponseCode());
                                    TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                                    tbsLogInfo.setErrorCode(126);
                                    tbsLogInfo.setFailDetail("" + httpURLConnection.getResponseCode());
                                    TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                                    return;
                                } catch (Throwable th) {
                                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Post failed -- exceptions:");
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.getMessage());
                                    TbsLog.m2158e("sdkreport", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                                    TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(context).tbsLogInfo();
                                    tbsLogInfo2.setErrorCode(126);
                                    tbsLogInfo2.setFailDetail(th);
                                    TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo2);
                                    return;
                                }
                            } catch (Throwable unused3) {
                                return;
                            }
                        }
                        sb2 = "post -- jsonData is null!";
                    } catch (IOException e3) {
                        e = e3;
                        sb = new StringBuilder();
                        str5 = "Post failed -- IOException:";
                        sb.append(str5);
                        sb.append(e);
                        sb2 = sb.toString();
                        TbsLog.m2158e("sdkreport", sb2);
                    } catch (AssertionError e4) {
                        e = e4;
                        sb = new StringBuilder();
                        str5 = "Post failed -- AssertionError:";
                        sb.append(str5);
                        sb.append(e);
                        sb2 = sb.toString();
                        TbsLog.m2158e("sdkreport", sb2);
                    } catch (NoClassDefFoundError e5) {
                        e = e5;
                        sb = new StringBuilder();
                        str5 = "Post failed -- NoClassDefFoundError:";
                        sb.append(str5);
                        sb.append(e);
                        sb2 = sb.toString();
                        TbsLog.m2158e("sdkreport", sb2);
                    }
                }
                TbsLog.m2158e("sdkreport", sb2);
            }
        }.start();
    }

    /* renamed from: a */
    public static void m2383a(Context context, String str, String str2) {
        if (f2233b == null) {
            ThirdAppInfoNew thirdAppInfoNew = new ThirdAppInfoNew();
            thirdAppInfoNew.sAppName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().packageName;
            C1467n.m2018a(context);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            thirdAppInfoNew.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
            thirdAppInfoNew.sVersionCode = C1429b.m2116e(context);
            String m2127a = C1429b.m2127a(context, TbsDownloader.TBS_METADATA);
            if (!TextUtils.isEmpty(m2127a)) {
                thirdAppInfoNew.sMetaData = m2127a;
            }
            thirdAppInfoNew.sGuid = "";
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(QbSdk.getTbsVersion(context));
            thirdAppInfoNew.sQua2 = C1463k.m2038a(context, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            thirdAppInfoNew.sLc = "";
            String m2111j = C1429b.m2111j(context);
            String m2113h = C1429b.m2113h(context);
            String m2112i = C1429b.m2112i(context);
            String m2110k = C1429b.m2110k(context);
            if (m2113h != null && !"".equals(m2113h)) {
                thirdAppInfoNew.sImei = m2113h;
            }
            if (m2112i != null && !"".equals(m2112i)) {
                thirdAppInfoNew.sImsi = m2112i;
            }
            if (!TextUtils.isEmpty(m2110k)) {
                thirdAppInfoNew.sAndroidID = m2110k;
            }
            if (m2111j != null && !"".equals(m2111j)) {
                thirdAppInfoNew.sMac = m2111j;
            }
            thirdAppInfoNew.iPv = 0L;
            if (QbSdk.getTbsVersion(context) > 0) {
                thirdAppInfoNew.iCoreType = 1;
            } else {
                thirdAppInfoNew.iCoreType = 0;
                thirdAppInfoNew.localCoreVersion = QbSdk.getTbsVersion(context);
            }
            thirdAppInfoNew.sAppVersionName = context.getApplicationInfo().packageName;
            thirdAppInfoNew.sAppSignature = m2379b(context);
            f2233b = thirdAppInfoNew;
        }
        m2386a(f2233b, context, str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0147, code lost:
        if (r20 != false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0 A[Catch: all -> 0x0184, TryCatch #1 {all -> 0x0184, blocks: (B:21:0x0078, B:23:0x00c0, B:24:0x00c2, B:26:0x00c7, B:27:0x00d3, B:29:0x0108, B:31:0x010e, B:33:0x0112, B:35:0x0118, B:36:0x011a, B:38:0x0120, B:40:0x0124, B:42:0x012a, B:43:0x012c, B:46:0x013b, B:48:0x0141, B:50:0x0149, B:51:0x0159, B:53:0x0163, B:54:0x016d, B:57:0x0145, B:58:0x014c, B:61:0x0152, B:65:0x00cd), top: B:20:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c7 A[Catch: all -> 0x0184, TryCatch #1 {all -> 0x0184, blocks: (B:21:0x0078, B:23:0x00c0, B:24:0x00c2, B:26:0x00c7, B:27:0x00d3, B:29:0x0108, B:31:0x010e, B:33:0x0112, B:35:0x0118, B:36:0x011a, B:38:0x0120, B:40:0x0124, B:42:0x012a, B:43:0x012c, B:46:0x013b, B:48:0x0141, B:50:0x0149, B:51:0x0159, B:53:0x0163, B:54:0x016d, B:57:0x0145, B:58:0x014c, B:61:0x0152, B:65:0x00cd), top: B:20:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0120 A[Catch: all -> 0x0184, TryCatch #1 {all -> 0x0184, blocks: (B:21:0x0078, B:23:0x00c0, B:24:0x00c2, B:26:0x00c7, B:27:0x00d3, B:29:0x0108, B:31:0x010e, B:33:0x0112, B:35:0x0118, B:36:0x011a, B:38:0x0120, B:40:0x0124, B:42:0x012a, B:43:0x012c, B:46:0x013b, B:48:0x0141, B:50:0x0149, B:51:0x0159, B:53:0x0163, B:54:0x016d, B:57:0x0145, B:58:0x014c, B:61:0x0152, B:65:0x00cd), top: B:20:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0163 A[Catch: all -> 0x0184, TryCatch #1 {all -> 0x0184, blocks: (B:21:0x0078, B:23:0x00c0, B:24:0x00c2, B:26:0x00c7, B:27:0x00d3, B:29:0x0108, B:31:0x010e, B:33:0x0112, B:35:0x0118, B:36:0x011a, B:38:0x0120, B:40:0x0124, B:42:0x012a, B:43:0x012c, B:46:0x013b, B:48:0x0141, B:50:0x0149, B:51:0x0159, B:53:0x0163, B:54:0x016d, B:57:0x0145, B:58:0x014c, B:61:0x0152, B:65:0x00cd), top: B:20:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cd A[Catch: all -> 0x0184, TryCatch #1 {all -> 0x0184, blocks: (B:21:0x0078, B:23:0x00c0, B:24:0x00c2, B:26:0x00c7, B:27:0x00d3, B:29:0x0108, B:31:0x010e, B:33:0x0112, B:35:0x0118, B:36:0x011a, B:38:0x0120, B:40:0x0124, B:42:0x012a, B:43:0x012c, B:46:0x013b, B:48:0x0141, B:50:0x0149, B:51:0x0159, B:53:0x0163, B:54:0x016d, B:57:0x0145, B:58:0x014c, B:61:0x0152, B:65:0x00cd), top: B:20:0x0078 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m2382a(Context context, String str, String str2, String str3, int i, boolean z, long j, boolean z2) {
        String str4;
        ThirdAppInfoNew thirdAppInfoNew;
        String m2127a;
        String m2111j;
        String m2113h;
        String m2112i;
        String m2110k;
        if (QbSdk.getSettings() != null && QbSdk.getSettings().containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.getSettings().get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m2155i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        int i2 = 0;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (TbsConfig.APP_QQ.equals(applicationInfo.packageName)) {
                str4 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                try {
                    if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                        str4 = str4 + "." + QbSdk.getQQBuildNumber();
                    }
                } catch (Exception e) {
                    e = e;
                    TbsLog.m2152i(e);
                    thirdAppInfoNew = new ThirdAppInfoNew();
                    thirdAppInfoNew.sAppName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().packageName;
                    C1467n.m2018a(context);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                    thirdAppInfoNew.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
                    thirdAppInfoNew.sVersionCode = C1429b.m2116e(context);
                    m2127a = C1429b.m2127a(context, TbsDownloader.TBS_METADATA);
                    if (!TextUtils.isEmpty(m2127a)) {
                    }
                    thirdAppInfoNew.sGuid = str;
                    if (!z) {
                    }
                    thirdAppInfoNew.sLc = str3;
                    m2111j = C1429b.m2111j(context);
                    m2113h = C1429b.m2113h(context);
                    TbsLog.m2155i("sdkreport", "HttpUtils.doReport(): getImeiEnable = " + C1429b.m2114g(context) + " imei is " + m2113h);
                    m2112i = C1429b.m2112i(context);
                    m2110k = C1429b.m2110k(context);
                    if (m2113h != null) {
                        thirdAppInfoNew.sImei = m2113h;
                    }
                    if (m2112i != null) {
                        thirdAppInfoNew.sImsi = m2112i;
                    }
                    if (!TextUtils.isEmpty(m2110k)) {
                    }
                    if (m2111j != null) {
                        thirdAppInfoNew.sMac = m2111j;
                    }
                    thirdAppInfoNew.iPv = i;
                    if (TbsShareManager.isThirdPartyApp(context)) {
                    }
                    TbsLog.m2152i(th);
                }
            } else {
                str4 = "";
            }
        } catch (Exception e2) {
            e = e2;
            str4 = "";
        }
        try {
            thirdAppInfoNew = new ThirdAppInfoNew();
            thirdAppInfoNew.sAppName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().packageName;
            C1467n.m2018a(context);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            thirdAppInfoNew.sTime = simpleDateFormat2.format(Calendar.getInstance().getTime());
            thirdAppInfoNew.sVersionCode = C1429b.m2116e(context);
            m2127a = C1429b.m2127a(context, TbsDownloader.TBS_METADATA);
            if (!TextUtils.isEmpty(m2127a)) {
                thirdAppInfoNew.sMetaData = m2127a;
            }
            thirdAppInfoNew.sGuid = str;
            if (!z) {
                thirdAppInfoNew.sQua2 = str2;
                thirdAppInfoNew.bIsSandboxMode = z2;
            } else {
                thirdAppInfoNew.sQua2 = C1463k.m2039a(context);
            }
            thirdAppInfoNew.sLc = str3;
            m2111j = C1429b.m2111j(context);
            m2113h = C1429b.m2113h(context);
            TbsLog.m2155i("sdkreport", "HttpUtils.doReport(): getImeiEnable = " + C1429b.m2114g(context) + " imei is " + m2113h);
            m2112i = C1429b.m2112i(context);
            m2110k = C1429b.m2110k(context);
            if (m2113h != null && !"".equals(m2113h)) {
                thirdAppInfoNew.sImei = m2113h;
            }
            if (m2112i != null && !"".equals(m2112i)) {
                thirdAppInfoNew.sImsi = m2112i;
            }
            if (!TextUtils.isEmpty(m2110k)) {
                thirdAppInfoNew.sAndroidID = m2110k;
            }
            if (m2111j != null && !"".equals(m2111j)) {
                thirdAppInfoNew.sMac = m2111j;
            }
            thirdAppInfoNew.iPv = i;
            if (TbsShareManager.isThirdPartyApp(context)) {
                if (z) {
                    i2 = 1;
                }
                thirdAppInfoNew.iCoreType = i2;
                if (z && z2) {
                    thirdAppInfoNew.iCoreType = 3;
                }
                thirdAppInfoNew.sAppVersionName = str4;
                thirdAppInfoNew.sAppSignature = m2379b(context);
                if (!z) {
                }
                f2233b = thirdAppInfoNew;
                C1472q.m1981b(context, "pv_report", "");
                C1472q.m1986a(context, "pv_report", "");
                C1472q.m1967m(context);
                m2387a(thirdAppInfoNew, StubApp.getOrigApplicationContext(context.getApplicationContext()));
                return;
            }
            if (!z) {
                thirdAppInfoNew.iCoreType = 0;
            } else if (TbsShareManager.getCoreFormOwn()) {
                thirdAppInfoNew.iCoreType = 2;
            } else {
                thirdAppInfoNew.iCoreType = 1;
            }
            thirdAppInfoNew.sAppVersionName = str4;
            thirdAppInfoNew.sAppSignature = m2379b(context);
            if (!z) {
                thirdAppInfoNew.sWifiConnectedTime = j;
                thirdAppInfoNew.localCoreVersion = QbSdk.getTbsVersion(context);
            }
            f2233b = thirdAppInfoNew;
            C1472q.m1981b(context, "pv_report", "");
            C1472q.m1986a(context, "pv_report", "");
            C1472q.m1967m(context);
            m2387a(thirdAppInfoNew, StubApp.getOrigApplicationContext(context.getApplicationContext()));
            return;
        } catch (Throwable th) {
            TbsLog.m2152i(th);
        }
        TbsLog.m2152i(th);
    }

    /* renamed from: b */
    public static String m2379b(Context context) {
        try {
            byte[] byteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (byteArray != null) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(byteArray);
                byte[] digest = messageDigest.digest();
                if (digest != null) {
                    StringBuilder sb = new StringBuilder("");
                    if (digest.length <= 0) {
                        return null;
                    }
                    for (int i = 0; i < digest.length; i++) {
                        String upperCase = Integer.toHexString(digest[i] & 255).toUpperCase();
                        if (i > 0) {
                            sb.append(":");
                        }
                        if (upperCase.length() < 2) {
                            sb.append(0);
                        }
                        sb.append(upperCase);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            TbsLog.m2152i(e);
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:(14:(1:73)|9|10|11|12|13|(2:14|(1:16)(1:17))|(1:19)(2:33|34)|20|21|22|23|24|25)(1:7)|9|10|11|12|13|(3:14|(0)(0)|16)|(0)(0)|20|21|22|23|24|25) */
    /* JADX WARN: Can't wrap try/catch for region: R(19:1|2|3|(14:(1:73)|9|10|11|12|13|(2:14|(1:16)(1:17))|(1:19)(2:33|34)|20|21|22|23|24|25)(1:7)|8|9|10|11|12|13|(3:14|(0)(0)|16)|(0)(0)|20|21|22|23|24|25|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
        com.tencent.smtt.utils.TbsLog.m2152i(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
        com.tencent.smtt.utils.TbsLog.m2152i(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
        r0 = r4;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
        com.tencent.smtt.utils.TbsLog.m2152i(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
        if (r0 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0094, code lost:
        if (r1 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009e, code lost:
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        com.tencent.smtt.utils.TbsLog.m2152i(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008c, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0090, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0091, code lost:
        com.tencent.smtt.utils.TbsLog.m2152i(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0078, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0079, code lost:
        r0 = r4;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c0, code lost:
        if (r0 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ca, code lost:
        if (r1 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d4, code lost:
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00cc, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d0, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d1, code lost:
        com.tencent.smtt.utils.TbsLog.m2152i(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c2, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c7, code lost:
        com.tencent.smtt.utils.TbsLog.m2152i(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0080, code lost:
        r4 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040 A[Catch: all -> 0x0078, Exception -> 0x007c, LOOP:0: B:14:0x0039->B:16:0x0040, LOOP_END, TryCatch #11 {Exception -> 0x007c, all -> 0x0078, blocks: (B:13:0x0037, B:14:0x0039, B:16:0x0040, B:19:0x0047, B:33:0x0059), top: B:12:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[EDGE_INSN: B:17:0x0045->B:18:0x0045 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[Catch: all -> 0x0078, Exception -> 0x007c, TryCatch #11 {Exception -> 0x007c, all -> 0x0078, blocks: (B:13:0x0037, B:14:0x0039, B:16:0x0040, B:19:0x0047, B:33:0x0059), top: B:12:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0059 A[Catch: all -> 0x0078, Exception -> 0x007c, TRY_LEAVE, TryCatch #11 {Exception -> 0x007c, all -> 0x0078, blocks: (B:13:0x0037, B:14:0x0039, B:16:0x0040, B:19:0x0047, B:33:0x0059), top: B:12:0x0037 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m2376b(HttpURLConnection httpURLConnection, String str, boolean z) {
        InputStream inputStream;
        String contentEncoding;
        InputStream inflaterInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        int read;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            contentEncoding = httpURLConnection.getContentEncoding();
        } catch (Exception e) {
            e = e;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                if (contentEncoding != null && contentEncoding.equalsIgnoreCase("deflate")) {
                    inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                }
                byteArrayOutputStream = new ByteArrayOutputStream();
                bArr = new byte[128];
                while (true) {
                    read = inputStream.read(bArr);
                    if (read != -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String str2 = !z ? new String(C1458g.m2067a().m2060c(byteArrayOutputStream.toByteArray())) : new String(C1458g.m2062b(byteArrayOutputStream.toByteArray(), str));
                byteArrayOutputStream.close();
                inputStream.close();
                TbsLog.m2155i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
                return str2;
            }
            inflaterInputStream = new GZIPInputStream(inputStream);
            byteArrayOutputStream = new ByteArrayOutputStream();
            bArr = new byte[128];
            while (true) {
                read = inputStream.read(bArr);
                if (read != -1) {
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            if (!z) {
            }
            byteArrayOutputStream.close();
            inputStream.close();
            TbsLog.m2155i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
            return str2;
        } catch (Throwable th2) {
            th = th2;
        }
        inputStream = inflaterInputStream;
    }

    /* renamed from: b */
    public static void m2378b(Context context, String str) {
        try {
            TbsPVConfig.releaseInstance();
            TbsPVConfig.getInstance(context).clear();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (String str2 : str.split("\\|")) {
                try {
                    String[] split = str2.split("=");
                    if (split.length == 2) {
                        m2377b(context, split[0], split[1]);
                    }
                } catch (Exception e) {
                    TbsLog.m2152i(e);
                }
            }
            TbsPVConfig.getInstance(context).commit();
        } catch (Exception e2) {
            TbsLog.m2152i(e2);
        }
    }

    /* renamed from: b */
    public static void m2377b(Context context, String str, String str2) {
        if ("reset".equals(str) && "true".equals(str2)) {
            QbSdk.reset(context);
        } else if (!str.startsWith("rmfile")) {
            TbsPVConfig.getInstance(context).putData(str, str2);
        } else {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("tbs_status", 0);
                if (sharedPreferences.getBoolean(str, false)) {
                    return;
                }
                File file = new File(str2);
                if (str2 != null && file.exists()) {
                    TbsLog.m2155i("HttpUtils", "received command,delete" + str2);
                    FileUtil.m2175b(file);
                }
                sharedPreferences.edit().putBoolean(str, true).apply();
            } catch (Exception e) {
                TbsLog.m2152i(e);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:1|2|3|4|(18:11|(1:13)(1:50)|14|15|(1:17)|18|19|(2:21|(1:23))(1:49)|24|25|(1:27)(1:48)|28|(1:30)|31|33|34|(4:36|37|(1:39)(2:42|(1:44))|40)|45)|51|14|15|(0)|18|19|(0)(0)|24|25|(0)(0)|28|(0)|31|33|34|(0)|45|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f3 A[Catch: Exception -> 0x019b, TryCatch #0 {Exception -> 0x019b, blocks: (B:3:0x0006, B:6:0x0079, B:8:0x0081, B:11:0x008c, B:14:0x0092, B:15:0x00d5, B:17:0x00f3, B:18:0x00f8, B:21:0x010d, B:23:0x0123, B:24:0x013b, B:27:0x0151, B:30:0x0163, B:31:0x0168, B:48:0x015d, B:49:0x012b, B:50:0x0096, B:51:0x0099), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x010d A[Catch: Exception -> 0x019b, TRY_ENTER, TryCatch #0 {Exception -> 0x019b, blocks: (B:3:0x0006, B:6:0x0079, B:8:0x0081, B:11:0x008c, B:14:0x0092, B:15:0x00d5, B:17:0x00f3, B:18:0x00f8, B:21:0x010d, B:23:0x0123, B:24:0x013b, B:27:0x0151, B:30:0x0163, B:31:0x0168, B:48:0x015d, B:49:0x012b, B:50:0x0096, B:51:0x0099), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0151 A[Catch: Exception -> 0x019b, TRY_ENTER, TryCatch #0 {Exception -> 0x019b, blocks: (B:3:0x0006, B:6:0x0079, B:8:0x0081, B:11:0x008c, B:14:0x0092, B:15:0x00d5, B:17:0x00f3, B:18:0x00f8, B:21:0x010d, B:23:0x0123, B:24:0x013b, B:27:0x0151, B:30:0x0163, B:31:0x0168, B:48:0x015d, B:49:0x012b, B:50:0x0096, B:51:0x0099), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0163 A[Catch: Exception -> 0x019b, TryCatch #0 {Exception -> 0x019b, blocks: (B:3:0x0006, B:6:0x0079, B:8:0x0081, B:11:0x008c, B:14:0x0092, B:15:0x00d5, B:17:0x00f3, B:18:0x00f8, B:21:0x010d, B:23:0x0123, B:24:0x013b, B:27:0x0151, B:30:0x0163, B:31:0x0168, B:48:0x015d, B:49:0x012b, B:50:0x0096, B:51:0x0099), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0175 A[Catch: Exception -> 0x019a, TRY_LEAVE, TryCatch #1 {Exception -> 0x019a, blocks: (B:34:0x016f, B:36:0x0175, B:39:0x0182, B:40:0x0186, B:42:0x018d, B:44:0x0195), top: B:33:0x016f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015d A[Catch: Exception -> 0x019b, TryCatch #0 {Exception -> 0x019b, blocks: (B:3:0x0006, B:6:0x0079, B:8:0x0081, B:11:0x008c, B:14:0x0092, B:15:0x00d5, B:17:0x00f3, B:18:0x00f8, B:21:0x010d, B:23:0x0123, B:24:0x013b, B:27:0x0151, B:30:0x0163, B:31:0x0168, B:48:0x015d, B:49:0x012b, B:50:0x0096, B:51:0x0099), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b A[Catch: Exception -> 0x019b, TryCatch #0 {Exception -> 0x019b, blocks: (B:3:0x0006, B:6:0x0079, B:8:0x0081, B:11:0x008c, B:14:0x0092, B:15:0x00d5, B:17:0x00f3, B:18:0x00f8, B:21:0x010d, B:23:0x0123, B:24:0x013b, B:27:0x0151, B:30:0x0163, B:31:0x0168, B:48:0x015d, B:49:0x012b, B:50:0x0096, B:51:0x0099), top: B:2:0x0006 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject m2375c(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        String str;
        String m2385a;
        int i;
        String tid;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", thirdAppInfoNew.sAppName);
            jSONObject.put("TIME", thirdAppInfoNew.sTime);
            jSONObject.put("QUA2", thirdAppInfoNew.sQua2);
            jSONObject.put("LC", thirdAppInfoNew.sLc);
            jSONObject.put("GUID", thirdAppInfoNew.sGuid);
            jSONObject.put("IMEI", thirdAppInfoNew.sImei);
            jSONObject.put("IMSI", thirdAppInfoNew.sImsi);
            jSONObject.put("MAC", thirdAppInfoNew.sMac);
            jSONObject.put("PV", thirdAppInfoNew.iPv);
            jSONObject.put("CORETYPE", thirdAppInfoNew.iCoreType);
            jSONObject.put("APPVN", thirdAppInfoNew.sAppVersionName);
            jSONObject.put("APPMETADATA", thirdAppInfoNew.sMetaData);
            jSONObject.put("VERSION_CODE", thirdAppInfoNew.sVersionCode);
            jSONObject.put("CPU", thirdAppInfoNew.sCpu);
            if (!TbsConfig.APP_WX.equals(thirdAppInfoNew.sAppName) && !TbsConfig.APP_QQ.equals(thirdAppInfoNew.sAppName) && !TbsConfig.APP_DEMO.equals(thirdAppInfoNew.sAppName)) {
                str = thirdAppInfoNew.sAppSignature == null ? "0" : thirdAppInfoNew.sAppSignature;
                jSONObject.put("SIGNATURE", str);
                m2385a = m2385a(context);
                TbsLog.m2155i("sdkreport", "addInfo is " + m2385a);
                if (!TextUtils.isEmpty(m2385a)) {
                    jSONObject.put("EXT_INFO", m2385a);
                }
                jSONObject.put("PROTOCOL_VERSION", 3);
                jSONObject.put("ANDROID_ID", thirdAppInfoNew.sAndroidID);
                if (TbsShareManager.isThirdPartyApp(context)) {
                    jSONObject.put("HOST_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(context));
                    jSONObject.put("DECOUPLE_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(context));
                } else if (!"com.xunmeng.pinduoduo".equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().packageName)) {
                    jSONObject.put("HOST_COREVERSION", TbsShareManager.getHostCoreVersions(context));
                }
                jSONObject.put("WIFICONNECTEDTIME", thirdAppInfoNew.sWifiConnectedTime);
                jSONObject.put("CORE_EXIST", thirdAppInfoNew.localCoreVersion);
                i = TbsCoreLoadStat.mLoadErrorCode;
                if (thirdAppInfoNew.localCoreVersion > 0) {
                    jSONObject.put("TBS_ERROR_CODE", TbsDownloadConfig.getInstance(context).getDownloadInterruptCode());
                } else {
                    jSONObject.put("TBS_ERROR_CODE", i);
                }
                if (i == -1) {
                    TbsLog.m2158e("sdkreport", "ATTENTION: Load errorCode missed!");
                }
                TbsDownloadConfig.getInstance(context).uploadDownloadInterruptCodeIfNeeded(context);
                if (QbSdk.getTID() != null) {
                    if (thirdAppInfoNew.sAppName.equals(TbsConfig.APP_QQ)) {
                        tid = QbSdk.getTID();
                    } else if (thirdAppInfoNew.sAppName.equals(TbsConfig.APP_WX)) {
                        tid = QbSdk.getTID();
                    }
                    jSONObject.put("TID", tid);
                    jSONObject.put("TIDTYPE", 0);
                }
                return jSONObject;
            }
            TbsDownloadUpload tbsDownloadUpload = new TbsDownloadUpload(context);
            tbsDownloadUpload.readTbsDownloadInfo(context);
            str = "" + tbsDownloadUpload.getNeedDownloadCode() + ":" + tbsDownloadUpload.getStartDownloadCode() + ":" + tbsDownloadUpload.getNeedDownloadReturn() + ":" + tbsDownloadUpload.getLocalCoreVersion();
            jSONObject.put("SIGNATURE", str);
            m2385a = m2385a(context);
            TbsLog.m2155i("sdkreport", "addInfo is " + m2385a);
            if (!TextUtils.isEmpty(m2385a)) {
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", thirdAppInfoNew.sAndroidID);
            if (TbsShareManager.isThirdPartyApp(context)) {
            }
            jSONObject.put("WIFICONNECTEDTIME", thirdAppInfoNew.sWifiConnectedTime);
            jSONObject.put("CORE_EXIST", thirdAppInfoNew.localCoreVersion);
            i = TbsCoreLoadStat.mLoadErrorCode;
            if (thirdAppInfoNew.localCoreVersion > 0) {
            }
            if (i == -1) {
            }
            TbsDownloadConfig.getInstance(context).uploadDownloadInterruptCodeIfNeeded(context);
            if (QbSdk.getTID() != null) {
            }
            return jSONObject;
        } catch (Exception unused) {
            TbsLog.m2158e("sdkreport", "getPostData exception!");
            return null;
        }
    }
}
