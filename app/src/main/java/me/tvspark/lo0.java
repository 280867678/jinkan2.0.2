package me.tvspark;

import android.text.TextUtils;
import com.arialyy.aria.core.ProtocolType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import me.tvspark.ApplicationC1880C;
import me.tvspark.utils.SKUtils;

/* loaded from: classes4.dex */
public class lo0 {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Thread {
        public File Wwwwwwwwwwwwwwwwwwwwwww;
        public String Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements X509TrustManager {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }

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

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, File file) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwww = file;
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, File file) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            file.getAbsolutePath();
            try {
                try {
                    URL url = new URL(str);
                    if (url.getProtocol().toUpperCase().equals("HTTPS")) {
                        TrustManager[] trustManagerArr = {new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)};
                        try {
                            SSLContext sSLContext = SSLContext.getInstance(ProtocolType.SSL);
                            sSLContext.init(null, trustManagerArr, new SecureRandom());
                            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        String readLine = bufferedReader.readLine();
                        System.currentTimeMillis();
                        while (!TextUtils.isEmpty(readLine)) {
                            bufferedWriter.write(readLine);
                            bufferedWriter.write("\n");
                            readLine = bufferedReader.readLine();
                            if (TextUtils.isEmpty(readLine)) {
                                readLine = bufferedReader.readLine();
                            }
                        }
                        System.currentTimeMillis();
                        File file2 = new File(lo0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwww(str));
                        if (file.renameTo(file2)) {
                            file2.getName();
                        } else {
                            file.getName();
                        }
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        bufferedReader.close();
                        return true;
                    } finally {
                        httpURLConnection.disconnect();
                    }
                } catch (IOException unused) {
                    lo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lo0.this);
                    lo0 lo0Var = lo0.this;
                    if (lo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == lo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length && (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = lo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                        ((ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    return false;
                }
            } finally {
                lo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lo0.this);
                lo0 lo0Var2 = lo0.this;
                if (lo0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == lo0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length && (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = lo0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                    ((ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public lo0(File file, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        String[] strArr = {"https://easylist-downloads.adblockplus.org/easylistchina.txt", "https://halflife.coding.net/p/list/d/list/git/raw/master/ad.txt"};
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = strArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = file;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        for (String str : strArr) {
            try {
                new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, new File(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwww(str) + ".tmp")).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lo0 lo0Var) {
        int i = lo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        lo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
        return i;
    }
}
