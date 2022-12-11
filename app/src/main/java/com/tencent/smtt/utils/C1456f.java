package com.tencent.smtt.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.eclipse.jetty.http.HttpHeaderValues;

/* renamed from: com.tencent.smtt.utils.f */
/* loaded from: classes4.dex */
public class C1456f {

    /* renamed from: com.tencent.smtt.utils.f$a */
    /* loaded from: classes4.dex */
    public interface AbstractC1457a {
        /* renamed from: a */
        void mo2068a(int i);
    }

    /* renamed from: a */
    public static String m2073a(String str, Map<String, String> map, byte[] bArr, AbstractC1457a abstractC1457a, boolean z) {
        HttpURLConnection m2074a;
        if (bArr == null || (m2074a = m2074a(str, map)) == null) {
            return null;
        }
        if (z) {
            m2070a(m2074a, bArr);
        } else {
            m2069b(m2074a, bArr);
        }
        return m2071a(m2074a, abstractC1457a, false);
    }

    /* renamed from: a */
    public static String m2072a(String str, byte[] bArr, AbstractC1457a abstractC1457a, boolean z) {
        try {
            String str2 = str + (z ? C1459h.m2057a().m2053c() : C1458g.m2067a().m2064b());
            try {
                bArr = z ? C1459h.m2057a().m2056a(bArr) : C1458g.m2067a().m2066a(bArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (bArr == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Content-Length", String.valueOf(bArr.length));
            HttpURLConnection m2074a = m2074a(str2, hashMap);
            if (m2074a == null) {
                return null;
            }
            m2069b(m2074a, bArr);
            return m2071a(m2074a, abstractC1457a, z);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004d A[Catch: all -> 0x0073, LOOP:0: B:19:0x0046->B:21:0x004d, LOOP_END, TryCatch #0 {all -> 0x0073, blocks: (B:18:0x0044, B:19:0x0046, B:21:0x004d, B:24:0x0054, B:29:0x0061), top: B:17:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052 A[EDGE_INSN: B:22:0x0052->B:23:0x0052 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:18:0x0044, B:19:0x0046, B:21:0x004d, B:24:0x0054, B:29:0x0061), top: B:17:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0061 A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:18:0x0044, B:19:0x0046, B:21:0x004d, B:24:0x0054, B:29:0x0061), top: B:17:0x0044 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m2071a(HttpURLConnection httpURLConnection, AbstractC1457a abstractC1457a, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str;
        InputStream inflaterInputStream;
        byte[] bArr;
        int read;
        InputStream inputStream2 = null;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (abstractC1457a != null) {
                abstractC1457a.mo2068a(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream3 = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                try {
                    try {
                        if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                            if (contentEncoding != null && contentEncoding.equalsIgnoreCase("deflate")) {
                                inflaterInputStream = new InflaterInputStream(inputStream3, new Inflater(true));
                            }
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                            bArr = new byte[128];
                            while (true) {
                                read = inputStream3.read(bArr);
                                if (read != -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr, 0, read);
                            }
                            str = !z ? new String(byteArrayOutputStream2.toByteArray(), "utf-8") : new String(C1458g.m2067a().m2060c(byteArrayOutputStream2.toByteArray()));
                            inputStream2 = inputStream3;
                        } else {
                            inflaterInputStream = new GZIPInputStream(inputStream3);
                        }
                        bArr = new byte[128];
                        while (true) {
                            read = inputStream3.read(bArr);
                            if (read != -1) {
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        if (!z) {
                        }
                        inputStream2 = inputStream3;
                    } catch (Throwable th) {
                        InputStream inputStream4 = inputStream3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        th = th;
                        inputStream = inputStream4;
                        try {
                            th.printStackTrace();
                            return null;
                        } finally {
                            m2075a(inputStream);
                            m2075a(byteArrayOutputStream);
                        }
                    }
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream3;
                    byteArrayOutputStream = null;
                }
                inputStream3 = inflaterInputStream;
            } else {
                byteArrayOutputStream2 = null;
                str = null;
            }
            m2075a(inputStream2);
            m2075a(byteArrayOutputStream2);
            return str;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            inputStream = null;
        }
    }

    /* renamed from: a */
    public static HttpURLConnection m2074a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e) {
            e = e;
        }
        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setRequestProperty("Connection", HttpHeaderValues.CLOSE);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            return httpURLConnection;
        } catch (Exception e2) {
            e = e2;
            httpURLConnection2 = httpURLConnection;
            e.printStackTrace();
            return httpURLConnection2;
        }
    }

    /* renamed from: a */
    public static void m2075a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m2070a(HttpURLConnection httpURLConnection, byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream(), 204800));
            try {
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.flush();
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    m2075a(null);
                    m2075a(gZIPOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                m2075a(null);
                m2075a(gZIPOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            gZIPOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream = null;
            m2075a(null);
            m2075a(gZIPOutputStream);
            throw th;
        }
        m2075a(null);
        m2075a(gZIPOutputStream);
    }

    /* renamed from: b */
    public static void m2069b(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = null;
        try {
            try {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            m2075a(outputStream);
        }
    }
}
