package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.collections.EmptyList;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.r40;
import okhttp3.internal.Util;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.util.security.Constraint;

@ef0
/* loaded from: classes4.dex */
public final class Handshake {
    public static final Companion Companion = new Companion(null);
    public final CipherSuite cipherSuite;
    public final List<Certificate> localCertificates;
    public final List<Certificate> peerCertificates;
    public final TlsVersion tlsVersion;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final Handshake m5023deprecated_get(SSLSession sSLSession) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSession, "sslSession");
            return get(sSLSession);
        }

        public final Handshake get(SSLSession sSLSession) throws IOException {
            Certificate[] certificateArr;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSession, "$this$handshake");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite != null) {
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) "SSL_NULL_WITH_NULL_NULL", (Object) cipherSuite)) {
                    throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
                }
                CipherSuite forJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
                String protocol = sSLSession.getProtocol();
                if (protocol == null) {
                    throw new IllegalStateException("tlsVersion == null".toString());
                }
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) Constraint.NONE, (Object) protocol)) {
                    throw new IOException("tlsVersion == NONE");
                }
                TlsVersion forJavaName2 = TlsVersion.Companion.forJavaName(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                List immutableListOf = certificateArr != null ? Util.immutableListOf((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : EmptyList.INSTANCE;
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                return new Handshake(forJavaName2, forJavaName, immutableListOf, localCertificates != null ? Util.immutableListOf((Certificate[]) Arrays.copyOf(localCertificates, localCertificates.length)) : EmptyList.INSTANCE, null);
            }
            throw new IllegalStateException("cipherSuite == null".toString());
        }

        public final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tlsVersion, "tlsVersion");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cipherSuite, "cipherSuite");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "peerCertificates");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list2, "localCertificates");
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(list), Util.toImmutableList(list2), null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.peerCertificates = list;
        this.localCertificates = list2;
    }

    public /* synthetic */ Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List list, List list2, gi0 gi0Var) {
        this(tlsVersion, cipherSuite, list, list2);
    }

    public static final Handshake get(SSLSession sSLSession) throws IOException {
        return Companion.get(sSLSession);
    }

    public static final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }

    private final String getName(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) type, "type");
        return type;
    }

    /* renamed from: -deprecated_cipherSuite  reason: not valid java name */
    public final CipherSuite m5017deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    /* renamed from: -deprecated_localCertificates  reason: not valid java name */
    public final List<Certificate> m5018deprecated_localCertificates() {
        return this.localCertificates;
    }

    /* renamed from: -deprecated_localPrincipal  reason: not valid java name */
    public final Principal m5019deprecated_localPrincipal() {
        return localPrincipal();
    }

    /* renamed from: -deprecated_peerCertificates  reason: not valid java name */
    public final List<Certificate> m5020deprecated_peerCertificates() {
        return this.peerCertificates;
    }

    /* renamed from: -deprecated_peerPrincipal  reason: not valid java name */
    public final Principal m5021deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    /* renamed from: -deprecated_tlsVersion  reason: not valid java name */
    public final TlsVersion m5022deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.tlsVersion == this.tlsVersion && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handshake.cipherSuite, this.cipherSuite) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handshake.peerCertificates, this.peerCertificates) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handshake.localCertificates, this.localCertificates)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.cipherSuite.hashCode();
        int hashCode2 = this.peerCertificates.hashCode();
        return this.localCertificates.hashCode() + ((hashCode2 + ((hashCode + ((this.tlsVersion.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public final Principal localPrincipal() {
        Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((List<? extends Object>) this.localCertificates);
        if (!(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof X509Certificate)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        X509Certificate x509Certificate = (X509Certificate) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    public final List<Certificate> peerCertificates() {
        return this.peerCertificates;
    }

    public final Principal peerPrincipal() {
        Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((List<? extends Object>) this.peerCertificates);
        if (!(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof X509Certificate)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        X509Certificate x509Certificate = (X509Certificate) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Handshake{", "tlsVersion=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.tlsVersion);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TokenParser.f4579SP);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("cipherSuite=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.cipherSuite);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TokenParser.f4579SP);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("peerCertificates=");
        List<Certificate> list = this.peerCertificates;
        ArrayList arrayList = new ArrayList(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, 10));
        for (Certificate certificate : list) {
            arrayList.add(getName(certificate));
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(arrayList);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TokenParser.f4579SP);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("localCertificates=");
        List<Certificate> list2 = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list2, 10));
        for (Certificate certificate2 : list2) {
            arrayList2.add(getName(certificate2));
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(arrayList2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
