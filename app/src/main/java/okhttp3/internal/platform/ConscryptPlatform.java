package okhttp3.internal.platform;

import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;

@ef0
/* loaded from: classes4.dex */
public final class ConscryptPlatform extends Platform {
    public static final Companion Companion = new Companion(null);

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public static /* synthetic */ boolean atLeastVersion$default(Companion companion, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = 0;
            }
            return companion.atLeastVersion(i, i2, i3);
        }

        public final boolean atLeastVersion(int i, int i2, int i3) {
            Conscrypt.Version version = Conscrypt.version();
            return version.major() != i ? version.major() > i : version.minor() != i2 ? version.minor() > i2 : version.patch() >= i3;
        }

        public final ConscryptPlatform buildIfSupported() {
            try {
                Class.forName("org.conscrypt.Conscrypt$Version");
                if (Conscrypt.isAvailable() && atLeastVersion(2, 1, 0)) {
                    return new ConscryptPlatform(null);
                }
                return null;
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    public ConscryptPlatform() {
    }

    public /* synthetic */ ConscryptPlatform(gi0 gi0Var) {
        this();
    }

    private final Provider getProvider() {
        Provider build = Conscrypt.newProviderBuilder().provideTrustManager(true).build();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) build, "Conscrypt.newProviderBui…rustManager(true).build()");
        return build;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocketFactory, "socketFactory");
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "sslSocket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "protocols");
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.configureTlsExtensions(sSLSocket, str, list);
            return;
        }
        if (str != null) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setHostname(sSLSocket, str);
        }
        List<String> alpnProtocolNames = Platform.Companion.alpnProtocolNames(list);
        if (alpnProtocolNames == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        Object[] array = alpnProtocolNames.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTrustManager(X509TrustManager x509TrustManager) {
        if (Conscrypt.isConscrypt(x509TrustManager)) {
            Conscrypt.setHostnameVerifier(x509TrustManager, ConscryptPlatform$configureTrustManager$1.INSTANCE);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "socket");
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.getSelectedProtocol(sSLSocket);
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext newSSLContext() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", getProvider());
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager platformTrustManager() {
        X509TrustManager defaultX509TrustManager = Conscrypt.getDefaultX509TrustManager();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) defaultX509TrustManager, "Conscrypt.getDefaultX509TrustManager()");
        return defaultX509TrustManager;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocketFactory, "sslSocketFactory");
        if (!Conscrypt.isConscrypt(sSLSocketFactory)) {
            return super.trustManager(sSLSocketFactory);
        }
        try {
            Object readFieldOrNull = Platform.Companion.readFieldOrNull(sSLSocketFactory, Object.class, "sslParameters");
            if (readFieldOrNull == null) {
                return null;
            }
            return (X509TrustManager) Platform.Companion.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
        } catch (Exception e) {
            throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e);
        }
    }
}
