package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import okhttp3.internal.platform.Platform;

@ef0
/* loaded from: classes4.dex */
public abstract class CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final CertificateChainCleaner get(X509TrustManager x509TrustManager) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509TrustManager, "trustManager");
            return Platform.Companion.get().buildCertificateChainCleaner(x509TrustManager);
        }

        public final CertificateChainCleaner get(X509Certificate... x509CertificateArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509CertificateArr, "caCerts");
            return new BasicCertificateChainCleaner(new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(x509CertificateArr, x509CertificateArr.length)));
        }
    }

    public abstract List<Certificate> clean(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException;
}
