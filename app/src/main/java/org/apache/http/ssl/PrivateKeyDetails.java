package org.apache.http.ssl;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import org.apache.http.util.Args;

/* loaded from: classes4.dex */
public final class PrivateKeyDetails {
    public final X509Certificate[] certChain;
    public final String type;

    public PrivateKeyDetails(String str, X509Certificate[] x509CertificateArr) {
        this.type = (String) Args.notNull(str, "Private key type");
        this.certChain = x509CertificateArr;
    }

    public X509Certificate[] getCertChain() {
        return this.certChain;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return this.type + ':' + Arrays.toString(this.certChain);
    }
}
