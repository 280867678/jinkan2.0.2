package org.apache.http.ssl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509TrustManager;
import me.tvspark.outline;
import org.apache.http.util.Args;

/* loaded from: classes4.dex */
public class SSLContextBuilder {
    public static final String TLS = "TLS";
    public String protocol;
    public Provider provider;
    public SecureRandom secureRandom;
    public String keyManagerFactoryAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
    public String keyStoreType = KeyStore.getDefaultType();
    public String trustManagerFactoryAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
    public final Set<KeyManager> keyManagers = new LinkedHashSet();
    public final Set<TrustManager> trustManagers = new LinkedHashSet();

    /* loaded from: classes4.dex */
    public static class KeyManagerDelegate extends X509ExtendedKeyManager {
        public final PrivateKeyStrategy aliasStrategy;
        public final X509ExtendedKeyManager keyManager;

        public KeyManagerDelegate(X509ExtendedKeyManager x509ExtendedKeyManager, PrivateKeyStrategy privateKeyStrategy) {
            this.keyManager = x509ExtendedKeyManager;
            this.aliasStrategy = privateKeyStrategy;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
            return this.aliasStrategy.chooseAlias(getClientAliasMap(strArr, principalArr), socket);
        }

        @Override // javax.net.ssl.X509ExtendedKeyManager
        public String chooseEngineClientAlias(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
            return this.aliasStrategy.chooseAlias(getClientAliasMap(strArr, principalArr), null);
        }

        @Override // javax.net.ssl.X509ExtendedKeyManager
        public String chooseEngineServerAlias(String str, Principal[] principalArr, SSLEngine sSLEngine) {
            return this.aliasStrategy.chooseAlias(getServerAliasMap(str, principalArr), null);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
            return this.aliasStrategy.chooseAlias(getServerAliasMap(str, principalArr), socket);
        }

        @Override // javax.net.ssl.X509KeyManager
        public X509Certificate[] getCertificateChain(String str) {
            return this.keyManager.getCertificateChain(str);
        }

        public Map<String, PrivateKeyDetails> getClientAliasMap(String[] strArr, Principal[] principalArr) {
            HashMap hashMap = new HashMap();
            for (String str : strArr) {
                String[] clientAliases = this.keyManager.getClientAliases(str, principalArr);
                if (clientAliases != null) {
                    for (String str2 : clientAliases) {
                        hashMap.put(str2, new PrivateKeyDetails(str, this.keyManager.getCertificateChain(str2)));
                    }
                }
            }
            return hashMap;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getClientAliases(String str, Principal[] principalArr) {
            return this.keyManager.getClientAliases(str, principalArr);
        }

        @Override // javax.net.ssl.X509KeyManager
        public PrivateKey getPrivateKey(String str) {
            return this.keyManager.getPrivateKey(str);
        }

        public Map<String, PrivateKeyDetails> getServerAliasMap(String str, Principal[] principalArr) {
            HashMap hashMap = new HashMap();
            String[] serverAliases = this.keyManager.getServerAliases(str, principalArr);
            if (serverAliases != null) {
                for (String str2 : serverAliases) {
                    hashMap.put(str2, new PrivateKeyDetails(str, this.keyManager.getCertificateChain(str2)));
                }
            }
            return hashMap;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getServerAliases(String str, Principal[] principalArr) {
            return this.keyManager.getServerAliases(str, principalArr);
        }
    }

    /* loaded from: classes4.dex */
    public static class TrustManagerDelegate implements X509TrustManager {
        public final X509TrustManager trustManager;
        public final TrustStrategy trustStrategy;

        public TrustManagerDelegate(X509TrustManager x509TrustManager, TrustStrategy trustStrategy) {
            this.trustManager = x509TrustManager;
            this.trustStrategy = trustStrategy;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.trustManager.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            if (!this.trustStrategy.isTrusted(x509CertificateArr, str)) {
                this.trustManager.checkServerTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.trustManager.getAcceptedIssuers();
        }
    }

    public static SSLContextBuilder create() {
        return new SSLContextBuilder();
    }

    public SSLContext build() throws NoSuchAlgorithmException, KeyManagementException {
        String str = this.protocol;
        if (str == null) {
            str = "TLS";
        }
        Provider provider = this.provider;
        SSLContext sSLContext = provider != null ? SSLContext.getInstance(str, provider) : SSLContext.getInstance(str);
        initSSLContext(sSLContext, this.keyManagers, this.trustManagers, this.secureRandom);
        return sSLContext;
    }

    public void initSSLContext(SSLContext sSLContext, Collection<KeyManager> collection, Collection<TrustManager> collection2, SecureRandom secureRandom) throws KeyManagementException {
        TrustManager[] trustManagerArr = null;
        KeyManager[] keyManagerArr = !collection.isEmpty() ? (KeyManager[]) collection.toArray(new KeyManager[collection.size()]) : null;
        if (!collection2.isEmpty()) {
            trustManagerArr = (TrustManager[]) collection2.toArray(new TrustManager[collection2.size()]);
        }
        sSLContext.init(keyManagerArr, trustManagerArr, secureRandom);
    }

    public SSLContextBuilder loadKeyMaterial(File file, char[] cArr, char[] cArr2) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        return loadKeyMaterial(file, cArr, cArr2, (PrivateKeyStrategy) null);
    }

    public SSLContextBuilder loadKeyMaterial(File file, char[] cArr, char[] cArr2, PrivateKeyStrategy privateKeyStrategy) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        Args.notNull(file, "Keystore file");
        KeyStore keyStore = KeyStore.getInstance(this.keyStoreType);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            keyStore.load(fileInputStream, cArr);
            fileInputStream.close();
            return loadKeyMaterial(keyStore, cArr2, privateKeyStrategy);
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    public SSLContextBuilder loadKeyMaterial(URL url, char[] cArr, char[] cArr2) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        return loadKeyMaterial(url, cArr, cArr2, (PrivateKeyStrategy) null);
    }

    public SSLContextBuilder loadKeyMaterial(URL url, char[] cArr, char[] cArr2, PrivateKeyStrategy privateKeyStrategy) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        Args.notNull(url, "Keystore URL");
        KeyStore keyStore = KeyStore.getInstance(this.keyStoreType);
        InputStream openStream = url.openStream();
        try {
            keyStore.load(openStream, cArr);
            openStream.close();
            return loadKeyMaterial(keyStore, cArr2, privateKeyStrategy);
        } catch (Throwable th) {
            openStream.close();
            throw th;
        }
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore keyStore, char[] cArr) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        return loadKeyMaterial(keyStore, cArr, (PrivateKeyStrategy) null);
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore keyStore, char[] cArr, PrivateKeyStrategy privateKeyStrategy) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        String str = this.keyManagerFactoryAlgorithm;
        if (str == null) {
            str = KeyManagerFactory.getDefaultAlgorithm();
        }
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(str);
        keyManagerFactory.init(keyStore, cArr);
        KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
        if (keyManagers != null) {
            if (privateKeyStrategy != null) {
                for (int i = 0; i < keyManagers.length; i++) {
                    KeyManager keyManager = keyManagers[i];
                    if (keyManager instanceof X509ExtendedKeyManager) {
                        keyManagers[i] = new KeyManagerDelegate((X509ExtendedKeyManager) keyManager, privateKeyStrategy);
                    }
                }
            }
            for (KeyManager keyManager2 : keyManagers) {
                this.keyManagers.add(keyManager2);
            }
        }
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(File file) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        return loadTrustMaterial(file, (char[]) null);
    }

    public SSLContextBuilder loadTrustMaterial(File file, char[] cArr) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        return loadTrustMaterial(file, cArr, (TrustStrategy) null);
    }

    public SSLContextBuilder loadTrustMaterial(File file, char[] cArr, TrustStrategy trustStrategy) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        Args.notNull(file, "Truststore file");
        KeyStore keyStore = KeyStore.getInstance(this.keyStoreType);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            keyStore.load(fileInputStream, cArr);
            fileInputStream.close();
            return loadTrustMaterial(keyStore, trustStrategy);
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    public SSLContextBuilder loadTrustMaterial(URL url, char[] cArr) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        return loadTrustMaterial(url, cArr, (TrustStrategy) null);
    }

    public SSLContextBuilder loadTrustMaterial(URL url, char[] cArr, TrustStrategy trustStrategy) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        Args.notNull(url, "Truststore URL");
        KeyStore keyStore = KeyStore.getInstance(this.keyStoreType);
        InputStream openStream = url.openStream();
        try {
            keyStore.load(openStream, cArr);
            openStream.close();
            return loadTrustMaterial(keyStore, trustStrategy);
        } catch (Throwable th) {
            openStream.close();
            throw th;
        }
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore keyStore, TrustStrategy trustStrategy) throws NoSuchAlgorithmException, KeyStoreException {
        String str = this.trustManagerFactoryAlgorithm;
        if (str == null) {
            str = TrustManagerFactory.getDefaultAlgorithm();
        }
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(str);
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers != null) {
            if (trustStrategy != null) {
                for (int i = 0; i < trustManagers.length; i++) {
                    TrustManager trustManager = trustManagers[i];
                    if (trustManager instanceof X509TrustManager) {
                        trustManagers[i] = new TrustManagerDelegate((X509TrustManager) trustManager, trustStrategy);
                    }
                }
            }
            for (TrustManager trustManager2 : trustManagers) {
                this.trustManagers.add(trustManager2);
            }
        }
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(TrustStrategy trustStrategy) throws NoSuchAlgorithmException, KeyStoreException {
        return loadTrustMaterial((KeyStore) null, trustStrategy);
    }

    public SSLContextBuilder setKeyManagerFactoryAlgorithm(String str) {
        this.keyManagerFactoryAlgorithm = str;
        return this;
    }

    public SSLContextBuilder setKeyStoreType(String str) {
        this.keyStoreType = str;
        return this;
    }

    public SSLContextBuilder setProtocol(String str) {
        this.protocol = str;
        return this;
    }

    public SSLContextBuilder setProvider(String str) {
        this.provider = Security.getProvider(str);
        return this;
    }

    public SSLContextBuilder setProvider(Provider provider) {
        this.provider = provider;
        return this;
    }

    public SSLContextBuilder setSecureRandom(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
        return this;
    }

    public SSLContextBuilder setTrustManagerFactoryAlgorithm(String str) {
        this.trustManagerFactoryAlgorithm = str;
        return this;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[provider=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.provider);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", protocol=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.protocol);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", keyStoreType=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.keyStoreType);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", keyManagerFactoryAlgorithm=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.keyManagerFactoryAlgorithm);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", keyManagers=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.keyManagers);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", trustManagerFactoryAlgorithm=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.trustManagerFactoryAlgorithm);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", trustManagers=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.trustManagers);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", secureRandom=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.secureRandom);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Deprecated
    public SSLContextBuilder useProtocol(String str) {
        this.protocol = str;
        return this;
    }
}
