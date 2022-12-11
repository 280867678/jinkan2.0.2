package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* renamed from: com.umeng.umzid.a */
/* loaded from: classes4.dex */
public class C1859a {

    /* renamed from: com.umeng.umzid.a$a */
    /* loaded from: classes4.dex */
    public static class C1860a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (!TextUtils.isEmpty(str)) {
                return "aaid.umeng.com".equalsIgnoreCase(str) || "pre-aaid.umeng.com".equalsIgnoreCase(str);
            }
            return false;
        }
    }

    /* renamed from: a */
    public static SharedPreferences m205a(Context context) {
        if (context != null) {
            return context.getSharedPreferences("umzid_general_config", 0);
        }
        return null;
    }

    /* renamed from: a */
    public static synchronized String m204a(String str, String str2) {
        synchronized (C1859a.class) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                httpsURLConnection.setHostnameVerifier(new C1860a());
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setRequestProperty("Content-Type", "application/json");
                httpsURLConnection.setConnectTimeout(BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH);
                httpsURLConnection.setReadTimeout(BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                outputStream.write(str2.getBytes());
                outputStream.flush();
                outputStream.close();
                if (httpsURLConnection.getResponseCode() == 200) {
                    InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnection.getInputStream());
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        int read = inputStreamReader.read();
                        if (read == -1) {
                            return stringBuffer.toString();
                        }
                        stringBuffer.append((char) read);
                    }
                }
            } catch (Exception unused) {
            }
            return null;
        }
    }
}
