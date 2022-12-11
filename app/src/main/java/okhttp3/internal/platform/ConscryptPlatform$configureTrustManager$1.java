package okhttp3.internal.platform;

import javax.net.ssl.SSLSession;
import me.tvspark.ef0;
import org.conscrypt.ConscryptHostnameVerifier;

@ef0
/* loaded from: classes4.dex */
public final class ConscryptPlatform$configureTrustManager$1 implements ConscryptHostnameVerifier {
    public static final ConscryptPlatform$configureTrustManager$1 INSTANCE = new ConscryptPlatform$configureTrustManager$1();

    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
