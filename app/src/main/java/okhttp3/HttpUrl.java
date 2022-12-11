package okhttp3;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.text.Regex;
import me.tvspark.ef0;
import me.tvspark.fj0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import me.tvspark.uw0;
import me.tvspark.zi0;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.eclipse.jetty.util.B64Code;
import org.eclipse.jetty.util.URIUtil;
import org.slf4j.Marker;

@ef0
/* loaded from: classes4.dex */
public final class HttpUrl {
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public final String fragment;
    public final String host;
    public final boolean isHttps;
    public final String password;
    public final List<String> pathSegments;
    public final int port;
    public final List<String> queryNamesAndValues;
    public final String scheme;
    public final String url;
    public final String username;
    public static final Companion Companion = new Companion(null);
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    @ef0
    /* loaded from: classes4.dex */
    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        public static final String INVALID_HOST = "Invalid URL host";
        public String encodedFragment;
        public final List<String> encodedPathSegments;
        public List<String> encodedQueryNamesAndValues;
        public String host;
        public String scheme;
        public String encodedUsername = "";
        public String encodedPassword = "";
        public int port = -1;

        @ef0
        /* loaded from: classes4.dex */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(gi0 gi0Var) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String str, int i, int i2) {
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i, i2, "", false, false, false, false, null, 248, null));
                    if (1 > parseInt || 65535 < parseInt) {
                        return -1;
                    }
                    return parseInt;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String str, int i, int i2) {
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt == ':') {
                        return i;
                    }
                    if (charAt == '[') {
                        do {
                            i++;
                            if (i < i2) {
                            }
                        } while (str.charAt(i) != ']');
                    }
                    i++;
                }
                return i2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i, int i2) {
                if (i2 - i < 2) {
                    return -1;
                }
                char charAt = str.charAt(i);
                if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                    return -1;
                }
                while (true) {
                    i++;
                    if (i >= i2) {
                        return -1;
                    }
                    char charAt2 = str.charAt(i);
                    if ('a' > charAt2 || 'z' < charAt2) {
                        if ('A' > charAt2 || 'Z' < charAt2) {
                            if ('0' > charAt2 || '9' < charAt2) {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 != ':') {
                                        return -1;
                                    }
                                    return i;
                                }
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i, int i2) {
                int i3 = 0;
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final Builder addPathSegments(String str, boolean z) {
            int i = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, "/\\", i, str.length());
                push(str, i, delimiterOffset, delimiterOffset < str.length(), z);
                i = delimiterOffset + 1;
            } while (i <= str.length());
            return this;
        }

        private final int effectivePort() {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            if (str != null) {
                return companion.defaultPort(str);
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }

        private final boolean isDot(String str) {
            return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) ".") || nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "%2e", true);
        }

        private final boolean isDotDot(String str) {
            return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "..") || nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "%2e.", true) || nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".%2e", true) || nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "%2e%2e", true);
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if (!(list.remove(list.size() - 1).length() == 0) || !(!this.encodedPathSegments.isEmpty())) {
                this.encodedPathSegments.add("");
                return;
            }
            List<String> list2 = this.encodedPathSegments;
            list2.set(list2.size() - 1, "");
        }

        private final void push(String str, int i, int i2, boolean z, boolean z2) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i, i2, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, false, null, TbsListener.ErrorCode.TPATCH_VERSION_FAILED, null);
            if (isDot(canonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(canonicalize$okhttp$default)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() + (-1)).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, canonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(canonicalize$okhttp$default);
            }
            if (!z) {
                return;
            }
            this.encodedPathSegments.add("");
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            if (list == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            zi0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list.size() - 2, 0), 2);
            int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
            if (i3 >= 0) {
                if (i > i2) {
                    return;
                }
            } else if (i < i2) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                if (list2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) list2.get(i))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    if (list3 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    list3.remove(i + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    if (list4 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    list4.remove(i);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    if (list5 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    } else if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (i == i2) {
                    return;
                }
                i += i3;
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:9:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void resolvePath(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = okhttp3.internal.Util.delimiterOffset(r11, r12, r6, r13)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.push(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.resolvePath(java.lang.String, int, int):void");
        }

        public final Builder addEncodedPathSegment(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "encodedPathSegment");
            push(str, 0, str.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "encodedPathSegments");
            return addPathSegments(str, true);
        }

        public final Builder addEncodedQueryParameter(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            String str3 = null;
            if (list == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            list.add(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            if (str2 != null) {
                str3 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null);
            }
            list2.add(str3);
            return this;
        }

        public final Builder addPathSegment(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "pathSegment");
            push(str, 0, str.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "pathSegments");
            return addPathSegments(str, false);
        }

        public final Builder addQueryParameter(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            String str3 = null;
            if (list == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            list.add(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, TbsListener.ErrorCode.RENAME_EXCEPTION, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            if (str2 != null) {
                str3 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, TbsListener.ErrorCode.RENAME_EXCEPTION, null);
            }
            list2.add(str3);
            return this;
        }

        public final HttpUrl build() {
            String str = this.scheme;
            if (str != null) {
                String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedUsername, 0, 0, false, 7, null);
                String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedPassword, 0, 0, false, 7, null);
                String str2 = this.host;
                if (str2 == null) {
                    throw new IllegalStateException("host == null");
                }
                int effectivePort = effectivePort();
                List percentDecode$default = Companion.percentDecode$default(HttpUrl.Companion, this.encodedPathSegments, false, 1, null);
                if (percentDecode$default == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                }
                List<String> list = this.encodedQueryNamesAndValues;
                List percentDecode = list != null ? HttpUrl.Companion.percentDecode(list, true) : null;
                String str3 = this.encodedFragment;
                return new HttpUrl(str, percentDecode$okhttp$default, percentDecode$okhttp$default2, str2, effectivePort, percentDecode$default, percentDecode, str3 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, false, 7, null) : null, toString());
            }
            throw new IllegalStateException("scheme == null");
        }

        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, null, 179, null) : null;
            return this;
        }

        public final Builder encodedPassword(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, TbsListener.ErrorCode.DOWNLOAD_FAILED_FOR_PREINIT_CALLBACK, null);
            return this;
        }

        public final Builder encodedPath(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "encodedPath");
            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "/", false, 2)) {
                resolvePath(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected encodedPath: ", str).toString());
        }

        public final Builder encodedQuery(String str) {
            String canonicalize$okhttp$default;
            this.encodedQueryNamesAndValues = (str == null || (canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null)) == null) ? null : HttpUrl.Companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
            return this;
        }

        public final Builder encodedUsername(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, TbsListener.ErrorCode.DOWNLOAD_FAILED_FOR_PREINIT_CALLBACK, null);
            return this;
        }

        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, null, 187, null) : null;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Http2ExchangeCodec.HOST);
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, 0, 0, false, 7, null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected host: ", str));
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            int delimiterOffset;
            int i;
            String str2;
            int i2;
            int i3;
            String str3;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "input");
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(str, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(str, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            int schemeDelimiterOffset = Companion.schemeDelimiterOffset(str, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            String str4 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            char c = 65535;
            if (schemeDelimiterOffset != -1) {
                if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, URIUtil.HTTPS_COLON, indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, URIUtil.HTTP_COLON, indexOfFirstNonAsciiWhitespace$default, true)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected URL scheme 'http' or 'https' but was '");
                    String substring = str.substring(0, schemeDelimiterOffset);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, str4);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(substring);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
                    throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                } else {
                    this.scheme = "http";
                    indexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else if (httpUrl == null) {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            } else {
                this.scheme = httpUrl.scheme();
            }
            int slashCount = Companion.slashCount(str, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c2 = '?';
            char c3 = '#';
            if (slashCount >= 2 || httpUrl == null || (!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) httpUrl.scheme(), (Object) this.scheme))) {
                int i4 = indexOfFirstNonAsciiWhitespace$default + slashCount;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(str, "@/\\?#", i4, indexOfLastNonAsciiWhitespace$default);
                    char charAt = delimiterOffset != indexOfLastNonAsciiWhitespace$default ? str.charAt(delimiterOffset) : (char) 65535;
                    if (charAt == c || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    }
                    if (charAt != '@') {
                        i2 = indexOfLastNonAsciiWhitespace$default;
                        str3 = str4;
                    } else {
                        if (!z) {
                            int delimiterOffset2 = Util.delimiterOffset(str, ':', i4, delimiterOffset);
                            i2 = indexOfLastNonAsciiWhitespace$default;
                            i3 = delimiterOffset;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i4, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, TbsListener.ErrorCode.TPATCH_VERSION_FAILED, null);
                            if (z2) {
                                canonicalize$okhttp$default = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.encodedUsername, "%40", canonicalize$okhttp$default);
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            if (delimiterOffset2 != i3) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, delimiterOffset2 + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, TbsListener.ErrorCode.TPATCH_VERSION_FAILED, null);
                                z = true;
                            }
                            z2 = true;
                            str3 = str4;
                        } else {
                            i2 = indexOfLastNonAsciiWhitespace$default;
                            i3 = delimiterOffset;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.encodedPassword);
                            sb.append("%40");
                            str3 = str4;
                            sb.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i4, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, TbsListener.ErrorCode.TPATCH_VERSION_FAILED, null));
                            this.encodedPassword = sb.toString();
                        }
                        i4 = i3 + 1;
                    }
                    c3 = '#';
                    c2 = '?';
                    c = 65535;
                    indexOfLastNonAsciiWhitespace$default = i2;
                    str4 = str3;
                }
                i = indexOfLastNonAsciiWhitespace$default;
                String str5 = str4;
                int portColonOffset = Companion.portColonOffset(str, i4, delimiterOffset);
                int i5 = portColonOffset + 1;
                if (i5 < delimiterOffset) {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, i4, portColonOffset, false, 4, null));
                    int parsePort = Companion.parsePort(str, i5, delimiterOffset);
                    this.port = parsePort;
                    if (!(parsePort != -1)) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid URL port: \"");
                        String substring2 = str.substring(i5, delimiterOffset);
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring2, str5);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(substring2);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append('\"');
                        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString().toString());
                    }
                    str2 = str5;
                } else {
                    str2 = str5;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, i4, portColonOffset, false, 4, null));
                    Companion companion = HttpUrl.Companion;
                    String str6 = this.scheme;
                    if (str6 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    this.port = companion.defaultPort(str6);
                }
                if (!(this.host != null)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid URL host: \"");
                    String substring3 = str.substring(i4, portColonOffset);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring3, str2);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(substring3);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append('\"');
                    throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString().toString());
                }
                indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || str.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i = indexOfLastNonAsciiWhitespace$default;
            }
            int i6 = i;
            int delimiterOffset3 = Util.delimiterOffset(str, "?#", indexOfFirstNonAsciiWhitespace$default, i6);
            resolvePath(str, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 < i6 && str.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(str, '#', delimiterOffset3, i6);
                Companion companion2 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion2.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion2, str, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i6 && str.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, delimiterOffset3 + 1, i6, "", true, false, false, true, null, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, null);
            }
            return this;
        }

        public final Builder password(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, null);
            return this;
        }

        public final Builder port(int i) {
            boolean z = true;
            if (1 > i || 65535 < i) {
                z = false;
            }
            if (z) {
                this.port = i;
                return this;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected port: ", i).toString());
        }

        public final Builder query(String str) {
            String canonicalize$okhttp$default;
            this.encodedQueryNamesAndValues = (str == null || (canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, TbsListener.ErrorCode.RENAME_EXCEPTION, null)) == null) ? null : HttpUrl.Companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            int size = this.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                List<String> list = this.encodedPathSegments;
                list.set(i, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            String str = null;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str2 = list2.get(i2);
                    list2.set(i2, str2 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            if (str3 != null) {
                str = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str3, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null);
            }
            this.encodedFragment = str;
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        public final Builder removeAllQueryParameters(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, TbsListener.ErrorCode.RENAME_EXCEPTION, null));
            return this;
        }

        public final Builder removePathSegment(int i) {
            this.encodedPathSegments.remove(i);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder scheme(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "scheme");
            String str2 = "http";
            if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, true)) {
                str2 = "https";
                if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, true)) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected scheme: ", str));
                }
            }
            this.scheme = str2;
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i, String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "encodedPathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, TbsListener.ErrorCode.DOWNLOAD_FAILED_FOR_PREINIT_CALLBACK, null);
            this.encodedPathSegments.set(i, canonicalize$okhttp$default);
            if (!isDot(canonicalize$okhttp$default) && !isDotDot(canonicalize$okhttp$default)) {
                return this;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected path segment: ", str).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "encodedName");
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i, String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "pathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, null);
            if (!isDot(canonicalize$okhttp$default) && !isDotDot(canonicalize$okhttp$default)) {
                this.encodedPathSegments.set(i, canonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected path segment: ", str).toString());
        }

        public final void setPort$okhttp(int i) {
            this.port = i;
        }

        public final Builder setQueryParameter(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
            if ((r6.encodedPassword.length() > 0) != false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0091, code lost:
            if (r1 != r5.defaultPort(r3)) goto L47;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            String str2 = this.scheme;
            if (str2 != null) {
                sb.append(str2);
                str = "://";
            } else {
                str = "//";
            }
            sb.append(str);
            boolean z = true;
            if (!(this.encodedUsername.length() > 0)) {
            }
            sb.append(this.encodedUsername);
            if (this.encodedPassword.length() <= 0) {
                z = false;
            }
            if (z) {
                sb.append(':');
                sb.append(this.encodedPassword);
            }
            sb.append('@');
            String str3 = this.host;
            if (str3 != null) {
                if (str3 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str3, ':', false, 2)) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int effectivePort = effectivePort();
                String str4 = this.scheme;
                if (str4 != null) {
                    Companion companion = HttpUrl.Companion;
                    if (str4 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                }
                sb.append(':');
                sb.append(effectivePort);
            }
            HttpUrl.Companion.toPathString$okhttp(this.encodedPathSegments, sb);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                Companion companion2 = HttpUrl.Companion;
                List<String> list = this.encodedQueryNamesAndValues;
                if (list == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                companion2.toQueryString$okhttp(list, sb);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            String sb2 = sb.toString();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }

        public final Builder username(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, null);
            return this;
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

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            return companion.canonicalize$okhttp(str, (i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? str.length() : i2, str2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? false : z3, (i3 & 64) != 0 ? false : z4, (i3 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && Util.parseHexDigit(str.charAt(i + 1)) != -1 && Util.parseHexDigit(str.charAt(i3)) != -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<String> percentDecode(List<String> list, boolean z) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                arrayList.add(next != null ? percentDecode$okhttp$default(this, next, 0, 0, z, 3, null) : null);
            }
            List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableList, "Collections.unmodifiableList(result)");
            return unmodifiableList;
        }

        public static /* synthetic */ List percentDecode$default(Companion companion, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.percentDecode(list, z);
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return companion.percentDecode$okhttp(str, i, i2, z);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
            if (isPercentEncoded(r15, r4, r17) == false) goto L40;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void writeCanonicalized(uw0 uw0Var, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
            uw0 uw0Var2 = null;
            int i3 = i;
            while (i3 < i2) {
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                int codePointAt = str.codePointAt(i3);
                if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                    if (codePointAt != 43 || !z3) {
                        if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z4)) {
                            if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str2, (char) codePointAt, false, 2)) {
                                if (codePointAt == 37) {
                                    if (z) {
                                        if (z2) {
                                        }
                                    }
                                }
                                uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(codePointAt);
                                i3 += Character.charCount(codePointAt);
                            }
                        }
                        if (uw0Var2 == null) {
                            uw0Var2 = new uw0();
                        }
                        if (charset == null || ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, StandardCharsets.UTF_8)) {
                            uw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(codePointAt);
                        } else {
                            uw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, i3, Character.charCount(codePointAt) + i3, charset);
                        }
                        while (!uw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            int readByte = uw0Var2.readByte() & 255;
                            uw0Var.mo4963writeByte(37);
                            uw0Var.mo4963writeByte((int) HttpUrl.HEX_DIGITS[(readByte >> 4) & 15]);
                            uw0Var.mo4963writeByte((int) HttpUrl.HEX_DIGITS[readByte & 15]);
                        }
                        i3 += Character.charCount(codePointAt);
                    } else {
                        uw0Var.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                    }
                }
                i3 += Character.charCount(codePointAt);
            }
        }

        private final void writePercentDecoded(uw0 uw0Var, String str, int i, int i2, boolean z) {
            int i3;
            while (i < i2) {
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                int codePointAt = str.codePointAt(i);
                if (codePointAt != 37 || (i3 = i + 2) >= i2) {
                    if (codePointAt == 43 && z) {
                        uw0Var.mo4963writeByte(32);
                        i++;
                    }
                    uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(codePointAt);
                    i += Character.charCount(codePointAt);
                } else {
                    int parseHexDigit = Util.parseHexDigit(str.charAt(i + 1));
                    int parseHexDigit2 = Util.parseHexDigit(str.charAt(i3));
                    if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                        uw0Var.mo4963writeByte((parseHexDigit << 4) + parseHexDigit2);
                        i = Character.charCount(codePointAt) + i3;
                    }
                    uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(codePointAt);
                    i += Character.charCount(codePointAt);
                }
            }
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m5046deprecated_get(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "url");
            return get(str);
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m5047deprecated_get(URI uri) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, "uri");
            return get(uri);
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m5048deprecated_get(URL url) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(url, "url");
            return get(url);
        }

        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final HttpUrl m5049deprecated_parse(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "url");
            return parse(str);
        }

        public final String canonicalize$okhttp(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$canonicalize");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "encodeSet");
            int i3 = i;
            while (i3 < i2) {
                int codePointAt = str.codePointAt(i3);
                if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || z4) && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str2, (char) codePointAt, false, 2))) {
                    if (codePointAt == 37) {
                        if (z) {
                            if (z2) {
                                if (!isPercentEncoded(str, i3, i2)) {
                                    uw0 uw0Var = new uw0();
                                    uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, i, i3);
                                    writeCanonicalized(uw0Var, str, i3, i2, str2, z, z2, z3, z4, charset);
                                    return uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                                }
                                if (codePointAt != 43 && z3) {
                                    uw0 uw0Var2 = new uw0();
                                    uw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, i, i3);
                                    writeCanonicalized(uw0Var2, str, i3, i2, str2, z, z2, z3, z4, charset);
                                    return uw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                                }
                                i3 += Character.charCount(codePointAt);
                            }
                        }
                    }
                    if (codePointAt != 43) {
                    }
                    i3 += Character.charCount(codePointAt);
                }
                uw0 uw0Var22 = new uw0();
                uw0Var22.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, i, i3);
                writeCanonicalized(uw0Var22, str, i3, i2, str2, z, z2, z3, z4, charset);
                return uw0Var22.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            String substring = str.substring(i, i2);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final int defaultPort(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "scheme");
            int hashCode = str.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && str.equals("https")) {
                    return 443;
                }
            } else if (str.equals("http")) {
                return 80;
            }
            return -1;
        }

        public final HttpUrl get(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$toHttpUrl");
            return new Builder().parse$okhttp(null, str).build();
        }

        public final HttpUrl get(URI uri) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, "$this$toHttpUrlOrNull");
            String uri2 = uri.toString();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) uri2, "toString()");
            return parse(uri2);
        }

        public final HttpUrl get(URL url) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(url, "$this$toHttpUrlOrNull");
            String url2 = url.toString();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) url2, "toString()");
            return parse(url2);
        }

        public final HttpUrl parse(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$toHttpUrlOrNull");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String str, int i, int i2, boolean z) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$percentDecode");
            for (int i3 = i; i3 < i2; i3++) {
                char charAt = str.charAt(i3);
                if (charAt == '%' || (charAt == '+' && z)) {
                    uw0 uw0Var = new uw0();
                    uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, i, i3);
                    writePercentDecoded(uw0Var, str, i3, i2, z);
                    return uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
            String substring = str.substring(i, i2);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final void toPathString$okhttp(List<String> list, StringBuilder sb) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "$this$toPathString");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "out");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append('/');
                sb.append(list.get(i));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String str) {
            String str2;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, '&', i, false, 4);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str.length();
                }
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, (char) B64Code.__pad, i, false, 4);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    String substring = str.substring(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    str2 = null;
                } else {
                    String substring2 = str.substring(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    str2 = str.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                arrayList.add(str2);
                i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> list, StringBuilder sb) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "$this$toQueryString");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "out");
            zi0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, list.size()), 2);
            int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
            if (i3 >= 0) {
                if (i > i2) {
                    return;
                }
            } else if (i < i2) {
                return;
            }
            while (true) {
                String str = list.get(i);
                String str2 = list.get(i + 1);
                if (i > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append(B64Code.__pad);
                    sb.append(str2);
                }
                if (i != i2) {
                    i += i3;
                } else {
                    return;
                }
            }
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i, List<String> list, List<String> list2, String str5, String str6) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "scheme");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "username");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, "password");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4, Http2ExchangeCodec.HOST);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "pathSegments");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str6, "url");
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
        this.isHttps = ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "https");
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_encodedFragment  reason: not valid java name */
    public final String m5027deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* renamed from: -deprecated_encodedPassword  reason: not valid java name */
    public final String m5028deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* renamed from: -deprecated_encodedPath  reason: not valid java name */
    public final String m5029deprecated_encodedPath() {
        return encodedPath();
    }

    /* renamed from: -deprecated_encodedPathSegments  reason: not valid java name */
    public final List<String> m5030deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* renamed from: -deprecated_encodedQuery  reason: not valid java name */
    public final String m5031deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* renamed from: -deprecated_encodedUsername  reason: not valid java name */
    public final String m5032deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* renamed from: -deprecated_fragment  reason: not valid java name */
    public final String m5033deprecated_fragment() {
        return this.fragment;
    }

    /* renamed from: -deprecated_host  reason: not valid java name */
    public final String m5034deprecated_host() {
        return this.host;
    }

    /* renamed from: -deprecated_password  reason: not valid java name */
    public final String m5035deprecated_password() {
        return this.password;
    }

    /* renamed from: -deprecated_pathSegments  reason: not valid java name */
    public final List<String> m5036deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* renamed from: -deprecated_pathSize  reason: not valid java name */
    public final int m5037deprecated_pathSize() {
        return pathSize();
    }

    /* renamed from: -deprecated_port  reason: not valid java name */
    public final int m5038deprecated_port() {
        return this.port;
    }

    /* renamed from: -deprecated_query  reason: not valid java name */
    public final String m5039deprecated_query() {
        return query();
    }

    /* renamed from: -deprecated_queryParameterNames  reason: not valid java name */
    public final Set<String> m5040deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* renamed from: -deprecated_querySize  reason: not valid java name */
    public final int m5041deprecated_querySize() {
        return querySize();
    }

    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m5042deprecated_scheme() {
        return this.scheme;
    }

    /* renamed from: -deprecated_uri  reason: not valid java name */
    public final URI m5043deprecated_uri() {
        return uri();
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final URL m5044deprecated_url() {
        return url();
    }

    /* renamed from: -deprecated_username  reason: not valid java name */
    public final String m5045deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) this.url, '#', 0, false, 6) + 1;
        String str = this.url;
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) this.url, ':', this.scheme.length() + 3, false, 4) + 1;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) this.url, '@', 0, false, 6);
        String str = this.url;
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedPath() {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str.length());
        String str2 = this.url;
        if (str2 != null) {
            String substring = str2.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, delimiterOffset);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final List<String> encodedPathSegments() {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str.length());
        ArrayList arrayList = new ArrayList();
        while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < delimiterOffset) {
            int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, '/', i, delimiterOffset);
            String str2 = this.url;
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = str2.substring(i, delimiterOffset2);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(substring);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = delimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) this.url, '?', 0, false, 6) + 1;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, '#', Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str2.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, delimiterOffset);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, ":@", length, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str2.substring(length, delimiterOffset);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) ((HttpUrl) obj).url, (Object) this.url);
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final Builder newBuilder(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "link");
        try {
            return new Builder().parse$okhttp(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final String queryParameter(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        zi0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, list.size()), 2);
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        if (i3 < 0 ? i >= i2 : i <= i2) {
            while (!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) this.queryNamesAndValues.get(i))) {
                if (i != i2) {
                    i += i3;
                }
            }
            return this.queryNamesAndValues.get(i + 1);
        }
        return null;
    }

    public final String queryParameterName(int i) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            String str = list.get(i * 2);
            if (str != null) {
                return str;
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        throw new IndexOutOfBoundsException();
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return EmptySet.INSTANCE;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        zi0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, this.queryNamesAndValues.size()), 2);
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        if (i3 < 0 ? i >= i2 : i <= i2) {
            while (true) {
                String str = this.queryNamesAndValues.get(i);
                if (str == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                linkedHashSet.add(str);
                if (i == i2) {
                    break;
                }
                i += i3;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final String queryParameterValue(int i) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        if (this.queryNamesAndValues == null) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        zi0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, this.queryNamesAndValues.size()), 2);
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        if (i3 < 0 ? i >= i2 : i <= i2) {
            while (true) {
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) this.queryNamesAndValues.get(i))) {
                    arrayList.add(this.queryNamesAndValues.get(i + 1));
                }
                if (i == i2) {
                    break;
                }
                i += i3;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        if (newBuilder != null) {
            return newBuilder.username("").password("").build().toString();
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    public final HttpUrl resolve(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "link");
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(builder, ""));
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) create, "URI.create(stripped)");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public final String username() {
        return this.username;
    }
}
