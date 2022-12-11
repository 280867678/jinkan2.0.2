package okhttp3;

import com.just.agentweb.DefaultWebClient;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.TypeCastException;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.ni0;
import me.tvspark.nk0;
import me.tvspark.outline;
import me.tvspark.pi0;
import me.tvspark.r40;
import okhttp3.HttpUrl;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

@ef0
/* loaded from: classes4.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    public static final String WILDCARD = "*.";
    public final CertificateChainCleaner certificateChainCleaner;
    public final Set<Pin> pins;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Builder {
        public final List<Pin> pins = new ArrayList();

        public final Builder add(String str, String... strArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "pattern");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, "pins");
            for (String str2 : strArr) {
                this.pins.add(CertificatePinner.Companion.newPin$okhttp(str, str2));
            }
            return this;
        }

        public final CertificatePinner build() {
            Set set;
            List<Pin> list = this.pins;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "$this$toSet");
            int size = list.size();
            if (size == 0) {
                set = EmptySet.INSTANCE;
            } else if (size != 1) {
                set = new LinkedHashSet(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(list.size()));
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable) list, set);
            } else {
                set = Collections.singleton(list.get(0));
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(set, "java.util.Collections.singleton(element)");
            }
            return new CertificatePinner(set, null);
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

        public final Pin newPin$okhttp(String str, String str2) {
            HttpUrl.Companion companion;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "pattern");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "pin");
            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, CertificatePinner.WILDCARD, false, 2)) {
                companion = HttpUrl.Companion;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultWebClient.HTTP_SCHEME);
                String substring = str.substring(2);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.String).substring(startIndex)");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(substring);
            } else {
                companion = HttpUrl.Companion;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultWebClient.HTTP_SCHEME, str);
            }
            String host = companion.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()).host();
            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "sha1/", false, 2)) {
                ByteString.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteString.Companion;
                String substring2 = str2.substring(5);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring2, "(this as java.lang.String).substring(startIndex)");
                ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring2);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    return new Pin(str, host, "sha1/", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            } else if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "sha256/", false, 2)) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("pins must start with 'sha256/' or 'sha1/': ", str2));
            } else {
                ByteString.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ByteString.Companion;
                String substring3 = str2.substring(7);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring3, "(this as java.lang.String).substring(startIndex)");
                ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring3);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                    return new Pin(str, host, "sha256/", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                }
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
        }

        public final String pin(Certificate certificate) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("sha256/");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(toSha256ByteString$okhttp((X509Certificate) certificate).base64());
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        public final ByteString toSha1ByteString$okhttp(X509Certificate x509Certificate) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509Certificate, "$this$toSha1ByteString");
            ByteString.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteString.Companion;
            PublicKey publicKey = x509Certificate.getPublicKey();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) encoded, "publicKey.encoded");
            return ByteString.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, encoded, 0, 0, 3).sha1();
        }

        public final ByteString toSha256ByteString$okhttp(X509Certificate x509Certificate) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509Certificate, "$this$toSha256ByteString");
            ByteString.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteString.Companion;
            PublicKey publicKey = x509Certificate.getPublicKey();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) encoded, "publicKey.encoded");
            return ByteString.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, encoded, 0, 0, 3).sha256();
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Pin {
        public final String canonicalHostname;
        public final ByteString hash;
        public final String hashAlgorithm;
        public final String pattern;

        public Pin(String str, String str2, String str3, ByteString byteString) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "pattern");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "canonicalHostname");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, "hashAlgorithm");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "hash");
            this.pattern = str;
            this.canonicalHostname = str2;
            this.hashAlgorithm = str3;
            this.hash = byteString;
        }

        private final String component2() {
            return this.canonicalHostname;
        }

        public static /* synthetic */ Pin copy$default(Pin pin, String str, String str2, String str3, ByteString byteString, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pin.pattern;
            }
            if ((i & 2) != 0) {
                str2 = pin.canonicalHostname;
            }
            if ((i & 4) != 0) {
                str3 = pin.hashAlgorithm;
            }
            if ((i & 8) != 0) {
                byteString = pin.hash;
            }
            return pin.copy(str, str2, str3, byteString);
        }

        public final String component1() {
            return this.pattern;
        }

        public final String component3() {
            return this.hashAlgorithm;
        }

        public final ByteString component4() {
            return this.hash;
        }

        public final Pin copy(String str, String str2, String str3, ByteString byteString) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "pattern");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "canonicalHostname");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, "hashAlgorithm");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "hash");
            return new Pin(str, str2, str3, byteString);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof Pin)) {
                    return false;
                }
                Pin pin = (Pin) obj;
                return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.pattern, (Object) pin.pattern) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.canonicalHostname, (Object) pin.canonicalHostname) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.hashAlgorithm, (Object) pin.hashAlgorithm) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.hash, pin.hash);
            }
            return true;
        }

        public final ByteString getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            String str = this.pattern;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.canonicalHostname;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.hashAlgorithm;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            ByteString byteString = this.hash;
            if (byteString != null) {
                i = byteString.hashCode();
            }
            return hashCode3 + i;
        }

        public final boolean matches(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "hostname");
            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.pattern, CertificatePinner.WILDCARD, false, 2)) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, '.', 0, false, 6);
                return (str.length() - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) - 1 == this.canonicalHostname.length() && nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, this.canonicalHostname, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1, false, 4);
            }
            return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) this.canonicalHostname);
        }

        public String toString() {
            return this.hashAlgorithm + this.hash.base64();
        }
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public final void check(String str, List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "hostname");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "peerCertificates");
        List<Pin> findMatchingPins$okhttp = findMatchingPins$okhttp(str);
        if (findMatchingPins$okhttp.isEmpty()) {
            return;
        }
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        if (certificateChainCleaner != null) {
            list = certificateChainCleaner.clean(list, str);
        }
        for (Certificate certificate : list) {
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate = (X509Certificate) certificate;
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (Pin pin : findMatchingPins$okhttp) {
                String hashAlgorithm = pin.getHashAlgorithm();
                int hashCode = hashAlgorithm.hashCode();
                if (hashCode != 109397962) {
                    if (hashCode == 2052263656 && hashAlgorithm.equals("sha256/")) {
                        if (byteString2 == null) {
                            byteString2 = Companion.toSha256ByteString$okhttp(x509Certificate);
                        }
                        if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pin.getHash(), byteString2)) {
                            return;
                        }
                    }
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unsupported hashAlgorithm: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(pin.getHashAlgorithm());
                    throw new AssertionError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                } else if (!hashAlgorithm.equals("sha1/")) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unsupported hashAlgorithm: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(pin.getHashAlgorithm());
                    throw new AssertionError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                } else {
                    if (byteString == null) {
                        byteString = Companion.toSha1ByteString$okhttp(x509Certificate);
                    }
                    if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pin.getHash(), byteString)) {
                        return;
                    }
                }
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Certificate pinning failure!", "\n  Peer certificate chain:");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Certificate certificate2 = list.get(i);
            if (certificate2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate2 = (X509Certificate) certificate2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\n    ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Companion.pin(x509Certificate2));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) subjectDN, "x509Certificate.subjectDN");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(subjectDN.getName());
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\n  Pinned certificates for ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
        for (Pin pin2 : findMatchingPins$okhttp) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\n    ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(pin2);
        }
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) sb, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(sb);
    }

    public final void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "hostname");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(certificateArr, "peerCertificates");
        check(str, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(certificateArr));
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(certificatePinner.pins, this.pins) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    public final List<Pin> findMatchingPins$okhttp(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "hostname");
        List list = EmptyList.INSTANCE;
        for (Pin pin : this.pins) {
            if (pin.matches(str)) {
                if (list.isEmpty()) {
                    list = new ArrayList();
                }
                if (!(list instanceof pi0)) {
                    list.add(pin);
                } else {
                    ni0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "kotlin.collections.MutableList");
                    throw null;
                }
            }
        }
        return list;
    }

    public int hashCode() {
        int hashCode = (this.pins.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return hashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }
}
