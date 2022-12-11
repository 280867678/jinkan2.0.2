package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.outline;
import okio.ByteString;

@ef0
/* loaded from: classes4.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    public static final String basic(String str, String str2) {
        return basic$default(str, str2, null, 4, null);
    }

    public static final String basic(String str, String str2, Charset charset) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "username");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "password");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "charset");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Basic ", ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str + ':' + str2, charset).base64());
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i, Object obj) {
        if ((i & 4) != 0) {
            charset = StandardCharsets.ISO_8859_1;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) charset, "ISO_8859_1");
        }
        return basic(str, str2, charset);
    }
}
