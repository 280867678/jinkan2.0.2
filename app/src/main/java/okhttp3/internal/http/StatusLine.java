package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import okhttp3.Protocol;
import okhttp3.Response;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.http.HttpVersions;

@ef0
/* loaded from: classes4.dex */
public final class StatusLine {
    public static final Companion Companion = new Companion(null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final StatusLine get(Response response) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String str) throws IOException {
            Protocol protocol;
            String str2;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "statusLine");
            int i = 9;
            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "HTTP/1.", false, 2)) {
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected status line: ", str));
                }
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else if (charAt != 1) {
                    throw new ProtocolException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected status line: ", str));
                } else {
                    protocol = Protocol.HTTP_1_1;
                }
            } else if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "ICY ", false, 2)) {
                throw new ProtocolException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected status line: ", str));
            } else {
                protocol = Protocol.HTTP_1_0;
                i = 4;
            }
            int i2 = i + 3;
            if (str.length() >= i2) {
                try {
                    String substring = str.substring(i, i2);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    int parseInt = Integer.parseInt(substring);
                    if (str.length() <= i2) {
                        str2 = "";
                    } else if (str.charAt(i2) != ' ') {
                        throw new ProtocolException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected status line: ", str));
                    } else {
                        str2 = str.substring(i + 4);
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str2, "(this as java.lang.String).substring(startIndex)");
                    }
                    return new StatusLine(protocol, parseInt, str2);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected status line: ", str));
                }
            }
            throw new ProtocolException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected status line: ", str));
        }
    }

    public StatusLine(Protocol protocol, int i, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(protocol, "protocol");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "message");
        this.protocol = protocol;
        this.code = i;
        this.message = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.protocol == Protocol.HTTP_1_0 ? HttpVersions.HTTP_1_0 : HttpVersions.HTTP_1_1);
        sb.append(TokenParser.f4579SP);
        sb.append(this.code);
        sb.append(TokenParser.f4579SP);
        sb.append(this.message);
        String sb2 = sb.toString();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
