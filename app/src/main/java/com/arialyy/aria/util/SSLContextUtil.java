package com.arialyy.aria.util;

import android.text.TextUtils;
import com.arialyy.aria.core.AriaConfig;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.WeakHashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes3.dex */
public class SSLContextUtil {
    public static final String TAG = "SSLContextUtil";
    public static Map<String, SSLContext> SSL_CACHE = new WeakHashMap();
    public static TrustManager trustManagers = new X509TrustManager() { // from class: com.arialyy.aria.util.SSLContextUtil.1
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
    };
    public static final HostnameVerifier HOSTNAME_VERIFIER = new HostnameVerifier() { // from class: com.arialyy.aria.util.SSLContextUtil.2
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };

    public static SSLContext createContext(String str, Certificate certificate, String str2, String str3) {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry(str, certificate);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, null);
            if (TextUtils.isEmpty(str2)) {
                str2 = "TLS";
            }
            SSLContext sSLContext = SSLContext.getInstance(str2);
            sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
            SSL_CACHE.put(str3, sSLContext);
            return sSLContext;
        } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getCacheKey(String str, String str2) {
        return CommonUtil.getStrMd5(String.format("%s_%s", str, str2));
    }

    public static SSLContext getDefaultSLLContext(String str) {
        SSLContext sSLContext = null;
        try {
            if (TextUtils.isEmpty(str)) {
                str = "TLS";
            }
            SSLContext sSLContext2 = SSLContext.getInstance(str);
            try {
                sSLContext2.init(null, new TrustManager[]{trustManagers}, new SecureRandom());
                return sSLContext2;
            } catch (Exception e) {
                sSLContext = sSLContext2;
                e = e;
                e.printStackTrace();
                return sSLContext;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static SSLContext getSSLContext(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String cacheKey = getCacheKey(str, str2);
                SSLContext sSLContext = SSL_CACHE.get(cacheKey);
                return sSLContext != null ? sSLContext : createContext(str, loadCert(new FileInputStream(str2)), str3, cacheKey);
            } catch (IOException | CertificateException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static SSLContext getSSLContextFromAssets(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String cacheKey = getCacheKey(str, str2);
                SSLContext sSLContext = SSL_CACHE.get(cacheKey);
                return sSLContext != null ? sSLContext : createContext(str, loadCert(AriaConfig.getInstance().getAPP().getAssets().open(str2)), str3, cacheKey);
            } catch (IOException | CertificateException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Certificate loadCert(InputStream inputStream) throws CertificateException, IOException {
        Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
        ALog.m4192d(TAG, String.format("ca【%s】", ((X509Certificate) generateCertificate).getSubjectDN()));
        inputStream.close();
        return generateCertificate;
    }
}
