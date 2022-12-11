package me.tvspark;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public class ir0 {
    public static final HostnameVerifier Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Map<String, List<String>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Map<String, List<String>> map) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = map;
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hashMap;
        hashMap.put("User-Agent", ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwww);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Map<String, String> map, int i) throws IOException {
        HttpsURLConnection httpsURLConnection;
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                if (url.getProtocol().toUpperCase().equals("HTTPS")) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                    httpsURLConnection2.setHostnameVerifier(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    httpsURLConnection = httpsURLConnection2;
                } else {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                HttpURLConnection httpURLConnection2 = httpsURLConnection;
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(10000);
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
                int responseCode = httpURLConnection2.getResponseCode();
                try {
                    httpURLConnection2.getInputStream().close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                httpURLConnection2.disconnect();
                if (responseCode != 302 && responseCode != 301) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, headerFields);
                    try {
                        httpURLConnection2.getInputStream().close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    httpURLConnection2.disconnect();
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                if (i >= 4) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, new HashMap());
                    try {
                        httpURLConnection2.getInputStream().close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    httpURLConnection2.disconnect();
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
                List<String> list = headerFields.get("Location");
                if (list == null || list.isEmpty()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, headerFields);
                    try {
                        httpURLConnection2.getInputStream().close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    httpURLConnection2.disconnect();
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list.get(0), map, i + 1);
                try {
                    httpURLConnection2.getInputStream().close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                httpURLConnection2.disconnect();
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        httpURLConnection.getInputStream().close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IndexOutOfBoundsException unused) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, new HashMap());
            if (0 != 0) {
                try {
                    httpURLConnection.getInputStream().close();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
                httpURLConnection.disconnect();
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        } catch (Exception unused2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, new HashMap());
            if (0 != 0) {
                try {
                    httpURLConnection.getInputStream().close();
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
                httpURLConnection.disconnect();
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        TrustManager[] trustManagerArr = {new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
