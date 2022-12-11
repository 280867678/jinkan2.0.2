package org.eclipse.jetty.util.security;

import java.security.GeneralSecurityException;
import java.security.InvalidParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Security;
import java.security.cert.CRL;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathValidator;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.outline;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class CertificateValidator {
    public static final Logger LOG = Log.getLogger(CertificateValidator.class);
    public static AtomicLong __aliasCount = new AtomicLong();
    public Collection<? extends CRL> _crls;
    public String _ocspResponderURL;
    public KeyStore _trustStore;
    public int _maxCertPathLength = -1;
    public boolean _enableCRLDP = false;
    public boolean _enableOCSP = false;

    public CertificateValidator(KeyStore keyStore, Collection<? extends CRL> collection) {
        if (keyStore != null) {
            this._trustStore = keyStore;
            this._crls = collection;
            return;
        }
        throw new InvalidParameterException("TrustStore must be specified for CertificateValidator.");
    }

    public Collection<? extends CRL> getCrls() {
        return this._crls;
    }

    public int getMaxCertPathLength() {
        return this._maxCertPathLength;
    }

    public String getOcspResponderURL() {
        return this._ocspResponderURL;
    }

    public KeyStore getTrustStore() {
        return this._trustStore;
    }

    public boolean isEnableCRLDP() {
        return this._enableCRLDP;
    }

    public boolean isEnableOCSP() {
        return this._enableOCSP;
    }

    public void setEnableCRLDP(boolean z) {
        this._enableCRLDP = z;
    }

    public void setEnableOCSP(boolean z) {
        this._enableOCSP = z;
    }

    public void setMaxCertPathLength(int i) {
        this._maxCertPathLength = i;
    }

    public void setOcspResponderURL(String str) {
        this._ocspResponderURL = str;
    }

    public String validate(KeyStore keyStore, String str) throws CertificateException {
        if (str != null) {
            try {
                validate(keyStore, keyStore.getCertificate(str));
                return str;
            } catch (KeyStoreException e) {
                LOG.debug(e);
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to validate certificate for alias [", str, "]: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
                throw new CertificateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
            }
        }
        return null;
    }

    public void validate(KeyStore keyStore) throws CertificateException {
        try {
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                validate(keyStore, aliases.nextElement());
            }
        } catch (KeyStoreException e) {
            throw new CertificateException("Unable to retrieve aliases from keystore", e);
        }
    }

    public void validate(KeyStore keyStore, Certificate certificate) throws CertificateException {
        if (certificate == null || !(certificate instanceof X509Certificate)) {
            return;
        }
        ((X509Certificate) certificate).checkValidity();
        try {
            if (keyStore == null) {
                throw new InvalidParameterException("Keystore cannot be null");
            }
            String certificateAlias = keyStore.getCertificateAlias((X509Certificate) certificate);
            if (certificateAlias == null) {
                certificateAlias = "JETTY" + String.format("%016X", Long.valueOf(__aliasCount.incrementAndGet()));
                keyStore.setCertificateEntry(certificateAlias, certificate);
            }
            Certificate[] certificateChain = keyStore.getCertificateChain(certificateAlias);
            if (certificateChain == null || certificateChain.length == 0) {
                throw new IllegalStateException("Unable to retrieve certificate chain");
            }
            validate(certificateChain);
        } catch (KeyStoreException e) {
            LOG.debug(e);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to validate certificate");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(0 == 0 ? "" : outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(" for alias [", (String) null, "]"));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(": ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new CertificateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }

    public void validate(Certificate[] certificateArr) throws CertificateException {
        try {
            ArrayList arrayList = new ArrayList();
            for (Certificate certificate : certificateArr) {
                if (certificate != null) {
                    if (!(certificate instanceof X509Certificate)) {
                        throw new IllegalStateException("Invalid certificate type in chain");
                    }
                    arrayList.add((X509Certificate) certificate);
                }
            }
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("Invalid certificate chain");
            }
            X509CertSelector x509CertSelector = new X509CertSelector();
            x509CertSelector.setCertificate((X509Certificate) arrayList.get(0));
            PKIXBuilderParameters pKIXBuilderParameters = new PKIXBuilderParameters(this._trustStore, x509CertSelector);
            pKIXBuilderParameters.addCertStore(CertStore.getInstance("Collection", new CollectionCertStoreParameters(arrayList)));
            pKIXBuilderParameters.setMaxPathLength(this._maxCertPathLength);
            pKIXBuilderParameters.setRevocationEnabled(true);
            if (this._crls != null && !this._crls.isEmpty()) {
                pKIXBuilderParameters.addCertStore(CertStore.getInstance("Collection", new CollectionCertStoreParameters(this._crls)));
            }
            if (this._enableOCSP) {
                Security.setProperty("ocsp.enable", "true");
            }
            if (this._enableCRLDP) {
                System.setProperty("com.sun.security.enableCRLDP", "true");
            }
            CertPathValidator.getInstance("PKIX").validate(CertPathBuilder.getInstance("PKIX").build(pKIXBuilderParameters).getCertPath(), pKIXBuilderParameters);
        } catch (GeneralSecurityException e) {
            LOG.debug(e);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to validate certificate: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            throw new CertificateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }
}
