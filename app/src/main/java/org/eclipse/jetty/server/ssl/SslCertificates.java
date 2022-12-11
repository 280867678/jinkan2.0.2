package org.eclipse.jetty.server.ssl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class SslCertificates {
    public static final Logger LOG = Log.getLogger(SslCertificates.class);
    public static final String CACHED_INFO_ATTR = CachedInfo.class.getName();

    /* loaded from: classes5.dex */
    public static class CachedInfo {
        public final X509Certificate[] _certs;
        public final String _idStr;
        public final Integer _keySize;

        public CachedInfo(Integer num, X509Certificate[] x509CertificateArr, String str) {
            this._keySize = num;
            this._certs = x509CertificateArr;
            this._idStr = str;
        }

        public X509Certificate[] getCerts() {
            return this._certs;
        }

        public String getIdStr() {
            return this._idStr;
        }

        public Integer getKeySize() {
            return this._keySize;
        }
    }

    public static void customize(SSLSession sSLSession, EndPoint endPoint, Request request) throws IOException {
        X509Certificate[] certChain;
        Object obj;
        Object obj2;
        request.setScheme("https");
        try {
            String cipherSuite = sSLSession.getCipherSuite();
            CachedInfo cachedInfo = (CachedInfo) sSLSession.getValue(CACHED_INFO_ATTR);
            if (cachedInfo != null) {
                obj = cachedInfo.getKeySize();
                certChain = cachedInfo.getCerts();
                obj2 = cachedInfo.getIdStr();
            } else {
                Integer num = new Integer(ServletSSL.deduceKeyLength(cipherSuite));
                certChain = getCertChain(sSLSession);
                String hexString = TypeUtil.toHexString(sSLSession.getId());
                sSLSession.putValue(CACHED_INFO_ATTR, new CachedInfo(num, certChain, hexString));
                obj = num;
                obj2 = hexString;
            }
            if (certChain != null) {
                request.setAttribute("javax.servlet.request.X509Certificate", certChain);
            }
            request.setAttribute("javax.servlet.request.cipher_suite", cipherSuite);
            request.setAttribute("javax.servlet.request.key_size", obj);
            request.setAttribute("javax.servlet.request.ssl_session_id", obj2);
        } catch (Exception e) {
            LOG.warn(Log.EXCEPTION, e);
        }
    }

    public static X509Certificate[] getCertChain(SSLSession sSLSession) {
        try {
            javax.security.cert.X509Certificate[] peerCertificateChain = sSLSession.getPeerCertificateChain();
            if (peerCertificateChain != null && peerCertificateChain.length != 0) {
                int length = peerCertificateChain.length;
                X509Certificate[] x509CertificateArr = new X509Certificate[length];
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                for (int i = 0; i < length; i++) {
                    x509CertificateArr[i] = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(peerCertificateChain[i].getEncoded()));
                }
                return x509CertificateArr;
            }
            return null;
        } catch (SSLPeerUnverifiedException unused) {
            return null;
        } catch (Exception e) {
            LOG.warn(Log.EXCEPTION, e);
            return null;
        }
    }
}
