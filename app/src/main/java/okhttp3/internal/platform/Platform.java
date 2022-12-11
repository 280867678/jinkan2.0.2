package okhttp3.internal.platform;

import androidx.transition.Transition;
import com.tencent.bugly.beta.tinker.TinkerUtils;
import com.umeng.analytics.pro.C1615d;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.uw0;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

@ef0
/* loaded from: classes4.dex */
public class Platform {
    public static final Companion Companion;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());
    public static volatile Platform platform;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Platform findPlatform() {
            ConscryptPlatform buildIfSupported;
            Platform buildIfSupported2 = AndroidPlatform.Companion.buildIfSupported();
            if (buildIfSupported2 != null) {
                return buildIfSupported2;
            }
            if (isConscryptPreferred() && (buildIfSupported = ConscryptPlatform.Companion.buildIfSupported()) != null) {
                return buildIfSupported;
            }
            Jdk9Platform buildIfSupported3 = Jdk9Platform.Companion.buildIfSupported();
            if (buildIfSupported3 != null) {
                return buildIfSupported3;
            }
            Platform buildIfSupported4 = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
            return buildIfSupported4 != null ? buildIfSupported4 : new Platform();
        }

        public static /* synthetic */ void resetForTests$default(Companion companion, Platform platform, int i, Object obj) {
            if ((i & 1) != 0) {
                platform = companion.findPlatform();
            }
            companion.resetForTests(platform);
        }

        public final List<String> alpnProtocolNames(List<? extends Protocol> list) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "protocols");
            ArrayList<Protocol> arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, 10));
            for (Protocol protocol : arrayList) {
                arrayList2.add(protocol.toString());
            }
            return arrayList2;
        }

        public final byte[] concatLengthPrefixed(List<? extends Protocol> list) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "protocols");
            uw0 uw0Var = new uw0();
            for (String str : alpnProtocolNames(list)) {
                uw0Var.mo4963writeByte(str.length());
                uw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            }
            return uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public final Platform get() {
            return Platform.platform;
        }

        public final boolean isConscryptPreferred() {
            Provider provider = Security.getProviders()[0];
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) provider, "Security.getProviders()[0]");
            return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) "Conscrypt", (Object) provider.getName());
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
            return r4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
            Object readFieldOrNull;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, Transition.MATCH_INSTANCE_STR);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, "fieldType");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "fieldName");
            Class<?> cls2 = obj.getClass();
            while (true) {
                T t = null;
                if (!(!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls2, Object.class))) {
                    if ((!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "delegate")) && (readFieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) != null) {
                        return (T) readFieldOrNull(readFieldOrNull, cls, str);
                    }
                    return null;
                }
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) declaredField, "field");
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (cls.isInstance(obj2)) {
                        t = cls.cast(obj2);
                        break;
                    }
                    break;
                } catch (NoSuchFieldException unused) {
                    cls2 = cls2.getSuperclass();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) cls2, "c.superclass");
                }
            }
        }

        public final void resetForTests(Platform platform) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(platform, TinkerUtils.PLATFORM);
            Platform.platform = platform;
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        platform = companion.findPlatform();
    }

    public static final Platform get() {
        return Companion.get();
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "sslSocket");
    }

    public final CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory sSLSocketFactory) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocketFactory, "sslSocketFactory");
        X509TrustManager trustManager = trustManager(sSLSocketFactory);
        if (trustManager != null) {
            return buildCertificateChainCleaner(trustManager);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to extract the trust manager on ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Companion.get());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("sslSocketFactory is ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(sSLSocketFactory.getClass());
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509TrustManager, "trustManager");
        return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) acceptedIssuers, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocketFactory, "socketFactory");
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "sslSocket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "protocols");
    }

    public void configureTrustManager(X509TrustManager x509TrustManager) {
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket, "socket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    public final String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "socket");
        return null;
    }

    public Object getStackTraceForCloseable(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "closer");
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "hostname");
        return true;
    }

    public void log(int i, String str, Throwable th) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "message");
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void logCloseableLeak(String str, Object obj) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "message");
        if (obj == null) {
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        log(5, str, (Throwable) obj);
    }

    public SSLContext newSSLContext() {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public X509TrustManager platformTrustManager() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) trustManagerFactory, "factory");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        boolean z = true;
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            z = false;
        }
        if (z) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager == null) {
                throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            }
            return (X509TrustManager) trustManager;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) arrays, "java.util.Arrays.toString(this)");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(arrays);
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocketFactory, "sslSocketFactory");
        try {
            Class<?> cls = Class.forName("sun.security.ssl.SSLContextImpl");
            Companion companion = Companion;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) cls, "sslContextClass");
            Object readFieldOrNull = companion.readFieldOrNull(sSLSocketFactory, cls, C1615d.f3292R);
            if (readFieldOrNull == null) {
                return null;
            }
            return (X509TrustManager) Companion.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
