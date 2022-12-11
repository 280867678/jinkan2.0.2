package okhttp3;

import com.arialyy.aria.core.ProtocolType;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.outline;

@ef0
/* loaded from: classes4.dex */
public enum TlsVersion {
    TLS_1_3("TLSv1.3"),
    TLS_1_2(ProtocolType.TLSv1_2),
    TLS_1_1(ProtocolType.TLSv1_1),
    TLS_1_0(ProtocolType.TLSv1),
    SSL_3_0(ProtocolType.SSLv3);
    
    public static final Companion Companion = new Companion(null);
    public final String javaName;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final TlsVersion forJavaName(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "javaName");
            int hashCode = str.hashCode();
            if (hashCode != 79201641) {
                if (hashCode != 79923350) {
                    switch (hashCode) {
                        case -503070503:
                            if (str.equals(ProtocolType.TLSv1_1)) {
                                return TlsVersion.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (str.equals(ProtocolType.TLSv1_2)) {
                                return TlsVersion.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (str.equals("TLSv1.3")) {
                                return TlsVersion.TLS_1_3;
                            }
                            break;
                    }
                } else if (str.equals(ProtocolType.TLSv1)) {
                    return TlsVersion.TLS_1_0;
                }
            } else if (str.equals(ProtocolType.SSLv3)) {
                return TlsVersion.SSL_3_0;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected TLS version: ", str));
        }
    }

    TlsVersion(String str) {
        this.javaName = str;
    }

    public static final TlsVersion forJavaName(String str) {
        return Companion.forJavaName(str);
    }

    /* renamed from: -deprecated_javaName  reason: not valid java name */
    public final String m5110deprecated_javaName() {
        return this.javaName;
    }

    public final String javaName() {
        return this.javaName;
    }
}
