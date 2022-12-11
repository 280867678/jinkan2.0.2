package okhttp3.internal.tls;

import com.umeng.analytics.pro.C1615d;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.TypeCastException;
import kotlin.collections.EmptyList;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import me.tvspark.r40;
import okhttp3.CertificatePinner;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2ExchangeCodec;

@ef0
/* loaded from: classes4.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    public static final int ALT_DNS_NAME = 2;
    public static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return EmptyList.INSTANCE;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && !(!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list.get(0), Integer.valueOf(i))) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return EmptyList.INSTANCE;
        }
    }

    private final boolean verifyHostname(String str, String str2) {
        if (!(str == null || str.length() == 0) && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".", false, 2) && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "..", false, 2)) {
            if (!(str2 == null || str2.length() == 0) && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, ".", false, 2) && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "..", false, 2)) {
                if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".", false, 2)) {
                    str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".");
                }
                if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, ".", false, 2)) {
                    str2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, ".");
                }
                Locale locale = Locale.US;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) locale, "Locale.US");
                if (str2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = str2.toLowerCase(locale);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) lowerCase, (CharSequence) "*", false, 2)) {
                    return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) lowerCase);
                }
                if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lowerCase, CertificatePinner.WILDCARD, false, 2) || nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) lowerCase, '*', 1, false, 4) != -1 || str.length() < lowerCase.length() || ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) CertificatePinner.WILDCARD, (Object) lowerCase)) {
                    return false;
                }
                String substring = lowerCase.substring(1);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.String).substring(startIndex)");
                if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, substring, false, 2)) {
                    return false;
                }
                int length = str.length() - substring.length();
                return length <= 0 || nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, '.', length - 1, false, 4) == -1;
            }
        }
        return false;
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        Locale locale = Locale.US;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) locale, "Locale.US");
        if (str != null) {
            String lowerCase = str.toLowerCase(locale);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
            if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
                return false;
            }
            for (String str2 : subjectAltNames) {
                if (INSTANCE.verifyHostname(lowerCase, str2)) {
                    return true;
                }
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if (!(subjectAltNames instanceof Collection) || !subjectAltNames.isEmpty()) {
            for (String str2 : subjectAltNames) {
                if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate x509Certificate) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509Certificate, "certificate");
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getSubjectAltNames(x509Certificate, 7), getSubjectAltNames(x509Certificate, 2));
    }

    public final boolean verify(String str, X509Certificate x509Certificate) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Http2ExchangeCodec.HOST);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x509Certificate, "certificate");
        return Util.canParseAsIpAddress(str) ? verifyIpAddress(str, x509Certificate) : verifyHostname(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Http2ExchangeCodec.HOST);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSession, C1615d.f3332aw);
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            return verify(str, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }
}
