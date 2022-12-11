package okhttp3;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import org.mozilla.javascript.Token;

@ef0
/* loaded from: classes4.dex */
public final class CipherSuite {
    public final String javaName;
    public static final Companion Companion = new Companion(null);
    public static final Comparator<String> ORDER_BY_NAME = new Comparator<String>() { // from class: okhttp3.CipherSuite$Companion$ORDER_BY_NAME$1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "a");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "b");
            int min = Math.min(str.length(), str2.length());
            for (int i = 4; i < min; i++) {
                char charAt = str.charAt(i);
                char charAt2 = str2.charAt(i);
                if (charAt != charAt2) {
                    return charAt < charAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    };
    public static final Map<String, CipherSuite> INSTANCES = new LinkedHashMap();
    public static final CipherSuite TLS_RSA_WITH_NULL_MD5 = Companion.init("SSL_RSA_WITH_NULL_MD5", 1);
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA = Companion.init("SSL_RSA_WITH_NULL_SHA", 2);
    public static final CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5 = Companion.init("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final CipherSuite TLS_RSA_WITH_RC4_128_MD5 = Companion.init("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final CipherSuite TLS_RSA_WITH_RC4_128_SHA = Companion.init("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = Companion.init("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final CipherSuite TLS_RSA_WITH_DES_CBC_SHA = Companion.init("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA = Companion.init("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = Companion.init("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA = Companion.init("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = Companion.init("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = Companion.init("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA = Companion.init("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = Companion.init("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = Companion.init("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final CipherSuite TLS_DH_anon_WITH_RC4_128_MD5 = Companion.init("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = Companion.init("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA = Companion.init("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = Companion.init("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_SHA = Companion.init("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_SHA = Companion.init("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_MD5 = Companion.init("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = Companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_MD5 = Companion.init("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = Companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA = Companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = Companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = Companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA = Companion.init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA = Companion.init("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA = Companion.init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA = Companion.init("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA256 = Companion.init("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256 = Companion.init("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = Companion.init("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = Companion.init("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = Companion.init("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = Companion.init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = Companion.init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256 = Companion.init("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = Companion.init("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", Token.TARGET);
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = Companion.init("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", Token.EXPR_RESULT);
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = Companion.init("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", Token.JSR);
    public static final CipherSuite TLS_PSK_WITH_RC4_128_SHA = Companion.init("TLS_PSK_WITH_RC4_128_SHA", Token.TYPEOFNAME);
    public static final CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_PSK_WITH_3DES_EDE_CBC_SHA", Token.USE_STACK);
    public static final CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA = Companion.init("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA = Companion.init("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final CipherSuite TLS_RSA_WITH_SEED_CBC_SHA = Companion.init("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", Token.LETEXPR);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV = Companion.init("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final CipherSuite TLS_FALLBACK_SCSV = Companion.init("TLS_FALLBACK_SCSV", 22016);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA = Companion.init("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA = Companion.init("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA = Companion.init("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA = Companion.init("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA = Companion.init("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA = Companion.init("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = Companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = Companion.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = Companion.init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = Companion.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.init("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.init("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    public static final CipherSuite TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.init("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
    public static final CipherSuite TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = Companion.init("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    public static final CipherSuite TLS_AES_128_GCM_SHA256 = Companion.init("TLS_AES_128_GCM_SHA256", 4865);
    public static final CipherSuite TLS_AES_256_GCM_SHA384 = Companion.init("TLS_AES_256_GCM_SHA384", 4866);
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256 = Companion.init("TLS_CHACHA20_POLY1305_SHA256", 4867);
    public static final CipherSuite TLS_AES_128_CCM_SHA256 = Companion.init("TLS_AES_128_CCM_SHA256", 4868);
    public static final CipherSuite TLS_AES_128_CCM_8_SHA256 = Companion.init("TLS_AES_128_CCM_8_SHA256", 4869);

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final CipherSuite init(String str, int i) {
            CipherSuite cipherSuite = new CipherSuite(str, null);
            CipherSuite.INSTANCES.put(str, cipherSuite);
            return cipherSuite;
        }

        private final String secondaryName(String str) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "TLS_", false, 2)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SSL_");
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "SSL_", false, 2)) {
                return str;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TLS_");
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            String substring = str.substring(4);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.String).substring(startIndex)");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(substring);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }

        public final synchronized CipherSuite forJavaName(String str) {
            CipherSuite cipherSuite;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "javaName");
            cipherSuite = (CipherSuite) CipherSuite.INSTANCES.get(str);
            if (cipherSuite == null) {
                cipherSuite = (CipherSuite) CipherSuite.INSTANCES.get(secondaryName(str));
                if (cipherSuite == null) {
                    cipherSuite = new CipherSuite(str, null);
                }
                CipherSuite.INSTANCES.put(str, cipherSuite);
            }
            return cipherSuite;
        }

        public final Comparator<String> getORDER_BY_NAME$okhttp() {
            return CipherSuite.ORDER_BY_NAME;
        }
    }

    public CipherSuite(String str) {
        this.javaName = str;
    }

    public /* synthetic */ CipherSuite(String str, gi0 gi0Var) {
        this(str);
    }

    public static final synchronized CipherSuite forJavaName(String str) {
        CipherSuite forJavaName;
        synchronized (CipherSuite.class) {
            forJavaName = Companion.forJavaName(str);
        }
        return forJavaName;
    }

    /* renamed from: -deprecated_javaName  reason: not valid java name */
    public final String m5002deprecated_javaName() {
        return this.javaName;
    }

    public final String javaName() {
        return this.javaName;
    }

    public String toString() {
        return this.javaName;
    }
}
