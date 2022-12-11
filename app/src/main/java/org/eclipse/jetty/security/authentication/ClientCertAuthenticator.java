package org.eclipse.jetty.security.authentication;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.Principal;
import java.security.cert.CRL;
import java.security.cert.X509Certificate;
import java.util.Collection;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.security.ServerAuthException;
import org.eclipse.jetty.security.UserAuthentication;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.B64Code;
import org.eclipse.jetty.util.security.CertificateUtils;
import org.eclipse.jetty.util.security.CertificateValidator;
import org.eclipse.jetty.util.security.Constraint;
import org.eclipse.jetty.util.security.Password;

/* loaded from: classes4.dex */
public class ClientCertAuthenticator extends LoginAuthenticator {
    public static final String PASSWORD_PROPERTY = "org.eclipse.jetty.ssl.password";
    public String _crlPath;
    public String _ocspResponderURL;
    public transient Password _trustStorePassword;
    public String _trustStorePath;
    public String _trustStoreProvider;
    public boolean _validateCerts;
    public String _trustStoreType = "JKS";
    public int _maxCertPathLength = -1;
    public boolean _enableCRLDP = false;
    public boolean _enableOCSP = false;

    @Override // org.eclipse.jetty.security.Authenticator
    public String getAuthMethod() {
        return Constraint.__CERT_AUTH;
    }

    public String getCrlPath() {
        return this._crlPath;
    }

    public KeyStore getKeyStore(InputStream inputStream, String str, String str2, String str3, String str4) throws Exception {
        return CertificateUtils.getKeyStore(inputStream, str, str2, str3, str4);
    }

    public int getMaxCertPathLength() {
        return this._maxCertPathLength;
    }

    public String getOcspResponderURL() {
        return this._ocspResponderURL;
    }

    public String getTrustStore() {
        return this._trustStorePath;
    }

    public String getTrustStoreProvider() {
        return this._trustStoreProvider;
    }

    public String getTrustStoreType() {
        return this._trustStoreType;
    }

    public boolean isEnableCRLDP() {
        return this._enableCRLDP;
    }

    public boolean isEnableOCSP() {
        return this._enableOCSP;
    }

    public boolean isValidateCerts() {
        return this._validateCerts;
    }

    public Collection<? extends CRL> loadCRL(String str) throws Exception {
        return CertificateUtils.loadCRL(str);
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public boolean secureResponse(ServletRequest servletRequest, ServletResponse servletResponse, boolean z, Authentication.User user) throws ServerAuthException {
        return true;
    }

    public void setCrlPath(String str) {
        this._crlPath = str;
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

    public void setTrustStore(String str) {
        this._trustStorePath = str;
    }

    public void setTrustStorePassword(String str) {
        this._trustStorePassword = Password.getPassword("org.eclipse.jetty.ssl.password", str, null);
    }

    public void setTrustStoreProvider(String str) {
        this._trustStoreProvider = str;
    }

    public void setTrustStoreType(String str) {
        this._trustStoreType = str;
    }

    public void setValidateCerts(boolean z) {
        this._validateCerts = z;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public Authentication validateRequest(ServletRequest servletRequest, ServletResponse servletResponse, boolean z) throws ServerAuthException {
        if (!z) {
            return new DeferredAuthentication(this);
        }
        ce0 ce0Var = (ce0) servletResponse;
        X509Certificate[] x509CertificateArr = (X509Certificate[]) ((ae0) servletRequest).getAttribute("javax.servlet.request.X509Certificate");
        if (x509CertificateArr != null) {
            try {
                if (x509CertificateArr.length > 0) {
                    if (this._validateCerts) {
                        new CertificateValidator(getKeyStore(null, this._trustStorePath, this._trustStoreType, this._trustStoreProvider, this._trustStorePassword == null ? null : this._trustStorePassword.toString()), loadCRL(this._crlPath)).validate(x509CertificateArr);
                    }
                    for (X509Certificate x509Certificate : x509CertificateArr) {
                        if (x509Certificate != null) {
                            Principal subjectDN = x509Certificate.getSubjectDN();
                            if (subjectDN == null) {
                                subjectDN = x509Certificate.getIssuerDN();
                            }
                            UserIdentity login = login(subjectDN == null ? "clientcert" : subjectDN.getName(), B64Code.encode(x509Certificate.getSignature()), servletRequest);
                            if (login != null) {
                                return new UserAuthentication(getAuthMethod(), login);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                throw new ServerAuthException(e.getMessage());
            }
        }
        if (DeferredAuthentication.isDeferred(ce0Var)) {
            return Authentication.UNAUTHENTICATED;
        }
        ce0Var.sendError(403);
        return Authentication.SEND_FAILURE;
    }
}
