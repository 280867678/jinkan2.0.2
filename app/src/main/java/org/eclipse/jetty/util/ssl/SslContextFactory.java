package org.eclipse.jetty.util.ssl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.security.InvalidParameterException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CRL;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.CertPathTrustManagerParameters;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import me.tvspark.outline;
import org.apache.commons.lang3.SystemUtils;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.security.CertificateUtils;
import org.eclipse.jetty.util.security.CertificateValidator;
import org.eclipse.jetty.util.security.Password;

/* loaded from: classes5.dex */
public class SslContextFactory extends AbstractLifeCycle {
    public static final String DEFAULT_KEYMANAGERFACTORY_ALGORITHM;
    public static final String DEFAULT_KEYSTORE_PATH;
    public static final String DEFAULT_TRUSTMANAGERFACTORY_ALGORITHM;
    public static final String KEYPASSWORD_PROPERTY = "org.eclipse.jetty.ssl.keypassword";
    public static final String PASSWORD_PROPERTY = "org.eclipse.jetty.ssl.password";
    public boolean _allowRenegotiate;
    public String _certAlias;
    public SSLContext _context;
    public String _crlPath;
    public boolean _enableCRLDP;
    public boolean _enableOCSP;
    public final Set<String> _excludeCipherSuites;
    public final Set<String> _excludeProtocols;
    public Set<String> _includeCipherSuites;
    public Set<String> _includeProtocols;
    public String _keyManagerFactoryAlgorithm;
    public transient Password _keyManagerPassword;
    public KeyStore _keyStore;
    public InputStream _keyStoreInputStream;
    public transient Password _keyStorePassword;
    public String _keyStorePath;
    public String _keyStoreProvider;
    public String _keyStoreType;
    public int _maxCertPathLength;
    public boolean _needClientAuth;
    public String _ocspResponderURL;
    public String _secureRandomAlgorithm;
    public boolean _sessionCachingEnabled;
    public String _sslProtocol;
    public String _sslProvider;
    public int _sslSessionCacheSize;
    public int _sslSessionTimeout;
    public boolean _trustAll;
    public String _trustManagerFactoryAlgorithm;
    public KeyStore _trustStore;
    public InputStream _trustStoreInputStream;
    public transient Password _trustStorePassword;
    public String _trustStorePath;
    public String _trustStoreProvider;
    public String _trustStoreType;
    public boolean _validateCerts;
    public boolean _validatePeerCerts;
    public boolean _wantClientAuth;
    public static final TrustManager[] TRUST_ALL_CERTS = {new X509TrustManager() { // from class: org.eclipse.jetty.util.ssl.SslContextFactory.1
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }};
    public static final Logger LOG = Log.getLogger(SslContextFactory.class);

    static {
        String str = "SunX509";
        DEFAULT_KEYMANAGERFACTORY_ALGORITHM = Security.getProperty("ssl.KeyManagerFactory.algorithm") == null ? str : Security.getProperty("ssl.KeyManagerFactory.algorithm");
        if (Security.getProperty("ssl.TrustManagerFactory.algorithm") != null) {
            str = Security.getProperty("ssl.TrustManagerFactory.algorithm");
        }
        DEFAULT_TRUSTMANAGERFACTORY_ALGORITHM = str;
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty(SystemUtils.USER_HOME_KEY));
        DEFAULT_KEYSTORE_PATH = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, File.separator, ".keystore");
    }

    public SslContextFactory() {
        this._excludeProtocols = new LinkedHashSet();
        this._includeProtocols = new LinkedHashSet();
        this._excludeCipherSuites = new LinkedHashSet();
        this._includeCipherSuites = new LinkedHashSet();
        this._keyStoreType = "JKS";
        this._trustStoreType = "JKS";
        this._needClientAuth = false;
        this._wantClientAuth = false;
        this._allowRenegotiate = true;
        this._sslProtocol = "TLS";
        this._keyManagerFactoryAlgorithm = DEFAULT_KEYMANAGERFACTORY_ALGORITHM;
        this._trustManagerFactoryAlgorithm = DEFAULT_TRUSTMANAGERFACTORY_ALGORITHM;
        this._maxCertPathLength = -1;
        this._enableCRLDP = false;
        this._enableOCSP = false;
        this._sessionCachingEnabled = true;
        this._trustAll = true;
    }

    public SslContextFactory(String str) {
        this._excludeProtocols = new LinkedHashSet();
        this._includeProtocols = new LinkedHashSet();
        this._excludeCipherSuites = new LinkedHashSet();
        this._includeCipherSuites = new LinkedHashSet();
        this._keyStoreType = "JKS";
        this._trustStoreType = "JKS";
        this._needClientAuth = false;
        this._wantClientAuth = false;
        this._allowRenegotiate = true;
        this._sslProtocol = "TLS";
        this._keyManagerFactoryAlgorithm = DEFAULT_KEYMANAGERFACTORY_ALGORITHM;
        this._trustManagerFactoryAlgorithm = DEFAULT_TRUSTMANAGERFACTORY_ALGORITHM;
        this._maxCertPathLength = -1;
        this._enableCRLDP = false;
        this._enableOCSP = false;
        this._sessionCachingEnabled = true;
        this._keyStorePath = str;
    }

    public SslContextFactory(boolean z) {
        this._excludeProtocols = new LinkedHashSet();
        this._includeProtocols = new LinkedHashSet();
        this._excludeCipherSuites = new LinkedHashSet();
        this._includeCipherSuites = new LinkedHashSet();
        this._keyStoreType = "JKS";
        this._trustStoreType = "JKS";
        this._needClientAuth = false;
        this._wantClientAuth = false;
        this._allowRenegotiate = true;
        this._sslProtocol = "TLS";
        this._keyManagerFactoryAlgorithm = DEFAULT_KEYMANAGERFACTORY_ALGORITHM;
        this._trustManagerFactoryAlgorithm = DEFAULT_TRUSTMANAGERFACTORY_ALGORITHM;
        this._maxCertPathLength = -1;
        this._enableCRLDP = false;
        this._enableOCSP = false;
        this._sessionCachingEnabled = true;
        this._trustAll = z;
    }

    public void addExcludeCipherSuites(String... strArr) {
        checkNotStarted();
        this._excludeCipherSuites.addAll(Arrays.asList(strArr));
    }

    public void addExcludeProtocols(String... strArr) {
        checkNotStarted();
        this._excludeProtocols.addAll(Arrays.asList(strArr));
    }

    public void checkKeyStore() {
        if (this._context != null) {
            return;
        }
        if (this._keyStore == null && this._keyStoreInputStream == null && this._keyStorePath == null) {
            throw new IllegalStateException("SSL doesn't have a valid keystore");
        }
        if (this._trustStore == null && this._trustStoreInputStream == null && this._trustStorePath == null) {
            this._trustStore = this._keyStore;
            this._trustStorePath = this._keyStorePath;
            this._trustStoreInputStream = this._keyStoreInputStream;
            this._trustStoreType = this._keyStoreType;
            this._trustStoreProvider = this._keyStoreProvider;
            this._trustStorePassword = this._keyStorePassword;
            this._trustManagerFactoryAlgorithm = this._keyManagerFactoryAlgorithm;
        }
        InputStream inputStream = this._keyStoreInputStream;
        if (inputStream == null || inputStream != this._trustStoreInputStream) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            C3009IO.copy(this._keyStoreInputStream, byteArrayOutputStream);
            this._keyStoreInputStream.close();
            this._keyStoreInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            this._trustStoreInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void checkNotStarted() {
        if (!isStarted()) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot modify configuration when ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getState());
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public void customize(SSLEngine sSLEngine) {
        if (getWantClientAuth()) {
            sSLEngine.setWantClientAuth(getWantClientAuth());
        }
        if (getNeedClientAuth()) {
            sSLEngine.setNeedClientAuth(getNeedClientAuth());
        }
        sSLEngine.setEnabledCipherSuites(selectCipherSuites(sSLEngine.getEnabledCipherSuites(), sSLEngine.getSupportedCipherSuites()));
        sSLEngine.setEnabledProtocols(selectProtocols(sSLEngine.getEnabledProtocols(), sSLEngine.getSupportedProtocols()));
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        String sb;
        TrustManager[] trustManagerArr;
        if (this._context == null) {
            SecureRandom secureRandom = null;
            if (this._keyStore == null && this._keyStoreInputStream == null && this._keyStorePath == null && this._trustStore == null && this._trustStoreInputStream == null && this._trustStorePath == null) {
                if (this._trustAll) {
                    LOG.debug("No keystore or trust store configured.  ACCEPTING UNTRUSTED CERTIFICATES!!!!!", new Object[0]);
                    trustManagerArr = TRUST_ALL_CERTS;
                } else {
                    trustManagerArr = null;
                }
                String str = this._secureRandomAlgorithm;
                SecureRandom secureRandom2 = str == null ? null : SecureRandom.getInstance(str);
                String str2 = this._sslProvider;
                SSLContext sSLContext = str2 == null ? SSLContext.getInstance(this._sslProtocol) : SSLContext.getInstance(this._sslProtocol, str2);
                this._context = sSLContext;
                sSLContext.init(null, trustManagerArr, secureRandom2);
                return;
            }
            checkKeyStore();
            KeyStore loadKeyStore = loadKeyStore();
            KeyStore loadTrustStore = loadTrustStore();
            Collection<? extends CRL> loadCRL = loadCRL(this._crlPath);
            if (this._validateCerts && loadKeyStore != null) {
                if (this._certAlias == null) {
                    ArrayList list = Collections.list(loadKeyStore.aliases());
                    this._certAlias = list.size() == 1 ? (String) list.get(0) : null;
                }
                String str3 = this._certAlias;
                Certificate certificate = str3 == null ? null : loadKeyStore.getCertificate(str3);
                if (certificate == null) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No certificate found in the keystore");
                    if (this._certAlias == null) {
                        sb = "";
                    } else {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(" for alias ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this._certAlias);
                        sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(sb);
                    throw new Exception(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
                CertificateValidator certificateValidator = new CertificateValidator(loadTrustStore, loadCRL);
                certificateValidator.setMaxCertPathLength(this._maxCertPathLength);
                certificateValidator.setEnableCRLDP(this._enableCRLDP);
                certificateValidator.setEnableOCSP(this._enableOCSP);
                certificateValidator.setOcspResponderURL(this._ocspResponderURL);
                certificateValidator.validate(loadKeyStore, certificate);
            }
            KeyManager[] keyManagers = getKeyManagers(loadKeyStore);
            TrustManager[] trustManagers = getTrustManagers(loadTrustStore, loadCRL);
            String str4 = this._secureRandomAlgorithm;
            if (str4 != null) {
                secureRandom = SecureRandom.getInstance(str4);
            }
            String str5 = this._sslProvider;
            SSLContext sSLContext2 = str5 == null ? SSLContext.getInstance(this._sslProtocol) : SSLContext.getInstance(this._sslProtocol, str5);
            this._context = sSLContext2;
            sSLContext2.init(keyManagers, trustManagers, secureRandom);
            SSLEngine newSslEngine = newSslEngine();
            LOG.info("Enabled Protocols {} of {}", Arrays.asList(newSslEngine.getEnabledProtocols()), Arrays.asList(newSslEngine.getSupportedProtocols()));
            if (!LOG.isDebugEnabled()) {
                return;
            }
            LOG.debug("Enabled Ciphers   {} of {}", Arrays.asList(newSslEngine.getEnabledCipherSuites()), Arrays.asList(newSslEngine.getSupportedCipherSuites()));
        }
    }

    public String getCertAlias() {
        return this._certAlias;
    }

    public String getCrlPath() {
        return this._crlPath;
    }

    public String[] getExcludeCipherSuites() {
        Set<String> set = this._excludeCipherSuites;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public String[] getExcludeProtocols() {
        Set<String> set = this._excludeProtocols;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public String[] getIncludeCipherSuites() {
        Set<String> set = this._includeCipherSuites;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public String[] getIncludeProtocols() {
        Set<String> set = this._includeProtocols;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public KeyManager[] getKeyManagers(KeyStore keyStore) throws Exception {
        KeyManager[] keyManagerArr = null;
        char[] charArray = null;
        if (keyStore != null) {
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(this._keyManagerFactoryAlgorithm);
            Password password = this._keyManagerPassword;
            if (password != null || (password = this._keyStorePassword) != null) {
                charArray = password.toString().toCharArray();
            }
            keyManagerFactory.init(keyStore, charArray);
            keyManagerArr = keyManagerFactory.getKeyManagers();
            if (this._certAlias != null) {
                for (int i = 0; i < keyManagerArr.length; i++) {
                    if (keyManagerArr[i] instanceof X509KeyManager) {
                        keyManagerArr[i] = new AliasedX509ExtendedKeyManager(this._certAlias, (X509KeyManager) keyManagerArr[i]);
                    }
                }
            }
        }
        return keyManagerArr;
    }

    @Deprecated
    public String getKeyStore() {
        return this._keyStorePath;
    }

    @Deprecated
    public KeyStore getKeyStore(InputStream inputStream, String str, String str2, String str3, String str4) throws Exception {
        return CertificateUtils.getKeyStore(inputStream, str, str2, str3, str4);
    }

    @Deprecated
    public InputStream getKeyStoreInputStream() {
        checkKeyStore();
        return this._keyStoreInputStream;
    }

    public String getKeyStorePath() {
        return this._keyStorePath;
    }

    public String getKeyStoreProvider() {
        return this._keyStoreProvider;
    }

    public String getKeyStoreType() {
        return this._keyStoreType;
    }

    public int getMaxCertPathLength() {
        return this._maxCertPathLength;
    }

    public boolean getNeedClientAuth() {
        return this._needClientAuth;
    }

    public String getOcspResponderURL() {
        return this._ocspResponderURL;
    }

    public String getProtocol() {
        return this._sslProtocol;
    }

    public String getProvider() {
        return this._sslProvider;
    }

    public String getSecureRandomAlgorithm() {
        return this._secureRandomAlgorithm;
    }

    public SSLContext getSslContext() {
        if (isStarted()) {
            return this._context;
        }
        throw new IllegalStateException(getState());
    }

    public String getSslKeyManagerFactoryAlgorithm() {
        return this._keyManagerFactoryAlgorithm;
    }

    public int getSslSessionCacheSize() {
        return this._sslSessionCacheSize;
    }

    public int getSslSessionTimeout() {
        return this._sslSessionTimeout;
    }

    public String getTrustManagerFactoryAlgorithm() {
        return this._trustManagerFactoryAlgorithm;
    }

    public TrustManager[] getTrustManagers(KeyStore keyStore, Collection<? extends CRL> collection) throws Exception {
        if (keyStore != null) {
            if (!this._validatePeerCerts || !this._trustManagerFactoryAlgorithm.equalsIgnoreCase("PKIX")) {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(this._trustManagerFactoryAlgorithm);
                trustManagerFactory.init(keyStore);
                return trustManagerFactory.getTrustManagers();
            }
            PKIXBuilderParameters pKIXBuilderParameters = new PKIXBuilderParameters(keyStore, new X509CertSelector());
            pKIXBuilderParameters.setMaxPathLength(this._maxCertPathLength);
            pKIXBuilderParameters.setRevocationEnabled(true);
            if (collection != null && !collection.isEmpty()) {
                pKIXBuilderParameters.addCertStore(CertStore.getInstance("Collection", new CollectionCertStoreParameters(collection)));
            }
            if (this._enableCRLDP) {
                System.setProperty("com.sun.security.enableCRLDP", "true");
            }
            if (this._enableOCSP) {
                Security.setProperty("ocsp.enable", "true");
                String str = this._ocspResponderURL;
                if (str != null) {
                    Security.setProperty("ocsp.responderURL", str);
                }
            }
            TrustManagerFactory trustManagerFactory2 = TrustManagerFactory.getInstance(this._trustManagerFactoryAlgorithm);
            trustManagerFactory2.init(new CertPathTrustManagerParameters(pKIXBuilderParameters));
            return trustManagerFactory2.getTrustManagers();
        }
        return null;
    }

    public String getTrustStore() {
        return this._trustStorePath;
    }

    @Deprecated
    public InputStream getTrustStoreInputStream() {
        checkKeyStore();
        return this._trustStoreInputStream;
    }

    public String getTrustStoreProvider() {
        return this._trustStoreProvider;
    }

    public String getTrustStoreType() {
        return this._trustStoreType;
    }

    @Deprecated
    public boolean getValidateCerts() {
        return this._validateCerts;
    }

    public boolean getWantClientAuth() {
        return this._wantClientAuth;
    }

    public boolean isAllowRenegotiate() {
        return this._allowRenegotiate;
    }

    public boolean isEnableCRLDP() {
        return this._enableCRLDP;
    }

    public boolean isEnableOCSP() {
        return this._enableOCSP;
    }

    public boolean isSessionCachingEnabled() {
        return this._sessionCachingEnabled;
    }

    public boolean isTrustAll() {
        return this._trustAll;
    }

    public boolean isValidateCerts() {
        return this._validateCerts;
    }

    public boolean isValidatePeerCerts() {
        return this._validatePeerCerts;
    }

    public Collection<? extends CRL> loadCRL(String str) throws Exception {
        return CertificateUtils.loadCRL(str);
    }

    public KeyStore loadKeyStore() throws Exception {
        KeyStore keyStore = this._keyStore;
        if (keyStore != null) {
            return keyStore;
        }
        InputStream inputStream = this._keyStoreInputStream;
        String str = this._keyStorePath;
        String str2 = this._keyStoreType;
        String str3 = this._keyStoreProvider;
        Password password = this._keyStorePassword;
        return getKeyStore(inputStream, str, str2, str3, password == null ? null : password.toString());
    }

    public KeyStore loadTrustStore() throws Exception {
        KeyStore keyStore = this._trustStore;
        if (keyStore != null) {
            return keyStore;
        }
        InputStream inputStream = this._trustStoreInputStream;
        String str = this._trustStorePath;
        String str2 = this._trustStoreType;
        String str3 = this._trustStoreProvider;
        Password password = this._trustStorePassword;
        return getKeyStore(inputStream, str, str2, str3, password == null ? null : password.toString());
    }

    public SSLEngine newSslEngine() {
        SSLEngine createSSLEngine = this._context.createSSLEngine();
        customize(createSSLEngine);
        return createSSLEngine;
    }

    public SSLEngine newSslEngine(String str, int i) {
        SSLEngine createSSLEngine = isSessionCachingEnabled() ? this._context.createSSLEngine(str, i) : this._context.createSSLEngine();
        customize(createSSLEngine);
        return createSSLEngine;
    }

    public SSLServerSocket newSslServerSocket(String str, int i, int i2) throws IOException {
        SSLServerSocketFactory serverSocketFactory = this._context.getServerSocketFactory();
        SSLServerSocket sSLServerSocket = (SSLServerSocket) (str == null ? serverSocketFactory.createServerSocket(i, i2) : serverSocketFactory.createServerSocket(i, i2, InetAddress.getByName(str)));
        if (getWantClientAuth()) {
            sSLServerSocket.setWantClientAuth(getWantClientAuth());
        }
        if (getNeedClientAuth()) {
            sSLServerSocket.setNeedClientAuth(getNeedClientAuth());
        }
        sSLServerSocket.setEnabledCipherSuites(selectCipherSuites(sSLServerSocket.getEnabledCipherSuites(), sSLServerSocket.getSupportedCipherSuites()));
        sSLServerSocket.setEnabledProtocols(selectProtocols(sSLServerSocket.getEnabledProtocols(), sSLServerSocket.getSupportedProtocols()));
        return sSLServerSocket;
    }

    public SSLSocket newSslSocket() throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this._context.getSocketFactory().createSocket();
        if (getWantClientAuth()) {
            sSLSocket.setWantClientAuth(getWantClientAuth());
        }
        if (getNeedClientAuth()) {
            sSLSocket.setNeedClientAuth(getNeedClientAuth());
        }
        sSLSocket.setEnabledCipherSuites(selectCipherSuites(sSLSocket.getEnabledCipherSuites(), sSLSocket.getSupportedCipherSuites()));
        sSLSocket.setEnabledProtocols(selectProtocols(sSLSocket.getEnabledProtocols(), sSLSocket.getSupportedProtocols()));
        return sSLSocket;
    }

    public String[] selectCipherSuites(String[] strArr, String[] strArr2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!this._includeCipherSuites.isEmpty()) {
            for (String str : this._includeCipherSuites) {
                if (Arrays.asList(strArr2).contains(str)) {
                    linkedHashSet.add(str);
                }
            }
        } else {
            linkedHashSet.addAll(Arrays.asList(strArr));
        }
        Set<String> set = this._excludeCipherSuites;
        if (set != null) {
            linkedHashSet.removeAll(set);
        }
        return (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]);
    }

    public String[] selectProtocols(String[] strArr, String[] strArr2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!this._includeProtocols.isEmpty()) {
            for (String str : this._includeProtocols) {
                if (Arrays.asList(strArr2).contains(str)) {
                    linkedHashSet.add(str);
                }
            }
        } else {
            linkedHashSet.addAll(Arrays.asList(strArr));
        }
        Set<String> set = this._excludeProtocols;
        if (set != null) {
            linkedHashSet.removeAll(set);
        }
        return (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]);
    }

    public void setAllowRenegotiate(boolean z) {
        checkNotStarted();
        this._allowRenegotiate = z;
    }

    public void setCertAlias(String str) {
        checkNotStarted();
        this._certAlias = str;
    }

    public void setCrlPath(String str) {
        checkNotStarted();
        this._crlPath = str;
    }

    public void setEnableCRLDP(boolean z) {
        checkNotStarted();
        this._enableCRLDP = z;
    }

    public void setEnableOCSP(boolean z) {
        checkNotStarted();
        this._enableOCSP = z;
    }

    public void setExcludeCipherSuites(String... strArr) {
        checkNotStarted();
        this._excludeCipherSuites.clear();
        this._excludeCipherSuites.addAll(Arrays.asList(strArr));
    }

    public void setExcludeProtocols(String... strArr) {
        checkNotStarted();
        this._excludeProtocols.clear();
        this._excludeProtocols.addAll(Arrays.asList(strArr));
    }

    public void setIncludeCipherSuites(String... strArr) {
        checkNotStarted();
        this._includeCipherSuites.clear();
        this._includeCipherSuites.addAll(Arrays.asList(strArr));
    }

    public void setIncludeProtocols(String... strArr) {
        checkNotStarted();
        this._includeProtocols.clear();
        this._includeProtocols.addAll(Arrays.asList(strArr));
    }

    public void setKeyManagerPassword(String str) {
        checkNotStarted();
        this._keyManagerPassword = Password.getPassword("org.eclipse.jetty.ssl.keypassword", str, null);
    }

    @Deprecated
    public void setKeyStore(String str) {
        checkNotStarted();
        this._keyStorePath = str;
    }

    public void setKeyStore(KeyStore keyStore) {
        checkNotStarted();
        this._keyStore = keyStore;
    }

    @Deprecated
    public void setKeyStoreInputStream(InputStream inputStream) {
        checkNotStarted();
        this._keyStoreInputStream = inputStream;
    }

    public void setKeyStorePassword(String str) {
        checkNotStarted();
        this._keyStorePassword = Password.getPassword("org.eclipse.jetty.ssl.password", str, null);
    }

    public void setKeyStorePath(String str) {
        checkNotStarted();
        this._keyStorePath = str;
    }

    public void setKeyStoreProvider(String str) {
        checkNotStarted();
        this._keyStoreProvider = str;
    }

    public void setKeyStoreResource(Resource resource) {
        checkNotStarted();
        try {
            this._keyStoreInputStream = resource.getInputStream();
        } catch (IOException unused) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to get resource input stream for resource ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(resource.toString());
            throw new InvalidParameterException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    public void setKeyStoreType(String str) {
        checkNotStarted();
        this._keyStoreType = str;
    }

    public void setMaxCertPathLength(int i) {
        checkNotStarted();
        this._maxCertPathLength = i;
    }

    public void setNeedClientAuth(boolean z) {
        checkNotStarted();
        this._needClientAuth = z;
    }

    public void setOcspResponderURL(String str) {
        checkNotStarted();
        this._ocspResponderURL = str;
    }

    public void setProtocol(String str) {
        checkNotStarted();
        this._sslProtocol = str;
    }

    public void setProvider(String str) {
        checkNotStarted();
        this._sslProvider = str;
    }

    public void setSecureRandomAlgorithm(String str) {
        checkNotStarted();
        this._secureRandomAlgorithm = str;
    }

    public void setSessionCachingEnabled(boolean z) {
        this._sessionCachingEnabled = z;
    }

    public void setSslContext(SSLContext sSLContext) {
        checkNotStarted();
        this._context = sSLContext;
    }

    public void setSslKeyManagerFactoryAlgorithm(String str) {
        checkNotStarted();
        this._keyManagerFactoryAlgorithm = str;
    }

    public void setSslSessionCacheSize(int i) {
        this._sslSessionCacheSize = i;
    }

    public void setSslSessionTimeout(int i) {
        this._sslSessionTimeout = i;
    }

    public void setTrustAll(boolean z) {
        this._trustAll = z;
    }

    public void setTrustManagerFactoryAlgorithm(String str) {
        checkNotStarted();
        this._trustManagerFactoryAlgorithm = str;
    }

    public void setTrustStore(String str) {
        checkNotStarted();
        this._trustStorePath = str;
    }

    public void setTrustStore(KeyStore keyStore) {
        checkNotStarted();
        this._trustStore = keyStore;
    }

    @Deprecated
    public void setTrustStoreInputStream(InputStream inputStream) {
        checkNotStarted();
        this._trustStoreInputStream = inputStream;
    }

    public void setTrustStorePassword(String str) {
        checkNotStarted();
        this._trustStorePassword = Password.getPassword("org.eclipse.jetty.ssl.password", str, null);
    }

    public void setTrustStoreProvider(String str) {
        checkNotStarted();
        this._trustStoreProvider = str;
    }

    public void setTrustStoreResource(Resource resource) {
        checkNotStarted();
        try {
            this._trustStoreInputStream = resource.getInputStream();
        } catch (IOException unused) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to get resource input stream for resource ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(resource.toString());
            throw new InvalidParameterException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    public void setTrustStoreType(String str) {
        checkNotStarted();
        this._trustStoreType = str;
    }

    public void setValidateCerts(boolean z) {
        checkNotStarted();
        this._validateCerts = z;
    }

    public void setValidatePeerCerts(boolean z) {
        checkNotStarted();
        this._validatePeerCerts = z;
    }

    public void setWantClientAuth(boolean z) {
        checkNotStarted();
        this._wantClientAuth = z;
    }

    public String toString() {
        return String.format("%s@%x(%s,%s)", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._keyStorePath, this._trustStorePath);
    }
}
