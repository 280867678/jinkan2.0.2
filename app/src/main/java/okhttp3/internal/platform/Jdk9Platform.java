package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import okhttp3.Protocol;

@ef0
/* loaded from: classes4.dex */
public final class Jdk9Platform extends Platform {
    public static final Companion Companion = new Companion(null);
    public final Method getProtocolMethod;
    public final Method setProtocolMethod;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final Jdk9Platform buildIfSupported() {
            try {
                Method method = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
                Method method2 = SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method, "setProtocolMethod");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method2, "getProtocolMethod");
                return new Jdk9Platform(method, method2);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
    }

    public Jdk9Platform(Method method, Method method2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method, "setProtocolMethod");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method2, "getProtocolMethod");
        this.setProtocolMethod = method;
        this.getProtocolMethod = method2;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "sslSocket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "protocols");
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> alpnProtocolNames = Platform.Companion.alpnProtocolNames(list);
            Method method = this.setProtocolMethod;
            Object[] objArr = new Object[1];
            if (alpnProtocolNames == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
            }
            Object[] array = alpnProtocolNames.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            objArr[0] = array;
            method.invoke(sSLParameters, objArr);
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set SSL parameters", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set SSL parameters", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "socket");
        try {
            String str = (String) this.getProtocolMethod.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
