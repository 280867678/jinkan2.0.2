package okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import com.just.agentweb.JsCallJava;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import okhttp3.Protocol;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

@ef0
/* loaded from: classes4.dex */
public final class AndroidPlatform extends Platform {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_LOG_LENGTH = 4000;
    public final CloseGuard closeGuard = CloseGuard.Companion.get();
    public final Method getAlpnSelectedProtocol;
    public final Method setAlpnProtocols;
    public final Method setHostname;
    public final Method setUseSessionTickets;
    public final Class<?> sslParametersClass;
    public final Class<?> sslSocketClass;

    @ef0
    /* loaded from: classes4.dex */
    public static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
        public final Method checkServerTrusted;
        public final Object x509TrustManagerExtensions;

        public AndroidCertificateChainCleaner(Object obj, Method method) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "x509TrustManagerExtensions");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method, "checkServerTrusted");
            this.x509TrustManagerExtensions = obj;
            this.checkServerTrusted = method;
        }

        @Override // okhttp3.internal.tls.CertificateChainCleaner
        public List<Certificate> clean(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "chain");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "hostname");
            try {
                Object[] array = list.toArray(new X509Certificate[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                Object invoke = this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, (X509Certificate[]) array, "RSA", str);
                if (invoke == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<java.security.cert.Certificate>");
                }
                return (List) invoke;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof AndroidCertificateChainCleaner;
        }

        public int hashCode() {
            return 0;
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class CloseGuard {
        public static final Companion Companion = new Companion(null);
        public final Method getMethod;
        public final Method openMethod;
        public final Method warnIfOpenMethod;

        @ef0
        /* loaded from: classes4.dex */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(gi0 gi0Var) {
                this();
            }

            public final CloseGuard get() {
                Method method;
                Method method2;
                Method method3 = null;
                try {
                    Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                    Method method4 = cls.getMethod("get", new Class[0]);
                    method2 = cls.getMethod("open", String.class);
                    method = cls.getMethod("warnIfOpen", new Class[0]);
                    method3 = method4;
                } catch (Exception unused) {
                    method = null;
                    method2 = null;
                }
                return new CloseGuard(method3, method2, method);
            }
        }

        public CloseGuard(Method method, Method method2, Method method3) {
            this.getMethod = method;
            this.openMethod = method2;
            this.warnIfOpenMethod = method3;
        }

        public final Object createAndOpen(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "closer");
            Method method = this.getMethod;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    Method method2 = this.openMethod;
                    if (method2 != null) {
                        method2.invoke(invoke, str);
                        return invoke;
                    }
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public final boolean warnIfOpen(Object obj) {
            if (obj != null) {
                try {
                    Method method = this.warnIfOpenMethod;
                    if (method != null) {
                        method.invoke(obj, new Object[0]);
                        return true;
                    }
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final Platform buildIfSupported() {
            try {
                Class<?> cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) cls, "Class.forName(\"com.andro…crypt.SSLParametersImpl\")");
                Class<?> cls2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) cls2, "Class.forName(\"com.andro…crypt.OpenSSLSocketImpl\")");
                try {
                    Method declaredMethod = cls2.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
                    Method method = cls2.getMethod("setHostname", String.class);
                    Method method2 = cls2.getMethod("getAlpnSelectedProtocol", new Class[0]);
                    Method method3 = cls2.getMethod("setAlpnProtocols", byte[].class);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) declaredMethod, "setUseSessionTickets");
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method, "setHostname");
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method2, "getAlpnSelectedProtocol");
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method3, "setAlpnProtocols");
                    return new AndroidPlatform(cls, cls2, declaredMethod, method, method2, method3);
                } catch (NoSuchMethodException unused) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected Android API level 21+ but was ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Build.VERSION.SDK_INT);
                    throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class CustomTrustRootIndex implements TrustRootIndex {
        public final Method findByIssuerAndSignatureMethod;
        public final X509TrustManager trustManager;

        public CustomTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509TrustManager, "trustManager");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method, "findByIssuerAndSignatureMethod");
            this.trustManager = x509TrustManager;
            this.findByIssuerAndSignatureMethod = method;
        }

        private final X509TrustManager component1() {
            return this.trustManager;
        }

        private final Method component2() {
            return this.findByIssuerAndSignatureMethod;
        }

        public static /* synthetic */ CustomTrustRootIndex copy$default(CustomTrustRootIndex customTrustRootIndex, X509TrustManager x509TrustManager, Method method, int i, Object obj) {
            if ((i & 1) != 0) {
                x509TrustManager = customTrustRootIndex.trustManager;
            }
            if ((i & 2) != 0) {
                method = customTrustRootIndex.findByIssuerAndSignatureMethod;
            }
            return customTrustRootIndex.copy(x509TrustManager, method);
        }

        public final CustomTrustRootIndex copy(X509TrustManager x509TrustManager, Method method) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509TrustManager, "trustManager");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method, "findByIssuerAndSignatureMethod");
            return new CustomTrustRootIndex(x509TrustManager, method);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof CustomTrustRootIndex)) {
                    return false;
                }
                CustomTrustRootIndex customTrustRootIndex = (CustomTrustRootIndex) obj;
                return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.trustManager, customTrustRootIndex.trustManager) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.findByIssuerAndSignatureMethod, customTrustRootIndex.findByIssuerAndSignatureMethod);
            }
            return true;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509Certificate, "cert");
            try {
                Object invoke = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, x509Certificate);
                if (invoke == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
                }
                return ((TrustAnchor) invoke).getTrustedCert();
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.trustManager;
            int i = 0;
            int hashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.findByIssuerAndSignatureMethod;
            if (method != null) {
                i = method.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("CustomTrustRootIndex(trustManager=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.trustManager);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", findByIssuerAndSignatureMethod=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.findByIssuerAndSignatureMethod);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public AndroidPlatform(Class<?> cls, Class<?> cls2, Method method, Method method2, Method method3, Method method4) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, "sslParametersClass");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls2, "sslSocketClass");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method, "setUseSessionTickets");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method2, "setHostname");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method3, "getAlpnSelectedProtocol");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method4, "setAlpnProtocols");
        this.sslParametersClass = cls;
        this.sslSocketClass = cls2;
        this.setUseSessionTickets = method;
        this.setHostname = method2;
        this.getAlpnSelectedProtocol = method3;
        this.setAlpnProtocols = method4;
    }

    private final boolean api23IsCleartextTrafficPermitted(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            Object invoke = cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0]);
            if (invoke == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
            }
            return ((Boolean) invoke).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        }
    }

    private final boolean api24IsCleartextTrafficPermitted(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            Object invoke = cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str);
            if (invoke == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
            }
            return ((Boolean) invoke).booleanValue();
        } catch (NoSuchMethodException unused) {
            return api23IsCleartextTrafficPermitted(str, cls, obj);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509TrustManager, "trustManager");
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            Object newInstance = cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager);
            Method method = cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newInstance, "extensions");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method, "checkServerTrusted");
            return new AndroidCertificateChainCleaner(newInstance, method);
        } catch (Exception unused) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) declaredMethod, JsCallJava.KEY_METHOD);
            declaredMethod.setAccessible(true);
            return new CustomTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "sslSocket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "protocols");
        if (!this.sslSocketClass.isInstance(sSLSocket)) {
            return;
        }
        if (str != null) {
            try {
                this.setUseSessionTickets.invoke(sSLSocket, true);
                this.setHostname.invoke(sSLSocket, str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
        this.setAlpnProtocols.invoke(sSLSocket, Platform.Companion.concatLengthPrefixed(list));
    }

    @Override // okhttp3.internal.platform.Platform
    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket, "socket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e;
            }
            throw new IOException("Exception in connect", e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "socket");
        if (this.sslSocketClass.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invoke(sSLSocket, new Object[0]);
                if (bArr == null) {
                    return null;
                }
                Charset charset = StandardCharsets.UTF_8;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) charset, "UTF_8");
                return new String(bArr, charset);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public Object getStackTraceForCloseable(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "closer");
        return this.closeGuard.createAndOpen(str);
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "hostname");
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) cls, "networkPolicyClass");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(invoke, "networkSecurityPolicy");
            return api24IsCleartextTrafficPermitted(str, cls, invoke);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (IllegalAccessException e) {
            throw new AssertionError("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            throw new AssertionError("unable to determine cleartext support", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("unable to determine cleartext support", e3);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void log(int i, String str, Throwable th) {
        int min;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "message");
        if (th != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "\n");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(th));
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, '\n', i2, false, 4);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = length;
            }
            while (true) {
                min = Math.min(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2 + MAX_LOG_LENGTH);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str.substring(i2, min), "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (min >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    break;
                }
                i2 = min;
            }
            i2 = min + 1;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void logCloseableLeak(String str, Object obj) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "message");
        if (!this.closeGuard.warnIfOpen(obj)) {
            log(5, str, null);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocketFactory, "sslSocketFactory");
        Object readFieldOrNull = Platform.Companion.readFieldOrNull(sSLSocketFactory, this.sslParametersClass, "sslParameters");
        if (readFieldOrNull == null) {
            try {
                Class<?> cls = Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader());
                Platform.Companion companion = Platform.Companion;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) cls, "gmsSslParametersClass");
                readFieldOrNull = companion.readFieldOrNull(sSLSocketFactory, cls, "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.trustManager(sSLSocketFactory);
            }
        }
        Platform.Companion companion2 = Platform.Companion;
        if (readFieldOrNull != null) {
            X509TrustManager x509TrustManager = (X509TrustManager) companion2.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
            return x509TrustManager != null ? x509TrustManager : (X509TrustManager) Platform.Companion.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }
}
