package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import me.tvspark.ef0;

@ef0
/* loaded from: classes4.dex */
public interface TrustRootIndex {
    X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate);
}
