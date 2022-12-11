package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.C1141b;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.proguard.O */
/* loaded from: classes3.dex */
public class C1191O {

    /* renamed from: a */
    public static C1191O f1405a;

    /* renamed from: b */
    public Context f1406b;

    /* renamed from: c */
    public Map<String, String> f1407c = null;

    public C1191O(Context context) {
        this.f1406b = context;
    }

    /* renamed from: a */
    public static C1191O m3127a(Context context) {
        if (f1405a == null) {
            f1405a = new C1191O(context);
        }
        return f1405a;
    }

    /* renamed from: a */
    public static void m3129a() {
        TrustManager[] trustManagerArr = {new C1190N()};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private Map<String, String> m3122b(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list.size() >= 1) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public HttpURLConnection m3126a(String str, String str2) {
        URLConnection openConnection;
        try {
            URL url = new URL(str2);
            if (C1200Y.m3074a() != null) {
                openConnection = url.openConnection(C1200Y.m3074a());
            } else if (str == null || !str.toLowerCase(Locale.US).contains("wap")) {
                openConnection = url.openConnection();
            } else {
                openConnection = url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setConnectTimeout(BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public HttpURLConnection m3124a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            C1199X.m3081b("destUrl is null.", new Object[0]);
            return null;
        }
        m3129a();
        HttpURLConnection m3126a = m3126a(str2, str);
        if (m3126a == null) {
            C1199X.m3081b("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            m3126a.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    m3126a.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            }
            m3126a.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            m3126a.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = m3126a.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return m3126a;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            C1199X.m3081b("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public boolean m3128a(int i) {
        return i == 301 || i == 302 || i == 303 || i == 307;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0164, code lost:
        if (com.tencent.bugly.proguard.C1199X.m3080b(r10) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0166, code lost:
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0149, code lost:
        if (com.tencent.bugly.proguard.C1199X.m3080b(r10) != false) goto L21;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] m3125a(String str, byte[] bArr, RunnableC1196U runnableC1196U, Map<String, String> map) {
        Throwable th;
        int i;
        byte[] bArr2 = null;
        if (str == null) {
            C1199X.m3081b("Failed for no URL.", new Object[0]);
            return null;
        }
        long length = bArr == null ? 0L : bArr.length;
        C1199X.m3084a("request: %s, send: %d (pid=%d | tid=%d)", str, Long.valueOf(length), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        String str2 = str;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        for (int i5 = 1; i3 < i5 && i4 < i5; i5 = 1) {
            if (z) {
                z = false;
            } else {
                i3++;
                if (i3 > i5) {
                    C1199X.m3084a(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("try time: ", i3), new Object[i2]);
                    SystemClock.sleep(new Random(System.currentTimeMillis()).nextInt(10000) + 10000);
                }
            }
            String m3374c = C1141b.m3374c(this.f1406b);
            if (m3374c == null) {
                C1199X.m3076e("Failed to request for network not avail", new Object[i2]);
                i = i2;
            } else {
                runnableC1196U.m3095a(str2, length, m3374c);
                HttpURLConnection m3124a = m3124a(str2, bArr, m3374c, map);
                if (m3124a != null) {
                    try {
                        try {
                            int responseCode = m3124a.getResponseCode();
                            if (responseCode == 200) {
                                this.f1407c = m3122b(m3124a);
                                byte[] m3123a = m3123a(m3124a);
                                runnableC1196U.m3099a(m3123a == null ? 0L : m3123a.length);
                                try {
                                    m3124a.disconnect();
                                } catch (Throwable th2) {
                                    if (!C1199X.m3080b(th2)) {
                                        th2.printStackTrace();
                                    }
                                }
                                return m3123a;
                            }
                            if (m3128a(responseCode)) {
                                try {
                                    String headerField = m3124a.getHeaderField("Location");
                                    if (headerField == null) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Failed to redirect: %d");
                                        sb.append(responseCode);
                                        C1199X.m3081b(sb.toString(), new Object[0]);
                                        try {
                                            m3124a.disconnect();
                                            return null;
                                        } catch (Throwable th3) {
                                            if (C1199X.m3080b(th3)) {
                                                return null;
                                            }
                                            th3.printStackTrace();
                                            return null;
                                        }
                                    }
                                    i4++;
                                    try {
                                        C1199X.m3084a("redirect code: %d ,to:%s", Integer.valueOf(responseCode), headerField);
                                        i3 = 0;
                                        str2 = headerField;
                                        z = true;
                                    } catch (IOException e) {
                                        e = e;
                                        i3 = 0;
                                        str2 = headerField;
                                        z = true;
                                        if (!C1199X.m3080b(e)) {
                                            e.printStackTrace();
                                        }
                                        try {
                                            m3124a.disconnect();
                                        } catch (Throwable th4) {
                                            th = th4;
                                        }
                                        bArr2 = null;
                                        i = 0;
                                        i2 = i;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                }
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("response code ");
                            sb2.append(responseCode);
                            C1199X.m3076e(sb2.toString(), new Object[0]);
                            long contentLength = m3124a.getContentLength();
                            if (contentLength < 0) {
                                contentLength = 0;
                            }
                            runnableC1196U.m3099a(contentLength);
                            try {
                                m3124a.disconnect();
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (Throwable th6) {
                            try {
                                m3124a.disconnect();
                            } catch (Throwable th7) {
                                if (!C1199X.m3080b(th7)) {
                                    th7.printStackTrace();
                                }
                            }
                            throw th6;
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                } else {
                    C1199X.m3084a("Failed to execute post.", new Object[0]);
                    runnableC1196U.m3099a(0L);
                }
                bArr2 = null;
                i = 0;
            }
            i2 = i;
        }
        return bArr2;
    }

    /* renamed from: a */
    public byte[] m3123a(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!C1199X.m3080b(th)) {
                        th.printStackTrace();
                    }
                    return null;
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }
}
