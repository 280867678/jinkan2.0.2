package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.C1642l;
import com.umeng.analytics.pro.C1648o;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C1724a;
import com.umeng.commonsdk.internal.C1725b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.C1767b;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.C1847b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import me.tvspark.outline;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* renamed from: com.umeng.commonsdk.statistics.internal.c */
/* loaded from: classes4.dex */
public class C1799c {

    /* renamed from: e */
    public static boolean f4124e;

    /* renamed from: f */
    public static boolean f4125f;

    /* renamed from: g */
    public static boolean f4126g;

    /* renamed from: a */
    public String f4127a = "10.0.0.172";

    /* renamed from: b */
    public int f4128b = 80;

    /* renamed from: c */
    public Context f4129c;

    /* renamed from: d */
    public AbstractC1798b f4130d;

    public C1799c(Context context) {
        this.f4129c = context;
    }

    /* renamed from: a */
    private void m425a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f4129c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f4129c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    /* renamed from: b */
    private void m420b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f4129c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f4129c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        String imprintProperty3 = UMEnvelopeBuild.imprintProperty(this.f4129c, "oversea_domain_p", "");
        String imprintProperty4 = UMEnvelopeBuild.imprintProperty(this.f4129c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(imprintProperty3);
        }
        if (!TextUtils.isEmpty(imprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(imprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (!TextUtils.isEmpty(C1767b.f4021b)) {
            if (!C1767b.f4021b.startsWith("460") && !C1767b.f4021b.startsWith("461")) {
                return;
            }
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    /* renamed from: c */
    private void m419c() {
        if (!f4126g) {
            ImprintHandler.getImprintService(this.f4129c).registImprintCallback("cfgfd", new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
                @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                public void onImprintValueChanged(String str, String str2) {
                    if (FieldManager.m790b()) {
                        FieldManager.m794a().m792a(C1799c.this.f4129c, str2);
                        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                        UMWorkDispatch.sendEvent(C1799c.this.f4129c, C1724a.f3921w, C1725b.m729a(C1799c.this.f4129c).m730a(), null);
                    }
                }
            });
            f4126g = true;
        }
    }

    /* renamed from: d */
    private void m418d() {
        if (!f4125f) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
            ImprintHandler.getImprintService(this.f4129c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
                @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
                public boolean onPreProcessImprintKey(String str, String str2) {
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                    FieldManager.m794a().m793a(C1799c.this.f4129c);
                    UMWorkDispatch.sendEvent(C1799c.this.f4129c, C1724a.f3917s, C1725b.m729a(C1799c.this.f4129c).m730a(), null);
                    ImprintHandler.getImprintService(C1799c.this.f4129c).m481a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                    return true;
                }
            });
            ImprintHandler.getImprintService(this.f4129c).registImprintCallback("cfgfd", new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.3
                @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                public void onImprintValueChanged(String str, String str2) {
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                    FieldManager.m794a().m792a(C1799c.this.f4129c, str2);
                    UMWorkDispatch.sendEvent(C1799c.this.f4129c, C1724a.f3917s, C1725b.m729a(C1799c.this.f4129c).m730a(), null);
                    if (FieldManager.allow(C1847b.f4254E)) {
                        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                        if (!UMWorkDispatch.eventHasExist()) {
                            UMWorkDispatch.sendEventEx(C1799c.this.f4129c, C1648o.C1650a.f3581C, CoreProtocol.getInstance(C1799c.this.f4129c), null, 0L);
                        }
                    }
                    if (FieldManager.allow(C1847b.f4255F)) {
                        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                        C1642l.m1019a(C1799c.this.f4129c).m1012b(C1799c.this.f4129c);
                    }
                    ImprintHandler.getImprintService(C1799c.this.f4129c).unregistImprintCallback("cfgfd", this);
                }
            });
            f4125f = true;
        }
    }

    /* renamed from: e */
    private boolean m417e() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (this.f4129c.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f4129c.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f4129c.getSystemService("connectivity");
            if (DeviceConfig.checkPermission(this.f4129c, "android.permission.ACCESS_NETWORK_STATE") && connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                    if (extraInfo.equals("uniwap")) {
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f4129c, th);
        }
        return false;
    }

    /* renamed from: a */
    public void m424a(AbstractC1798b abstractC1798b) {
        this.f4130d = abstractC1798b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x017e: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:111:0x018a, block:B:110:0x017e */
    /* renamed from: a */
    public byte[] m422a(byte[] bArr, String str) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        URLConnection openConnection;
        try {
            try {
                if (this.f4130d != null) {
                    this.f4130d.onRequestStart();
                }
                if (m417e()) {
                    openConnection = new URL(str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f4127a, this.f4128b)));
                } else {
                    openConnection = new URL(str).openConnection();
                }
                httpsURLConnection = (HttpsURLConnection) openConnection;
                try {
                    boolean z = true;
                    if (!f4124e) {
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        f4124e = true;
                    }
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("X-Umeng-Sdk", C1795a.m434a(this.f4129c).m432b());
                    httpsURLConnection.setRequestProperty("Content-Type", C1795a.m434a(this.f4129c).m435a());
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                    httpsURLConnection.setConnectTimeout(BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH);
                    httpsURLConnection.setReadTimeout(BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                    try {
                        outputStream.write(bArr);
                        outputStream.flush();
                        httpsURLConnection.connect();
                        if (this.f4130d != null) {
                            this.f4130d.onRequestEnd();
                        }
                        int responseCode = httpsURLConnection.getResponseCode();
                        String headerField = httpsURLConnection.getHeaderField("Content-Type");
                        if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                            z = false;
                        }
                        boolean z2 = AnalyticsConstants.UM_DEBUG;
                        if (responseCode != 200 || !z) {
                            try {
                                outputStream.close();
                            } catch (Exception e) {
                                UMCrashManager.reportCrash(this.f4129c, e);
                            }
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException unused) {
                            }
                            httpsURLConnection.disconnect();
                            return null;
                        }
                        InputStream inputStream = httpsURLConnection.getInputStream();
                        try {
                            byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                            try {
                                outputStream.close();
                            } catch (Exception e2) {
                                UMCrashManager.reportCrash(this.f4129c, e2);
                            }
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException unused2) {
                            }
                            httpsURLConnection.disconnect();
                            return readStreamToByteArray;
                        } finally {
                            HelperUtils.safeClose(inputStream);
                        }
                    } catch (UnknownHostException unused3) {
                        UMLog.m773aq("A_10200", 2, "\\|");
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e3) {
                                UMCrashManager.reportCrash(this.f4129c, e3);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException unused4) {
                            }
                            httpsURLConnection.disconnect();
                        }
                        return null;
                    } catch (SSLHandshakeException unused5) {
                        UMLog.m773aq("A_10201", 2, "\\|");
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e4) {
                                UMCrashManager.reportCrash(this.f4129c, e4);
                            }
                        }
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.getInputStream().close();
                            } catch (IOException unused6) {
                            }
                            httpsURLConnection.disconnect();
                        }
                        return null;
                    } catch (Throwable unused7) {
                        return null;
                    }
                } catch (UnknownHostException unused8) {
                    outputStream = null;
                } catch (SSLHandshakeException unused9) {
                    outputStream = null;
                } catch (Throwable unused10) {
                    outputStream = null;
                }
            } finally {
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (Exception e5) {
                        UMCrashManager.reportCrash(this.f4129c, e5);
                    }
                }
                if (str != 0) {
                    try {
                        str.getInputStream().close();
                    } catch (IOException unused11) {
                    }
                    str.disconnect();
                }
            }
        } catch (UnknownHostException unused12) {
            httpsURLConnection = null;
            outputStream = null;
        } catch (SSLHandshakeException unused13) {
            httpsURLConnection = null;
            outputStream = null;
        } catch (Throwable unused14) {
            httpsURLConnection = null;
            outputStream = null;
        }
    }

    /* renamed from: a */
    public byte[] m421a(byte[] bArr, boolean z, boolean z2, String str) {
        if (SdkVersion.SDK_TYPE == 0) {
            m425a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            m420b();
        }
        int i = 0;
        byte[] bArr2 = null;
        while (true) {
            String[] strArr = AnalyticsConstants.APPLOG_URL_LIST;
            if (i >= strArr.length) {
                break;
            }
            String str2 = strArr[i];
            if (z2) {
                m418d();
            } else {
                m419c();
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(File.separator);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
            bArr2 = m422a(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            if (bArr2 != null) {
                AbstractC1798b abstractC1798b = this.f4130d;
                if (abstractC1798b != null) {
                    abstractC1798b.onRequestSucceed(z);
                }
            } else {
                AbstractC1798b abstractC1798b2 = this.f4130d;
                if (abstractC1798b2 != null) {
                    abstractC1798b2.onRequestFailed();
                }
                i++;
            }
        }
        return bArr2;
    }
}
