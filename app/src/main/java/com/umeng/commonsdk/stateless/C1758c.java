package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.C1767b;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* renamed from: com.umeng.commonsdk.stateless.c */
/* loaded from: classes4.dex */
public class C1758c {

    /* renamed from: a */
    public String f4010a = "10.0.0.172";

    /* renamed from: b */
    public int f4011b = 80;

    /* renamed from: c */
    public Context f4012c;

    public C1758c(Context context) {
        this.f4012c = context;
    }

    /* renamed from: a */
    private void m623a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f4012c, "sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            C1753a.f3993i = DataHelper.assembleStatelessURL(imprintProperty);
        }
    }

    /* renamed from: b */
    private void m621b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f4012c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f4012c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            C1753a.f3992h = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            C1753a.f3995k = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        C1753a.f3993i = C1753a.f3995k;
        if (!TextUtils.isEmpty(C1767b.f4021b)) {
            if (!C1767b.f4021b.startsWith("460") && !C1767b.f4021b.startsWith("461")) {
                return;
            }
            C1753a.f3993i = C1753a.f3992h;
        }
    }

    /* renamed from: c */
    private boolean m620c() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        Context context = this.f4012c;
        if (context == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f4012c.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f4012c.getSystemService("connectivity");
            if (DeviceConfig.checkPermission(this.f4012c, "android.permission.ACCESS_NETWORK_STATE") && connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                    if (extraInfo.equals("uniwap")) {
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f4012c, th);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0135, code lost:
        if (r13 == null) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [javax.net.ssl.HttpsURLConnection, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m622a(byte[] bArr, String str, String str2, String str3) {
        HttpsURLConnection httpsURLConnection;
        URLConnection openConnection;
        boolean z = false;
        if (bArr == null || str == null) {
            ULog.m535i("walle", "[stateless] sendMessage, envelopeByte == null || path == null ");
            return false;
        }
        if (SdkVersion.SDK_TYPE == 0) {
            m623a();
        } else {
            C1753a.f3992h = C1753a.f3995k;
            m621b();
        }
        String str4 = C1753a.f3993i;
        boolean isEmpty = TextUtils.isEmpty(str2);
        ?? r13 = str2;
        if (isEmpty) {
            r13 = str4;
        }
        OutputStream outputStream = null;
        try {
            try {
                if (m620c()) {
                    openConnection = new URL(((String) r13) + File.separator + str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f4010a, this.f4011b)));
                } else {
                    openConnection = new URL(((String) r13) + File.separator + str).openConnection();
                }
                httpsURLConnection = (HttpsURLConnection) openConnection;
                try {
                    httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, null, new SecureRandom());
                    httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("Content-Type", C1543ak.f2979aP + str3);
                    httpsURLConnection.setConnectTimeout(BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH);
                    httpsURLConnection.setReadTimeout(BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    httpsURLConnection.connect();
                    if (httpsURLConnection.getResponseCode() == 200) {
                        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> send stateless message success : " + C1753a.f3993i + "/" + str);
                        z = true;
                    }
                    try {
                        outputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (SSLHandshakeException e) {
                    e = e;
                    MLog.m572e("SSLHandshakeException, Failed to send message.", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    MLog.m572e("Exception,Failed to send message.", th);
                }
            } finally {
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                if (r13 != 0) {
                    try {
                        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                        r13.disconnect();
                    } catch (Throwable unused4) {
                    }
                }
            }
        } catch (SSLHandshakeException e2) {
            e = e2;
            httpsURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            httpsURLConnection = null;
        }
        try {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
            httpsURLConnection.disconnect();
        } catch (Throwable unused5) {
            return z;
        }
    }
}
