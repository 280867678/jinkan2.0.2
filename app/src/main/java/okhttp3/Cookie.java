package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.collections.EmptyList;
import kotlin.text.Regex;
import me.tvspark.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
import me.tvspark.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.http.message.BasicHeaderValueParser;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.util.B64Code;
import org.fourthline.cling.model.Constants;

@ef0
/* loaded from: classes4.dex */
public final class Cookie {
    public final String domain;
    public final long expiresAt;
    public final boolean hostOnly;
    public final boolean httpOnly;
    public final String name;
    public final String path;
    public final boolean persistent;
    public final boolean secure;
    public final String value;
    public static final Companion Companion = new Companion(null);
    public static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    @ef0
    /* loaded from: classes4.dex */
    public static final class Builder {
        public String domain;
        public boolean hostOnly;
        public boolean httpOnly;
        public String name;
        public boolean persistent;
        public boolean secure;
        public String value;
        public long expiresAt = DatesKt.MAX_DATE;
        public String path = "/";

        private final Builder domain(String str, boolean z) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = z;
                return this;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected domain: ", str));
        }

        public final Cookie build() {
            String str = this.name;
            if (str != null) {
                String str2 = this.value;
                if (str2 == null) {
                    throw new NullPointerException("builder.value == null");
                }
                long j = this.expiresAt;
                String str3 = this.domain;
                if (str3 == null) {
                    throw new NullPointerException("builder.domain == null");
                }
                return new Cookie(str, str2, j, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
            }
            throw new NullPointerException("builder.name == null");
        }

        public final Builder domain(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "domain");
            return domain(str, false);
        }

        public final Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > DatesKt.MAX_DATE) {
                j = 253402300799999L;
            }
            this.expiresAt = j;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "domain");
            return domain(str, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).toString(), (Object) str)) {
                this.name = str;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        public final Builder path(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "path");
            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "/", false, 2)) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "value");
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).toString(), (Object) str)) {
                this.value = str;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed".toString());
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

        private final int dateCharacterOffset(String str, int i, int i2, boolean z) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || ('0' <= charAt && '9' >= charAt) || (('a' <= charAt && 'z' >= charAt) || (('A' <= charAt && 'Z' >= charAt) || charAt == ':'))) == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) str2)) {
                return true;
            }
            return nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, false, 2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.canParseAsIpAddress(str);
        }

        private final String parseDomain(String str) {
            if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".", false, 2)) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$removePrefix");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".", "prefix");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$startsWith");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".", "prefix");
                if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".", false, 2)) {
                    str = str.substring(".".length());
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "(this as java.lang.String).substring(startIndex)");
                }
                String canonicalHost = HostnamesKt.toCanonicalHost(str);
                if (canonicalHost == null) {
                    throw new IllegalArgumentException();
                }
                return canonicalHost;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseExpires(String str, int i, int i2) {
            int dateCharacterOffset = dateCharacterOffset(str, i, i2, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            while (dateCharacterOffset < i2) {
                int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i2, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i4 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    i4 = Integer.parseInt(matcher.group(1));
                    i7 = Integer.parseInt(matcher.group(2));
                    i8 = Integer.parseInt(matcher.group(3));
                } else if (i5 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    i5 = Integer.parseInt(matcher.group(1));
                } else if (i6 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group = matcher.group(1);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) group, "matcher.group(1)");
                    Locale locale = Locale.US;
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) locale, "Locale.US");
                    String lowerCase = group.toLowerCase(locale);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String pattern = Cookie.MONTH_PATTERN.pattern();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) pattern, "MONTH_PATTERN.pattern()");
                    i6 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) pattern, lowerCase, 0, false, 6) / 4;
                } else if (i3 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
                dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i2, false);
            }
            if (70 <= i3 && 99 >= i3) {
                i3 += Constants.UPNP_MULTICAST_PORT;
            }
            if (i3 >= 0 && 69 >= i3) {
                i3 += 2000;
            }
            if (i3 >= 1601) {
                if (!(i6 != -1)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (!(1 <= i5 && 31 >= i5)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (!(i4 >= 0 && 23 >= i4)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (!(i7 >= 0 && 59 >= i7)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (!(i8 >= 0 && 59 >= i8)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, i3);
                gregorianCalendar.set(2, i6 - 1);
                gregorianCalendar.set(5, i5);
                gregorianCalendar.set(11, i4);
                gregorianCalendar.set(12, i7);
                gregorianCalendar.set(13, i8);
                gregorianCalendar.set(14, 0);
                return gregorianCalendar.getTimeInMillis();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 0) {
                    return parseLong;
                }
                return Long.MIN_VALUE;
            } catch (NumberFormatException e) {
                if (!new Regex("-?\\d+").matches(str)) {
                    throw e;
                }
                return nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "-", false, 2) ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) encodedPath, (Object) str)) {
                return true;
            }
            return nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(encodedPath, str, false, 2) && (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "/", false, 2) || encodedPath.charAt(str.length()) == '/');
        }

        public final Cookie parse(HttpUrl httpUrl, String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        /* JADX WARN: Code restructure failed: missing block: B:88:0x0103, code lost:
            if (r1 > okhttp3.internal.http.DatesKt.MAX_DATE) goto L89;
         */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0115  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0118  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Cookie parse$okhttp(long j, HttpUrl httpUrl, String str) {
            long j2;
            String host;
            Cookie cookie;
            String str2;
            String str3;
            String str4;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            String str5;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "setCookie");
            int delimiterOffset$default = Util.delimiterOffset$default(str, (char) BasicHeaderValueParser.PARAM_DELIMITER, 0, 0, 6, (Object) null);
            int delimiterOffset$default2 = Util.delimiterOffset$default(str, (char) B64Code.__pad, 0, delimiterOffset$default, 2, (Object) null);
            if (delimiterOffset$default2 == delimiterOffset$default) {
                return null;
            }
            String trimSubstring$default = Util.trimSubstring$default(str, 0, delimiterOffset$default2, 1, null);
            if ((trimSubstring$default.length() == 0) || Util.indexOfControlOrNonAscii(trimSubstring$default) != -1) {
                return null;
            }
            String trimSubstring = Util.trimSubstring(str, delimiterOffset$default2 + 1, delimiterOffset$default);
            if (Util.indexOfControlOrNonAscii(trimSubstring) != -1) {
                return null;
            }
            int i = delimiterOffset$default + 1;
            int length = str.length();
            String str6 = null;
            String str7 = null;
            long j3 = -1;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = true;
            long j4 = DatesKt.MAX_DATE;
            while (i < length) {
                int delimiterOffset = Util.delimiterOffset(str, (char) BasicHeaderValueParser.PARAM_DELIMITER, i, length);
                int delimiterOffset2 = Util.delimiterOffset(str, (char) B64Code.__pad, i, delimiterOffset);
                String trimSubstring2 = Util.trimSubstring(str, i, delimiterOffset2);
                String trimSubstring3 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : "";
                if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trimSubstring2, "expires", true)) {
                    try {
                        j4 = parseExpires(trimSubstring3, 0, trimSubstring3.length());
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trimSubstring2, "max-age", true)) {
                    j3 = parseMaxAge(trimSubstring3);
                } else {
                    if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trimSubstring2, "domain", true)) {
                        str6 = parseDomain(trimSubstring3);
                        z4 = false;
                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trimSubstring2, "path", true)) {
                        str7 = trimSubstring3;
                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trimSubstring2, "secure", true)) {
                        z = true;
                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(trimSubstring2, "httponly", true)) {
                        z2 = true;
                    }
                    i = delimiterOffset + 1;
                }
                z3 = true;
                i = delimiterOffset + 1;
            }
            long j5 = Long.MIN_VALUE;
            if (j3 != Long.MIN_VALUE) {
                if (j3 != -1) {
                    j5 = j + (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE);
                    long j6 = j5 >= j ? DatesKt.MAX_DATE : DatesKt.MAX_DATE;
                    j2 = j6;
                } else {
                    j2 = j4;
                }
                host = httpUrl.host();
                if (str6 != null) {
                    str2 = host;
                    cookie = null;
                } else if (!domainMatch(host, str6)) {
                    return null;
                } else {
                    cookie = null;
                    str2 = str6;
                }
                if (host.length() == str2.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str2) == null) {
                    return cookie;
                }
                str3 = "/";
                str4 = str7;
                if (str4 != null || !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4, str3, false, 2)) {
                    String encodedPath = httpUrl.encodedPath();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(encodedPath, '/', 0, false, 6);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                        if (encodedPath == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        str3 = encodedPath.substring(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    str5 = str3;
                } else {
                    str5 = str4;
                }
                return new Cookie(trimSubstring$default, trimSubstring, j2, str2, str5, z, z2, z3, z4, null);
            }
            j2 = j5;
            host = httpUrl.host();
            if (str6 != null) {
            }
            if (host.length() == str2.length()) {
            }
            str3 = "/";
            str4 = str7;
            if (str4 != null) {
            }
            String encodedPath2 = httpUrl.encodedPath();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(encodedPath2, '/', 0, false, 6);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
            }
            str5 = str3;
            return new Cookie(trimSubstring$default, trimSubstring, j2, str2, str5, z, z2, z3, z4, null);
        }

        public final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, IOptionConstant.headers);
            List<String> values = headers.values(HttpHeaders.SET_COOKIE);
            int size = values.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                Cookie parse = parse(httpUrl, values.get(i));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList != null) {
                List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableList, "Collections.unmodifiableList(cookies)");
                return unmodifiableList;
            }
            return EmptyList.INSTANCE;
        }
    }

    public Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
    }

    public /* synthetic */ Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, gi0 gi0Var) {
        this(str, str2, j, str3, str4, z, z2, z3, z4);
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* renamed from: -deprecated_domain  reason: not valid java name */
    public final String m5006deprecated_domain() {
        return this.domain;
    }

    /* renamed from: -deprecated_expiresAt  reason: not valid java name */
    public final long m5007deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* renamed from: -deprecated_hostOnly  reason: not valid java name */
    public final boolean m5008deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* renamed from: -deprecated_httpOnly  reason: not valid java name */
    public final boolean m5009deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* renamed from: -deprecated_name  reason: not valid java name */
    public final String m5010deprecated_name() {
        return this.name;
    }

    /* renamed from: -deprecated_path  reason: not valid java name */
    public final String m5011deprecated_path() {
        return this.path;
    }

    /* renamed from: -deprecated_persistent  reason: not valid java name */
    public final boolean m5012deprecated_persistent() {
        return this.persistent;
    }

    /* renamed from: -deprecated_secure  reason: not valid java name */
    public final boolean m5013deprecated_secure() {
        return this.secure;
    }

    /* renamed from: -deprecated_value  reason: not valid java name */
    public final String m5014deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) cookie.name, (Object) this.name) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) cookie.value, (Object) this.value) && cookie.expiresAt == this.expiresAt && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) cookie.domain, (Object) this.domain) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) cookie.path, (Object) this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.value, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.name, 527, 31), 31);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.path, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.domain, (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.expiresAt) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31, 31), 31);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.httpOnly);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.persistent);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.hostOnly) + ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.secure) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) * 31)) * 31)) * 31);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl httpUrl) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
        if ((this.hostOnly ? ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) httpUrl.host(), (Object) this.domain) : Companion.domainMatch(httpUrl.host(), this.domain)) && Companion.pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z) {
        String httpDateString;
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(B64Code.__pad);
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                httpDateString = "; max-age=0";
            } else {
                sb.append("; expires=");
                httpDateString = DatesKt.toHttpDateString(new Date(this.expiresAt));
            }
            sb.append(httpDateString);
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) sb2, "toString()");
        return sb2;
    }

    public final String value() {
        return this.value;
    }
}
