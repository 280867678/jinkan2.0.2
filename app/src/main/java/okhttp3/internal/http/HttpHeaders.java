package okhttp3.internal.http;

import com.arialyy.aria.core.inf.IOptionConstant;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.uw0;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.ByteString;
import org.apache.http.message.BasicHeaderValueFormatter;

@ef0
/* loaded from: classes4.dex */
public final class HttpHeaders {
    public static final ByteString QUOTED_STRING_DELIMITERS = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BasicHeaderValueFormatter.UNSAFE_CHARS);
    public static final ByteString TOKEN_DELIMITERS = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\t ,=");

    public static final boolean hasBody(Response response) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, "$this$parseChallenges");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, headers.name(i), true)) {
                uw0 uw0Var = new uw0();
                uw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers.value(i));
                try {
                    readChallengeHeader(uw0Var, arrayList);
                } catch (EOFException e) {
                    Platform.Companion.get().log(5, "Unable to parse challenge", e);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "$this$promisesBody");
        if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) response.request().method(), (Object) "HEAD")) {
            return false;
        }
        int code = response.code();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && Util.headersContentLength(response) == -1 && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("chunked", Response.header$default(response, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0082, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void readChallengeHeader(uw0 uw0Var, List<Challenge> list) throws EOFException {
        String readToken;
        int skipAll;
        LinkedHashMap linkedHashMap;
        while (true) {
            String str = null;
            while (true) {
                if (str == null) {
                    skipCommasAndWhitespace(uw0Var);
                    str = readToken(uw0Var);
                    if (str == null) {
                        return;
                    }
                }
                boolean skipCommasAndWhitespace = skipCommasAndWhitespace(uw0Var);
                readToken = readToken(uw0Var);
                if (readToken == null) {
                    if (!uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        return;
                    }
                    list.add(new Challenge(str, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                    return;
                }
                byte b = (byte) 61;
                skipAll = Util.skipAll(uw0Var, b);
                boolean skipCommasAndWhitespace2 = skipCommasAndWhitespace(uw0Var);
                if (skipCommasAndWhitespace || (!skipCommasAndWhitespace2 && !uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                    linkedHashMap = new LinkedHashMap();
                    int skipAll2 = Util.skipAll(uw0Var, b) + skipAll;
                    while (true) {
                        if (readToken == null) {
                            readToken = readToken(uw0Var);
                            if (skipCommasAndWhitespace(uw0Var)) {
                                break;
                            }
                            skipAll2 = Util.skipAll(uw0Var, b);
                        }
                        if (skipAll2 == 0) {
                            break;
                        } else if (skipAll2 > 1 || skipCommasAndWhitespace(uw0Var)) {
                            return;
                        } else {
                            String readQuotedString = startsWith(uw0Var, (byte) 34) ? readQuotedString(uw0Var) : readToken(uw0Var);
                            if (readQuotedString == null || ((String) linkedHashMap.put(readToken, readQuotedString)) != null) {
                                return;
                            }
                            if (!skipCommasAndWhitespace(uw0Var) && !uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                return;
                            }
                            readToken = null;
                        }
                    }
                }
                list.add(new Challenge(str, linkedHashMap));
                str = readToken;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readToken);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("=", skipAll));
            Map singletonMap = Collections.singletonMap(null, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) singletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
            list.add(new Challenge(str, singletonMap));
        }
    }

    public static final String readQuotedString(uw0 uw0Var) throws EOFException {
        byte b = (byte) 34;
        if (uw0Var.readByte() == b) {
            uw0 uw0Var2 = new uw0();
            while (true) {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(QUOTED_STRING_DELIMITERS);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                    return null;
                }
                if (uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == b) {
                    uw0Var2.write(uw0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    uw0Var.readByte();
                    return uw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                } else if (uw0Var.Wwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1) {
                    return null;
                } else {
                    uw0Var2.write(uw0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    uw0Var.readByte();
                    uw0Var2.write(uw0Var, 1L);
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public static final String readToken(uw0 uw0Var) {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TOKEN_DELIMITERS);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uw0Var.Wwwwwwwwwwwwwwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
            return uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cookieJar, "$this$receiveHeaders");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, IOptionConstant.headers);
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.Companion.parseAll(httpUrl, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, parseAll);
    }

    public static final boolean skipCommasAndWhitespace(uw0 uw0Var) {
        boolean z = false;
        while (!uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            byte Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 9 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 32) {
                uw0Var.readByte();
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 44) {
                break;
            } else {
                uw0Var.readByte();
                z = true;
            }
        }
        return z;
    }

    public static final boolean startsWith(uw0 uw0Var, byte b) {
        return !uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L) == b;
    }
}
