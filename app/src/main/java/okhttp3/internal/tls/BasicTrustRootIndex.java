package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import me.tvspark.ef0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes4.dex */
public final class BasicTrustRootIndex implements TrustRootIndex {
    public final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;

    public BasicTrustRootIndex(X509Certificate... x509CertificateArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509CertificateArr, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) subjectX500Principal, "caCert.subjectX500Principal");
            Object obj = linkedHashMap.get(subjectX500Principal);
            if (obj == null) {
                obj = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, obj);
            }
            ((Set) obj).add(x509Certificate);
        }
        this.subjectToCaCerts = linkedHashMap;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof BasicTrustRootIndex) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((BasicTrustRootIndex) obj).subjectToCaCerts, this.subjectToCaCerts));
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
        boolean z;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509Certificate, "cert");
        Set<X509Certificate> set = this.subjectToCaCerts.get(x509Certificate.getIssuerX500Principal());
        Object obj = null;
        if (set != null) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                try {
                    x509Certificate.verify(((X509Certificate) next).getPublicKey());
                    z = true;
                    continue;
                } catch (Exception unused) {
                    z = false;
                    continue;
                }
                if (z) {
                    obj = next;
                    break;
                }
            }
            return (X509Certificate) obj;
        }
        return null;
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
