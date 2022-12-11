package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.kg0;
import me.tvspark.outline;
import me.tvspark.r40;
import okhttp3.internal.Util;

@ef0
/* loaded from: classes4.dex */
public final class ConnectionSpec {
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final ConnectionSpec MODERN_TLS;
    public static final ConnectionSpec RESTRICTED_TLS;
    public final String[] cipherSuitesAsString;
    public final boolean isTls;
    public final boolean supportsTlsExtensions;
    public final String[] tlsVersionsAsString;
    public static final Companion Companion = new Companion(null);
    public static final CipherSuite[] RESTRICTED_CIPHER_SUITES = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256};
    public static final CipherSuite[] APPROVED_CIPHER_SUITES = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();

    @ef0
    /* loaded from: classes4.dex */
    public static final class Builder {
        public String[] cipherSuites;
        public boolean supportsTlsExtensions;
        public boolean tls;
        public String[] tlsVersions;

        public Builder(ConnectionSpec connectionSpec) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(connectionSpec, "connectionSpec");
            this.tls = connectionSpec.isTls();
            this.cipherSuites = connectionSpec.cipherSuitesAsString;
            this.tlsVersions = connectionSpec.tlsVersionsAsString;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions();
        }

        public Builder(boolean z) {
            this.tls = z;
        }

        public final Builder allEnabledCipherSuites() {
            if (this.tls) {
                this.cipherSuites = null;
                return this;
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final Builder allEnabledTlsVersions() {
            if (this.tls) {
                this.tlsVersions = null;
                return this;
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public final ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }

        public final Builder cipherSuites(String... strArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, "cipherSuites");
            if (this.tls) {
                if (!(!(strArr.length == 0))) {
                    throw new IllegalArgumentException("At least one cipher suite is required".toString());
                }
                Object clone = strArr.clone();
                if (clone == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                this.cipherSuites = (String[]) clone;
                return this;
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cipherSuiteArr, "cipherSuites");
            if (this.tls) {
                ArrayList arrayList = new ArrayList(cipherSuiteArr.length);
                for (CipherSuite cipherSuite : cipherSuiteArr) {
                    arrayList.add(cipherSuite.javaName());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                String[] strArr = (String[]) array;
                return cipherSuites((String[]) Arrays.copyOf(strArr, strArr.length));
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final String[] getCipherSuites$okhttp() {
            return this.cipherSuites;
        }

        public final boolean getSupportsTlsExtensions$okhttp() {
            return this.supportsTlsExtensions;
        }

        public final boolean getTls$okhttp() {
            return this.tls;
        }

        public final String[] getTlsVersions$okhttp() {
            return this.tlsVersions;
        }

        public final void setCipherSuites$okhttp(String[] strArr) {
            this.cipherSuites = strArr;
        }

        public final void setSupportsTlsExtensions$okhttp(boolean z) {
            this.supportsTlsExtensions = z;
        }

        public final void setTls$okhttp(boolean z) {
            this.tls = z;
        }

        public final void setTlsVersions$okhttp(String[] strArr) {
            this.tlsVersions = strArr;
        }

        public final Builder supportsTlsExtensions(boolean z) {
            if (this.tls) {
                this.supportsTlsExtensions = z;
                return this;
            }
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }

        public final Builder tlsVersions(String... strArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, "tlsVersions");
            if (this.tls) {
                if (!(!(strArr.length == 0))) {
                    throw new IllegalArgumentException("At least one TLS version is required".toString());
                }
                Object clone = strArr.clone();
                if (clone == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                this.tlsVersions = (String[]) clone;
                return this;
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public final Builder tlsVersions(TlsVersion... tlsVersionArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tlsVersionArr, "tlsVersions");
            if (this.tls) {
                ArrayList arrayList = new ArrayList(tlsVersionArr.length);
                for (TlsVersion tlsVersion : tlsVersionArr) {
                    arrayList.add(tlsVersion.javaName());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                String[] strArr = (String[]) array;
                return tlsVersions((String[]) Arrays.copyOf(strArr, strArr.length));
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
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
    }

    static {
        Builder builder = new Builder(true);
        CipherSuite[] cipherSuiteArr = RESTRICTED_CIPHER_SUITES;
        RESTRICTED_TLS = builder.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, cipherSuiteArr.length)).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
        Builder builder2 = new Builder(true);
        CipherSuite[] cipherSuiteArr2 = APPROVED_CIPHER_SUITES;
        MODERN_TLS = builder2.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length)).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
        Builder builder3 = new Builder(true);
        CipherSuite[] cipherSuiteArr3 = APPROVED_CIPHER_SUITES;
        COMPATIBLE_TLS = builder3.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr3, cipherSuiteArr3.length)).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    }

    public ConnectionSpec(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.isTls = z;
        this.supportsTlsExtensions = z2;
        this.cipherSuitesAsString = strArr;
        this.tlsVersionsAsString = strArr2;
    }

    private final ConnectionSpec supportedSpec(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.cipherSuitesAsString != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            enabledCipherSuites = Util.intersect(enabledCipherSuites2, this.cipherSuitesAsString, CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.tlsVersionsAsString != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) enabledProtocols2, "sslSocket.enabledProtocols");
            enabledProtocols = Util.intersect(enabledProtocols2, this.tlsVersionsAsString, kg0.Wwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) supportedCipherSuites, "supportedCipherSuites");
        int indexOf = Util.indexOf(supportedCipherSuites, "TLS_FALLBACK_SCSV", CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        if (z && indexOf != -1) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[indexOf];
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, "supportedCipherSuites[indexOfFallbackScsv]");
            enabledCipherSuites = Util.concat(enabledCipherSuites, str);
        }
        Builder builder = new Builder(this);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) enabledCipherSuites, "cipherSuitesIntersection");
        Builder cipherSuites = builder.cipherSuites((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) enabledProtocols, "tlsVersionsIntersection");
        return cipherSuites.tlsVersions((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length)).build();
    }

    /* renamed from: -deprecated_cipherSuites  reason: not valid java name */
    public final List<CipherSuite> m5003deprecated_cipherSuites() {
        return cipherSuites();
    }

    /* renamed from: -deprecated_supportsTlsExtensions  reason: not valid java name */
    public final boolean m5004deprecated_supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    /* renamed from: -deprecated_tlsVersions  reason: not valid java name */
    public final List<TlsVersion> m5005deprecated_tlsVersions() {
        return tlsVersions();
    }

    public final void apply$okhttp(SSLSocket sSLSocket, boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "sslSocket");
        ConnectionSpec supportedSpec = supportedSpec(sSLSocket, z);
        if (supportedSpec.tlsVersions() != null) {
            sSLSocket.setEnabledProtocols(supportedSpec.tlsVersionsAsString);
        }
        if (supportedSpec.cipherSuites() != null) {
            sSLSocket.setEnabledCipherSuites(supportedSpec.cipherSuitesAsString);
        }
    }

    public final List<CipherSuite> cipherSuites() {
        String[] strArr = this.cipherSuitesAsString;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(CipherSuite.Companion.forJavaName(str));
            }
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) arrayList);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z = this.isTls;
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        if (z != connectionSpec.isTls) {
            return false;
        }
        return !z || (Arrays.equals(this.cipherSuitesAsString, connectionSpec.cipherSuitesAsString) && Arrays.equals(this.tlsVersionsAsString, connectionSpec.tlsVersionsAsString) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions);
    }

    public int hashCode() {
        if (this.isTls) {
            String[] strArr = this.cipherSuitesAsString;
            int i = 0;
            int hashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
            String[] strArr2 = this.tlsVersionsAsString;
            if (strArr2 != null) {
                i = Arrays.hashCode(strArr2);
            }
            return ((hashCode + i) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
        }
        return 17;
    }

    public final boolean isCompatible(SSLSocket sSLSocket) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "socket");
        if (!this.isTls) {
            return false;
        }
        String[] strArr = this.tlsVersionsAsString;
        if (strArr != null && !Util.hasIntersection(strArr, sSLSocket.getEnabledProtocols(), kg0.Wwwwwwwwwwwwwwwwwwwwwwww)) {
            return false;
        }
        String[] strArr2 = this.cipherSuitesAsString;
        return strArr2 == null || Util.hasIntersection(strArr2, sSLSocket.getEnabledCipherSuites(), CipherSuite.Companion.getORDER_BY_NAME$okhttp());
    }

    public final boolean isTls() {
        return this.isTls;
    }

    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public final List<TlsVersion> tlsVersions() {
        String[] strArr = this.tlsVersionsAsString;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(TlsVersion.Companion.forJavaName(str));
            }
            return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) arrayList);
        }
        return null;
    }

    public String toString() {
        if (!this.isTls) {
            return "ConnectionSpec()";
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ConnectionSpec(", "cipherSuites=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Objects.toString(cipherSuites(), "[all enabled]"));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("tlsVersions=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Objects.toString(tlsVersions(), "[all enabled]"));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("supportsTlsExtensions=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.supportsTlsExtensions);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
